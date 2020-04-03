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
 * Servlet implementation class Emp_All_Details_list
 */
public class Emp_All_Details_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Emp_All_Details_list() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doGet(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 * }
		 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("<---------------Emp Edit  hr Approvals side get All Details-----------> ");
		String empID = request.getParameter("EmpID");
		
		System.out.println("the elements are ::"+empID);
		
		Statement statement=null;
		java.sql.ResultSet Res = null;
		// DataSource dataSource=null;
		java.sql.Connection conn = null;
		java.sql.PreparedStatement ps = null;
		//Map userdata = new HashMap();
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
		//Map ls = new HashMap<Integer,String>();
		List<JSONObject> List =new ArrayList<JSONObject>();
		//List<Map<String,Object>> list = new ArrayList<>();
		List<JSONObject> reList =new ArrayList<JSONObject>();
		List<JSONObject> reList1 =new ArrayList<JSONObject>();
		List<JSONObject> reList2 =new ArrayList<JSONObject>();
		List<JSONObject> reList3 =new ArrayList<JSONObject>();
		List<JSONObject> reList4 =new ArrayList<JSONObject>();
		String bankname="",otpvalid="";
		StringBuffer query1ol = new StringBuffer();
		StringBuffer query1ol1 = new StringBuffer();
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
		
		/*
		 * try { //conn =dataSource.getConnection();
		 * conn=(java.sql.Connection)session.getAttribute("ConnectionObj"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */

		
		final Logger logger = Logger.getLogger(Emp_All_Details_list.class);
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
		
		
		
		
		
		
		
		
		
		
		
		/*query1ol.append("select a.*,b.PermanentAddress,b.PermanentAddress2,b.PermanentAddress3,b.PermanentAddress4,b.state 'pstate',b.city 'pcity',b.Status'perStatus',b.pin'ppin'\r\n" + 
				",c.CommunicationAddress,c.communication2,c.communication3,c.communication4,c.state 'cState',c.city 'ccity',c.Status 'comStatus',c.pin'cpin',\r\n" + 
				"d.*,e.* from hclhrm_prod.emp_bank_details_edit a\r\n" + 
				"left join hclhrm_prod.emp_permanentaddress_edit b on a.empId=b.empId\r\n" + 
				"left join hclhrm_prod.emp_communication_edit_details c on a.empId=c.empId\r\n" + 
				"left join hclhrm_prod.emp_aadhar_pan_edit_details d on a.empId=d.empId\r\n" + 
				"left join hclhrm_prod.personal_edit_details e on a.empId=e.empId\r\n" + 
				"where a.empId="+empID+"; ");*/

		String Routing = request.getParameter("routing");
		System.out.println("the routing is::"+Routing);
		
		if(Routing.equalsIgnoreCase("aadharandPan"))
		{
		
		try {
			
			query1ol.append("	select *\r\n" + 
					"			from\r\n" + 
					"			emp_edit_details.emp_list_table a\r\n" + 
					"			where empId="+empID+" and Status=1001; ");

			System.out.println("the edit data ::" + query1ol);
		

			ps = conn.prepareStatement(query1ol.toString());
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
			
				reList.add(obj);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
			
			  try { StringBuffer query1 = new StringBuffer(); query1.append("select\r\n" +
			  "B.employeesequenceno'EmpID',\r\n" +
			  "concat(tit.name,' ',B.CALLNAME)'NAME',\r\n" + "b.DATEOFBIRTH,\r\n" +
			  "ifnull(banks.BANKNAME,'--')'BANKNAME',\r\n" +
			  "ifnull(ifc.bankifc,'--')'IFSC11',\r\n" +
			  "ifnull(other.ACCOUNTNO,'--')'ACCOUNTNO11',\r\n" +
			  "per.AADHAARCARDNO 'AADHAARCARDNO11',\r\n" +
			  "per.AADHAARNAME 'AADHAARNAME11',\r\n" +
			  "per.DRIVINGLICENSENO 'DRIVINGLICENSENO11',\r\n" +
			  "per.PASSPORTNO 'PASSPORTNO11',\r\n" + "per.pan 'pan11',\r\n" +
			  "ps.email 'personal_email1111',\r\n" + "ps.phone 'personal_phone11',\r\n" +
			  "prof.phone 'professional_phone11',\r\n" +
			  "ps.PERMANENTADDRESS 'perm_addr111', ps.PERMANENTADDRESS2 'peradd2', ps.PERMANENTADDRESS3 'peradd3',ps.PERMANENTADDRESS4 'peradd4',ps.PERMANENTZIP 'perm_pincode11',\r\n"
			  +
			  "ps.COMMUNICATIONADDRESS 'comm_addr111', ps.COMMUNICATIONADDRESS2 'commadd11',ps.COMMUNICATIONADDRESS3 'commadd113', ps.COMMUNICATIONADDRESS4 'commadd4',\r\n"
			  +
			  "ps.COMMUNICATIONZIP 'comm_pincode',IFNULL(COMMLOC.NAME,'') COMCITY,IFNULL(COMMSTATELOC.NAME,'')COMMSTATE,\r\n"
			  + "IFNULL(PLOC.NAME,'') PCITY, IFNULL(PSLOC.NAME,'')PSTATE\r\n" + "\r\n" +
			  "\r\n" + "from hclhrm_prod.tbl_employee_primary B\r\n" +
			  "left join hclhrm_prod.tbl_employee_other_detail other on other.employeeid=b.employeeid\r\n"
			  +
			  "left join hcladm_prod.tbl_bank_details banks on banks.bankid=other.bankid\r\n"
			  +
			  "left join hclhrm_prod_others.tbl_emp_bank_ifc ifc on ifc.empid=b.employeeid\r\n"
			  + "left join hcladm_prod.tbl_title tit on tit.title=b.title\r\n" +
			  "left join hclhrm_prod.tbl_employee_personalinfo per on per.employeeid=b.employeeid\r\n"
			  +
			  "left join hclhrm_prod.tbl_employee_professional_contact prof on prof.employeeid=b.employeeid\r\n"
			  +
			  "left join hclhrm_prod.tbl_employee_personal_contact ps on ps.employeeid=b.employeeid\r\n"
			  +
			  "LEFT JOIN hclhrm_prod.tbl_employee_personal_contact D 	ON b.EMPLOYEEID=D.EMPLOYEEID\r\n"
			  +
			  "LEFT JOIN HCLLCM_PROD.TBL_LOCATION COMMLOC ON D.COMMUNICATIONLOCATIONID=COMMLOC.LOCATIONID\r\n"
			  +
			  "LEFT JOIN HCLLCM_PROD.TBL_LOCATION COMMSTATELOC ON COMMLOC.PARENT=COMMSTATELOC.LOCATIONID\r\n"
			  +
			  "LEFT JOIN HCLLCM_PROD.TBL_LOCATION PLOC 	ON D.PERMANENTLOCATIONID=PLOC.LOCATIONID\r\n"
			  +
			  "LEFT JOIN HCLLCM_PROD.TBL_LOCATION PSLOC ON PLOC.PARENT=PSLOC.LOCATIONID\r\n"
			  + "where b.status=1001 and b.employeesequenceno="+empID+"; ");
			  
			  System.out.println("the edit data ::" + query1);
			  
			  ps = conn.prepareStatement(query1.toString()); java.sql.ResultSet Res1 =
			  ps.executeQuery();
			  
			  System.out.println("the result set");
			  
			  System.out.println("the result set data is::" + Res1);
			  
			  
			  java.sql.ResultSetMetaData resMeta = Res1.getMetaData();
			  
			  int countcol = resMeta.getColumnCount(); List<String> colnames = new
			  ArrayList<String>(); for(int i=1;i<=countcol;i++) {
			  
			  colnames.add(resMeta.getColumnName(i));
			  
			  } while (Res1.next()) {
			  
			  
			  
			  JSONObject obj5 = new JSONObject(); for(int i=1;i<=countcol;i++) { String key
			  = colnames.get(i-1); String val = Res1.getString(i); obj5.put(key, val); }
			  
			  reList.add(obj5);
			  
			  
			  }
			  
			  
			  
			  } catch (SQLException e) { // TODO Auto-generated catch block
			  e.printStackTrace(); }
			  
			  
			 
		
		
		
		
		
		
		
		
		
		System.out.println("the values are:: "+reList);
		
		
		
		
		
		
		
		
		
		
	
		}	
		
		
		
	///table 2
		
		if(Routing.equalsIgnoreCase("bankDetails"))
		{
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT * FROM hclhrm_prod.emp_bank_details_edit; ");

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

						
				
				JSONObject obj2 = new JSONObject();
				for(int i=1;i<=countcol;i++)
				{
					String key = colnames.get(i-1);
					String val = Res1.getString(i);
					obj2.put(key, val);
				}
			
				reList1.add(obj2);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		//table 3
		
		if(Routing.equalsIgnoreCase("communication"))
		{
		
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT * FROM hclhrm_prod.emp_communication_edit_details; ");

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

						
				
				JSONObject obj3 = new JSONObject();
				for(int i=1;i<=countcol;i++)
				{
					String key = colnames.get(i-1);
					String val = Res1.getString(i);
					obj3.put(key, val);
				}
			
				reList2.add(obj3);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//table 4
		
		if(Routing.equalsIgnoreCase("PermaneatDetails"))
		{
	
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT * FROM hclhrm_prod.emp_permanentaddress_edit; ");

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

						
				
				JSONObject obj4 = new JSONObject();
				for(int i=1;i<=countcol;i++)
				{
					String key = colnames.get(i-1);
					String val = Res1.getString(i);
					obj4.put(key, val);
				}
			
				reList3.add(obj4);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//table 5
		
		if(Routing.equalsIgnoreCase("PersonalDetails12"))
		{
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("select\r\n" + 
					"B.employeesequenceno'EmpID',\r\n" + 
					"concat(tit.name,' ',B.CALLNAME)'NAME',\r\n" + 
					"b.DATEOFBIRTH,\r\n" + 
					"ifnull(banks.BANKNAME,'--')'BANKNAME',\r\n" + 
					"ifnull(ifc.bankifc,'--')'IFSC11',\r\n" + 
					"ifnull(other.ACCOUNTNO,'--')'ACCOUNTNO11',\r\n" + 
					"per.AADHAARCARDNO 'AADHAARCARDNO11',\r\n" + 
					"per.AADHAARNAME 'AADHAARNAME11',\r\n" + 
					"per.DRIVINGLICENSENO 'DRIVINGLICENSENO11',\r\n" + 
					"per.PASSPORTNO 'PASSPORTNO11',\r\n" + 
					"per.pan 'pan11',\r\n" + 
					"ps.email 'personal_email11',\r\n" + 
					"ps.phone 'personal_phone11',\r\n" + 
					"prof.phone 'professional_phone11',\r\n" + 
					"ps.PERMANENTADDRESS 'perm_addr111', ps.PERMANENTADDRESS2 'peradd2', ps.PERMANENTADDRESS3 'peradd3',ps.PERMANENTADDRESS4 'peradd4',ps.PERMANENTZIP 'perm_pincode11',\r\n" + 
					"ps.COMMUNICATIONADDRESS 'comm_addr111', ps.COMMUNICATIONADDRESS2 'commadd11',ps.COMMUNICATIONADDRESS3 'commadd113', ps.COMMUNICATIONADDRESS4 'commadd4',\r\n" + 
					"ps.COMMUNICATIONZIP 'comm_pincode',IFNULL(COMMLOC.NAME,'') COMCITY,IFNULL(COMMSTATELOC.NAME,'')COMMSTATE,\r\n" + 
					"IFNULL(PLOC.NAME,'') PCITY, IFNULL(PSLOC.NAME,'')PSTATE\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"from hclhrm_prod.tbl_employee_primary B\r\n" + 
					"left join hclhrm_prod.tbl_employee_other_detail other on other.employeeid=b.employeeid\r\n" + 
					"left join hcladm_prod.tbl_bank_details banks on banks.bankid=other.bankid\r\n" + 
					"left join hclhrm_prod_others.tbl_emp_bank_ifc ifc on ifc.empid=b.employeeid\r\n" + 
					"left join hcladm_prod.tbl_title tit on tit.title=b.title\r\n" + 
					"left join hclhrm_prod.tbl_employee_personalinfo per on per.employeeid=b.employeeid\r\n" + 
					"left join hclhrm_prod.tbl_employee_professional_contact prof on prof.employeeid=b.employeeid\r\n" + 
					"left join hclhrm_prod.tbl_employee_personal_contact ps on ps.employeeid=b.employeeid\r\n" + 
					"LEFT JOIN hclhrm_prod.tbl_employee_personal_contact D 	ON b.EMPLOYEEID=D.EMPLOYEEID\r\n" + 
					"LEFT JOIN HCLLCM_PROD.TBL_LOCATION COMMLOC ON D.COMMUNICATIONLOCATIONID=COMMLOC.LOCATIONID\r\n" + 
					"LEFT JOIN HCLLCM_PROD.TBL_LOCATION COMMSTATELOC ON COMMLOC.PARENT=COMMSTATELOC.LOCATIONID\r\n" + 
					"LEFT JOIN HCLLCM_PROD.TBL_LOCATION PLOC 	ON D.PERMANENTLOCATIONID=PLOC.LOCATIONID\r\n" + 
					"LEFT JOIN HCLLCM_PROD.TBL_LOCATION PSLOC ON PLOC.PARENT=PSLOC.LOCATIONID\r\n" + 
					"where b.status=1001 and b.employeesequenceno="+empID+"; ");

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

						
				
				JSONObject obj5 = new JSONObject();
				for(int i=1;i<=countcol;i++)
				{
					String key = colnames.get(i-1);
					String val = Res1.getString(i);
					obj5.put(key, val);
				}
			
				reList4.add(obj5);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		if(Routing.equalsIgnoreCase("aadharandPan"))
		{
			System.out.println("the jason data is" + reList);
			System.out.println("the edit data ::" + query1ol);
			out.write(reList.toString());
			
		}
		if(Routing.equalsIgnoreCase("bankDetails"))
		{
			System.out.println("the jason data is" + reList1);
			out.write(reList1.toString());
			
		}if(Routing.equalsIgnoreCase("communication"))
		{
			System.out.println("the jason data is" + reList2);
			out.write(reList2.toString());
			
		}if(Routing.equalsIgnoreCase("PermaneatDetails"))
		{
			System.out.println("the jason data is" + reList3);
			out.write(reList3.toString());
			
		}if(Routing.equalsIgnoreCase("PersonalDetails12"))
		{
			
			System.out.println("the jason data is" + reList4);
			out.write(reList4.toString());
		}
		
		
		
		
		
		
		
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
		
		try {
			ConnectionpoolFilter.close(conn, Res,"Emp_All_Details_list",false);
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
