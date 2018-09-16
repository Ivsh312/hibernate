
package by.bsu.DaoLayer;

import by.bsu.entity.Course;
import by.bsu.entity.Student;
import java.util.Set;

public interface CourseDaoLayer {
    public Set<Student> findRegistedOnCourse(String courseTitle);

    public boolean addCourse(Course course);
}
