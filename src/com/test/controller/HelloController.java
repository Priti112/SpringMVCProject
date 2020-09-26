package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.dao.BookDao;
import com.test.model.Book;

@Controller
public class HelloController {
	
	@Autowired
	BookDao dao;
	
	@RequestMapping("/")
	public String display() {
		return "index";
		
	}
	
	
	@RequestMapping("/viewlist")
	public String priti(Model m) {
		List<Book> list = dao.listAll();
		m.addAttribute("listBook", list);
		return "list";
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveform(@ModelAttribute("book") Book book) {
		if(book.getId() == 0) {
			dao.insert(book);
		}
		else
		{
			dao.update(book);
		}
		return "redirect:/viewlist";
		
	}
	
	
	@RequestMapping("/new")
	public String showform(Model m) {
		//Book b = new Book();
		m.addAttribute("command", new Book());
		return "entry";
		
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editform(@PathVariable int id, Model m) {
		Book book = dao.GetById(id);
		m.addAttribute("command", book);
		return "entry";
		
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteform(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewlist";
		
	}

}
