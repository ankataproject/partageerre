/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horus.ankata.core.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author babacar
 */
@Service("genDao")
@Transactional
public class GenDaoImp implements GenDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getsessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<Object> findHqlAll(String model, String criteres) {
        Query q = sessionFactory.getCurrentSession().createQuery("from " + model + " " + criteres);
        return q.list();
    }

    @Override
    public List findHql(String query) {
        Query q = sessionFactory.getCurrentSession().createQuery(query);
        return q.list();
    }

    @Override
    public List findSql(String query) {
        Query q = sessionFactory.getCurrentSession().createSQLQuery(query);
        return q.list();
    }

    @Override
    public Object findHqlUnique(String query) {
        Query q = sessionFactory.getCurrentSession().createQuery(query);
        return q.uniqueResult();
    }

    @Override
    public Object findHqlUnique(String model, String where) {
        Query q = sessionFactory.getCurrentSession().createQuery("from " + model + " " + where);
        return q.uniqueResult();
    }

    @Override
    public Object findHqlById(String model, Long id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from " + model + " where id = :id");
        q.setLong("id", id);
        return q.uniqueResult();
    }

    @Override
    public Object findHqlByCode(String model, String code) {
        Query q = sessionFactory.getCurrentSession().createQuery("from " + model + " where code = :code");
        return q.uniqueResult();
    }

    @Override
    public void save(Object o) {
        sessionFactory.getCurrentSession().save(o);
    }

    @Override
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(Object o) {
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    public int deleteHql(String q) {
        int rowCount = 0;
        Session sess = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            //System.out.println(q);
            Query query = sess.createQuery(q);
            rowCount = query.executeUpdate();
            tx.commit();
        } catch (Throwable t) {
            tx.rollback();
            t.printStackTrace();
        }
        return rowCount;
    }

    @Override
    public int deleteSqlAll(String model, List<Long> liste) {
        String q = "delete from " + model + "where in (" + longArrayToString(liste) + ");";
        return sessionFactory.getCurrentSession().createSQLQuery(q).executeUpdate();
    }

    @Override
    public int deleteHqlAll(String model, List<Long> liste) {
        int rowCount = 0;
        String hql = "delete from " + model + " where id in (" + longArrayToString(liste) + ")";
        //System.out.println(hql);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        rowCount = query.executeUpdate();
        return rowCount;
    }

    private String longArrayToString(List<Long> liste) {
        String s="";
		for(Long _i:liste) {
			s+=_i+",";
		}
		if (s.length()>0)s=s.substring(0,s.length()-1);
		return s;
    }

}
