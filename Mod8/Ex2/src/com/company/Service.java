package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Service {
    private DBConnectionPool dbconnectionPool;
    private final String initPath;
    private Statement statement;

    public Service(String initPath) throws IOException, SQLException {
        this.initPath = initPath;
        statement = getConnection().createStatement();
    }

    public Connection getConnection() throws IOException {
        if (dbconnectionPool == null)
            dbconnectionPool = new DBConnectionPool(dbconnectionPool.getURL(),dbconnectionPool.getUser(),
                    dbconnectionPool.getPassword(),dbconnectionPool.getMaxConn());
        return dbconnectionPool.getConnection();
    }

    public void releasedConnection() throws IOException {
        if (!dbconnectionPool.freeConnections.isEmpty())
            dbconnectionPool.released();
    }

    public void init() throws SQLException {
        createInitialState(statement);
    }

    private void createInitialState(Statement statement) throws SQLException {
        String createTableSQL = getInitQuieries(initPath);
        Arrays.stream(createTableSQL.split(";")).filter(x -> (!x.equals("\n"))).forEach(x -> {
            try {
                statement.execute(x);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    private String getInitQuieries(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List strings = Files.readAllLines(Paths.get(path));
            for(Object o:strings){
                stringBuilder.append(o.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}