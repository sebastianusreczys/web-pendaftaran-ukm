package com.sebastian.reczy.belajar.jsp.dao;

import com.sebastian.reczy.belajar.jsp.config.DatabaseKonfigurasi;
import com.sebastian.reczy.belajar.jsp.helper.VariableDatabase;
import com.sebastian.reczy.belajar.jsp.model.Users;
import com.sebastian.reczy.belajar.jsp.model.Jurusan;
import com.sebastian.reczy.belajar.jsp.model.Ukm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersDao {

    Connection conn;

    protected void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(VariableDatabase.url, VariableDatabase.username, VariableDatabase.password);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
    }

    public void save(Users us) throws SQLException {

        connect();
        String save = "INSERT INTO s_users (id, nim, nama, email, jenis_kelamain, id_jurusan, id_ukm) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(save);
        stm.setString(1, UUID.randomUUID().toString());
        stm.setString(2, us.getNim());
        stm.setString(3, us.getNama());
        stm.setString(4, us.getEmail());
        stm.setString(5, us.getJenis_kelamin());
        stm.setString(6, us.getJurusan().getId());
        stm.setString(7, us.getUkm().getId());
        stm.executeUpdate();
        conn.close();

    }

    public List<Users> showData() throws SQLException {
        connect();
        List<Users> listData = new ArrayList<>();
        String sql_join = "select nim, nama, email, jenis_kelamain, jurusan, nama_ukm from s_users\n"
                + "inner join s_jurusan on s_users.id_jurusan = s_jurusan.id\n"
                + "inner join s_ukm on s_users.id_ukm = s_ukm.id;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql_join);

        while (rs.next()) {
            Users us = new Users();
            us.setId(rs.getString("id"));

            Jurusan ju = new Jurusan();
            ju.setId(rs.getString("id"));
            ju.setNamaJurusan(rs.getString("jurusan"));
            us.setJurusan(ju);

            Ukm uk = new Ukm();
            uk.setId(rs.getString("id"));
            uk.setNamaUkm(rs.getString("nama_ukm"));
            us.setUkm(uk);
            listData.add(us);

        }
        System.out.println("jumlah listdata" + listData.size());
        rs.close();
        st.clearBatch();
        conn.close();
        return listData;
    }
}
