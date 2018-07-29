package com.soft.app.RestfulWebServicesCRUD.DAOImpl;

import com.soft.app.RestfulWebServicesCRUD.DAO.UserDAO;
import com.soft.app.RestfulWebServicesCRUD.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Autowired
    public void someService(EntityManagerFactory emf){
        sessionFactory=emf.unwrap(SessionFactory.class);

    }

    @Override
    public List<User> getAllUsers() {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        List<User> users=session.createQuery("FROM User user").list();
        trans.commit();
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        session.save(user);
        trans.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        session.update(user);
        trans.commit();
        session.close();

    }

    @Override
    public void removeUser(int userId) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        User user=(User)session.get(User.class,userId);
        session.delete(user);
        trans.commit();
        session.close();

    }

    @Override
    public User getUserById(int userId) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        User user=(User)session.get(User.class,userId);
        session.close();
        trans.commit();
        return user;
    }
}
