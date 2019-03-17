package com.vny.streams.aggregation;

import java.util.List;

import com.vny.streams.bean.Student;

public class Level1 {

	public static void main(String[] args) {
		List<Student> school = Student.createSchool();

		/*
		 * Aggregation Operation Before Java 8
		 * 		 
		 */
		System.out.println("### Aggregation Operation Before Java 8");
		for(Student student: school){
			System.out.println(student);
		}
		System.out.println(" ");

		/*
		 * Aggregation Operation After Java 8
		 */
		System.out.println("### Aggregation Operation After Java 8");
		school.stream().forEach(student -> System.out.println(student));
		System.out.println(" ");

	}

}
