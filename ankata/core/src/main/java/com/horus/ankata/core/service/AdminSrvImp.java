/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.service;

import com.horus.ankata.core.commonutils.StringUtils;
import com.horus.ankata.core.dao.GenDao;
import com.horus.ankata.core.domain.commons.ComUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author babacar
 */
@Service("adminSrv")
@Transactional
public class AdminSrvImp implements AdminSrv {

    @Autowired
	private GenDao genDao;
    
    @Override
    public GenDao getGenDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setGenDao(GenDao genDao) {
		this.genDao = genDao;
	}

    @Override
    public boolean connexion(String structure,String login, String mdp) {
        String query;
		try {
			//query = " FROM "+EpgUsers.class.getName()+" WHERE login='admin'";
			query = " FROM "+ComUsers.class.getName()+" WHERE structure='"+structure+"' AND login='"+login+"' AND mdp='"+StringUtils.getEncodedMD5Password(mdp)+"'";
			ComUsers u=(ComUsers) genDao.findHqlUnique(query);
			if(u!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
    }

    @Override
    public ComUsers userConnecter(String login) {
       String query;
		try {
			query = " FROM "+ComUsers.class.getName()+" WHERE login='"+login+"'";
			ComUsers u=(ComUsers) genDao.findHqlUnique(query);
			if(u!=null) {
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
    }

    @Override
    public boolean userAccess(String profile, String menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
