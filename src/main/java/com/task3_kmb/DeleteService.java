package com.task3_kmb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.task3_services.DeleteLogic;
public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteService() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		// int empId = Integer.parseInt(request.getParameter("empId"));

		StringBuffer jb = new StringBuffer();
		String line = null;
		String str;
		String s;
		int empId;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
			str = jb.toString();
			JSONParser jp = new JSONParser();

			JSONObject jo = new JSONObject();
			jo = (JSONObject) jp.parse(str);
			s = jo.get("empId").toString();
			empId = Integer.parseInt(s);
			//out.println(DeleteLogic.RemoveService(empId));
			DeleteLogic.RemoveService(empId);
			out.println("Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
