package com.up.clinicaveterinaria;

import java.util.List;

import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.dao.EnderecoDAO;
import com.up.clinicaveterinaria.dao.GenericDAO;
import com.up.clinicaveterinaria.facade.AnimalFacade;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.model.Endereco;

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