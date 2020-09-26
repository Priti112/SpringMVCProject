package com.test.dao;

import java.util.List;

import com.test.model.Book;

public interface BookDao {
	
	int insert(Book book);
	int update(Book book);
	int delete(int id);
	List<Book> listAll();
	Book GetById(int id);
	

}

