package com.company;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBConnectionPool {
        List<Connection> freeConnections = new ArrayList<Connection>();
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "root";
        int maxConn = 5;

        DBConnectionPool(String URL, String user, String password, int maxConn) {
                this.URL = URL;
                this.user = user;
                this.password = password;
                this.maxConn = maxConn;
                loadDrivers();
        }

        public String getURL() {
                return URL;
        }

        public String getUser() {
                return user;
        }

        public String getPassword() {
                return password;
        }

        public int getMaxConn() {
                return maxConn;
        }

        private void loadDrivers() {
                try {
                        Driver driver = (Driver) Class.forName("JDBC_DRIVER").newInstance();
                        DriverManager.registerDriver(driver);
                } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                } catch (InstantiationException e1) {
                        e1.printStackTrace();
                } catch (SQLException e1) {
                        e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                }
        }

        public synchronized Connection getConnection() {
                Connection con = null;
                if (!freeConnections.isEmpty()) {
                        con = (Connection) freeConnections.get(freeConnections.size() - 1);
                        freeConnections.remove(con);
                        try {
                                if (con.isClosed()) {
                                        con = getConnection();
                                }
                        } catch (SQLException e) {
                                con = getConnection();
                        } catch (Exception e) {
                                con = getConnection();
                        }
                } else {
                        con = newConnection();
                }
                return con;
        }

        private Connection
        newConnection() {
                Connection con = null;
                try {
                        if (user == null) {
                                con = DriverManager.
                                        getConnection(URL);
                        } else {
                                con = DriverManager.
                                        getConnection(URL, user, password);
                        }
                } catch (SQLException e) {
                        return null;
                }
                return con;
        }

        public synchronized void freeConnection(Connection con) {
                if ((con != null) &&
                        (freeConnections.size() <= maxConn)) {
                        freeConnections.add(con);
                }
        }

        public synchronized void released() {
                Iterator allConnections = freeConnections.iterator();
                while (allConnections.hasNext()) {
                        Connection con = (Connection) allConnections.next();
                        try {
                                con.close();
                        } catch (SQLException e) {
                        }
                }
                freeConnections.clear();
        }
}