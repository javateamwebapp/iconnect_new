<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!doctype HTML>
<html class="fixed">
	<head>
	
	 <% 
 
  
  String Emp_DATA=(String)request.getAttribute("EDIT_DATA_1");
  
	 System.out.println(" Edit Data at JSP::" +Emp_DATA);
  
 
  String EMP_NAME=(String)session.getAttribute("EMP_NAME");
 
 
  
%>

		<!-- Basic -->
		<meta charset="UTF-8">

		
		<meta name="keywords" content="HETERO" />
		<meta name="description" content="Hetero">
		<meta name="author" content="Hetero">

         <title>Hetero Healthcare LTD</title>
          <link rel="icon" href="LOH.png" />
          
		<!-- Mobile Metas -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />


		<!-- Web Fonts  -->
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css">

		<!-- Vendor CSS -->
		<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="assets/vendor/magnific-popup/magnific-popup.css" />
	
<!-- <link rel="stylesheet" href="assets/stylesheets/GScroll.css" /> -->
		<link rel="shortcut icon" href="/images.png" type="image/x-icon" />

		<!-- Specific Page Vendor CSS -->
		<link rel="stylesheet" href="assets/vendor/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />
		

		<!-- Theme CSS -->
		<link rel="stylesheet" href="assets/stylesheets/theme.css" />

		<!-- Skin CSS -->
		<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />
	
		<!-- Theme Custom CSS -->
		<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">
			<!-- <script src="assets/vendor/jquery/jquery.js"></script> -->
			<!--  <link rel="stylesheet" href="colorbox.css" /> -->
	<!-- <script src="jquery.colorbox.js"></script>  -->
	

<!-- 	 <script src="assets/vendor/nanoscroller/nanoscroller.js"></script>  -->
<!-- 	<link rel="stylesheet" href="assets/vendor/nanoscroller/nanoscroller.css"> -->
		
	<!--  <script src="assets/javascripts/jquery-1.8.3.js"></script> 
	<script src="assets/javascripts/GScroll.js"></script> -->
	
	 
      
        
		<!-- Head Libs -->
		<!-- <script src="assets/vendor/modernizr/modernizr.js"></script>
		<link rel="stylesheet" type="text/css" href="css3clock.css" /> -->

<!-- <link href="scroll/perfect-scrollbar.css" rel="stylesheet">
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
      <script src="scroll/jquery.mousewheel.js"></script>
      <script src="scroll/perfect-scrollbar.js"></script> -->
      
 <!--  <link rel="stylesheet" href="css/icon-font.min.css" type='text/css' /> -->
<!-- <link rel="stylesheet" href="css/jqueryui.css" type='text/css' /> -->
<!-- <link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.css">
 --><link rel="stylesheet" href="assets/stylesheets/style.css" />
   <script src="jquery-ui-1.12.1.custom/jquery-1.12.4.js"></script>
   <script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script> 
  <style>
  .modal {
}
.vertical-alignment-helper {
    display:table;
    height: 100%;
    width: 100%;
}
.vertical-align-center {
    /* To center vertically */
    display: table-cell;
    vertical-align: middle;
}
.modal-content {
    /* Bootstrap sets the size of the modal in the modal-dialog class, we need to inherit it */
    width:inherit;
    height:inherit;
    /* To center horizontally */
    margin: 0 auto;
}
select {
    border: 1px solid #E5E7E9;
    border-radius: 6px;
   height:30px;
    padding: 6px;
    outline: none;
}
  
  </style>
  <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

<%-- <script>
var app = angular.module('myApp', []);
app.controller('formCtrl', function($scope) {
	$scope.Data="";
	
	
	try{
		
   
		 $scope.Data_1=<%=Emp_DATA%>;
		 System.out.println(" Edit Data at JSP::" +Data_1);
		
 
	}catch(err){
		alert(err.message);
	}
  
 });
 
 
</script>
 --%>

<!-- <script>
var app = angular.module("myApp", []);
app.controller("myCtrl", function($scope) {
  $scope.records = Emp_DATA
});
onload="noBack();" onpageshow="if (event.persisted) noBack();" ng-app="myApp" ng-controller="formCtrl"
</script> -->

 





	</head>
	
	<body   >
		<section class="body">

			<!-- start: header onload="disableBackButton();-->
			<header class="header">
				<div class="logo-container">
					<a href="#" class="logo">
						<img src="assets/images/logo.png" alt="" />
					</a>
					<div class="visible-xs toggle-sidebar-left" data-toggle-class="sidebar-left-opened" data-target="html" data-fire-event="sidebar-left-opened">
						<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
					</div>
				</div>
			
				<!-- start: search & user box -->
				<div class="header-right">
			
					<div id="userbox" class="userbox">
						<a href="#" data-toggle="dropdown">
							<div class="clear"></div>
							<div class="profile-info" data-lock-name="" data-lock-email="">
								<span class="name"><%=EMP_NAME %></span>
								
							</div>
			
							<i class="fa custom-caret"></i>
						</a>
			
						<div class="dropdown-menu">
							<ul class="list-unstyled">
								<li class="divider"></li>
								<!-- <li>
									<a role="menuitem" tabindex="-1" href="data-toggle="modal" data-target="#myModal"><i class="fa fa-cogs"></i>Change Password</a>
									<a role="menuitem" tabindex="-1" data-toggle="modal" href="#changepassword" ><i class="fa fa-cogs"></i>Change Password</a>
								</li> -->
								<li>
									<a role="menuitem" tabindex="-1" href="logout"><i class="fa fa-power-off"></i> Logout</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- end: search & user box -->
			</header>
			<!-- end: header -->

			<div class="inner-wrapper">
				<!-- start: sidebar -->
				<aside id="sidebar-left" class="sidebar-left">
					<div class="nano">
						<div class="nano-content">
							<nav id="menu" class="nav-main" role="navigation">
								<ul class="nav nav-main">
									
									<li class="active">
									  <a href="User_Auth?Routing=DashBoard">
										<i class="fa fa-tachometer"></i>
										<span class="font-bold">Home</span>
									  </a>
									</li>
									
									
									<!-- <li>
									  <a href="Hhcl_Emp_Update_List.jsp">
										<i class="fa fa-briefcase"></i>
										<span class="font-bold">Hr Appovals List</span>
									  </a>
									</li> -->
									
									
									
								</ul>
								
							</nav>
							
					</div>
				
							
<!-- <script type="text/javascript">
				$(function() {
  $( "#datepicker" ).datepicker({ firstDay: 1});
});
				</script>	 -->		
						</div>
				</aside>
				<!-- end: sidebar -->

			 <section role="main" class="content-body content-body-main">
					<header class="page-header">
					<div class="clear col-md-5" style="color:red;"> <marquee> <%=session.getAttribute("HHCL_EVENT_INFO")%>  </marquee></div>
					
				  <div class="col-md-2 tool-tip-header">
			
				 </div> 
				 
					<div class="col-md-3 col-sm-3" style="float: right;">
					<span><b>Date:</b> <span>
									<script>
									var mydate=new Date()
									var year=mydate.getYear()
									if (year < 1000)
									year+=1900
									var day=mydate.getDay()
									var month=mydate.getMonth()
									var daym=mydate.getDate()
									if (daym<10)
									daym="0"+daym
									var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
									var montharray=new Array("January","February","March","April","May","June","July","August","September","October","November","December")
									document.write("<small><font color='#0088cc' face='Arial'><b>"+dayarray[day]+", "+montharray[month]+" "+daym+", "+year+"</b></font></small>")
								</script>
						 
					</span> </span>
					</div>
				
					
				</header>
					<!-- start: page -->
					<div class="row">
						<div class="col-md-12">
							<!-- start: page -->
					<div id="description" class="wrapper" style="margin-top:25px;">
					<div class="container">
						<div class="row "  id="alldetails" >
							<div class="col-md-10 middle-reg1">
								<div class="panel panel-danger" >
									<div class="panel-heading1">
										<span><b>HR Approval</b> </span>
								        <!-- <span id="Responce_Message" style="color:white;" >  </span> -->
									</div>
									<input id="myInput" type="text" placeholder="Search..">
										<table id="myTable">
 										 <tr>
  										  <th>Employee Id</th>
  										  <th>First Name</th>
  										  <th>Department</th>
  										  <th>Designation</th>
  										  <th>view</th>
										  </tr>
										  	
										</table>
																			
										
									</div>
									
									
								</div>
							</div>
							
							
								   
			
		<script>
		
		/* function goback2()
		{
			$("#aadhar").hide();
		}
		 */
		
		
		function goback()
		{
			//alert("hi");
			
			$("#show1").hide();
			
			$("#alldetails").show();
			
			$("#updt1").hide();$("#updt2").hide();$("#updt3").hide();$("#updt4").hide();$("#updt5").hide();
			$("#updt6").hide();$("#updt7").hide();$("#updt8").hide();$("#updt9").hide();$("#updt10").hide();
			$("#updt11").hide();$("#updt12").hide();$("#updt13").hide();
			
			$("#rej1").hide();$("#rej2").hide();$("#rej3").hide();$("#rej4").hide();$("#rej5").hide();
			$("#rej6").hide();$("#rej7").hide();$("#rej8").hide();$("#rej9").hide();$("#rej10").hide();
			$("#rej11").hide();$("#rej12").hide();$("#rej13").hide();
			
			
			location.reload();

		}
		
		
		</script>


