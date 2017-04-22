package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.Dono;

public class DonoDAO {
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public List<Dono> listar() throws Exception{
		List<Dono> retorno = new ArrayList<Dono>();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
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
			throw new Exception("Ocorreu um erro ao executar a consulta", e);
		}finally{
			try{//Note que caso ocorra uma exception, vamos deixar componentes abertos.
				if(resultSet != null)
					resultSet.close();
				if(statement != null)
					statement.close();
				if(con != null)
					con.close();
			}catch(Exception e){
				throw new Exception("Ocorreu um erro ao executar a consulta", e);
			}
		}
	}
}