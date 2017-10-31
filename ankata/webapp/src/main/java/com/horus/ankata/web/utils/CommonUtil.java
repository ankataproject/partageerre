/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.horus.ankata.web.utils;


import com.horus.ankata.web.beans.LoginBeans;
import com.horus.ankata.core.beans.ComMenuBeans;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;





/**
 *
 * @author Administrateur
 */
@SuppressWarnings("deprecation")
public class CommonUtil {
    
    
    public static LoginBeans getLogin() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueBinding bind = ctx.getApplication().createValueBinding("#{loginBean}");
        LoginBeans bean = (LoginBeans) bind.getValue(ctx);
        return bean;
    }
   
     public static ComMenuBeans getMenu() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueBinding bind = ctx.getApplication().createValueBinding("#{menu}");
        ComMenuBeans bean = (ComMenuBeans) bind.getValue(ctx);
        return bean;
    }
    
    
    public static boolean estEntier(String string) {

		/** Tester si string est un r�el **/
		long lg;
		try {
			lg = Long.parseLong(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
		/** Fin Tester si string est un r�el **/
	}
  
}
