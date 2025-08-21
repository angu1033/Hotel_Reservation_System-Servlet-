package hotel.servlet;

import hotel.dao.ReservationDAO;
import hotel.model.Reservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.List;

public class ViewReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Reservation> list = ReservationDAO.getAllReservations();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Current Reservations</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Room</th><th>Contact</th><th>Date</th></tr>");
        for (Reservation r : list) {
            out.println("<tr>");
            out.println("<td>" + r.getReservationId() + "</td>");
            out.println("<td>" + r.getGuestName() + "</td>");
            out.println("<td>" + r.getRoomNumber() + "</td>");
            out.println("<td>" + r.getContactNumber() + "</td>");
            out.println("<td>" + r.getReservationDate() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<a href='home'>Back to Home</a>");
        out.println("</body></html>");
    }
}
