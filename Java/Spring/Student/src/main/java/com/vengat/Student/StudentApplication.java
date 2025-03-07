package com.vengat.Student;

import com.vengat.Student.model.Student;
import com.vengat.Student.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);

		Student stu = context.getBean(Student.class);
		stu.setId(1004);
		stu.setName("Ramesh");
		stu.setMarks(37);


		StudentService service = context.getBean(StudentService.class);
		service.addStudent(stu);

		List<Student> s1 = service.getStudents();
		System.out.println(s1);
		for(Student temp : s1){
			System.out.println("data ====> "+temp);
		}
	}

}
