package com.up.clinicaveterinaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.clinicaveterinaria.model.Vacina;

public class Main {
	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica_pu");
			EntityManager em =factory.createEntityManager();
			
			Vacina vacina = null;
			em.getTransaction().begin();
			vacina = em.find(Vacina.class, 2);
			em.getTransaction().commit();
			
			System.out.println(vacina.getNome());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}