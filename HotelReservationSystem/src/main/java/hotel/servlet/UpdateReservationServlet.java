package hotel.servlet;

import hotel.dao.ReservationDAO;
import hotel.model.Reservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class UpdateReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Update Reservation</h3>");
        out.println("<form method='post'>");
        out.println("Reservation ID: <input type='number' name='id'><br>");
        out.println("New Guest Name: <input type='text' name='guestName'><br>");
        out.println("New Room Number: <input type='number' name='roomNumber'><br>");
        out.println("New Contact Number: <input type='text' name='contactNumber'><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("guestName");
        int room = Integer.parseInt(request.getParameter("roomNumber"));
        String contact = request.getParameter("contactNumber");

        Reservation r = new Reservation();
        r.setReservationId(id);
        r.setGuestName(name);
        r.setRoomNumber(room);
        r.setContactNumber(contact);

        boolean status = ReservationDAO.updateReservation(r);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (status) out.println("<p>Reservation Updated!</p>");
        else out.println("<p>Update Failed!</p>");
        out.println("<a href='home'>Back to Home</a>");
        out.println("</body></html>");
    }
}
