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

import com.task3_services.ListLogic;

public class ListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListService() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		// int empId = Integer.parseInt(request.getParameter("empId"));

		StringBuffer jb = new StringBuffer();
		String line = null;
		String str;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
			str = jb.toString();
			// System.out.println(str);
			JSONParser jp = new JSONParser();
			// jp.parse(str);
			JSONObject jo = new JSONObject();
			jo = (JSONObject) jp.parse(str);

			// jo.get("empCode");
			// System.out.println(jo.get("empCode"));

			String s = jo.get("empId").toString();

			int empId = Integer.parseInt(s);
			out.println(ListLogic.fetchData(empId));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
