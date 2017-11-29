package com.company.DAOImp;


import com.company.DAO.AuthorDAO;
import com.company.Entity.Author;

import java.sql.*;

public class AuthorDAOImp implements AuthorDAO {
    private Connection connection;

    public AuthorDAOImp(Connection connection) {
        this.connection = connection;

    }

    @Override
    public void insert(Author author) throws SQLException {
        String firstName = author.getFirstName();
        String lastName = author.getLastName();
        String query = "INSERT INTO LibraryDB.AUTHORS (FIRSTNAME, LASTNAME)" +
                "SELECT * FROM (SELECT '" +
                firstName + "', '" + lastName + "') AS tmp " +
                "WHERE NOT EXISTS (SELECT FIRSTNAME FROM LibraryDB.AUTHORS WHERE FIRSTNAME = '" + firstName
                + "' AND LASTNAME = '" + lastName + "') LIMIT 1 ;";
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        }

    }

    @Override
    public Author get(String firstName, String lastName) throws SQLException {
        Author author;
        String query = "SELECT FIRSTNAME, LASTNAME FROM LibraryDB.AUTHORS " +
                " WHERE(FIRSTNAME = '" + firstName + "' AND LASTNAME = '" + lastName + "');";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            rs.next();
            author = new Author(rs.getString(1), rs.getString(2));
        }
        return author;
    }


    @Override
    public void remove(String firstName, String lastName) throws SQLException {
        String query = "DELETE FROM LibraryDB.AUTHORS " +
                " WHERE('" + firstName + "' = FIRSTNAME AND LASTNAME = '" + lastName + "');";
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        }
    }


}
