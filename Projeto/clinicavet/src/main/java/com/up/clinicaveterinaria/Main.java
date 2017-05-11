package com.up.clinicaveterinaria;

import com.up.clinicaveterinaria.dao.AnimalDAO;
import com.up.clinicaveterinaria.model.Animal;

public class Main {
	public static void main(String[] args) {
		try{
			AnimalDAO animalDAO = new AnimalDAO();
			Animal animal = animalDAO.buscarEager(4L);
			
			System.out.println(animal.getNome() + "\t" + animal.getEspecie().getNome()
					+ "\t" + animal.getDono().getNome());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}