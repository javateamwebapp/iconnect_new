package iconnect.hhcl.EmpEdit;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.ibm.icu.text.ChineseDateFormat.Field;
import com.mysql.jdbc.Statement;

import iconnect.hhcl.db.ConnectionpoolFilter;
import iconnect.hhcl.db.GetDbData;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class fileupload
 */
public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public fileupload() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("/* ========================upload files========================================== */");

		JSONObject jason = new JSONObject();
		String GetRouting = request.getParameter("Routing");
		ResultSet Res = null;
		System.out.println(GetRouting);
		// ServletContext c = getServletContext();
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		Statement statement = null;
		GetDbData DataObj = new GetDbData();
		String SUCCESS_PAGE = null;

		@SuppressWarnings("rawtypes")
		Map userdata = new HashMap();
		String pannumber = " ", ifccode = " ", accnumber = " ", bankname = " ", pan = " ", bank = " ", passportno = " ",
				drivinglnc1 = " ", aadharname = "", drivinglnc = "", passfile = "", aadharno = " ", aadhar = " ",
				aaname = " ", passport = " ";

		// java.sql.ResultSet Res = null;
		// DataSource dataSource=null;
		java.sql.Connection conn = null;
		java.sql.PreparedStatement ps = null;

		/*
		 * try { // conn =dataSource.getConnection(); conn = (java.sql.Connection)
		 * session.getAttribute("ConnectionObj"); } catch (Exception e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */
		final Logger logger = Logger.getLogger(fileupload.class);
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
		int RejStaurs = 0;
		String fl1 = "", fl2 = "", fl3 = "", fl4 = "", fl5 = "", fl6 = "", fl7 = "", fl8 = "", fl9 = "", fl10 = "",
				fl11 = "", fl12 = "", fl13 = "", fl14 = "", fl15 = "", fl16 = "", fl17 = "", fl18 = "", fl19 = "",
				fl20 = "", fl21 = "", fl22 = "", fl23 = "", fl24 = "", fl25 = "", fl26 = "", fl27 = "", fl28 = "",
				fl29 = "", fl30 = "", fl31 = "", fl32 = "";
		String empId = "", email = "", mobilenumber = "", proffimobile = "", dateofbirth = "", aadharname1 = "",
				aadharnumber = "", pannumber1 = "", passportnumber = "", Drivinglic = "", bankname1 = "",
				accountno = "", ifcscode = "", comcountry = "", comstate = "", comcity = "", commadrass1 = "",
				comadrass2 = "", commaddrass3 = "", comadrass4 = "", compin = "", percountry = "", perState = "",
				percity = "", peraddrass1 = "", peraddrass2 = "", peraddrass3 = "", peraddrass4 = "", perpin = "";

		/*
		 * EmpID, NAME, DATEOFBIRTH, BANKNAME, IFSC, ACCOUNTNO, AADHAARCARDNO,
		 * AADHAARNAME, DRIVINGLICENSENO, PASSPORTNO, pan, personal_email,
		 * personal_phone, professional_phone, perm_addr1, PERMANENTADDRESS2,
		 * PERMANENTADDRESS3, PERMANENTADDRESS4, perm_pincode, comm_addr1,
		 * COMMUNICATIONADDRESS2, COMMUNICATIONADDRESS3, COMMUNICATIONADDRESS4,
		 * comm_pincode,COMCITY, COMMSTATE, PCITY, PSTATE
		 */

		String user_id = (String) session.getAttribute("EMP_ID");

		try {

			StringBuffer query13453453 = new StringBuffer();

			query13453453.append("  select\r\n" + "B.employeesequenceno'EmpID',\r\n"
					+ "concat(tit.name,' ',B.CALLNAME)'NAME',\r\n" + "b.DATEOFBIRTH,\r\n"
					+ "ifnull(banks.BANKNAME,'--')'BANKNAME',\r\n" + "ifnull(ifc.bankifc,'--')'IFSC',\r\n"
					+ "ifnull(other.ACCOUNTNO,'--')'ACCOUNTNO',\r\n" + "per.AADHAARCARDNO 'AADHAARCARDNO',\r\n"
					+ "per.AADHAARNAME 'AADHAARNAME',\r\n" + "per.DRIVINGLICENSENO 'DRIVINGLICENSENO',\r\n"
					+ "per.PASSPORTNO 'PASSPORTNO',\r\n" + "per.pan 'pan',\r\n" + "ps.email 'personal_email',\r\n"
					+ "ps.phone 'personal_phone',\r\n" + "prof.phone 'professional_phone',\r\n"
					+ "ps.PERMANENTADDRESS 'perm_addr1', ps.PERMANENTADDRESS2, ps.PERMANENTADDRESS3,ps.PERMANENTADDRESS4,ps.PERMANENTZIP 'perm_pincode',\r\n"
					+ "ps.COMMUNICATIONADDRESS 'comm_addr1', ps.COMMUNICATIONADDRESS2,ps.COMMUNICATIONADDRESS3, ps.COMMUNICATIONADDRESS4,\r\n"
					+ "ps.COMMUNICATIONZIP 'comm_pincode',IFNULL(COMMLOC.NAME,'') COMCITY,IFNULL(COMMSTATELOC.NAME,'')COMMSTATE,\r\n"
					+ "IFNULL(PLOC.NAME,'') PCITY, IFNULL(PSLOC.NAME,'')PSTATE\r\n" + "\r\n" + "\r\n"
					+ "from hclhrm_prod.tbl_employee_primary B\r\n"
					+ "left join hclhrm_prod.tbl_employee_other_detail other on other.employeeid=b.employeeid\r\n"
					+ "left join hcladm_prod.tbl_bank_details banks on banks.bankid=other.bankid\r\n"
					+ "left join hclhrm_prod_others.tbl_emp_bank_ifc ifc on ifc.empid=b.employeeid\r\n"
					+ "left join hcladm_prod.tbl_title tit on tit.title=b.title\r\n"
					+ "left join hclhrm_prod.tbl_employee_personalinfo per on per.employeeid=b.employeeid\r\n"
					+ "left join hclhrm_prod.tbl_employee_professional_contact prof on prof.employeeid=b.employeeid\r\n"
					+ "left join hclhrm_prod.tbl_employee_personal_contact ps on ps.employeeid=b.employeeid\r\n"
					+ "LEFT JOIN hclhrm_prod.tbl_employee_personal_contact D 	ON b.EMPLOYEEID=D.EMPLOYEEID\r\n"
					+ "LEFT JOIN HCLLCM_PROD.TBL_LOCATION COMMLOC ON D.COMMUNICATIONLOCATIONID=COMMLOC.LOCATIONID\r\n"
					+ "LEFT JOIN HCLLCM_PROD.TBL_LOCATION COMMSTATELOC ON COMMLOC.PARENT=COMMSTATELOC.LOCATIONID\r\n"
					+ "LEFT JOIN HCLLCM_PROD.TBL_LOCATION PLOC 	ON D.PERMANENTLOCATIONID=PLOC.LOCATIONID\r\n"
					+ "LEFT JOIN HCLLCM_PROD.TBL_LOCATION PSLOC ON PLOC.PARENT=PSLOC.LOCATIONID\r\n" + "\r\n"
					+ "where b.status=1001 and b.employeesequenceno=" + user_id + "; ");

			System.out.println(query13453453);

			Res = (ResultSet) DataObj.FetchData(query13453453.toString(), "Req_Adj", Res, conn);

			if (Res.next()) {

				fl1 = Res.getString(1);// EmpID
				fl2 = Res.getString(2);// NAME
				fl3 = Res.getString(3);// DATEOFBIRTH
				fl4 = Res.getString(4);// BANKNAME
				fl5 = Res.getString(5);// IFSC
				fl6 = Res.getString(6);// ACCOUNTNO
				fl7 = Res.getString(7);// AADHAARCARDNO
				fl29 = Res.getString(8);// aadhar name

				fl8 = Res.getString(9);// DRIVINGLICENSENO
				fl9 = Res.getString(10);// PASSPORTNO
				fl10 = Res.getString(11);// pan
				fl11 = Res.getString(12);// personal_email
				fl12 = Res.getString(13);// personal_phone
				fl13 = Res.getString(14);// professional_phone
				fl14 = Res.getString(15);// perm_addr1
				fl16 = Res.getString(16);// PERMANENTADDRESS2
				fl17 = Res.getString(17);// PERMANENTADDRESS3
				fl18 = Res.getString(18);// PERMANENTADDRESS4
				fl19 = Res.getString(19);// perm_pincode
				fl20 = Res.getString(20);// comm_addr1
				fl21 = Res.getString(21);// COMMUNICATIONADDRESS2
				fl22 = Res.getString(22);// COMMUNICATIONADDRESS3
				fl23 = Res.getString(23);// COMMUNICATIONADDRESS4
				fl24 = Res.getString(24);// comm_pincode
				fl25 = Res.getString(25);// COMCITY
				fl26 = Res.getString(26);// COMMSTATE
				fl27 = Res.getString(27);// PCITY
				fl28 = Res.getString(28);// PSTATE

				System.out.println("the db data f1::" + fl1 + "\n" + fl2 + "\n" + fl3 + "f4" + fl4 + "f5" + fl5);

			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();

		}

		String filePathDirectory = "";

		String Field = "";
		String directoryName = "";
		directoryName = "C://uploads//" + user_id + "//";
		System.out.println("the file directory name is:" + directoryName);
		filePathDirectory = directoryName;

		System.out.println("the directory name is:" + filePathDirectory);

		File directory = new File(directoryName);
		if (!directory.exists()) {
			System.out.println("/.. folder does not exits  directoryName...////  " + directoryName);
			directory.mkdirs();
		} else {
			System.out.println(directoryName + " folder exits in............. " + directory);
		}

		String pannum = request.getParameter("pan");
		System.out.println("the pan muner is::" + pannum);

		// personal
		String NAME = "", DATEOFBIRTH = "", personal_email = "", personal_phone = "", professional_phone = "",
				// bank
				BANKNAME = "", IFSC = "", ACCOUNTNO = "",
				// aadhar
				AADHAARCARDNO = "", AADHAARNAME = "", DRIVINGLICENSENO = "", PASSPORTNO = "", pan1 = "",
				// per
				perm_addr1 = "", PERMANENTADDRESS2 = "", PERMANENTADDRESS3 = "", PERMANENTADDRESS4 = "", pcountry = "",
				PCITY = "", PSTATE = "", perm_pincode = "",
				// com
				comm_addr1 = "", COMMUNICATIONADDRESS2 = "", COMMUNICATIONADDRESS3 = "", COMMUNICATIONADDRESS4 = "",
				ccountry = "", comm_pincode = "", COMCITY = "", COMMSTATE = "";

		// String ename= parseRequest(request);
		/*
		 * the Names are ols :email the values are ols :venu9394@gmail.com the Names are
		 * ols :phone the values are ols :6756767675 the Names are ols :promobile the
		 * values are ols :4040473939 the Names are ols :bday the values are ols
		 * :1984-06-01 the Names are ols :aadharname the values are ols :hjgjghjghj the
		 * Names are ols :adhar the values are ols :329929245274 the file upload adharf
		 * the Names are ols :pan the values are ols :AOVPG6693N the file upload panf
		 * the Names are ols :passport the values are ols :567567676 the Names are ols
		 * :drivinglnc the values are ols :5675675675 the Names are ols :bankName1 the
		 * values are ols :AXIS the Names are ols :accno the values are ols
		 * :917010049532261 the Names are ols :ifccodenum the values are ols
		 * :UTIB0000008 the file upload bankf the pshgh ::AOVPG6693N
		 */

		if (ServletFileUpload.isMultipartContent(request)) {
			try {

				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				System.out.println("the multipartdata:" + multiparts);

				Iterator<FileItem> itr = multiparts.iterator();
				while (itr.hasNext()) {
					FileItem item1 = (FileItem) itr.next();

					if (!item1.isFormField()) {
						// System.out.println("obulesu......................."+directoryName);
						Field = item1.getFieldName();

						System.out.println("the file upload " + Field);

						String name = new File(item1.getName()).getName();
						boolean exists = name.isEmpty();

						System.out.println("the multipar true or false is:::" + exists);

						System.out.println("form fields......................." + Field);
						item1.write(new File(directoryName + File.separator + name));
						if (Field.equalsIgnoreCase("adharf")) {

							System.out.println("form fields......................." + name);
							aadhar = filePathDirectory.concat(name);

						}
						if (Field.equalsIgnoreCase("panf")) {

							pan = filePathDirectory.concat(name);

						}
						if (Field.equalsIgnoreCase("bankf")) {

							bank = filePathDirectory.concat(name);

						}
						if (Field.equalsIgnoreCase("passport")) {
							passfile = filePathDirectory.concat(name);
						}

					}

					if (item1.isFormField()) {
						String unames = item1.getString();
						Field = item1.getFieldName();
						System.out.println("the Names are ols :" + Field);
						System.out.println("the values are ols :" + unames);

						if (Field.equalsIgnoreCase("email")) {
							personal_email = unames;
						} else if (Field.equalsIgnoreCase("phone123")) {
							personal_phone = unames;
						} else if (Field.equalsIgnoreCase("promobile")) {
							professional_phone = unames;
						} else if (Field.equalsIgnoreCase("bday")) {
							DATEOFBIRTH = unames;
						} else if (Field.equalsIgnoreCase("pan")) {
							pan1 = unames;
						} else if (Field.equalsIgnoreCase("adhar")) {
							AADHAARCARDNO = unames;

						} else if (Field.equalsIgnoreCase("aadharname")) {
							AADHAARNAME = unames;
						} else if (Field.equalsIgnoreCase("passport")) {
							PASSPORTNO = unames;
						} else if (Field.equalsIgnoreCase("drivinglnc")) {
							DRIVINGLICENSENO = unames;
						}

						else if (Field.equalsIgnoreCase("bankName1")) {
							BANKNAME = unames;
						} else if (Field.equalsIgnoreCase("accno")) {
							ACCOUNTNO = unames;
						} else if (Field.equalsIgnoreCase("ifccodenum")) {
							IFSC = unames;
						} else if (Field.equalsIgnoreCase("country")) {
							ccountry = unames;
						} else if (Field.equalsIgnoreCase("State")) {
							COMMSTATE = unames;
						} else if (Field.equalsIgnoreCase("city")) {
							COMCITY = unames;
						} else if (Field.equalsIgnoreCase("address1")) {
							comm_addr1 = unames;
						} else if (Field.equalsIgnoreCase("address2")) {
							COMMUNICATIONADDRESS2 = unames;
						} else if (Field.equalsIgnoreCase("address3")) {
							COMMUNICATIONADDRESS3 = unames;
						} else if (Field.equalsIgnoreCase("address4")) {
							COMMUNICATIONADDRESS4 = unames;
						} else if (Field.equalsIgnoreCase("pincode")) {
							comm_pincode = unames;
						} else if (Field.equalsIgnoreCase("countryper")) {
							pcountry = unames;
						} else if (Field.equalsIgnoreCase("stateper")) {
							PSTATE = unames;
						} else if (Field.equalsIgnoreCase("cityper")) {
							PCITY = unames;
						} else if (Field.equalsIgnoreCase("aadharper")) {
							perm_addr1 = unames;
						} else if (Field.equalsIgnoreCase("aadharper1")) {
							PERMANENTADDRESS2 = unames;
						} else if (Field.equalsIgnoreCase("aadharper2")) {
							PERMANENTADDRESS3 = unames;
						} else if (Field.equalsIgnoreCase("aadharper3")) {
							PERMANENTADDRESS4 = unames;
						} else if (Field.equalsIgnoreCase("ppincode")) {
							perm_pincode = unames;
						}

					}

				} // for loop
			}

			catch (Exception e) {

			}

		}

//dofb
		if (DATEOFBIRTH.equalsIgnoreCase(fl3) || DATEOFBIRTH.isEmpty()) {
			dateofbirth = " ";
		} else {
			dateofbirth = DATEOFBIRTH;
		}

//personal email			
		if (personal_email.equalsIgnoreCase(fl11) || personal_email.isEmpty()) {
			email = " ";
		} else {
			email = personal_email;
		}

//personal phone			
		if (personal_phone.equalsIgnoreCase(fl12) || personal_phone.isEmpty()) {
			mobilenumber = " ";
		} else {
			mobilenumber = personal_phone;
		}

//proffi phone 		

		if (professional_phone.equalsIgnoreCase(fl13) || professional_phone.isEmpty()) {
			proffimobile = " ";
		} else {
			proffimobile = professional_phone;
		}
//	pan		

		if (pan1.equalsIgnoreCase(fl10) || pan1.isEmpty()) {
			pannumber1 = " ";
		} else {
			pannumber1 = pan1;
		}
//aadhar name

		if (AADHAARNAME.equalsIgnoreCase(fl29) || AADHAARNAME.isEmpty()) {
			aadharname1 = " ";
		} else {
			aadharname1 = AADHAARNAME;
		}

//	aadhar number	
		if (AADHAARCARDNO.equalsIgnoreCase(fl7) || AADHAARCARDNO.isEmpty()) {
			aadharnumber = " ";
		} else {
			aadharnumber = AADHAARCARDNO;
		}
//PASSPORTNO
		if (PASSPORTNO.equalsIgnoreCase(fl9) || PASSPORTNO.isEmpty()) {
			passportnumber = " ";
		} else {
			passportnumber = PASSPORTNO;
		}
//	DRIVINGLICENSENO		
		if (DRIVINGLICENSENO.equalsIgnoreCase(fl8) || DRIVINGLICENSENO.isEmpty()) {
			Drivinglic = " ";
		} else {
			Drivinglic = DRIVINGLICENSENO;
		}
//bank name
		if (BANKNAME.equalsIgnoreCase(fl4) || BANKNAME.isEmpty()) {
			bankname1 = " ";
		} else {
			bankname1 = BANKNAME;
		}

//ACCOUNTNO
		if (ACCOUNTNO.equalsIgnoreCase(fl6) || ACCOUNTNO.isEmpty()) {
			accountno = " ";
		} else {
			accountno = ACCOUNTNO;
		}

		// IFSC

		if (IFSC.equalsIgnoreCase(fl5) || IFSC.isEmpty()) {
			ifcscode = " ";
		} else {
			ifcscode = IFSC;
		}

		// ccountry
		if (ccountry.equalsIgnoreCase(fl2) || ccountry.isEmpty()) {
			comcountry = " ";
		} else {
			comcountry = ccountry;

			// COMMSTATE
		}
		if (COMMSTATE.equalsIgnoreCase(fl26) || COMMSTATE.isEmpty()) {

			comstate = " ";
		} else {
			comstate = COMMSTATE;

			// COMCITY
		}
		if (COMCITY.equalsIgnoreCase(fl25) || COMCITY.isEmpty()) {

			comcity = " ";
		} else {
			comcity = COMCITY;
		}

		// comm_addr1
		if (comm_addr1.equalsIgnoreCase(fl20) || comm_addr1.isEmpty()) {
			commadrass1 = " ";
		} else {
			commadrass1 = comm_addr1;
		}

		// comm2
		if (COMMUNICATIONADDRESS2.equalsIgnoreCase(fl21) || COMMUNICATIONADDRESS2.isEmpty()) {
			comadrass2 = " ";
		} else {
			comadrass2 = COMMUNICATIONADDRESS2;
		}

		// comm3

		if (COMMUNICATIONADDRESS3.equalsIgnoreCase(fl22) || COMMUNICATIONADDRESS3.isEmpty()) {
			commaddrass3 = " ";
		} else {
			commaddrass3 = COMMUNICATIONADDRESS3;
		}
		// comu4

		if (COMMUNICATIONADDRESS4.equalsIgnoreCase(fl23) || COMMUNICATIONADDRESS4.isEmpty()) {
			comadrass4 = " ";
		} else {
			comadrass4 = COMMUNICATIONADDRESS4;
		}
		// cpin number
		if (comm_pincode.equalsIgnoreCase(fl24) || comm_pincode.isEmpty()) {
			compin = " ";
		} else {
			compin = comm_pincode;
		}

		// pecountry1
		if (pcountry.equalsIgnoreCase(fl5) || pcountry.isEmpty()) {
			percountry = " ";
		} else {
			percountry = pcountry;
		}
		// per State
		if (PSTATE.equalsIgnoreCase(fl28) || PSTATE.isEmpty()) {
			perState = " ";
		} else {
			perState = PSTATE;
		}
		// per city
		if (PCITY.equalsIgnoreCase(fl27) || PCITY.isEmpty()) {
			percity = " ";
		} else {
			percity = PCITY;
		}

		// peraddr 1

		if (perm_addr1.equalsIgnoreCase(fl14) || perm_addr1.isEmpty()) {
			peraddrass1 = " ";
		} else {
			peraddrass1 = perm_addr1;
		}
		// per add 2

		if (PERMANENTADDRESS2.equalsIgnoreCase(fl16) || PERMANENTADDRESS2.isEmpty()) {
			peraddrass2 = " ";
		} else {
			peraddrass2 = PERMANENTADDRESS2;
		}
		// per addr 3

		if (PERMANENTADDRESS3.equalsIgnoreCase(fl17) || PERMANENTADDRESS3.isEmpty()) {
			peraddrass3 = " ";
		} else {
			peraddrass3 = PERMANENTADDRESS3;
		}
		// per addr 4
		if (PERMANENTADDRESS4.equalsIgnoreCase(fl18) || PERMANENTADDRESS4.isEmpty()) {
			peraddrass4 = " ";
		} else {
			peraddrass4 = PERMANENTADDRESS4;
		}
		// peradd pin

		if (perm_pincode.equalsIgnoreCase(fl19) || perm_pincode.isEmpty()) {
			perpin = " ";
		} else {
			perpin = perm_pincode;
		}

		System.out.println("the pshgh ::" + pan1);
		/*
		 * slno,passportno aadharName, aadharnumber, pannumber, passportnumber,
		 * aadharfile, panfile, passport, dateofmodification, Status, Empid,
		 * DrivingLicenseno
		 * 
		 */

		System.out.println("the new values are::" + empId + " " + email + mobilenumber + "" + proffimobile + ""
				+ dateofbirth + "" + aadharname1 + "" + aadharnumber + "" + pannumber1 + "" + passportnumber + ""
				+ Drivinglic + "" + bankname1 + "" + accountno + "" + ifcscode + "" + comcountry + "" + comstate + ""
				+ comcity + "" + commadrass1 + "" + comadrass2 + "" + commaddrass3 + "" + comadrass4 + "" + compin + ""
				+ percountry + "" + percity + "" + peraddrass1 + "" + peraddrass2 + "" + peraddrass3 + "" + peraddrass4
				+ "" + perpin);

		System.out.println("aadhar file::" + aadhar);

		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		// SimpleDateFormat

		// LocalDateTime now = LocalDateTime.now();
		// String dat2=dtf.format(now);
		StringBuffer query = new StringBuffer();
		query.append(" insert into emp_edit_details.emp_list_table(EmpID,Personalmobile,Professionalmobile, ");
		query.append(
				"Dateofbirth,  personal_email1, PermanentAddress,PermanentAddress2,PermanentAddress3,PermanentAddress4,country,"
						+ "state,city,pin,CommunicationAddress,communication2,communication3,communication4,ccountry,Cstate,"
						+ "Ccity,Cpin,BankName,AccountNo,IfcsCode,BankFile,aadharName,aadharnumber,pannumber,passportnumber,"
						+ "DrivingLicenseno,aadharfile,panfile,passportfile )   values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
						+ ",?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,?,? ); ");
		System.out.println(query);
		try {
			ps = conn.prepareStatement(query.toString());

			ps.setString(1, user_id);
			ps.setString(2, mobilenumber);
			ps.setString(3, proffimobile);
			ps.setString(4, dateofbirth);
			ps.setString(5, email);

			ps.setString(6, peraddrass1);
			ps.setString(7, peraddrass2);
			ps.setString(8, peraddrass3);
			ps.setString(9, peraddrass4);
			ps.setString(10, percountry);
			ps.setString(11, perState);
			ps.setString(12, percity);
			ps.setString(13, perpin);

			ps.setString(14, commadrass1);
			ps.setString(15, comadrass2);
			ps.setString(16, commaddrass3);
			ps.setString(17, comadrass4);
			ps.setString(18, comcountry);
			ps.setString(19, comstate);
			ps.setString(20, comcity);
			ps.setString(21, compin);

			ps.setString(22, bankname1);
			ps.setString(23, accountno);
			ps.setString(24, ifcscode);
			ps.setString(25, bank);

			ps.setString(26, aadharname1);
			ps.setString(27, aadharnumber);
			ps.setString(28, pannumber1);
			ps.setString(29, passportnumber);
			ps.setString(30, Drivinglic);
			ps.setString(31, aadhar);
			ps.setString(32, pan);
			ps.setString(33, passfile);
			// ps.setString(34,dat2);

			// DATEOFBIRTH

			System.out.println("the ps ::" + ps);

			int res = ps.executeUpdate();

			if (res >= 0) {
				System.out.println("the successfully inserted");

				/*
				 * String emailBody =null; String emp_professional_mail =null; String
				 * emp_personal_mail =null; String hr_prof_mail =null; String hod_mail=null;
				 * StringBuffer htmlboddy=new StringBuffer(); String
				 * FromEmail="obulesu.pullirapu@heterohealthcare.com"; String toEmail=
				 * "pullirapuobulesu111@gmail.com" ;
				 * 
				 * String EmailPassword="*************";
				 * 
				 * 
				 * Properties properties = new Properties(); properties.put("mail.smtp.host",
				 * "smtp.gmail.com"); properties.put("mail.smtp.host",
				 * "czismtp.logix.in");//czismtp.logix.in
				 * properties.put("mail.smtp.socketFactory.port", "465");
				 * properties.put("mail.smtp.socketFactory.class",
				 * "javax.net.ssl.SSLSocketFactory"); properties.put("mail.smtp.auth", "true");
				 * properties.put("mail.smtp.port", "465"); properties.put("mail.smtp.port",
				 * "587");
				 * 
				 * 
				 * final String frommail = properties.getProperty(FromEmail); final String Epas
				 * = properties.getProperty(EmailPassword);
				 * 
				 * Session session1 = Session.getDefaultInstance(properties , new
				 * javax.mail.Authenticator(){ protected PasswordAuthentication
				 * getPasswordAuthentication() { return new
				 * PasswordAuthentication(frommail,Epas); }
				 * 
				 * });
				 * 
				 * MimeMessage message = new MimeMessage(session1);
				 * System.out.println("hellooo  ..."); try { message.setFrom(new
				 * InternetAddress(frommail)); } catch (AddressException e3) { // TODO
				 * Auto-generated catch block e3.printStackTrace(); } catch (MessagingException
				 * e3) { // TODO Auto-generated catch block e3.printStackTrace(); } //
				 * InternetAddress.parse try { message.setSubject("Feedback Form"); } catch
				 * (MessagingException e2) { // TODO Auto-generated catch block
				 * e2.printStackTrace(); }
				 * 
				 * htmlboddy.append(" <!DOCTYPE html>    "); htmlboddy.append(" <html>   ");
				 * htmlboddy.append(" <head>   ");
				 * htmlboddy.append(" <title>Feedback Form</title> ");
				 * htmlboddy.append(" </head>   "); htmlboddy.append(" <body>   ");
				 * 
				 * //************************************ // //
				 * htmlboddy.append(" <span> Dear  Mr  " +CALLNAME +"   , </span>");
				 * 
				 * htmlboddy.
				 * append(" <div font-size: 11px;  style='font-style:Regular'>  Mr / Ms "
				 * +user_id+"  , </div>"); htmlboddy.append("  <br/> ");
				 * htmlboddy.append("  <br/> "); htmlboddy.
				 * append(" <div style='font-family: Regular, sans-serif;'> This mail is regarding on feedback form  </div> "
				 * ); htmlboddy.append("  <br/> "); htmlboddy.append("  <br/> "); htmlboddy.
				 * append(" <div> <a href='http://172.19.1.50:8080/heterodesk/feedback?userid="
				 * +user_id+"' >IConnect</a></div> ");
				 * htmlboddy.append(" <div> Regards, </div> ");
				 * htmlboddy.append(" <div> Hetero HealthCare & Azista industries.</div> ");
				 * 
				 * 
				 * emailBody = htmlboddy.toString();
				 * message.setRecipients(Message.RecipientType.TO,
				 * InternetAddress.parse(toEmail)); // toEmail , message.setRecipients(
				 * Message.RecipientType.BCC,InternetAddress.parse(emp_professional_mail));
				 * message.setRecipients( Message.RecipientType.BCC,InternetAddress.parse(
				 * "haritha.vendipalli26@gmail.com"));// insert EmailId variable
				 * message.setContent(emailBody,"text/html" );
				 * System.out.println("hellooo  ..."); Transport.send(message);
				 * 
				 * emailBody = htmlboddy.toString(); try {
				 * message.setRecipients(Message.RecipientType.TO,
				 * InternetAddress.parse(toEmail)); message.setRecipients(
				 * Message.RecipientType.CC,InternetAddress.parse(emp_professional_mail));
				 * message.setRecipients(
				 * Message.RecipientType.BCC,InternetAddress.parse(""));// insert EmailId
				 * variable message.setContent(emailBody,"text/html" );
				 * 
				 * } catch (AddressException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); } catch (MessagingException e1) { // TODO
				 * Auto-generated catch block e1.printStackTrace(); } // toEmail ,
				 * 
				 */
					int ols111=1004;
				StringBuffer query1 = new StringBuffer();
				StringBuffer que = new StringBuffer();
				StringBuffer query131 = new StringBuffer();

				que.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"
						+ user_id + "' and Status_rej=1002;");

				System.out.println(que);
				try {

					Res = (ResultSet) DataObj.FetchData(que.toString(), "Req_Adj", Res, conn);
					if (Res.next()) {

						RejStaurs = Res.getInt(1);

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("the obulesu Id is::" + RejStaurs);
				if (RejStaurs == 1) {

					StringBuffer query11 = new StringBuffer();
					query11.append(" update emp_edit_details.emp_hr_accept_table set Status_rej='"+ols111+"' where empId='"
							+ user_id + "' and Status_rej=1002; ");

					ps = conn.prepareStatement(query11.toString());

					int res11 = ps.executeUpdate();
					System.out.println("the successfully inserted rejected Status Ols obulesu::" + res11);

				}

				
				
				
				
				
				
				query131.append("select count(EmpId) from emp_edit_details.emp_hr_accept_table   where empId='"
						+ user_id + "' and Status=1001;");

				System.out.println(query131);
				try {

					Res = (ResultSet) DataObj.FetchData(query131.toString(), "Req_Adj", Res, conn);
					if (Res.next()) {

						RejStaurs = Res.getInt(1);

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("the obulesu Id is::" + RejStaurs);
				if (RejStaurs == 1) {

					StringBuffer query11 = new StringBuffer();
					query11.append(" update emp_edit_details.emp_hr_accept_table set Status=1004 where empId='"
							+ user_id + "' and Status=1001; ");

					ps = conn.prepareStatement(query11.toString());

					int res11 = ps.executeUpdate();
					System.out.println("the successfully inserted Ols obulesu::" + res11);

				}

				StringBuffer query11 = new StringBuffer();
				query11.append(" insert into emp_edit_details.emp_accept_table(EmpID ) values(?); ");

				ps = conn.prepareStatement(query11.toString());

				ps.setString(1, user_id);
				// ps.setString(2,dat2);
				int res11 = ps.executeUpdate();
				// System.out.println("the successfully inserted Ols obulesu::"+res1);

				// emp_edit_details.emp_accept_table

			} else {
				System.out.println("something error in code ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SUCCESS_PAGE=bundle_info.getString("HHCL_DESK_DIVERT_1");
		String GetRouting1 = "adharandpanfile";
		jason.put("GetRouting", GetRouting1);
		System.out.println("the json response form bank for file uploads" + jason);
		out.write(jason.toString());
		String succ = "succefully submitted";
		request.setAttribute("successefull", succ);
		// ((HttpServletResponse) request).sendRedirect(request.getRequestURI());

		// request.getRequestDispatcher(SUCCESS_PAGE).forward(request, response);

		// request.getRequestDispatcher("/hhcl_profile.jsp").forward(request, response);
		// response.sendRedirect("hhcl_edit_profile.jsp");
		response.sendRedirect(request.getHeader("Referer"));

		try {
			if (statement != null) {
				statement.close();
			}
			if (Res != null) {
				Res.close();
			}
			/*
			 * if(conn!=null){ conn.close(); }
			 */
			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		try {
			ConnectionpoolFilter.close(conn, Res,"fileupload",true);
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
