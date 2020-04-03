package iconnect.hhcl.service;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;


/**
 * Servlet implementation class ReqAcpt
 */
public class ReqAcpt_Resi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqAcpt_Resi() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Atten_Req_Message="Successfully Submit.";
		
		System.out.println("Hit ReqActp 2");
		
		PrintWriter out = response.getWriter();
		int rs=0;
		//System.out.println(request.getParameter("id")+"<---------");
		
		String ROUTING=request.getParameter("ROUTING");
		
		String empid=request.getParameter("id");
		String flagupdate=request.getParameter("flag");
		String rid=request.getParameter("rid");
		
		String APP_MOD=request.getParameter("APP_MOD");
		
		String comments=request.getParameter("comment");
		
		HttpSession session=request.getSession();
		
		
		String User_id=(String)session.getAttribute("EMP_ID");
		String User_pwd=(String)session.getAttribute("EMP_PASSWORD");
		
		/*if(ROUTING!=null && ROUTING.equalsIgnoreCase("EMPLOYEE")){
			
			empid=User_id;
		}*/
		
		
		System.out.println(empid +"~ "+flagupdate+"~"+rid+"~"+comments);
		//14~ 84~Approve~null
		 //  id  comment
		//out.write(Atten_Req_Message);
		//out.write("~"+flagupdate);
		//out.write("~Mahesh");
		ResultSet Res=null;
		GetDbData DataObj=new GetDbData();
		java.sql.Connection con=null;
		ServletContext c = getServletContext();
		System.out.println("GetParameter"+ c.getAttribute("Venu"));
		DataSource dataSource=null;
		
		ResourceBundle bundle_info =(ResourceBundle)(c.getAttribute("bundle"));
		
		//Connection con = (Connection) Dbconnection.getDBConection();
		/*try {
			dataSource=(DataSource)(c.getAttribute("dataSource"));

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			con =dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/*DataSource_Cls ConnObj=null;
		try {
			 ConnObj=new DataSource_Cls();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (PropertyVetoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			//conn =dataSource.getConnection();
			con=ConnObj.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		/*
		 * try { //conn =dataSource.getConnection();
		 * con=(java.sql.Connection)session.getAttribute("ConnectionObj"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
	
		
		final Logger logger = Logger.getLogger(ReqAcpt_Resi.class);
		long start = System.currentTimeMillis();
			
			con=null; 
			try {
				try {
					con = ConnectionpoolFilter.Call();
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				logger.error(e1.getLocalizedMessage());
				e1.printStackTrace();
			}
			logger.info("Login Servlet Main  - welcome " +con );
		
		
		
		
		
// ===================================================================
		int Authcode=0;
		String Emp_name=null,Emp_id=null,approved_Mesg=null;
		Res=null;
	    StringBuffer validate=new StringBuffer();
		validate.append(" SELECT COUNT(*),A.EMPLOYEECODE,B.CALLNAME FROM  ");
		validate.append(" HCLHRM_PROD.TBL_EMPLOYEE_LOGIN A ");
		validate.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEECODE=B.EMPLOYEESEQUENCENO ");
		validate.append(" WHERE EMPLOYEECODE="+User_id);
		validate.append(" AND PASSWORD=md5('"+User_pwd+"') ");
		
		
		try {
			Res=(ResultSet)DataObj.FetchData(validate.toString(), "Emp_DOJ", Res ,con);
			if(Res.next()){
				
				Authcode=Res.getInt(1); 
				Emp_id=Res.getString(2);
				Emp_name=Res.getString(3);
				
			}  
		}catch(Exception Er){
			System.out.println("Exception At Er::"+Er);
		}
		
		
		StringBuffer updateflag=new StringBuffer();
		int record=0;
	int count_flg=0;
	String Test_Flag=null,test_approved=null,test_approvedname=null,test_EMPLOYEEID=null;
   if(Authcode>0){
	   
	   
	     //*****************************************************************************
	 		try{
	 			
	 			System.out.println("rs  ::: "+rs);
	 			
	 			if(rs>0){
	 				Atten_Req_Message="Successfully Submit";
	 				System.out.println("Done");
	 			}else{
	 				try {
	 					
	 					if(APP_MOD.equalsIgnoreCase("MG")){	
	 						if(flagupdate.equalsIgnoreCase("ok")){
	 						Res=(ResultSet)DataObj.FetchData("select count(*) from hclhrm_prod_others.tbl_emp_resignation where EMPLOYEEID="+rid+" and MANAGER_MSTATUS in('A','R') and CC_STATUS in('A','R') and status=1001", "Manager approvals", Res ,con);
	 						}else{
	 							Res=(ResultSet)DataObj.FetchData("select count(*) from hclhrm_prod_others.tbl_emp_resignation where EMPLOYEEID="+rid+" and MANAGER_MSTATUS='P' and CC_STATUS='P' ", "Manager approvals", Res ,con);
	 		 						
	 						}
		 				}else if(APP_MOD.equalsIgnoreCase("HR")){
	 						
		 					Res=(ResultSet)DataObj.FetchData("select count(*) from hclhrm_prod_others.tbl_emp_resignation where EMPLOYEEID="+rid+" and MANAGER_MSTATUS in ('A','R') and CC_STATUS='P' ", "HR APPROVALS", Res ,con);
		 							
	 					}
	 					
	 					if(Res.next()){
	 						
	 						count_flg=Res.getInt(1);
	 						/*Test_Flag=Res.getString(2);
	 						test_approved=Res.getString(3);
	 						test_approvedname=Res.getString(4);
	 						test_EMPLOYEEID=Res.getString(5);*/
	 						//Atten_Req_Message="Your are already "+approved_Mesg;
	 						System.out.println(count_flg +"~" +Test_Flag+ "~"+test_approved+ "~"+ test_EMPLOYEEID);
	 					}  
	 				}catch(Exception Er){
	 					System.out.println("Exception At Er::"+Er);
	 					Atten_Req_Message="Unable to Process your request right now";
	 				}
	 			}
	 			}catch(Exception g){
	 				Atten_Req_Message="Unable to Process your request right now";
	 				g.printStackTrace();
	 				System.out.println("Fail");
	 			}
	   //****************************************************************************
	 		boolean auth_apr_flag=false;
	 		if(count_flg==0){
	 			
	 			Atten_Req_Message="Already Processed";
	 			auth_apr_flag=false;
	 			
	 		}else if(count_flg>0){
	 			
	 			//Atten_Req_Message="This request is approved by '"+test_approvedname+"' his/her  having rights for Canceld/Reject . ";
	 			auth_apr_flag=true;
	 			
	 		}
	   //********************************************************************************
	 System.out.println("auth_apr_flag ::" +auth_apr_flag);
	 if(auth_apr_flag){
		try{
			
			System.out.println(empid +"~ "+flagupdate+"~"+rid+"~"+comments);
			//14~ 84~Approve~null
			if(comments==null){
			 comments="APPROVE FROM APPLICATION";
			}
			//updateflag.append("UPDATE hclhrm_prod_others.tbl_emp_attn_req set FLAG='"+flagupdate+"',comments= '"+comments+"',approvedby='"+Emp_id+"',approvedname='"+Emp_name+"' WHERE FLAG in('P','A') AND EMPLOYEEID="+empid+" AND RID="+rid+" ");
			
		if(APP_MOD.equalsIgnoreCase("MG")){
			
			if(flagupdate.equalsIgnoreCase("ok")){
			
				updateflag.append("UPDATE hclhrm_prod_others.tbl_emp_resignation set MGR_OK=1001 where EMPLOYEEID="+rid+" and status=1001 and MANAGER_MSTATUS in('A','R') and CC_STATUS in('A','R') ");
				
			}else{
			updateflag.append("UPDATE hclhrm_prod_others.tbl_emp_resignation set MANAGER_MSTATUS='"+flagupdate+"', MANAGERS_COMMENTS='"+comments+"', MA_APP_DATE=now() where EMPLOYEEID="+rid+" and MANAGER_MSTATUS='P'  and CC_STATUS='P' ");
			}
		
		}else if(APP_MOD.equalsIgnoreCase("HR")){
			
			updateflag.append("UPDATE hclhrm_prod_others.tbl_emp_resignation set CC_STATUS='"+flagupdate+"',HRS_COMMENTS='"+comments+"', HR_APP_DATE=now() where EMPLOYEEID="+rid+" and MANAGER_MSTATUS in('A','R') and CC_STATUS='P' ");
				
		}
			
			System.out.println(updateflag.toString());
			PreparedStatement ps=con.prepareStatement(updateflag.toString());
			try{
				 record=ps.executeUpdate();
				
				if(record==0){
					 Atten_Req_Message="Faild your request please try again with valid data/contact system admin";
				}
				System.out.println("record" +record);
			}catch(Exception e){
				 System.out.println("record "+ record);
				 Atten_Req_Message="Faild to submit your request/try again(OR)contact system admin  ";
				e.printStackTrace();
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	 }
	 //**************************************************************************************
	 try {
	     
	   if(Res!=null){
		    Res.close();
		}
	 /*if(con!=null){
		con.close();
  }*/
	 
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
   }else{
	   Atten_Req_Message="Invalid Password/User id";
	   
	   
	   
	   try {
			ConnectionpoolFilter.close(con, Res,"ReqAcpt_Resi",true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
      long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
	    logger.info("Login servlet Main  execution time in Seconds ::"+ sec);
	    request.setAttribute("Excecutiontime", sec +" Sec");
	   
	   
	   
   }
       out.write(""+Atten_Req_Message+"");	
	}
// ===================================================================
}
//}Faild your request please try again with valid data/contact system admin
