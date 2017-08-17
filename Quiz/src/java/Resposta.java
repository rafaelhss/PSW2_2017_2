/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael.Soares
 */
public class Resposta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String[] gabarito = {"Dercy",
                             "pirata",
                             "4",
                             "Neymar"};
        
        String resp = request.getParameter("resposta");
        
        Integer questaoAtual 
                = (Integer) request.getSession().getAttribute("questao");
       
        if(questaoAtual == null){
            questaoAtual = 0;
        }
        Integer pontos = null;
        
        if(gabarito[questaoAtual].equals(resp)){            
            pontos = (Integer) request.getSession()
                                .getAttribute("pontos");
            if (pontos == null){
                pontos = 0;
            }
            
            pontos += 10;
            
            request.getSession()
                    .setAttribute("pontos", pontos);            
        }
        
        request.getSession().setAttribute("questao", ++questaoAtual);
        
        if (questaoAtual >= gabarito.length){
            //chegou na ultima
            request.setAttribute("pontos", pontos);
            request.getRequestDispatcher("resultado.jsp")
                .forward(request, response);
            
        } else {
        
            request.getRequestDispatcher("Quiz")
                .forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
