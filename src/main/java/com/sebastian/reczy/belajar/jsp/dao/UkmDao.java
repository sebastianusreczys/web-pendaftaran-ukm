
package com.sebastian.reczy.belajar.jsp.dao;

import com.sebastian.reczy.belajar.jsp.config.DatabaseKonfigurasi;
import com.sebastian.reczy.belajar.jsp.model.Ukm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UkmDao {
    public void save(Ukm uk) throws SQLException {
        try (Connection connection = new DatabaseKonfigurasi().getDataSource().getConnection()) {
            connection.setAutoCommit(false);
            String save = "INSERT INTO t_ukm(id, nama_ukm) VALUES(?,?)";
            PreparedStatement stm = connection.prepareStatement(save);
            stm.setString(1, UUID.randomUUID().toString());
            stm.setString(2, uk.getNamaUkm());
            
            stm.executeUpdate();
            connection.close();
        }
    }
    public List<Ukm> showData() throws SQLException{
        List<Ukm> listData = new ArrayList<>();
        Connection connection = new DatabaseKonfigurasi().getDataSource().getConnection();
        String show = "SELECT * FROM s_ukm";
        
        
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(show);
        
        while(rs.next()){
            Ukm uk = new Ukm();
            uk.setId(rs.getString("id"));
            uk.setNamaUkm(rs.getString("nama_ukm"));
            listData.add(uk);
        }
        connection.close();
        st.close();
        rs.close();
        return listData;
    }
}
