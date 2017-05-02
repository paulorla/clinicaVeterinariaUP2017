package com.up.clinicaveterinaria;

import java.util.List;

import com.up.clinicaveterinaria.dao.AlergiaDAO;
import com.up.clinicaveterinaria.dao.AnimalDAO;
import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.dao.FuncionarioDAO;
import com.up.clinicaveterinaria.dao.TipoAnimalDAO;
import com.up.clinicaveterinaria.model.Alergia;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.model.TipoAnimal;

public class Main {
	public static void main(String[] args) {
		try{
			DonoDAO donoDAO = new DonoDAO();
			
			List<Dono> donos = donoDAO.listar();
			for(Dono d : donos){
				System.out.println(d.getNome());
			}
			Dono buscaDonoPorId = donoDAO.find(donos.get(0).getId());
			System.out.println();
			System.out.println(buscaDonoPorId.getNome());
			System.out.println();
			
			AlergiaDAO alergiaDAO = new AlergiaDAO();
			List<Alergia> alergias = alergiaDAO.listar();
			for(Alergia a : alergias){
				System.out.println(a.getNomeAlergia());
			}
			
			Alergia buscaAlergiaPorId = alergiaDAO.find(alergias.get(0).getId());
			System.out.println();
			System.out.println(buscaAlergiaPorId.getNomeAlergia());
			System.out.println();
			
			TipoAnimalDAO tipoAnimalDAO = new TipoAnimalDAO();
			List<TipoAnimal> tiposAnimal = tipoAnimalDAO.listar();
			for(TipoAnimal ta : tiposAnimal){
				System.out.println(ta.getNome());
			}
			
			TipoAnimal buscaTipoAnimalPorId = tipoAnimalDAO.find(tiposAnimal.get(0).getAcronimo());
			System.out.println();
			System.out.println(buscaTipoAnimalPorId.getNome());
			System.out.println();
			
			AnimalDAO animalDAO = new AnimalDAO();
			List<Animal> animais = animalDAO.listar();
			for(Animal a : animais){
				System.out.println(a.getNome() +"\t" + a.getNascimento());
			}
			
			Animal animal = animalDAO.find(animais.get(0).getId());
			System.out.println();
			System.out.println(animal.getNome());
			System.out.println();
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			List<Funcionario> funcionarios = funcionarioDAO.listar();
			for(Funcionario f : funcionarios){
				System.out.println(f.getNome() +"\t" + f.getCpf());
			}
			
			Funcionario funcionario = funcionarioDAO.find(funcionarios.get(0).getId());
			System.out.println();
			System.out.println(funcionario.getNome());
			System.out.println();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fim!");
	}
}