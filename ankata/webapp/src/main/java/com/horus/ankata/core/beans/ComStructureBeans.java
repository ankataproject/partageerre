/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.beans;

import com.horus.ankata.core.domain.commons.ComStructures;
import com.horus.ankata.core.service.AdminSrv;
 import com.horus.ankata.web.utils.JsfUtil;
import com.horus.ankata.web.utils.Messages;
import java.io.Serializable;
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
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author babacar
 */
@Component("structBean")
@Scope("session")
public class ComStructureBeans implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AdminSrv adminSrv;

    private ComStructures item;
    private List<ComStructures> items;
    private ComStructures[] selectedItems;
    private ComStructuresDataModel itemsModel;
    private String action;

    @PostConstruct
    public void init() {
        loadList();
    }

    public void loadList() {
        try {
            items = adminSrv.getGenDao().findHqlAll(ComStructures.class.getName(), " ORDER BY Libelle");
            itemsModel = new ComStructuresDataModel(items);
        } catch (Throwable th) {
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

            List<ComStructures> listes = adminSrv.getGenDao().findHqlAll(ComStructures.class.getName(), "WHERE code='" + item.getCode() + "'and libelle='" + item.getLibelle() + "'and id!='" + idd);

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
            adminSrv.getGenDao().deleteHqlAll(ComStructures.class.getName(), getSelectedItemsIds());
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
        item = new ComStructures();
    }

    public ComStructures getItem() {
        return item;
    }

    public void setItem(ComStructures item) {
        this.item = item;
    }

    public List<ComStructures> getItems() {
        return items;
    }

    public void setItems(List<ComStructures> items) {
        this.items = items;
    }

    public ComStructures[] getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(ComStructures[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

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
}

class ComStructuresDataModel extends LazyDataModel<ComStructures> implements SelectableDataModel<ComStructures> {

    private List<ComStructures> datasource;

    public ComStructuresDataModel() {
    }

    ComStructuresDataModel(List<ComStructures> items) {
        this.datasource = datasource;
    }

    @Override
    public Object getRowKey(ComStructures o) {
        return o.getId();
    }

    @Override
    public ComStructures getRowData(String rowKey) {
        for (ComStructures o : datasource) {
            if (o.getId() == (Integer.parseInt(rowKey))) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<ComStructures> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<ComStructures> data = new ArrayList<ComStructures>();

        //filter  
        for (ComStructures o : datasource) {
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
            Collections.sort(data, new ComStructuresLazySorter(sortField, sortOrder));
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

class ComStructuresLazySorter implements Comparator<ComStructures> {

    private String sortField;

    private SortOrder sortOrder;

    public ComStructuresLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public int compare(ComStructures o1, ComStructures o2) {
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
