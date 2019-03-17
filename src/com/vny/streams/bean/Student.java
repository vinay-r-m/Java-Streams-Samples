/**
 * Student bean class
 */
package com.vny.streams.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author rmv
 *
 */
public class Student {

	public enum Gender {
		MALE, FEMALE
	}

	public enum Grade {
		A_PLUS, A, B_PLUS, B, C, D
	}

	public enum Section {
		I, II, III, IV, V, VI, VII, VIII, IX, X
	}

	private String name;
	private int age;
	private Grade grade;
	private String rollnum;
	private Gender gender;
	private Section section;

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Student setAge(int age) {
		this.age = age;
		return this;

	}

	public Grade getGrade() {
		return grade;
	}

	public Student setGrade(Grade grade) {
		this.grade = grade;
		return this;

	}

	public String getRollnum() {
		return rollnum;
	}

	public Student setRollnum(String rolenum) {
		this.rollnum = rolenum;
		return this;

	}

	public Gender getGender() {
		return gender;
	}

	public Student setGender(Gender gender) {
		this.gender = gender;
		return this;

	}

	public Section getSection() {
		return section;
	}

	public Student setSection(Section section) {
		this.section = section;
		return this;

	}

	@Override
	public String toString() {
		return name+"_"+rollnum+" [name=" + name + ", age=" + age + ", grade=" + grade + ", rolenum=" + rollnum + ", gender="
				+ gender + ", section=" + section + "]";
	}
	
	
	public static List<Student> createSchool() {

		Random random = new Random();
		List<Student> school = new ArrayList<>();
		school.add(new Student().setAge(6).setGender(Gender.MALE).setGrade(Grade.A).setName("Luke")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.II));
		school.add(new Student().setAge(5).setGender(Gender.FEMALE).setGrade(Grade.A_PLUS).setName("Jack")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.I));
		school.add(new Student().setAge(7).setGender(Gender.MALE).setGrade(Grade.B).setName("joy")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.III));
		school.add(new Student().setAge(8).setGender(Gender.MALE).setGrade(Grade.B_PLUS).setName("Ray")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.VII));
		school.add(new Student().setAge(8).setGender(Gender.MALE).setGrade(Grade.C).setName("Mike")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.IX));
		school.add(new Student().setAge(12).setGender(Gender.FEMALE).setGrade(Grade.D).setName("Ace")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.X));
		school.add(new Student().setAge(6).setGender(Gender.FEMALE).setGrade(Grade.D).setName("Jos")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.II));
		school.add(new Student().setAge(10).setGender(Gender.FEMALE).setGrade(Grade.A_PLUS).setName("Julie")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.X));
		school.add(new Student().setAge(8).setGender(Gender.FEMALE).setGrade(Grade.B).setName("Bob")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.IV));
		school.add(new Student().setAge(9).setGender(Gender.MALE).setGrade(Grade.D).setName("David")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.VII));
		school.add(new Student().setAge(8).setGender(Gender.MALE).setGrade(Grade.C).setName("Zack")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.IX));
		school.add(new Student().setAge(9).setGender(Gender.FEMALE).setGrade(Grade.D).setName("Mozic")
				.setRollnum(String.valueOf(random.ints(1000, (9999)).findFirst().getAsInt())).setSection(Section.X));
		return school;

	}
}
