package com.up.clinicaveterinaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.clinicaveterinaria.model.Alergia;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.model.Vacina;
import com.up.clinicaveterinaria.model.VacinaAnimal;

public class Main {
	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica_pu");
			EntityManager em =factory.createEntityManager();
			
			Animal a = null;
			em.getTransaction().begin();
			a = em.find(Animal.class, 4);
			em.getTransaction().commit();
			
			System.out.println(a.getNome());
			
			for(Alergia al : a.getAlergias()){
				System.out.println("\t" + al.getNomeAlergia());
			}
			em.close();
			factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}