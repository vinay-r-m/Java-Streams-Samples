package com.vny.streams.aggregation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vny.streams.bean.Student;
import com.vny.streams.bean.Student.Gender;
import com.vny.streams.bean.Student.Section;

/**
 * This class demonstrates on the concurrent reduction operations and the Parallel streams.
 * 
 * @author rmv
 *
 */
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
		Map<Section, Double> avgAgeByGender = school.stream()
				.collect(Collectors.groupingBy(Student::getSection, Collectors.averagingInt(Student::getAge)));
		avgAgeByGender.forEach((k, v) -> {
			System.out.print(" Section : " + k);
			System.out.println(" Average : " + v.doubleValue());
		});

		/*
		 * Section wise and Gender wise average age
		 */
		Map<Section, Map<Gender, Double>> avgAgeByGenderBySection = school.stream()
				.collect(Collectors.groupingBy(Student::getSection,
						Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge))));

		avgAgeByGenderBySection.forEach((k, v) -> {
			System.out.println("Section : " + k);
			v.forEach((k1, v1) -> {
				System.out.print("\t" + k1 + " value : " + v1.doubleValue());
			});
			System.out.println();

		});
		
		/*
		 * Parallel streams
		 */
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(Arrays.asList(new Integer[]{1,6,7,3,2,10,9}));
		
		
		
		
		numbers.parallelStream().forEach(e -> System.out.print(e + " "));
		System.out.println(" ");
		numbers.stream().forEach(e -> System.out.print(e + " "));
		System.out.println(" ");

		numbers.parallelStream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println(" ");
		numbers.stream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println(" ");

		
		numbers.parallelStream().sorted().forEach(e -> System.out.print(e + " "));
		System.out.println(" ");
		numbers.stream().sorted().forEach(e -> System.out.print(e + " "));
		System.out.println(" ");
		
		numbers.parallelStream().sorted().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println(" ");
		numbers.stream().sorted().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println(" ");

		/*
		 * Dont modify the stream when they are pipelined.
		 */
		try {
		    List<String> listOfStrings =
		        new ArrayList<>(Arrays.asList("one", "two"));
		  		             
		    Optional<String> data = listOfStrings
		        .stream()		        
		        // Don't do this! Interference occurs here.
		        .peek(s -> listOfStrings.add("three"))		        
		        .reduce((a, b) -> a + " " + b);
		                 
		    System.out.println("Concatenated string: " + data.get());
		         
		} catch (Exception e) {
		    System.out.println("Exception caught: " + e.toString());
		    e.printStackTrace();
		}
		
	}
}
