package com.test.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.Items;
import com.test.service.ItemsService;


@Controller
public class ItemsController {

	@Autowired
	private ItemsService itmesService;
	
	@RequestMapping("/list")
	public ModelAndView itemsList() throws Exception{
		List<Items> list = itmesService.list();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		
		return modelAndView;
	}
	
	/**
	 * HttpServletRequest
	 * HttpServletResponse
	 * HttSession
	 * Model
	 * 以上四个为Springmvc默认支持的参数类型 
	 */
	@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest request,Model model) throws Exception{
		
		String idStr = request.getParameter("id");
		Items item = itmesService.findById(Integer.parseInt(idStr));
		
		model.addAttribute("item",item);
		
		//若返回为一个字符串，则springmvc认为，这是一个页面的名称
		return "editItem";
		
	}
	/**
	 * 更新
	 * controller方法中的参数与jsp页面中<input>中name属性值一致。id,name,price,detail...
	 * public String update(Integer id, String name, Float price, String detail) throws Exception{
	 * 也可直接将pojo类作为参数，（pojo类的属性值与<input>的name属性值一致，即可）
	 */
	@RequestMapping("/updateItem")
    public String update(Items item) throws Exception{
		
		//item.setCreatetime(new Date());
		itmesService.update(item);
		return "success";
	}
	
	
	
	
	
	
	
	
	
}
