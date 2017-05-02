package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioDAO implements IGenericDAO<Funcionario, Long>{

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	@Override
	public List<Funcionario> listar() throws Exception {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT id,nome,cpf,nascimento,dataadmissao FROM FUNCIONARIO";
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Funcionario f = new Funcionario();
				
				f.setId(resultSet.getLong("id"));
				f.setNome(resultSet.getString("nome"));
				f.setCpf(resultSet.getLong("cpf"));
				f.setNascimento(resultSet.getDate("nascimento"));
				f.setDataAdmissao(resultSet.getDate("dataadmissao"));
				
				retorno.add(f);
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
	public Funcionario find(Long id) throws Exception {
		Funcionario retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "SELECT nome,cpf,nascimento,dataadmissao FROM FUNCIONARIO WHERE id=?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				retorno = new Funcionario();
				
				retorno.setId(id);
				retorno.setNome(resultSet.getString("nome"));
				retorno.setCpf(resultSet.getLong("cpf"));
				retorno.setNascimento(resultSet.getDate("nascimento"));
				retorno.setDataAdmissao(resultSet.getDate("dataadmissao"));
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
