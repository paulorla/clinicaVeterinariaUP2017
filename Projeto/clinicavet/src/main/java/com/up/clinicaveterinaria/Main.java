package com.up.clinicaveterinaria;

import java.util.List;

import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.dao.GenericDAO;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;

public class Main {
	public static void main(String[] args) {
		DonoDAO donoDAO = new DonoDAO();
		try{
			donoDAO.beginTransaction();
			List<Dono> donos = donoDAO.listarPessoasQuePossuemTipoAnimal("GAT");
			
			for(Dono d : donos)
				System.out.println(d.getNome());
			donoDAO.commitAndCloseTransaction();
			
			donoDAO.beginTransaction();
			Dono d = donoDAO.find(3);
			System.out.println(d.getNome());
			for(Animal a : d.getAnimais())
				System.out.println(a.getNome());
			
			donoDAO.commitAndCloseTransaction();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!");
	}
}