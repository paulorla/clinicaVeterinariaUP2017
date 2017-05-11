package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Especie;

public class AnimalDAO implements IGenericDAO<Animal, Long>{

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	@Override
	public List<Animal> listar() throws Exception {
		List<Animal> retorno = new ArrayList<Animal>();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT id,nome,nascimento FROM ANIMAL";
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Animal a = new Animal();
				
				a.setId(resultSet.getLong("id"));
				a.setNome(resultSet.getString("nome"));
				a.setNascimento(resultSet.getDate("nascimento"));
				
				retorno.add(a);
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
	public Animal buscar(Long id) throws Exception {
		Animal retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT nome,nascimento FROM ANIMAL where id=?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				retorno = new Animal();
				
				retorno.setId(id);
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
	
	public Animal buscarEager(Long id) throws Exception {
		Animal retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT a.nome as nomeanimal, "
					+ "a.nascimento as nascimentoanimal, "
					+ "e.id as idespecie, e.nome as nomeespecie, "
					+ "e.descricao as descricaoespecie "
					+ "FROM ANIMAL a "
					+ "INNER JOIN especie e on (a.especie_id = e.id) "
					+ "where id=?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				retorno = new Animal();
				
				retorno.setId(id);
				retorno.setNome(resultSet.getString("nomeanimal"));
				retorno.setNascimento(resultSet.getDate("nascimentoanimal"));
				
				Especie e = new Especie();
				e.setId(resultSet.getLong("idespecie"));
				e.setNome(resultSet.getString("nomeespecie"));
				e.setDescricao("descricaoespecie");
				retorno.setEspecie(e);
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
	public void persistir(Animal objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Animal objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
