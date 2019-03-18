package com.vny.streams.aggregation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;
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

	static class StudentCollector<T extends Student> implements Consumer {

		private List<T> students;

		public StudentCollector() {
			students = new ArrayList<>();
		}

		public List<T> getStudents(){
			return students;
		}
		@Override
		public void accept(Object t) {
			students.add((T)t);
		}
		
		public void combine(StudentCollector studentCollector) {
			students.addAll(studentCollector.getStudents());
		}
		
	}

	
	static class RollNumCollector implements Consumer {

		private List<String> rollNumAndName;

		public RollNumCollector() {
			rollNumAndName = new ArrayList<>();
		}

		public List<String> getStudents(){
			return rollNumAndName;
		}
		@Override
		public void accept(Object t) {
			rollNumAndName.add(((Student)t).getName().toUpperCase() + "_" + ((Student)t).getRollnum());
		}
		
		public void combine(RollNumCollector rollNumCollector) {
			rollNumAndName.addAll(rollNumCollector.getStudents());
		}
		
	}

	
	
	public static void main(String[] args) {

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
		System.out.println("Female Student names with A+ Grade : ");
		names.stream().forEach(e -> System.out.println(e + " "));

		
		/*
		 * Count the students in the school using reduce method
		 */
		Optional<Integer> totalStudents = school.stream().map(e -> e != null ? 1 : 0).reduce((a, b) -> a + b);
		System.out.println("Total age of students in VI class : " + totalStudents.get());
		
		

		/*
		 * Student names using collector
		 */
		StudentCollector<Student> studentNames = school.stream().collect(StudentCollector::new, StudentCollector::accept,
				StudentCollector::combine);
		studentNames.getStudents().forEach(e -> System.out.println(e));
		
		
		/*
		 * Collect names in uppercase with rollnum of all students
		 */
		RollNumCollector rollNumWithNames = school.stream().collect(RollNumCollector::new, RollNumCollector::accept,
				RollNumCollector::combine);
		rollNumWithNames.getStudents().forEach(e -> System.out.println(e));
		// supplier:
		// accumulator:
		// combiner: 

	}

}
