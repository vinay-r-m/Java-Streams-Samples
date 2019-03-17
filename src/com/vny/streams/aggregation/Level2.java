package com.vny.streams.aggregation;

import java.util.List;
import java.util.stream.Stream;

import com.vny.streams.bean.Student;

public class Level2 {

	public static void main(String[] args) {

		List<Student> school = Student.createSchool();

		/*
		 * Streams doesn't store the data, it is not a data-structure
		 */
		Stream<Student> studentStream = school.stream();

		/*
		 * Count the number of students
		 */
		System.out.println("Number of students in school : " + studentStream.count());

		try {
			// The below line will through an exception
			System.out.println("Number of students in school : " + studentStream.count());
		} catch (IllegalStateException exp) {
			System.out.println("Oops dont do that, Stream is closed : " + exp.getLocalizedMessage());
		}

		System.out.println(" ");

		/*
		 * Aggregation with intermediate operation Before Java 8
		 * 
		 */
		System.out.println("### Aggregation with intermediate operation before Java 8");
		for (Student student : school) {
			if (student.getGrade() == Student.Grade.A_PLUS) {
				System.out.println(student);
			}
		}
		System.out.println(" ");

		/*
		 * Aggregation with intermediate operation after Java 8
		 */
		System.out.println("### Aggregation with intermediate operation after Java 8");
		school.stream().filter(student -> student.getGrade() == Student.Grade.A_PLUS)
				.forEach(student -> System.out.println(student));
		// school : source
		// filter : intermediate Operation --> There can be one are more
		// intermediate Operations
		// aggregate functions
		// forEach : Terminal Operation

		System.out.println(" ");

		/*
		 * Limiting the Results
		 */
		System.out.println("Total Female students : "
				+ school.stream().filter(e -> e.getGender() == Student.Gender.FEMALE).count());
		System.out.println("## Limit to 3 results");
		school.stream().filter(student -> student.getGender() == Student.Gender.FEMALE).limit(3)
				.forEach(student -> System.out.println(student));
		System.out.println(" ");
		
	}

}
