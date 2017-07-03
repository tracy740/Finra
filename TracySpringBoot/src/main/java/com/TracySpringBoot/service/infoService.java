package com.TracySpringBoot.service;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TracySpringBoot.dao.dao;
import com.TracySpringBoot.model.modelinfo;



@Service
public class infoService {
	@Autowired
	dao DAO;
	
	public void saveIn(modelinfo file) {
		DAO.save(file);
	}
    public modelinfo ById (Integer id) {
			return DAO.findOne(id);
		}

	
}
	

	
	

	
	
	

