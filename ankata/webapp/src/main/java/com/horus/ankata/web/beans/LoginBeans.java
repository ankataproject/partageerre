/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.web.beans;


import com.horus.ankata.core.commonutils.Constant;
import com.horus.ankata.core.domain.commons.ComStructures;
import com.horus.ankata.core.domain.commons.ComUsers;
import com.horus.ankata.core.pojo.Erreur;
import com.horus.ankata.core.service.AdminSrv;
import com.horus.ankata.web.utils.CommonUtil;
import com.horus.ankata.web.utils.JsfUtil;
import com.horus.ankata.web.utils.Messages;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

/**
 *
 * @author babacar
 */
@Component("loginBeans")
@Scope
public class LoginBeans implements Serializable{

    @Autowired
    private AdminSrv adminSrv;
    private ComUsers userConnecte;
    private List<Erreur> erreurs;
    private String structure = null;
    private String login = "admin";
    private String mdp = "admin";
    private String status = "false";
    private String enable = "false";
    private boolean connecter = false;
    private String newmdp;
    private String cnewmdp;
    private String action = "";

    
    private Long societe;
	private List<SelectItem> listSociete = new ArrayList<SelectItem>();
    
   
   
    

	

    @PostConstruct
    private void init() {
    	loadSelect();
    }
    
    @SuppressWarnings("unchecked")
	public void loadSelect() {
		listSociete.clear();
		
		List<ComStructures> l = (List<ComStructures>) adminSrv.getGenDao().findHqlAll(
				ComStructures.class.getName(), "");
		for (Iterator it = l.iterator(); it.hasNext();) {
			ComStructures srv = (ComStructures) l.get(l.indexOf(it.next()));
			listSociete.add(new SelectItem(srv.getId(), srv.getLibelle().toUpperCase()));

		}

		
		
	}
    
    
    public void putLogin(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        String svalue = (String) value;
        login = svalue;
    }

    public void putStructure(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        String svalue = (String) value;
        structure = svalue;
    }

    public void validateMdp(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        String svalue = (String) value;
        mdp = svalue;

        if (login != null && structure != null) {
            if (!adminSrv.connexion(structure, login, mdp)) {
                Object[] messageArguments = {};
                throw new ValidatorException(new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, Messages.getString("error.connexion", messageArguments),
                        ""));
            } else {
                userConnecte = (ComUsers) adminSrv.userConnecter(login);
            }
        }

    }

    public void validateLogin(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        String svalue = (String) value;
        login = svalue;
    }

    public void validateStructure(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        String svalue = (String) value;
        structure = svalue;
    }

    public void action() {
       if (action.equals("login")) {
            login();
        }
        if (action.equals("annuler")) {
            annuler();
        }

        if (action.equals("connexion")) {
            connexion();
        }
        if (action.equals("deconnexion")) {
            deconnexion();
        }
        if (action.equals("effacer")) {
            login = "";
            mdp = "";
        }
     
    }

    private void login() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(("/" + Constant.APP_CONTEXT + "/"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void annuler() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/" + Constant.APP_CONTEXT + "/");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void connexion() {
        try {
            LoginBeans lb = CommonUtil.getLogin();
            lb.setConnecter(true);
            lb.setUserConnecte(userConnecte);
            JsfUtil.pageRedirect("pages/welcome");

        } catch (CannotCreateTransactionException e) {
            connexion();
        }
    }

    private void deconnexion() {
        try {
            try {
                connecter = false;
                userConnecte = null;
                FacesContext.getCurrentInstance().getExternalContext().redirect("/" + Constant.APP_DIR_NAME + "/");
            } catch (Exception ex) {
                Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (CannotCreateTransactionException e) {
            connexion();
        }
    }

    public ComUsers getUserConnecte() {
        return userConnecte;
    }

    public void setUserConnecte(ComUsers userConnecte) {
        this.userConnecte = userConnecte;
    }

    public List<Erreur> getErreurs() {
        return erreurs;
    }

    public void setErreurs(List<Erreur> erreurs) {
        this.erreurs = erreurs;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public boolean isConnecter() {
        return connecter;
    }

    public void setConnecter(boolean connecter) {
        this.connecter = connecter;
    }

    public String getNewmdp() {
        return newmdp;
    }

    public void setNewmdp(String newmdp) {
        this.newmdp = newmdp;
    }

    public String getCnewmdp() {
        return cnewmdp;
    }

    public void setCnewmdp(String cnewmdp) {
        this.cnewmdp = cnewmdp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getSociete() {
        return societe;
    }

    public void setSociete(Long societe) {
        this.societe = societe;
    }

    public List<SelectItem> getListSociete() {
        return listSociete;
    }

    public void setListSociete(List<SelectItem> listSociete) {
        this.listSociete = listSociete;
    }

}
