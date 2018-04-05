package com.test.service;

import java.util.List;


import com.test.pojo.Items;

public interface ItemsService {

	public List<Items> list() throws Exception;

	public Items findById(int id) throws Exception;

	public void update(Items item) throws Exception;
	
}
