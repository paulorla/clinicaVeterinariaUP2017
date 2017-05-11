package com.up.clinicaveterinaria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.up.clinicaveterinaria.dao.ConsultaDAO;
import com.up.clinicaveterinaria.model.Consulta;

public class Main {
	public static void main(String[] args) {
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			
			ConsultaDAO consultaDAO = new ConsultaDAO();
			List<Consulta> consultas = consultaDAO.listar();
			for(Consulta c : consultas){
				System.out.println(c.getAnimal().getId() +
						"\t" + dateFormat.format(c.getDataHoraConsulta()) + 
						"\t" + c.getVeterinario().getId());
			}
			
			consultas.get(0).getVeterinario().setId(4L);
			consultaDAO.atualizar(consultas.get(0));
			
			consultas = consultaDAO.listar();
			for(Consulta c : consultas){
				System.out.println(c.getAnimal().getId() +
						"\t" + dateFormat.format(c.getDataHoraConsulta()) + 
						"\t" + c.getVeterinario().getId());
			}
			
			Consulta resultadoBuscar = consultaDAO.buscar(consultas.get(0).getConsultaId());
			
			System.out.println(resultadoBuscar.getAnimal().getId() +
					"\t" + dateFormat.format(resultadoBuscar.getDataHoraConsulta()) + 
					"\t" + resultadoBuscar.getVeterinario().getId());
			
			Consulta novaConsulta = new Consulta();
			novaConsulta.setAnimal(resultadoBuscar.getAnimal());
			novaConsulta.setDataHoraConsulta(new Date());
			novaConsulta.setVeterinario(resultadoBuscar.getVeterinario());
			novaConsulta.setResponsavelAgendamento(resultadoBuscar.getResponsavelAgendamento());
			
			consultaDAO.persistir(novaConsulta);
			
			consultaDAO.remover(novaConsulta.getConsultaId());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}