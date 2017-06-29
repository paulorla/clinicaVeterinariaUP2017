package com.up.clinicaveterinaria;

import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.dao.GenericDAO;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;

public class Main {
	public static void main(String[] args) {
		DonoDAO donoDAO = new DonoDAO();
		try{
			donoDAO.beginTransaction();
			Dono d = donoDAO.find(3);
			donoDAO.commitAndCloseTransaction();
			
			System.out.println(d.getNome());
			
			for(Animal a : d.getAnimais())
				System.out.println("\t" + a.getNome());
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!");
	}
}