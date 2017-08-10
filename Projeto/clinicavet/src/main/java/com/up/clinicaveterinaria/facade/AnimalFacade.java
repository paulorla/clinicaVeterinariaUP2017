package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.AnimalDAO;
import com.up.clinicaveterinaria.model.Animal;

public class AnimalFacade implements IGenericFacade<Integer, Animal>{

	private AnimalDAO dao = new AnimalDAO();

	@Override
	public void save(Animal animal) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(animal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void update(Animal animal) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(animal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	@Override
	public Animal find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Animal animal = dao.find(id);
			dao.commitAndCloseTransaction();
			return animal;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Animal animal = dao.findReferenceOnly(id);
			dao.delete(animal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public Animal findReferenceOnly(Integer entityID) throws Exception {
		try {
			dao.beginTransaction();
			Animal animal = dao.findReferenceOnly(entityID);
			dao.commitAndCloseTransaction();
			return animal;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}