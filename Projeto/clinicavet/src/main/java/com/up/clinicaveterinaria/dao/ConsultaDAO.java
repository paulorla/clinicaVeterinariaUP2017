package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Consulta;
import com.up.clinicaveterinaria.model.ConsultaId;
import com.up.clinicaveterinaria.model.Funcionario;

public class ConsultaDAO implements IGenericDAO<Consulta, ConsultaId>{
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	@Override
	public List<Consulta> listar() throws Exception {
		List<Consulta> retorno = new ArrayList<Consulta>();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT animal_id,datahora_consulta,"
					+ "funcionario_agend_id,veterinario_id FROM CONSULTA";
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Consulta c = new Consulta();
				
				Animal a = new Animal();
				a.setId(resultSet.getLong("animal_id"));
				c.setAnimal(a);
				
				c.setDataHoraConsulta(new Date(
						resultSet.getTimestamp("datahora_consulta").getTime()));
				
				Funcionario fAgend = new Funcionario();
				fAgend.setId(resultSet.getLong("funcionario_agend_id"));
				c.setResponsavelAgendamento(fAgend);
				
				Funcionario vet = new Funcionario();
				vet.setId(resultSet.getLong("veterinario_id"));
				c.setVeterinario(vet);
				
				retorno.add(c);
			}
			return retorno;
		}catch(Exception e){
			exp = e;
		}finally{
			try{
				if(resultSet != null)
					resultSet.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(statement != null)
					statement.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(con != null)
					con.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
		}
		throw exp;//lançando somente a última exceção gerada para simplificar!
	}

	@Override
	public Consulta buscar(ConsultaId id) throws Exception {
		Consulta retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT animal_id,datahora_consulta,"
					+ "funcionario_agend_id,veterinario_id FROM CONSULTA where animal_id=? and datahora_consulta=?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, id.getAnimal().getId());
			statement.setDate(2, new java.sql.Date(id.getDataHoraConsulta().getTime()));
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				retorno = new Consulta();
				
				Animal a = new Animal();
				a.setId(resultSet.getLong("animal_id"));
				retorno.setAnimal(a);
				
				retorno.setDataHoraConsulta(new Date(
						resultSet.getTimestamp("datahora_consulta").getTime()));
				
				Funcionario fAgend = new Funcionario();
				fAgend.setId(resultSet.getLong("funcionario_agend_id"));
				retorno.setResponsavelAgendamento(fAgend);
				
				Funcionario vet = new Funcionario();
				vet.setId(resultSet.getLong("veterinario_id"));
				retorno.setVeterinario(vet);
			}
			return retorno;
		}catch(Exception e){
			exp = e;
		}finally{
			try{
				if(resultSet != null)
					resultSet.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(statement != null)
					statement.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(con != null)
					con.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
		}
		throw exp;//lançando somente a última exceção gerada para simplificar!
	}

	@Override
	public void persistir(Consulta objeto) throws Exception {
		Connection con=null;
		PreparedStatement statement = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "INSERT INTO CONSULTA (animal_id, datahora_consulta, funcionario_agend_id, "
					+ " veterinario_id) VALUES (?,?,?,?)";
			
			statement = con.prepareStatement(sql);
			statement.setLong(1, objeto.getAnimal().getId());
			statement.setDate(2,new java.sql.Date(objeto.getDataHoraConsulta().getTime()));
			statement.setLong(3, objeto.getResponsavelAgendamento().getId());
			statement.setLong(4, objeto.getVeterinario().getId());
			
			statement.executeUpdate();
			return;
		}catch(Exception e){
			exp = e;
		}finally{
			try{
				if(statement != null)
					statement.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(con != null)
					con.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
		}
		throw exp;//lançando somente a última exceção gerada para simplificar!
	}

	@Override
	public void remover(ConsultaId id) throws Exception {
		Connection con=null;
		PreparedStatement statement = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "DELETE FROM CONSULTA WHERE animal_id=? AND datahora_consulta=?";
			
			statement = con.prepareStatement(sql);
			statement.setLong(1, id.getAnimal().getId());
			statement.setDate(2,new java.sql.Date(id.getDataHoraConsulta().getTime()));
			
			statement.executeUpdate();
			return;
		}catch(Exception e){
			exp = e;
		}finally{
			try{
				if(statement != null)
					statement.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(con != null)
					con.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
		}
		throw exp;//lançando somente a última exceção gerada para simplificar!		
	}

	@Override
	public void atualizar(Consulta objeto) throws Exception {
		Connection con=null;
		PreparedStatement statement = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "UPDATE CONSULTA set funcionario_agend_id=?, "
					+ " veterinario_id=? WHERE animal_id=? AND datahora_consulta=?";
			
			statement = con.prepareStatement(sql);
			statement.setLong(1, objeto.getResponsavelAgendamento().getId());
			statement.setLong(2, objeto.getVeterinario().getId());
			statement.setLong(3, objeto.getAnimal().getId());
			statement.setDate(4, 
					new java.sql.Date(objeto.getDataHoraConsulta().getTime()));
			
			statement.executeUpdate();
			return;
		}catch(Exception e){
			exp = e;
		}finally{
			try{
				if(statement != null)
					statement.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
			try{
				if(con != null)
					con.close();
			}catch(Exception e){
				exp = e;
				//logar exceção
			}
		}
		throw exp;//lançando somente a última exceção gerada para simplificar!
	}
}
