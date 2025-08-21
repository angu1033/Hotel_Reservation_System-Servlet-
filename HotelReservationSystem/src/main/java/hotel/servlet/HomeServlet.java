package hotel.servlet;
import jakarta.servlet.http.*;
import java.io.*;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Hotel Reservation</title></head><body>");
        out.println("<h2>Hotel Reservation System</h2>");
        out.println("<ul>");
        out.println("<li><a href='add'>Reserve a Room</a></li>");
        out.println("<li><a href='view'>View Reservations</a></li>");
        out.println("<li><a href='get'>Get Guest Info</a></li>");
        out.println("<li><a href='update'>Update Reservation</a></li>");
        out.println("<li><a href='delete'>Delete Reservation</a></li>");
        out.println("</ul>");
        out.println("</body></html>");
    }
}
