package com.BDD.Tests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import com.BDD.utils.Student;

import io.restassured.http.ContentType;

public class SerializationAndDeserialization {

	Student s=new Student();
	@BeforeClass
	public void createStduentSeriTestData()
	{
		ArrayList<String> coursesList=new ArrayList<String>();
		coursesList.add("plsql");
		coursesList.add("DynamicProgramming");
		
		
		s.setCourses(coursesList);
		s.setEmail("abc@gmelklrail.com");
		s.setFirstName("firsterealklkmebro");
		s.setLastName("LastNamelklreebro");
		s.setProgramme("JavaPrereokkjgrammeBro");
		s.setSID(1093);
	}
	
	@Test(priority=1)
	public void createNewStudentSerialization()
	{
		
		given()
			.contentType(ContentType.JSON)
			.body(s)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat().body("msg", equalTo("Student added"))
			.log().all();
		
	}
	@Test(priority=2)
	public void getdeserilization()
	{
		Student stu= get("http://localhost:8085/student/1092").as(Student.class);
		System.out.println(stu.getStudentRecord());
	}
	
}
