package hotel.servlet;

import hotel.dao.ReservationDAO;
import hotel.model.Reservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class GetReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Get Reservation Info</h3>");
        out.println("<form method='post'>");
        out.println("Enter Reservation ID: <input type='number' name='id'><br>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reservation r = ReservationDAO.getReservationById(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (r != null) {
            out.println("<h3>Reservation Details</h3>");
            out.println("ID: " + r.getReservationId() + "<br>");
            out.println("Name: " + r.getGuestName() + "<br>");
            out.println("Room: " + r.getRoomNumber() + "<br>");
            out.println("Contact: " + r.getContactNumber() + "<br>");
            out.println("Date: " + r.getReservationDate() + "<br>");
        } else {
            out.println("<p>No reservation found for ID: " + id + "</p>");
        }
        out.println("<a href='home'>Back to Home</a>");
        out.println("</body></html>");
    }
}
