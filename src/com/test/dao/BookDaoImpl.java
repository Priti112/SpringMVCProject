package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.model.Book;


public class BookDaoImpl implements BookDao {
String sql;
JdbcTemplate template;	
	
   public void setTemplate(JdbcTemplate template) {
	   this.template = template;
   }
	
	@Override
	public int insert(Book book) {
		sql = "insert into book(name, price) values(?,?)";
		return template.update(sql,book.getName(),book.getPrice());
	}

	@Override
	public List<Book> listAll() {
		sql = "select * from book";
		return template.query(sql, new RowMapper<Book>(){

			@Override
			public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Book book = new Book();
				book.setId(resultSet.getInt(1));
				book.setName(resultSet.getString(2));
				book.setPrice(Float.parseFloat(resultSet.getString(3)));
				return book;
			}
			
		});
	}

	@Override
	public int update(Book book) {
		sql = "update book set name = ?, price = ? where id = ?";
		return template.update(sql,book.getName(),book.getPrice(),book.getId());
	}

	@Override
	public Book GetById(int id) {
		sql = "select * from book where id = ?";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public int delete(int id) {
		sql = "delete from book where id = ?";
		return template.update(sql, id);
	}

	

}
