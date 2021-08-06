package datlt.controller;

import datlt.dtos.CartDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateBuyingQuantityController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            ArrayList<CartDTO> shoppingCart = (ArrayList<CartDTO>) session.getAttribute("shoppingCart");

            String[] listID = request.getParameterValues("txtID");
            String[] listQuantity = request.getParameterValues("txtBuyingQuantity");
            for (int i = 0; i < listQuantity.length; i++) {
                for (CartDTO dto : shoppingCart) {
                    if (dto.getBookId() == Integer.parseInt(listID[i])) {
                        dto.setBuyingQuantity(Integer.parseInt(listQuantity[i]));
                    }
                }

            }

            session.setAttribute("shoppingCar", shoppingCart);
        } catch (Exception e) {
            log("ERROR at UpdateBuyingQuantityController: " + e.getMessage());
        } finally {
            response.sendRedirect("ViewCartController");
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
