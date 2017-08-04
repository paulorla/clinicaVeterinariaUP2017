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
			Dono d = donoDAO.findByCPF(123456789L);
			System.out.println(d.getNome());
			System.out.println(d.getEndereco().getCidade());
			donoDAO.commitAndCloseTransaction();
			
			d.setNome("Maria 4");
			
			donoDAO.beginTransaction();
			donoDAO.update(d);
			donoDAO.commitAndCloseTransaction();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!");
	}
}