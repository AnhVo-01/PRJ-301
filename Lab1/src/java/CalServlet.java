
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

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

        String opera = request.getParameter("operator");     
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        StringBuilder sb = new StringBuilder();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Calculator</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome to calculator!</h1>");
            out.println("<form name=\"input\" action=\"CalServlet\" method=\"post\">");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>First:</td><td><input type=\"text\" name=\"num1\" value=\""+n1+"\"/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Second:</td><td><input type=\"text\" name=\"num2\" value=\""+n2+"\"/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Operator</td>");
            out.println("<td><select name = \"operator\">");
            switch (opera) {
                case "+":
                    out.println("<option selected>+</option>");
                    out.println("<option>-</option>");
                    out.println("<option>*</option>");
                    out.println("<option>/</option>");
                    sb.append(n1 + n2);
                    break;
                case "-":
                    out.println("<option>+</option>");
                    out.println("<option selected>-</option>");
                    out.println("<option>*</option>");
                    out.println("<option>/</option>");
                    sb.append(n1 - n2);
                    break;
                case "*":
                    out.println("<option>+</option>");
                    out.println("<option>-</option>");
                    out.println("<option selected>*</option>");
                    out.println("<option>/</option>");
                    sb.append(n1 * n2);
                    break;
                case "/":
                    out.println("<option>+</option>");
                    out.println("<option>-</option>");
                    out.println("<option>*</option>");
                    out.println("<option selected>/</option>");
                    if (n2 == 0) {
                        sb.append("error");
                    } else {
                        sb.append(n1 / n2);
                    }
                    break;
            }
            out.println("</select></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td></td><td><input type=\"submit\" value=\"Compute\"/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Result:</td><td><input type=\"text\" name=\"result\" value=\""+sb+"\"/></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form></body></html>");
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
