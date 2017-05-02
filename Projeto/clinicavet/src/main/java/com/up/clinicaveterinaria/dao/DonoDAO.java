package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.Dono;

public class DonoDAO implements IGenericDAO<Dono, Long>{
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public List<Dono> listar() throws Exception{
		List<Dono> retorno = new ArrayList<Dono>();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT id,cpf,nome,nascimento FROM DONO";
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Dono d = new Dono();
				
				d.setId(resultSet.getLong("id"));
				d.setCpf(resultSet.getLong("cpf"));
				d.setNome(resultSet.getString("nome"));
				d.setNascimento(resultSet.getDate("nascimento"));
				
				retorno.add(d);
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
	public Dono find(Long id) throws Exception {
		Dono retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT cpf,nome,nascimento FROM DONO where id=?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				retorno = new Dono();
				
				retorno.setId(id);
				retorno.setCpf(resultSet.getLong("cpf"));
				retorno.setNome(resultSet.getString("nome"));
				retorno.setNascimento(resultSet.getDate("nascimento"));
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
}