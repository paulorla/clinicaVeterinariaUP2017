package com.up.clinicaveterinaria;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Consulta;
import com.up.clinicaveterinaria.model.ConsultaId;
import com.up.clinicaveterinaria.model.Funcionario;

public class Main {
	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica_pu");
			EntityManager em =factory.createEntityManager();
			
			ConsultaId consultaId = new ConsultaId();
			Animal a = null;
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			Date dataConsulta = df.parse("2015/01/01 15:30");
			Consulta consulta = null;
			
			em.getTransaction().begin();
			a = em.find(Animal.class, 4);
			consultaId.setAnimal(a);
			consultaId.setDataHoraConsulta(dataConsulta);
			consulta = em.find(Consulta.class, consultaId);
			
			
			em.getTransaction().commit();
			
			System.out.println(consulta.getAnimal().getNome());
			
			em.close();
			factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}