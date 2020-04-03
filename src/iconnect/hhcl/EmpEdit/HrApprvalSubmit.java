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

import com.mysql.jdbc.Statement;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class HrApprvalSubmit
 */
public class HrApprvalSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrApprvalSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unused", "resource" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("the Hr Approval Start from here");
		
		
	int res1=0;
		java.sql.Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet Res=null;
		PrintWriter out = response.getWriter();
		
		JSONObject jason = new JSONObject();
		Statement statement=null;

		/*
		 * String filePathDirectory = "C://uploads//";
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
		
		
		final Logger logger = Logger.getLogger(HrApprvalSubmit.class);
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
		
		
		
		
		
		
		
		
		
		
		//personal 		//	pemail:email,Permob:Personalmobile,Profemob:Professionalmobile,Datebirth:Dateofbirth,

		int ols111=1002;
		
		
		String username = request.getParameter("user1");
		String email= request.getParameter("pemail");
		String GetRouting = request.getParameter("routing");
		String professionalmob= request.getParameter("Profemob");
		String personalmob= request.getParameter("Permob");
		String Dofb = request.getParameter("Datebirth");
		
		String emlrej=request.getParameter("Erej");
		String emreason=request.getParameter("txtE");
		String perMObrej=request.getParameter("PMrej");
		String permobreason=request.getParameter("txtPM");
		
		String proMobrej=request.getParameter("PROMrej");
		String proreason=request.getParameter("txtPROM");
		String dofbrej=request.getParameter("DOFBACREJ");
		String dofbreason=request.getParameter("txtDOFBACC");
		
		

				
		
		
		
		//Aadhar and Pan
		String panfile= request.getParameter("panfile");
		String pannumber= request.getParameter("pannumber");
		String aadharno= request.getParameter("aadharno");
		String aadharfile= request.getParameter("aadharfile");
		String aadharname=request.getParameter("aadharName");
		String passportNo=request.getParameter("passportNo");
		String drivelicNo=request.getParameter("drivelicNo");
		
		String aadharej=request.getParameter("aadharREJ");
		String aadhareason=request.getParameter("txtaadhar");
		String panrej=request.getParameter("panREJ");
		String panreas=request.getParameter("txtpan");
		String passrej=request.getParameter("passREJ");
		String passreaso=request.getParameter("txtpass");
		String drivlcrej=request.getParameter("drivlcREJ");
		String drivreason=request.getParameter("txtdrivlc");
		
		 
		//	txtcommunic:txtcommunic, communicrej:communicrej,txtperaddr:txtperaddr,
			//peraddrrej:peraddrrej
		
		
		
		
		
		String bankifccode= request.getParameter("bankifccode");
		String ACNO= request.getParameter("ACNO");
		String bankname= request.getParameter("bankname");
		String bankfile= request.getParameter("bankfile");
		
		String bankrej=request.getParameter("bankREJ");
		String bakreason=request.getParameter("txtbank");
		
		 
		
		
	//communication addr
		String cstate = request.getParameter("cState");
		String ccity= request.getParameter("ccity1");
		String commuaddress= request.getParameter("ccomadd1");
		String commuaddress1= request.getParameter("ccomadd2");
		String commuaddress2= request.getParameter("ccomadd3");
		String commuaddress3= request.getParameter("ccomadd4");
		String cpin= request.getParameter("cpin");
		
		String commaddrej=request.getParameter("communicrej");
		String commaddreason=request.getParameter("txtperaddr");
		
		
		String peraddrrej= request.getParameter("peraddrrej");
		String peraddrreas=request.getParameter("txtperaddr");
		
		
		
		
		//cstate,ccity,commuaddress,commuaddress1,commuaddress2,commuaddress3,cpin	
		
		//System.out.println("the communication city and State are::"+cstate+"city::"+ccity);
		
// per Addr		
		String pstate = request.getParameter("pemrstate");
		String pcity= request.getParameter("pcity");
		String peraddress= request.getParameter("peraddress");
		String peraddress1= request.getParameter("peraddress1");
		String peraddress2= request.getParameter("peraddress2");
		String peraddress3= request.getParameter("peraddress3");
		String ppin= request.getParameter("ppin");
		
		//pstate,pcity,peraddress,peraddress1,peraddress1,peraddress2,peraddress3,ppin
		//cstate,ccity,commuaddress,commuaddress1,commuaddress2,commuaddress3,cpin
		//pstate,pcity,peraddress,peraddress1,peraddress2,peraddress3,ppin
		//System.out.println("the permanat address city and State are::"+pstate+"city::"+pcity);
		
		String empt="";
	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   String dat2=dtf.format(now);
		
		
			HttpSession session = request.getSession(false);
			String Hr_id = (String) session.getAttribute("EMP_ID");
		
		
			
			int RejStaurs=0;
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		String reson = request.getParameter("");
		String Rejres = request.getParameter("Rej");
		System.out.println("the routing is "+Rejres);
		GetDbData DataObj = new GetDbData();
		System.out.println("the username is"+email+""+professionalmob+""+personalmob+""+Dofb);
		int backSatus=0;
		int empseqid=0000;
		StringBuffer sslo=new StringBuffer();
		
		sslo.append("select employeeid from hclhrm_prod.tbl_employee_primary where employeesequenceno in ("+username+");");

		System.out.println(sslo);
		try {
			
			Res=(ResultSet)DataObj.FetchData(sslo.toString(), "Req_Adj", Res ,conn);
			
			
			if(Res.next())
			{
				empseqid=Res.getInt(1);	
			
				System.out.println(empseqid);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//System.out.println("the HrMS EMP ID IS:"+empseqid);
		
		
		int Status_rej=1002;
		
		
		
		
		
		
		
		
/*-----------------------------------------------------------------Aadhar& Pan Details--------------------------------------------------------------*/	
		int Status=1002;int Status1 =1001;
