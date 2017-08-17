package com.up.clinicaveterinaria;

import com.up.clinicaveterinaria.dao.GenericDAO;
import com.up.clinicaveterinaria.facade.AnimalFacade;
import com.up.clinicaveterinaria.model.Animal;

public class Main {
	public static void main(String[] args) {
		try{
			AnimalFacade animalFacade = new AnimalFacade();
			Animal a = animalFacade.find(0);
			System.out.println(a.getNome());
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!");
	}
}