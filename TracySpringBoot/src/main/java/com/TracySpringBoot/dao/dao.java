package com.TracySpringBoot.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.TracySpringBoot.model.modelinfo;

public interface dao extends CrudRepository<modelinfo, Integer> {
	
	
	
}
