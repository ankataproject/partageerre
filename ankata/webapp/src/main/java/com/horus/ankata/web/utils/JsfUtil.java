package com.horus.ankata.web.utils;

import com.horus.ankata.core.beans.ComMenuBeans;
import com.horus.ankata.core.commonutils.Constant;
import com.horus.ankata.core.pojo.Erreur;
import com.horus.ankata.web.beans.ErreurBean;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.dialog.Dialog;
import org.primefaces.context.RequestContext;


public class JsfUtil {
	public static String getAppWebroot() {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext(); 
		return servletContext.getRealPath("/");
	}
	public static void displayError(Throwable th) {
		th.printStackTrace();
		List<Erreur> erreurs = new ArrayList<Erreur>();
		erreurs.add(new Erreur(th));
	    while (th.getCause() != null) {
            th = th.getCause();
            erreurs.add(new Erreur(th));
        }
        if(erreurs.size()>0) {        	 
        	displayError(erreurs);
        }
        
    }

    public static void displayError(List<Erreur> erreurs) {
        try {
            if (erreurs.size() > 0) {
                ErreurBean errorBean = (ErreurBean) JsfUtil.getManagedBean("error");
                if (errorBean != null) {
                    errorBean.setErreurs(erreurs);
                    pageRedirect("common/erreur");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void pageRedirect(String page) {
        try {
            ComMenuBeans menu = (ComMenuBeans) getManagedBean("menu");
            if (menu != null) {
                menu.setRedirectPageToDisplay(page);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/"+Constant.APP_CONTEXT+"/");
            }

        } catch (IOException ex) {
            Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void pageBack() {
        try {
            ComMenuBeans menu = (ComMenuBeans) getManagedBean("menu");
            if (menu != null) {
                menu.setRedirectPageToDisplay(menu.getBackPageToDisplay());
                FacesContext.getCurrentInstance().getExternalContext().redirect("/"+Constant.APP_CONTEXT+"/");
            }

        } catch (IOException ex) {
            Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public static Object getManagedBean(String beanName) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueBinding bind = ctx.getApplication().createValueBinding("#{" + beanName + "}");
        Object bean = (Object) bind.getValue(ctx);
        return bean;
    }
    
   

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    public static void addValidatorError(String msg) {    	
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,""));       
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    //https://community.jboss.org/thread/8446
    public static void clearComponentHierarchy(UIComponent pComponent) {

        if (pComponent.isRendered()) {

            if (pComponent instanceof EditableValueHolder) {
                EditableValueHolder editableValueHolder = (EditableValueHolder) pComponent;
                editableValueHolder.setSubmittedValue(null);
                editableValueHolder.setValue(null);
                editableValueHolder.setLocalValueSet(false);
                editableValueHolder.setValid(true);
            }

            for (Iterator<UIComponent> iterator = pComponent.getFacetsAndChildren(); iterator.hasNext();) {
                clearComponentHierarchy(iterator.next());
            }

        }
    }
    
   
    
    public static void createDialog() {
    	 FacesContext facesContext = FacesContext.getCurrentInstance();
    	 UIComponent panelGroup = facesContext.getViewRoot().findComponent("projetform");
    	System.out.println("found or not??"+ panelGroup.toString());
	    Dialog dialog = new Dialog();
	    dialog.setId("sample");
	    dialog.setWidgetVar("widget");
	    dialog.setHeader("Sample");
	    dialog.setVisible(true);
	    dialog.setMinimizable(true);

	    dialog.setDynamic(true);
	    dialog.setHideEffect("fade");
	    dialog.setFooter("footer");

	    dialog.setDraggable(true);
	    dialog.setMinWidth(600);
	    dialog.setClosable(true);
	    dialog.setModal(false);
	    

	    panelGroup.getChildren().add(dialog);

	    RequestContext requestContext = RequestContext.getCurrentInstance();
	    requestContext.execute("PF('widget').show()");     
	    requestContext.update("projetform");
    }
    
    public static String getComponentValue(UIComponent form,String id) {
    	String v="";
    	
    	if(form.findComponent(id)!=null){
    		Object ip=((UIInput) form.findComponent(id)).getLocalValue();
    		if(ip!=null)
    		v=ip.toString();
    	}

        return v;
     }
    
	
	
	
}
