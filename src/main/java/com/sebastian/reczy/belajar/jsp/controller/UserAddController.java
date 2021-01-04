package com.sebastian.reczy.belajar.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sebastian.reczy.belajar.jsp.dao.JurusanDao;
import com.sebastian.reczy.belajar.jsp.dao.UkmDao;
import com.sebastian.reczy.belajar.jsp.dao.UsersDao;
import com.sebastian.reczy.belajar.jsp.helper.VariableDatabase;
import com.sebastian.reczy.belajar.jsp.model.Users;
import com.sebastian.reczy.belajar.jsp.model.Jurusan;
import com.sebastian.reczy.belajar.jsp.model.Ukm;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/user/add", "/user/proses"})
public class UserAddController extends HttpServlet {

    private JurusanDao jurusanDao = new JurusanDao();
    private UkmDao ukmDao = new UkmDao();
    private UsersDao usersDao = new UsersDao();
    Connection conn;

    protected void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(VariableDatabase.url, VariableDatabase.username, VariableDatabase.password);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            connect();
            req.setAttribute("listJurusan", jurusanDao.showData());
            req.setAttribute("listUkm", ukmDao.showData());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/user/index.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            connect();
            PrintWriter out = resp.getWriter();
            Users us = new Users();
            us.setNim(req.getParameter("nim"));
            us.setNama(req.getParameter("nama"));
            us.setEmail(req.getParameter("email"));
            us.setJenis_kelamin(req.getParameter("jenis_kelamin"));

            String jurusan = req.getParameter("jurusan");
            Jurusan ju = new Jurusan();
            ju.setId(jurusan);
            us.setJurusan(ju);

            String ukm = req.getParameter("ukm");
            Ukm uk = new Ukm();
            uk.setId(ukm);
            us.setUkm(uk);

            usersDao.save(us);
            out.println("Berhasil daftar");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
