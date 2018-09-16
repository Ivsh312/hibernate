
package by.bsu.hib.main;

import by.bsu.hib.servisLayer.CourseService;
import by.bsu.hib.servisLayer.StudentSerice;
import by.bsu.entity.Course;
import by.bsu.entity.Student;
import by.bsu.hiber.util.HibernateUtil;
import java.util.HashSet;

public class StudentCourseSimplestDemo {

    public static void main(String[] args) {

            StudentSerice ss = new StudentSerice();
            CourseService cs = new CourseService();
            String courseTitle1 = "Java";
            Course course1 = new Course();
            course1.setTitle(courseTitle1);
            HashSet<Student> set1 = new HashSet<Student>() {
                {
                    this.add(new Student("Ivanov", "Vitalii"));
                    this.add(new Student("Reut", "Alexandra"));
                    this.add(new Student("Tomkevich", "Alina"));
                }
            };
            course1.setStudents(set1);
            System.out.println(cs.addCourse(course1));
            String courseTitle2 = "Design Patterns for Java";
            Course course2 = new Course();
            course2.setTitle(courseTitle2);
            cs.addCourse(course2);
           //Set<Student> setRes = CourseService.getInstance().findRegistedOnCourse(courseTitle1);
            Student student1 = new Student("Zanko", "Vital");
            ss.addStudent(student1);
            //System.out.println(setRes);
            Student student2 = ss.getStudent("Ivanov");
            System.out.println(student2);
            HashSet<Student> set2 = new HashSet<>();
            set2.add(student1);
            set2.add(student2);
            course2.setStudents(set2);
            cs.addCourse(course2); 
            System.out.println("1111");
            
            System.out.println(cs.findRegistedOnCourse(courseTitle1).toString());
            
            HibernateUtil.shoutDown();
    }
}
