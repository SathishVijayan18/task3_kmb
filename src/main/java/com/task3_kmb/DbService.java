package com.task3_kmb;
import com.task3_services.JdbcConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DbService extends HttpServlet {
	private static final Logger log = LogManager.getLogger(DbService.class);
	private static final long serialVersionUID = 1L;
  
    public DbService() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		try {
			JdbcConnect.connectDB();
			log.info("Database connected...");
			out.println("Working....");
		} catch (SQLException e) {
			log.trace(e);
		}
	}
}
