/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import dao.DAOVendeeGlobe;
import model.Skipper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/skippers")
public class SkipperServlet extends HttpServlet {
    private DAOVendeeGlobe daoVendeeGlobe = new DAOVendeeGlobe();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Skipper> skippers = daoVendeeGlobe.lireTousLesSkippers();
        String json = new Gson().toJson(skippers);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}