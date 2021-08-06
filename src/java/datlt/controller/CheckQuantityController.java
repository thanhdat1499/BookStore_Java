
package datlt.controller;

import datlt.dtos.CartDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CheckQuantityController extends HttpServlet {

    public static final String ENOUGH = "discount.jsp";
    public static final String OUTOFSTOCK = "outOfStock.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ENOUGH;
        try{
            HttpSession session = request.getSession();
            ArrayList<CartDTO> shoppingCart = (ArrayList<CartDTO>) session.getAttribute("shoppingCart");
            String discountName = request.getParameter("txtDiscountName");
            
            ArrayList<CartDTO> outOfStock = new ArrayList<>();
            
            for (CartDTO cart : shoppingCart) {
                if(cart.getBuyingQuantity() > cart.getQuantity()){    
                    url = OUTOFSTOCK;
                    outOfStock.add(cart);
                }
            }
            
            if(!outOfStock.isEmpty()){
                request.setAttribute("outOfStockk", outOfStock);
            }
            

        }catch(Exception e){
            log("ERROR at CheckQuantityController: " +e.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
