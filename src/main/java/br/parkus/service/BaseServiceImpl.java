package br.parkus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.parkus.repository.BaseRepository;

public class BaseServiceImpl<T, S> implements BaseService<T, S>{
	
	@Autowired
	protected BaseRepository<T, S> repository;
	
	@Transactional
	@Override
	public T create(T object) {
		beforeCreate(object);
		T obj = repository.save(object);
		afterCreate(obj);
		return obj;
	}

	private void afterCreate(T obj) {

	}

	private void beforeCreate(T object) {

	}

	@Override
	public T update(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(S id) {
		// TODO Auto-generated method stub
		
	}
}
