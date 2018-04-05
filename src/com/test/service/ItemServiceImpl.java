package com.test.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ItemsMapper;
import com.test.pojo.Items;
import com.test.pojo.ItemsExample;

@Service
public class ItemServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;

	/**
	 * 查询所有商品
	 */
	@Override
	public List<Items> list() throws Exception {
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	/**
	 * 按id查询
	 */
	@Override
	public Items findById(int id) throws Exception {
		Items item = itemsMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public void update(Items item) throws Exception {

		itemsMapper.updateByPrimaryKeyWithBLOBs(item);
	}

	

	

	
}
