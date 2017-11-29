package com.company.DAOImp;

import com.company.DAO.AuthorDAO;
import com.company.DAO.LibraryDAO;
import com.company.Entity.Author;
import com.company.Entity.Book;

import java.sql.*;

public class LibraryDAOImp implements LibraryDAO {
    private Connection connection;


    public LibraryDAOImp(Connection connection) {
        this.connection = connection;

    }

    @Override
    public void insert(Book book) throws SQLException {
        AuthorDAO authorDAO = new AuthorDAOImp(connection);
        authorDAO.insert(book.getAuthor());
        int authorID;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT id FROM LibraryDB.AUTHOR" +
                    " WHERE(FIRST_NAME = '" + book.getAuthor().getFirstName() +
                    "' AND LAST_NAME = '" + book.getAuthor().getLastName() + "');");
            rs.next();
            authorID = rs.getInt(3);
            String query2 = "INSERT INTO LibraryDB.BOOK (Title, Author_id) VALUES ('" +
                    book.getName() + "', " + authorID + ");";
            st.execute(query2);
        }
    }

    @Override
    public Book get(String name) throws SQLException {
        Author author;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT LibraryDB.BOOK.Title, LibraryDB.AUTHORS.FIRST_NAME," +
                    " LibraryDB.AUTHORS.LAST_NAME  + ';'");
            rs.next();
            author = new Author(rs.getString(1), rs.getString(2));
            return new Book(rs.getString(1), author);
        }
    }


    @Override
    public void remove(String name) throws SQLException {
        String query = "DELETE FROM LibraryDB.BOOK " +
                " WHERE(NAME = '" + name + "');";
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        }
    }
}
