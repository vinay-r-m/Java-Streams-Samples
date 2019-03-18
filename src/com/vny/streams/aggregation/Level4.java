package com.vny.streams.aggregation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vny.streams.bean.Student;
import com.vny.streams.bean.Student.Section;

public class Level4 {

	public static void main(String[] args) {

		List<Student> school = Student.createSchool();

		/*
		 * Get the count of Female and Male Students in the class
		 */
		Map<Student.Gender, List<Student>> byGender = school.stream()
				.collect(Collectors.groupingBy(Student::getGender));

		byGender.forEach((k, v) -> {
			System.out.print(" Gender : " + k);
			System.out.println(" Count : " + v.stream().count());
		});
		
		
		
		/*
		 * Average age per class 
		 */
		Map<Section, Double> avgAgeByGender = school.stream().collect(Collectors.groupingBy(
	            		Student::getSection,                      
	                    Collectors.averagingInt(Student::getAge)));
		avgAgeByGender.forEach((k, v) -> {
			System.out.print(" Section : " + k);
			System.out.println(" Average : " + v.doubleValue());
		});
		
		
	}

}
