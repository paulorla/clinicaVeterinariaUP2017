package com.up.clinicaveterinaria.mb;

import java.util.List;

import com.up.clinicaveterinaria.facade.AnimalFacade;
import com.up.clinicaveterinaria.model.Animal;

public class CadastroAnimaisMB {

	private AnimalFacade animalFacade = new AnimalFacade();
	private List<Animal> animais;
	
	private Animal animalEdicao;

	public CadastroAnimaisMB() {
		this.carregarListaAnimais();
	}

	public void carregarListaAnimais() {
		animais = animalFacade.listAll();
	}

	public AnimalFacade getAnimalFacade() {
		return animalFacade;
	}

	public void setAnimalFacade(AnimalFacade animalFacade) {
		this.animalFacade = animalFacade;
	}

	public Animal getAnimalEdicao() {
		return animalEdicao;
	}

	public void setAnimalEdicao(Animal animalEdicao) {
		this.animalEdicao = animalEdicao;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	public void salvarAlteracoesAnimal() {
		try {
			animalFacade.update(animalEdicao);
			this.carregarListaAnimais();
		}catch(Exception e) {
			e.printStackTrace();//logar
		}
	}
}