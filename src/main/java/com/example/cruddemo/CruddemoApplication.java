package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);

            // createMultipleStudents(studentDAO);

            //readStudent(studentDAO);
            
            //queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);

        };

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        //display list of students
        for (Student tempStudent: theStudents ){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // Create a student object

        System.out.println("Creating a new student object.. ");
        Student tempstudent = new Student( "Daffy", "Duck", "daffy@gmail.com");


        // save the student
        System.out.println("Saving the student.. ");

        studentDAO.save(tempstudent);



        // display id of the saved student
        int theId = tempstudent.getId();
        System.out.println("Generated id of the saved students  "+ theId);


        // retrieve student basd on the id: primary key
        System.out.println("Terreiving the  profile of the saved students  "+ theId);
        Student  myStudent= studentDAO.findById(theId);

        // display student
        System.out.println("FOund the  profile of the saved students  "+ myStudent);


    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating Multiple student Object..");
        Student tempstudent1 = new Student( "john", "doe", "john@gmail.com");
        Student tempstudent2 = new Student( "Jessi", "hopam", "jessy@gmail.com");
        Student tempstudent3 = new Student( "Peter", "Parker", "Peter@gmail.com");


        // save student objects
        System.out.println("Saving Multiple students..");
        studentDAO.save(tempstudent1);
        studentDAO.save(tempstudent2);
        studentDAO.save(tempstudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student Object..");
        Student tempstudent = new Student( "paul", "mark", "paul@gmail.com");

        //save the student object
        System.out.println("Saving the student..");
        studentDAO.save(tempstudent);


        //display id of the student object
        System.out.println("Saved student generated id "+ tempstudent.getId() );
    }


}

