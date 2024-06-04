package br.parkus.service;

public interface BaseService<T, S> {
	
	public T create(T object);
	public T update(T object);
	public void delete(S id);
}
