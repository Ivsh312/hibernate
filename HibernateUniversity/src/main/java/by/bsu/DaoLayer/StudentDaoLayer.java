
package by.bsu.DaoLayer;

import by.bsu.entity.Student;

public interface StudentDaoLayer {
    public Student getStudent(String lastName);
     public boolean studentExists(String lastName);
    public void addStudent(Student student);

    public void deleteStudent(Student student);

    public void updateStudent(Student student);
}
