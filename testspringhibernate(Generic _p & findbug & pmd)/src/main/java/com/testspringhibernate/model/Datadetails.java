/**
 * 
 */
package com.testspringhibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Dell
 *
 */
@Component
@Entity(name="shmdata")
public class Datadetails {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	int id;
	String name;
	String str1;
	
	public Datadetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Datadetails [id=" + id + ", name=" + name + ", str1=" + str1 + "]";
	}
}	
