package hu.dw9yg6.semTaskDW9YG6.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private Date birthDate;
	
	private String specializing;
	
	private Integer employedAt;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSpecializing() {
		return specializing;
	}

	public void setSpecializing(String specializing) {
		this.specializing = specializing;
	}

	public Integer getEmployedAt() {
		return employedAt;
	}

	public void setEmployedAt(Integer employedAt) {
		this.employedAt = employedAt;
	}

}
