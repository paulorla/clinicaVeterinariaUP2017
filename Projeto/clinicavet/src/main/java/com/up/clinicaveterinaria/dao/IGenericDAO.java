package com.up.clinicaveterinaria.dao;

import java.util.List;

public interface IGenericDAO<T,U> {
	public List<T> listar() throws Exception;
	public T find(U id) throws Exception;
}