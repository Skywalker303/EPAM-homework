package com.company.DAO;

import com.company.Entity.Book;

import java.sql.SQLException;

public interface LibraryDAO {

    void insert(Book book) throws SQLException;

    Book get(String name) throws SQLException;

    void remove(String name) throws SQLException;
}