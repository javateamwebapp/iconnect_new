package iconnect.hhcl.EmpEdit;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetStates
 */
public class GetStates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("<-------------------the gettting from States--------------------> ");
		JSONObject jason = new JSONObject();
		String GetRouting = request.getParameter("Routing");
		ResultSet Res=null;
		System.out.println(GetRouting);
		ServletContext c = getServletContext();
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		Statement statement=null;
		GetDbData DataObj=new GetDbData();
		String SUCCESS_PAGE = null;
		List<JSONObject> List =new ArrayList<JSONObject>();
		List<JSONObject> List1 =new ArrayList<JSONObject>();
		java.sql.Connection conn = null;
		java.sql.PreparedStatement ps = null;
		/*
		 * try { Context initContext = new InitialContext(); Context envContext =
		 * (Context) initContext.lookup("java:comp/env"); DataSource ds = (DataSource)
		 * envContext.lookup("jdbc/HHCL_DESK"); conn = ds.getConnection();
		 * 
		 * } catch (SQLException SQLEx) {
		 * 
		 * System.err.println(SQLEx);
		 * System.out.println("There was a problem with the database connection.");
		 * System.out.println(SQLEx);
		 * 
		 * System.out.println(SQLEx.getCause()); request.setAttribute("Reason",
		 * SQLEx.getCause());
		 * 
		 * } catch (NamingException ex) { System.err.println(ex);
		 * request.setAttribute("Reason", ex); }
		 */
	
		final Logger logger = Logger.getLogger(GetStates.class);
		long start = System.currentTimeMillis();
			
			conn=null; 
			try {
				try {
					conn = ConnectionpoolFilter.Call();
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				logger.error(e1.getLocalizedMessage());
				e1.printStackTrace();
			}
			logger.info("Login Servlet Main  - welcome " +conn );
		
		
		
		
		
		
		
		String Routing = request.getParameter("Routing");

		String countryId = request.getParameter("countryId");
		
		String  stateid = request.getParameter("stateid");
		System.out.println("the State Name is:"+stateid);
		System.out.println("stateid!!!!!"+stateid);
		
		if(Routing.equalsIgnoreCase("getStates")) {
		
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT LOCATIONID,NAME FROM hcllcm_prod.tbl_location where parent="+countryId+" and status=1001 ;  ");

			System.out.println(" the edit data ::" + query1);

			ps = conn.prepareStatement(query1.toString());
			java.sql.ResultSet Res1 = ps.executeQuery();

			System.out.println("the result set");

			System.out.println("the result set data is::" + Res1);
			
		
			java.sql.ResultSetMetaData resMeta = Res1.getMetaData();
			
			int countcol = resMeta.getColumnCount();
			List<String> colnames = new ArrayList<String>();
			for(int i=1;i<=countcol;i++)
			{
			
				colnames.add(resMeta.getColumnName(i));
				
			}
			while (Res1.next()) {

						
				
				JSONObject obj = new JSONObject();
				for(int i=1;i<=countcol;i++)
				{
					String key = colnames.get(i-1);
					String val = Res1.getString(i);
					obj.put(key, val);
				}
			
				List.add(obj);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		int Sid=1001;
	//getcitiesstateid
		if(Routing.equalsIgnoreCase("getcities"))
		{
			
			try {
				StringBuffer query1 = new StringBuffer();
				query1.append("SELECT LOCATIONID,NAME FROM hcllcm_prod.tbl_location where parent in(SELECT LOCATIONID FROM hcllcm_prod.tbl_location where NAME='"+stateid+"') and status=1001 ; ");
				//query1.append("select LOCATIONID,NAME from  hcllcm_prod.tbl_location  where NAME LIKE '%"+stateid+"%';  ");
				//query1.append("select LOCATIONID,NAME from  hcllcm_prod.tbl_location  where NAME LIKE '%"+stateid+"%';  ");
				

				System.out.println("the edit data ::" + query1);

				ps = conn.prepareStatement(query1.toString());
				java.sql.ResultSet Res1 = ps.executeQuery();

				System.out.println("the result set");

				System.out.println("the result set data is::" + Res1);
				
			
				java.sql.ResultSetMetaData resMeta = Res1.getMetaData();
				
				int countcol = resMeta.getColumnCount();
				List<String> colnames = new ArrayList<String>();
				for(int i=1;i<=countcol;i++)
				{
				
					colnames.add(resMeta.getColumnName(i));
					
				}
				while (Res1.next()) {

							
					
					JSONObject obj = new JSONObject();
					for(int i=1;i<=countcol;i++)
					{
						String key = colnames.get(i-1);
						String val = Res1.getString(i);
						obj.put(key, val);
					}
				
					List1.add(obj);
					 

				}

				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
		}
		
		
		
		
		
		
		
		System.out.println("the State data is" + List);
		
		
		if(Routing.equalsIgnoreCase("getcities"))
		{
			out.write(List1.toString());
		}else
		{
			out.write(List.toString());
		}
	

		
		
		try {
			ConnectionpoolFilter.close(conn, Res,"GetStates",false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
	    logger.info("Login servlet Main  execution time in Seconds ::"+ sec);
	    request.setAttribute("Excecutiontime", sec +" Sec");
		
		
		
		
		
	}

}
