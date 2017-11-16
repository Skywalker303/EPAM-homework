package com.company;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("не удалось загрузить класс драйвера");
        }

        DBWorker worker = new DBWorker();

        String query = "select * from User where BusinessArea like 'Automobile'";


        try{
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setBusinessArea(resultSet.getString(2));
                user.setYearsOnMarket(resultSet.getInt(3));
                user.setPotentialMarketShare(resultSet.getDouble(4));
                user.setTagsAboutProductSpecific(resultSet.getString(5));
                user.setLocation(resultSet.getString(6));

                int res = statement.executeUpdate("UPDATE User SET BusinessArea = 'Clothes' WHERE id=1");
                statement.addBatch("INSERT INTO User(id,BusinessArea,YearsOnMarket,TagsAboutProduct,Location) VALUES ('4','Automobile','2','car','Moscow')");
                statement.addBatch("INSERT INTO User(id,BusinessArea,YearsOnMarket,TagsAboutProduct,Location) VALUES ('5','Clothes','3','shirts,jackets','Saint-Petersburg')");
                statement.addBatch("INSERT INTO User(id,BusinessArea,YearsOnMarket,TagsAboutProduct,Location) VALUES ('6','Pharmacy','1','medicine','Kazan')");

                System.out.println(user);
                System.out.println(res);
                statement.executeUpdate("DROP TABLE User");
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
