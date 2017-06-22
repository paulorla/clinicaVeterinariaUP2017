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
			
			Dono d = null;
			em.getTransaction().begin();
			d = em.find(Dono.class, 3);
			em.getTransaction().commit();
			
			System.out.println(d.getNome());
			
			for(Animal a : d.getAnimais()){
				System.out.println(a.getNome());
				for(VacinaAnimal va : a.getVacinasAnimal())
					System.out.println("\t" + va.getVacina().getNome() + " " + va.getDataVacinacao());
			}
			em.close();
			factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}