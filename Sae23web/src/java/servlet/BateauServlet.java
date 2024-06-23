/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import dao.DAOVendeeGlobe;
import model.Bateau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author robert
 */
@WebServlet("/bateaux")
public class BateauServlet extends HttpServlet {
    private DAOVendeeGlobe daoVendeeGlobe = new DAOVendeeGlobe();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bateau> bateaux = daoVendeeGlobe.lireBateaux();
        String json = new Gson().toJson(bateaux);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
        }
    }

    @Override
    public String getServletInfo() {
        return "Bateau Servlet";
    }
}
