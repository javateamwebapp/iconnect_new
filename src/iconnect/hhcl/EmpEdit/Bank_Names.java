package iconnect.hhcl.EmpEdit;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Bank_Names
 */
public class Bank_Names extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank_Names() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("<---------------Emp Edit profile hr Approvals-----------> ");
		Statement statement=null;
		java.sql.ResultSet Res = null;
		// DataSource dataSource=null;
		java.sql.Connection conn = null;
		java.sql.PreparedStatement ps = null;
		Map userdata = new HashMap();
		String GetRouting = request.getParameter("Routing");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		System.out.println("GetRouting" + GetRouting);
		GetDbData DataObj = new GetDbData();
		String PAGE = null;
		ServletContext c = getServletContext();
		System.out.println("GetParameter" + c.getAttribute("HR Approvals"));
		ResourceBundle info = (ResourceBundle) (c.getAttribute("bundle"));
		System.out.println("the resource is  " + info);
		JSONObject jason = new JSONObject();
		//Map ls = new HashMap<String>();
		JSONArray jsonArray = new JSONArray();
		Map ls = new HashMap<Integer,String>();
		List<JSONObject> List =new ArrayList<JSONObject>();
		//List<Map<String,Object>> list = new ArrayList<>();
		
		String bankname="",otpvalid="";
		
		/*
		 * try { //conn =dataSource.getConnection();
		 * conn=(java.sql.Connection)session.getAttribute("ConnectionObj"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
		
		final Logger logger = Logger.getLogger(Bank_Names.class);
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

		
		
		System.out.println("the mobile otp exicute query::"+ls);
		
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("select bankname FROM hcladm_prod.tbl_bank_details;  ");

			System.out.println("theBankdata ::" + query1);

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
		jsonArray.add(jason);
		System.out.println("thebankdatais" + List);
		out.write(List.toString());
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
		     if(statement!=null){
		       statement.close();
		     }
		   if(Res!=null){
			    Res.close();
 			}
		 /*if(conn!=null){
			conn.close();
      }*/
		 if(ps!=null){
			ps.close();
      }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		
		/*
		 * try { ConnectionpoolFilter.close(conn, Res,"Bank_Names",false); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * long end = System.currentTimeMillis(); float sec = (end - start) / 1000F;
		 * logger.info("Login servlet Main  execution time in Seconds ::"+ sec);
		 * request.setAttribute("Excecutiontime", sec +" Sec");
		 * 
		 * 
		 */
		
		
		
		
	}

	

}
