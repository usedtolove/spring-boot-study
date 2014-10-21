package com.mycompany.study.dao;

import com.mycompany.study.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2014/10/21.
 *
 */
public class CustomerDaoImpl implements CustomerDaoCustom {

    @PersistenceContext//Expresses a dependency on a container-managed EntityManager and its associated persistence context.
    private EntityManager em;
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Customer> getByProp(String prop, Object value) {
        String ql = "select c from Customer as c where c."+prop+" = :value";
        Query query = em.createQuery(ql);
        query.setParameter("value", value);
        List<Customer> list = query.getResultList();
        return list;
    }
}
