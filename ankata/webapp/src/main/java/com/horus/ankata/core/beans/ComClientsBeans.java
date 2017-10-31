/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.beans;

import com.horus.ankata.core.domain.commons.ComClients;
import com.horus.ankata.core.service.AdminSrv;
 import com.horus.ankata.web.utils.JsfUtil;
import com.horus.ankata.web.utils.Messages;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SelectableDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author babacar
 */
@Component("clientBean")
@Scope("session")
public class ComClientsBeans {
  @Autowired
    private AdminSrv adminSrv;

    private ComClients item;
    private List<ComClients > items;
    private ComClients[] selectedItems;
    private ComClientsDataModel itemsModel;
    private String action;
  
    @PostConstruct
    public void init(){
        
    }

  
}
class ComClientsDataModel extends LazyDataModel<ComClients> implements SelectableDataModel<ComClients>{
   private List<ComClients> datasource;

    public ComClientsDataModel() {
    }

    ComClientsDataModel(List<ComClients> items) {
        this.datasource = datasource;
    }

    @Override
    public Object getRowKey(ComClients o) {
        return o.getId();
    }

    @Override
    public ComClients getRowData(String rowKey) {
        for (ComClients o : datasource) {
            if (o.getId() == (Integer.parseInt(rowKey))) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<ComClients> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<ComClients> data = new ArrayList<ComClients>();

        //filter  
        for (ComClients o : datasource) {
            boolean match = true;

            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = (String) filters.get(filterProperty);

                    if (filterProperty.equals("globalFilter")) {
                        if (filterValue == null || o.getComPersonnes().getNomComplet().toLowerCase().contains(filterValue.toLowerCase())) {
                            match = true;
                        } else {
                            match = false;
                            break;
                        }
                    } else {
                        match = true;
                    }

                } catch (Throwable th) {
                    JsfUtil.displayError(th);
                    match = false;
                }
            }

            if (match) {
                data.add(o);
            }
        }

        //sort  
        if (sortField != null) {
            Collections.sort(data, new ComClientsLazySorter(sortField, sortOrder));
        }

        //rowCount  
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate  
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }
    }

}

class ComClientsLazySorter implements Comparator<ComClients> {

    private String sortField;

    private SortOrder sortOrder;

    public ComClientsLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public int compare(ComClients o1, ComClients o2) {
        try {
            Class clazz1 = o1.getClass();
            Class clazz2 = o2.getClass();

            Field field1 = clazz1.getDeclaredField(this.sortField);
            Field field2 = clazz2.getDeclaredField(this.sortField);

            field1.setAccessible(true);
            field2.setAccessible(true);

            Object value1 = (Object) field1.get(o1);
            Object value2 = (Object) field1.get(o2);

            int value = ((Comparable) value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (Throwable th) {
            JsfUtil.displayError(th);
            throw new RuntimeException();
        }
    }
}
