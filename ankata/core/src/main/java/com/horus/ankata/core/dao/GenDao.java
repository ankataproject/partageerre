package com.horus.ankata.core.dao;

import java.util.List;
import org.hibernate.SessionFactory;

public interface GenDao {

    SessionFactory getsessionFactory();
    List findHqlAll(String model, String criteres);
    List findHql(String query);
    public List findSql(String query);

    Object findHqlUnique(String query);
    Object findHqlUnique(String model, String where);
    Object findHqlById(String model, Long id);
    Object findHqlByCode(String model, String code);
    
    void save(Object o);
    void update(Object o);
    
    void delete(Object o);
    int deleteHql(String q);
    int deleteSqlAll(String model,List<Long> liste);
    int deleteHqlAll(String model,List<Long> liste);
    
}
