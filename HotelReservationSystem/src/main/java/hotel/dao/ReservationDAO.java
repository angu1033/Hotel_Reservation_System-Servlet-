package hotel.dao;
import hotel.util.DBConnection; 
import java.sql.*;
import java.util.*;
import hotel.model.Reservation;
import hotel.util.DBConnection;

public class ReservationDAO {

    // Insert new reservation
	  public static boolean addReservation(Reservation res) {
	        String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) VALUES (?, ?, ?)";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, res.getGuestName());
	            ps.setInt(2, res.getRoomNumber());
	            ps.setString(3, res.getContactNumber());

	            int rows = ps.executeUpdate();
	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }


    // Get all reservations
    public static List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rs.getInt("reservation_id"));
                r.setGuestName(rs.getString("guest_name"));
                r.setRoomNumber(rs.getInt("room_number"));
                r.setContactNumber(rs.getString("contact_number"));
                r.setReservationDate(rs.getTimestamp("reservation_date"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get by ID
    public static Reservation getReservationById(int id) {
        String sql = "SELECT * FROM reservations WHERE reservation_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rs.getInt("reservation_id"));
                r.setGuestName(rs.getString("guest_name"));
                r.setRoomNumber(rs.getInt("room_number"));
                r.setContactNumber(rs.getString("contact_number"));
                r.setReservationDate(rs.getTimestamp("reservation_date"));
                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update reservation
    public static boolean updateReservation(Reservation res) {
        String sql = "UPDATE reservations SET guest_name=?, room_number=?, contact_number=? WHERE reservation_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, res.getGuestName());
            ps.setInt(2, res.getRoomNumber());
            ps.setString(3, res.getContactNumber());
            ps.setInt(4, res.getReservationId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete reservation
    public static boolean deleteReservation(int id) {
        String sql = "DELETE FROM reservations WHERE reservation_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
