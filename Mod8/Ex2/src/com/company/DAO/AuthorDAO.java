package com.company.DAO;

import com.company.Entity.Author;
import java.sql.SQLException;

public interface AuthorDAO {

    void insert(Author author) throws SQLException;

    Author get(String firstName, String lastName) throws SQLException;

    void remove(String firstName, String lastName) throws SQLException;

}
