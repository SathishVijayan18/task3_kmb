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

import com.task3_services.CreateLogic;
import com.task3_services.ListLogic;

public class CreateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CreateService() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		/*int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		int empSal = Integer.parseInt(request.getParameter("empSal"));
		int empCode = Integer.parseInt(request.getParameter("deptCode"));*/
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

			String s1 = jo.get("empId").toString();
			String s2 = jo.get("empName").toString();
			String s3 = jo.get("empSal").toString();
			String s4 = jo.get("deptCode").toString();
			int empId = Integer.parseInt(s1);
			String empName=s2;
			int empSal=Integer.parseInt(s3);
			int deptCode=Integer.parseInt(s4);
			CreateLogic.insertData(empId, empName, empSal, deptCode);
			out.println("Record Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
