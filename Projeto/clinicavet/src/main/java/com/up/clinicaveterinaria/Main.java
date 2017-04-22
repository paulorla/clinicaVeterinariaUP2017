package com.up.clinicaveterinaria;

import java.util.List;

import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.model.Dono;

public class Main {
	public static void main(String[] args) {
		try{
			DonoDAO donoDAO = new DonoDAO();
			List<Dono> donos = donoDAO.listar();
			for(Dono d : donos){
				System.out.println(d.getNome());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println("Fim!");
	}
}