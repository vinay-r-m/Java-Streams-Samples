package com.vny.streams.aggregation;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.vny.streams.bean.Student;

/**
 * Map Reduce functionality. For more examples refer to the link
 * https://docs.oracle.com/javase/tutorial/collections/streams/examples/ReductionExamples.java
 * 
 * @author rmv
 *
 */
public class Level3 {

	public static void main(String[] args) {

		/*
		 * Intermediate Map
		 */
		List<Student> school = Student.createSchool();

		/*
		 * Get the average age of students in class IV
		 */
		double average = school.stream().filter(e -> e.getSection() == Student.Section.IV).mapToInt(e -> e.getAge())
				.average().getAsDouble();
		System.out.println("Average age of class IV is " + average);

		/*
		 * Get the average age of students in class VI usage of function
		 * reference
		 */
		OptionalDouble optionalAverage = school.stream().filter(e -> e.getSection() == Student.Section.VI)
				.mapToInt(Student::getAge).average();
		if (optionalAverage.isPresent()) {
			System.out.println("Average age of class VI is " + optionalAverage.getAsDouble());
		} else {
			System.out.println("No students in class VI");
		}

		/*
		 * Average age of students whose names start with a vowel
		 */
		OptionalDouble optionalAvgAge = school.stream().filter(e -> e.getName().matches("(^[aeiouAEIOU].*)"))
				.mapToInt(Student::getAge).average();
		if (optionalAvgAge.isPresent()) {
			System.out.println("Average age of students whose names starts with vowel " + optionalAvgAge.getAsDouble());
		} else {
			System.out.println("No students whose names starts with vowel ");
		}

		/*
		 * Get the rollnum of female students with A+ Grade
		 */
		List<String> rollNum = school.stream()
				.filter(e -> e.getGender() == Student.Gender.FEMALE && e.getGrade() == Student.Grade.A_PLUS)
				.map(Student::getRollnum).collect(Collectors.toList());
		System.out.print("Female Students with A+ Grade : ");
		rollNum.stream().forEach(e -> System.out.print(e + " "));
		System.out.println();

		/*
		 * Get the Names of female students with A+ Grade Ensure the Names are
		 * in capital letter
		 */

		List<String> names = school.stream()
				.filter(e -> e.getGender() == Student.Gender.FEMALE && e.getGrade() == Student.Grade.A_PLUS)
				.map(e -> e.getName().toUpperCase()).collect(Collectors.toList());
		System.out.print("Female Student names with A+ Grade : ");
		names.stream().forEach(e -> System.out.print(e + " "));

	}

}
