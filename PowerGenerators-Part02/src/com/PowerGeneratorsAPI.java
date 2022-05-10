package com;
import com.PowerGenerator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;

/**
 * Servlet implementation class PowerGeneratorsAPI
 */
@WebServlet("/PowerGeneratorsAPI")
public class PowerGeneratorsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PowerGenerator pGen = new PowerGenerator();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerGeneratorsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		String output = pGen.addPowerGenerator(request.getParameter("gCode"), 
		request.getParameter("gName"), 
		request.getParameter("gType"), 
		request.getParameter("gLocation"),
		request.getParameter("gUnitPrice"),
		request.getParameter("gRegDate")); 
		response.getWriter().write(output); 
	}*/
	
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
		Map<String, String> map = new HashMap<String, String>(); 
		try
		{ 
			 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
			 String queryString = scanner.hasNext() ? 
			 scanner.useDelimiter("\\A").next() : ""; 
			 scanner.close(); 
			 String[] params = queryString.split("&"); 
			 for (String param : params) 
			 { 
				 String[] p = param.split("="); 
				 map.put(p[0], p[1]); 
			 } 
		} 
	    catch (Exception e) 
	    { } 
	
		return map; 
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		Map paras = getParasMap(request); 
		String output = pGen.updatePowerGenerator(paras.get("hidgIDSave").toString(), 
		paras.get("gCode").toString(), 
		paras.get("gName").toString(), 
		paras.get("gType").toString(), 
		paras.get("gLocation").toString(),
		paras.get("gUnitPrice").toString(),
		paras.get("gRegDate").toString()); 
		response.getWriter().write(output); 
	} 
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		Map paras = getParasMap(request); 
		String output = pGen.deletePowerGenerator(paras.get("gID").toString()); 
		response.getWriter().write(output); 
	}


}
