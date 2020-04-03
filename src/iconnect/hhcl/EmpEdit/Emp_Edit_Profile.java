package iconnect.hhcl.EmpEdit;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;
import net.sf.json.JSONObject;








/**
 * Servlet implementation class Emp_Edit_Profile
 */
public class Emp_Edit_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object statement;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Emp_Edit_Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext c = getServletContext();
		Statement statement=null;
		java.sql.ResultSet Res = null;
		// DataSource dataSource=null;
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
	HttpSession session=request.getSession();
			
		/*
		 * try { //conn =dataSource.getConnection();
		 * conn=(java.sql.Connection)session.getAttribute("ConnectionObj"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
	
	final Logger logger = Logger.getLogger(Emp_Edit_Profile.class);
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
	
	
	
	
	
	
	
		//HttpSession session = request.getSession(false);
		String	user_id=(String)session.getAttribute("EMP_ID");
		
		System.out.println("mobil");
		System.out.println(user_id+"/////// ... user_id");
		System.out.println("<---------------Emp Edit profile-----------> ");
		String username = request.getParameter("username");
		
		String GetRouting = request.getParameter("Routing");
		PrintWriter out = response.getWriter();
	
		System.out.println("GetRouting" + GetRouting);
		GetDbData DataObj = new GetDbData();
     
		int AuthCode = 0;
		Res = null;
		String Code = "1002";
		String message = "Invalid  Mobile Number..!";
		JSONObject jason = new JSONObject();
		StringBuffer Datavalid = new StringBuffer();
		String generatedPassword="";
		Map map=new HashMap();
		String Hrid="";
		
		jason.put("message", message);
		jason.put("Code", Code);

		int size=0;
		int moblength1 = 0;
		
		
		String a1="",a2="",a3="",a4="",a5="",a6="",a7="",a8="",a9="",a10="",a11="";
		 String username1 = "", name ="",ifcscode = "",bnkname="", accno = "",aadharno="", pannum = "",pemail ="", personalmobile="", profimobile="",village="", monddal="";
		
		//personal_edit_details
		 String	user_id1=(String)session.getAttribute("EMP_ID");
		 String emailname=request.getParameter("email1");
			String mobile1 = request.getParameter("mobile");
			String promoblie1 = request.getParameter("promobile");
			String dofb = request.getParameter("dateofb");
			String number = request.getParameter("number");
			String pmunber=" ",
			 pronum=" ",
			 pdofb=" ",
			 emailId=" ", 
			 sts = " ";
			int Statusper1=0; 
			String Statusa=" ";
			int Statusp1=00;int Statusp=00;int Statusb=00; int Statusc=00; int Statusc1=0; int Statusb1=00;int Statusper=00;int Statusa1=00;
			System.out.println("the values are::"+emailname+""+mobile1+""+dofb+""+number+""+promoblie1);
		// communication addr Emp_Communication_Edit_details
		/*
		 * var address2 = $("#address2").val(); var address12 = $("#address12").val();
		 * var address112 = $("#address112").val(); var address112 =
		 * $("#address112").val();
		 */
		/*
		 * var addressI = $("#address").val(); var address1I = $("#address1").val(); var
		 * address11I = $("#address11").val(); var address111I = $("#address111").val();
		 */
			String reason1="",reason2="",reason3="",reason4="";
			
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city1");
			String  Communicationaddress = request.getParameter("addressO12");
			
			
			
			String  Communicationaddress1 = request.getParameter("addressA");
			String  Communicationaddress2 = request.getParameter("address12");
			String  Communicationaddress3 = request.getParameter("addressB");
			String pin = request.getParameter("pin");
			
			System.out.println("the Communicationaddress1 Addresss:"+Communicationaddress+"one"+Communicationaddress1+"two"+Communicationaddress2+"three"+Communicationaddress3+"four"+pin);

			
		//PERMANENT addr
			String country2 = request.getParameter("country2");
			String state2 = request.getParameter("state2");
			String city2 = request.getParameter("city2");
			String  PERMANENTaddr = request.getParameter("addressO");
			String  PERMANENTaddr1 = request.getParameter("addressB");
			String  PERMANENTaddr2 = request.getParameter("addressS");
			String  PERMANENTaddr3 = request.getParameter("addressL");
			String pin2 = request.getParameter("pin2");
			
			System.out.println("the permaneat Addresss:"+state2+"one"+PERMANENTaddr1+"two"+PERMANENTaddr2+"three"+PERMANENTaddr3+"four"+pin2);
			
			
		int count=0;
		String exists="your request is under Processing";
	ResultSet rs=null;
		/*
		 * slno, empId, Personalmobile, Professionalmobile, Dateofbirth, otp,
		 * dateofmodification, Status,email
		 */
		
		//form 1 for personal details
		
		if(GetRouting.equalsIgnoreCase("form1"))
		{
			//StringBuffer  valid = new StringBuffer();
			//select max(slno),count(empId),Status,reason from hclhrm_prod.emp_aadhar_pan_edit_details  where empId="+user_id1+" and Status=1001   "
			 // valid.append(" select count(empId) from hclhrm_prod.personal_edit_details  where empId="+user_id1+" ");
			  String validf ="select max(slno),count(empId),Status,reason from hclhrm_prod.personal_edit_details  where empId="+user_id1+" and Status=1001 ;"; 
			try {
				
				Res=(ResultSet)DataObj.FetchData(validf.toString(), "Req_Adj", Res ,conn);
				if(Res.next()){
					count=Res.getInt(2);
					Statusp=Res.getInt(3);
					
					//System.out.println("the reson is:fsdfsdfsdfsdsfsdfdfsfsdfdfsf"+count);

				} 
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			 String validf1 ="select max(slno),count(empId),Status,reason from hclhrm_prod.personal_edit_details  where empId="+user_id1+" and Status=1002; ";
				try {
					
					Res=(ResultSet)DataObj.FetchData(validf1.toString(), "Req_Adj", Res ,conn);
					if(Res.next()){
						count=Res.getInt(3);
						reason1=Res.getString("reason");
						Statusp1=Res.getInt(3);
						
						System.out.println("the reson ols gangadhara"+reason1);

					} 
					 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
			
			System.out.println("the user count is::"+count);
			//int count=1; 
			if(Statusp!=1001 || Statusp1==1002) {
				System.out.println("the reson is:fsdfsdfsdfsdsfsdfdfsfsdfdfsf"+Statusp);

			
				try {
					
			
					
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					   LocalDateTime now = LocalDateTime.now();
					   String data=dtf.format(now);
					
					StringBuffer  query = new StringBuffer();
					query.append(" insert into hclhrm_prod.personal_edit_details(empId,Personalmobile,Professionalmobile, Dateofbirth,");
					query.append("dateofmodification,email )   values( ?,?,?,?,?,? ); ");
						System.out.println(query );	
					ps=conn.prepareStatement(query.toString());
					ps.setString(1, user_id1);
					
					ps.setString(2,mobile1);
					ps.setString(3, promoblie1);
					ps.setString(4, dofb);
					ps.setString(5,data );
					ps.setString(6,emailname);
					int res = ps.executeUpdate();
					System.out.println("the mobile otp exicute query::"+res);
					
					if(res==1)
					{
						StringBuffer getdata = new StringBuffer();
				 getdata.append("select * from hclhrm_prod.personal_edit_details where empId="+user_id1+"");

					 Res=(ResultSet)DataObj.FetchData(getdata.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							pmunber=Res.getString(3);
							
							System.out.println("the values fro select data:"+pmunber);

							
						} 
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else
		{
			jason.put("exists", exists);
			jason.put("count", count);
			
		}
	}
		//form 2 communication Emp_Communication_Edit_details 
		/*
		 * slno, empId, CommunicationAddress, country, state, city, pin,
		 * Dateofmodification, Status
		 */
		
		/*
		 * ----------------------------------------------------------------------------- * -------------------------------------------------------------
		 */	
	
		if(GetRouting.equalsIgnoreCase("form2"))
		{
			String  validc ="select max(slno),count(empId),Status,reason from hclhrm_prod.emp_communication_edit_details  where empId="+user_id1+" and Status=1001 ; ";
				try {
					
					 Res=(ResultSet)DataObj.FetchData(validc.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							count=Res.getInt(1);
							//reason2=Res.getString("reason");
							Statusc=Res.getInt(3);
						}  
					 
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String  validc1 ="select max(slno),count(empId),Status,reason from hclhrm_prod.emp_communication_edit_details  where empId="+user_id1+" and Status=1002 ; ";
				try {
					
					 Res=(ResultSet)DataObj.FetchData(validc1.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							count=Res.getInt(1);
							Statusc1=Res.getInt(3);
							reason2=Res.getString("reason");
						}  
					 
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
				 
			
			
			
			//int count=1;
			if(Statusc!=1001||Statusc1==1002) {
			
				/*
				 * slno, empId, CommunicationAddress, country, state, city, pin,
				 * Dateofmodification, Status, communication2, communication3, communication4,
				 * reason
				 */				try {
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					   LocalDateTime now = LocalDateTime.now();
					   String data=dtf.format(now);
					
					StringBuffer  query = new StringBuffer();
					query.append(" insert into hclhrm_prod.emp_communication_edit_details(empId,CommunicationAddress,country, state,");
					query.append("city,pin,Dateofmodification,communication2,communication3,communication4 )   values( ?,?,?,?,?,?,?,?,?,? ); ");
						System.out.println(query );	
					ps=conn.prepareStatement(query.toString());
					ps.setString(1, user_id1);
					ps.setString(2,Communicationaddress);
					
					ps.setString(3, country);
					ps.setString(4, state);
					ps.setString(5,city);
					ps.setString(6, pin);
					ps.setString(7,data );
					ps.setString(8, Communicationaddress1);
					ps.setString(9, Communicationaddress2);
					ps.setString(10, Communicationaddress3);
					
					int res = ps.executeUpdate();
					
					
					System.out.println("the mobile otp exicute query::"+res);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				jason.put("exists", exists);
				jason.put("count", count);

			}
		}
		
		
		//form 3 PERMANENT add 
		
		if(GetRouting.equalsIgnoreCase("form3"))
		{
			
			//select max(slno),count(empId),Status,reason from hclhrm_prod.emp_permanentaddress_edit  where empId="+user_id1+" and Status=1001 ;
			String  validp ="select max(slno),count(empId),Status,reason from hclhrm_prod.emp_permanentaddress_edit  where empId="+user_id1+" and Status=1001 ; ";
			try {
				
				 Res=(ResultSet)DataObj.FetchData(validp.toString(), "Req_Adj", Res ,conn);
					if(Res.next()){
						count=Res.getInt(1);
						//reason3=Res.getString("reason");
						Statusper=Res.getInt(3);
					}  
				 
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			String  validp2 ="select max(slno),count(empId),Status,reason from hclhrm_prod.emp_permanentaddress_edit  where empId="+user_id1+" and Status=1002 ; ";
			try {
				
				 Res=(ResultSet)DataObj.FetchData(validp2.toString(), "Req_Adj", Res ,conn);
					if(Res.next()){
						count=Res.getInt(1);
						Statusper1=Res.getInt(3);
						reason3=Res.getString("reason");
					}  
				 
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			/*
			 * slno, PermanentAddress, country, state, city, pin, Dateofmodification,
			 * Status, empid, PermanentAddress2, PermanentAddress3, PermanentAddress4,
			 * reason
			 */			//int count=1;
			if(Statusper!=1001||Statusper1==1002) {
			
			
			
				try {
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					   LocalDateTime now = LocalDateTime.now();
					   String data=dtf.format(now);
					
					StringBuffer  query = new StringBuffer();
					//slno, Permanent Address, country, state, city, pin, Dateofmodification, Status, empid
					
					query.append(" insert into hclhrm_prod.emp_permanentaddress_edit(PermanentAddress,city, state,country,pin,Dateofmodification,empid,PermanentAddress2,"
							+ "PermanentAddress3,PermanentAddress4 )   values(?,?,?,?,?,?,?,?,?,?) ");
						System.out.println(query );	
					ps=conn.prepareStatement(query.toString());
					
					ps.setString(1,PERMANENTaddr);
					ps.setString(2,city2);
					ps.setString(3, state2);
					ps.setString(4, country2);
					ps.setString(5, pin2);
					ps.setString(6,data );
					ps.setString(7, user_id1);
					ps.setString(8, PERMANENTaddr1);
					ps.setString(9, PERMANENTaddr2);
					ps.setString(10, PERMANENTaddr3);
					int res = ps.executeUpdate();
					
					
					System.out.println("the mobile otp exicute query::"+res);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				jason.put("exists", exists);
				jason.put("count", count);

			}
		}
		
		
		
		
		
		
		
			if(GetRouting.equalsIgnoreCase("getvalid"))
			{
				
			System.out.println("/*-------OTP MOBILE-----------*/"+number);
					Random random = new Random();
					
					 generatedPassword = String.format("%04d", random.nextInt(10000));
					map=SMSGatewayCenterAPI.CallSmsData(number,generatedPassword);
					System.out.println("the map data is:"+map);
					
					try {
						
					// dateFormate= "yyyy-mm-dd hh:mm:ss";
						
						StringBuffer  query1 = new StringBuffer();
						query1.append(" update hclhrm_prod.personal_edit_details set otp='"+generatedPassword+"' where empId="+user_id+ "; ");
					
							System.out.println(query1 );	
						ps=conn.prepareStatement(query1.toString());
						
						int res = ps.executeUpdate();
						
						
						System.out.println("the mobile otp exicute query::"+res);
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
		
		
		  if(GetRouting.equalsIgnoreCase("getvalidmob")) {
		  Random random = new Random();  
		  generatedPassword = String.format("%04d", random.nextInt(10000));
		  map=SMSGatewayCenterAPI.CallSmsData(promoblie1,generatedPassword);
		  StringBuffer  query2 = new StringBuffer();
		  query2.append(" update hclhrm_prod.tbl_emp_profiled_update set otp='"+generatedPassword+"' where username="+username+ "; ");

			System.out.println(query2);
			try {
				ps=conn.prepareStatement(query2.toString());
				int res1 = ps.executeUpdate();
				
				System.out.println("the mobile otp exicute query::"+res1);
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		  }
		  
		  if(GetRouting.equalsIgnoreCase("form41"))
			{
				//StringBuffer  valid = new StringBuffer();
				
				 // valid.append(" select count(empId) from hclhrm_prod.personal_edit_details  where empId="+user_id1+" ");
			   
				  String validb ="select max(slno),count(empId),Status,reason from emp_edit_details.emp_list_table  where empId="+user_id1+" and Status=1001;  ";
				try {
					
					Res=(ResultSet)DataObj.FetchData(validb.toString(), "Req_Adj", Res ,conn);
					if(Res.next()){
						count=Res.getInt(1);
						//count=Res.getInt(1);
						//reason3=Res.getString("reason");
						Statusb=Res.getInt(3);
					} 
					 System.out.println("the user count is::"+count);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 String validi ="select max(slno),count(empId),Status,reason from emp_edit_details.emp_list_table  where empId="+user_id1+" and Status=1002;  ";
					try {
						
						Res=(ResultSet)DataObj.FetchData(validi.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							count=Res.getInt(1);
							if(Res.next()){
								count=Res.getInt(1);
								Statusb1=Res.getInt(3);
								reason3=Res.getString("reason");
								
								
							} 
						} 
						 System.out.println("the user count is::"+count);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				
				
				
				
				
				jason.put("count", count);
			}	
			
		  if(GetRouting.equalsIgnoreCase("form51"))
			{
				//StringBuffer  valid = new StringBuffer();
				
				 // valid.append(" select count(empId) from hclhrm_prod.personal_edit_details  where empId="+user_id1+" ");
				  String valid =" select max(slno),count(empId),Status,reason from hclhrm_prod.emp_aadhar_pan_edit_details  where empId="+user_id1+" and Status=1001   ";
				try {
					
					Res=(ResultSet)DataObj.FetchData(valid.toString(), "Req_Adj", Res ,conn);
					if(Res.next()){
						count=Res.getInt(2);
							//Statusa=Res.getInt(3);
						//	reason4=Res.getString("reason");
							
						
					} 
					 System.out.println("the user count is::"+count);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			  String valid1 =" select max(slno),count(empId),Status,reason from hclhrm_prod.emp_aadhar_pan_edit_details  where empId=" +user_id1+" and Status=1002  "; 
			  try {
			  
			  Res=(ResultSet)DataObj.FetchData(valid1.toString(), "Req_Adj", Res ,conn);
			  if(Res.next()){ 
				  count=Res.getInt(2); Statusa1=Res.getInt(3);
			  reason4=Res.getString("reason");
			  
			  
			  } System.out.println("the user count is::"+count); } catch (SQLException e1)
			  { // TODO Auto-generated catch block e1.printStackTrace();
				  
			  }
			  
			} 
			  	
				
		  
		  
		  
		  
		  if(GetRouting.equalsIgnoreCase("HRFOR"))
			{
				
			  Hrid=user_id1;
			  }
			  
			
			  if(GetRouting.equalsIgnoreCase("reasons"))
				{
					//StringBuffer  valid = new StringBuffer();
				
					  String valid11 =" select  personal_mobile_reason, profissinal_mobile_reason, dateofbirth_reason, communication_addres_reason, PERMANENT_ADDRESS_reason, bank_reason, email_reason, aadhar_reject_reason, pan_reason, passsport_reason, drivinglicense_reason from emp_edit_details.emp_accept_table  where empId="+user_id1+" and Status=1003 ;" + 
					  		" ";
					try {
						
						Res=(ResultSet)DataObj.FetchData(valid11.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
					
							a1= Res.getString("personal_mobile_reason");
							a2=Res.getString("profissinal_mobile_reason");
							a3=Res.getString("dateofbirth_reason");
							a4=Res.getString("communication_addres_reason");
							a5=Res.getString("PERMANENT_ADDRESS_reason");
							a6=Res.getString("bank_reason");
							a7=Res.getString("email_reason");
							a8=Res.getString("aadhar_reject_reason");
							a9=Res.getString("pan_reason");
							a10=Res.getString("passsport_reason");
							a11=Res.getString("drivinglicense_reason");
							
						System.out.println("the values are ::"+a1+""+a3);	 
								
							
						} 
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					 String valid1 =" select reason from emp_edit_details.emp_list_table  where slno=" +count+" "; 
					  try {
					  
					  Res=(ResultSet)DataObj.FetchData(valid1.toString(), "Req_Adj", Res ,conn);
					  if(Res.next()){ 
						
					  reason4=Res.getString("reason");
					  
					  
					  } System.out.println("the user count is::"+count); } catch (SQLException e1)
					  { // TODO Auto-generated catch block e1.printStackTrace();
						  System.out.println("the user  is::"+reason4);  
					  }
			}	
			
			
		
			  jason.put("a1", a1);jason.put("a2", a2);jason.put("a3", a3);jason.put("a4", a4);jason.put("a5", a5);
			  jason.put("a6", a6);jason.put("a7", a7);jason.put("a8", a8);jason.put("a9", a9);jason.put("a10", a10);
			  jason.put("a11", a11);
			  
			
		
			jason.put("count", count);
			 jason.put("reason1", reason1);
			 jason.put("reason2", reason2);
			  jason.put("reason3", reason3);
			  jason.put("reason4", Statusa);
			  
			  
			  
			  
			  jason.put("Statusp", Statusp);jason.put("Statusp1", Statusp1);
			  
			  jason.put("Statusa", Statusa);
			  
			  
			  jason.put("Statusa1", Statusa1);
			  
			  jason.put("Statusb", Statusb);jason.put("Statusb1", Statusb1);
			  
			  jason.put("Statusc", Statusc);
			  jason.put("Statusc1", Statusc1);
			  jason.put("Statusper", Statusper); jason.put("Statusper1", Statusper1);
			  
		 
		jason.put("GetRouting", GetRouting);
		 jason.put("pmunber", pmunber);
		 jason.put("pronum", pronum);
		 jason.put("pdofb", pdofb);
		 jason.put("emailId", emailId);
		 jason.put("sts", sts);
		 jason.put("count", count);
		jason.put("username", username);
		jason.put("MobileP",mobile1);
		jason.put("message", map.get("message"));
		jason.put("Number", map.get("Mobile"));
		
		jason.put("Code", map.get("ErrorCode"));
		jason.put("OTP", generatedPassword);
		
		
		
		jason.put("Hrid1", Hrid);
		
		session.setAttribute("SMSDATA", map);

		
		System.out.println("the sms message is :"+ map.get("ErrorCode"));
		
		System.out.println("the obulesu code is :::"+jason);
		
		out.write(jason.toString());
		
		
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
		 * try { ConnectionpoolFilter.close(conn, Res,"Emp_Edit_Profile",false); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * long end = System.currentTimeMillis(); float sec = (end - start) / 1000F;
		 * logger.info("Login servlet Main  execution time in Seconds ::"+ sec);
		 * request.setAttribute("Excecutiontime", sec +" Sec");
		 */
		
	}
	
	}

	













































