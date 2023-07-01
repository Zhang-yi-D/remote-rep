package com.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtils {
    static ThreadLocal<Connection> threadLocal = new ThreadLocal();
    private String driverClass;
    private String url;
    private String username;
    private String password;
    public ConnectionUtils(String jdbcPath) {
        this.init(jdbcPath);
    }
    public void init(String jdbcPath) {
        Properties properties = new Properties();

        try {
            InputStream inputStream = new FileInputStream(jdbcPath);
            Throwable var4 = null;

            try {
                properties.load(inputStream);
                String driverClassName = properties.getProperty("jdbc.driverClass");
                this.driverClass = driverClassName;
                this.url = properties.getProperty("jdbc.url");
                this.username = properties.getProperty("jdbc.username");
                this.password = properties.getProperty("jdbc.password");
            } catch (Throwable var14) {
                var4 = var14;
                throw var14;
            } finally {
                if (inputStream != null) {
                    if (var4 != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var13) {
                            var4.addSuppressed(var13);
                        }
                    } else {
                        inputStream.close();
                    }
                }

            }
        } catch (Exception var16) {
            var16.printStackTrace();
        }

    }

    public Connection getConnection() {
        Connection connection = null;
        boolean isExist = true;
        boolean isClosed = false;

        try {
            if (threadLocal.get() == null) {
                isExist = false;
            } else if (((Connection)threadLocal.get()).isClosed()) {
                isClosed = true;
            }

            if (isExist && !isClosed) {
                connection = (Connection)threadLocal.get();
            } else {
                if (isClosed) {
                    threadLocal.remove();
                }

                Class.forName(this.driverClass);
                connection = DriverManager.getConnection(this.url, this.username, this.password);
                threadLocal.set(connection);
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return connection;
    }
}
