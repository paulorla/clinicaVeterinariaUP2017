package com.up.clinicaveterinaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.model.Especie;

public class Main {
	public static void main(String[] args) {
		try{
			Especie e = new Especie();
			e.setId(3L);
			
			Especie e2 = new Especie();
			e2.setId(3L);
			
			Dono dono = new Dono();
			dono.setCpf(56789L);
			dono.setNome("Cleide");
			dono.setNascimento(new Date());
			
			Animal a1 = new Animal();
			a1.setDono(dono);
			a1.setEspecie(e);
			a1.setNome("Animal Cleide 1");
			
			Animal a2 = new Animal();
			a2.setDono(dono);
			a2.setEspecie(e2);
			a2.setNome("Animal Cleide 2");
			
			List<Animal> animais = new ArrayList<Animal>();
			animais.add(a1);
			animais.add(a2);
			
			dono.setAnimais(animais);
			DonoDAO donoDAO = new DonoDAO();
			donoDAO.persistirComAnimais(dono);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}