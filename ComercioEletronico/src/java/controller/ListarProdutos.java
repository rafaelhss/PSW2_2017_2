package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Catalogo;
import model.ClassificacaoProduto;
import model.Produto;

/**
 *
 * @author Rafael.Soares
 */
public class ListarProdutos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String filename = "C:\\Users\\rafael.soares\\Documents\\NetBeansProjects\\ComercioEletronico\\src\\java\\produtos.txt";
            Catalogo catalogo = new Catalogo(filename);
            
            HttpSession sessao = request.getSession(false);
            System.out.println("Sessao:" + sessao);
            if(sessao == null){
                request.getRequestDispatcher("informarIdade.html")
                        .forward(request, response);
            } else {
            
                List<Produto> produtos = new ArrayList<Produto>();

                Integer idade = (Integer) sessao.getAttribute("idade");
                if(idade >= 18){
                    produtos.addAll(catalogo.listarProdutos(ClassificacaoProduto.IDOSO));
                    produtos.addAll(catalogo.listarProdutos(ClassificacaoProduto.ADULTO));
                }
                produtos.addAll(catalogo.listarProdutos(ClassificacaoProduto.INFANTIL));

                request.setAttribute("produtos", produtos);

                request.getRequestDispatcher("mostraProdutos.jsp")
                        .forward(request, response);
            }
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
