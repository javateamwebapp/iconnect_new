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

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Hr_Approvals_emp
 */
public class Hr_Approvals_emp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Hr_Approvals_emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String username = "";
		JSONArray jsonArray = new JSONArray();
		List<JSONObject> reList =new ArrayList<JSONObject>();
		ArrayList Rows = new ArrayList();
		String PersonalMobile = null, Pannumber = null, Bankifccode = null, Account_numbe = null, bankname = null,
				bankfile = null, panfile = null, PermanentAddress = null, CommunicationAddress = null,
				Professionalmobile = null, aadharno = null, aadharfile = null, email = "";

		JSONArray data = new JSONArray();
		JSONObject editdata = new JSONObject();
		JSONArray data1;

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		// int User_Auth=1;
		// username=(String)session.getAttribute("EMP_ID");
		// password=(String)session.getAttribute("EMP_PASSWORD");

		/*
		 * String filePathDirectory = "C://uploads//";
		 */
		/*
		 * try { //conn =dataSource.getConnection();
		 * conn=(java.sql.Connection)session.getAttribute("ConnectionObj"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
		
		
		final Logger logger = Logger.getLogger(Hr_Approvals_emp.class);
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
		// System.out.println("the user name :" + mobile);

		// System.out.println("the username ::"+);

		StringBuffer User_Authen = new StringBuffer();
		// User_Authen.append(Query);

		System.out.println("DB connection ::" + conn);

		Res = null;
		/*
		 * try { ps=conn.prepareStatement(User_Authen.toString());
		 * ps.setInt(1,Integer.parseInt(username)); ps.setString(2,password);
		 * Res=(ResultSet)DataObj.FetchDataPrepare_2(ps,
		 * "User Authentication",Res,conn); //Res=(ResultSet)DataObj.
		 * FetchData("Select * from hclhrm_prod.tbl_employee_primary",
		 * "UserAuthentiCation", Res ,conn); if(Res.next()){
		 * 
		 * User_Auth=Res.getInt(1); } } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */ Res = null;
		ps = null;
		Res = null;
		ResultSetMetaData rsmd = null;

		System.out.println("Hr approvals ");
		/*query1.append("select p.employeesequenceno 'EMPID',p.callname 'EMPNAME',E.NAME 'DEPARTMENTNAME',F.NAME 'DESIGNATION',\r\n" + 
				"a.Status'first',o.Status 'second',b.Status 'third',s.Status 'fourth',u.Status 'fiveth'\r\n" + 
				" FROM hclhrm_prod.tbl_employee_primary p\r\n" + 
				"left join hclhrm_prod.emp_aadhar_pan_edit_details a on a.empid=p.employeesequenceno\r\n" + 
				"LEFT JOIN hcladm_prod.tbl_businessunit C ON C.BUSINESSUNITID=p.COMPANYID\r\n" + 
				"LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS D ON p.EMPLOYEEID=D.EMPLOYEEID\r\n" + 
				"LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT E ON D.DEPARTMENTID=E.DEPARTMENTID\r\n" + 
				"LEFT JOIN hcladm_prod.tbl_designation F ON D.designationid=F.designationid\r\n" + 
				"left join hclhrm_prod.emp_communication_edit_details o on o.empId= p.employeesequenceno\r\n" + 
				"left join hclhrm_prod.emp_bank_details_edit s on s.empId = p.employeesequenceno\r\n" + 
				"left join hclhrm_prod.emp_permanentaddress_edit b on  b.empId=p.employeesequenceno\r\n" + 
				"left join hclhrm_prod.personal_edit_details u on u.empId=p.employeesequenceno\r\n" + 
				"where u.Status=1001 || b.Status=1001 || s.Status=1001 || o.Status=1001 || a.Status=1001\r\n" + 
				"GROUP by u.empid; ");
*/


		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("select p.employeesequenceno 'EMPID',p.callname 'EMPNAME',E.NAME 'DEPARTMENTNAME',F.NAME 'DESIGNATION',\r\n" + 
					"			a.Status'first'\r\n" + 
					"			 FROM hclhrm_prod.tbl_employee_primary p\r\n" + 
					"			left join emp_edit_details.emp_list_table a on a.EmpId=p.employeesequenceno\r\n" + 
					"			LEFT JOIN hcladm_prod.tbl_businessunit C ON C.BUSINESSUNITID=p.COMPANYID\r\n" + 
					"			LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS D ON p.EMPLOYEEID=D.EMPLOYEEID\r\n" + 
					"			LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT E ON D.DEPARTMENTID=E.DEPARTMENTID\r\n" + 
					"			LEFT JOIN hcladm_prod.tbl_designation F ON D.designationid=F.designationid\r\n" + 
					"			where a.Status=1001\r\n" + 
					"			GROUP by a.empid;\r\n" + 
					"			");

			
			
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
			
				reList.add(obj);
				 

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		System.out.println("the jason data is" + reList);
		/// json.put("children", toplevel);
		
		jsonArray.add(jason);
		System.out.println("the jason data is" + jsonArray);
		out.write(reList.toString());

		// request.setAttribute("EDIT_DATA_1", data1.toString());

		// System.out.println("the getting data is ::" + data1);

		System.out.println("_SUCCESS_PAGE::" + PAGE);
		// request.getRequestDispatcher(PAGE).forward(request, response);

		System.out.println("the page:::" + PAGE);

		
		
		
		
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
		 * try { ConnectionpoolFilter.close(conn, Res,"Hr_Approvals_emp",false); } catch
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
