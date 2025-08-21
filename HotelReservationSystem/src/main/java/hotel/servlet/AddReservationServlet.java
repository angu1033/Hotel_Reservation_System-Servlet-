package hotel.servlet;

import hotel.dao.ReservationDAO;
import hotel.model.Reservation;
import jakarta.servlet.http.*;
import java.io.*;

public class AddReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Reserve a Room</h3>");
        out.println("<form method='post'>");
        out.println("Guest Name: <input type='text' name='guestName'><br>");
        out.println("Room Number: <input type='number' name='roomNumber'><br>");
        out.println("Contact Number: <input type='text' name='contactNumber'><br>");
        out.println("<input type='submit' value='Reserve'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("guestName");
        int room = Integer.parseInt(request.getParameter("roomNumber"));
        String contact = request.getParameter("contactNumber");

        Reservation r = new Reservation();
        r.setGuestName(name);
        r.setRoomNumber(room);
        r.setContactNumber(contact);

        boolean status = ReservationDAO.addReservation(r);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (status) out.println("<p>Reservation Successful!</p>");
        else out.println("<p>Reservation Failed!</p>");
        out.println("<a href='home'>Back to Home</a>");
        out.println("</body></html>");
    }
}
