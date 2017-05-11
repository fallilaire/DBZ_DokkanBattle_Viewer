package fr.allilaire.dbz.dokkanbattle.web.persistence;

import java.util.List;

public interface IDAO<T> {

	public List<T> findAll();
	public T findOneById(Integer id);
	public void create(T dto);
	public void createAll(List<T> dtos);
	
}
