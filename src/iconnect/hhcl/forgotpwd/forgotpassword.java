package iconnect.hhcl.forgotpwd;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class forgotpassword
 */
public class forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet Res=null;
		//DataSource dataSource=null;
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		
		java.sql.PreparedStatement ps1=null;
		String GetRouting=request.getParameter("Routing");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		System.out.println("GetRouting" +GetRouting);
		GetDbData DataObj=new GetDbData();
		//String ExpMsg=null;
		//String WgOMsg=null;
		JSONObject jason = new JSONObject();
		String username = request.getParameter("username");
		
		String generatedPassword=null;
		String Mobile="00";
		@SuppressWarnings("rawtypes")
		Map map=new HashMap();
		//String mobile = request.getParameter("mobile");
		//String mobile1 = request.getParameter("mobile1");
		
		//System.out.println("the mobile nubers are :::"+mobile+""+mobile1);
		
		System.out.println(" user id"+username);
		
		jason.put("MOBILE", "NA");
		jason.put("username", "NA");
		jason.put("message", "NA");
		jason.put("Code", "NA");
		jason.put("OTP", "NA");
		jason.put("succ", "NA");
		
		String password = request.getParameter("password");
		String inputOtp = request.getParameter("OTP");
		String SUBROUTE = request.getParameter("SUBROUTE");
		Mobile = request.getParameter("Mobile");
		String DBMobile=null;
		String ALTMOBILE=request.getParameter("Mobile");
		
		System.out.println("EMP FORGOT OTP AND PASSWORD"+password+"!"+inputOtp+"!"+ALTMOBILE+"!"+SUBROUTE);
		
		
		
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
		
		final Logger logger = Logger.getLogger(forgotpassword.class);
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
		
		
		
		if(GetRouting.equalsIgnoreCase("Submitform")){
			
			StringBuffer validOTP=new StringBuffer();
			int otpvalid=0;
			
			validOTP.append(" select count(*), IF(TIMEDIFF(TIME(now()),TIME(TIMESTAMP))<=TIME(concat('00',VALID,'00')),1,0),TIMEDIFF(TIME(now()),TIME(TIMESTAMP) ) from test.tbl_employee_forgot_pass ");
			validOTP.append(" where employeeid="+username+" and OTP="+inputOtp+" ");
		
			System.out.println("Datavalid::" +validOTP.toString());
		try {
			Res=(ResultSet)DataObj.FetchData(validOTP.toString(), "Req_Adj", Res ,conn);
			if(Res.next()){
				otpvalid=Res.getInt(1);
			}  
		}catch(Exception Er){
			System.out.println("Exception At Er::"+Er);
		}
		 if(otpvalid>0) {
			 
			 try {
				conn.setAutoCommit(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			StringBuffer passupd = new StringBuffer();
			
			StringBuffer rollbacktbl = new StringBuffer();
				
			rollbacktbl.append(" update test.tbl_employee_forgot_pass A ") ;
			rollbacktbl.append(" JOIN hclhrm_prod.tbl_employee_login B " );
			rollbacktbl.append(" on B.employeecode=A.employeeid ");
			rollbacktbl.append(" SET A.OLDPASSWORD=B.PASSWORD , ");
			rollbacktbl.append(" A.NEWPASSWORD='"+password+"' "); 
			rollbacktbl.append(" , A.STATUS=1002 ");
			rollbacktbl.append(" where A.OTP="+inputOtp+" AND A.employeeid="+username+" "); // 2-OTP,3 -empid
			rollbacktbl.append(" and B.employeecode="+username+" and b.employeeid!=1 "); // 4-empid,
				
			System.out.println("rollbacktbl::" +rollbacktbl.toString());
			
				passupd.append(" insert into hclhrm_prod.tbl_employee_login(EMPLOYEEID, EMPLOYEECODE, PASSWORD, STATUS, LOGID, ");
				passupd.append("	CREATEDBY, DATEMODIFIED,LUPDATE )");
				passupd.append(" select employeeid,employeesequenceno,md5('"+password+"'),'1001',01,1001,now(),now() ");
				passupd.append(" from hclhrm_prod.tbl_employee_primary where employeesequenceno in("+username+") ");
				passupd.append(" 	ON DUPLICATE KEY UPDATE EMPLOYEECODE="+username+" , PASSWORD=md5('"+password+"'),STATUS=1001, ");
				passupd.append(" LUPDATE=now() ,LOGID=1001 ");
				
			
				System.out.println("passupd::" +passupd.toString());	

           // Start insertion Query 
				try { 
						  ps=conn.prepareStatement(rollbacktbl.toString()); 
						  int res = ps.executeUpdate();
						  
						System.out.println("HAII" +res);
						
						 // ps=null; 
						  ps1=conn. prepareStatement(passupd.toString()); 
								
						  System.out.println(ps.toString()+ "Forgot password Data :"+username+"Otp"+generatedPassword+"MOBILE"+Mobile);
						  int res1 = ps1.executeUpdate();
						  System.out.println("the insert date count ::::"+res1);
				  
				  if(res1>0) {
					    
					    conn.commit();
					    jason.put("MOBILE", "");
						jason.put("username", username);
						jason.put("message", " <span class='succesmsg'>Your Password has been updated successfully..!<br><B> Redirecting to <a href='login.html' >iConnect</a> </B> &nbsp;<span style='color:red'><B><span id='timed'> 5 </span> Sec. </span> </B></span>");
						jason.put("Code", "1000");
						jason.put("OTP", "0000");
						jason.put("succ", "success");
				     
				  }else {
					  conn.rollback();
					    jason.put("MOBILE", "");
						jason.put("username", username);
						jason.put("message", "Unable to Connect Database Server Please try again/contact admin..!");
						jason.put("Code", "4000");
						jason.put("OTP", "0000");
						jason.put("succ", "fails");
						
				  }
				  
				  } catch (SQLException e) { // TODO Auto-generated catch block
					  
					    try {
							conn.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    jason.put("MOBILE", "");
						jason.put("username", username);
						jason.put("message", "Unable to Connect Database Server Please try again/contact admin..!");
						jason.put("Code", "4000");
						jason.put("OTP", "0000");
						jason.put("succ", "fails");
						
				  e.printStackTrace(); 
				  
				  }
				 
			  
			 
			 
			 
			 //End insertion Query out
			 
			 
			   
			 
		 }else {
			 
			    jason.put("MOBILE", "");
				jason.put("username", username);
				jason.put("message", "Invalid Credientials/In valid OTP/OTP Expire & Get otp again");
				jason.put("Code", "50001");
				jason.put("OTP", "20000");
				jason.put("SSSSSsucc", "CODE");
		 }
		
		
			
		}else if(GetRouting.equalsIgnoreCase("forgotpwd")) {
			request.getRequestDispatcher("Hhc_forgot_password.jsp").forward(request, response);
		}else {
			
			int AuthCode=0;
			// Mobile="00";
			int moblength=0;
			Res=null;
			String Code="1002";
			String message="Invalid UserID/ Mobile Number..!";
			String Succ="succ";
			
			StringBuffer Datavalid=new StringBuffer();
			
			jason.put("MOBILE", Mobile);
			jason.put("message",message);
			jason.put("Code",Code);
			
			
				Datavalid.append(" select count(*) ,ifnull(b.mobile,0) MOBILE,length(ifnull(b.mobile,0)) MOBLENGTH from hclhrm_prod.tbl_employee_primary a ");
				Datavalid.append(" left join hclhrm_prod.tbl_employee_professional_contact b on a.employeeid=b.employeeid ");
				Datavalid.append(" where a.employeesequenceno="+username);
				Datavalid.append(" and a.status=1001 ");
				
			
				System.out.println("Datavalid::" +Datavalid.toString());
			try {
				Res=(ResultSet)DataObj.FetchData(Datavalid.toString(), "Req_Adj", Res ,conn);
				
				jason.put("Code", "1002");
				jason.put("message", "Invalid mobile number please contact HR. ");
				if(Res.next()){
					AuthCode=Res.getInt(1);
					if(AuthCode<=0) {
						
						jason.put("message", "Invalid UserID ..!");
					}
					DBMobile=Res.getString("MOBILE");
					moblength=Res.getInt("MOBLENGTH");
					if(SUBROUTE.equalsIgnoreCase("ALMB")) {
					   Mobile=Mobile; 
					   moblength=10;
					}else {
					  Mobile=Res.getString("MOBILE");
					}
					
					if(moblength>=10 && AuthCode>0) {
						jason.put("Code", "1001");
						jason.put("message", "Please click on <span style='color:#7303fc'>'GET OTP'</span>");
					}else if(moblength<10 && AuthCode>0) {
						
						jason.put("Code", "1002");
						jason.put("message", "Invalid mobile number please contact HR.");
						
					}
					
					jason.put("MOBILE", DBMobile);
					jason.put("ALTMOBILE", "");
					jason.put("username", username);
					
					jason.put("OTP", "0");
					jason.put("succ", "0");
					
					
				} else {
					
					jason.put("MOBILE", "");
					jason.put("ALTMOBILE", "");
					jason.put("username", username);
					jason.put("message", "invalid userid ..!");
					jason.put("Code", "1002");
					jason.put("OTP", "0");
					jason.put("succ", "0");
				}
			}catch(Exception Er){
				System.out.println("Exception At Er::"+Er);
			}finally {
				
				
			}
				//	hlday.put(Res.getString(1), Res.getString(2));
			
			if(AuthCode>0 && moblength>=10 && GetRouting.equalsIgnoreCase("Getsms") ) {
				
				Random random = new Random();
				//Map map=new HashMap();
			    generatedPassword = String.format("%04d", random.nextInt(10000));
				map=SMSGatewayCenterAPI.CallSmsData(Mobile,generatedPassword);
				
				
				System.out.println("DATA FROM SERVICE:" +map.toString());
				
				
				
				// Date Difference Validatetion
				
				  String Date = dateFormate(); System.out.println("the current date ::"+Date);

				  
				  try { 
					  ps=conn. prepareStatement("insert into test.tbl_employee_forgot_pass (EMPLOYEEID,OLDPASSWORD, NEWPASSWORD, OTP, MOBLE, ALTMOBILE,TIMESTAMP) values (?,?,?,?,?,?,now()) ");
					  ps.setString(1, username);
					  ps.setString(2, "NA");
					  ps.setString(3, "NA"); 
					  ps.setString(4, generatedPassword);
					  if(DBMobile!=null) {
					  ps.setString(5, DBMobile);
					  }else {
						  ps.setString(5, "0000000000");
					  }
					  if(ALTMOBILE!=null) {
					    ps.setString(6, ALTMOBILE);
					  }else {
						  ps.setString(6, "0000000000");
					  }
				  int res = ps.executeUpdate();
				  System.out.println("the insert date count ::::"+res);
				 
				  if(res<=0) {
					  map.put("message", "Unable to Connect Database ..!");
					  map.put("Code", "400");
					}
				  
				  } catch (SQLException e) { // TODO Auto-generated catch block
				  e.printStackTrace(); }
				  
				map.put("OTP", generatedPassword);
				jason.put("MOBILE", Mobile);
				jason.put("ALTMOBILE", ALTMOBILE);
				jason.put("username", username);
				jason.put("message", map.get("message"));
				jason.put("Code", map.get("ErrorCode"));
				jason.put("OTP", generatedPassword);
				jason.put("succ", Succ);
				
				session.setAttribute("SMSDATA", map);
				/*
				 * map.put("message", message); map.put("ErrorCode", ErrorCode);
				 * map.put("Mobile", Mobile);
				 */
				
			}else {
				
				
			}
				 
			System.out.println("jason.toString()::" +jason.toString());
			
		}
		try {
			
			conn.close();
			
		}catch(Exception err) {
			err.printStackTrace();
			
			
			 try {
					ConnectionpoolFilter.close(conn, Res,"forgotpassword",true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        long end = System.currentTimeMillis();
				float sec = (end - start) / 1000F;
			    logger.info("Login servlet Main  execution time in Seconds ::"+ sec);
			    request.setAttribute("Excecutiontime", sec +" Sec");
			
			
			
			
			
		}
		out.write(jason.toString());
	}
	
	
	//DateFormate
		public static  String dateFormate()
		{
			Date d= new Date();
			String formateDate = "yyyy-mm-dd hh:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(formateDate);
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			return sdf.format(d);
		}
	// Date Difference
		public  static long date_difference(String Startdate)
		{
			String dateStop = dateFormate();
			Date DD = new Date();
			String formate = "yyyy-mm-dd hh:mm:ss";
			SimpleDateFormat sm = new SimpleDateFormat();
			Date d1=null; Date d2= null;
			try
			{
				 d1 = sm.parse(Startdate);
			     d2 = sm.parse(dateStop);
			     long diff = d2.getTime()-d1.getTime();
			     long diffMints = diff/(60*1000)%60;
			    return  diffMints;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 0;
				}
		}
	




}
