package com.unicorn.korzo.humans;

import java.util.List;

public interface HumanDAO {
	boolean add(Human human);
	boolean remove(Human human);
	boolean update(Human human);
	List<Human> findAll();
	List<Human> findByCriteria();
	List<Human> findByAge();

}
