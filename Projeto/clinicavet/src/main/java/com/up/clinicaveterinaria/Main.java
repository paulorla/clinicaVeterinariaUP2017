package com.up.clinicaveterinaria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.up.clinicaveterinaria.dao.AnimalDAO;
import com.up.clinicaveterinaria.dao.ConsultaDAO;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Consulta;

public class Main {
	public static void main(String[] args) {
		try{
			AnimalDAO animalDAO = new AnimalDAO();
			Animal animal = animalDAO.buscarEager(4L);
			
			System.out.println(animal.getNome() + "\t" + animal.getEspecie().getNome());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}