<script type="text/javascript">

//alert("hi");

$("#show1").hide();

$("#showvw").hide();

$.ajax({
    url: 'Hr_Approvals_emp',
    dataType: 'json',
    success: function(data) {
    	
    	
    	$("#show1").hide();
    	//alert(data);
        for (var i=0; i<data.length; i++) {
        
        	//first":"1001","second":"1002","third":"1002","fourth":"1002"fiveth
        	
        	var ols =data[i].first;
        
        	alert("obulesu"+ols);
        	 if(ols==1001){
        		// slno, aadharName, aadharnumber, pannumber, passportnumber, aadharfile, panfile, passport, dateofmodification, Status, Empid, DrivingLicenseno
        	var tr = $('<tr></tr>');
            tr.append('<td align="center">'+data[i].EMPID+'</td>');
            tr.append('<td align="center">'+data[i].EMPNAME+'</td>');
            tr.append('<td align="center">'+data[i].DEPARTMENTNAME+'</td>');
            tr.append('<td align="center">'+data[i].DESIGNATION+'</td>');
          
 	 		tr.append('<button onclick="return activeFunction1(\'' +data[i].EMPID + '\')">View Details</button>'); 
 			$('table').append(tr);    
            
        	 }
            
        	
            
        }
        
        
        
        
        
    },
    error: function(jqXHR, textStatus, errorThrown){
       // alert('Error: ' + textStatus + ' - ' + errorThrown);
    }
});






</script>




<script type="text/javascript">

//personal Details
var email1=" ";
var emailols=" ";var Personalmobile=" ";var Professionalmobile="";var Dateofbirth="";
//Bank
var Bname=" "; var Baccno=" "; var ifcscode=" ";
// communication 
var commstate=" "; var commcity1=" "; var comadd1=" "; var comadd2=" "; var comadd3=" "; var comadd4=" "; var pin=" ";
//perman addr
var perState=" "; var percity1=" "; var peradd1=" "; var peradd2=" "; var peradd3=" "; var peradd4=" "; var ppin=" ";							

var emp="";
//aadhar and pan
var aadhrfl =" "; var pnfl =" "; var passfile=" "; var aadharnam=" "; var pannbr=" "; var drivl =" "; 
var aadhrnum =" "; var pannum=" "; var drivlc =" ";
// slno, aadharName, aadharnumber, pannumber, passportnumber, aadharfile, panfile, passport, dateofmodification, Status, Empid, DrivingLicenseno
 var aadharName=" "; var aadharnumber=" "; var pannumber=" "; var passportnumber=" "; var aadharfile=" "; var panfile=" "; var passport=" ";
var  DrivingLicenseno=" ";
 var str = " "; var panfl=" "; var pcut=" ";var iii=" ";var beml="";var spho=" ";var sproh="";
 var res = " "; var pasf=" "; var pacut=" ";
