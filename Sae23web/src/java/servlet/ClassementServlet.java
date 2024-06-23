/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import dao.DAOVendeeGlobe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClassementComplet;

/**
 *
 * @author robert
 */

@WebServlet("/classements")
public class ClassementServlet extends HttpServlet {
    private DAOVendeeGlobe daoVendeeGlobe = new DAOVendeeGlobe();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String edition = request.getParameter("edition");
    List<ClassementComplet> classements = daoVendeeGlobe.getClassementsByEdition(edition);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    out.print(new Gson().toJson(classements));
    out.flush();
    }

    @Override
    public String getServletInfo() {
        return "Classement Servlet";
    }
}