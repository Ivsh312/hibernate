/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.entity;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = ("student"))
@NamedQuery(name = "findStudentByLastName",
        query = "select s from Student s where s.lastName = :lastName")
public  class Student implements Serializable{

    @Id
    @GenericGenerator(name = "auto_inc", strategy = "increment")
    @GeneratedValue(generator = "auto_inc")
    @Column(name = ("ID"))
    private Long id;
    @Column(name = ("LAST_NAME"))
    private String lastName;
    @Column(name = ("FIRST_NAME"))
    private String firstName;

    public Student() {
        /* more code */ }

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Student(Long id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    // getters and setters

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + '}';
    }

}
