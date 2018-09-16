
package by.bsu.hib.servisLayer;

import by.bsu.DaoLayer.StudentDaoLayer;
import by.bsu.entity.Student;
import by.bsu.hiber.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentSerice extends SessionUtil implements StudentDaoLayer {

    public Student getStudent(String lastName) {
        Student student = null;
        openTransaction();
        Session session = getSession();
        try {
            Query query = session.getNamedQuery("findStudentByLastName");
            query.setParameter("lastName", lastName);
            student = (Student) query.uniqueResult();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student;
    }

    public boolean studentExists(String lastName) {
        Student student = null;
        openTransaction();
        Session session = getSession();
        try {
            Query query = session.getNamedQuery("findStudentByLastName");
            query.setParameter("lastName", lastName);
            student = (Student) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student != null;
    }

    public void addStudent(Student student) {
        Transaction t = null;
        Session session = null;
        try {
            t = openTransaction();
            session = getSession();
            session.save(student);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteStudent(Student student) {
        Transaction t = null;
        Session session = null;
        try {
            t = openTransaction();
            session = getSession();
            session.delete(student);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateStudent(Student student) {
        Transaction t = null;
        Session session = null;
        try {
            t = openTransaction();
            session = getSession();
            session.update(student);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
