package com.lab.jpa.repository;

import com.lab.jpa.entities.Department;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CompanyDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    Session session = null;
    
    private Session getSession(){
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        return  session;
    }
    
    // 儲存部門資料
    @Transactional
    public void saveDept(Department dept){
        getSession().save(dept);
    }
    
    // 查詢所有部門資料
    public List queryForAllDepts(){
        List list = getSession().createQuery("from Department d").list();
        return list;
    }
    
    // 查詢所有社團資料
    public List queryForAllClubs(){
        List list = getSession().createQuery("from Club c").list();
        return list;
    }
    
    // 查詢所有員工資料
    public List queryForAllEmps(){
        List list = getSession().createQuery("from Employee e").list();
        return list;
    }
    
}
