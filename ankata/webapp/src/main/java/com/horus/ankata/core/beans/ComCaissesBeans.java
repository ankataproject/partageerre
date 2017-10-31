/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.beans;

import com.horus.ankata.core.domain.commons.ComCaisses;
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
@Component("caisseBean")
@Scope("session")
public class ComCaissesBeans {
  @Autowired
    private AdminSrv adminSrv;

    private ComCaisses item;
    private List<ComCaisses > items;
    private ComCaisses[] selectedItems;
    private ComCaissesDataModel itemsModel;
    private String action;
  
    @PostConstruct
    public void init(){
        loadList() ;
    }

    private void loadList() {
        try{
            items = adminSrv.getGenDao().findHqlAll(ComCaisses.class.getName(), "ORDER BY code");
            itemsModel = new ComCaissesDataModel(items);
        }catch(Throwable th){
            JsfUtil.displayError(th);
            return;
        }
    }
    
     public void valideCode(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String svalue = (String) value;
        item.setCode(svalue);

        if (item.getCode() != null) {
            int size = 0;
            long idd = -1;

            if (item != null && item.getId() != null) {
                idd = item.getId();
            }

            List<ComCaisses> listes = adminSrv.getGenDao().findHqlAll(ComCaisses.class.getName(), "WHERE code='" + item.getCode() + "'and libelle='" + item.getLibelle() + "'and id!='" + idd);

            if (listes != null) {
                size = listes.size();
            }
            if (size > 0) {
                Object[] messageArgements = {Messages.getString("label.libelle"), item.getLibelle()};
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, Messages.getString("error.doublon", messageArgements), ""));
            }
        }
    }

    /*-----------------Methode Metier------------*/
    public void saveOrUpdate() {
        try {
            if (item.getId() == null) {
                adminSrv.getGenDao().save(item);
                JsfUtil.addSuccessMessage(Messages.getString("msg.create.success", "label.structure"));
            } else {
                adminSrv.getGenDao().update(item);
                JsfUtil.addSuccessMessage(Messages.getString("msg.update.success", "label.structure"));
            }
        } catch (Throwable th) {
            JsfUtil.addErrorMessage(Messages.getString("error.persistence"));
            JsfUtil.displayError(th);
        }
    }

    private void delete() {
        try {
            adminSrv.getGenDao().delete(item);
            JsfUtil.addSuccessMessage(Messages.getString("msg.delete.success", "label.structure"));
            //hb.loadMenu();
        } catch (Throwable th) {
            JsfUtil.addErrorMessage(Messages.getString("error.delete.one", "label.rapport", "label.structure"));
            // JsfUtil.displayError(th);
        }
    }

    private void deleteAll() {
        try {
            adminSrv.getGenDao().deleteHqlAll(ComCaisses.class.getName(), getSelectedItemsIds());
            JsfUtil.addSuccessMessage(Messages.getString("msg.delete.success", "label.structure"));
            //hb.loadMenu();
        } catch (Throwable th) {
            JsfUtil.addErrorMessage(Messages.getString("error.delete.all", "label.rapport", "label.structure"));
            //JsfUtil.displayError(th);
        }

    }

    private List<Long> getSelectedItemsIds() {
        List<Long> l = new ArrayList<Long>();
        if (selectedItems != null && selectedItems.length > 0) {
            for (int i = 0; i < selectedItems.length; i++) {
                l.add(selectedItems[i].getId());
            }
        }
        return l;
    }

    ///////Menu--------------------------
    public void action() {
        if (action.equals("save")) {
            saveOrUpdate();
        }

        if (action.equals("delete")) {
            delete();
        }

        if (action.equals("deleteAll")) {
            if (selectedItems != null && selectedItems.length > 0) {
                deleteAll();
            }
        }

        if (action.equals("new")) {
            nouveau();
        }
        if (action.equals("edit")) {
            getCurrent();
        }
        if (action.equals("editAll")) {
            getFirst();
        }
    }
    
    private void getFirst() {
        if (selectedItems != null && selectedItems.length > 0) {
            item = selectedItems[0];
        }
    }

    private void getCurrent() {
        if (item != null) {

        }
    }

    public void nouveau() {
        item = new ComCaisses();
    }

    public ComCaisses getItem() {
        return item;
    }

    public void setItem(ComCaisses item) {
        this.item = item;
    }

    public List<ComCaisses> getItems() {
        return items;
    }

    public void setItems(List<ComCaisses> items) {
        this.items = items;
    }

    public ComCaisses[] getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(ComCaisses[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    public ComCaissesDataModel getItemsModel() {
        return itemsModel;
    }

    public void setItemsModel(ComCaissesDataModel itemsModel) {
        this.itemsModel = itemsModel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
}
class ComCaissesDataModel extends LazyDataModel<ComCaisses> implements SelectableDataModel<ComCaisses>{
   private List<ComCaisses> datasource;

    public ComCaissesDataModel() {
    }

    ComCaissesDataModel(List<ComCaisses> items) {
        this.datasource = datasource;
    }

    @Override
    public Object getRowKey(ComCaisses o) {
        return o.getId();
    }

    @Override
    public ComCaisses getRowData(String rowKey) {
        for (ComCaisses o : datasource) {
            if (o.getId() == (Integer.parseInt(rowKey))) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<ComCaisses> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<ComCaisses> data = new ArrayList<ComCaisses>();

        //filter  
        for (ComCaisses o : datasource) {
            boolean match = true;

            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = (String) filters.get(filterProperty);

                    if (filterProperty.equals("globalFilter")) {
                        if (filterValue == null || o.getLibelle().toLowerCase().contains(filterValue.toLowerCase())) {
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
            Collections.sort(data, new ComCaissesLazySorter(sortField, sortOrder));
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

class ComCaissesLazySorter implements Comparator<ComCaisses> {

    private String sortField;

    private SortOrder sortOrder;

    public ComCaissesLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public int compare(ComCaisses o1, ComCaisses o2) {
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