var bankfl=" "; var bankcut=" "; var email2=" ";
var ssbnm=""; var ssifcs=""; var ssaccno="";
var saaname=""; var saanum=""; var sspannu=""; var sspass=""; var ssdriv="";
var sscadd1=""; var sscomadd2=""; var sscomadd3=""; var sscomadd4=""; var ssct=""; var ssst=""; var sspin="";
//sspin  sscadd1 sscomadd2  sscomadd3  sscomadd4 ssct sspin
var ssperadd1=""; var ssperadd2=""; var ssperadd3=""; var ssperadd4=""; var ssperct=""; var ssperst=""; var sspin="";
//ssperadd1 ssperadd2  ssperadd3 ssperadd4 ssperct ssperst sspin
function activeFunction1(Empid)
{
	
	//alert("hi!!!"+Empid);
	emp=Empid;
	//showvw
	//$("#showvw").show();
	$("#show1").show();
	$("#alldetails").hide();
	$("#showforall").show();
	
	var delay = 2000;
	
	var routing1="PersonalDetails12";
	var routing="aadharandPan";
	$.ajax({url:'Emp_All_Details_list',
		data:{routing: routing1,
        	EmpID:Empid},
		type:'post',
		dataType:'json',
		success:function(data){
			
			//alert(data);
			
			setTimeout(function() {
          delaySuccess(data);
        }, delay);
			
			for(var i=0; i<data.length;i++)
				{
				
				// iii=data[i].professional_phone11;
				 beml= data[i].personal_email11;
				 spho= data[i].personal_phone11;
				 sproh= data[i].professional_phone11;
				 iii= data[i].DATEOFBIRTH
				//AADHAARNAME11,AADHAARCARDNO11,DRIVINGLICENSENO11,PASSPORTNO11;
				 saaname =data[i].AADHAARNAME11;
				 saanum =data[i].AADHAARCARDNO11;
				 ssdriv =data[i].DRIVINGLICENSENO11;
				  sspass=data[i].PASSPORTNO11;
				 sspannu =data[i].pan11;
				//BANKNAME,IFSC11,ACCOUNTNO11,
				ssbnm=data[i].BANKNAME;
				ssifcs=data[i].IFSC11;
				ssaccno=data[i].ACCOUNTNO11;
				//comm_addr111,commadd11,commadd113,commadd4,comm_pincode,COMCITY,COMMSTATE 	    
					sscadd1=data[i].comm_addr111;
					sscomadd2=data[i].commadd11;
					sscomadd3=data[i].commadd113;
					sscomadd4=data[i].commadd4;
					sspin=data[i].comm_pincode;
					ssct=data[i].COMCITY;
					ssst=data[i].COMMSTATE;
					//perm_addr111,peradd2,peradd3,peradd4,perm_pincode11,PCITY,PSTATE
					ssperadd1=data[i].perm_addr111;
					ssperadd2=data[i].peradd2;
					ssperadd3=data[i].peradd3;
					ssperadd4=data[i].peradd4;
					sspin=data[i].perm_pincode11;
					ssperct=data[i].PCITY;
					ssperst=data[i].PSTATE;
					 
				
				 
				}
			
		}});
	
	
	 $.ajax
	    ({ 
	        url: 'Emp_All_Details_list',
	        data: {routing: routing,
	        	EmpID:Empid},
	        type: 'post',
	        dataType: 'json',
	        success: function(data)

	        {
	        	//alert(data.EmpID);
	        	  for (var i=0; i<data.length; i++) {
	        	        
	        		//personal  
	        		//eml2
	        		
	        		//alert(iii);
	        		  emailols=data[i].personal_email1;
	        		//alert("obulesu"+emailols.length);
	        		if(emailols.trim().length==0)
	        			{
	        			
	        			
	        			$("#emailid").hide();
	        			$("#ch1").prop('disabled',true);
	        			$("#chA").prop('disabled',true);
	        			$("#email1").val(beml);
	        			
	        			}
	        		else
	        			{
	        			
	        			email2=data[i].personal_email1;
	        			//alert("obulesu"+email2);
	        			$("#emailid").show();
	        			 $("#email1").val(data[i].personal_email1);
	        			}
	        		 
	        		 Personalmobile=data[i].Personalmobile;
	        		
	        		if(Personalmobile.trim().length==0)
        			{
        			$("#personal").hide();
        			
        			$("#ch2").prop('disabled',true);
        			$("#chB").prop('disabled',true);
        			$("#pmol").val(spho);
        			
        			}
        		else
        			{
        			$("#personal").show();
        			 $("#pmol").val(data[i].Personalmobile);
        			}
	        		
	        		//promobil,dofb;aadhar;aadharnu,aafile	
	        		 Professionalmobile=data[i].Professionalmobile;
	        		
	        		if(Professionalmobile.trim().length==0)
        			{
        				$("#promobil").hide();
        			  $("#promob").val(sproh);
        			$("#ch3").prop('disabled',true);
        			$("#chc").prop('disabled',true);
        			}
        		else
        			{
        			$("#promobil").show();
        			 $("#promob").val(data[i].Professionalmobile);
        			}
	        		Dateofbirth=data[i].Dateofbirth;
	        		//alert(Dateofbirth);
	        		if(Dateofbirth.trim().length==0)
        			{
        			$("#dofb11").hide();
        			$("#dofb").val(iii);
        			$("#ch4").prop('disabled',true);
        			$("#chD").prop('disabled',true);
        			}
        		else
        			{
        			$("#dofb11").show();
        			$("#dofb").val(data[i].Dateofbirth);
        			}
	        			
	        		
	        		if(Dateofbirth.trim().length==0 && Professionalmobile.trim().length==0 && Personalmobile.trim().length==0 && emailols.trim().length==0 )
        			{
        			$("#personald").hide();
        			}
        		else
        			{
        			$("#personald").show();
        			
        			}
	        		
	        		 aadharName=data[i].aadharName;
	        		
	        		 if(aadharName.trim().length==0)
	        			{
	        		$("#aadhar").hide();
	        			  $("#ch5").prop('disabled',true);
	        			  $("#chE").prop('disabled',true);
	        			  $("#aaname").val(saaname);
	        			  
	        			
	        			}
	        		else
	        			{
	        			$("#aadhar").show();
	        			$("#aaname").val(data[i].aadharName);
	        			
	        			}
	        		  aadharnumber=data[i].aadharnumber;
	        		  if(aadharnumber.trim().length==0)
	        			{
	        			$("#aadharnu").hide();
	        			 $("#ch6").prop('disabled',true);
	        			   $("#chF").prop('disabled',true);
	        			   $("#aanum").val(saanum);
	        			   
	        			}
	        		else
	        			{
	        			$("#aadharnu").show();
	        			$("#aanum").val(data[i].aadharnumber);
	        			
	        			}
	        		  res=data[i].aadharfile;
	        		  
	        		  if(res.trim().length==0)
	        			{
	        			$("#aafile").hide();
	        			}
	        		else
	        			{
	        			$("#aafile").show();
	        			
	        			}
	        		
	        		 // pannu, panufile,drivl, passnum, passfile
	        		 
	        		  pannumber=data[i].pannumber; 
	        		 
	        		  if(pannumber.trim().length==0)
	        			{
	        			$("#pannu").hide();
	        			 $("#ch8").prop('disabled',true);	
	        			   $("#chH").prop('disabled',true);
	        			   $("#panNo").val(sspannu);
	        			   
	        			}
	        		else
	        			{
	        			$("#pannu").show();
	        			$("#panNo").val(data[i].pannumber);
	        			
	        			}
	        		  
	        		  passportnumber=data[i].passportnumber;
	        		  if(passportnumber.trim().length==0)
	        			{
	        			$("#passnum").hide();
	        			 $("#ch11").prop('disabled',true);
	        			   $("#chK").prop('disabled',true);
	        			   $("#Passsno").val(sspass);
	        			   
	        			}
	        		else
	        			{
	        			$("#passnum").show();
	        			  $("#Passsno").val(data[i].passportnumber);
	        			
	        			}
	        		  DrivingLicenseno=data[i].DrivingLicenseno;
	        		  if(DrivingLicenseno.trim().length==0)
	        			{
	        			$("#drivl").hide();
	        			 $("#ch10").prop('disabled',true);
	        			   $("#chJ").prop('disabled',true);
	        			   $("#DrivNo").val(ssdriv);
	        			   
	        			
	        			}
	        		else
	        			{
	        			$("#drivl").show();
	        			  $("#DrivNo").val(data[i].DrivingLicenseno);
	        			}
	        		  panfl=data[i].panfile;
	        		  if(panfl.trim().length==0)
	        			{
	        			$("#panufile").hide();
	        			}
	        		else
	        			{
	        			$("#panufile").show();
	        			
	        			}
	        		  
	        		  pasf=data[i].passportfile;
	        		  if(pasf.trim().length==0)
	        			{
	        			$("#passfile").hide();
	        			}
	        		else
	        			{
	        			$("#passfile").show();
	        			
	        			}
	        		 
	        		   
	        		  if(pasf.trim().length==0 && panfl.trim().length==0 && DrivingLicenseno.trim().length==0 && passportnumber.trim().length==0 && pannumber.trim().length==0 && res.trim().length==0 && aadharName.trim().length==0 && aadharnumber.trim().length==0 )
	        			{
	        			$("#aadhaed").hide();
	        			}
	        		else
	        			{
	        			$("#aadhaed").show();
	        			
	        			}
	        		  
	        		  
		        		str=res.substring(20,res.length);
		        		 pcut=panfl.substring(20,panfl.length);
		        		 pasf=data[i].passportfile; 
		        		 pacut=pasf.substring(20,pasf.length);
		       		 
		        		 Bname=data[i].BankName; 
		        		
		        		 if(Bname.trim().length!=0)
		        			{
		        			$("#bankmm").hide();
		        			$("#ch13").prop('disabled',true);
		        			   $("#chM").prop('disabled',true);
		        			   $("#BankN1").val(data[i].BankName);
		        			}
		        		else
		        			{
		        			
		        			$("#bankmm").show();
		        			$("#BankN1").val(ssbnm);	
		        			}
		        		 Baccno=data[i].AccountNo;
		        		// alert(Baccno.trim().length);
		        		 if(Baccno.trim().length==0)
		        			{
		        			$("#accnu").hide();     
		        			 $("#ch14").prop('disabled',true);
		        			   $("#chN").prop('disabled',true);
		        			   $("#Accno").val(ssaccno);
		        			}
		        		else
		        			{
		        			$("#accnu").show();
		        			$("#Accno").val(data[i].AccountNo);	
		        			}
		        		 ifcscode=data[i].IfcsCode;
		        		 if(ifcscode.trim().length==0)
		        			{
		        			$("#ifcsnum").hide();
		        			 $("#ch15").prop('disabled',true);
		        			   $("#chO").prop('disabled',true);
		        			   $("#IfcNo").val(ssifcs);
		        			}
		        		else
		        			{
		        			$("#ifcsnum").show();
		        			$("#IfcNo").val(data[i].IfcsCode);	
		        			}
		        		 bankfl=data[i].BankFile;
	        		 bankcut=bankfl.substring(20,bankfl.length);
	        		 if(bankfl.trim().length==0)
	        			{
	        			$("#bankfile").hide();
	        			}
	        		else
	        			{
	        			$("#bankfile").show();
	        			
	        			}
	        
	        		 if(bankfl.trim().length==0 && ifcscode.trim().length==0 && Baccno.trim().length==0 && Bname.trim().length==0 )
	        			{
	        			$("#bankid").hide();
	        			}
	        		else
	        			{
	        			$("#bankid").show();
	        			
	        			}
	        		 
	        		          
	        		 
	        		 commstate=data[i].Cstate; 
	        		 if(commstate.trim().length==0)
	        			{
	        			$("#commst").hide();
	        			  $("#ch16").prop('disabled',true);
	        			   $("#chP").prop('disabled',true);
	        			   $("#State1").val(ssst);
	        			}
	        		else
	        			{
	        			$("#commst").show();
	        			$("#State1").val(data[i].Cstate);	
	        			}
	        		 
	        		 commcity1=data[i].Ccity;
	        		 if(commcity1.trim().length==0)
	        			{
	        			$("#commct").hide();
	        			  $("#ch17").prop('disabled',true);
	        			   $("#chQ").prop('disabled',true);
	        			   $("#city1").val(ssct);
	        			}
	        		else
	        			{
	        			$("#commct").show();
	        			$("#city1").val(data[i].Ccity);
	        			
	        			}
	        		 
	        		 comadd1=data[i].CommunicationAddress;
	        		 if(comadd1.trim().length==0)
	        			{
	        			$("#commadr1").hide();
	        			 $("#ch18").prop('disabled',true);
	        			 $("#chR").prop('disabled',true);
	        			 $("#comm1").val(sscadd1);
	        			}
	        		else
	        			{
	        			$("#commadr1").show();
	        			$("#comm1").val(data[i].CommunicationAddress);	
	        			}
	        		 
	        		 
	        		 comadd2=data[i].communication2; 
	        		 if(comadd2.trim().length==0)
	        			{
	        			$("#commaddr2").hide();
	        			 $("#ch19").prop('disabled',true);
	        			   $("#chS").prop('disabled',true);
	        			   $("#comm2").val(sscomadd2);
	        			}
	        		else
	        			{
	        			$("#commaddr2").show();
	        			$("#comm2").val(data[i].communication2);
	        			
	        			}
	        		 comadd3=data[i].communication3;
	        		 if(comadd3.trim().length==0)
	        			{
	        			$("#commaddr3").hide();
	        			
	        			 $("#ch20").prop('disabled',true);
	        			  	$("#chT").prop('disabled',true);
	        			  	$("#comm3").val(sscomadd3);
	        			}
	        		else
	        			{
	        			$("#commaddr3").show();
	        			$("#comm3").val(data[i].communication3);
	        			}
	          
	         comadd4=data[i].communication4; 
	         if(comadd4.trim().length==0)
 			{
 			$("#commaddr4").hide();
 			 $("#ch21").prop('disabled',true);
 			   $("#chU").prop('disabled',true);
 			  
 			  $("#comm4").val(sscomadd4);
 			}
 		else
 			{
 			$("#commaddr4").show();
 			$("#comm4").val(data[i].communication4);
 			
 			}
	         
	         pin=data[i].Cpin;
	         if(pin.trim().length==0)
	 			{
	 			$("#commpin").hide();
	 			 $("#ch22").prop('disabled',true);
	 			   $("#chV").prop('disabled',true);
	 			  $("#cpin").val(sspin);
	 			}
	 		else
	 			{
	 			$("#commpin").show();
	 			 $("#cpin").val(pin);
	 			}
	         
	         
	         if(pin.trim().length==0 && comadd4.trim().length==0&& comadd3.trim().length==0 && comadd2.trim().length==0 &&comadd1.trim().length==0&&commcity1.trim().length==0&&commstate.trim().length==0)
	 			{
	 			$("#commid").hide();
	 			}
	 		else
	 			{
	 			$("#commid").show();
	 			
	 			}  
	         
	         
	         //perst, perct, peradd1 , peradd2,peradd3, peradd3,peradd4,  perpin  
	         // ssperadd1 ssperadd2  ssperadd3 ssperadd4 ssperct ssperst sspin
			 perState=data[i].state;
	         ///alert(perState.trim().length);
	         
	         if(perState.trim().length==0)
	 			{
	 			$("#perst").hide();
	 			 $("#ch23").prop('disabled',true);
	 			   $("#chW").prop('disabled',true);
	 			  $("#pState2").val(ssperst);
	 			}
	 		else
	 			{
	 			$("#perst").show();
	 			$("#perid1").show();
	 			$("#pState2").val(data[i].state);
	 			
	 			}
	         
			 percity1=data[i].city;
			 if(percity1.trim().length==0)
	 			{
	 			$("#perct").hide();
	 			  $("#ch24").prop('disabled',true);
	 			   $("#chX").prop('disabled',true);
	 			  $("#pcity1").val(ssperct);
	 			}
	 		else
	 			{
	 			$("#perct").show();
	 			$("#perid1").show();
	 			$("#pcity1").val(data[i].city);
	 			
	 			}
	         
			 peradd1=data[i].PermanentAddress; 
			 if(peradd1.trim().length==0)
	 			{
	 			$("#peradd1").hide();
	 			 $("#ch25").prop('disabled',true);
	 			   $("#chY").prop('disabled',true);
	 			  $("#paddress1").val(ssperadd1);
	 			}
	 		else
	 			{
	 			$("#peradd1").show();
	 			$("#perid1").show();
	 			$("#paddress1").val(data[i].PermanentAddress);
	 			
	 			}
	         
			 peradd2=data[i].PermanentAddress2;
			 if(peradd2.trim().length==0)
	 			{
	 			$("#peradd2").hide();
	 			 $("#ch26").prop('disabled',true);
	 			   $("#chZ").prop('disabled',true);
	 			  $("#paddress2").val(ssperadd2);
	 			}
	 		else
	 			{
	 			$("#peradd2").show();
	 			$("#perid1").show();
	 			$("#paddress2").val(data[i].PermanentAddress2);
	 			
	 			}
			 
			 peradd3=data[i].PermanentAddress3;
			 
			 if(peradd3.trim().length==0)
	 			{
	 			$("#peradd3").hide();
	 			 $("#ch27").prop('disabled',true);
	 		  	$("#chols1").prop('disabled',true);
	 			$("#paddress3").val(ssperadd3);
	 			}
	 		else
	 			{
	 			$("#peradd3").show();
	 			$("#perid1").show();
	 			$("#paddress3").val(data[i].PermanentAddress3);
	 			}
			 
			 
			   
			 peradd4=data[i].PermanentAddress4;
			 if(peradd4.trim().length==0)
	 			{
	 			$("#peradd4").hide();
	 			 $("#ch28").prop('disabled',true);
	 			   $("#chols2").prop('disabled',true);
	 			  $("#paddress4").val(ssperadd4); 
	 			}
	 		else
	 			{
	 			$("#peradd4").show();
	 			$("#perid1").show();
	 			$("#paddress4").val(data[i].PermanentAddress4); 
	 			}
			 
			 
			 
			 
			 ppin=data[i].pin;							
			 if(ppin.trim().length==0)
	 			{
	 			$("#perpin").hide();
	 			 $("#ch29").prop('disabled',true);
	 			   $("#chols3").prop('disabled',true);
	 			  $("#ppin").val(sspin);
	 			}
	 		else
	 			{
	 			$("#perpin").show();
	 			$("#perid1").show();
	 			$("#ppin").val(data[i].pin);
	 			}
			 
			
			 if( perState.trim().length==0 && percity1.trim().length==0&&peradd1.trim().length==0&&peradd2.trim().length==0&&peradd3.trim().length==0&&peradd4.trim().length==0&&peradd4.trim().length==0
                && ppin.trim().length==0)
	 			{
	 			$("#perid1").hide();
	 			$("#perpin").hide();
	 			}
	 		else
	 			{
	 			//$("#perid1").show();
	 			$("#perpin").show();
	 			
	 			
	 			}
			 
			 
			 
	        	//perState,percity1,peradd1,peradd2,peradd3,peradd4,ppin"pstate":" ","pcity" 
	        	
	        	
	        		
	        		 
	        		  $("#aafile").val(str)
	        		  $("#panfile").val(pcut);
	        		  $("#passfile").val(pacut);
	        		   $("#BanFil").val(bankcut);
	        			
	        			
 
	                
	        		  
	        		  

	        		 	
	                  
	              }
	              
	        }
	    });
	
	
	
}

		

	
/* $.post(url="FileDownloadServlet",{panFile:pnfl }, function(data, status){} */

	
	
		
		
		


