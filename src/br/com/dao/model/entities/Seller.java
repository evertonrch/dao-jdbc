package br.com.dao.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;
	private Date birthDate;
	private double baseSalary;
	private Department department;
	
	public Seller() {}

	public Seller(int id, String name, String email, Date birthDate, double baseSalary, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	@Override
	public boolean equals(Object ref) {		
		Seller s = (Seller) ref;
		if(id != s.getId())
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(this.id);
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name 
				+ ", email=" + email + ", birthDate=" + birthDate 
				+ ", baseSalary="+ baseSalary 
				+ ", department=" + department + "]";
	}

}
