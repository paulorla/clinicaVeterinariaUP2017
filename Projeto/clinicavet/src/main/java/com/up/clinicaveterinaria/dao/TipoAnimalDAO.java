package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.TipoAnimal;

public class TipoAnimalDAO implements IGenericDAO<TipoAnimal, String>{

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	@Override
	public List<TipoAnimal> listar() throws Exception {
		List<TipoAnimal> retorno = new ArrayList<TipoAnimal>();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT acronimo,nome,descricao FROM TIPO_ANIMAL";
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				TipoAnimal ta = new TipoAnimal();
				
				ta.setAcronimo(resultSet.getString("acronimo"));
				ta.setNome(resultSet.getString("nome"));
				ta.setDescricao(resultSet.getString("descricao"));
				
				retorno.add(ta);
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
	public TipoAnimal find(String id) throws Exception {
		TipoAnimal retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT nome,descricao FROM TIPO_ANIMAL where acronimo=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				retorno = new TipoAnimal();
				
				retorno.setAcronimo(id);
				retorno.setNome(resultSet.getString("nome"));
				retorno.setDescricao(resultSet.getString("descricao"));
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
