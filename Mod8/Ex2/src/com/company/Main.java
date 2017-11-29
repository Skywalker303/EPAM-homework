package com.company;

import com.company.DAO.AuthorDAO;
import com.company.DAO.LibraryDAO;
import com.company.DAOImp.AuthorDAOImp;
import com.company.DAOImp.LibraryDAOImp;
import com.company.Entity.Author;
import com.company.Entity.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            String initPath = "IdeaProjects/src/main/resources/Mod8.Ex2/base.sql";
            Service service = new Service(initPath);
            service.init();
            Connection connection = service.getConnection();
            AuthorDAO authorDAO = new AuthorDAOImp(connection);
            LibraryDAO libraryDAO = new LibraryDAOImp(connection);
            insertInitials(authorDAO, libraryDAO);
            libraryDAO.get("For whom the bell tolls");
            libraryDAO.insert(new Book("The Old man and the sea", authorDAO.get("Ernest", "Hemingway")));
            libraryDAO.remove("Harry Potter");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertInitials(AuthorDAO authorDAO, LibraryDAO libraryDAO) throws SQLException {

        Author author1 = new Author("Ernest", "Hemingway");
        Author author2 = new Author("Johan", "Goethe");
        Book book1 = new Book("Faust", author2);
        Book book2 = new Book("For whom the bell tolls", author1);

            authorDAO.insert(author1);
            authorDAO.insert(author2);
            libraryDAO.insert(book1);
            libraryDAO.insert(book2);

    }
}

