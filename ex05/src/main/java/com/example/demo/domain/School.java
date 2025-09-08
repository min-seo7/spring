package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter	
@NoArgsConstructor
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long	id;
	private	String	name;
	
	@OneToMany(mappedBy	= "school",	cascade	= CascadeType.ALL, orphanRemoval = true)
	private	List<Student> students = new	ArrayList<>();
	
	public	School(String	name)	{
		this.name	=	name;
	}
	
	public	void	addStudent(Student	student){
		this.students.add(student);
	  student.updateSchool(this);
				}
}
