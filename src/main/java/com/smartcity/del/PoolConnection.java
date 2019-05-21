package com.smartcity.del;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PoolConnection {

    private static Properties properties;
    private static ComboPooledDataSource dataSource;
    static{
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/application-dev.properties"));

            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(properties.getProperty("db.driverClassName"));
            dataSource.setJdbcUrl(properties.getProperty("db.url"));
            dataSource.setUser(properties.getProperty("db.username"));
            dataSource.setPassword(properties.getProperty("db.password"));

            dataSource.setMinPoolSize(5);
            dataSource.setMaxPoolSize(20);
            dataSource.setAcquireIncrement(3);

        } catch (PropertyVetoException | IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }


//    static {
//        try {
//            ComboPooledDataSource cpds = new ComboPooledDataSource("db");
//            cpds.setDriverClass(properties"db.driverClassName");
//            cpds.setJdbcUrl("db.url");
//            cpds.setUser("db.username");
//            cpds.setPassword("db.password");
//
//
//            cpds.setMinPoolSize(2);
//            cpds.setAcquireIncrement(3);
//            cpds.setMaxPoolSize(7);
////            cpds.setMaxStatements(50);
//        } catch (Exception e) {
//            throw new DbOperationException(e.getMessage());
//        }
//    }
//
//    public static DataSource getConnection(){
//        return cpds;
//    }
//
//    private PoolConnection(){}
}