//field1		
		
		  if(GetRouting.equalsIgnoreCase("AADHARNAMEA") && !aadharname.trim().isEmpty() && aadharname!=null ) {
			
			
			  StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
			  StringBuffer  queryEmai1 = new StringBuffer();
			  
			//  query1.append(" update emp_edit_details.emp_hr_accept_table set aadharName='"+aadharname+"', Status='"+Status+"' where EmpId="+username+ "; ");
			  
			  
			  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
			  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ "))"
			  		+ " k on k.slno=u.slno set u.aadharName='"+aadharname+"',Status='"+Status+"';");

			  
				System.out.println(query1);
				try {
					ps=conn.prepareStatement(query1.toString());
					 res1 = ps.executeUpdate();
					
					System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
				  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				//queryEmai.append(" update emp_edit_details.emp_accept_table set aadharName='"+aadharname+"',  Status='"+Status+"' where EmpId="+username+ "; ");
				
			/*
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid=20314))"
			 * +
			 * " k on k.slno=u.slno set u.aadharName='"+aadharname+"',Status='"+Status+"';")
			 * ;
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");
					
			/*
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
			 * + " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="
			 * +username+ "))" + " k on k.slno=u.slno set Status='"+Status+"';");
			 */
					queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
					
					

					System.out.println(queryEmai1);
					try {
						ps=conn.prepareStatement(queryEmai1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						backSatus=res1;
						
						
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
			
			  }
		    else
		    {
		    	empt="Empty field data";
		    }
			  
		   
		  	  if(aadharej.equalsIgnoreCase("AADHARNAMEREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer(); StringBuffer  query13 = new StringBuffer();
					  StringBuffer  query12 = new StringBuffer();StringBuffer  query56712 = new StringBuffer();

					  
					  
					  
					  query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
					  
					  
						System.out.println(query13);
						try {
							
							Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
							if(Res.next()){
								
								RejStaurs=Res.getInt(1);
								 
							}
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
						System.out.println("the obulesu  AAdhar is::"+RejStaurs);
					  if(RejStaurs==0)
					  {
						// insert
						  query56712.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,aadharName,aadharnumber,verifiedbyHr,Status_rej,dateofmodification,aadhar_reject_reason,Status)   values( ?,?,?,?,?,?,?,? ); ");
						  try {
							ps=conn.prepareStatement(query56712.toString());
							ps.setString(1, username);
							ps.setString(2,aadharname);
							ps.setString(3, aadharno);
							ps.setString(4, Hr_id);
							ps.setInt(5, Status_rej);
							ps.setString(6, dat2);
							ps.setString(7, aadhareason);
							ps.setInt(8, Status);
							
							int res = ps.executeUpdate();
							if(res>0)
							{
								System.out.println("Aadhar reject Status Succefilly inserted::"+res);
							}
						
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					  }
					  else
					  {
						  // update
						  String Aadhar="Aadhar Nmae"+aadhareason;
						  

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
							  		+ " k on k.slno=u.slno set aadharName='"+aadharname+"', verifiedbyHr='"+Hr_id+"',aadharnumber='"+aadharno+"', dateofmodification='"+dat2+"',Status_rej='"+Status_rej+"',aadhar_reject_reason='"+aadhareason+"', reason=CONCAT(reason,':','"+Aadhar+"');");

						  
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						  
					  }
					  
					  
			/*
			 * String Aadhar="Aadhar Nmae"+aadhareason;
			 * 
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set aadharName='"+aadharname+"', verifiedbyHr='"+Hr_id+
			 * "',aadharnumber='"+aadharno+"', dateofmodification='"+dat2+"',Status='"+
			 * Status+"',aadhar_reject_reason='"+aadhareason+"', reason=CONCAT(reason,':','"
			 * +Aadhar+"');");
			 * 
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						
						
						 query12.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
							//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

							System.out.println(query12);
							try {
								ps=conn.prepareStatement(query12.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
								backSatus=res1;
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						
						
						
						
						
						
						
						
						
				  }
			 
	// aadhar number 		  
		    if(GetRouting.equalsIgnoreCase("AADHARNUMBERA") && !aadharno.trim().isEmpty() && aadharno!=null) {
				
				
		    	 StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				//  query1.append(" update emp_edit_details.emp_hr_accept_table set aadharnumber='"+aadharno+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.aadharnumber='"+aadharno+"',Status='"+Status+"';");

					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set aadharnumber='"
			 * +aadharno+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					
			/*
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
			 * + " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="
			 * +username+"))" + " k on k.slno=u.slno set Status='"+Status+"';");
			 */
					  queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
						
					
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query jkhjkhj ::"+res1);
							backSatus=res1;
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			 
		    if(GetRouting.equalsIgnoreCase("AADHARNUMBERREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer(); StringBuffer  query12 = new StringBuffer(); 
					  
					  StringBuffer  queryEmaiDGFDG1 = new StringBuffer(); 
					  String Aadhar1="Aadhar Number"+Rejres;
					 // query1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"', aadharnumber='"+aadharno+"',reason=CONCAT(reason,':','"+Aadhar1+"') where EmpId="+username+ "; ");

					  
					  
					  
					  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
						  		+ " k on k.slno=u.slno set aadharnumber='"+aadharno+"',Status='"+Status+"', reason=CONCAT(reason,':','"+Aadhar1+"');");

					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the DFGHFDFGGFmobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
						
						
					System.out.println("the values are :::"+query12);
						
						 query12.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
							//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

							System.out.println(query12);
							try {
								ps=conn.prepareStatement(query12.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
								backSatus=res1;
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						
						
						
						
						
						
						
				  }
			 
	//pan number		  
		   if(GetRouting.equalsIgnoreCase("PANNUMBERA") && !pannumber.trim().isEmpty()) {
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				 // query1.append(" update emp_edit_details.emp_hr_accept_table set pannumber='"+pannumber+"', Status='"+Status+"' where EmpId="+username+ "; ");
				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.pannumber='"+pannumber+"',Status='"+Status+"';");

				  
					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
					 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set pannumber='"
			 * +pannumber+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
							backSatus=res1;
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			 
		 //  
		   
		    if(panrej.equalsIgnoreCase("PANNUMBERREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer();StringBuffer  query14512 = new StringBuffer();
					  StringBuffer  query12 = new StringBuffer();StringBuffer  query112 = new StringBuffer();
					  String Pan="Pan NUmber"+panreas;
					 // query1.append(" emp_edit_details.emp_list_table set  Status='"+Status+"', pannumber='"+pannumber+"',reason=CONCAT(reason,':','"+Pan+"') where EmpId="+username+ "; ");

					  
					  
					  query112.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
					  
					  
						System.out.println(query112);
						try {
							
							Res=(ResultSet)DataObj.FetchData(query112.toString(), "Req_Adj", Res ,conn);
							if(Res.next()){
								
								RejStaurs=Res.getInt(1);
								 System.out.println("the Pan Status Id is::"+RejStaurs);
							}
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
					  
					  if(RejStaurs==0)
					  {
						// insert
						  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,pannumber,verifiedbyHr,Status_rej,dateofmodification,pan_reason,Status)   values( ?,?,?,?,?,?,? ); ");
						  try {
							ps=conn.prepareStatement(query14512.toString());
							ps.setString(1, username);
							ps.setString(2,pannumber);
							ps.setString(3, Hr_id);
							ps.setInt(4, Status_rej);
							ps.setString(5, dat2);
							ps.setString(6, Pan);
							ps.setInt(7, Status);
							int res=ps.executeUpdate();
							System.out.println("the  Pan reject "+query14512);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					  }
					  else
					  {
						  // update
						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status=1002))"
							  		+ " k on k.slno=u.slno set pannumber='"+pannumber+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status_rej='"+Status_rej+"',pan_reason='"+panreas+"',      reason=CONCAT(reason,':','"+Pan+"');");

							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  
					  }
					  

					  
			/*
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set pannumber='"+pannumber+"',verifiedbyHr='"+Hr_id+
			 * "',dateofmodification='"+dat2+"',Status='"+Status+"',pan_reason='"+
			 * panreas+"',      reason=CONCAT(reason,':','"+Pan+"');");
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						 query12.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
							//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

							System.out.println(query12);
							try {
								ps=conn.prepareStatement(query12.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
								backSatus=res1;
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						
						
						
						
				  }
			 
	// passport number		  
		   if(GetRouting.equalsIgnoreCase("PASSPORTNUMBERA") && !passportNo.trim().isEmpty()) {
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				//  query1.append(" update emp_edit_details.emp_hr_accept_table set passportnumber='"+passportNo+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.passportnumber='"+passportNo+"',Status='"+Status+"';");

					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set passportnumber='"
			 * +passportNo+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					
					queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
						res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
		   
	//PASSSPORT REJECT	 passrej  passreaso   
		   if(passrej.equalsIgnoreCase("PASSPORTNUMBERREJ"))
			  {
				  StringBuffer  query1 = new StringBuffer();StringBuffer  query112 = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();StringBuffer  query14512 = new StringBuffer();
				  
				  query112.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
				  	System.out.println(query112);
					try {
						
						Res=(ResultSet)DataObj.FetchData(query112.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							
							RejStaurs=Res.getInt(1);
							 System.out.println("the Pass port Status Id is::"+RejStaurs);
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				  
				  if(RejStaurs==0)
				  {
					// insert
					  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,passportnumber,verifiedbyHr,Status_rej,dateofmodification,passsport_reason,Status)   values( ?,?,?,?,?,?,? ); ");
					  try {
						ps=conn.prepareStatement(query14512.toString());
						ps.setString(1, username);
						ps.setString(2,passportNo);
						ps.setString(3, Hr_id);
						ps.setInt(4, Status_rej);
						ps.setString(5, dat2);
						ps.setString(6, passreaso);
						ps.setInt(7, Status);
						int ols=ps.executeUpdate();
						System.out.println("the pass port nd one "+query14512);
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				  }
				  else
				  {
					  // update
					  String pass="Passport Number"+passreaso;
					  

					  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
						  		+ " k on k.slno=u.slno set passportnumber='"+passportNo+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status_rej='"+Status_rej+"',passsport_reason='"+passreaso+"',  reason=CONCAT(reason,':','"+pass+"');");

					  
					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					  
				  }
				  

				  
				  
			/*
			 * String pass="Passport Number"+passreaso;
			 * 
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set passportnumber='"+passportNo+"',verifiedbyHr='"+
			 * Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status+
			 * "',passsport_reason='"+passreaso+"',  reason=CONCAT(reason,':','"+pass+"');")
			 * ;
			 * 
			 * 
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					
					queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

				
				
					//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

					System.out.println(queryEmai1);
					try {
						ps=conn.prepareStatement(queryEmai1.toString());
					res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						backSatus=res1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
					
					
			  }
		   
		// Driving licence number 	 
			  
		   if(GetRouting.equalsIgnoreCase("DRIVINGLICA") && !drivelicNo.trim().isEmpty()) {
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				 // query1.append(" update emp_edit_details.emp_hr_accept_table set DrivingLicenseno='"+drivelicNo+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.DrivingLicenseno='"+drivelicNo+"',Status='"+Status+"';");

				  				  
					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set DrivingLicenseno='"
			 * +drivelicNo+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					
					queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			  
		   
		   //drivlcrej  drivreason
		     if(drivlcrej.equalsIgnoreCase("DRIVINGLICREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer(); StringBuffer  query14512 = new StringBuffer();StringBuffer  queryEmai13 = new StringBuffer();
					  StringBuffer  queryEmai1 = new StringBuffer();StringBuffer  queryEmai11 = new StringBuffer();
					  
					  queryEmai13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
					  	System.out.println(queryEmai13);
						try {
							
							Res=(ResultSet)DataObj.FetchData(queryEmai13.toString(), "Req_Adj", Res ,conn);
							if(Res.next()){
								
								RejStaurs=Res.getInt(1);
								 System.out.println("the driving Id is::"+RejStaurs);
							}
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
					  
					  
					  if(RejStaurs==0)
					  {
						// insert
						  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,DrivingLicenseno,verifiedbyHr,Status_rej,dateofmodification,drivinglicense_reason,Status)   values( ?,?,?,?,?,?,? ); ");
						  try {
							ps=conn.prepareStatement(query14512.toString());
							ps.setString(1, username);
							ps.setString(2,drivelicNo);
							ps.setString(3, Hr_id);
							ps.setInt(4, Status_rej);
							ps.setString(5, dat2);ps.setString(6, drivreason);ps.setInt(7, Status);
							
							int res=ps.executeUpdate();
							System.out.println("the driving one "+query14512);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					  }
					  else
					  {
						  // update
						  String driv="DRIVINGLIC No"+drivreason;
						  
						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
							  		+ " k on k.slno=u.slno set DrivingLicenseno='"+drivelicNo+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status_rej='"+Status_rej+"',drivinglicense_reason='"+drivreason+"',   reason=CONCAT(reason,':','"+driv+"');");

							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							
						  
					  }
					  

					  
			/*
			 * String driv="DRIVINGLIC No"+drivreason;
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set DrivingLicenseno='"+drivelicNo+"',verifiedbyHr='"+
			 * Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status+
			 * "',drivinglicense_reason='"+drivreason+"',   reason=CONCAT(reason,':','"+driv
			 * +"');");
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						queryEmai11.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai11);
						try {
							ps=conn.prepareStatement(queryEmai11.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						
						
						
						
				  }
			 
/*------------------------------------------------------------BANK DETAILS---------------------------------------------------------------------*/			  
	// bank name	
		     if(GetRouting.equalsIgnoreCase("BANKNAEA") && !bankname.trim().isEmpty()) {
				
				
		    	 StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				//  query1.append(" update emp_edit_details.emp_hr_accept_table set BankName='"+bankname+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.BankName='"+bankname+"',Status='"+Status+"';");

					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set BankName='"
			 * +bankname+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						 query1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			 
		      
		     
		    if(bankrej.equalsIgnoreCase("BANKNAEREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai1 = new StringBuffer();
					  StringBuffer  queryEmai11 = new StringBuffer(); StringBuffer  queryEmai411 = new StringBuffer();
					  StringBuffer  queryEmai111 = new StringBuffer();
					  
					  
					  
					  queryEmai11.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
					  	System.out.println(queryEmai11);
						try {
							
							Res=(ResultSet)DataObj.FetchData(queryEmai11.toString(), "Req_Adj", Res ,conn);
							if(Res.next()){
								
								RejStaurs=Res.getInt(1);
								 System.out.println("the Bank Id is::"+RejStaurs);
							}
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
					  
					  
					  if(RejStaurs==0)
					  {
						// insert
						  queryEmai411.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,BankName,AccountNo,IfcsCode,verifiedbyHr,Status_rej,dateofmodification,bank_reason,Status)   values( ?,?,?,?,?,?,?,?,? ); ");
						  try {
							ps=conn.prepareStatement(queryEmai411.toString());
							ps.setString(1, username);
							ps.setString(2,bankname);
							ps.setString(3,ACNO);
							ps.setString(4,bankifccode);
							ps.setString(5, Hr_id);
							ps.setInt(6, Status_rej);
							ps.setString(7, dat2);
							ps.setString(8, bakreason);ps.setInt(9, Status);
							
							int fd=ps.executeUpdate();
							System.out.println("the bank rej"+queryEmai411);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					  }
					  else
					  {
						  // update
						  String bankname1="Bank Name"+bakreason;
						  

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
							  		+ " k on k.slno=u.slno set BankName='"+bankname+"', AccountNo='"+ACNO+"',IfcsCode='"+bankifccode+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"', Status_rej='"+Status_rej+"', bank_reason='"+bakreason+"',     reason=CONCAT(reason,':','"+bankname1+"');");

							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  
					  }
					  

					  
			/*
			 * String bankname1="Bank Name"+bakreason;
			 * 
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set BankName='"+bankname+"', AccountNo='"+ACNO+
			 * "',IfcsCode='"+bankifccode+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+
			 * dat2+"', Status='"+Status+"', bank_reason='"
			 * +bakreason+"',     reason=CONCAT(reason,':','"+bankname1+"');");
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						queryEmai111.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
						System.out.println(queryEmai111);
						try {
							ps=conn.prepareStatement(queryEmai111.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						
						
						
						
						
						
				  }
			 
		// ACCOUNT NUMBER	  
		   if(GetRouting.equalsIgnoreCase("ACCOUNTNUMA") && !ACNO.trim().isEmpty()) {
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				 // query1.append(" update emp_edit_details.emp_hr_accept_table set AccountNo='"+ACNO+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.AccountNo='"+ACNO+"',Status='"+Status+"';");

				  
				  
				  
				  
				  
				  
				  
					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set AccountNo='"
			 * +ACNO+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					 query1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
					//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			 
		    if(GetRouting.equalsIgnoreCase("ACCOUNTNUMREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer();
					  StringBuffer  queryEmai1 = new StringBuffer();
					  String AccNo="ACC No"+Rejres;
					  
					//  query1.append(" emp_edit_details.emp_list_table set  Status='"+Status+"', AccountNo='"+ACNO+"', reason=CONCAT(reason,':','"+AccNo+"') where EmpId="+username+ "; ");

					  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
						  		+ " k on k.slno=u.slno set AccountNo='"+ACNO+"',Status='"+Status+"',verifiedbyHr='"+Hr_id+"', reason=CONCAT(reason,':','"+AccNo+"');");

					  
					  
					  
					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
						//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

							System.out.println(queryEmai1);
							try {
								ps=conn.prepareStatement(queryEmai1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								backSatus=res1;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						
						
						
						
						
						
				  }
			 
// ifc number			  
		   if(GetRouting.equalsIgnoreCase("IFCNUMA") && !bankifccode.trim().isEmpty()) {
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				 // query1.append(" update emp_edit_details.emp_hr_accept_table set IfcsCode='"+bankifccode+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.IfcsCode='"+bankifccode+"',Status='"+Status+"';");

				  
					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						backSatus=res1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set IfcsCode='"
			 * +bankifccode+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					
					 query1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
					
					//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
	
		    if(GetRouting.equalsIgnoreCase("IFCNUMREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer(); 
					  StringBuffer  queryEmai1 = new StringBuffer();
					  String ifcnum="Ifc Number"+Rejres;
					 // query1.append(" update update emp_edit_details.emp_list_table set  Status='"+Status+"', IfcsCode='"+bankifccode+"',  reason=CONCAT(reason,':','"+ifcnum+"') where EmpId="+username+ "; ");

					  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
						  		+ " k on k.slno=u.slno set IfcsCode='"+bankifccode+"',Status='"+Status+"', reason=CONCAT(reason,':','"+ifcnum+"');");
  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
					
					//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						
						
						
						
				  }
			 
		/*---------------------------------------------------COMMUNICATION DETAILS-----------------------------------------------------------------*/			  
		  
		  // COUNTRY   
		    if(GetRouting.equalsIgnoreCase("COUNTRYA")) {
				
				
			  StringBuffer  query1 = new StringBuffer();
			  query1.append(" update hclhrm_prod.tbl_emp_profiled_update set CommunicationAddress='"+peraddress+"', Status='"+Status+"' where username="+username+ "; ");

				System.out.println(query1);
				try {
					ps=conn.prepareStatement(query1.toString());
					 res1 = ps.executeUpdate();
					
					System.out.println("the mobile otp exicute query::"+res1);
				  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			  }
			 
		    if(GetRouting.equalsIgnoreCase("countryrej"))
				  {
					  StringBuffer  query1 = new StringBuffer();
					  query1.append(" update hclhrm_prod.tbl_emp_profiled_update set CommunicationAddress='"+peraddress+"', reason=CONCAT(reason,':','"+Rejres+"') where EmpId="+username+ "; ");

						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
				  }
			 
	// State 		  
		   if(GetRouting.equalsIgnoreCase("COMSTATE") && !cstate.trim().isEmpty() && cstate != null ) {
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				//  query1.append(" update emp_edit_details.emp_hr_accept_table set Cstate='"+cstate+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.Cstate='"+cstate+"',Status='"+Status+"';");

				  
				  
				  
					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set Cstate='"
			 * +cstate+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
					
					 query1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			 
		   
		    
		   
		    if(commaddrej.equalsIgnoreCase("COMSTATEREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer();StringBuffer  queryEmai11 = new StringBuffer();
					  StringBuffer  query12 = new StringBuffer();StringBuffer  queryEmai131 = new StringBuffer();
					  StringBuffer  queryEmai5131 = new StringBuffer();
					  
					  
					  queryEmai11.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
					  	System.out.println(queryEmai11);
						try {
							
							Res=(ResultSet)DataObj.FetchData(queryEmai11.toString(), "Req_Adj", Res ,conn);
							if(Res.next()){
								
								RejStaurs=Res.getInt(1);
								 System.out.println("the communication Id is::"+RejStaurs);
							}
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
					  
					  
					  if(RejStaurs==0)
					  {
						// insert
						  queryEmai131.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,CommunicationAddress,communication2,communication3,communication4"
						  		+ ",Cstate,Ccity,Cpin,verifiedbyHr,Status_rej,dateofmodification,communication_addres_reason,Status)   values( ?,?,?,?,?,?,?,?,?,?,?,?,? ); ");
						  try {
							ps=conn.prepareStatement(queryEmai131.toString());
							ps.setString(1, username);
							ps.setString(2,commuaddress);
							ps.setString(3,commuaddress1);
							ps.setString(4,commuaddress2);
							ps.setString(5,commuaddress3);
							ps.setString(6,cstate);
							ps.setString(7,ccity);
							ps.setString(8,cpin);
							ps.setString(9, Hr_id);
							ps.setInt(10, Status_rej);
							ps.setString(11, dat2);
							ps.setString(12, commaddreason);
							ps.setInt(13, Status);
							
							
							int ss=ps.executeUpdate();
							System.out.println("the commu rej ::"+queryEmai131);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					  }
					  else
					  {
						  // update
						  String commst="Communication State"+commaddreason;

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
							  		+ " k on k.slno=u.slno set Cstate='"+cstate+"',"
							  				+ "Ccity='"+ccity+"',CommunicationAddress='"+commuaddress+"',communication2='"+commuaddress1+"',"
							  						+ "communication3='"+commuaddress2+"',communication4='"+commuaddress3+"',Status_rej='"+Status_rej+"', "
							  								+ "Cpin='"+cpin+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',communication_addres_reason='"+commaddreason+"',reason=CONCAT(reason,':','"+commaddreason+"');");

							System.out.println(query1);
							
							
							
							try {
								ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						  
					  }
					  
					  
					  
			/*
			 * String commst="Communication State"+commaddreason;
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" + " k on k.slno=u.slno set Cstate='"+cstate+"'," +
			 * "Ccity='"+ccity+"',CommunicationAddress='"+commuaddress+"',communication2='"+
			 * commuaddress1+"'," +
			 * "communication3='"+commuaddress2+"',communication4='"+commuaddress3+
			 * "',Status='"+Status+"', " +
			 * "Cpin='"+cpin+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+
			 * "',communication_addres_reason='"+commaddreason+
			 * "',reason=CONCAT(reason,':','"+commaddreason+"');");
			 * 
			 * System.out.println(query1);
			 * 
			 * 
			 * 
			 * try { ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */						
						 query12.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						

							System.out.println(query12);
							try {
								ps=conn.prepareStatement(query12.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								backSatus=res1;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						
						
								
						
						
				  }
			 
// city
		   if(GetRouting.equalsIgnoreCase("COMCITY") && !ccity.trim().isEmpty() && ccity!=null) {
				
				
			   StringBuffer  query3 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				//  query3.append(" update emp_edit_details.emp_hr_accept_table set Ccity='"+ccity+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query3.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.Ccity='"+ccity+"',Status='"+Status+"';");

				  
					System.out.println(query3);
					try {
						ps=conn.prepareStatement(query3.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set Ccity='"
			 * +ccity+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
						res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }

			 
		    if(GetRouting.equalsIgnoreCase("COMCITYREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer();
					  StringBuffer  queryEmai1 = new StringBuffer();
					  String commcity="Communication City"+Rejres;
		// query1.append(" updateemp_edit_details.emp_list_table set  Status='"+Status+"', Ccity='"+ccity+"', reason=CONCAT(reason,':','"+commcity+"') where EmpId="+username+ "; ");

		  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
			  		+ " k on k.slno=u.slno set Ccity='"+ccity+"',Status='"+Status+"', reason=CONCAT(reason,':','"+commcity+"');");

					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					System.out.println(queryEmai1);
					try {
						ps=conn.prepareStatement(queryEmai1.toString());
					res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						backSatus=res1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
						
						
						
						
						
						
						
				  }
	// address 
			  
		   if(GetRouting.equalsIgnoreCase("COMMADD1")&& !commuaddress.trim().isEmpty()&& commuaddress!=null) {
				
				
				
			   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				  //query1.append(" update emp_edit_details.emp_hr_accept_table set CommunicationAddress='"+commuaddress+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  
				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.CommunicationAddress='"+commuaddress+"',Status='"+Status+"';");

				  
				  
				  
				  
				  
				  
					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
					 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						backSatus=res1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set CommunicationAddress='"
			 * +commuaddress+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
						
						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			 
		    if(GetRouting.equalsIgnoreCase("COMMADD1REJ"))
				  {
					  StringBuffer  query1 = new StringBuffer();
					  StringBuffer  queryEmai1 = new StringBuffer();
					  String  commadd="Communication Address"+Rejres;
					  
					//  query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', CommunicationAddress='"+commuaddress+"',reason=CONCAT(reason,':','"+commadd+"') where EmpId="+username+ "; ");
					  
					  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
						  		+ " k on k.slno=u.slno set CommunicationAddress='"+commuaddress+"',Status='"+Status+"', reason=CONCAT(reason,':','"+commadd+"');");

					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
						
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					System.out.println(queryEmai1);
					try {
						ps=conn.prepareStatement(queryEmai1.toString());
					res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						backSatus=res1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
							
						
						
						
						
						
						
						
				  }
		    
	//COMM ADD 2
		    if(GetRouting.equalsIgnoreCase("COMMADD2")&& !commuaddress1.trim().isEmpty() && commuaddress1!=null ) {
				
				
				
				   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
					  StringBuffer  queryEmai1 = new StringBuffer();
					  
					//  query1.append(" update emp_edit_details.emp_hr_accept_table set communication2='"+commuaddress1+"', Status='"+Status+"' where EmpId="+username+ "; ");

					  
					  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.communication2='"+commuaddress1+"',Status='"+Status+"';");

						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set communication2='"
			 * +commuaddress1+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
						
						
						
							//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

							System.out.println(queryEmai1);
							try {
								ps=conn.prepareStatement(queryEmai1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								backSatus=res1;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
					  }
				    else
				    {
				    	empt="Empty field data";
				    }
				 
			    if(GetRouting.equalsIgnoreCase("COMMADD2REJ"))
					  {
						  StringBuffer  query1 = new StringBuffer();
						  StringBuffer  queryEmai1 = new StringBuffer();
						  String commadd2="Communication Address2"+Rejres;
					//	  query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', communication2='"+commuaddress1+"', reason=CONCAT(reason,':','"+commadd2+"') where EmpId="+username+ "; ");

					 query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
							  		+ " k on k.slno=u.slno set communication2='"+commuaddress1+"',Status='"+Status+"', reason=CONCAT(reason,':','"+commadd2+"');");

						  
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
						res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
								
							
							
							
							
							
							
							
							
							
					  }
			    
		    
		    
		    
	//COM ADD 3
			    if(GetRouting.equalsIgnoreCase("COMMADD3")&& !commuaddress2.trim().isEmpty() && commuaddress2!=null ) {
					
					
					
					   StringBuffer  query1 = new StringBuffer();  //StringBuffer  queryEmai = new StringBuffer();
						  StringBuffer  queryEmai1 = new StringBuffer();
						  
						 // query1.append(" update emp_edit_details.emp_hr_accept_table set communication3='"+commuaddress2+"', Status='"+Status+"' where EmpId="+username+ "; ");

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set u.communication3='"+commuaddress2+"',Status='"+Status+"';");

						
						  
						  
						  
						  
						  
						  
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set communication3='"
			 * +commuaddress2+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
								
								
								//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								System.out.println(queryEmai1);
								try {
									ps=conn.prepareStatement(queryEmai1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
						  }
					    else
					    {
					    	empt="Empty field data";
					    }
					 
				    if(GetRouting.equalsIgnoreCase("COMMADD3REJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();StringBuffer  queryEmai1 = new StringBuffer();
							  String commad3="Communication Address3"+Rejres;
							 // query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', communication3='"+commuaddress2+"', reason=CONCAT(reason,':','"+commad3+"') where EmpId="+username+ "; ");

							  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
								  		+ " k on k.slno=u.slno set communication3='"+commuaddress2+"',Status='"+Status+"', reason=CONCAT(reason,':','"+commad3+"');");
 
								System.out.println(query1);
								try {
									ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								System.out.println(queryEmai1);
								try {
									ps=conn.prepareStatement(queryEmai1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
								
								
								
								
								
								
								
								
						  }
				    
				    
		    
	//COM ADD 4	    
		    
				    if(GetRouting.equalsIgnoreCase("COMMADD4")&& !commuaddress3.trim().isEmpty() && commuaddress3!=null) {
						
						
						
						   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
							  StringBuffer  queryEmai1 = new StringBuffer();
							  
							 // query1.append(" update emp_edit_details.emp_hr_accept_table set communication4='"+commuaddress3+"', Status='"+Status+"' where EmpId="+username+ "; ");

							  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set u.communication4='"+commuaddress3+"',Status='"+Status+"';");

							
							  
								System.out.println(query1);
								try {
									ps=conn.prepareStatement(query1.toString());
									res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set communication4='"
			 * +commuaddress3+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
								
								
								
								//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							
							  }
						    else
						    {
						    	empt="Empty field data";
						    }
						 
					    if(GetRouting.equalsIgnoreCase("COMMADD4REJ"))
							  {
								  StringBuffer  query1 = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();
								  String comm4="Communication"+Rejres;
								  
								//  query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', communication4='"+commuaddress3+"', reason=CONCAT(reason,':','"+comm4+"') where EmpId="+username+ "; ");
								  
								  
								  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
									  		+ " k on k.slno=u.slno set communication4='"+commuaddress3+"',Status='"+Status+"', reason=CONCAT(reason,':','"+comm4+"');");
	 
								  
									System.out.println(query1);
									try {
										ps=conn.prepareStatement(query1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
									
									
									
									
									
									
									
							  }
					    
		
			 
// pin	Cpin		  
		    if(GetRouting.equalsIgnoreCase("COMMPIN") && !cpin.trim().isEmpty() && cpin!=null ) {
				
				
		    	 StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();
				  
				//  query1.append(" update emp_edit_details.emp_hr_accept_table set Cpin='"+cpin+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set u.Cpin='"+cpin+"',Status='"+Status+"';");

					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set Cpin='"
			 * +cpin+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			    else
			    {
			    	empt="Empty field data";
			    }
			  
		    if(GetRouting.equalsIgnoreCase("COMMPINREJ"))
				  {
					  StringBuffer  query1 = new StringBuffer(); StringBuffer  queryEmai1 = new StringBuffer();
					  String compin="Communication Pin"+Rejres;
					 // query1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"', Cpin='"+cpin+"', reason=CONCAT(reason,':','"+compin+"') where EmpId="+username+ "; ");

					  
					  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
						  		+ " k on k.slno=u.slno set Cpin='"+cpin+"',Status='"+Status+"', reason=CONCAT(reason,':','"+compin+"');");

					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
						
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
						
						
						
						
						
						
						
						
						
						
						
				  }
		  
	
		    /*---------------------------------------------------PERMANENT ADDRESS-----------------------------------------------------------------*/			  
			  
			  // COUNTRY1   
			    if(GetRouting.equalsIgnoreCase("PCOUNTRYA1")) {
					
					
				  StringBuffer  query1 = new StringBuffer();
				  query1.append(" update hclhrm_prod.tbl_emp_profiled_update set CommunicationAddress='"+peraddress+"', Status='"+Status+"' where username="+username+ "; ");

					System.out.println(query1);
					try {
						ps=conn.prepareStatement(query1.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				  }
				 
			    if(GetRouting.equalsIgnoreCase("pcountryrej1"))
					  {
						  StringBuffer  query1 = new StringBuffer();
						  query1.append(" update hclhrm_prod.tbl_emp_profiled_update set CommunicationAddress='"+peraddress+"', reason=CONCAT(reason,':','"+peraddress+"') where username="+username+ "; ");

							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					  }
				 
			 // pState 		  
				   if(GetRouting.equalsIgnoreCase("PERSTATE") && !pstate.trim().isEmpty() && pstate!=null ) {
						
						
					   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
						  StringBuffer  queryEmai1 = new StringBuffer();
						  
						 // query1.append(" update emp_edit_details.emp_hr_accept_table set state='"+pstate+"', Status='"+Status+"' where EmpId="+username+ "; ");

						  
						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set u.state='"+pstate+"',Status='"+Status+"';");

						
						  
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set state='"
			 * +pstate+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
							
							queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

							//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

								System.out.println(queryEmai1);
								try {
									ps=conn.prepareStatement(queryEmai1.toString());
								 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
						  }
					    else
					    {
					    	empt="Empty field data";
					    }
					 
				    
				   
				   
				    if(peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();StringBuffer  queryEmai1 = new StringBuffer();
							  StringBuffer  queryEmai11 = new StringBuffer();StringBuffer  queryEmai131 = new StringBuffer();
							  
							  
							  
							  
							  queryEmai11.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
							  	System.out.println(queryEmai11);
								try {
									
									Res=(ResultSet)DataObj.FetchData(queryEmai11.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 System.out.println("the permanet add  Id is::"+RejStaurs);
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
							  
							  
							  if(RejStaurs==0)
							  {
								// insert
								  queryEmai131.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,PermanentAddress,PermanentAddress2,PermanentAddress3,PermanentAddress4"
								  		+ ",state,city,pin,verifiedbyHr,Status_rej,dateofmodification,PERMANENT_ADDRESS_reason,Status)   values( ?,?,?,?,?,?,?,?,?,?,?,?,? ); ");
								  try {
									ps=conn.prepareStatement(queryEmai131.toString());
									ps.setString(1, username);
									ps.setString(2,peraddress);
									ps.setString(3,peraddress1);
									ps.setString(4,peraddress2);
									ps.setString(5,peraddress3);
									ps.setString(6,pstate);
									ps.setString(7,pcity);
									ps.setString(8,ppin);
									ps.setString(9, Hr_id);
									ps.setInt(10, Status_rej);
									ps.setString(11, dat2);ps.setString(12, peraddrreas);
									ps.setInt(13, Status);
									
									int rr=ps.executeUpdate();
									System.out.println("the peradd rej are ::"+queryEmai131);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
							  }
							  else
							  {
								  // update
								  String perstate="State"+peraddrreas;
								  
								  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
									  		+ " k on k.slno=u.slno set state='"+pstate+"',"
									  				+ " city='"+pcity+"',PermanentAddress='"+peraddress+"',PermanentAddress2='"+peraddress1+"',"
									  				+ "PermanentAddress3='"+peraddress2+"',PermanentAddress4='"+peraddress3+"',pin='"+ppin+"',"
									  				+ "Status_rej='"+Status_rej+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',PERMANENT_ADDRESS_reason='"+peraddrreas+"', reason=CONCAT(reason,':','"+perstate+"');");

									System.out.println(query1);
									try {
										ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
								  
							  }
							  
							 							  
							  
			/*
			 * String perstate="State"+peraddrreas;
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" + " k on k.slno=u.slno set state='"+pstate+"'," +
			 * " city='"+pcity+"',PermanentAddress='"+peraddress+"',PermanentAddress2='"+
			 * peraddress1+"'," +
			 * "PermanentAddress3='"+peraddress2+"',PermanentAddress4='"+peraddress3+
			 * "',pin='"+ppin+"'," +
			 * "Status='"+Status+"',dateofmodification='"+dat2+"',verifiedbyHr='"+
			 * Hr_id+"',PERMANENT ADDRESS_reason='"
			 * +peraddrreas+"', reason=CONCAT(reason,':','"+perstate+"');");
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
									 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}	
								
						
								
								
						  }
					 
		// pcity
				   if(GetRouting.equalsIgnoreCase("PERCITY") && !pcity.trim().isEmpty() && pcity!=null) {
						
						
					   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
						  StringBuffer  queryEmai1 = new StringBuffer();
						  
						//  query1.append(" update emp_edit_details.emp_hr_accept_table set city='"+pcity+"', Status='"+Status+"' where EmpId="+username+ "; ");

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set u.city='"+pcity+"',Status='"+Status+"';");

						
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set city='"
			 * +pcity+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
							
							queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

							
							
							
								//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

								System.out.println(queryEmai1);
								try {
									ps=conn.prepareStatement(queryEmai1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
						  }
					    else
					    {
					    	empt="Empty field data";
					    }

					 
				    if(GetRouting.equalsIgnoreCase("PERCITYREJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();StringBuffer  queryEmai1 = new StringBuffer();
							  String percity="city"+Rejres;
							  
							  
				// query1.append(" updateemp_edit_details.emp_list_table set  Status='"+Status+"', city='"+pcity+"', reason=CONCAT(reason,':','"+percity+"') where EmpId="+username+ "; ");

				  
				  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
					  		+ " k on k.slno=u.slno set city='"+pcity+"',Status='"+Status+"', reason=CONCAT(reason,':','"+percity+"');");

				 
								System.out.println(query1);
								try {
									ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
								
								
									//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								
								
								
								
								
								
								
						  }
			// per address 
					  
				   if(GetRouting.equalsIgnoreCase("PERADD1")&& !peraddress.trim().isEmpty() && peraddress!=null ) {
						
						
						
					   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
						  StringBuffer  queryEmai1 = new StringBuffer();
						  
						//  query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress='"+peraddress+"', Status='"+Status+"' where EmpId="+username+ "; ");

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set u.PermanentAddress='"+peraddress+"',Status='"+Status+"';");

						  
						  
						 
						  
						  
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set PermanentAddress='"
			 * +peraddress+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
							queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

							
							
							
							
								//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

								System.out.println(queryEmai1);
								try {
									ps=conn.prepareStatement(queryEmai1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
						  }
					    else
					    {
					    	empt="Empty field data";
					    }
					 
				    if(GetRouting.equalsIgnoreCase("PERADD1REJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();StringBuffer  queryEmai1 = new StringBuffer();
							  String peraddr="Permanent Address"+Rejres;
							  
							  //query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', PermanentAddress='"+peraddress+"', reason=CONCAT(reason,':','"+peraddr+"') where EmpId="+username+ "; ");

							  
							  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
								  		+ " k on k.slno=u.slno set PermanentAddress='"+peraddress+"',Status='"+Status+"', reason=CONCAT(reason,':','"+peraddr+"');");

								System.out.println(query1);
								try {
									ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
								
								
								
									//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								
								
								
								
						  }
				    
			//prer ADD 2
				    if(GetRouting.equalsIgnoreCase("PERADD2")&& !peraddress1.trim().isEmpty() && peraddress1!=null  ) {
						
						
						
						   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
							  StringBuffer  queryEmai1 = new StringBuffer();
							  
							 // query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress2='"+peraddress1+"', Status='"+Status+"' where EmpId="+username+ "; ");

							  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set u.PermanentAddress2='"+peraddress1+"',Status='"+Status+"';");

							  
							  
							  
							  
								System.out.println(query1);
								try {
									ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set PermanentAddress2='"
			 * +peraddress1+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
								
									//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							
							  }
						    else
						    {
						    	empt="Empty field data";
						    }
						 
					    if(GetRouting.equalsIgnoreCase("PERADD2REJ"))
							  {
								  StringBuffer  query1 = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();
								  String peradd2="PermanentAddress2"+Rejres;
								  
								 // query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', PermanentAddress2='"+peraddress1+"', reason=CONCAT(reason,':','"+peradd2+"') where EmpId="+username+ "; ");

								  
								  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
									  		+ " k on k.slno=u.slno set PermanentAddress2='"+peraddress1+"',Status='"+Status+"', reason=CONCAT(reason,':','"+peradd2+"');");

								  
								  
								  
								  
								  
									System.out.println(query1);
									try {
										ps=conn.prepareStatement(query1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									
									queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

									
									
										//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											backSatus=res1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}	
									
									
									
									
									
							  }
					    
				    
				    
				    
			//per ADD 3
					    if(GetRouting.equalsIgnoreCase("PERADD3")&& !peraddress2.trim().isEmpty()) {
							
							
							
							   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();
								  
								  //query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress3='"+peraddress2+"', Status='"+Status+"' where EmpId="+username+ "; ");

								  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set u.PermanentAddress3='"+peraddress2+"',Status='"+Status+"';");

								  
								  
									System.out.println(query1);
									try {
										ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set PermanentAddress3='"
			 * +peraddress2+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
									
									
									queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

									
										//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											backSatus=res1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								
								  }
							    else
							    {
							    	empt="Empty field data";
							    }
							 
						    if(GetRouting.equalsIgnoreCase("PERADD3REJ"))
								  {
									  StringBuffer  query1 = new StringBuffer();
									  StringBuffer  queryEmai1 = new StringBuffer();
									  String per3="PermanentAddress3"+Rejres;
									//  query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', PermanentAddress3='"+peraddress2+"', reason=CONCAT(reason,':','"+per3+"') where EmpId="+username+ "; ");

									  
									  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
										  		+ " k on k.slno=u.slno set PermanentAddress3='"+peraddress2+"',Status='"+Status+"', reason=CONCAT(reason,':','"+per3+"');");

									  
									  
										System.out.println(query1);
										try {
											ps=conn.prepareStatement(query1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										
										
										queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

										
											//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

											System.out.println(queryEmai1);
											try {
												ps=conn.prepareStatement(queryEmai1.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												backSatus=res1;
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										
										
										
										
										
										
										
										
										
								  }
						    
				
				    
			//per ADD 4	    
				    
						    if(GetRouting.equalsIgnoreCase("PERADD4")&& !peraddress3.trim().isEmpty()) {
								
								
								
								   StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
									  StringBuffer  queryEmai1 = new StringBuffer();
									  
									  //query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress4='"+peraddress3+"', Status='"+Status+"' where EmpId="+username+ "; ");

									  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set u.PermanentAddress4='"+peraddress3+"',Status='"+Status+"';");

									 		  
									  
										System.out.println(query1);
										try {
											ps=conn.prepareStatement(query1.toString());
										 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											backSatus=res1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
			/*
			 * queryEmai.
			 * append(" update emp_edit_details.emp_accept_table set PermanentAddress4='"
			 * +peraddress3+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
										queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

										
										
										//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

											System.out.println(queryEmai1);
											try {
												ps=conn.prepareStatement(queryEmai1.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												backSatus=res1;
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									
									  }
								    else
								    {
								    	empt="Empty field data";
								    }
								 
							    if(GetRouting.equalsIgnoreCase("PERADD4REJ"))
									  {
										  StringBuffer  query1 = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  String peradd4="PermanentAddress4"+Rejres;
										//  query1.append(" updateupdate emp_edit_details.emp_list_table set  Status='"+Status+"', PermanentAddress4='"+peraddress3+"', reason=CONCAT(reason,':','"+peradd4+"') where EmpId="+username+ "; ");

										  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
											  		+ " k on k.slno=u.slno set PermanentAddress4='"+peraddress3+"',Status='"+Status+"', reason=CONCAT(reason,':','"+peradd4+"');");

										   
										  
										  
										  
										  
											System.out.println(query1);
											try {
												ps=conn.prepareStatement(query1.toString());
												 res1 = ps.executeUpdate();
											
												System.out.println("the mobile otp exicute query::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} 
											
											queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

											
											
											//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

												System.out.println(queryEmai1);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										
											
									  }
							    
				    
			
					 
		// ppin	Cpin		  
				    if(GetRouting.equalsIgnoreCase("PERPIN") && !ppin.trim().isEmpty()) {
						
						
				    	 StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
						  StringBuffer  queryEmai1 = new StringBuffer();
						  
						 // query1.append(" update emp_edit_details.emp_hr_accept_table set pin='"+ppin+"', Status='"+Status+"' where EmpId="+username+ "; ");

						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set u.pin='"+ppin+"',Status='"+Status+"';");

						  
						 
						  
						  
							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			/*
			 * queryEmai.append(" update emp_edit_details.emp_accept_table set pin='"
			 * +ppin+"',  Status='"+Status+"' where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryEmai); try {
			 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
							
							queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

							
							
								//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

								System.out.println(queryEmai1);
								try {
									ps=conn.prepareStatement(queryEmai1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
						  }
					    else
					    {
					    	empt="Empty field data";
					    }
					  
				    if(GetRouting.equalsIgnoreCase("PERPINREJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();
							  StringBuffer  queryEmai1 = new StringBuffer();
							  String perpin="Pin"+Rejres;
							 // query1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"', pin='"+ppin+"', reason=CONCAT(reason,':','"+perpin+"') where EmpId="+username+ "; ");

							  
							  query1.append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="+username+ "))"
								  		+ " k on k.slno=u.slno set pin='"+ppin+"',Status='"+Status+"', reason=CONCAT(reason,':','"+perpin+"');");

							  
							  
							  
							  
								System.out.println(query1);
								try {
									ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query::"+res1);
								  
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								
								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
								
									//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							
							
								
						  }
			  
			    /*---------------------------------------------------PERSONAL DETAILS-----------------------------------------------------------------*/			  
				  
	  //    Email
				    if(GetRouting.equalsIgnoreCase("EMAILA") && !email.trim().isEmpty()) {
						
						
					  StringBuffer  query1 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
					  StringBuffer  queryEmai1 = new StringBuffer();
					  
					 // query1.append(" update emp_edit_details.emp_hr_accept_table set email='"+email+"', Status='"+Status+"' where EmpId="+username+ "; ");

					  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.email='"+email+"',Status='"+Status+"';");

						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
						queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
							//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

							System.out.println(queryEmai1);
							try {
								ps=conn.prepareStatement(queryEmai1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query pullirapuobulesu EMAIL ::"+res1);
								backSatus=res1;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
					  }
				    else
				    {
				    	empt="Empty field data";
				    }
					 
				    
				    
					 
				    
				    
				    
				    if(emlrej.equalsIgnoreCase("EMAILREJ"))
						  {
				    	
							  StringBuffer  query1 = new StringBuffer();StringBuffer  queryEmai1 = new StringBuffer();
							  StringBuffer  query112 = new StringBuffer();StringBuffer  query14512 = new StringBuffer();
							  //reason=concat(reason,":"'obulesu ols123456789')  
				 query112.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
							  
								System.out.println(query112);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query112.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 System.out.println("the Bank Id is::"+RejStaurs);
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
							  
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,email,verifiedbyHr,Status_rej,dateofmodification,email_reason,Status)   values( ?,?,?,?,?,?,? ); ");
								  System.out.println(query14512);
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,email);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status_rej);
									ps.setString(5, dat2);
									ps.setString(6, emreason);
									ps.setInt(7, Status);
									
									int aa = ps.executeUpdate();
									System.out.println("the email reason ake ::"+aa);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  //System.out.println("email reject count ::"+);	
							  }
							  else
							  {
								  // update
								  String Email="Email "+emreason;
									//  query1.append(" update emp_edit_details.emp_list_table set email='"+email+"',Status='"+Status+"', reason=CONCAT(reason,':','"+Email+"') where EmpId="+username+ "; ");

									  
									  
									  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
										  		+ " k on k.slno=u.slno set email='"+email+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status_rej='"+Status_rej+"',email_reason='"+emreason+"', reason=CONCAT(reason,':','"+Email+"');");

									 
									  
										System.out.println(query1);
										try {
											ps=conn.prepareStatement(query1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}  

								  
							  }
							  
			/*
			 * String Email="Email "+emreason; //
			 * query1.append(" update emp_edit_details.emp_list_table set email='"+email+
			 * "',Status='"+Status+"', reason=CONCAT(reason,':','"+Email+"') where EmpId="
			 * +username+ "; ");
			 * 
			 * 
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set email='"+email+"',verifiedbyHr='"+Hr_id+
			 * "',dateofmodification='"+dat2+"',Status='"+Status+"',email_reason='"+
			 * emreason+"', reason=CONCAT(reason,':','"+Email+"');");
			 * 
			 * 
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */								
								queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
									//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

									System.out.println(queryEmai1);
									try {
										ps=conn.prepareStatement(queryEmai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu EMAIL ::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								
						  }
					 
// mobile number		  
				   if(GetRouting.equalsIgnoreCase("MOBILEA") && !personalmob.trim().isEmpty() ) {
						
						
					  StringBuffer  query1 = new StringBuffer();StringBuffer  queryM = new StringBuffer();
					  StringBuffer  queryM1 = new StringBuffer();
					//  query1.append(" update emp_edit_details.emp_hr_accept_table set Personalmobile='"+personalmob+"'  where EmpId="+username+ "; ");

					  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.Personalmobile='"+personalmob+"',Status='"+Status+"';");

					  
					  
					  
					  
					  
						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			/*
			 * queryM.
			 * append(" update emp_edit_details.emp_accept_table set Personalmobile='"
			 * +personalmob+"'  where EmpId="+username+ "; ");
			 * 
			 * System.out.println(queryM); try {
			 * ps=conn.prepareStatement(queryM.toString()); int res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						queryM1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
						
						
						//queryM1.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

						System.out.println(queryM1);
						try {
							ps=conn.prepareStatement(queryM1.toString());
						 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					  }
				   else
				   {
					   empt="Empty field data";
				   }
				   	
				   
				    
				   
				    if(perMObrej.equalsIgnoreCase("MOBILEREJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();
							  StringBuffer  queryM1 = new StringBuffer();
							  StringBuffer  query112 = new StringBuffer();
							  StringBuffer  query14512 = new StringBuffer();
							  
							  
							  query112.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
							  
								System.out.println(query112);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query112.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 System.out.println("the Bank Id is::"+RejStaurs);
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
							  
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Personalmobile,verifiedbyHr,Status_rej,dateofmodification,personal_mobile_reason,Status)   values( ?,?,?,?,?,?,? ); ");
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,personalmob);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status_rej);
									ps.setString(5, dat2);
									ps.setString(6, proreason);
									ps.setInt(7,Status);
									int oo = ps.executeUpdate();
									System.out.println("thepersonal mobile rehect are :: "+oo);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
							  }
							  else
							  {
								  // update
								  String mob="Personal Mobile No"+proreason;
									 // query1.append(" update emp_edit_details.emp_list_table set Personalmobile='"+personalmob+"',Status='"+Status+"', reason=CONCAT(reason,':','"+mob+"') where EmpId="+username+ "; ");

									  
									  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
										  		+ " k on k.slno=u.slno set Personalmobile='"+personalmob+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',personal_mobile_reason='"+permobreason+"',Status_rej='"+Status_rej+"', reason=CONCAT(reason,':','"+mob+"');");

									  
										System.out.println(query1);
										try {
											ps=conn.prepareStatement(query1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}  
								  
							  }
							  
 
							  
							  
							  
			/*
			 * String mob="Personal Mobile No"+proreason; //
			 * query1.append(" update emp_edit_details.emp_list_table set Personalmobile='"
			 * +personalmob+"',Status='"+Status+"', reason=CONCAT(reason,':','"
			 * +mob+"') where EmpId="+username+ "; ");
			 * 
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set Personalmobile='"+personalmob+"',verifiedbyHr='"+
			 * Hr_id+"',dateofmodification='"+dat2+"',personal_mobile_reason='"+permobreason
			 * +"',Status='"+Status+"', reason=CONCAT(reason,':','"+mob+"');");
			 * 
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
								
								queryM1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
								
								
								//queryM1.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

								System.out.println(queryM1);
								try {
									ps=conn.prepareStatement(queryM1.toString());
								 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								
								
								
								
								
								
						  }
					 
		// profissinal mobile
				   if(GetRouting.equalsIgnoreCase("PROFIMOBA") && !professionalmob.trim().isEmpty()) {
						
					  
					  StringBuffer  query1 = new StringBuffer();  StringBuffer  querypRO1 = new StringBuffer();
					  StringBuffer  querypRO2 = new StringBuffer();
					//  query1.append("  update emp_edit_details.emp_hr_accept_table set Professionalmobile='"+professionalmob+"'  where EmpId="+username+ "; ");

					  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.Professionalmobile='"+professionalmob+"',Status='"+Status+"';");

						System.out.println(query1);
						try {
							ps=conn.prepareStatement(query1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
			/*
			 * querypRO1.
			 * append(" update emp_edit_details.emp_accept_table set Professionalmobile='"
			 * +professionalmob+"'  where EmpId="+username+ "; ");
			 * 
			 * System.out.println(querypRO1); try {
			 * ps=conn.prepareStatement(querypRO1.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
						
						
						querypRO2.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

						
							//querypRO2.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

							System.out.println(querypRO2);
							try {
								ps=conn.prepareStatement(querypRO2.toString());
							 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
								backSatus=res1;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
					  }
				   else
				   {
					   empt="Empty field data Profissinal ";
				   }
					 
				   
				 //proMobrej proreason
				    if(proMobrej.equalsIgnoreCase("PROFIMOBREJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();
							  
							  StringBuffer  querypRO2 = new StringBuffer();
							  
							  
							  StringBuffer  query112 = new StringBuffer();
							  StringBuffer  query14512 = new StringBuffer();
							  
							  
							  query112.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
							  
								System.out.println(query112);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query112.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 System.out.println("the Bank Id is::"+RejStaurs);
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
							  
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Professionalmobile,verifiedbyHr,Status_rej,dateofmodification,profissinal_mobile_reason,Status)   values( ?,?,?,?,?,?,? ); ");
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,professionalmob);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status_rej);
									ps.setString(5, dat2);
									ps.setString(6, proreason);
									ps.setInt(7, Status);
									int dd = ps.executeUpdate();
									System.out.println("the values are ::"+dd);
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
							  }
							  else
							  {
								  // update
								  String prombl="Profissinal Mobile No"+proreason;
								  //query1.append(" update hclhrm_prod.tbl_emp_profiled_update set Professionalmobile='"+professionalmob+"',Status='"+Status+"', reason=CONCAT(reason,':','"+prombl+"') where EmpId="+username+ "; ");

								  
								  
								  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+" and Status_rej=1002))"
									  		+ " k on k.slno=u.slno set Professionalmobile='"+professionalmob+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',profissinal_mobile_reason='"+proreason+"',Status_rej='"+Status_rej+"', reason=CONCAT(reason,':','"+prombl+"');");

									System.out.println(query1);
									try {
										ps=conn.prepareStatement(query1.toString());
									 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
					
							  }
							  
							  
							  
			/*
			 * String prombl="Profissinal Mobile No"+proreason; //query1.
			 * append(" update hclhrm_prod.tbl_emp_profiled_update set Professionalmobile='"
			 * +professionalmob+"',Status='"+Status+"', reason=CONCAT(reason,':','"
			 * +prombl+"') where EmpId="+username+ "; ");
			 * 
			 * 
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set Professionalmobile='"+professionalmob+
			 * "',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+
			 * "',profissinal_mobile_reason='"+proreason+"',Status='"+
			 * Status+"', reason=CONCAT(reason,':','"+prombl+"');");
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */				
								querypRO2.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								
									//querypRO2.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

									System.out.println(querypRO2);
									try {
										ps=conn.prepareStatement(querypRO2.toString());
									 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							
								
								
						  }
			// date of birth  
					  
				   if(GetRouting.equalsIgnoreCase("DATEOFBITRTHA") && !Dofb.trim().isEmpty()) {
						
						
					   StringBuffer  query1 = new StringBuffer();  StringBuffer  querypDofb = new StringBuffer();
						  StringBuffer  querypDofb1 = new StringBuffer();
						 // query1.append("  update emp_edit_details.emp_hr_accept_table set Dateofbirth='"+Dofb+"'  where EmpId="+username+ "; ");

						  
						  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set u.Dateofbirth='"+Dofb+"',Status='"+Status+"';");

							System.out.println(query1);
							try {
								ps=conn.prepareStatement(query1.toString());
								 res1 = ps.executeUpdate();
								
								System.out.println("the mobile otp exicute query::"+res1);
							  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
			/*
			 * querypDofb.
			 * append(" update emp_edit_details.emp_accept_table set Dateofbirth='"
			 * +Dofb+"'  where EmpId="+username+ "; ");
			 * 
			 * System.out.println(querypDofb); try {
			 * ps=conn.prepareStatement(querypDofb.toString()); int res1 =
			 * ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
							querypDofb1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
							  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
							  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

								//querypDofb1.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

								System.out.println(querypDofb1);
								try {
									ps=conn.prepareStatement(querypDofb1.toString());
									 res1 = ps.executeUpdate();
									
									System.out.println("the mobile otp exicute query::"+res1);
									backSatus=res1;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
						  }
					   else
					   {
						   empt="Empty field data Profissinal ";
					   }
					 
					// 
				   
				    if(dofbrej.equalsIgnoreCase("DATEOFBITRTHREJ"))
						  {
							  StringBuffer  query1 = new StringBuffer();StringBuffer  querypDofb1 = new StringBuffer();
							  
							  
							  
							  
							  StringBuffer  query112 = new StringBuffer();
							  StringBuffer  query14512 = new StringBuffer();
							  
							  
							  query112.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status_rej=1002;");
							  
								System.out.println(query112);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query112.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 System.out.println("the Bank Id is::"+RejStaurs);
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
							  
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Dateofbirth,verifiedbyHr,Status_rej,dateofmodification,dateofbirth_reason,Status)   values( ?,?,?,?,?,?,? ); ");
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,Dofb);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status_rej);
									ps.setString(5, dat2);
									ps.setString(6, dofbreason);
									ps.setInt(7,Status);
									
									int qq= ps.executeUpdate();
									System.out.println("the profissinal mobile reject ::"+qq);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
							  }
							  else
							  {
								  // update
								  String empdb="Date of Birth"+dofbreason;
									//  query1.append(" update emp_edit_details.emp_list_table set Dateofbirth='"+Dofb+"',Status='"+Status+"', reason=CONCAT(reason,':','"+empdb+"') where EmpId="+username+ "; ");

									  query1.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ " and Status_rej=1002))"
										  		+ " k on k.slno=u.slno set Dateofbirth='"+Dofb+"',Status_rej='"+Status_rej+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',dateofbirth_reason='"+dofbreason+"', reason=CONCAT(reason,':','"+empdb+"');");

									  
									  
										System.out.println(query1);
										try {
											ps=conn.prepareStatement(query1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}  
										

					
							  }
							  
							  
							  
			/*
			 * String empdb="Date of Birth"+dofbreason; //
			 * query1.append(" update emp_edit_details.emp_list_table set Dateofbirth='"
			 * +Dofb+"',Status='"+Status+"', reason=CONCAT(reason,':','"
			 * +empdb+"') where EmpId="+username+ "; ");
			 * 
			 * query1.
			 * append(" UPDATE emp_edit_details.emp_accept_table u join (SELECT a.slno from emp_edit_details.emp_accept_table a where"
			 * +
			 * " slno=(select max(slno)from emp_edit_details.emp_accept_table where empid="
			 * +username+ "))" +
			 * " k on k.slno=u.slno set Dateofbirth='"+Dofb+"',Status='"+Status+
			 * "',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+
			 * "',dateofbirth_reason='"+dofbreason+"', reason=CONCAT(reason,':','"+empdb+
			 * "');");
			 * 
			 * 
			 * 
			 * System.out.println(query1); try {
			 * ps=conn.prepareStatement(query1.toString()); res1 = ps.executeUpdate();
			 * 
			 * System.out.println("the mobile otp exicute query::"+res1);
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 * 
			 */								querypDofb1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
								  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
								  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

									//querypDofb1.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

									System.out.println(querypDofb1);
									try {
										ps=conn.prepareStatement(querypDofb1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query::"+res1);
										backSatus=res1;
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								
								
								
								
						  }
					 
		
		/*--------------------------------------------Accept All personal Detailos-------------------------------------------------*/
				    int stsac=1003;
				    int pqext=0;
				    if(GetRouting.equalsIgnoreCase("Allaccept")) {
				    	//slno, empId, Personalmobile, Professionalmobile, Dateofbirth, otp, dateofmodification, Status, email, reason
				    	//email,professionalmob,personalmob,Dofb
				    	//slno, PermanentAddress, country, state, city, pin, Dateofmodification, Status, empid, PermanentAddress2, 
				    	//PermanentAddress3, PermanentAddress4, reason
						  StringBuffer  query1 = new StringBuffer();
						  StringBuffer  query2 = new StringBuffer();
						  StringBuffer  query3 = new StringBuffer();
						  StringBuffer  query4 = new StringBuffer();  StringBuffer  query5 = new StringBuffer();
						  System.out.println("the All Aprroved list Start Hete......");
			  if(email.trim().isEmpty()||email==null ) {
				  
				  	System.out.println("the values are:"+email);
			 
			  }
			  else
			  {
				  if(!emlrej.equalsIgnoreCase("EMAILREJ"))
				  {
				  
				  
				  StringBuffer  query11 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
				  StringBuffer  queryEmai1 = new StringBuffer();StringBuffer  queryEmai11 = new StringBuffer();
				  StringBuffer  query14512 = new StringBuffer();StringBuffer  query13 = new StringBuffer();
				 // query1.append(" update emp_edit_details.emp_hr_accept_table set email='"+email+"', Status='"+Status+"' where EmpId="+username+ "; ");

				  query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
				  
				  
					System.out.println(query13);
					try {
						
						Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							
							RejStaurs=Res.getInt(1);
							 
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
					System.out.println("the obulesu  AAdhar is::"+RejStaurs);
				  if(RejStaurs==0)
				  {
					// insert
					  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,email,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
					  System.out.println(query14512);
					  try {
						ps=conn.prepareStatement(query14512.toString());
						ps.setString(1, username);
						ps.setString(2,email);
						ps.setString(3, Hr_id);
						ps.setInt(4,Status1);
						ps.setString(5, dat2);
						
						
						int aa = ps.executeUpdate();
						System.out.println("the email reason ake ::"+aa);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  //System.out.println("email reject count ::"+);	
				  }
				  else
				  {
					  // update
					  query11.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.email='"+email+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',Status='"+Status1+"';");

						System.out.println(query11);
						try {
							ps=conn.prepareStatement(query11.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu  ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					  
				  }
				  
				  	queryEmai.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set EMAIL='"+email+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

						System.out.println(queryEmai);
						try {
							ps=conn.prepareStatement(queryEmai.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					
		
					queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
						//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

						System.out.println(queryEmai1);
						try {
							ps=conn.prepareStatement(queryEmai1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query pullirapuobulesu EMAIL ::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						
				  }				
			  }
			  
			  if(personalmob.trim().isEmpty()||personalmob==null) {
			  
				  
				  
			  }else {
				  
				  
				  if(!perMObrej.equalsIgnoreCase("MOBILEREJ"))
				  {
				  
				  StringBuffer  query11 = new StringBuffer();StringBuffer  queryM = new StringBuffer();
				  StringBuffer  queryM1 = new StringBuffer();StringBuffer  query14512 = new StringBuffer();
				  StringBuffer  query13 = new StringBuffer();
				//  query1.append(" update emp_edit_details.emp_hr_accept_table set Personalmobile='"+personalmob+"'  where EmpId="+username+ "; ");

				  
				  
				  
				  query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
				  
				  
					System.out.println(query13);
					try {
						
						Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							
							RejStaurs=Res.getInt(1);
							 
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
					System.out.println("the obulesu  AAdhar is::"+RejStaurs);
				  if(RejStaurs==0)
				  {
					// insert
					  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Personalmobile,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
					  System.out.println(query14512);
					  try {
						ps=conn.prepareStatement(query14512.toString());
						ps.setString(1, username);
						ps.setString(2,personalmob);
						ps.setString(3, Hr_id);
						ps.setInt(4,Status1);
						ps.setString(5, dat2);
						
						
						int aa = ps.executeUpdate();
						System.out.println("the email reason ake ::"+aa);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  //System.out.println("email reject count ::"+);	
				  }
				  else
				  {
					  // update
					  query11.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.Personalmobile='"+personalmob+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',Status='"+Status1+"';");

						System.out.println(query11);
						try {
							ps=conn.prepareStatement(query11.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						

					  
				  }

				  	
					
					queryM.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set PHONE='"+personalmob+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

					System.out.println(queryM);
					try {
						ps=conn.prepareStatement(queryM.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					queryM1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
					
					//queryM1.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

					System.out.println(queryM1);
					try {
						ps=conn.prepareStatement(queryM1.toString());
					 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query::"+res1);
						backSatus=res1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
			  } 
				  if(Dofb.trim().isEmpty()||Dofb==null) {
			  
			  }else {
				  
				  if(!dofbrej.equalsIgnoreCase("DATEOFBITRTHREJ")) {
				  StringBuffer  query11 = new StringBuffer();  StringBuffer  querypDofb = new StringBuffer();
				  StringBuffer  querypDofb1 = new StringBuffer();StringBuffer  querypDofb112 = new StringBuffer();
				 // query1.append("  update emp_edit_details.emp_hr_accept_table set Dateofbirth='"+Dofb+"'  where EmpId="+username+ "; ");
				  StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
				  
				  
				  query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
				  
				  
					System.out.println(query13);
					try {
						
						Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							
							RejStaurs=Res.getInt(1);
							 
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
					System.out.println("the obulesu  AAdhar is::"+RejStaurs);
				  if(RejStaurs==0)
				  {
					// insert
					  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Dateofbirth,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
					  System.out.println(query14512);
					  try {
						ps=conn.prepareStatement(query14512.toString());
						ps.setString(1, username);
						ps.setString(2,Dofb);
						ps.setString(3, Hr_id);
						ps.setInt(4,Status1);
						ps.setString(5, dat2);
						
						
						int aa = ps.executeUpdate();
						System.out.println("the email reason ake ::"+aa);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  //System.out.println("email reject count ::"+);	
				  }
				  else
				  {
					  // update
					  query11.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.Dateofbirth='"+Dofb+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',Status='"+Status1+"';");

					  
						System.out.println(query11);
						try {
							ps=conn.prepareStatement(query11.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
						  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

					  
				  }
				  
				  
				  
					querypDofb112.append("UPDATE hclhrm_prod.tbl_employee_primary  set DATEOFBIRTH='"+Dofb+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

					System.out.println(querypDofb112);
					try {
						ps=conn.prepareStatement(querypDofb112.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					querypDofb1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
					
						//querypDofb1.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

						System.out.println(querypDofb1);
						try {
							ps=conn.prepareStatement(querypDofb1.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }
			  }
			 
			  if( !professionalmob.trim().isEmpty() && professionalmob!=null && !proMobrej.equalsIgnoreCase("PROFIMOBREJ")  ) {
					
				  
				  StringBuffer  query11 = new StringBuffer();  StringBuffer  querypRO1 = new StringBuffer();
				  StringBuffer  querypRO2 = new StringBuffer(); StringBuffer  querypDofb112 = new StringBuffer();
				//  query1.append("  update emp_edit_details.emp_hr_accept_table set Professionalmobile='"+professionalmob+"'  where EmpId="+username+ "; ");

				  
				  		StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
				  		query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
				  				  
					System.out.println(query13);
					try {
						
						Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
						if(Res.next()){
							
							RejStaurs=Res.getInt(1);
							 
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
					System.out.println("the obulesu  AAdhar is::"+RejStaurs);
				  if(RejStaurs==0)
				  {
					// insert
					  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Professionalmobile,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
					  System.out.println(query14512);
					  try {
						ps=conn.prepareStatement(query14512.toString());
						ps.setString(1, username);
						ps.setString(2,professionalmob);
						ps.setString(3, Hr_id);
						ps.setInt(4, Status1);
						ps.setString(5, dat2);
						
						
						int aa = ps.executeUpdate();
						System.out.println("the email reason ake ::"+aa);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  //System.out.println("email reject count ::"+);	
				  }
				  else
				  {
					  // update
					  query11.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
						  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
						  		+ " k on k.slno=u.slno set u.Professionalmobile='"+professionalmob+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

						System.out.println(query11);
						try {
							ps=conn.prepareStatement(query11.toString());
							 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

					  
				  }
				  
				
					
					querypDofb112.append("UPDATE hclhrm_prod.tbl_employee_professional_contact  set phone='"+professionalmob+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

					System.out.println(querypDofb112);
					try {
						ps=conn.prepareStatement(querypDofb112.toString());
						 res1 = ps.executeUpdate();
						
						System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
							
					querypRO2.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
					  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
					  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

					
						//querypRO2.append(" update emp_edit_details.emp_list_table set Status='"+Status+"'  where EmpId="+username+ "; ");

						System.out.println(querypRO2);
						try {
							ps=conn.prepareStatement(querypRO2.toString());
						 res1 = ps.executeUpdate();
							
							System.out.println("the mobile otp exicute query::"+res1);
							backSatus=res1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				  }
			  
			 
				    
				    int sts=1002;
				   
	/*--------------------------------------------Accept All Aadhar  Details-------------------------------------------------*/
					    
			/*
			 * if(GetRouting.equalsIgnoreCase("AadharAccept")) {
			 */							
							
							  StringBuffer  query6 = new StringBuffer();
							  StringBuffer  query7 = new StringBuffer();StringBuffer  query8 = new StringBuffer();
							  StringBuffer  query9 = new StringBuffer();StringBuffer  query10 = new StringBuffer();
							  StringBuffer  query11 = new StringBuffer();
							  StringBuffer  querypDofb112 = new StringBuffer();
							  if(pannumber.trim().isEmpty()||pannumber==null) {
								  
								  	System.out.println("the values are:"+pannumber);
							 
							  }
							  else
							  {
								  
								  if(!panrej.equalsIgnoreCase("PANNUMBERREJ"))
								  {
								  
								  
								  StringBuffer  query1c = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();
								  
								  StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
							  		query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
							  				  
								System.out.println(query13);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
								System.out.println("the obulesu  AAdhar is::"+RejStaurs);
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,pannumber,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
								  System.out.println(query14512);
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,pannumber);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status1);
									ps.setString(5, dat2);
									
									
									int aa = ps.executeUpdate();
									System.out.println("the email reason ake ::"+aa);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  //System.out.println("email reject count ::"+);	
							  }
							  else
							  {
								  // update
								  query1c.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set u.pannumber='"+pannumber+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

								  
									System.out.println(query1c);
									try {
										ps=conn.prepareStatement(query1c.toString());
									 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								  
							  }
							  
								  
								  
								 // query1.append(" update emp_edit_details.emp_hr_accept_table set pannumber='"+pannumber+"', Status='"+Status+"' where EmpId="+username+ "; ");
								  
									//hclhrm_prod.tbl_employee_personalinfo
									
									querypDofb112.append("UPDATE hclhrm_prod.tbl_employee_personalinfo  set pan='"+pannumber+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

									System.out.println(querypDofb112);
									try {
										ps=conn.prepareStatement(querypDofb112.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									
									
									queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

									
									
										//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										  
											backSatus=res1;
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								  }
							  } 
							  
							//2aadharno
							  if(aadharno.trim().isEmpty()||aadharno==null) {
								  
								  	System.out.println("the values are:"+aadharno);
							 
							  }
							  else
							  {
								  
								  if(!aadharej.equalsIgnoreCase("AADHARNAMEREJ")) {
								  
								  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();StringBuffer  que645ryEmai = new StringBuffer();
								  
								//  query1.append(" update emp_edit_details.emp_hr_accept_table set aadharnumber='"+aadharno+"', Status='"+Status+"' where EmpId="+username+ "; ");

								  
								  StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
							  		query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
							  				  
								System.out.println(query13);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
								System.out.println("the obulesu  AAdhar is::"+RejStaurs);
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,aadharnumber,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
								  System.out.println(query14512);
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,aadharno);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status1);
									ps.setString(5, dat2);
									
									
									int aa = ps.executeUpdate();
									System.out.println("the email reason ake ::"+aa);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  //System.out.println("email reject count ::"+);	
							  }
							  else
							  {
								  // update
								  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set u.aadharnumber='"+aadharno+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

									System.out.println(query111);
									try {
										ps=conn.prepareStatement(query111.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								  
							  }
							  
								 
									que645ryEmai.append("UPDATE hclhrm_prod.tbl_employee_personalinfo  set AADHAARCARDNO='"+aadharno+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

									System.out.println(que645ryEmai);
									try {
										ps=conn.prepareStatement(que645ryEmai.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						
									  queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
										
									
										//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query jkhjkhj ::"+res1);
											backSatus=res1;
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							  } 
							  }
							  //3aadharname
							  if(aadharname.trim().isEmpty()||aadharname==null) {
								  
								  	System.out.println("the values are:"+aadharname);
							 
							  }
							  else
							  {
								  
								  
								  if(!aadharej.equalsIgnoreCase("AADHARNAMEREJ"))
								  {
								  
								  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer(); StringBuffer  queryE6765mai1 = new StringBuffer();
								  
								//  query1.append(" update emp_edit_details.emp_hr_accept_table set aadharName='"+aadharname+"', Status='"+Status+"' where EmpId="+username+ "; ");
								  
								  
								  StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
							  		query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
							  				  
								System.out.println(query13);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
								System.out.println("the obulesu  AAdhar is::"+RejStaurs);
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,passportnumber,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
								  System.out.println(query14512);
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,passportNo);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status1);
									ps.setString(5, dat2);
									
									
									int aa = ps.executeUpdate();
									System.out.println("the email reason ake ::"+aa);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  //System.out.println("email reject count ::"+);	
							  }
							  else
							  {
								  // update
								  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set u.passportnumber='"+passportNo+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

									System.out.println(query111);
									try {
										ps=conn.prepareStatement(query111.toString());
										res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								  
							  }
							
								 
									//queryEmai.append(" update emp_edit_details.emp_accept_table set aadharName='"+aadharname+"',  Status='"+Status+"' where EmpId="+username+ "; ");
									
									queryE6765mai1.append("UPDATE hclhrm_prod.tbl_employee_personalinfo  set AADHAARNAME='"+aadharname+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

									System.out.println(queryE6765mai1);
									try {
										ps=conn.prepareStatement(queryE6765mai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
										queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
										
										

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											backSatus=res1;
											
											
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								  }
										
							  } 
							  //4passportNo
							  if(passportNo.trim().isEmpty()||passportNo==null) {
								  
								System.out.println("the values are:"+passportNo);
							 
							  }
							  else
							  {
								  
								  
								  if(!passrej.equalsIgnoreCase("PASSPORTNUMBERREJ"))
								  {
								  
								  
								  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();  StringBuffer  queryEma546i1 = new StringBuffer();
								  
								//  query1.append(" update emp_edit_details.emp_hr_accept_table set passportnumber='"+passportNo+"', Status='"+Status+"' where EmpId="+username+ "; ");

								  StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
							  		query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
							  				  
								System.out.println(query13);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
								System.out.println("the obulesu  AAdhar is::"+RejStaurs);
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,aadharName,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
								  System.out.println(query14512);
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,aadharname);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status);
									ps.setString(5, dat2);
									
									
									int aa = ps.executeUpdate();
									System.out.println("the email reason ake ::"+aa);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  //System.out.println("email reject count ::"+);	
							  }
							  else
							  {
								  // update
								  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+ "))"
									  		+ " k on k.slno=u.slno set u.aadharName='"+aadharname+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

									  
										System.out.println(query111);
										try {
											ps=conn.prepareStatement(query111.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								  
							  }
							
								 								  
								  
								 queryEma546i1.append("UPDATE hclhrm_prod.tbl_employee_personalinfo  set PASSPORTNO='"+passportNo+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

									System.out.println(queryEma546i1);
									try {
										ps=conn.prepareStatement(queryEma546i1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

									
									
										//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
										res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											backSatus=res1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								  }
															  } 
							  //5drivelicNo
							  if(drivelicNo.trim().isEmpty()||drivelicNo==null) {
								  
								  	System.out.println("the values are:"+drivelicNo);
							 
							  }
							  else
							  {
								  if(!drivlcrej.equalsIgnoreCase("DRIVINGLICREJ"))
								  {
								  
								  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
								  StringBuffer  queryEmai1 = new StringBuffer();  StringBuffer  queryE567mai1 = new StringBuffer();
								  
								 // query1.append(" update emp_edit_details.emp_hr_accept_table set DrivingLicenseno='"+drivelicNo+"', Status='"+Status+"' where EmpId="+username+ "; ");

								  
								  StringBuffer  query13 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
							  		query13.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
							  				  
								System.out.println(query13);
								try {
									
									Res=(ResultSet)DataObj.FetchData(query13.toString(), "Req_Adj", Res ,conn);
									if(Res.next()){
										
										RejStaurs=Res.getInt(1);
										 
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  
								System.out.println("the obulesu  AAdhar is::"+RejStaurs);
							  if(RejStaurs==0)
							  {
								// insert
								  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,DrivingLicenseno,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
								  System.out.println(query14512);
								  try {
									ps=conn.prepareStatement(query14512.toString());
									ps.setString(1, username);
									ps.setString(2,drivelicNo);
									ps.setString(3, Hr_id);
									ps.setInt(4, Status);
									ps.setString(5, dat2);
									
									
									int aa = ps.executeUpdate();
									System.out.println("the email reason ake ::"+aa);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  //System.out.println("email reject count ::"+);	
							  }
							  else
							  {
								  // update
								  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
									  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
									  		+ " k on k.slno=u.slno set u.DrivingLicenseno='"+drivelicNo+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

								  
									System.out.println(query111);
									try {
										ps=conn.prepareStatement(query111.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							  }
								  
							
								 
									queryE567mai1.append("UPDATE hclhrm_prod.tbl_employee_personalinfo  set DRIVINGLICENSENO='"+drivelicNo+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

									System.out.println(queryE567mai1);
									try {
										ps=conn.prepareStatement(queryE567mai1.toString());
										 res1 = ps.executeUpdate();
										
										System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
									  
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set Status='"+ols111+"';");
										//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

										System.out.println(queryEmai1);
										try {
											ps=conn.prepareStatement(queryEmai1.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										  
											backSatus=res1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							  } 
							  }
							  
							 
								
							  /*}*/
							 
					    
					   
						  
		/*--------------------------------------------Accept All Bank  Details-------------------------------------------------*/
						    
						    //bankifccode,ACNO,bankname
						    //slno, empId, BankName, AccountNo, IfcsCode, BankFile, DateofModification, Status, reason
						    
			/* if(GetRouting.equalsIgnoreCase("BankAccept")) { */
								
								
								  StringBuffer  query12 = new StringBuffer();StringBuffer  query13 = new StringBuffer();StringBuffer 
								  query14 = new StringBuffer();
								  StringBuffer  query15 = new StringBuffer();
								  //bankifccode
								  if(bankname.trim().isEmpty()||bankname==null) {
									  
									  	System.out.println("the values are:"+bankname);
								 
								  }
								  else
								  {
									  
									  if(!bankrej.equalsIgnoreCase("BANKNAEREJ"))
									  {
									  
										  int bankid=00;
									  StringBuffer  query1111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
									  StringBuffer  queryEmai1 = new StringBuffer(); 
									  
									 
									  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
								  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
								  				  
									System.out.println(query131);
									try {
										
										Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
										if(Res.next()){
											
											RejStaurs=Res.getInt(1);
											 
										}
										
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								  
									System.out.println("the obulesu  AAdhar is::"+RejStaurs);
								  if(RejStaurs==0)
								  {
									// insert
									  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,BankName,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
									  System.out.println(query14512);
									  try {
										ps=conn.prepareStatement(query14512.toString());
										ps.setString(1, username);
										ps.setString(2,bankname);
										ps.setString(3, Hr_id);
										ps.setInt(4, Status1);
										ps.setString(5, dat2);
										
										
										int aa = ps.executeUpdate();
										System.out.println("the email reason ake ::"+aa);
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									  //System.out.println("email reject count ::"+);	
								  }
								  else
								  {
									  // update
									  queryEmai.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set u.BankName='"+bankname+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

										System.out.println(queryEmai);
										try {
											ps=conn.prepareStatement(queryEmai.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								  }
									  
							StringBuffer query121=new StringBuffer();
									  
							query121.append("select bankid from hcladm_prod.tbl_bank_details banks  where bankname='"+bankname+"';");
  
									  
										System.out.println(query121);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query121.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												 bankid=Res.getInt(1);
												 System.out.println("the Bank Id is::"+bankid);
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									 
						
									//  query1.append(" update emp_edit_details.emp_hr_accept_table set BankName='"+bankname+"', Status='"+Status+"' where EmpId="+username+ "; ");

									  
								
										query15.append("UPDATE hclhrm_prod_others.tbl_emp_bank_ifc  set BANKID='"+bankid+"',LUPDATE='"+dat2+"' where empid='"+empseqid+"';");

										System.out.println(query15);
										try {
											ps=conn.prepareStatement(query15.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									
											 query1111.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

											
											
											System.out.println(queryEmai1);
											try {
												ps=conn.prepareStatement(query1111.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												backSatus=res1;
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									  }
								  } 
								 // ACNO
								  if(ACNO.trim().isEmpty()||ACNO==null) {
									  
									  	System.out.println("the values are:"+ACNO);
								 
								  }
								  else
								  {
									  
									  if(!bankrej.equalsIgnoreCase("BANKNAEREJ"))
									  {
									  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
									  StringBuffer  queryEmai1 = new StringBuffer(); StringBuffer  queryEmai451 = new StringBuffer();
									  StringBuffer  queryEmai1456 = new StringBuffer();
									 // query1.append(" update emp_edit_details.emp_hr_accept_table set AccountNo='"+ACNO+"', Status='"+Status+"' where EmpId="+username+ "; ");

									  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
								  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
								  				  
									System.out.println(query131);
									try {
										
										Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
										if(Res.next()){
											
											RejStaurs=Res.getInt(1);
											 
										}
										
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								  
									System.out.println("the obulesu  AAdhar is::"+RejStaurs);
								  if(RejStaurs==0)
								  {
									// insert
									  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,AccountNo,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
									  System.out.println(query14512);
									  try {
										ps=conn.prepareStatement(query14512.toString());
										ps.setString(1, username);
										ps.setString(2,ACNO);
										ps.setString(3, Hr_id);
										ps.setInt(4, Status1);
										ps.setString(5, dat2);
										
										
										int aa = ps.executeUpdate();
										System.out.println("the email reason ake ::"+aa);
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									  //System.out.println("email reject count ::"+);	
								  }
								  else
								  {
									  // update
									  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set u.AccountNo='"+ACNO+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

									 // acc
									  
										System.out.println(query111);
									 
										queryEmai451.append("UPDATE hclhrm_prod_others.tbl_emp_bank_ifc  set BANKACC='"+ACNO+"',LUPDATE='"+dat2+"' where empid='"+empseqid+"';");

										System.out.println(queryEmai451);
										try {
											ps=conn.prepareStatement(queryEmai451.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								  }
									  
								
									 
										//select ACCOUNTNO from hclhrm_prod.tbl_employee_other_detail other where employeeid=102478 ;
										queryEmai1456.append("UPDATE hclhrm_prod.tbl_employee_other_detail  set ACCOUNTNO='"+ACNO+"',LUPDATE='"+dat2+"' where employeeid='"+empseqid+"';");

										System.out.println(queryEmai1456);
										try {
											ps=conn.prepareStatement(queryEmai1456.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									 
							
									 
									 
										try {
											ps=conn.prepareStatement(query111.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								/*
								 * queryEmai.append(" update emp_edit_details.emp_accept_table set AccountNo='"
								 * +ACNO+"',  Status='"+Status+"' where EmpId="+username+ "; ");
								 * 
								 * System.out.println(queryEmai); try {
								 * ps=conn.prepareStatement(queryEmai.toString()); int res1 =
								 * ps.executeUpdate();
								 * 
								 * System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
								 * 
								 * } catch (SQLException e) { // TODO Auto-generated catch block
								 * e.printStackTrace(); }
								 */
										queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

										
										
										//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

											System.out.println(queryEmai1);
											try {
												ps=conn.prepareStatement(queryEmai1.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												backSatus=res1;
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
								  } 
								  }
								  //bankname
								  if(bankifccode.trim().isEmpty()||bankifccode==null) {
									  
									  	System.out.println("the values are:"+bankifccode);
								 
								  }
								  else
								  {
									  
									  if(!bankrej.equalsIgnoreCase("BANKNAEREJ"))
									  {
									  
										  
										 System.out.println("obulesu bank Details"); 
										  
									  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
									  StringBuffer  queryEmai1 = new StringBuffer(); StringBuffer  queryEmai45651 = new StringBuffer();
									  
									 // query1.append(" update emp_edit_details.emp_hr_accept_table set IfcsCode='"+bankifccode+"', Status='"+Status+"' where EmpId="+username+ "; ");

									  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
								  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
								  				  
									System.out.println(query131);
									try {
										
										Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
										if(Res.next()){
											
											RejStaurs=Res.getInt(1);
											 
										}
										
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								  
									System.out.println("the obulesu  AAdhar is::"+RejStaurs);
								  if(RejStaurs==0)
								  {
									// insert
									  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,IfcsCode,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
									  System.out.println(query14512);
									  try {
										ps=conn.prepareStatement(query14512.toString());
										ps.setString(1, username);
										ps.setString(2,bankifccode);
										ps.setString(3, Hr_id);
										ps.setInt(4, Status1);
										ps.setString(5, dat2);
										
										
										int aa = ps.executeUpdate();
										System.out.println("the email reason ake ::"+aa);
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									  //System.out.println("email reject count ::"+);	
								  }
								  else
								  {
									  // update
									  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
										  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
										  		+ " k on k.slno=u.slno set u.IfcsCode='"+bankifccode+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

									  
										System.out.println(query111);
										try {
											ps=conn.prepareStatement(query111.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											backSatus=res1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								
								  }
									  
							
									  
									 
										queryEmai45651.append("UPDATE hclhrm_prod_others.tbl_emp_bank_ifc  set BANKIFC='"+bankifccode+"',LUPDATE='"+dat2+"' where empid='"+empseqid+"';");

										System.out.println(queryEmai45651);
										try {
											ps=conn.prepareStatement(queryEmai45651.toString());
											 res1 = ps.executeUpdate();
											
											System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
										  
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									 
										
										
										
										
										
										
										queryEmai.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

										
										
										
										//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

											System.out.println(queryEmai1);
											try {
												ps=conn.prepareStatement(queryEmai.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
								  } 
								  
								  
								  }
									
								 /* }*/
								 
						    
						   
							  
								/*--------------------------------------------Accept All communication   Details-------------------------------------------------*/
							    
			/* if(GetRouting.equalsIgnoreCase("commAccept")) { */
									
									
									  StringBuffer  query16 = new StringBuffer();  StringBuffer  query17 = new StringBuffer();
									  StringBuffer  query18 = new StringBuffer();  StringBuffer  query19 = new StringBuffer();
									  StringBuffer  query20 = new StringBuffer();  StringBuffer  query21 = new StringBuffer();
									  StringBuffer  querypDofb1412 = new StringBuffer();  StringBuffer  query23 = new StringBuffer();
									  
										//cstate,ccity,commuaddress,commuaddress1,commuaddress2,commuaddress3,cpin	
									//  slno, empId, CommunicationAddress, country, state, city, pin, Dateofmodification, Status,
									//  communication2, communication3, communication4, reason
									  //state
									  if(cstate.trim().isEmpty()||cstate==null) {
										  
									  	System.out.println("the values are:"+cstate);
									 
									  }
									  else
									  {
										  
										  if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  {
										  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  
										//  query1.append(" update emp_edit_details.emp_hr_accept_table set Cstate='"+cstate+"', Status='"+Status+"' where EmpId="+username+ "; ");

										  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
									  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
									  				  
										System.out.println(query131);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												RejStaurs=Res.getInt(1);
												 
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									  
										System.out.println("the obulesu  AAdhar is::"+RejStaurs);
									  if(RejStaurs==0)
									  {
										// insert
										  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Cstate,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
										  System.out.println(query14512);
										  try {
											ps=conn.prepareStatement(query14512.toString());
											ps.setString(1, username);
											ps.setString(2,cstate);
											ps.setString(3, Hr_id);
											ps.setInt(4, Status1);
											ps.setString(5, dat2);
											
											
											int aa = ps.executeUpdate();
											System.out.println("the email reason ake ::"+aa);
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  //System.out.println("email reject count ::"+);	
									  }
									  else
									  {
										  // update
										  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set u.Cstate='"+cstate+"',verifiedbyHr='"+Hr_id+"', dateofmodification='"+dat2+"',Status='"+Status1+"';");

										  
										  
										  
											System.out.println(query111);
											try {
												ps=conn.prepareStatement(query111.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									
									  }
										  
								
											
											queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

											
												//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

												System.out.println(query111);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
									  } 
									  //city
									  if(ccity.trim().isEmpty()||ccity==null) {
										  
										  	System.out.println("the values are:"+bankifccode);
									 
									  }
									  else
									  {
										  
										  if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  {
										  
										  StringBuffer  query31 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  
										//  query3.append(" update emp_edit_details.emp_hr_accept_table set Ccity='"+ccity+"', Status='"+Status+"' where EmpId="+username+ "; ");

										  
										  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
									  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
									  				  
										System.out.println(query131);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												RejStaurs=Res.getInt(1);
												 
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									  
										System.out.println("the obulesu  AAdhar is::"+RejStaurs);
									  if(RejStaurs==0)
									  {
										// insert
										  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Cstate,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
										  System.out.println(query14512);
										  try {
											ps=conn.prepareStatement(query14512.toString());
											ps.setString(1, username);
											ps.setString(2,cstate);
											ps.setString(3, Hr_id);
											ps.setInt(4, Status1);
											ps.setString(5, dat2);
											
											
											int aa = ps.executeUpdate();
											System.out.println("the email reason ake ::"+aa);
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  //System.out.println("email reject count ::"+);	
									  }
									  else
									  {
										  // update
										  query31.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set u.Ccity='"+ccity+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

										  
											System.out.println(query31);
											try {
												ps=conn.prepareStatement(query31.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									
									  }
								
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
													  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
													  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												
												
												System.out.println(queryEmai1);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
												res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
									  } 
									  
									  
									  
									  }
									  
									  
									  
									  
									  
									  
									  
									  //add1
									  if(commuaddress.trim().isEmpty()||commuaddress==null) {
										  
										  	System.out.println("the values are:"+commuaddress);
									 
									  }
									  else
									  {
										  
										  if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  {
										  
										  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  
										  //query1.append(" update emp_edit_details.emp_hr_accept_table set CommunicationAddress='"+commuaddress+"', Status='"+Status+"' where EmpId="+username+ "; ");

										  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
									  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
									  				  
										System.out.println(query131);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												RejStaurs=Res.getInt(1);
												 
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									  
										System.out.println("the obulesu  AAdhar is::"+RejStaurs);
									  if(RejStaurs==0)
									  {
										// insert
										  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,CommunicationAddress,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
										  System.out.println(query14512);
										  try {
											ps=conn.prepareStatement(query14512.toString());
											ps.setString(1, username);
											ps.setString(2,commuaddress);
											ps.setString(3, Hr_id);
											ps.setInt(4, Status1);
											ps.setString(5, dat2);
											
											
											int aa = ps.executeUpdate();
											System.out.println("the email reason ake ::"+aa);
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  //System.out.println("email reject count ::"+);	
									  }
									  else
									  {
										  // update
										  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set u.CommunicationAddress='"+commuaddress+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											System.out.println(query111);
											try {
												ps=conn.prepareStatement(query111.toString());
											 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												backSatus=res1;
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									
									  }
								
										StringBuffer qrie=new StringBuffer();
										qrie.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set COMMUNICATIONADDRESS='"+commuaddress+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

											System.out.println(qrie);
											try {
												ps=conn.prepareStatement(qrie.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

											
											
												//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												
												
												
												System.out.println(queryEmai1);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
									  } 
									  //add2
									  if(commuaddress1.trim().isEmpty()||commuaddress1==null) {
										  
										  	System.out.println("the values are:"+commuaddress1);
									 
									  }
									  else
									  {
										  
										  if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  {
										  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  
										//  query1.append(" update emp_edit_details.emp_hr_accept_table set communication2='"+commuaddress1+"', Status='"+Status+"' where EmpId="+username+ "; ");

										  
										  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
									  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
									  				  
										System.out.println(query131);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												RejStaurs=Res.getInt(1);
												 
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									  
										System.out.println("the obulesu  AAdhar is::"+RejStaurs);
									  if(RejStaurs==0)
									  {
										// insert
										  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,communication2,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
										  System.out.println(query14512);
										  try {
											ps=conn.prepareStatement(query14512.toString());
											ps.setString(1, username);
											ps.setString(2,commuaddress1);
											ps.setString(3, Hr_id);
											ps.setInt(4,Status1 );
											ps.setString(5, dat2);
											
											
											int aa = ps.executeUpdate();
											System.out.println("the email reason ake ::"+aa);
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  //System.out.println("email reject count ::"+);	
									  }
									  else
									  {
										  // update
										  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set u.communication2='"+commuaddress1+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

										
										  
											System.out.println(query111);
											try {
												ps=conn.prepareStatement(query111.toString());
											 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											

									
									  }
																	
											querypDofb1412.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set COMMUNICATIONADDRESS2='"+commuaddress1+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

											System.out.println(querypDofb1412);
											try {
												ps=conn.prepareStatement(querypDofb1412.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
										
											queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

											
												//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

												System.out.println(queryEmai1);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
									  } 
									  //add3
									  if(commuaddress2.trim().isEmpty()||commuaddress2==null) {
										  
										  	System.out.println("the values are:"+commuaddress2);
									 
									  }
									  else
									  {
										  	if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  	{
										  
										  
										  
										   StringBuffer  query111 = new StringBuffer();  //StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer();
											  
											 // query1.append(" update emp_edit_details.emp_hr_accept_table set communication3='"+commuaddress2+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  
											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,communication3,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,commuaddress2);
												ps.setString(3, Hr_id);
												ps.setInt(4, Status1);
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.communication3='"+commuaddress2+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											  
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												
												

										
										  }
											  
											  
										
											  
											  
												query17.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set COMMUNICATIONADDRESS3='"+commuaddress2+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

												System.out.println(query17);
												try {
													ps=conn.prepareStatement(query17.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												
												
													
													//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
													  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
													  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
														backSatus=res1;
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
										  	}
									  } 
									  //add4
									  if(commuaddress3.trim().isEmpty()||commuaddress3==null) {
										  
										  	System.out.println("the values are:"+commuaddress3);
									 
									  }
									  else
									  {
										  
										  if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  {
										  
										  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  
										 // query1.append(" update emp_edit_details.emp_hr_accept_table set communication4='"+commuaddress3+"', Status='"+Status+"' where EmpId="+username+ "; ");

										  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
									  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
									  				  
										System.out.println(query131);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												RejStaurs=Res.getInt(1);
												 
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									  
										System.out.println("the obulesu  AAdhar is::"+RejStaurs);
									  if(RejStaurs==0)
									  {
										// insert
										  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,communication4,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
										  System.out.println(query14512);
										  try {
											ps=conn.prepareStatement(query14512.toString());
											ps.setString(1, username);
											ps.setString(2,commuaddress3);
											ps.setString(3, Hr_id);
											ps.setInt(4, Status1);
											ps.setString(5, dat2);
											
											
											int aa = ps.executeUpdate();
											System.out.println("the email reason ake ::"+aa);
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  //System.out.println("email reject count ::"+);	
									  }
									  else
									  {
										  // update
										  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set u.communication4='"+commuaddress3+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

										
										  
											System.out.println(query111);
											try {
												ps=conn.prepareStatement(query111.toString());
												res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

									
									  }
										  
								
										 
											query19.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set COMMUNICATIONADDRESS4='"+commuaddress3+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

											System.out.println(query19);
											try {
												ps=conn.prepareStatement(query19.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
											
											
											queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

											
											
											
											//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

												System.out.println(queryEmai1);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
									  } 
									  //cpin
									  if(cpin.trim().isEmpty()||cpin==null) {
										  
										  	System.out.println("the values are:"+cpin);
									 
									  }
									  else
									  {
										  
										  if(!commaddrej.equalsIgnoreCase("COMSTATEREJ"))
										  {
										  
										  
										  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
										  StringBuffer  queryEmai1 = new StringBuffer();
										  
										//  query1.append(" update emp_edit_details.emp_hr_accept_table set Cpin='"+cpin+"', Status='"+Status+"' where EmpId="+username+ "; ");

										  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
									  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
									  				  
										System.out.println(query131);
										try {
											
											Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
											if(Res.next()){
												
												RejStaurs=Res.getInt(1);
												 
											}
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									  
										System.out.println("the obulesu  AAdhar is::"+RejStaurs);
									  if(RejStaurs==0)
									  {
										// insert
										  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,Cpin,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
										  System.out.println(query14512);
										  try {
											ps=conn.prepareStatement(query14512.toString());
											ps.setString(1, username);
											ps.setString(2,cpin);
											ps.setString(3, Hr_id);
											ps.setInt(4, Status1);
											ps.setString(5, dat2);
											
											
											int aa = ps.executeUpdate();
											System.out.println("the email reason ake ::"+aa);
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  //System.out.println("email reject count ::"+);	
									  }
									  else
									  {
										  // update
										  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
											  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
											  		+ " k on k.slno=u.slno set u.Cpin='"+cpin+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',Status='"+Status1+"';");

											System.out.println(query111);
											try {
												ps=conn.prepareStatement(query111.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

									
									  }
										  
								
										 
											query20.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set COMMUNICATIONZIP='"+cpin+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

											System.out.println(query20);
											try {
												ps=conn.prepareStatement(query20.toString());
												 res1 = ps.executeUpdate();
												
												System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
											  
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
												//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												System.out.println(queryEmai1);
												try {
													ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
									  } 
									  
									  }
									  
									 
										
									 /* }*/
									 
							    
							   
								    
								    
			/* if(GetRouting.equalsIgnoreCase("perAccept")) { */
										
										
										  StringBuffer  query24 = new StringBuffer(); StringBuffer  query25 = new StringBuffer();
										  StringBuffer  query26 = new StringBuffer(); StringBuffer  query27 = new StringBuffer();
										  StringBuffer  query28 = new StringBuffer(); StringBuffer  query29 = new StringBuffer();
										  StringBuffer  query30 = new StringBuffer();  StringBuffer  query31= new StringBuffer();
										  
										  if(pstate.trim().isEmpty()||pstate==null) {
											  
											  	System.out.println("the values are:"+pstate);
										 
										  }
										  else
										  {
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer();
											  
											 // query1.append(" update emp_edit_details.emp_hr_accept_table set state='"+pstate+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,state,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,pstate);
												ps.setString(3, Hr_id);
												ps.setInt(4, Status1);
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.state='"+pstate+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											
											  
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										
										  }
											  
								
												
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
													 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
														backSatus=res1;
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											  }
										  }   
										  
										  if(pcity.trim().isEmpty()||pcity==null) {
											  
										  	System.out.println("the values are:"+pcity);
										 
										  }
										  else
										  {
											  
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer();
											  
											//  query1.append(" update emp_edit_details.emp_hr_accept_table set city='"+pcity+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  
											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,city,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,pcity);
												ps.setString(3, Hr_id);
												ps.setInt(4, Status1);
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.city='"+pcity+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										
										  }
											  
										
							
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												
												
												
													//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													  
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											  }
										  }    
										  
										  if(peraddress.trim().isEmpty()||peraddress==null) {
											  
											  	System.out.println("the values are:"+peraddress);
										 
										  }
										  else
										  {
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer();
											  
											//  query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress='"+peraddress+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  
											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,PermanentAddress,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,peraddress);
												ps.setString(3, Hr_id);
												ps.setInt(4, Status1);
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.PermanentAddress='"+peraddress+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											  
											  
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										
										  }
											  
										
											 StringBuffer eee=new StringBuffer();
											 eee.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set PERMANENTADDRESS='"+peraddress+"', DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

												System.out.println(eee);
												try {
													ps=conn.prepareStatement(eee.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												
												
												
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												
												
												
												
													//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
														backSatus=res1;
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											  }
										  }     
										  
										  if(peraddress1.trim().isEmpty()||peraddress1==null) {
											  
											  	System.out.println("the values are:"+peraddress1);
										 
										  }
										  else
										  {
											  
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											   StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
												  StringBuffer  queryEmai1 = new StringBuffer(); StringBuffer  queryEmai14 = new StringBuffer();
												  
												 // query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress2='"+peraddress1+"', Status='"+Status+"' where EmpId="+username+ "; ");

												  
												  
												  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
											  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
											  				  
												System.out.println(query131);
												try {
													
													Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
													if(Res.next()){
														
														RejStaurs=Res.getInt(1);
														 
													}
													
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											  
												System.out.println("the obulesu  AAdhar is::"+RejStaurs);
											  if(RejStaurs==0)
											  {
												// insert
												  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,PermanentAddress2,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
												  System.out.println(query14512);
												  try {
													ps=conn.prepareStatement(query14512.toString());
													ps.setString(1, username);
													ps.setString(2,peraddress1);
													ps.setString(3, Hr_id);
													ps.setInt(4,Status1 );
													ps.setString(5, dat2);
													
													
													int aa = ps.executeUpdate();
													System.out.println("the email reason ake ::"+aa);
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												  //System.out.println("email reject count ::"+);	
											  }
											  else
											  {
												  // update
												  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
													  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
													  		+ " k on k.slno=u.slno set u.PermanentAddress2='"+peraddress1+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

												  
													System.out.println(query111);
													try {
														ps=conn.prepareStatement(query111.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													  
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											
											  }
												  
										

													queryEmai14.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set PERMANENTADDRESS2='"+peraddress1+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

													System.out.println(queryEmai14);
													try {
														ps=conn.prepareStatement(queryEmai14.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
													  
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
													
													
													
													
													
													
													queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
													  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
													  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

													
													
														//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

														System.out.println(queryEmai1);
														try {
															ps=conn.prepareStatement(queryEmai1.toString());
															 res1 = ps.executeUpdate();
															
															System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
															backSatus=res1;
														} catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
											  }
										  }     
										  
										  
										  if(peraddress2.trim().isEmpty()||peraddress2==null) {
											  
										  	System.out.println("the values are:"+peraddress2);
										 
										  }
										  else
										  {
											  
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer();StringBuffer  queryEmai16 = new StringBuffer();
											  
											  //query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress3='"+peraddress2+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  
											  
											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,PermanentAddress3,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,peraddress2);
												ps.setString(3, Hr_id);
												ps.setInt(4,Status );
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.PermanentAddress3='"+peraddress2+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											  
											  
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
												 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
											  
										
											  
											  
											 
												queryEmai16.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set PERMANENTADDRESS3='"+peraddress2+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

												System.out.println(queryEmai16);
												try {
													ps=conn.prepareStatement(queryEmai16.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												
												
												
												
												
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												
													//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
														backSatus=res1;
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											  }
										  }     
										  
										  if(peraddress3.trim().isEmpty()||peraddress3==null) {
											  
											  	System.out.println("the values are:"+peraddress3);
										 
										  }
										  else
										  {
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer(); StringBuffer  queryEmai1545 = new StringBuffer();
											  
											  //query1.append(" update emp_edit_details.emp_hr_accept_table set PermanentAddress4='"+peraddress3+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  
											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,PermanentAddress4,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,peraddress3);
												ps.setString(3, Hr_id);
												ps.setInt(4, Status1);
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.PermanentAddress4='"+peraddress3+"',verifiedbyHr='"+Hr_id+"',dateofmodification='"+dat2+"',Status='"+Status1+"';");

											  
											  
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
												 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
													backSatus=res1;
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
											  
										
											  
											 
												queryEmai1545.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set PERMANENTADDRESS4='"+peraddress3+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

												System.out.println(queryEmai1545);
												try {
													ps=conn.prepareStatement(queryEmai1545.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												
												
												
												
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status='"+ols111+"';");

												
												
												//	queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
														backSatus=res1;
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											  }
										  }     
										  
										  if(ppin.trim().isEmpty()||ppin==null) {
											  
											 	System.out.println("the values are:"+peraddress3);
										 
										  }
										  else
										  {
											  if(!peraddrrej.equalsIgnoreCase("PERSTATEREJ"))
											  {
											  
											  StringBuffer  query111 = new StringBuffer();  StringBuffer  queryEmai = new StringBuffer();
											  StringBuffer  queryEmai1 = new StringBuffer();StringBuffer  queryE45mai1 = new StringBuffer();
											  
											 // query1.append(" update emp_edit_details.emp_hr_accept_table set pin='"+ppin+"', Status='"+Status+"' where EmpId="+username+ "; ");

											  
											  
											  StringBuffer  query131 = new StringBuffer();  StringBuffer  query14512 = new StringBuffer();
										  		query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"+username+"' and Status=1001;");
										  				  
											System.out.println(query131);
											try {
												
												Res=(ResultSet)DataObj.FetchData(query131.toString(), "Req_Adj", Res ,conn);
												if(Res.next()){
													
													RejStaurs=Res.getInt(1);
													 
												}
												
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  
											System.out.println("the obulesu  AAdhar is::"+RejStaurs);
										  if(RejStaurs==0)
										  {
											// insert
											  query14512.append(" insert into emp_edit_details.emp_hr_accept_table(EmpID,pin,verifiedbyHr,Status,dateofmodification)   values( ?,?,?,?,? ); ");
											  System.out.println(query14512);
											  try {
												ps=conn.prepareStatement(query14512.toString());
												ps.setString(1, username);
												ps.setString(2,ppin);
												ps.setString(3, Hr_id);
												ps.setInt(4, Status1);
												ps.setString(5, dat2);
												
												
												int aa = ps.executeUpdate();
												System.out.println("the email reason ake ::"+aa);
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											  //System.out.println("email reject count ::"+);	
										  }
										  else
										  {
											  // update
											  query111.append(" UPDATE emp_edit_details.emp_hr_accept_table u join (SELECT a.slno from emp_edit_details.emp_hr_accept_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_hr_accept_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set u.pin='"+ppin+"',dateofmodification='"+dat2+"',verifiedbyHr='"+Hr_id+"',Status='"+Status1+"';");

											  
												System.out.println(query111);
												try {
													ps=conn.prepareStatement(query111.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										  }
											  
										
											  
											  
											  
												queryE45mai1.append("UPDATE hclhrm_prod.tbl_employee_personal_contact  set PERMANENTZIP='"+ppin+"',DATEMODIFIED='"+dat2+"',VERIFIEDBY='"+Hr_id+"' where employeeid='"+empseqid+"';");

												System.out.println(queryE45mai1);
												try {
													ps=conn.prepareStatement(queryE45mai1.toString());
													 res1 = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query pullirapuobulesu eMAIL ::"+res1);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												
												
												
												queryEmai1.append(" UPDATE emp_edit_details.emp_list_table u join (SELECT a.slno from emp_edit_details.emp_list_table a where"
												  		+ " slno=(select max(slno)from emp_edit_details.emp_list_table where empid="+username+"))"
												  		+ " k on k.slno=u.slno set Status="+ols111+";");

												
												
													//queryEmai1.append(" update emp_edit_details.emp_list_table set  Status='"+Status+"' where EmpId="+username+ "; ");

													System.out.println(queryEmai1);
													try {
														ps=conn.prepareStatement(queryEmai1.toString());
														 res1 = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query pullirapuobulesu ::"+res1);
														backSatus=res1;
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											  }
										  }     
										  
										  
											
										/*  }*/
										 
				    }    
								
	// rejected list							    
								    
								    
								 int sts=00;   
									    if(GetRouting.equalsIgnoreCase("permRej"))
											  {
												  StringBuffer  query1 = new StringBuffer();
												  query1.append(" update hclhrm_prod.emp_permanentaddress_edit set Status='"+sts+"', reason='"+Rejres+"' where empId="+username+ "; ");

													System.out.println(query1);
													try {
														ps=conn.prepareStatement(query1.toString());
														pqext = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query::"+pqext);
													  
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}  
											  }
					    
									    if(GetRouting.equalsIgnoreCase("personalRej"))
										  {
											  StringBuffer  query1 = new StringBuffer();
											  query1.append(" update hclhrm_prod.personal_edit_details set Status='"+sts+"', reason='"+Rejres+"' where empId="+username+ "; ");

												System.out.println(query1);
												try {
													ps=conn.prepareStatement(query1.toString());
													pqext = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query::"+pqext);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}  
										  }

									    if(GetRouting.equalsIgnoreCase("commRej"))
											  {
												  StringBuffer  query1 = new StringBuffer();
												  query1.append(" update hclhrm_prod.emp_communication_edit_details set Status='"+sts+"', reason='"+Rejres+"' where empId="+username+ "; ");

													System.out.println(query1);
													try {
														ps=conn.prepareStatement(query1.toString());
														pqext = ps.executeUpdate();
														
														System.out.println("the mobile otp exicute query::"+pqext);
													  
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}  
											  }
					    
									    if(GetRouting.equalsIgnoreCase("BankRej"))
										  {
											  StringBuffer  query1 = new StringBuffer();
											  query1.append(" update emp_edit_details.emp_list_table set Status='"+sts+"', reason='"+Rejres+"' where empId="+username+ "; ");

												System.out.println(query1);
												try {
													ps=conn.prepareStatement(query1.toString());
													pqext = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query::"+pqext);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}  
										  }
									    if(GetRouting.equalsIgnoreCase("AadharRej"))
										  {
											  StringBuffer  query1 = new StringBuffer();
											  query1.append(" update hclhrm_prod.emp_aadhar_pan_edit_details set Status='"+sts+"', reason='"+Rejres+"' where empId="+username+ "; ");

												System.out.println(query1);
												try {
													ps=conn.prepareStatement(query1.toString());
													pqext = ps.executeUpdate();
													
													System.out.println("the mobile otp exicute query::"+pqext);
												  
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}  
										  }
							    
							    
							    
							    
							    
							    
							    
							    
		
	 jason.put("pqext", pqext);
		
		jason.put("routing", GetRouting);jason.put("res1", res1);
		//res1
		jason.put("empt", empt);jason.put("backSatus", backSatus);
		
		

		System.out.println("the error code is :::"+jason);
		
		out.write(jason.toString());
		
		try {
			ConnectionpoolFilter.close(conn, Res,"HrApprvalSubmit",true);
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
