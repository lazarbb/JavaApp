package project.controller;

import project.model.Entity;
import project.util.MyException;
import project.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class Processing<T extends Entity>{
    
    protected T entity;
    protected Session session;
    public abstract List<T> read();
    protected abstract void controlInput() throws MyException;
    protected abstract void controlChange() throws MyException;
    protected abstract void controlDeletion() throws MyException;
    
    public Processing(){
        session = HibernateUtil.getSession();
    }
    
    public void create() throws MyException {
        controlNull();
        entity.setPassword(null);
        controlInput();
        persist();
    }
    
    public void update() throws MyException {
        controlNull();
        controlChange();
        persist();
    }
    
    public void delete() throws MyException {
        controlNull();
        controlDeletion();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
    }
    
    private void controlNull() throws MyException {
       if(entity ==null){
            throw new MyException("Entity is null");
        } 
       
    }
    

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

}