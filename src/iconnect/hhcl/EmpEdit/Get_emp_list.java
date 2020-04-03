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
 * Servlet implementation class Get_emp_list
 */
public class Get_emp_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get_emp_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		System.out.println("<---------------Emp Edit profile hr Approvals-----------> ");
		Statement statement=null;
		ResultSet Res = null;
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
		String	user_id=(String)session.getAttribute("EMP_ID");
	
		
		final Logger logger = Logger.getLogger(Get_emp_list.class);
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
		 * try { //conn =dataSource.getConnection();
		 * conn=(java.sql.Connection)session.getAttribute("ConnectionObj"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
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

	
		ps = null;
		Res = null;
		ResultSetMetaData rsmd = null;

		System.out.println("Hr approvals ");
	
		 String  DATEOFBIRTH=" ", BANKNAME=" ", IFSC=" ", ACCOUNTNO=" ", AADHAARCARDNO=" ", AADHAARNAME=" ", DRIVINGLICENSENO=" ",
					PASSPORTNO=" ", pan=" ", personal_email=" ", personal_phone=" ", professional_phone=" ", perm_addr1=" ", 
					PERMANENTADDRESS2=" ", PERMANENTADDRESS3=" ", PERMANENTADDRESS4=" ", perm_pincode=" ", comm_addr1=" ",
					COMMUNICATIONADDRESS2=" ", COMMUNICATIONADDRESS3=" ", COMMUNICATIONADDRESS4=" ", comm_pincode=" ",COMCITY=" ", 
					COMMSTATE=" ", PCITY=" ", PSTATE=" ";
			
			try {
				
			
				
				StringBuffer  query1 = new StringBuffer();
				
		
				query1.append("  select\r\n" + 
						"B.employeesequenceno'EmpID',\r\n" + 
						"concat(tit.name,' ',B.CALLNAME)'NAME',\r\n" + 
						"b.DATEOFBIRTH,\r\n" + 
						"ifnull(banks.BANKNAME,'--')'BANKNAME',\r\n" + 
						"ifnull(ifc.bankifc,'--')'IFSC',\r\n" + 
						"ifnull(other.ACCOUNTNO,'--')'ACCOUNTNO',\r\n" + 
						"per.AADHAARCARDNO 'AADHAARCARDNO',\r\n" + 
						"per.AADHAARNAME 'AADHAARNAME',\r\n" + 
						"per.DRIVINGLICENSENO 'DRIVINGLICENSENO',\r\n" + 
						"per.PASSPORTNO 'PASSPORTNO',\r\n" + 
						"per.pan 'pan',\r\n" + 
						"ps.email 'personal_email',\r\n" + 
						"ps.phone 'personal_phone',\r\n" + 
						"prof.phone 'professional_phone',\r\n" + 
						"ps.PERMANENTADDRESS 'perm_addr1', ps.PERMANENTADDRESS2, ps.PERMANENTADDRESS3,ps.PERMANENTADDRESS4,ps.PERMANENTZIP 'perm_pincode',\r\n" + 
						"ps.COMMUNICATIONADDRESS 'comm_addr1', ps.COMMUNICATIONADDRESS2,ps.COMMUNICATIONADDRESS3, ps.COMMUNICATIONADDRESS4,\r\n" + 
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
						"\r\n" + 
						"where b.status=1001 and b.employeesequenceno="+user_id+"; ");
				
					System.out.println(query1 );
					
					Res=(ResultSet)DataObj.FetchData(query1.toString(), "Req_Adj", Res ,conn);
				
				if(Res.next())
				{
					 
					 DATEOFBIRTH=Res.getString(3); BANKNAME=Res.getString(4) ;IFSC=Res.getString(5);
					 ACCOUNTNO=Res.getString(6); AADHAARCARDNO=Res.getString(7); AADHAARNAME=Res.getString(8);
					 DRIVINGLICENSENO=Res.getString(9);
							PASSPORTNO=Res.getString(10); pan=Res.getString(11); personal_email=Res.getString(12);
							personal_phone=Res.getString(13); professional_phone=Res.getString(14); perm_addr1=Res.getString(15); 
							PERMANENTADDRESS2=Res.getString(16); PERMANENTADDRESS3=Res.getString(17); PERMANENTADDRESS4=Res.getString(18);
							perm_pincode=Res.getString(19); comm_addr1=Res.getString(20);
							COMMUNICATIONADDRESS2=Res.getString(21); COMMUNICATIONADDRESS3=Res.getString(22); COMMUNICATIONADDRESS4=Res.getString(23);
							comm_pincode=Res.getString(24);
							COMCITY=Res.getString(25); COMMSTATE=Res.getString(26);
							PCITY=Res.getString(27); PSTATE=Res.getString(28);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			jason.put("GetRouting", GetRouting);
			jason.put("DATEOFBIRTH", DATEOFBIRTH);jason.put("BANKNAME", BANKNAME);jason.put("IFSC", IFSC);
			jason.put("ACCOUNTNO", ACCOUNTNO);jason.put("AADHAARCARDNO", AADHAARCARDNO);jason.put("AADHAARNAME", AADHAARNAME);
			jason.put("DRIVINGLICENSENO", DRIVINGLICENSENO);jason.put("PASSPORTNO", PASSPORTNO);jason.put("pan", pan);
			jason.put("personal_email", personal_email);jason.put("personal_phone", personal_phone);jason.put("professional_phone", professional_phone);
			jason.put("perm_addr1", perm_addr1);jason.put("PERMANENTADDRESS2", PERMANENTADDRESS2);jason.put("PERMANENTADDRESS3", PERMANENTADDRESS3);
			jason.put("PERMANENTADDRESS4", PERMANENTADDRESS4);jason.put("perm_pincode", perm_pincode);jason.put("comm_addr1", comm_addr1);
			jason.put("COMMUNICATIONADDRESS2", COMMUNICATIONADDRESS2);jason.put("COMMUNICATIONADDRESS3", COMMUNICATIONADDRESS3);jason.put("COMMUNICATIONADDRESS4", COMMUNICATIONADDRESS4);
			jason.put("comm_pincode", comm_pincode);jason.put("COMCITY", COMCITY);jason.put("COMMSTATE", COMMSTATE);
			jason.put("PCITY", PCITY);jason.put("PSTATE", PSTATE);
			
		
		/*
		 * EmpID, NAME, DATEOFBIRTH, BANKNAME, IFSC, ACCOUNTNO, AADHAARCARDNO,
		 * AADHAARNAME, DRIVINGLICENSENO, PASSPORTNO, pan, personal_email,
		 * personal_phone, professional_phone, perm_addr1, PERMANENTADDRESS2,
		 * PERMANENTADDRESS3, PERMANENTADDRESS4, perm_pincode, comm_addr1,
		 * COMMUNICATIONADDRESS2, COMMUNICATIONADDRESS3, COMMUNICATIONADDRESS4,
		 * comm_pincode
		 */
		 
		
			

			reList.add(jason);
			

		//jsonArray.add(jason);
		System.out.println("the jason data is" + reList);
		out.write(reList.toString());

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
