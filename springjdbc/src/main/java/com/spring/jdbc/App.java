package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started" );
//        ApplicationContext context = 
//        		new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
          ApplicationContext context = 
        		  new AnnotationConfigApplicationContext(JdbcConfig.class);
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//       
//        //insert
//        String query = "insert into student(id,name,city) values(?,?,?)";
//        
//        //fire the query
//        int result = template.update(query, 456, "Arthur", "England");
//        System.out.println("No of rows affected..." + result);
        
         StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        Student student = new Student();
//        student.setId(1927);
//        student.setName("Peaky");
//        student.setCity("America");
//        
//        int res =  studentDao.insert(student);
//        System.out.println("Student added " + res);
        
//        Student student = new Student();
//        student.setId(1927);
//        student.setName("Finn");
//        student.setCity("London");
//        int res = studentDao.change(student);
//        System.out.println("Student changed " + res);
        
//         int res = studentDao.delete(1927);
//         System.out.println("Student deleted " + res);
         
//         Student student = studentDao.getStudent(17);
//         System.out.println(student);
         
         List<Student> students = studentDao.getAllStudents();
         for(Student s : students) {
        	 System.out.println(s);
         }
         
    }
}
