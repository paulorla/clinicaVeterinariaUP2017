package com.up.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.jdbc.ConnectionFactory;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.model.Especie;
import com.up.clinicaveterinaria.model.TipoAnimal;

public class EspecieDAO implements IGenericDAO<Especie, Long>{
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public Especie buscarEager(Long id) throws Exception{
		Especie retorno = null;
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Exception exp = null;
		try{
			con = connectionFactory.getConnection();
			String sql = "select e.nome as nomeespecie, e.descricao as descricaoespecie,"
						+ " t.acronimo, t.nome as nomeTipo, t.descricao as descricaoTipo,"
						+ " a.id as animalid, a.nome as nomeanimal, a.nascimento, a.dono_id as donoid"
						+ " from especie e"
						+ " inner join tipo_animal t on (e.tipo_animal_acronimo = t.acronimo)"
						+ " inner join animal a on (a.especie_id = e.id)"
						+ " where e.id=?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				retorno = new Especie();
				
				retorno.setId(id);
				retorno.setNome(resultSet.getString("nomeespecie"));
				retorno.setDescricao(resultSet.getString("descricaoespecie"));
				
				TipoAnimal ta = new TipoAnimal();
				ta.setAcronimo(resultSet.getString("acronimo"));
				ta.setNome(resultSet.getString("nomeTipo"));
				ta.setDescricao(resultSet.getString("descricaoTipo"));
				retorno.setTipoAnimal(ta);
				
				List<Animal> animais = new ArrayList<Animal>();
				resultSet.getLong("animalid");
				do{
					if(!resultSet.wasNull()){
						Animal a = new Animal();
						a.setId(resultSet.getLong("animalid"));
						a.setNome(resultSet.getString("nomeanimal"));
						a.setNascimento(resultSet.getDate("nascimento"));
						
						Dono d = new Dono();
						d.setId(resultSet.getLong("donoid"));
						a.setDono(d);
						
						animais.add(a);
					}
				}while(resultSet.next());
				
				retorno.setAnimaisEspecie(animais);
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
	public List<Especie> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Especie buscar(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistir(Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}
}