$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
		
	
	
	


<!-- Modal -->

   <!-- =========================================================================================================================== -->   
 


 	 
</div>		
	
	</div>
	</div>
	</div>
	
	
	
	
	<script type="text/javascript">
	
	var Seml=" ";var db=" ";
	var msg=" ";var msg1=" ";

//email	
var txtE=" "; var Erej=" "; 
function R1() {
	
	if($("#ch1").prop('checked')==true)
	{
		$("#chA").prop("checked",false);
		
	  var person = prompt("Please enter Email Reject reason:", "");
	  if (person == null || person == "") {
		  txtE = "User cancelled the prompt.";
	    
	    $("#suberr").show();
	  } else {
		  txtE =  person;
		  Erej="EMAILREJ";
	    $("#suberr").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#chA").prop("checked",true);
		$("#suberr").hide();
		$("#errors").hide();
		}
	}

//A1 chA ch1

function A1()
{
	if($("#ch1").prop('checked')==true)
		{
		$("#ch1").prop("checked",false);
		Erej=" ";
		$("#suberr").hide();
		$("#errors").hide();
		}
	else
		{
		$("#ch1").prop("checked",false);
		$("#errors").hide();
		}
}




//personal mobile R2 chB a: ch2
var txtPM=" "; var PMrej=" "; 
function R2() {
	
	if($("#chB").prop('checked')==true)
	{
		$("#ch2").prop("checked",false);
		
	  var person = prompt("Please enter personal mobile Reject reason:", "");
	  if (person == null || person == "") {
		  txtPM = "User cancelled the prompt.";
	    
	    $("#suberr1").show();
	  } else {
		  txtPM =  person;
		  PMrej="MOBILEREJ";
	    $("#suberr1").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch2").prop("checked",true);
		$("#suberr").hide();
		$("#errors").hide();
		}
	}
//A2 ch2 chB

function A2()
{
	if($("#ch2").prop('checked')==true)
		{
		$("#chB").prop("checked",false);
		PMrej=" ";
		$("#suberr1").hide();
		$("#errors").hide();
		
		}
	else
		{
		$("#chB").prop("checked",false);
		$("#errors").hide();
		}
}
//profissinal mobile chc  ch3
var txtPROM=" "; var PROMrej=" "; 
function R3() {
	
	if($("#chc").prop('checked')==true)
	{
		$("#ch3").prop("checked",false);
		
	  var person = prompt("Please enter personal mobile Reject reason:", "");
	  if (person == null || person == "") {
		  txtPROM = "User cancelled the prompt.";
	    
	    $("#suberr2").show();
	  } else {
		  txtPROM =  person;
		  PROMrej="PROFIMOBREJ";
	    $("#suberr2").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch3").prop("checked",true);
		$("#suberr").hide();
		$("#errors").hide();
		}
	}

//A3 ch3 chc

function A3()
{
	if($("#ch3").prop('checked')==true)
		{
		$("#chc").prop("checked",false);
		PROMrej=" ";
		$("#suberr2").hide();
		$("#errors").hide();
		}
	else
		{
		$("#chc").prop("checked",false);
		$("#suberr").hide();
		$("#errors").hide();
		}
}




//dataof birth chD  ch4

var txtDOFBACC=" "; var DOFBACREJ=" "; 
function R4() {
	
	if($("#chD").prop('checked')==true)
	{
		$("#ch4").prop("checked",false);
		
	  var person = prompt("Please enter date of birth Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr3").show();
	  } else {
		  txtDOFBACC =  person;
		  DOFBACREJ="DATEOFBITRTHREJ";
	    $("#suberr3").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch4").prop("checked",true);
		$("#suberr3").hide();
		$("#errors").hide();
		}
	}

//A4 ch4 chD

function A4()
{
	if($("#ch4").prop('checked')==true)
		{
		$("#chD").prop("checked",false);
		DOFBACREJ=" ";
		$("#suberr3").hide();
		$("#errors").hide();
		}
	else
		{
		$("#chD").prop("checked",false);
		$("#suberr3").hide();
		$("#errors").hide();
		}
}





// aadhar name chE  ch5

var txtaadhar=" "; var aadharREJ=" "; 
function R5() {
	
	if($("#chE").prop('checked')==true)
	{
		$("#ch5").prop("checked",false);
		
	  var person = prompt("Please enter Aadhar Name Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr5").show();
	  } else {
		  txtaadhar =  person;
		  aadharREJ="AADHARNAMEREJ";
	    $("#suberr5").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch5").prop("checked",true);
		$("#suberr5").hide();
		$("#errors").hide();
		}
	}
//A5 ch5 chE	
	
	function A5()
{
	if($("#ch5").prop('checked')==true)
		{
		$("#chE").prop("checked",false);
		aadharREJ=" ";
		$("#suberr5").hide();
		$("#errors").hide();
		}
	else
		{
		$("#chE").prop("checked",false);
		$("#suberr5").hide();
		$("#errors").hide();
		}
}

	
	
	
//pan number   ch8


var txtpan=" "; var panREJ=" ";  
function R7() {
	
	if($("#chH").prop('checked')==true)
	{
		$("#ch8").prop("checked",false);
		
	  var person = prompt("Please enter Pan Number Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr6").show();
	  } else {
		  txtpan =  person;
		  panREJ="PANNUMBERREJ";
	    $("#suberr6").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch8").prop("checked",true);
		$("#suberr6").hide();
		$("#errors").hide();
		}
	}

//A7 ch8 chH
function A7()
{
	if($("#ch8").prop('checked')==true)
		{
		$("#chH").prop("checked",false);
		panREJ=" ";
		$("#suberr6").hide();
		$("#errors").hide();
		
		}
	else
		{
		$("#chH").prop("checked",false);
		$("#suberr6").hide();
		$("#errors").hide();
		}
}




// driving licence    ch10  
var txtdrivlc=" "; var drivlcREJ=" "; 
function R8() {
	
	if($("#chJ").prop('checked')==true)
	{
		$("#ch10").prop("checked",false);
		
	  var person = prompt("Please enter drivinglicence Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr7").show();
	  } else {
		  txtdrivlc =  person;
		   drivlcREJ="DRIVINGLICREJ";
	    $("#suberr7").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch10").prop("checked",true);
		$("#suberr7").hide();
		$("#errors").hide();
		}
	}
//A8 ch10 chJ	
	function A8()
{
	if($("#ch10").prop('checked')==true)
		{
		$("#chJ").prop("checked",false);
		drivlcREJ=" ";
		$("#suberr7").hide();
		$("#errors").hide();
		
		}
	else
		{
		$("#chJ").prop("checked",false);
		$("#suberr7").hide();
		$("#errors").hide();
		}
}
	
	
//pass port txtpan:txtpan, panREJ:panREJ,
var txtpass=" "; var passREJ=" ";
function R912() {
	
	if($("#chK").prop('checked')==true)
	{
		$("#ch11").prop("checked",false);
		
	  var person = prompt("Please enter Passport Number Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr8").show();
	  } else {
		  txtpass =  person;
		  passREJ="PASSPORTNUMBERREJ";
	    $("#suberr8").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#ch11").prop("checked",true);
		$("#suberr8").hide();
		$("#errors").hide();
		}
	}
//A9 ch11 chK	
	
function A9()
{
	if($("#ch11").prop('checked')==true)
		{
		$("#chK").prop("checked",false);
		passREJ=" ";
		$("#suberr8").hide();
		$("#errors").hide();
		}
	else
		{
		$("#chK").prop("checked",false);
		$("#suberr8").hide();
		$("#errors").hide();
		}
}
	
	// bank BanKrej  BanKAll txtbank:txtbank, bankrej:bankREJ
	var txtbank=" "; var bankREJ=" ";  
function R10() {
	
	if($("#BanKrej").prop('checked')==true)
	{
		$("#BanKAll").prop("checked",false);
		
	  var person = prompt("Please enter Bank Details Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr9").show();
	  } else {
		  txtbank =  person;
		  bankREJ="BANKNAEREJ";
	    $("#suberr9").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#BanKAll").prop("checked",true);
		$("#suberr9").hide();
		$("#errors").hide();
		}
	}

//A10 BanKAll BanKrej
function A10()
{
	if($("#BanKAll").prop('checked')==true)
		{
		$("#BanKrej").prop("checked",false);
		bankREJ=" ";
		$("#suberr9").hide();
		$("#errors").hide();
		}
	else
		{
		$("#BanKrej").prop("checked",false);
		$("#suberr9").hide();
		$("#errors").hide();
		}
}

//communication R11 COMMALLR  COMMALLA	
var txtcommunic=" "; var communicrej=" ";
function R11() {
	
	if($("#COMMALLR").prop('checked')==true)
	{
		$("#COMMALLA").prop("checked",false);
		
	  var person = prompt("Please enter Communication Address  Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr10").show();
	  } else {
		  txtcommunic =  person;
		  communicrej="COMSTATEREJ";
	    $("#suberr10").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#COMMALLA").prop("checked",true);
		$("#suberr10").hide();
		$("#errors").hide();
		}
	}
//A11 COMMALLA COMMALLR

function A11()
{
	if($("#COMMALLA").prop('checked')==true)
		{
		$("#COMMALLR").prop("checked",false);
		communicrej=" ";
		$("#suberr10").hide();
		$("#errors").hide();
		}
	else
		{
		$("#COMMALLR").prop("checked",false);
		$("#suberr10").hide();
		$("#errors").hide();
		}
}


// per addreass      
var txtperaddr=" "; var peraddrrej=" ";
 


function R12() {
	
	if($("#PERALLR").prop('checked')==true)
	{
		$("#PERALLA").prop("checked",false);
		
	  var person = prompt("Please enter Permanet Address  Reject reason:", "");
	  if (person == null || person == "") {
		//  txtDOFBACC = "User cancelled the prompt.";
	    
	    $("#suberr11").show();
	  } else {
		  txtperaddr =  person;  
		  peraddrrej="PERSTATEREJ";
	    $("#suberr11").hide();
	    $("#errors").hide();
	   
	  }
	}
	else
		{
		$("#PERALLA").prop("checked",true);
		$("#suberr11").hide();
		$("#errors").hide();
		}
	}
//A12 PERALLA PERALLR	
function A12()
{
	if($("#PERALLA").prop('checked')==true)
		{
		$("#PERALLR").prop("checked",false);
		peraddrrej=" ";
		$("#suberr11").hide();
		$("#errors").hide();
		}
	else
		{
		$("#PERALLR").prop("checked",false);
		}
}
	
	
	
function Hraccept1(dataObj)
{
	
	if($("#suberr8").is(":visible")||$("#suberr7").is(":visible")||$("#suberr6").is(":visible")||$("#suberr5").is(":visible")
			||$("#suberr11").is(":visible")||$("#suberr10").is(":visible")||$("#suberr9").is(":visible")||$("#suberr3").is(":visible")
			||$("#suberr2").is(":visible")||$("#suberr1").is(":visible")||$("#suberr").is(":visible"))
		{
		
		$("#errors").show();
		
		}
	else
		{
		
		$("#errors").hide();
  $.post(url="HrApprvalSubmit",{ routing:dataObj,
	 								user1:emp,
									pemail: email2,
									Permob:Personalmobile,
									Profemob:Professionalmobile,
									Datebirth:Dateofbirth,
									aadharName:aadharName,
									passportNo:passportnumber,
									drivelicNo:DrivingLicenseno,
									aadharno:aadharnumber,
									pannumber:pannumber,
									bankname:Bname,
									ACNO:Baccno,
									bankifccode:ifcscode,
									cState:commstate,
									ccity1:commcity1,
									ccomadd1:comadd1,
     								ccomadd2:comadd2,
     	 							ccomadd3:comadd3,
      								ccomadd4:comadd4, 
   									cpin:pin,
   									pemrstate:perState,
   									pcity:percity1,
   									peraddress:peradd1,
   									peraddress1:peradd2,
   									peraddress2:peradd3,
   									peraddress3:peradd4,
   									ppin:ppin,
   									txtE:txtE,
   									Erej:Erej,
   									txtPM:txtPM,PMrej:PMrej,PROMrej:PROMrej,txtPROM:txtPROM,DOFBACREJ:DOFBACREJ,
   									txtDOFBACC:txtDOFBACC,txtaadhar:txtaadhar, aadharREJ:aadharREJ,
   									txtpan:txtpan, panREJ:panREJ, txtdrivlc:txtdrivlc, drivlcREJ:drivlcREJ,
   									passREJ:passREJ, txtpass:txtpass,txtbank:txtbank, bankREJ:bankREJ,
   									txtcommunic:txtcommunic,communicrej:communicrej,
   									txtperaddr:txtperaddr, peraddrrej:peraddrrej
   									
   									
  						 
   									
  }, function(data, status){
		 // alert("Data: " + data + "\nStatus: " + status);
		  
		  var backobj = jQuery.parseJSON(data);
		  
	//	alert(backobj.routing);
		 if(backobj.routing=="Allaccept")
		  {
		// alert("fgsdf");
		   $("#u2912").show();
		   
			
			setTimeout(function(){
			
			location.reload();}, 2000);
			
			
		  }
		
		  
		  });
		}
}

function BanKAll () {
 
    if($("#BanKAll").prop('checked')==true)
    {
    	$("#ch13").prop('checked','checked');
    	$("#ch14").prop('checked','checked');
    	$("#ch15").prop('checked','checked');
    	$("#chM").prop('disabled',true);
    	$("#chN").prop('disabled',true);
    	$("#chO").prop('disabled',true);

    }
    else
    	{
    	$("#ch13").prop('checked',false);
    	$("#ch14").prop('checked',false);
    	$("#ch15").prop('checked',false);
    	$("#chM").prop('disabled',false);
    	$("#chN").prop('disabled',false);
    	$("#chO").prop('disabled',false);
    	
    	}
    
    
    
    
}



$("#BanKrej").click(function() {
	
	
	 if($("#BanKrej").prop('checked')==true)
	    {
	    	$("#chM").prop('checked','checked');
	    	$("#chN").prop('checked','checked');
	    	$("#chO").prop('checked','checked');
	    	$("#ch13").prop('disabled',true);
	    	$("#ch14").prop('disabled',true);
	    	$("#ch15").prop('disabled',true);

	    }
	    else
	    	{
	    	$("#chM").prop('checked','checked');
	    	$("#chN").prop('checked','checked');
	    	$("#chO").prop('checked','checked');
	    	$("#ch13").prop('disabled',true);
	    	$("#ch14").prop('disabled',true);
	    	$("#ch15").prop('disabled',true);
	    	
	    	}
	    
	    
    
    
});	


	
	</script>
	
	
	
		
<script type="text/javascript">





//aadhar file
var img;
function downloadingFile1(){

//alert(res.trim().length);


if( res.trim().length==0 || res==null)
	{
	$("#fl1").show();
	}
else
	{
	
	
var URL="Dowloadnew?filePath="+res;
try{
	window.open(URL,'_blank');
	//document.getElementById("URLSRC1").src=URL;
	
}catch(err){
	console.log(err.message);
}

}
}
//pan file
function downloadingFile2(){
	//alert(panfl)
	
	
	if( panfl.trim().length==0 || panfl==null)
	{
		$("#fl2").show();
	}
else
	{
	
	var URL="Dowloadnew?filePath="+panfl;
	try{
		window.open(URL,'_blank');
		//document.getElementById("URLSRC1").src=URL;
		
	}catch(err){
		console.log(err.message);
	}
}
}
// passport file
function downloadingFile3(){
	//alert(res)
	
	if( pasf.trim().length==0 || pasf==null)
	{
		$("#fl3").show();
	}
else
	{
	
	var URL="Dowloadnew?filePath="+pasf;
	try{
		window.open(URL,'_blank');
		//document.getElementById("URLSRC1").src=URL;
	}catch(err){
		console.log(err.message);
	}


	}
}
//bank file
function downloadingFile4(){
	//alert(res)
	
	if( bankfl.trim().length==0 || bankfl==null)
		{
		$("#fl4").show();
		}
	else
		{
	
	var URL="Dowloadnew?filePath="+bankfl;
	try{
		window.open(URL,'_blank');
		//document.getElementById("URLSRC1").src=URL;
	}catch(err){
		console.log(err.message);
	}
		}

	
}



</script>
<!-- Modal -->
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Reason for Reject</h4>
            </div>
            <div class="modal-body">
                <input type="text" name="reason" placeholder="Rejecte Reason...." id="input1" >
            </div>
<!--            <Span id="suberr" style='color:red;margin-bottom: 20px;' hidden = "hidden">save is not accepted without reject reason</Span>
 -->            
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="SendtoHr()">Save</button>
            </div>
        </div>
    </div>
</div> 




<div id="show1" class="hr-approval-block form-group" > 
	<div class="row">
		<div class="col-sm-12">
			<div class="demo">
				<input type="radio" class="green"/> <strong>APPROVAL</strong>
 				<input type="radio" class="red" /> <strong>REJECT</strong>
			</div>
		</div>
	</div>

	<div class="row" id="personald">
		<div class="col-sm-12">
			<h5>Personal Details</h5>
		</div>
	<!-- onclick="Hraccept1('EMAILA')" -->
		<div class="row">
			<div class="col-sm-6" >
 				<div class="demo">
 					<label for="fname">Email:</label>
 					<input  id="email1" name="fname" class="full-w" disabled>
 					<div id="emailid"> 
 					<small><input type="checkbox" id="chA" onclick="A1()"  class="green"  name="empid" checked/></small> 
 					<small><input type="checkbox" id="ch1" class="red" onclick="R1()" onclick="HrReject1('EMAILREJ')" name="empid"/></small>
 					</div>	                
	  				<Span id="u1" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	  				<Span id="suberr" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
	            	<Span id="r" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('MOBILEA')" -->
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Personal Mol No:</label>
 					<input  id="pmol" name="lname" class="full-w" disabled>
 					<div id="personal"> 
 					<input type="checkbox" id="ch2" class="green" onclick="A2()"  name="empid" checked/> 
	        	    <input type="checkbox"  id="chB" class="red" onclick="R2()" onclick="HrReject1('MOBILEREJ')" name="empid"/>
	        	    </div>
	  				<Span id="u2" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	            	<Span id="r2" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
	            <Span id="suberr1" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
	            	
 				</div>
 			</div>
				
			
		</div>
					<!-- onclick="Hraccept1('PROFIMOBA')" -->
		<div class="row">
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="fname">Pro Mol No:</label>
 					<input  id="promob" name="lname" class="full-w" disabled>
 					<div id="promobil"> 
 					 <input type="checkbox" id="ch3" class="green" onclick="A3()"  name="empid" checked/> 
	        	    <input type="checkbox"  id="chc" class="red" onclick="R3()" onclick="HrReject1('PROFIMOBREJ')" name="empid"/>
	        	    </div>
	  				<Span id="u3" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	            	<Span id="r3" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
	            <Span id="suberr2" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
	            	
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('DATEOFBITRTHA')" -->
 			<div class="col-sm-6">
 				<div class="demo">
 					<label for="lname">Date of Birth:</label>
 					<input  id="dofb" name="fname" class="full-w" disabled>
 					<div id="dofb11"> 
 					 <input type="checkbox" id="ch4" class="green" onclick="A4()"  name="empid" checked/> 
        	    	<input type="checkbox"  id="chD" class="red" onclick="R4()" onclick="HrReject1('DATEOFBITRTHREJ')" name="empid"/>
        	    </div>
  				<Span id="u4" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            	<Span id="r4" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
           <Span id="suberr3" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
            	
 				</div>
 			</div>
 		</div>
</div>
	<!-- <div class="col-sm-2"><button class="acc-btn" id="personalacc" onclick="HrAccept('personalAccept')" >Accept</button></div>
	<div class="col-sm-2"><button class="rej-btn" id="personalbutt" onclick="HrReject('personalRej')">Reject</button></div>
	     -->     
	
	<div class="row" id="aadhaed">
		<div class="col-sm-12">
			<h5>Aadhar Details</h5>
		</div>
	<!-- onclick="Hraccept1('AADHARNAMEA')" -->
	<div class="row">
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="fname">Aadhar Name:</label>
 					<input  id="aaname" name="fname" class="full-w" disabled>
 					<div id="aadhar"> 
 					 <input type="checkbox" id="ch5" class="green" onclick="A5()"  name="empid" checked/> 
	        	    <input type="checkbox"  id="chE" class="red" onclick="R5()"  onclick="HrReject1('AADHARNAMEREJ')" name="empid"/>
	        	    </div>
					<Span id="u5" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	            	<Span id="r5" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
	        <Span id="suberr4" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
	        
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('AADHARNUMBERA')" -->
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Aadhar Number:</label>
 					<input  id="aanum" name="lname"  class="full-w" disabled>
 				<!-- <div id="aadharnu">	
 				<input type="checkbox" id="ch6"  class="green"  name="empid" checked/> 
          		<input type="checkbox"  class="red"  id="chF" class="green" onclick="R6()" onclick="HrReject1('AADHARNUMBERREJ')" name="empid"/>
          		</div> -->
				<Span id="u6" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            <Span id="r6" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
            <Span id="suberr5" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
 				</div>
 			</div>
 		</div>
 		
 		<div class="row">
 			<div class="col-sm-6"></div>
 			<div class="col-sm-6">
 				<div class="demo" id="aafile">
 					<label for="fname">Aadhar file:</label>
 					<!-- <input  id="aafile" name="fname" class="full-w"> -->
 					<button type="button" id=""  onclick="downloadingFile1()" class="" ><i  class="fa fa-download" aria-hidden="true"></i></button>
 					<Span id="fl1" style='color:red;margin-bottom: 20px;' hidden = "hidden">File as not available</Span>
 				</div>
 			</div>
 		</div>
 		<!-- onclick="Hraccept1('PANNUMBERA')" -->
 		<div class="row">
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Pan Number:</label>
 					<input  id="panNo" name="lname"  class="full-w" disabled>
 					<div id="pannu"> 
 					<input type="checkbox" id="ch8"  class="green" onclick="A7()"   name="empid" checked/> 
	       		    <input type="checkbox"  id="chH"  class="red" onclick="R7()"  onclick="HrReject1('PANNUMBERREJ')" name="empid"/>
	       		    </div>
					<Span id="u8" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	            	<Span id="r8" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
	            	<Span id="suberr6" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
 				</div>
 			</div>
 			<div class="col-sm-6">
 				<div class="demo" id="panufile">
 					<label for="lname">pan file:</label>
 					 <input  id="panfile" name="lname"  class="full-w"> 
 					<button type="button" id=""  onclick="downloadingFile2()" class="" ><i  class="fa fa-download" aria-hidden="true"></i></button>
 						<Span id="fl2" style='color:red;margin-bottom: 20px;' hidden = "hidden">File as not available</Span>
 				</div>
 			</div>
 		</div>

	
	<!-- onclick="Hraccept1('DRIVINGLICA')" -->
		<div class="row">
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">drive licNo:</label>
 					<input  id="DrivNo" name="lname"  class="full-w" disabled>
 					<div id="drivl">  
 					 <input type="checkbox" id="ch10"  class="green" onclick="A8()"   name="empid" checked/> 
	       		    <input type="checkbox"  id="chJ"  class="red" onclick="R8()" onclick="HrReject1('DRIVINGLICREJ')" name="empid"/>
					</div>
					<Span id="u10" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	            	<Span id="r10" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
	            	<Span id="suberr7" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('PASSPORTNUMBERA')" -->
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Passport Number:</label>
 					<input  id="Passsno" name="lname" class="full-w" disabled>
 					<div id="passnum"> 
 					 <input type="checkbox" id="ch11"  class="green" onclick="A9()"   name="empid" checked/> 
       		    	<input type="checkbox"  id="chK"  class="red" onclick="R912()" onclick="HrReject1('PASSPORTNUMBERREJ')" name="empid"/>
				</div>
				<Span id="u11" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            	<Span id="r11" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
            	<Span id="suberr8" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
 				</div>
 			</div>
 		</div>

		<div class="row">
			<div class="col-sm-6"></div>
 			<div class="col-sm-6">
 				<div class="demo" id="passfile">
 					<label for="lname">Passport fiel:</label>
 					 <input  id="passfile" name="lname" class="full-w" disabled> 
 					<button type="button" id=""  onclick="downloadingFile3()" class="" ><i  class="fa fa-download" aria-hidden="true"></i></button>
 						<Span id="fl3" style='color:red;margin-bottom: 20px;' hidden = "hidden">File as not available</Span>
 				</div>
 			</div>
 		</div>
</div>
	<div class="row" id="bankid">
		<div class="col-sm-12">
			<h5>Bank Details</h5> 
			<input type="checkbox" id="BanKAll" onclick="BanKAll()" onclick="A10()"  class="green"  checked/>
          	<input type="checkbox" id="BanKrej"  class="red" onclick="R10()"  onclick="HrReject1('BANKNAEREJ')" name="email"/>
          	<Span id="suberr9" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
	       		    
		</div>
	
	<!-- onclick="Hraccept1('BANKNAEA')" -->
	<!-- onclick="HrReject1('BANKNAEREJ')" -->
		<div class="row">
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Bank Name:</label>
 				
 					<input  id="BankN1" name="lname" class="full-w" disabled>
 					<!-- <div id="bankmm" >
 					<input type="checkbox" id="ch13"  class="green"  name="email" checked/> 
          			<input type="checkbox" id="chM"  class="red"  name="email"/>
          			</div> -->
	       		    <Span id="u13" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r13" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="HrReject1('ACCOUNTNUMREJ')" -->
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Account No:</label>
 					<input  id="Accno" name="lname" class="full-w" disabled>
 					<!-- <div id="accnu">
 					<input type="checkbox" id="ch14"  class="green"  name="email"/> 
         			<input type="checkbox" id="chN"  class="red"  name="email"/>
         			</div> -->
					<Span id="u14" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
	            	<Span id="r14" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 		</div>
 		<!-- onclick="Hraccept1('IFCNUMA')" -->
 		<!-- onclick="HrReject1('IFCNUMREJ')" -->
 		<div class="row">
 			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Ifc No:</label>
 					<input  id="IfcNo" name="lname" class="full-w" disabled>
 					<!-- <div id="ifcsnum">
 					 <input type="checkbox" id="ch15"  class="green"  name="email"/> 
        	 		<input type="checkbox" id="chO"  class="red"  name="email"/>
        	 		</div> -->
	       		    <Span id="u15" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r15" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<div class="col-sm-6">
 				<div class="demo" id="bankfile">
 					<label for="lname">Bank File:</label>
 					 <input  id="" name="lname" class="full-w"> 
 					<button type="button" id=""  onclick="downloadingFile4()" class="" ><i  class="fa fa-download" aria-hidden="true"></i></button>
 						<Span id="fl4" style='color:red;margin-bottom: 20px;' hidden = "hidden">File as not available</Span>
 				</div>
 			</div>
 		</div>

	
	</div>
	
	
	<div class="row" id="commid">
	<div class="col-sm-12">
		<h5>Communication Address Details</h5>
	</div>
	
	<!-- onclick="Hraccept1('COMSTATE')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">State:</label>
 					<input  id="State1" name="lname" class="full-w" disabled>
 					<!-- <div id="commst" >
 					 <input type="checkbox" id="ch16"  class="green"  name="email" checked/> 
        	 		<input type="checkbox" id="chP"  class="red" onclick="HrReject1('COMSTATEREJ')" name="email"/>
	       		    </div> -->
	       		    <Span id="u16" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r16" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('COMCITY')" -->
 			
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">city :</label>
 					<input  id="city1" name="lname" class="full-w" disabled>
 					<!-- <div id="commct" >
				<input type="checkbox" id="ch17"  class="green"  name="email"/>
      	 		<input type="checkbox" id="chQ"  class="red" onclick="HrReject1('COMCITYREJ')" name="email"/>
	       		</div> -->
	       		    <Span id="u17" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r17" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>
		<!-- onclick="Hraccept1('COMMADD1')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Communication Address1:</label>
 					<input  id="comm1" name="lname" class="full-w" disabled>
 					<!-- <div id="commadr1">
					<input type="checkbox" id="ch18"  class="green"  name="pmobl" checked/>
         	 		<input type="checkbox" id="chR"  class="red" onclick="HrReject1('COMMADD1REJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u18" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            	<Span id="r18" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('COMMADD2')" -->
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Communication Address2:</label>
 					<input  id="comm2" name="lname" class="full-w" disabled>
 					<!-- <div id="commaddr2">
 					<input type="checkbox" id="ch19"  class="green"  name="pmobl" checked/>
       	 			<input type="checkbox" id="chS"  class="red" onclick="HrReject1('COMMADD2REJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u19" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r19" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>
		<!-- onclick="Hraccept1('COMMADD3')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Communication Address3:</label>
 					<input  id="comm3" name="lname" class="full-w" disabled>
  					<!-- <div id="commaddr3">
  					<input type="checkbox" id="ch20"  class="green"  name="pmobl" checked/>
         	 		<input type="checkbox" id="chT"  class="red" onclick="HrReject1('COMMADD3REJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u20" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r20" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('COMMADD4')" -->
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Communication Address4:</label>
 					<input  id="comm4" name="lname" class="full-w" disabled>
					<!-- <div id="commaddr4">
					<input type="checkbox" id="ch21"  class="green"  name="pmobl" checked/>
        	 		<input type="checkbox" id="chU"  class="red" onclick="HrReject1('COMMADD4REJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u21" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r21" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>
		
		<!-- onclick="Hraccept1('COMMPIN')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Pin:</label>
 					<input  id="cpin" name="lname" class="full-w" disabled>
  					<!-- <div id="commpin">
  					<input type="checkbox" id="ch22"  class="green"  name="pmobl" checked/>
       	 			<input type="checkbox" id="chV"  class="red" onclick="HrReject1('COMMPINREJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u22" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r22" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" > 
  					<input type="checkbox" id="COMMALLA"  class="green" onclick="A11()"  name="pmobl" checked/>
       	 			<input type="checkbox" id="COMMALLR"  class="red" onclick="R11()" onclick="HrReject1('COMMPINREJ')" name="pmobl"/>
	       		    <Span id="u22" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r22" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
            		<Span id="suberr10" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
 				</div>
 			</div>
		</div>




	</div>
<div class="row" id="perid1">
	<div class="col-sm-12">
		<h5>Permanent Address Details</h5>
	</div>
				
				<!-- onclick="Hraccept1('PERSTATE')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">State:</label>
 					<input  id="pState2" name="lname" class="full-w" disabled>
					<!-- <div id="perst">
					<input type="checkbox" id="ch23"  class="green"  name="pmobl" checked/>
       	 			<input type="checkbox" id="chW"  class="red" onclick="HrReject1('PERSTATEREJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u23" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r23" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('PERCITY')" -->
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">city :</label>
 					<input  id="pcity1" name="lname" class="full-w" disabled>
 				<!-- 	<div id="perct">
 					<input type="checkbox" id="ch24"  class="green"  name="pmobl" checked/>
       	 			<input type="checkbox" id="chX"  class="red" onclick="HrReject1('PERCITYREJ')" name="pmobl"/>
	       		    </div> -->
	       		    <Span id="u24" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r24" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>
		
		<!-- onclick="Hraccept1('PERADD1')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Permanent Address1:</label>
 					<input  id="paddress1" name="lname" class="full-w" disabled>
 					<!-- <div id="peradd1">
 					<input type="checkbox" id="ch25"  class="green"  name="email" checked/>
         			<input type="checkbox" id="chY"  class="red" onclick="HrReject1('PERADD1REJ')" name="email"/>
	       		    </div> -->
	       		    <Span id="u25" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<!-- <Span id="r25" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span> -->
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('PERADD2')" -->
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Permanent Address2:</label>
 					<input  id="paddress2" name="lname" class="full-w" disabled>
 					<!-- <div id="peradd2">
 					<input type="checkbox" id="ch26"  class="green"  name="email" checked/>
         			<input type="checkbox" id="chZ"  class="red" onclick="HrReject1('PERADD2REJ')" name="email"/>
	       		    </div> -->
	       		    <Span id="u26" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            <Span id="r26" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>
		<!-- onclick="Hraccept1('PERADD3')" -->
		<div class="row">
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Permanent Address3:</label>
 					<input  id="paddress3" name="lname" class="full-w" disabled>
 					<!-- <div id="peradd3">
 					<input type="checkbox" id="ch27"  class="green"  name="email" checked/>
         			<input type="checkbox" id="chols1"  class="red" onclick="HrReject1('PERADD3REJ')" name="email"/>
	       		    </div> -->
	       		    <Span id="u27" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r27" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<!-- onclick="Hraccept1('PERADD4')" -->
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Permanent Address4:</label>
 					<input  id="paddress4" name="lname" class="full-w" disabled>
  					<!-- <div id="peradd4">
  					<input type="checkbox" id="ch28"  class="green"  name="email" checked/>
          			<input type="checkbox" id="chols2"  class="red" onclick="HrReject1('PERADD4REJ')" name="email"/>
	       		    </div> -->
	       		    <Span id="u28" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span>
            		<Span id="r28" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
		</div>

			<!-- onclick="Hraccept1('PERPIN')" -->
		<div class="row">			
			<div class="col-sm-6">
 				<div class="demo" >
 					<label for="lname">Pin:</label>
 					<input  id="ppin" name="lname" class="full-w" disabled>
 					<!-- <div id="perpin">
 					<input type="checkbox" id="ch29"  class="green"  name="email" checked/>
         			<input type="checkbox" id="chols3"  class="red" onclick="HrReject1('PERPINREJ')" name="email"/>
	       		     </div> -->
	       		     <Span id="u29" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span> 
            		<Span id="r29" style='color:red;margin-bottom: 20px;' hidden = "hidden">Rejected successfully</Span>
 				</div>
 			</div>
 			<div class="col-sm-6">
 			 	<div class="demo" >
 					
 					<div id="perpin"> 
 					<input type="checkbox" id="PERALLA"  class="green" onclick="A12()"  name="email" checked/>
         			<input type="checkbox" id="PERALLR"  class="red" onclick="R12()"  onclick="HrReject1('PERPINREJ')" name="email"/>
	       		     </div>
	       		     
            		<Span id="suberr11" style='color:red;margin-bottom: 20px;' hidden = "hidden">It will not accepted without reject reason</Span>
 		
 			</div>
 			
 			
 			
 			</div>
		</div>
		
	</div>	
		<div id="showforall">
		<div class="row">			
			<div class="col-sm-6">
 				<div class="demo">
  				<button type="button"  onclick="Hraccept1('Allaccept')" ><i class="" aria-hidden="true"></i> submit</button>
  				
 				 <!--  <Span id="u29" style='color:green;margin-bottom: 20px;' hidden = "hidden">updated successfully</Span> -->
 				 <!--  <Span id="errors" style='color:red;margin-bottom: 20px;' hidden = "hidden">Please currect the form data..!</Span> -->
 				  
 				 					
 				</div>
 			</div>
 			<div class="col-sm-6"></div>
		</div>
		
		<div class="row">			
			<div class="col-sm-6">
 				<div class="demo">
 				<Span id="u2912" style='color:green;margin-bottom: 20px;' hidden = "hidden">your Approval  successfully submitted</Span> 
 				 <Span id="errors" style='color:red;margin-bottom: 20px;' hidden = "hidden">Please currect the form data..!</Span> 					
            		<!-- <button type="button"  onclick="goback()" ><i class="fa fa-backward" aria-hidden="true"></i> Back</button> -->
            		
 				</div>
 			</div>
 			<div class="col-sm-6"></div>
		</div>


</div>
	

</div>















<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

		
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
		
		
		<!-- Vendor -->
		<!-- <script src="assets/vendor/jquery/jquery.js"></script> -->
		<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
		<!-- Specific Page Vendor -->
		<!-- <script src="assets/vendor/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script> -->
		<!-- Theme Base, Components and Settings -->
		<!-- <script src="assets/javascripts/theme.js"></script> -->
		<!-- Theme Custom -->
		<script src="assets/javascripts/theme.custom.js"></script>
		<!-- Theme Initialization Files -->
		<script src="assets/javascripts/theme.init.js"></script>
		<!-- Examples -->
	<!-- 	<script src="assets/javascripts/dashboard/examples.dashboard.js"></script> -->
				<!-- start popup ad here -->
			<script src="assets/javascripts/jquery.colorbox.js"></script>
	
   <script src="hr_approve.js"></script>
 	</body>
</html>

