package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.tutorialspoint.eclipselink.entity.Employee;

public class CreateEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEid(1201);
		employee.setEname("Vadon E.");
		employee.setSalary(7);
		employee.setDeg("None");
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		employee.setEid(2);
		employee.setEname("Abc Cba");
		employee.setSalary(5000);
		employee.setDeg("Manager");
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		employee.setEid(3);
		employee.setEname("Kiss Pista");
		employee.setSalary(6050);
		employee.setDeg("HR Employee");
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		employee.setEid(4);
		employee.setEname("Nagy Erno");
		employee.setSalary(20000);
		employee.setDeg("CEO");
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}