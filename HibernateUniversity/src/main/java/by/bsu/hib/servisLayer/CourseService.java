
package by.bsu.hib.servisLayer;

import by.bsu.DaoLayer.CourseDaoLayer;
import by.bsu.entity.Student;
import by.bsu.entity.Course;
import by.bsu.hiber.util.SessionUtil;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CourseService extends SessionUtil implements CourseDaoLayer {
    public Set<Student> findRegistedOnCourse(String courseTitle) {
        Session session = null;
        Set<Student> registedOnCourse = null;
        Set<Student> s = null;
        Transaction t = openTransaction();
            session = getSession();
            
            Query query = session.createQuery("FROM Course WHERE title=:title");
            query.setParameter("title", courseTitle);
            Course course = (Course) query.uniqueResult();
            registedOnCourse = course.getStudents();
            s = registedOnCourse;
            t.commit();
            session.close();

        return s;

    }

    public boolean addCourse(Course course) {
        boolean flag = false;
        Transaction t = null;
        Session session = null;
        try {
            t = openTransaction();
            session = getSession();
            session.saveOrUpdate(course);
            t.commit();
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return flag;
    }
}
