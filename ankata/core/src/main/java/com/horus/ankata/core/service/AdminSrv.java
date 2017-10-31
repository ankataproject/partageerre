/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.service;

import com.horus.ankata.core.dao.GenDao;
import com.horus.ankata.core.domain.commons.ComUsers;

/**
 *
 * @author babacar
 */
public interface AdminSrv {
    GenDao  getGenDao();
    boolean connexion(String structure,String login, String mdp);
    ComUsers userConnecter(String login);
    boolean userAccess(String profile, String menu);
}
