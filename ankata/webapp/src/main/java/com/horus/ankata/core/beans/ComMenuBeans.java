/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.beans;

import com.horus.ankata.core.domain.commons.ComMenus;
import com.horus.ankata.core.service.AdminSrv;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author babacar
 */
@Component("menu")
@Scope("session")
public class ComMenuBeans {
  
    private AdminSrv adminSrv;
    private ComMenus item;
    private TreeNode root;
    private TreeNode selectedTreeNode;
    private String backPageToDisplay = "pages/welcome";
    private String pageToDisplay = "pages/welcome";
    private String module = "rapports";
    
    
    
    ///////Methode navigation
    public String getBackPageToDisplay() {
		return backPageToDisplay;
	}

	public void setBackPageToDisplay(String backPageToDisplay) {
		this.backPageToDisplay = backPageToDisplay;
	}

	public String getPageToDisplay() {
		return pageToDisplay;
	}

	public void setRedirectPageToDisplay(String pageToDisplay) {
		this.backPageToDisplay = this.pageToDisplay;
		this.pageToDisplay = pageToDisplay;

	}
        public void setPageToDisplay(String pageToDisplay) {
		this.pageToDisplay = pageToDisplay;
                
        }

    public ComMenus getItem() {
        return item;
    }

    public void setItem(ComMenus item) {
        this.item = item;
    }

    public TreeNode getSelectedTreeNode() {
        return selectedTreeNode;
    }

    public void setSelectedTreeNode(TreeNode selectedTreeNode) {
        this.selectedTreeNode = selectedTreeNode;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
        
        
}
