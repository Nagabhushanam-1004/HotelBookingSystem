package com.hotel.controller;

import com.hotel.connection.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookRoom")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Gather parameters sent from index.html form
        String guestName = request.getParameter("guestName");
        String guestEmail = request.getParameter("guestEmail");
        String checkInDate = request.getParameter("checkInDate");
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        
        boolean isSuccess = false;

        try (Connection conn = DBConnection.getConnection()) {
            // Disable auto-commit to run both queries safely as a single transaction
            conn.setAutoCommit(false);

            // 2. Insert query into bookings table
            String sqlBook = "INSERT INTO bookings (guest_name, guest_email, room_id, check_in) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psBook = conn.prepareStatement(sqlBook)) {
                psBook.setString(1, guestName);
                psBook.setString(2, guestEmail);
                psBook.setInt(3, roomId);
                psBook.setString(4, checkInDate);
                psBook.executeUpdate();
            }

            // 3. Update query to mark room status as Booked
            String sqlRoom = "UPDATE rooms SET status = 'Booked' WHERE room_id = ?";
            try (PreparedStatement psRoom = conn.prepareStatement(sqlRoom)) {
                psRoom.setInt(1, roomId);
                psRoom.executeUpdate();
            }

            // Commit transaction if both operations succeed
            conn.commit();
            isSuccess = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4. Set attributes and handoff to the JSP View layer
        if (isSuccess) {
            request.setAttribute("msg", "Success! Your reservation is secure.");
            request.setAttribute("name", guestName);
        } else {
            request.setAttribute("msg", "Error: Something went wrong with your booking registration.");
            request.setAttribute("name", "Guest");
        }
        
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }
}
