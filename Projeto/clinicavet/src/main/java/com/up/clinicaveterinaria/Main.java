package com.up.clinicaveterinaria;

import com.up.clinicaveterinaria.dao.EspecieDAO;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Especie;

public class Main {
	public static void main(String[] args) {
		try{
			EspecieDAO especieDAO = new EspecieDAO();
			Especie especie = especieDAO.buscarEager(3L);
			System.out.println(especie.getNome());
			System.out.println(especie.getTipoAnimal().getNome());
			for(Animal a : especie.getAnimaisEspecie()){
				System.out.println(a.getNome());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}