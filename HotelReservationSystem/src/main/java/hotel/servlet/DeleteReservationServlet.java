package hotel.servlet;

import hotel.dao.ReservationDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class DeleteReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Delete Reservation</h3>");
        out.println("<form method='post'>");
        out.println("Reservation ID: <input type='number' name='id'><br>");
        out.println("<input type='submit' value='Delete'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = ReservationDAO.deleteReservation(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (status) out.println("<p>Reservation Deleted!</p>");
        else out.println("<p>Delete Failed!</p>");
        out.println("<a href='home'>Back to Home</a>");
        out.println("</body></html>");
    }
}
