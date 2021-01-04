package com.sebastian.reczy.belajar.jsp.config;

import com.sebastian.reczy.belajar.jsp.model.Jurusan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseKonfigurasi {

    String url = "jdbc:mysql://localhost/javaweb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "$2a$10$C.FTYIsRycBfmlbYEU4KaekEdfUfdLY1taFd9Azmah/bu4TJca9wC";
    String password = "$2a$10$JwbcvLTTjzpWyebo/CUS2ef3rkdzbgOFuiKjeG1RW5NcYyI1BtZJS";

    public DataSource getDataSource() {
        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setUrl(url);
        dbcp.setUsername(username);
        dbcp.setPassword(password);
        return dbcp;

    }

    public List<Jurusan> showData() throws SQLException {
        List<Jurusan> listData = new ArrayList<>();
        Connection connection = new DatabaseKonfigurasi().getDataSource().getConnection();
        String show = "SELECT * FROM s_jurusan";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(show);

        while (rs.next()) {
            Jurusan ju = new Jurusan();
            System.out.println("'"+rs.getString("id"));
            System.out.println(""+ rs.getString("jurusan"));
           
            listData.add(ju);
        }
        connection.close();
        st.close();
        rs.close();
        return listData;
    }

    public static void main(String[] args) throws SQLException {
        DatabaseKonfigurasi connect = new DatabaseKonfigurasi();
        Connection koneksi = connect.getDataSource().getConnection();
        connect.showData();
        System.out.println("Berhasil data tampil");
        System.out.println("Berhasil koneksi");
    }

}
