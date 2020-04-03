package iconnect.hhcl.EmpEdit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.simple.JSONObject;





/**
 * Servlet implementation class EditProfile_HRLinksServlet
 */
public class EditProfile_HRLinksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditProfile_HRLinksServlet() {
        super();
    
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		PreparedStatement	stmt1=null;
		HttpSession session = request.getSession(false);
		String Routing=request.getParameter("Routing");
		String	user12_id=(String)session.getAttribute("EMP_ID");
		String Routing_page="login.html";
		Map otherLinks=new HashMap();
		JSONObject jason = new JSONObject();
		
		
		System.out.println("the user authenicatuion for link show and enable :::");
		
		/*
		 * if(Routing!=null && Routing.equalsIgnoreCase("EditProfileDisplay")){ try{
		 * 
		 * Context initContext = new InitialContext(); Context envContext = (Context)
		 * initContext.lookup("java:comp/env"); ServletContext c = getServletContext();
		 * DataSource ds = (DataSource) envContext.lookup("jdbc/HHCL_DESK"); conn =
		 * ds.getConnection();
		 * 
		 * StringBuffer query= new StringBuffer(); query.
		 * append(" SELECT Status , slno  FROM emp_edit_details.emp_list_table ;  ");
		 * 
		 * stmt1=conn.prepareStatement(query.toString()); ResultSet
		 * rs=stmt1.executeQuery();
		 * 
		 * if(rs.next()){
		 * 
		 * 
		 * 
		 * if((rs.getString("Status")).equalsIgnoreCase("1005") &&
		 * (user_id.equalsIgnoreCase("20314") || user_id.equalsIgnoreCase("10452"))){
		 * System.out.println( "in enable links"); otherLinks.put("Approvalslink", " ");
		 * } else if(!(rs.getString("Status")).equalsIgnoreCase("1005")){
		 * System.out.println( "in disable links"); otherLinks.put("Approvalslink",
		 * "none"); } } session.setAttribute("EDITPROFILELINKS",otherLinks);
		 * }catch(Exception ex){ ex.printStackTrace(); } }
		 */
			
			 if(Routing!=null && Routing.equalsIgnoreCase("EditProfileDisplay")){
				 
				 
				 
				 
					Routing_page="Hhcl_Emp_Update_By_Hr.jsp";
				}
			 
			 jason.put("CodeIDdis",user12_id);
				request.getRequestDispatcher(Routing_page).forward(request, response);
}


}
