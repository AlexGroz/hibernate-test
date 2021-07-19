package com.javastart.hibernatetest.dao;

import com.javastart.hibernatetest.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Account save(Account account){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return account;
    }
}
