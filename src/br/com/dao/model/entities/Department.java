package br.com.dao.model.entities;

import java.io.Serializable;

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public Department() {}
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(this.id);
	}

	@Override
	public boolean equals(Object ref) {
		Department other = (Department) ref;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
