package com.kang.db.transcation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kang on 16-6-1.
 */
public class TranscationTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=UTF-8","root","root");

            DatabaseMetaData metaData= conn.getMetaData();

            //是否支持事件
            boolean isSupportTranscation= metaData.supportsTransactions();
            System.out.println(isSupportTranscation);

            //判断事件是否支持某种隔离级别
            boolean a= metaData.supportsTransactionIsolationLevel(4);

            System.out.println(a);
            //获取默认的事件隔离级别
            System.out.println(metaData.getDefaultTransactionIsolation());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
