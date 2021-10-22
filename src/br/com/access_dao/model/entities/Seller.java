package br.com.access_dao.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private Date birthDate;
	private Double baseSalary;
	private Department department;
	
	public Seller() {}

	public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department) {
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
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
