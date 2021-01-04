package com.sebastian.reczy.belajar.jsp.dao;

import com.sebastian.reczy.belajar.jsp.config.DatabaseKonfigurasi;
import com.sebastian.reczy.belajar.jsp.model.Jurusan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JurusanDao {

    public void save(Jurusan ju) throws SQLException {
        Connection connection = new DatabaseKonfigurasi().getDataSource().getConnection();
        connection.setAutoCommit(false);
        String save = "INSERT INTO s_jurusan(id, jurusan) VALUES(?,?)";
        PreparedStatement stm = connection.prepareStatement(save);
        stm.setString(1, UUID.randomUUID().toString());
        stm.setString(2, ju.getNamaJurusan());

        stm.executeUpdate();
        connection.close();

    }

    public List<Jurusan> showData() throws SQLException {

        Connection connection = new DatabaseKonfigurasi().getDataSource().getConnection();
        List<Jurusan> listData = new ArrayList<>();

        String show = "SELECT * FROM s_jurusan";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(show);

        while (rs.next()) {
            Jurusan ju = new Jurusan();
            ju.setId(rs.getString("id"));
            ju.setNamaJurusan(rs.getString("jurusan"));
            listData.add(ju);
        }
        connection.close();
        st.close();
        rs.close();
        return listData;
    }

}
