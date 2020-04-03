<!doctype html>
<html class="fixed">

	<head>

 
<% 
  String TDSFLAG=(String)session.getAttribute("TDSFLAG");
  String EMP_NAME=(String)session.getAttribute("EMP_NAME");
  String  MGRFLAG=(String)session.getAttribute("Manage_Rights");
  String MGRFLAG_S="none";
  if(MGRFLAG!=null && Integer.parseInt(MGRFLAG)>0){
	  
	  MGRFLAG_S=" ";
  }
  
  if(EMP_NAME==null){
	  
	  response.sendRedirect("login.html");
  }
  
  String  HR_HRMS=(String)session.getAttribute("HR_HRMS");
  if(HR_HRMS!=null && HR_HRMS.equalsIgnoreCase("YES")){
  	HR_HRMS=" ";
  }else{
  	HR_HRMS="none";
  }
  
%>
 
 
 
		<!-- Basic -->
		<meta charset="UTF-8">

		<title>Hetero Healthcare LTD</title>
          <link rel="icon" href="LOH.png" />
		<meta name="keywords" content="HETERO" />
		<meta name="description" content="Hetero">
		<meta name="author" content="Hetero">

		<!-- Mobile Metas -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

		<!-- Web Fonts  -->
		<!-- <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css"> -->

		<!-- Vendor CSS -->
		<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="assets/vendor/magnific-popup/magnific-popup.css" />
		<link rel="stylesheet" href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />
		
	<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script> --> 
		<!-- Specific Page Vendor CSS -->
		<link rel="stylesheet" href="assets/vendor/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />

		
		<!-- Theme CSS -->
		<link rel="stylesheet" href="assets/stylesheets/theme.css" />

		<!-- Skin CSS -->
		<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

		<!-- Theme Custom CSS -->
		<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">
		
		<link rel="stylesheet" href="assets/stylesheets/style.css">

		<!-- Head Libs -->
		<script src="assets/vendor/modernizr/modernizr.js"></script>
		<!-- <script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script> -->
    <!--  <script src="jquery-3.4.1.min.js"></script>  -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
 <!-- <script type="text/javascript" src="select_jquery.js"></script>  -->
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script> 
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
  <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
 <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->

  <script>
  function disableBackButton() {
	   window.history.forward();
	}
	setTimeout("disableBackButton()", 0);


	document.onkeydown = function(){
	       if(event.keyCode == 116) {
	            event.returnValue = false;
	            event.keyCode = 0;
	            return false;
	        }

	}
</script>
	<SCRIPT type="text/javascript">
		window.history.forward();
		function noBack() { window.history.forward(); }
	
  </script>
    
    <style>
    .controlset-pad {
    position: absolute;
    left: -6px;
}
    .controlset-pad input {
    width: 16px;
    height: 16px;
}
input#motp[disabled] {
    opacity: .75;
}
input#motp {
    position: absolute;
    left: -80px;
    height: 34px !important;
} 
	.edit_section {
    padding: 0;
    background: #efefef;
}
.edit_section h1 {
    padding: 0.5em 0em;
    margin: 0;
    background: #0088bc;
    color: white;
    font-size: 22px;
    font-weight: 500;
}
.slct_block {
    width: 480px;
    padding: 1.5em;
	}
	.slct_block label{
	font-size: 14px;
	}
	._details_blk {
    padding-bottom: 0;
   /*  display: none; */
}
	
	._details_blk h2 {
    font-size: 14px;
    font-weight: 500;
    letter-spacing: 0px;
    margin: 0;
    padding: 8px 10px;
    background: #0072bc;
    color: #fff;
    text-align: left;
}
	._details_blk label{
	display: block;
	color: #383838;
	}
	._details_blk .row {
    margin-right: 0;
}
	.mt-2{
	margin-top: 2em;
	}
	
	._details_blk input[type="button"], 
	._details_blk .btn.reg-btn {
    padding: 2px 8px;
    line-height: 2;
    border: 1px solid #015190;
    background: #0071bb;
    color: white;
    border-radius: 0 5px 5px 0;
    font-size: 12px;
    height: 30px !important;
}
	.icon_blk img {
    width: 80px;
    display: block;
    margin: 8px auto;
}
.pl_0 {
    padding-left: 0!important;
}
input._otp {
    /* border: 0;
    border-bottom: 1px solid #cccccc;
    background: none;
    box-shadow: none!important;
    border-radius: 0; */
    padding-right: 10px!important;    
}
._warn {
    position: absolute;
    bottom: -22px;
    left: 18px;
    color: red;
    opacity: .8;
}

#errmsg
{
color: red;
}
#errmsg1
{
color: red;
}
#errmsg2
{
color: red;
}


    </style>
    
    
	</head>
	<body  onpageshow="if (event.persisted) noBack();" onload="disableBackButton(); noBack();" >
		<section class="body">

			<!-- start: header -->
			<header class="header">
				<div class="logo-container">
					<a href="#" class="logo">
						<img src="assets/images/logo.png" height="35" alt="Hetero" />
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
							<div class="profile-info" data-lock-name="sairam" data-lock-email="">
								<span class="name"><%=EMP_NAME %></span>
								
							</div>
			
							<i class="fa custom-caret"></i>
						</a>
			
						<div class="dropdown-menu">
							<ul class="list-unstyled">
								<li class="divider"></li>
								<!-- <li>
									<a role="menuitem" tabindex="-1" href="hhcl_changepassword.html"><i class="fa fa-cogs"></i>Change Password</a>
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
										<span class="font-bold">Dashboard</span>
									  </a>
									</li>
									<li>
									  <a href="NewJoinees?Routing=MyProfile"  >
										<i class="fa fa-user"></i>
										<span class="font-bold">Profile</span>
									  </a>
									</li>
									<li>
									  <a href="PayslipDownload">
										<i class="fa fa-download"></i>
										<span class="font-bold">Downloads</span>
									  </a>
									</li>
									<li>
									  <a href="hhcl_careers.jsp">
										<i class="fa fa-briefcase"></i>
										<span class="font-bold">Careers</span>
									  </a>
									</li>
									
									
									 <!-- Manager Approvals Start -->
							
								  <li style="display:<%=MGRFLAG_S%>;">
									  <a  href="ManagerApprovals?Routing=ManagerAppr" target="_parent">
										<i class="fa fa-check" ></i>
										<span class="font-bold">Manager Approvals</span>
									  </a>
									</li> 
									
									 
									<li>
									  <a href="NewJoinees?Routing=DEPINFO">
										<i class="fa fa-users"></i>
										<span class="font-bold">Department Information</span>
									  </a>
									</li>
									
									<li>
									  <a href="PayslipDownload?Routing=UPDATE" style="display:<%=HR_HRMS%>;"  >
										<i class="fa fa-user"></i>
										<span class="font-bold">HR/HRMS</span>
									  </a>
									 </li>  
									 
									 
									 <li style="display:<%=TDSFLAG%>;">
									  <a href="http://mydesk.heterohcl.com/IT/" target="_blank">
										<i class="fa fa-money "></i>
										<span class="font-bold">TDS Declaration</span>
									  </a>
									</li>
									
									<li>
									  <a href="http://www.heterohealthcare.com/" target="_blank">
										<i class="fa fa-building-o "></i>
										<span class="font-bold">About Our Organization</span>
									  </a>
									</li>
									
									<li>
										<div id="datepicker" class="calendar"></div>
									</li>
								</ul>
							</nav>
							
				
							
						</div>
				
					</div>
				
				</aside>
				<!-- end: sidebar -->

				<section role="main" class="content-body">
					<header class="page-header">
						<div class="clear col-md-9" style="color:red;"> <marquee> <%=session.getAttribute("HHCL_EVENT_INFO")%>  </marquee></div>
					<div class="col-md-3 col-sm-3">
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
					<div class="continer">
						<div class="row" style="padding-right:50px;">
							<div class="col-md-12 edit_section">
							
							 <!-- <h1 class="text-center" > Edit Details</h1>
								
								<div class="slct_block">
								<div class="form-group">	
								<div class="col-sm-4"><label>Choose an option</label></div>
								<div class="col-sm-8" >							
									<select name="" id="ols"  class="form-control" onchange="getIndex()">
									<option  value="" disabled selected>EMP DETAILS EDIT LIST</option>
									<option>PERSONAL DETAILS</option>
									<option>Communication Address</option>
									<option>Permanent Address</option>
									<option>AADHAR & PAN DETAILS</option>
									<option>BANK DETAILS</option>
									
									
									
									</select>
								</div>
								</div>
								</div>  -->
<!-- ---------------------------------------------PERSONAL   DETAILS--------------------------------------------------------------- -->
<div>
 	<form action="fileupload"  method="post" enctype="multipart/form-data" onclick="return validateFormaalldatasubmit();" class="">			

					<div class="_details_blk" id="personalD">
					 <div class="text-center">
              			<h2 class="title">Self DETAILS</h2>             			
            	 		 </div > 
            	<!--  <div class="f_ryt">					
 				 <button type="button"  data-toggle="modal" id="showReasons"  onclick="edit123()"  >Reasons</button>
				</div> -->
            	 		 
            	 		 
            	 		 <div class="panel-body-block">
            	 		 	<div class="row">
            	 		 <!-- <div class="col-sm-3 icon_blk">
       			 		 <img src="assets/images/persoanl_info-icon.svg" alt="personal-info-icon"/>
       					  </div> -->
                   <div class="col-sm-12">
							<!-- <form  name="personal"  onclick="return validateFormOls();"  > -->                       
                     		 <div class="form-group">
                     		  <div class="row ">
                     		 <div class="col-sm-4" >
                     		 <input type="checkbox" id="ch11" class="check-input">
  							 <label >Personal Email</label>

						
						
						<!-- pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" -->
                     <input class="viewcontrol form-control"  name="email" id="uemailid" title="Invalid input" required disabled > 
                     		  <span id="ols1" class="_warn _warn_bottom26" hidden = "hidden">Please enter valid Email Formate Exp(exp123@gmail.com)</span>
                     		   <span id="ols2" class="_warn _warn_bottom26" hidden = "hidden">your entered email is already existed please choose onther  one!</span>
                     		 </div>    
                     
                        
                     <!--  <div class="col-sm-3"><span>Mob.No</span></div> -->
                      <div class="col-sm-4">
                      <input type="checkbox" id="chkTwo" class="check-input">
  					  <label >Personal Mob.No</label>
                      <input class="viewcontrol form-control" type="text" name="phone123" id="umobile" value="" maxlength="10" disabled required >&nbsp;
                      <span id="errmsg" ></span>
                       <span id="ols11" class="_warn" hidden = "hidden">Please enter valid mobile number</span>
                         <span id="ols7" class="_warn" hidden = "hidden">click on get otp</span>
                        <span id="ols12" class="_warn _warn_otp4" hidden = "hidden">this mobile Number is already exists please enter choose onther one!</span>
                       
                      </div>

                      <div class="col-sm-2 ">
                      <label>&nbsp;</label>
                      <input type="button" class="btnSubmit" id="motp"  value="Get OTP" onClick="sendOTP()" >
                      </div>
                  
                      
                       <div class="col-sm-2 pl_0">
                      <label>&nbsp;</label>
                      <input type="text" class="form-control _otp enter_otp" id="otpvalidation" maxlength="4" placeholder="enter OTP " disabled  >
                       <span id="olsotp" class="_warn _warn_enter" hidden = "hidden">Please enter valid OTP</span>
                        <span id="olsotp1" class="_warn _warn_otp" hidden = "hidden">Please enter your  Received mobile number OTP</span>
                       
                      </div>
                       
                     <!--  <div class="col-sm-4"><span>Professional Mob.No</span></div> -->
                     
                    
                     
                     </div>
                  <div class="row">
                  
                  
                    <div class="col-sm-4" >
					<input type="checkbox" id="chkfour" class="check-input">
  				   <label >Date Of Birth</label>
                      
                      
                      
					<!-- <div id="date_picker11"  class="input-group date" data-date-format="mm-dd-yyyy">
    				<input class="form-control" type="text" id="udofb"  />
    				 <input type="" name="bday"   class="date-pik" disabled required> 
    				 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					</div> -->
					
					 <div class='input-group date' id='date_picker11' data-date-format="mm-dd-yyyy">
                    <input type='text' name="bday" id="udofb" class="form-control"  required/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
               		 </div>
					
                      </div>
                  
                 
                  
                   <div class="col-sm-4">
                   
                   <input type="checkbox" id="chkThree" class="check-input">
                   <label for="chkThree" class="left-label">Professional Mob.No</label>
                   <input type="checkbox" id="samepro" class="check-input">
  				   <label for="chkThree">Same as Personal Mob</label>

                      <input class="viewcontrol form-control" type="text" name="promobile" id="promobile" value="" maxlength="10" required disabled>&nbsp;<span id="errmsg1"></span>
                       <span id="ols1p" class="_warn" hidden = "hidden">Please enter valid mobile number</span>
                        <span id="ols1pro" class="_warn _warn_otp3" hidden = "hidden">this mobile Number is already exists please enter onther one!</span>
                       <span id="showgetotp" class="_warn"  hidden = "hidden">Please click on get OTP</span>
                      
                       
                      </div>
                      
                 		 <div class="col-sm-2 ">
                      <label>&nbsp;</label>
                      <input type="button" style="height: 34px !important;" class="btnSubmit getotp1" id="motpp12"  value="Get OTP" onClick="sendOTP12();" disabled>
                      <input type="text" class="form-control" id="otpvalidation12" maxlength="4" placeholder="enter OTP " disabled  >
                      </div>
                      
                       <div class="col-sm-2 pl_0">
                      <label>&nbsp;</label>
                      
                       
                       <span id="olsotp12"  class="_warn _warn_enter" hidden = "hidden">Please enter valid OTP</span>
                        <span id="olsotp123" class="_warn_otp2" hidden = "hidden">Please enter your  Received mobile number OTP</span>
                       
                      </div>
                      
                     <!--  <div class="col-sm-3" ><span>Date Of Birth</span></div> -->
                   
                   
                      
                       <div class="col-sm-2" >
                      <label>&nbsp;</label>                    
                     
					<!-- <div class="form-group ">
					<input type = "button" id = "driver" value = "Send to HR"  />
						</div> -->
					</div>
					
		<!-- 	<span id="succ" class="_warn" hidden = "hidden">your data successfully sended to Hr please wait for Hr Response</span>
			<span id="fails" class="_warn" hidden = "hidden">your previous request under Processed please wait for some time..!</span> -->
			<!-- <span id="reason1" class="_warn" hidden = "hidden"></span> -->
			
<!-- 			<input type="text" class="form-control _otp" id="reason1" hidden = "hidden"  >
 -->			
			
<!-- 			<span id="err1" class="_warn" hidden = "hidden">Without Edit Data it will not sent to Hr..!</span>
 -->			
			
			
					
				</div>
				</div>
				<!-- </form> -->
				</div>
		</div>
            	 		 </div>
			</div>
			
			<!-- ---------------------------------------------COMMUNICATION   ADDRESS--------------------------------------------------------------- -->
				<div class="_details_blk" id="commadd">	

				
				
					 <div class="text-center text-center-p">
              			<h2 class="title">COMMUNICATION  ADDRESS</h2>       
              			 <div class="checkbox-a">
              			 	<input type="checkbox" id="ch5" class="check-input">
  				         	<label>Select</label> 
              			 </div>    					
             		</div> 
         <div class="panel-body-block">
         
         <div class="row">
            	 	<!-- <div class="col-sm-3 icon_blk">
							<img src="assets/images/prsnt_adrs_icon.svg" alt="bank-details"/>
					 </div>  -->
							
				<div class="col-sm-12">	
        
         
			<!-- 	<form name="formB" class="form-horizontal"   onclick="return validateFormOls11();" > -->
 				<div class="form-group">
 				
 				 <div class="row">
 				
 			           <div class="col-sm-4">
                 	
                    <label>Country</label>
                    <select name="country" class="viewcontrol form-control" id="country1" disabled >
					<option value="" selected disabled>-Select Country-</option>
					<option value="1" >India</option>
					<option value="102767" >USA</option>
					</select>
					</div>
                       
                     <div class="col-sm-4">
                     <label>State</label>
                    <select name="State" id="state1"  class="form-control" disabled >    
					  					
					</select>                       
                       </div>
                       
               
                       
                      <div class="col-sm-4">
                      <label>City</label>
	                    <select name="city" id="city1" class="viewcontrol form-control" disabled  >
													
						</select>
						</div>
					</div>	
					 <div class="row">
                      <div class="col-sm-4">
                      <label>Address-1</label>
                      <input  type="text" name="address1" id="address"  class="form-control" disabled >                       
                       </div>
                        <div class="col-sm-4">
                      <label>Address-2</label>
                      <input  type="text" name="address2" id="address1"  class="form-control" disabled >                       
                       </div>
                        <div class="col-sm-4">
                      <label>Address-3</label>
                      <input  type="text" name="address3" id="address11"  class="form-control" disabled >                       
                       </div>
                       <div class="col-sm-4">
                      <label>Address-4</label>
                      <input  type="text" name="address4" id="address111ols"  class="form-control" disabled >                       
                       </div>
                       
                      <div class="col-sm-4">
	                      <label>Pin code</label>
	                      <input  type="text" name="pincode" id="pin" maxlength="6" value="" class="form-control" disabled>
                      </div>
                      			 
                      		  <!-- <div class="col-sm-4">	 
								<div class="form-group ">
								<label>&nbsp;</label>
								<button type="submit" class="btn reg-btn" id="disab">sent to hr</button>
								<input type = "button" id="commu" value = "Send to HR" />
								</div>
							</div>  -->
								<!-- <span id="succ1" class="_warn" hidden = "hidden">your data successfully sended to Hr please wait for Hr Response</span>
								<span id="fails1" class="_warn" hidden = "hidden">your previous request under Processed please wait for some time..!</span>
								<span id="editerr" class="_warn" hidden = "hidden">without Edit it will not set to Hr..!</span> -->
								
						</div>		
					</div>
			<!-- 	</form> -->
</div>
</div>
         	
         </div>
									</div>	
										
			
			
				<!-- ---------------------------------------------PERMANENT ADDRESS--------------------------------------------------------------- -->

		<div class="_details_blk" id="peraddr">	
				<div class="text-center">
					<!-- <button id="getformdetails" onclick="getIndex()"   type="submit">Search</button></div> -->
				</div>

             		<div class="text-center text-center-p">
              			<h2 class="title">PERMANENT ADDRESS</h2>       
              			 <div class="checkbox-a">
              			 	<input type="checkbox" id="ch6" class="check-input">
  				         	<label>Select </label> 
              			 </div> 
              			 <div class="checkbox-aa">
              			 	<input type="checkbox" id="btn2" class="check-input">
  				         	<label>SAME AS COMMUNICATION ADDRESS </label> 
              			 </div>   					
             		</div> 
            
                    
                   <div class="panel-body-block">
                   
                    <div class="row">
            	 	<!-- <div class="col-sm-3 icon_blk">
							<img src="assets/images/prmnt_adrs_icon.svg" alt="bank-details"/>
					 </div> -->
							
				<div class="col-sm-12">	
                    
				<!-- 	<form name="formA" class="form-horizontal"  action="" onclick="return validateFormOls111();"> -->
				
				
				
				
 					<div class="form-group">
 					
 					<div class="row "> 
                     <div class="col-sm-4" >
                     <label>Country</label>
                    <select name="countryper"  id="country2" class="form-control" disabled >
						<option value="" selected disabled>-Select Country-</option>
						<option value="187868" >USA</option>
						<option value="1" >India</option>
						</select>
				</div>
                    <!--  dropdown.append('<option value="">' + emptyMessage + '</option>'); -->  
                       
                       <div class="col-sm-4" >
                      <label>State</label>
                    <select name="stateper"id="state2" class="form-control" disabled>
                   
					</select>                       
                       </div> 
                       
                       
                     
                       
                       
                       
                       
                       
                       
                      <div class="col-sm-4" >
                      <label>City</label>
                   <select    id="city2" name="cityper"   class="form-control" disabled>                       
                       
					</select>
                   
                  
                       </div>
                       </div>
                       <div class="row"> 
                      <div class="col-sm-4" >
                      <label>Address-1</label>
                      <input  type="text" name="aadharper" id="addressp"  value="" class="form-control" disabled>                       
                       </div>
                        <div class="col-sm-4" >
                      <label>Address-2</label>
                      <input  type="text" name="aadharper1"id="addressp1"  value="" class="form-control" disabled>                       
                       </div>
                        <div class="col-sm-4" >
                      <label>Address-3</label>
                      <input  type="text" name="aadharper2" id="addressp2"  value="" class="form-control" disabled>                       
                       </div>
                        <div class="col-sm-4" >
                      <label>Address-4</label>
                      <input  type="text" name="aadharper3" id="addressp3"  value="" class="form-control" disabled>                       
                       </div>
                      <div class="col-sm-4">
                      <label>Pin code</label>
                      <input  type="text" name="ppincode"id="pin2" maxlength="6" value="" class="form-control" disabled> 
                      <span id="ols1234" class="_warn" hidden = "hidden">Please enter valid mobile number</span>                      
                       </div>


						<div class="col-sm-4">
						<div class="form-group ">
						<label>&nbsp;</label>
						<!-- <button type="submit" class="btn reg-btn" id="PERMANENT">sent to hr</button> -->
<!-- 						<input type = "button" id= "PERMAN" value = "submit" />
 -->						<!-- <button type="submit" class="btn reg-btn" id="allsubmit"  >Send to HR</button> -->
						</div>
						</div>
						
						<!-- <span id="succ2" class="_warn" hidden = "hidden">your data successfully sended to Hr please wait for Hr Response</span>
						<span id="fails2" class="_warn" hidden = "hidden">your previous request under Processed please wait for some time..!</span>
						<span id="editerr1" class="_warn" hidden = "hidden">without Edit Data it will not to sent to Hr..!</span>
						 -->
						
						
					</div>

							</div>
					<!-- 	</form> -->
						</div>
						</div>
                   	
                   </div>
										
			
			
			
			
		<!-- ---------------------------------------------AADHAR   & PAN DETAILS--------------------------------------------------------------- -->


						<div class="_details_blk" id="aadhar123">

						 <div class="text-center">
              				<h2 class="title">AADHAR &amp; PAN DETAILS</h2>
             				 </div> 
         
				<div class="panel-body-block">
				
				<div class="row">
            	 	<!-- <div class="col-sm-3 icon_blk">
							<img src="assets/images/identity_card-icon.svg" alt="identity-card"/>
					 </div> --> 
							
				<div class="col-sm-12">	
						<!--  <div class="controlset-pad">
                 	<label>Select All</label>
    					
    					<input type="checkbox"id="ch7">
						</div> -->
 					<!-- <form action="fileupload" method="post" enctype="multipart/form-data" onclick="return validateForm2();"  >	 -->		
						<div class="form-group">
						
						<div class="row">
                    	<div class="col-sm-4">
                    	
                    	<input type="checkbox" id="ch7" class="check-input">
  					    <label>Aadhar Name</label>
  					    
                      <input class="viewcontrol form-control" type="text" name="aadharname" id="aadhar" value=""  disabled required >
                    <span id="olsadhr" class="_warn" hidden = "hidden">Aadhar number already exist please upload aadhar file </span>
                       
                      </div>
                      
                      
                      <div class="col-sm-4">
                      <label>Aadhar Number</label>
                      <input class="viewcontrol form-control" type="text" name="adhar" id="aadharno" maxlength="12" value="" disabled required>&nbsp;<span id="errmsg2"></span>
                      <span id="olsadhrno" class="_warn" hidden = "hidden">Aadhar Number is already exist please upload aadhar file</span>
                      <span id="invalidaadha" class="_warn" hidden = "hidden">Please enter valid Aadhar number</span>
                      
                      </div>
                        <div class="col-sm-4">
                      <label>&nbsp;</label>
					<input type="file" name="adharf" class="form-control" id="adhaf" accept=".png, .jpg, .jpeg" disabled required />
					
							                       
                       </div> 
                       
                      
                </div>
                       
                       <div class="row"> 
                       
                      </div>
                 <!--   <div class="col-sm-4">
                      <label>&nbsp;</label>
					<input type="file" name="adharf" class="form-control" id="adhaf" disabled />		                       
                       </div>  -->
                      <div class="row mt-10 pb-23"> 
                       
                      <div class="col-sm-4">
                      <input type="checkbox" id="ch9" class="check-input">
  					   <label>PAN Number</label>
                      <input class="viewcontrol form-control" type="text" name="pan" id="pannumbr"  maxlength="10"  value="" disabled required >
                      <span id="olspan" class="_warn _warn_otp5" hidden = "hidden">your enter Pan Number is already exists please choose onther one..! </span>
                      
                      	 <span id="pannumberv" class="_warn _warn_otp5" hidden = "hidden">Please Enter the valid pan number</span> 
                      
                      </div>
                       <div class="col-sm-4">
                      <label>&nbsp;</label>
						<input type="file" name="panf" class="form-control" id="panf" disabled required />
					<!-- <span id="pnfile" class="_warn" hidden = "hidden">Please choose the file mandatory</span> -->
						
						             
					 </div>  
                        </div>
                    <!--    <div class="col-sm-4">
                      <label>&nbsp;</label>
						<input type="file" name="panf" class="form-control" id="panf" disabled />             
					 </div>  --> 
                     <div class="row mt-10 pb-23"> 
                      <div class="col-sm-4">
                      
                      <input type="checkbox" id="ch10" class="check-input">
  					   <label>Passport no</label>
                      <input class="viewcontrol form-control" type="text" name="passport" id="passportno" value="" maxlength="8" disabled required>
                      <span id="olspass" class="_warn _warn_otp5" hidden = "hidden">Passport Number is already exist please choose new one..!</span>
                    <span id="passvalidation" class="_warn _warn_otp5" hidden = "hidden">please enter valid passport number..!</span>
                      
                      
                     
                       </div>
                      <div class="col-sm-4">
						<label>&nbsp;</label>
						<input type="file" name="passport" class="form-control" id="passf" accept=".png, .jpg, .jpeg" disabled required /> 
						<!-- <span id="ptfile" class="_warn" hidden = "hidden">Please choose the file mandatory</span> -->
						
						                     
					  </div>
                        
					 </div>
					 <div class="row mt-10 pb-23">
					 	<div class="col-sm-4">
                      <input type="checkbox" id="ch12" class="check-input">
  					   <label>Driving License No</label>
                      <input class="viewcontrol form-control" type="text" name="drivinglnc" id="drivinglncno" value="" maxlength="13" disabled required >
                      <span id="olsDriv" class="_warn _warn_otp6" hidden = "hidden">your enter Driving License Number is already existe</span>
                       <span id="drivringlic" class="_warn _warn_otp6" hidden = "hidden">please enter valid Driving License No </span>
                    
		
                       </div>
					 </div>
				<!-- 	<span id="failsa" class="_warn" hidden = "hidden">your  request under Processed please wait for some time..!</span>
					<span id="err3" class="_warn" hidden = "hidden">Without Edit Data it will not sent to Hr..!</span> -->
					
						</div>
			<!-- </form> -->
		
		</div>
		</div>
				
				</div>		
		</div>
		
	<!-- --------------------------------------------------------BANK DETAILS----------------------------------------------------------------- -->	
		<div class="_details_blk" id="bankD">

             			
             			<div class="text-center text-center-p">
              			<h2 class="title">BANK DETAILS</h2>       
              			 <div class="checkbox-a">
              			 	<input type="checkbox" id="ch8" class="check-input">
  				         	<label>Select </label> 
              			 </div>    					
             		</div>  
             					
             					
             		<div class="panel-body-block">
             		
             		<div class="row">
            	 	<!-- <div class="col-sm-3 icon_blk">
							<img src="assets/images/bank_details-icon.svg" alt="bank-details"/>
					 </div> -->
							
				<div class="col-sm-12">			
             					
             				
					<!-- 	<form action="BanK_fileupload" method="post" enctype="multipart/form-data"  onclick="return validateForm1();"> -->

						<div class="form-group">
						 <div class="row">
                      	<div class="col-sm-4">
                      	<label>BANK Name</label>
					 <select name="bankName1" id="bnk"  class="form-control"  disabled required >	
					 <!--  <option  selected="selected" selected>---Select Bank---</option> -->			
							</select> 
							 
                       </div>
						
                    			 <div class="col-sm-4">
                    			  <label>Account No.</label>
                     			 <input class="viewcontrol form-control" type="text" name="accno" id="accno1" value="" disabled required>
                     			 <span id="olsacc" class="_warn _warn_bottom30" hidden = "hidden">Please choose onther one this account number alerady existed</span>                       
                       			</div>
                       
                     			 <div class="col-sm-4">
                     			 <label>IFSC No.</label>
                      			<input class="viewcontrol form-control" type="text" name="ifccodenum" id="ifccode1" value="" maxlength="10" disabled required>
                      			
                      			</div>
                      			 
                      			 </div>
                      			 <div class="row ">
                      			
                     			   <div class="col-sm-4">
                     			  <label>&nbsp;</label>						
								<input type="file" name="bankf" id="bankf" class="form-control" required disabled   />  
								<!-- <span id="bkfile" class="_warn" hidden = "hidden">Please choose the file mandatory</span> -->
								              
						       </div> 
								
								<!--  <div class="col-sm-4">
									<div class="form-group ">
									<label>&nbsp;</label>
									<button type="submit" class="btn reg-btn" id="disab"  >Send to HR</button>
									</div>
								</div> -->
								</div>	
					<div class="row">
					<div class="col-sm-5"></div>
					<div class="col-sm-2">
						<button type="submit" class="btn reg-btn final-btn" id="allsubmit"  >SUBMIT</button>
					</div>
					</div>
					<span id="ols8" class="_warn" hidden = "hidden">please currect the form data..!</span>
				<span id="sucb" class="_warn" hidden = "hidden">your data successfully sended to Hr please wait for Hr Response</span>
 					<span id="failsb" class="_warn" hidden = "hidden">your request under Processed please wait for some time..!</span>
					<span id="err2" class="_warn" hidden = "hidden">Without Edit Data it will not sent to Hr..!</span>
			
					
								
								</div>	
								
							<!-- 	</form> -->
			
										
						</div>
						</div>
             		
             		</div>
					</div>					
											
														
					
					</div> <!-- end edit_section -->
						
						
						
						
						</form>
						
						
						
						
						
						</div>						
					  </div>
					
					
					<!-- end: page -->
					
		</div>			
</div>
				</section>
				</div>
			
		
		</section>
		
		<script>
$(document).ready(function(){
  $("#btn2").click(function(){
	
	  $("#country2").attr("disabled", !this.checked); 
	    $("#state2").attr("disabled", !this.checked); 
	    $("#city2").attr("disabled", !this.checked); 
	    $("#addressp").attr("disabled", !this.checked); 
	    $("#addressp1").attr("disabled", !this.checked); 
	    $("#addressp2").attr("disabled", !this.checked); 
	    $("#addressp3").attr("disabled", !this.checked); 
	    $("#pin2").attr("disabled", !this.checked);
	  
	  
	    //ch6
	  if($("#btn2").prop('checked')==true)
	  {
	  
		 $("#ch6").prop('checked',false); 
		  
	  $('#city2 option:selected').remove(); 
	  $('#state2 option:selected').remove();
	  
    $("#country2").val($("#country1").val());
    $("#addressp").val($("#address").val());
    $("#addressp1").val($("#address1").val());
    $("#addressp2").val($("#address11").val());
    $("#addressp3").val($("#address111ols").val());
    $("#pin2").val($("#pin").val());
	$("#state2").append('<option value="'+ $("#state1").val()+ '"seleted>' + $("#state1").val() + ' </option>').attr("selected", "selected");
	$("#city2").append('<option value="'+ $("#city1").val()+ '"seleted>' + $("#city1").val() + ' </option>').attr("selected", "selected");
	 $("#allsubmit").prop("disabled",false);
	    $("#err2").hide();
	  }
	  else
		  {
			
		  
		  
		  $('#city2 option:selected').remove(); 
		  $('#state2 option:selected').remove();
		  $("#country2").val($("#country1").val());
		    $("#addressp").val(peraddr1);
		    $("#addressp1").val(peradd2);
		    $("#addressp2").val(peradd3);
		    $("#addressp3").val(peradd4);
		    $("#pin2").val(ppin);
			$("#state2").append('<option value="'+pstate+ '"seleted>' +pstate + ' </option>').attr("selected", "selected");
			$("#city2").append('<option value="'+pcity+ '"seleted>' + pcity + ' </option>').attr("selected", "selecte");
			 $("#allsubmit").prop("disabled",true);
			    $("#err2").hide();
		  }
	
  });
});
</script>
			
		<script type="text/javascript">
		
			
		
		
		$("#ch11").click(function() {
		    $("#uemailid").attr("disabled", !this.checked); 
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		    
		    if($("#ch11").prop('checked')==true)
		    {
		    	$("#uemailid").val(this.value='');
		    }
		    else
		    	{
		    	$("#uemailid").val(ols);
		    	}
		    
		    
		    
		});	
		
		$("#chkTwo").click(function() {
		    $("#umobile").attr("disabled", !this.checked);
		    $("#motp").attr("disabled", !this.checked); 
		    $("#motp").prop("disabled",false);
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		    
		    if($("#chkTwo").prop('checked')==true)
		    {
		    	$("#umobile").val(this.value='');
		    	
		    	 $("#motp").prop("disabled",false);
		    }
		    else
		    	{
		    	$("#umobile").val(mobile);
		    	 $("#olsotp1").hide();
		    	 $("#olsotp").hide();
		    	 $("#ols12").hide();
		    	 $("#ols7").hide();
		    	 $("#ols11").hide();
		    	 $("#motp").prop("disabled",true);
		    	}
		    
		    
		    
		    
		    
		});	
		 
		  	
		
		$("#samepro").click(function() {
		    
		    if($("#samepro").prop('checked')==true)
		    {
		    	$("#promobile").val($("#umobile").val());
		    	 $("#promobile").attr("disabled", false);
		    	 $("#chkThree").prop("checked",false);
		    	 	$("#motpp12").prop("disabled",true);
		    	 	 $("#ols1p").hide();$("#err1").hide();
		 			$("#ols1pro").hide();$("#olsotp12").hide();
		 			$("#otpvalidation12").val(this.value='');
		 			
		    }
		    else
		    	{
		    	$("#promobile").val(promob);
		    	$("#allsubmit").prop("disabled",false);
		    	$("#promobile").attr("disabled", true);
		    	 $("#ols1p").hide();
		    	 $("#ols1pro").hide();
		    	 $("#showgetotp").hide();
		    	 $("#olsotp12").hide();
		    	 $("#olsotp123").hide();
		    	
		    	 
		    	}
		    
		    
		    
		    
		});	
		
		
		
		
		
		
		$("#chkThree").click(function() {
		    $("#promobile").attr("disabled", !this.checked); 
		    $("#motpp12").prop("disabled",false);
		    
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		    
		    if($("#chkThree").prop('checked')==true)
		    {
		    	$("#promobile").val(this.value='');
		    	$("#samepro").prop("checked",false);
		    	
		    }
		    else
		    	{
		    	$("#promobile").val(promob);
		    	
		    	 $("#ols1p").hide();
		    	 $("#ols1pro").hide();
		    	 $("#showgetotp").hide();
		    	 $("#olsotp12").hide();
		    	 $("#olsotp123").hide();
		    	
		    	
		    	}
		    
		    
		    
		    
		});	
		
		$("#chkfour").click(function() {
		    $("#udofb").attr("disabled", !this.checked); 
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		    
		    if($("#chkfour").prop('checked')==true)
		    {
		    	$("#udofb").val(this.value='');
		    }
		    else
		    	{
		    	$("#udofb").val(dofb);
		    	}
		    
		    
		    
		    
		});	
	
		$("#ch5").click(function() {
		    $("#country1").attr("disabled", !this.checked); 
		    $("#state1").attr("disabled", !this.checked); 
		    $("#city1").attr("disabled", !this.checked); 
		    $("#address").attr("disabled", !this.checked); 
		    $("#address1").attr("disabled", !this.checked); 
		    $("#address11").attr("disabled", !this.checked); 
		    $("#address111ols").attr("disabled", !this.checked); 
		    $("#pin").attr("disabled", !this.checked); 
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		     
		    
		    if($("#ch6").prop('checked')==true)
		    	{
		    	
		    	}
		    else
		    	{
		    	
					    
					    
		    	}
		    
		    
		    
		    
		    
		});	
		
		
		$("#ch6").click(function() {
		    $("#country2").attr("disabled", !this.checked); 
		    $("#state2").attr("disabled", !this.checked); 
		    $("#city2").attr("disabled", !this.checked); 
		    $("#addressp").attr("disabled", !this.checked); 
		    $("#addressp1").attr("disabled", !this.checked); 
		    $("#addressp2").attr("disabled", !this.checked); 
		    $("#addressp3").attr("disabled", !this.checked); 
		    $("#pin2").attr("disabled", !this.checked); 
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		     
		    if($("#ch6").prop('checked')==true)
		    	{
		    	
		    	$("#btn2").prop("checked",false);
		    	  $('#city2 option:selected').remove(); 
				  $('#state2 option:selected').remove();
				  $("#country2").val($("#country1").val());
				    $("#addressp").val(peraddr1);
				    $("#addressp1").val(peradd2);
				    $("#addressp2").val(peradd3);
				    $("#addressp3").val(peradd4);
				    $("#pin2").val(ppin);
					$("#state2").append('<option value="'+pstate+ '"seleted>' +pstate + ' </option>').attr("selected", "selected");
					$("#city2").append('<option value="'+pcity+ '"seleted>' + pcity + ' </option>').attr("selected", "selecte");
					 $("#allsubmit").prop("disabled",false);
					    $("#err2").hide();
		    	}
		    else
		    	{
		    	
		    	 
				
				
		    	}
		    
		});	
		
		
		
		

		$("#ch7").click(function() {
		    
		  
		    if($("#ch7").prop('checked')==true)
			{
		    	$("#aadhar").attr("disabled", !this.checked); 
			    $("#aadharno").attr("disabled", !this.checked); 
			    $("#adhaf").attr("disabled", !this.checked); 
			    $("#allsubmit").prop("disabled",false);
			    
			    $("#aadhar").val(this.value=''); 
			    $("#aadharno").val(this.value=''); 
			    
			    $("#err2").hide();
			$("#Afile").show();
			}
		else
			{
			$("#aadhar").attr("disabled", true); 
		    $("#aadharno").attr("disabled", true); 
		    $("#adhaf").attr("disabled", true); 
		    $("#aadhar").val(aadharName1); 
		    $("#aadharno").val(aadharnub); 
		    
			$("#Afile").hide();
			$("#ols8").hide();
			}
		  
		});	
		
		//ch9
		$("#ch9").click(function() {
			 
		    
		    if($("#ch9").prop('checked')==true)
			{
		    		 $("#pannumbr").attr("disabled", !this.checked); 
		    		 $("#pannumbr").val(this.val=''); 
				    $("#panf").attr("disabled", !this.checked); 
				    $("#allsubmit").prop("disabled",false);
				    $("#err2").hide();
					//$("#pnfile").show();
			}
		else
			{
			 $("#pannumbr").attr("disabled", true); 
			    $("#panf").attr("disabled", true); 
			    $("#pannumbr").val(pan); 
			$("#pnhide").hide();
			$("#ols8").hide();
			
			}
		    
		    
		    
		    
		    
		});	
		//ch10
		
			$("#ch10").click(function() {
				
			    
			    if($("#ch10").prop('checked')==true)
				{
			    	$("#passportno").attr("disabled", !this.checked); 
			    	$("#passportno").val(this.val='');
				    $("#passf").attr("disabled", !this.checked); 
				    $("#allsubmit").prop("disabled",false);
				    $("#err2").hide();
					$("#ptfile").show();
				}
			else
				{
				
				$("#passportno").attr("disabled",true); 
			    $("#passf").attr("disabled",true ); 
			    $("#passportno").val(passnu);
			    $("#err2").hide();
				$("#ptfile").hide();
				$("#ols8").hide();
				}
				 	
			    
			    
			    
			    
			    
		});	
		
			$("#ch12").click(function() {
				 $("#drivinglncno").attr("disabled", !this.checked);
				 $("#allsubmit").prop("disabled",false);
				  $("#err2").hide();
				  
				if($("#ch12").prop('checked')==true)
					{
					$("#drivinglncno").val(this.val='');
					}
				else
					{
					$("#drivinglncno").val(drivl);
					}
				  
				  
		});	
		
	
		$("#ch8").click(function() {
		
		    $("#bnk").attr("disabled", !this.checked); 
		    $("#accno1").attr("disabled", !this.checked); 
		    $("#ifccode1").attr("disabled", !this.checked); 
		    $("#bankf").attr("disabled", !this.checked); 
		    $("#allsubmit").prop("disabled",false);
		    $("#err2").hide();
		  
		    
		    if($("#ch8").prop('checked')==true)
		    	{
		    	
		    	//$('#bnk option:selected').remove();
		    	//$('#bnk option:selected').val(this.value='');
				$("#accno1").val(this.value='');
				$("#ifccode1").val(this.value='');
				$("#bkfile").show();
		    	}
		    else
		    	{
		    	//$('option:selected', this).attr('mytag');
		    	//$("#bnk").val(bname);
		    	//	$('#bnk option:selected').remove();
		    	//$('#bnk option:selected').val(this.value=bname).attr("bank");
		    	 
				$("#accno1").val(accontnumbeer);
				$("#ifccode1").val(ifc);
				$("#bkfile").hide();
		    	
		    	}
		    
		    
		});	
		
		
		
		
	
		
		
		
		
		
		
		/* jQuery(document).ready(function($){
		    $cf = $('#umobile');
		    $cf.blur(function(e){
		        phone = $(this).val();
		        phone = phone.replace(/[^0-9]/g,'');
		        if (phone.length != 10)
		        {
		          //  alert('Phone number must be 10 digits.');
		            $('#phonenumber').val('');
		            $('#phonenumber').focus();
		        }
		    });
		}); */
		
		// Wait for the DOM to be ready
		
		//jsofcheckbox
		
		
		
		
		/* 
		$("#chkOne").click(function() {
		    $("#uemailid").attr("disabled", !this.checked); 
		});		
		
		function isChecked(checkbox, motp , umobile) {			
		    document.getElementById(motp).disabled = !checkbox.checked;
		    document.getElementById(umobile).disabled = !checkbox.checked;		   
		};
		
		$("#chkThree").click(function() {
	    	$("#promobile").attr("disabled", !this.checked); 
		});
		
		$("#chkfour").click(function() {
	    	$("#udofb").attr("disabled", !this.checked); 
		});
		 */
		
		
		 function validateForm2()
		{
			
			var rout ="form51";
			
			 $.post( 
	                  "Emp_Edit_Profile",
	                  { 
	                	Routing: rout
	                		                	},
	                  function(data) {
	                	
	                  // alert(data);
	                   var obj = jQuery.parseJSON(data);
	                    	
	                   var Statusa1=obj.Statusa;
	                    	var readhar=obj.reason4;
	                    	//alert("ols reason"+readhar);
	   	             	  if(obj.GetRouting=="form51" && obj.count==0 || Statusa==1002 )
	   	             		  {
	   	             		  
	   	             		  //$("#sucb").show();
	   	             		  }
	   	             	  if( Statusa==1001)
	   	             		  {
	   	             		  
	   	             		 // alert("hi");
	   	             		  $("#failsa").show();
	   	             		$("#err3").hide();
	   	             		  $("#aadharpan").prop('disabled',true);
	   	             	 $("#aadharno").prop("disabled",true);
	   	       			 $("#aadhar").prop("disabled",true);
	   	       			$("#pannumbr").prop("disabled",true);
	   	       			 $("#adhaf").prop("disabled",true);
	   	       			 $("#panf").prop("disabled",true);
	   	       			$("#passportno").prop("disabled",true);
	   	       			 $("#passf").prop("disabled",true);
	   	       			$("#drivinglncno").prop("disabled",true);
	   	             		  }
	                  }
	               );
				
			
		}
		 
		
		
		
		
		</script>
		
		
		
		
		
		<script type="text/javascript">

		/* $(function () {
			  $("#date_picker11").datepicker({ 
			        autoclose: true, 
			        format: 'mm-dd-yyyy',
		            autoclose:true,
		            endDate: "today",
		            maxDate: today
			        todayHighlight: true
			  }).datepicker('update', new Date());
			}); */

			 var today = new Date();
			 $(function() {
				  $( "#date_picker11" ).datepicker({   
					  autoclose:true,
					  format: 'yyyy/mm/dd' ,
		                endDate: "today",
		                maxDate: today});
				
				});  
			
			
				/* var today = new Date();
			 $("#txtfuturedate").datepicker({
				 format: 'mm-dd-yyyy',
	                autoclose:true,
	                endDate: "today",
	                maxDate: today
			}); */
	          /*  $(function () {
	                $('#date_picker11').datetimepicker({maxDate: 0});
	            }); */ 
	      
	            
	          /*   $('#date_picker11').datepicker({
	                format: 'mm-dd-yyyy',
	                autoclose:true,
	                endDate: "today",
	                maxDate: today
	            }).on('changeDate', function (ev) {
	                    $(this).datepicker('hide');
	                });
			 */
			
			


	

	$.ajax({
	    url: 'Bank_Names',
	    dataType: 'json',
	    success: function(data) {
	    	
	  
	 // var b= $("#bnk").val();
	//  alert(b);
	     $.each(data ,function(index,value){
	    	 // alert( value + " is " + value.BANKNAME );
			//$("#bnk").append("<option value="+value.bankname+">"+value.bankname+"</option>");
			
			
			
			
			 $('#bnk').append('<option value="' + value.BANKNAME + '">' + value.BANKNAME + '</option>');
		//	$("#bnk").append(value.bankname);
			
			}); 
	       
	    },
	    error: function(jqXHR, textStatus, errorThrown){
	       // alert('Error: ' + textStatus + ' - ' + errorThrown);
	    }
	});


</script>

<script>
$("#uemailid").prop("disabled",true);
$("#umobile").prop("disabled",true);
$("#promobile").prop("disabled",true);
$("#udofb").prop("disabled",true);
$("#motp").prop("disabled",true);
	

$("#olsotp1").hide();
var ppin=""; var ccpin=" ";
var accontnumbeer=" "; var aadharName1=" "; var aadharnub=" "; var pan=" "; var passnu=" "; var drivl=" ";
var pstate=" "; var pcity=" "; var ccity=" "; var cstate=" "; var bname=" "; var ifc=" ";
var mobile=""; var ols="";var promob="";var dofb=""; var bankn=" ";
var aadharname=" ";var adharno=" "; aadharfile=" "; var panno=" "; var panfile=""; var passport="";
var passfile=""; var drivinglicno=""; var accname=" "; var accno=" "; var ifccode=" "; var bankfile=" ";
var cntry=" "; var St=" "; var cit=" "; var cnty1=" ";var st1=" "; var cit1=" "; var commaddr=" ";
var peraddr1=" "; var peradd2=" "; var peradd3=" "; var peradd4=" ";var totalperadd1=" "; var totaoperadd2=" ";
var commadd1=" "; var commaddr2=" "; var commaddr3=" "; var commaddr4=" "; var totalcomm1=" "; var totalcomm2=" "; var totalcomm3=" ";
$.ajax({
    url: 'Get_emp_list',
    dataType: 'json',
    success: function(data) {
    	
    //alert(data);
        for (var i=0; i<data.length; i++) {
        
        	
        	
        	
        	
           //personal
        	 ols =data[i].personal_email;
        	 mobile= data[i].personal_phone;
        	 promob= data[i].professional_phone;
        	 dofb= data[i].DATEOFBIRTH;
        //per addrss	 
        	 peraddr1=data[i].perm_addr1;
        	 peradd2=data[i].PERMANENTADDRESS2;
        	 peradd3=data[i].PERMANENTADDRESS3;
        	 peradd4=data[i].PERMANENTADDRESS4;
       //commu 	 
        	 commadd1=data[i].comm_addr1;
        	 commaddr2=data[i].COMMUNICATIONADDRESS2;
        	 commaddr3=data[i].COMMUNICATIONADDRESS3;
        	 commaddr4=data[i].COMMUNICATIONADDRESS4;
        	 totalcomm1=commadd1.concat(commaddr2);
        	 totalcomm2=totalcomm1.concat(commaddr3);
        	 totalcomm3=totalcomm2.concat(commaddr4);
        	  totalperadd = peraddr1.concat(peradd2);
        	  totalperadd1= totalperadd.concat(peradd3);
        	  totaoperadd2=totalperadd1.concat(peradd4);
        	  
        	    
        	  
        	 
        	  
        	  
        	    ccity=data[i].COMCITY;
        	    cstate=data[i].COMMSTATE;
        	    pcity=data[i].PCITY;
        	   pstate= data[i].PSTATE;
        	   
        	  ppin= data[i].perm_pincode
        	   
        	   bname= data[i].BANKNAME;
        	   ifc=data[i].IFSC;
        	 
        	  	ccpin=data[i].comm_pincode;
        	  	
        	  
        	//bank
     //alert(bname);
        	  
        	//aadhar
        	aadharName1=data[i].AADHAARNAME;   
        	aadharnub=data[i].AADHAARCARDNO;
        	pan=data[i].pan;
        	passnu=data[i].PASSPORTNO;
        	drivl=data[i].DRIVINGLICENSENO;
        	accontnumbeer=data[i].ACCOUNTNO;
        	var dt=data[i].PCITY;
        	//alert(dt);
   		//alert(data[i].COMMUNICATIONADDRESS4);
          $("#uemailid").val(data[i].personal_email);
         $("#umobile").val(data[i].personal_phone);
            $("#promobile").val(data[i].professional_phone);
             $("#udofb").val(data[i].DATEOFBIRTH);
            $("#ifccode1").val(data[i].IFSC);
            $("#bnk").val(data[i].BANKNAME);
            $("#accno1").val(data[i].ACCOUNTNO);
            $("#aadharno").val(data[i].AADHAARCARDNO);
            $("#pannumbr").val(data[i].pan);
            $("#aadhar").val(data[i].AADHAARNAME);
        	$("#passportno").val(data[i].PASSPORTNO);
        	$("#drivinglncno").val(data[i].DRIVINGLICENSENO);
        	$("#addressp").val(data[i].perm_addr1);
        	$("#addressp1").val(data[i].PERMANENTADDRESS2);
        	$("#addressp2").val(data[i].PERMANENTADDRESS3);
        	$("#addressp3").val(data[i].PERMANENTADDRESS4);
        	$("#address").val(data[i].comm_addr1);
        	$("#address1").val(data[i].COMMUNICATIONADDRESS2);
        	$("#address11").val(data[i].COMMUNICATIONADDRESS3);
        	$("#address111ols").val(data[i].COMMUNICATIONADDRESS4);
        	$("#pin").val(data[i].comm_pincode);
        	$("#pin2").val(data[i].perm_pincode);
        	//$("#state1").val(data[i].COMMSTATE);
        	//$("#city1").val(data[i].COMCITY);
        	//$("#state2").val(data[i].PSTATE);
        	//$("#city2").val(data[i].PCITY);
        	//$("#city2").append(data[i].PCITY);
        	//$("#state2").val(data[i].PSTATE);
        	$("#state2").append('<option value="' + data[i].PSTATE + '"seleted>' + data[i].PSTATE + ' </option>').attr("selected", "selected");
        	$('#state1').append('<option value="' + data[i].COMMSTATE + '"seleted>' + data[i].COMMSTATE + ' </option>').attr("selected", "selected");
        	
        	$("#city1").append('<option value="' + data[i].COMCITY + '"seleted>' + data[i].COMCITY + ' </option>').attr("selected", "selected");
        	$('#city2').append('<option value="' + data[i].PCITY + '"seleted>' +data[i].PCITY + ' </option>').attr("selected", "selected");
        }
    },
    error: function(jqXHR, textStatus, errorThrown){
       // alert('Error: ' + textStatus + ' - ' + errorThrown);
    }
});

/* =============================================form validation===================================================================================== */



 $('#uemailid').keyup(function() {
			$("#err1").hide();
			$("#ols2").hide();
			$("#ols1").hide();
			//$("#ols2").show();
			$("#driver").prop("disabled",true);
			$("#allsubmit").prop("disabled",false);
    		
		});

 

 $('#promobile').keyup(function() {
	// alert("Gfg");
		$("#olsotp12").hide();
		$("#olsotp123").hide();
		$("#showgetotp").hide();
			$("#ols1p").hide();
		
		
	});

//email valid
/* $("#uemailid").change(function()
		 {
	var eml=$("#uemailid").val();
	var regex =  /^[A-Za-z]{3,15}.{1}[a-z0-9]{3,15}@[a-z]{4,7}\.[a-z]{3,4}$/;
	

			//alert(ols);alert(eml);
		if(!regex.test(eml))
			{
			$("#ols1").show();
			//$("#promobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#umobile").prop("disabled",true);
			$("#driver").prop("disabled",true);
			$("#err1").hide();
		
			}
		
		else{
			$("#ols1").hide();
		
		if(ols==eml)
			{
			$("#ols2").show();
			//$("#promobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#umobile").prop("disabled",true);
			$("#driver").prop("disabled",true);
			$("#err1").hide();
			
			}
		else
			{
			$("#err1").hide();
			$("#ols2").hide();
			
			$("#driver").prop("disabled",false);
			$("#promobile").prop("disabled",false);
			$("#udofb").prop("disabled",false);
			$("#umobile").prop("disabled",false);
			$("#driver").prop("disabled",false);
			
			}
		}

		 }); */
//umobile valid	
 $('#umobile').keyup(function() {
			$('#ols7').hide();
			$("#ols12").hide();
			$("#err1").hide();
			$("#ols11").hide();
			
			 $("#motp").prop("disabled",false);
			
			$("#allsubmit").prop("disabled",false);
			 $("#olsotp").hide();
			 $("#olsotp1").hide();
			 $("#olsotp1").hide();
		});

	$("#err").hide();
/* $("#umobile").change(function()
		 {
	var umo=$("#umobile").val();
	 var phoneno1 = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	//  if(inputtxt.value.match(phoneno))
	
//alert(mobile);alert(umo);
		if(umo.length == 0 && mobile==umo)
				{
				
			//	alert("empty");
				
				$("#err1").hide();
				$("#ols12").hide();
				$("#ols11").hide();
				$("#ols7").hide();
				 $("#olsotp1").hide();
				 $("#olsotp").hide();
				 $("#ols8").hide();
				 $("#driver").prop("disabled",false);

				
				}
		else{
			
		if(!phoneno1.test(umo))
			{
			$("#ols11").show();
			//$("#promobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#uemailid").prop("disabled",true);
			$("#driver").prop("disabled",true);
			$("#err1").hide();
			
			
			
			}
		else
			{
			$("#ols11").hide();
			if(mobile==umo)
			{
			
			$("#ols12").show();
			$("#err1").hide();
			//$("#promobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#uemailid").prop("disabled",true);
			 $("#driver").prop("disabled",true);
		//	alert("err");
			}
		else
			{
			$("#err1").hide();
			$("#ols12").hide();
			$("#ols11").hide();
			$("#ols7").show();
			//$("#promobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#uemailid").prop("disabled",true);
			 $("#driver").prop("disabled",true);
			}
			}
		}
		 });
//promobile valid
$('#promobile').keyup(function() {
	$("#err1").hide();
	$("#ols1pro").hide();
	$("#driver").prop("disabled",false);

		});
$("#promobile").change(function()
		 {
	var pumo=$("#promobile").val();
	 var phoneno11 = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
//alert(promob);alert(pumo);
		
		
		if(!phoneno11.test(pumo))
			{
			$("#ols1p").show();
			//$("#umobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#uemailid").prop("disabled",true);
			 $("#driver").prop("disabled",true);
			 $("#err1").hide();
			 $("#ols8").hide();
			}
		else
			{
			$("#ols1p").hide();
		if(promob==pumo)
			{
			$("#ols1pro").show();
			$("#driver").prop("disabled",true);
			$("#err1").hide();
			 $("#ols8").hide();
			//$("#umobile").prop("disabled",true);
			//$("#udofb").prop("disabled",true);
			//$("#uemailid").prop("disabled",true);
			}
		else
			{
			//alert("ok");
			$("#err1").hide();
			$("#ols1pro").hide();
			 $("#driver").prop("disabled",false);
				$("#umobile").prop("disabled",false);
				$("#udofb").prop("disabled",false);
				$("#uemailid").prop("disabled",false);
			
			}
			}

		 });

 *///dofb valid
$('#udofb').keyup(function() {
	$("#err1").hide();
	$("#ols1pro").hide();
	$("#driver").prop("disabled",false);

		});
$("#udofb").change(function()
		 {
	var udofb=$("#udofb").val();
	
//alert(dofb);alert(udofb);
		
		if(udofb==dofb)
			{
			$("#err").show();
		//	alert("err");
			}
		else
			{
			$("#err").hide();
			//alert("ok");
			}
		

		 });
		 
	
function sendOTP() {
	 $("#olsotp1").hide();
	var number = $("#umobile").val();
	var routing="getvalid";
	//alert(number);
	if (number.length == 10 && number != null) {
		
		$("#ols11").hide();
		
		
		$.ajax({
			url : 'Emp_Edit_Profile',
			type : 'POST',
			data : {Routing: routing,
				number:number},
			success : function(response) {
				OTPSTORE=00;
				PMob=0;
				var obj = jQuery.parseJSON(response);
				
	 			//alert("obuleu"+obj);
	 			
	            	if(obj.Code =="000" && obj.GetRouting=="getvalid"){
	            		
	            		 OTPSTORE=obj.OTP;
	            		 PMob=obj.Number;
	            		
	            		 $("#otpvalidation").prop("disabled",false);
	            		 
	            		 $("#motp").prop("disabled",true);
	            		 
	            		 
	            		//alert(OTPSTORE);
	            		 $("#olsotp1").show();
	            		 $("#ols7").hide();
	            		 
	    			}
				
				
				
				
				
				
			}
		});
	} else {
		//alert("hi");
		//$(".error").html('Please enter a valid number!')
		$("#ols11").show();$("#ols7").hide();
		
	}
}	 

// profissinal mobile number

function sendOTP12() {
	 $("#olsotp112").hide();
	var number1 = $("#promobile").val();
	var routing="getvalid";
	//alert(number1);
	if (number1.length == 10 && number1 != null && number1!=promob ) {
		
		$("#ols11").hide();
		
		
		$.ajax({
			url : 'Emp_Edit_Profile',
			type : 'POST',
			data : {Routing: routing,
				number:number1},
			success : function(response) {
				OTPSTORE=00;
				PMob=0;
				var obj = jQuery.parseJSON(response);
				
	 			//alert("obuleu"+obj);
	 			
	            	if(obj.Code =="000" && obj.GetRouting=="getvalid"){
	            		
	            		 OTPSTOREP=obj.OTP;
	            		 PRMob=obj.Number;
	            		
	            		 $("#otpvalidation12").prop("disabled",false);
	            		 $("#motpp12").prop("disabled",true);
	            		 //motpp12
	            		//alert(OTPSTORE);
	            		 $("#olsotp123").show();
	            		 $("#ols7").hide();
	            		 
	            		 $("#showgetotp").hide();
	            		 
	            		 
	    			}
				
				
				
				
				
				
			}
		});
	} else {
		//alert("hi");
		//$(".error").html('Please enter a valid number!')
		$("#ols1p").show();
	}
}	 
		 




		 
		 
   //  Aadhar and pan details
   
   /* -------------------------------------------------form 2------------------------------------------------------- */
   $('#accno1').keyup(function() {
	  $("#err2").hide();
	  $("#olsacc").hide();
	
	$("#ols8").hide();
		$("#allsubmit").prop("disabled",false);

		});
//account number
/* $("#accno1").change(function()
		 {
	
	var accnor=$("#accno1").val();
	
		//alert(accnor);alert(accontnumbeer);
		
		if(accontnumbeer==accnor)
			{
			$("#olsacc").show();
			// $("#bankf").prop("disabled",true);
			// $("#bnk").prop("disabled",true);
			// $("#ifccode1").prop("disabled",true);
			// $("#disab").prop("disabled",true);
			 $("#disab").prop("disabled",false);
			 $("#err2").hide();
			}
		else
			{
			$("#olsacc").hide();
			 $("#disab").prop("disabled",false);
			 $("#bankf").prop("disabled",false);
			 $("#bnk").prop("disabled",false);
			 $("#ifccode1").prop("disabled",false);
			 $("#err2").hide();
			
			}
		

		 });
//bank name
 $('#bnk').keyup(function() {
	  $("#olsacc").hide();
	  $("#err2").hide();
	$("#driver").prop("disabled",false);

		});

$("#bnk").change(function()
		 {
	
	var bnkname=$("#bnk").val();
	
		//alert(bname);alert(bnkname);
		
		if(bnkname==bname)
			{
	
			$("#olsacc").show();
			// $("#bankf").prop("disabled",true);
			// $("#bnk").prop("disabled",true);
			// $("#ifccode1").prop("disabled",true);
			// $("#disab").prop("disabled",true);
			 $("#err2").hide();
			 $("#disab").prop("disabled",false);
			}
		else
			{
			$("#olsacc").hide();
			 $("#disab").prop("disabled",false);
			 $("#bankf").prop("disabled",false);
			 $("#bnk").prop("disabled",false);
			 $("#ifccode1").prop("disabled",false);
			 $("#err2").hide();
			
			}
		

		 });

//ifcs code
 $('#ifccode1').keyup(function() {
	  $("#olsacc").hide();
	$("#driver").prop("disabled",false);

		});

$("#ifccode1").change(function()
		 {
	
	var ifcsc=$("#ifccode1").val();
	
		//alert(ifcsc);alert(bnkname);
		
		if(ifcsc==ifc)
			{
			$("#olsacc").show();
			 $("#err2").hide();
			// $("#bankf").prop("disabled",true);
			// $("#bnk").prop("disabled",true);
			// $("#ifccode1").prop("disabled",true);
			 $("#disab").prop("disabled",false);
			}
		else
			{
			$("#olsacc").hide();
			 $("#err2").hide();
			 $("#disab").prop("disabled",false);
			 $("#bankf").prop("disabled",false);
			 $("#bnk").prop("disabled",false);
			 $("#ifccode1").prop("disabled",false);
			
			}
		

		 });

 */


//aadhar and pan
/* ------------------------------------------------------AADHAR AND PAN--------------------------------------------------------------------------------- */

 $('#aadhar').keyup(function() {
	  $("#olsacc").hide();
	  $("#err3").hide();
	  $("#olsadhr").hide();
	  $("#aadharpan").prop("disabled",false);
		});
		 
$("#aadhar").change(function()
		 {
	
	var aadhrno= $("#aadhar").val();
	

		
	
	
		if(aadharName1==aadhrno)
			{
			
			 $("#olsadhr").show();
		
			$("#err3").hide();
		
		
		
			}
		else
			{
		

			 $("#olsadhr").hide();
			
			 $("#err3").hide();
			 
			 
			}
		

		 });
 
	//aadhar number
	 $('#aadharno').keyup(function() {
	  $("#olsadhrno").hide();
	  $("#err3").hide();
	  $("#invalidaadha").hide();
	  $("#aadharpan").prop("disabled",false);
		});
		 
	
	$("#aadharno").change(function()
			 {
		
		var aadhr= $("#aadharno").val();
		
	
			if(aadhr.length==12)
				{
			if(aadhr===aadharnub)
				{
				
				 $("#olsadhrno").show();
					
				
				 
				 $("#err3").hide();
				
				
				}
			else
				{
				
				$("#err3").hide();
				$("#olsadhrno").hide();
				
				}
				}
			else
				{
				$("#invalidaadha").show();
				}

			 });
		 
	//pannumbr	 
		 
		 $('#pannumbr').keyup(function() {
	  $("#olspan").hide();
	  $("#err3").hide();
	  $("#err2").hide();
	  $("#ols8").hide(); $("#pannumberv").hide();
	  
		$("#allsubmit").prop("disabled",false);
		});
	
		 $("#pannumbr").change(function()
			 {
		//alert("obuklesu")
		var pannum= $("#pannumbr").val();
			
			if(pannum.length==10)
				{
			if(pannum===pan)
				{
				$("#olspan").show();
				$("#pannumberv").hide();
				$("#err3").hide();
				
				}
			else
				{
				$("#olspan").hide();
				$("#pannumberv").hide();
				 $("#err3").hide();
				}
				}
			else
				{
				$("#pannumberv").show();
				}
			

			 });
		 
	
	
	 $('#passportno').keyup(function() {
	  $("#olspass").hide();
	  $("#err3").hide();
	  $("#err2").hide();
	  $("#ols8").hide(); 
	  $("#passvalidation").hide();
		$("#allsubmit").prop("disabled",false);
		});
	
	 $("#passportno").change(function()
			 {
		 $("#passvalidation").hide();
				var passNUM= $("#passportno").val();
		
					//alert(passNUM.length);
				if(passNUM.length==8)
				{
			
				$("#passvalidation").hide();
				if(passnu===passNUM)
				{
				
				
				$("#olspass").show();
				$("#err3").hide();
				$("#passvalidation").hide();
				 $("#err2").hide();
				}
			else
				{
				$("#olspass").hide();
				$("#err3").hide();
				$("#passvalidation").hide();
				 $("#aadharpan").prop("disabled",false);
				
				}
				}
			else
				{
				
				//alert("hi");
					$("#passvalidation").show();
				}
			
			 });
	
	//drivinglncno
	 $('#drivinglncno').keyup(function() {
	  $("#olsDriv").hide();
	  $("#err3").hide();
	  $("#err2").hide(); $("#drivringlic").hide();
	  $("#ols8").hide();
		
		$("#allsubmit").prop("disabled",false);
	  
		});
 $("#drivinglncno").change(function()
			 {
		//alert("obuklesu")
		var drivlcns= $("#drivinglncno").val();
		
//alert(drivl);
	//alert(drivlcns);
			if(drivlcns.length==13)
				{
				$("#drivringlic").hide();
				if(drivlcns===drivl)
				{
				$("#olsDriv").show();
				$("#err3").hide();
				
				}
			else
				{
				$("#olsDriv").hide();
				$("#err3").hide();
				
				$("#aadharpan").prop("disabled",false);
				}
				}
			else
				{
				$("#drivringlic").show();
				}
			
			 });
	
 $('#adhaf').keyup(function() {
	 
	  $("#err3").hide();
	  $("#aadharpan").prop("disabled",false);
	  
		});
	
 			$("#adhaf").change(function()
					 {
	 
					var aafil=$("#adhaf").val();
					
					//alert("hello");
					//alert(aafil);
					
					if(aafil=='')
						{
						//$("#aadharpan").prop("disabled",true);
						//$("#err3").hide();
						//$("#olsadhrno").hide();
						}
					else
						{
						//alert("ree")
						//$("#err3").hide();
						//$("#olsadhrno").hide();
						//$("#Afile").hide();
						$("#allsubmit").prop("disabled",false);
						//$("#ols8").hide();
						}
					
					
				

		 });
 			
 			
 			
 			$("#panf").change(function()
					 {
	 
					var pfil=$("#panf").val();
					
					if(pfil=='')
						{
						
					//	$("#err3").hide();
						//$("#olspan").hide();
						}
					else
						{
						//$("#err3").hide();
						//$("#olspan").hide();
						//$("#pnfile").hide();
						//$("#allsubmit").prop("disabled",false);
						//$("#ols8").hide();
						}
					
		 });
		 
 			 $('#passf').keyup(function() {
 				 
				  $("#err3").hide();
				//  $("#aadharpan").prop("disabled",false);
				  
					});
 			
 			$("#passf").change(function()
					 {
	 
 				//alert("hi");
 				
 				
					var pafil=$("#passf").val();
					
					if(pafil=='')
						{
					//	$("#err3").hide();
					
						}
					else
						{
						//alert("ree")
						//$("#aadharpan").prop("disabled",false);
						//$("#err3").hide();
						//$("#olspass").hide();
						//$("#ptfile").hide();
						//$("#ols8").hide();
						//$("#allsubmit").prop("disabled",false);
						}
				 });	
 			
 			
		 
</script>


<!-- ---------------------------------------PERSONAL DETAILS------------------------------------------------------ -->
<script type = "text/javascript" >

var email=" ";mob=" ";prom=" ";dofbr=" ";
         $(document).ready(function() {
			
            $("#driver").click(function(event){
				
            	
            	 email = $("#uemailid").val();
            	 mob = $("#umobile").val();
            	 prom = $("#promobile").val();
            	 dofbr = $("#udofb").val();
            	var rout ="form1";
            
            	
            	
            	
            	if(mobile==mob && promob==prom && ols==email && dofbr==dofb )
            		{
            		$("#driver").prop("disabled",true);
            		$("#err1").show();
            	
            		}
            	
            	
            	else{
            	
            		if($("#ols7").is(":visible") || $("#olsotp1").is(":visible") || $("#olsotp").is(":visible"))
                	{
                	//	alert("visible");
                		$("#ols8").show();
                	}
            		else{
            		
            		$("#err1").hide();
            		$("#ols8").hide();
            		$("#driver").prop("disabled",false);
            	
            		
            		
            		
            	if(dofbr==dofb)
    			{
            		dofbr=" ";
    			}
    		
            
            	if(ols==email)
    			{
            		email=" ";
    			}
    		
            	if(promob==prom)
    			{
            		prom=" ";
    			}
    		
            	if(mobile==mob)
    			{
            		mob=" ";
    			
    			}
    		
           
            	
            	
               $.post( 
                  "Emp_Edit_Profile",
                  { email1: email,
                	Routing: rout,
                	mobile:mob,
                	promobile:prom,
                	dateofb:dofbr},
                  function(data) {
                	
                 //  alert(data);
                   var obj = jQuery.parseJSON(data);
                    	/*  $("#SuccessMsg").modal("show");
   	             	  setTimeout(function(){
   	             		  $("#SuccessMsg").modal("hide"); 
   	             	  },3000) */
                    	 
   	             	  
   	             	 // alert("siva"+obj.Statusp);
   	             	  if(obj.GetRouting=="form1" && obj.Statusp==0)
   	             		  {
   	             		//  alert("hi");
   	             		  $("#succ").show();
   	             		// $("#fails").show();
  	             		// $("#succ").hide();
  	             		$("#err1").hide();
  	             		$("#uemailid").prop("disabled",true);
  	              	 $("#umobile").prop("disabled",true);
  	              	 $("#promobile").prop("disabled",true);
  	              	 $("#udofb").prop("disabled",true);
  	              	$("#driver").prop("disabled",true);
   	             		  }
   	             	  else{
   	             	//  $("#succ").show();
   	             	  }
                  }
               );
			
            		}
            	}
               
            });
				
         });
         
         
         
    /* function validateFormOls()
    {
    	
    //	alert("hi");
    	
    	
    	var rout ="form1";
    	 $.post( 
                 "Emp_Edit_Profile",
                 { 
               	Routing: rout
               },
                 function(data) {
               	
                //  alert(data);
                  var obj = jQuery.parseJSON(data);
                     $("#SuccessMsg").modal("show");
  	             	  setTimeout(function(){
  	             		  $("#SuccessMsg").modal("hide"); 
  	             	  },3000) 
                   	 
  	             	  if(obj.GetRouting=="form1" && obj.count==1)
  	             		  {
  	             		  $("#fails").show();
   	             		 $("#succ").hide();
   	             		$("#err1").hide();
   	             		$("#uemailid").prop("disabled",true);
   	              	 $("#umobile").prop("disabled",true);
   	              	 $("#promobile").prop("disabled",true);
   	              	 $("#udofb").prop("disabled",true);
   	              	$("#driver").prop("disabled",true);
  	             		  }
  	             	
                 }
              );
    	
    	
    }
          */
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
 
        
      </script>
<!-- ---------------------------------------COMMUNICATION ADDRESS------------------------------------------------------ -->
<script type = "text/javascript" >




         $(document).ready(function() {
			
            $("#commu").click(function(event){
				
            //	alert("hiols");
            	
            	var country = $("#country1").val();
            	var state = $("#state1").val();
            	var city11 = $("#city1").val();
            	var addressI = $("#address").val();
            	

            	var address1I = $("#address1").val();
            	var address11I = $("#address11").val();
            	var address111I = $("#address111ols").val();
            	
            	var pin =  $("#pin").val();
            	var rout ="form2";
				
				if(state==cstate && city11==ccity && commadd1==addressI && commaddr2==address1I && commaddr3==address11I && commaddr4==address111I )
					{
					//alert("hiolstryty");
					$("#editerr").show();
						$("#commu").prop("disabled",true);
					}
				else{
					
					$("#commu").prop("disabled",false);
					$("#editerr").hide();
					
            	if(state==cstate)
            	{
            		state=" ";
            	}
            	if(city11==ccity)
            		{
            		city11=" ";
            	
            		} 
            	if(commadd1==addressI)
            	{
            		addressI="  ";
            	}
            	if(commaddr2==address1I)
            		{
            		address1I="  ";
            	
            		}
            	if(commaddr3==address11I)
            		{
            		address11I=" ";
            		}
            	if(commaddr4==address111I)
        		{
            		address111I=" ";
        		}
            	
        //  alert(addressI);
            	
               $.post( 
                  "Emp_Edit_Profile",
                  { country: country,
                	Routing: rout,
                	state:state,
                	city1:city11,
                	addressO12:addressI,
                	addressA:address1I,
                	address12:address11I,
                	addressB:address111I,
                	
                	pin:pin},
                  function(data) {
                		   var obj1 = jQuery.parseJSON(data);
                		 //  alert(obj1.Statusc);
                		   
                		if(obj1.GetRouting=="form2" && obj1.Statusc==1001 )
 	             		  {
                			 $("#fails1").show();
                       		 $("#succ1").hide();
                       		$("#editerr").hide();
                       		$("#country1").prop("disabled",true);
                        	 $("#state1").prop("disabled",true);
                        	 $("#city1").prop("disabled",true);
                        	 $("#address").prop("disabled",true);
 	             		 
 	             		  }
                		else{
                			 $("#succ1").show();
                			 $("#country1").prop("disabled",true);
                        	 $("#state1").prop("disabled",true);
                        	 $("#city1").prop("disabled",true);
                        	 $("#address").prop("disabled",true);
                        	
                        	 $("#address").prop("disabled",true);
                        	 $("#address1").prop("disabled",true);
                        	 $("#address11").prop("disabled",true);
                        		 $("#address111ols").prop("disabled",true);
                        		 $("#address111").prop("disabled",true);
                        		 
                        		 $("#pin").prop("disabled",true);
                        		 $("#commu").prop("disabled",true);
                		}
 	             	
                  }
               );
				
               
               
					}
				
               
               
            });
				
         });
         
         
        /*  function validateFormOls11()
         {
        	 
        		var rout ="form2";
        	 $.post( 
                     "Emp_Edit_Profile",
                     {
                   	Routing: rout
                   	
                   	
                  },
                     function(data) {
                   		   var obj1 = jQuery.parseJSON(data);
                   		if(obj1.GetRouting=="form2" && obj1.count==1 )
    	             		  {
    	             		  
                   		 $("#fails1").show();
                   		 $("#succ1").hide();
                   		$("#editerr").hide();
                   		$("#country1").prop("disabled",true);
                    	 $("#state1").prop("disabled",true);
                    	 $("#city1").prop("disabled",true);
                    	 $("#address").prop("disabled",true);
                    	

                    	 $("#address1").prop("disabled",true);
                    	 $("#address11").prop("disabled",true);
                    		 $("#address111").prop("disabled",true);
                   		 
                    		 $("#commu").prop("disabled",true);
                   		 
                   		 
    	             		  }
    	             	
                     }
                  );
        	 
        	 
         }
         
         
          */
         
         
         
          $('#passf').keyup(function() {
				 
			  $("#err3").hide();
			//  $("#aadharpan").prop("disabled",false);
			  
				});
         
         
         
         
         
         
         
         
         
        
         
         
         
         
         
         
      </script>

<!-- ------------------------------------------------PERMANENT ADDRESS ------------------------------------------------------ -->

<script type = "text/javascript" >
         $(document).ready(function() {
			
            $("#PERMANENT").click(function(event){
				
           
            	var country2 = $("#country2").val();
            	var state2 = $("#state2").val();
            	
            
            	var city2 = $("#city2").val();
            	
            	
            	var addresso2 = $("#addressp").val();
            	var address12 = $("#addressp1").val();
            	
            	var address102 = $("#addressp2").val();
            	
            	var address132 = $("#addressp3").val();
            	
            	var pin2 =  $("#pin2").val(); 
            	var rout ="form3";
            	
            	
            	
            	if(state2==pstate && city2==pcity && addresso2==peraddr1 && address12==peradd2 && address102==peradd3 && address132==peradd4)
            	{
            		
            		//alert("hi");
            		$("#PERMANENT").prop("disabled",true);
            		$("#editerr1").show();
            		
            	}
            	
            	else{
            		$("#PERMANENT").prop("disabled",false);
            		$("#editerr1").hide();
            	if(state2==pstate )
        		{
        		state2=" ";
        		}
        	if(city2==pcity)
    		{
        		city2=" ";
    		} 
        	 if(addresso2==peraddr1)
        		{
        		 addresso2=" ";
        		}
        	if(address12==peradd2)
    		{
        		address12=" ";
    		}
        	if(address102==peradd3)
    		{
        		address102=" ";
    		}
        	
        	if(address132==peradd4)
    		{
        		address112=" ";
    		}
            	
            	
               $.post( 
                  "Emp_Edit_Profile",
                  { country2: country2,
                	Routing: rout,
                	state2:state2,
                	city2:city2,
                	addressO:addresso2,
                	addressB:address12,
                	addressS:address102,
                	addressL:address132,
                	pin2:pin2},
                  function(data) {
                		 var obj2 = jQuery.parseJSON(data);
                 		if(obj2.GetRouting=="form3" && obj2.Statusper==1001 )
  	             		  {
                 			  
                 			
                 			  
  	             		
  	             		  }
                 		else
                 			{
                 			 $("#fails2").hide();
                			 $("#editerr1").hide();
                			  $("#succ2").show();
                			 $("#country2").prop("disabled",true);
                        	 $("#state2").prop("disabled",true);
                        	 $("#city2").prop("disabled",true);
                        	 
                        	
                        	 $("#addressp").prop("disabled",true);
                        	$("#addressp1").prop("disabled",true);
                        	
                        	 $("#addressp2").prop("disabled",true);
                        	
                        	 $("#addressp3").prop("disabled",true);
                        	
                        	  $("#pin2").prop("disabled",true);
                        	  $("#fails2").prop("disabled",true);
                        	  $("#PERMANENT").prop("disabled",true);
                 			
                 			}
                 		
                  }
               );
               
            	}
					
            });
				
         });
         
         
        /*  function validateFormOls111()
         {
        	 
        	 //alert("hi");
        	 var rout ="form3";
        	 
        	 $.post( 
                     "Emp_Edit_Profile",
                     { 
                   	Routing: rout,
                   },
                     function(data) {
                   		 var obj2 = jQuery.parseJSON(data);
                    		if(obj2.GetRouting=="form3" && obj2.count==1 )
     	             		  {
                    			 $("#fails2").show();
                    			 $("#editerr1").hide();
                    			 $("#country2").prop("disabled",true);
                            	 $("#state2").prop("disabled",true);
                            	 $("#city2").prop("disabled",true);
                            	 
                            	
                            	 $("#addressp").prop("disabled",true);
                            	$("#addressp1").prop("disabled",true);
                            	
                            	 $("#addressp2").prop("disabled",true);
                            	
                            	 $("#addressp3").prop("disabled",true);
                            	
                            	  $("#pin2").prop("disabled",true);
                            	  $("#fails2").prop("disabled",true);
                            	  $("#PERMANENT").prop("disabled",true);
                            	  
     	             		  }
     	             	  
                     }
                  );
        	 
         }
          */
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
      </script>

<!-- ---------------------------mobile validation-------------------------------- -->


<script type="text/javascript">

/* aadhar&pan bankD commadd peraddr
PERSONAL DETAILS
Communication Address
Permanent Address

AADHAR & PAN DETAILS
BANK DETAILS */


function getIndex() {
 var filed1= $("#ols").val();
 
// alert(filed1);
 
 if(filed1=="AADHAR & PAN DETAILS" )
{

$("#aadhar123").show();

}
 else if(filed1=="PERSONAL DETAILS")
	 {
	 $("#personalD").show();
	 }
 else if(filed1=="Communication Address")
	 {
	 $("#commadd").show();
	 }
 else if(filed1=="Permanent Address")
	 {
	 $("#peraddr").show();
	 }
 else if(filed1=="BANK DETAILS")
	 {
	 $("#bankD").show();
	 }
 else{
	 alert("please select ");
 }
 
}

//FORM 1

</script>

		
<!-- ------------------------------------------States nad citys by country------------------------------------------------------------------- -->		
		
		
		
	<script type="text/javascript">
	
	
	
	$("#country1").change(function(){
		var countryid=$("#country1").val();    
		var routing ="getStates";
		$("#editerr").hide();
	 	$("#commu").prop("disabled",false);
       	$("#editerr").hide();
		//alert(countryid);
		$.ajax({
			type: "POST",
		    url: 'GetStates',
		    dataType: 'json',
		    data: {Routing:routing,countryId:countryid},
		    success: function(data) {
		    	
		  //  alert(data);
		   		      $('#state1 option:selected').remove();
		   		  $("#state1").append("<option>--Select--</option>");
		    	 $.each(data ,function(index,value){
		 	    	
		    		 //To reset cities
			    	// $("#state1").append("<option>--Select--</option>");
			    	 
		 			//$("#state1").append("<option value="+value.LOCATIONID+">"+value.NAME+"</option>");
					$('#state1').append('<option value="' + value.NAME + '">' + value.NAME + '</option>');

		 			
		 			}); 
		       
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		        alert('Error: ' + textStatus + ' - ' + errorThrown);
		    }
		});

	}); 
	
	
	
	$("#state1").change(function(){
		var stateid=$("#state1").val();
		$("#editerr").hide();
	 	$("#commu").prop("disabled",false);
       	$("#editerr").hide();
		var routing1 ="getcities";
		//alert(stateid);
		$.ajax({
			type: "POST",
		    url: 'GetStates',
		    dataType: 'json',
		    data: {Routing:routing1,stateid:stateid},
		    success: function(data) {
		    	
		 //   alert(data);
		      $('#city1 option:selected').remove();
		      
		     $.each(data ,function(index,value){
		    	
		    	
		    	 
		    	// $("#city1").remove();
				//$("#city1").append("<option value="+value.LOCATIONID+">"+value.NAME+"</option>");
				$('#city1').append('<option value="' + value.NAME + '">' + value.NAME + '</option>');

				
				
				}); 
		       
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		        alert('Error: ' + textStatus + ' - ' + errorThrown);
		    }
		});
	});

	$("#country2").change(function(){
		var countryid=$("#country2").val();    
		var routing ="getStates";
		
	//	alert(countryid);
		$.ajax({
			type: "POST",
		    url: 'GetStates',
		    dataType: 'json',
		    data: {Routing:routing,countryId:countryid},
		    success: function(data) {
		    	
		    //alert(data);
		     $('#state2 option:selected').remove();
		     $("#state2").append("<option>--Select--</option>");
		     $.each(data ,function(index,value){
		    	
		    	// $('#state2').append('<option value="">' + emptyMessage + '</option>');
				//$("#state2").append("<option value="+value.LOCATIONID+">"+value.NAME+"</option>");
				$('#state2').append('<option value="' + value.NAME + '">' + value.NAME + '</option>');
				
				}); 
		       
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		        alert('Error: ' + textStatus + ' - ' + errorThrown);
		    }
		});

	}); 
	
	
	
	$("#state2").change(function(){
		var stateid=$("#state2").val();
		
		//alert(stateid);
		
		var routing1 ="getcities";
		//alert(stateid);
		$.ajax({
			type: "POST",
		    url: 'GetStates',
		    dataType: 'json',
		    data: {Routing:routing1,stateid:stateid},
		    success: function(data) {
		    	
		  //  alert(data);
		     $('#city2 option:selected').remove();
		     $.each(data ,function(index,value){
		    	// $("#city2 option").val();
		    	// $('#city2').append('<option value="' + value.NAME + '"></option>');
				$('#city2').append('<option value="' + value.NAME + '">' + value.NAME + '</option>');
				
				
				}); 
		       
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		      //  alert('Error: ' + textStatus + ' - ' + errorThrown);
		    }
		});
	});

	
	
	
	
	
	 /* function validateForm1()
		{
			
	
		// alert("hello");
			var rout ="form41";
			
			 $.post( 
	                  "Emp_Edit_Profile",
	                  { 
	                	Routing: rout
	                		                	},
	                  function(data) {
	                	
	                  // alert(data);
	                   var obj = jQuery.parseJSON(data);
	                     $("#SuccessMsg").modal("show");
	   	             	  setTimeout(function(){
	   	             		  $("#SuccessMsg").modal("hide"); 
	   	             	  },3000) 
	                    	 
	   	             	var accnor=$("#accno1").val();//accontnumbeer
	   	  			 var bnkname=$("#bnk").val();//bname
	   	  			 var ifcsc=$("#ifccode1").val();//ifc
	   	  		// alert(accnor); alert(bnkname); alert(ifcsc);alert(accontnumbeer);alert(bname);alert(ifvc);
	   	  		
	   	             	  
	   	             	  
	   	             	  
	   	             	  
	   	             	  if(obj.GetRouting=="form41" && obj.count==0)
	   	             		  {
	   	             		  
	   	             		
	   	             		 	   	             		  
	   	             		  
	   	             		  }
	   	             	  if(obj.count==1)
	   	             		  {
	   	             		  $("#failsb").show();
	   	             		 $("#err2").hide();
	   	             		$("#accno1").prop("disabled",true);
	   	             		$("#bnk").prop("disabled",true);
	   	             		$("#ifccode1").prop("disabled",true);
	   	             		$("#bankf").prop("disabled",true);
	   		   	             	  
	   	             		  }
	                  }
	               );
				
			 
		 
				
			// form.myButton.disabled = true;
			    return true;
			 
				
		
			
		}
	
 */	
	 
	 $("#bankf").change(function()
			 {

			var pfil=$("#bankf").val();
			
			//alert("hello");
			//alert(aafil);
			
			if(pfil=='')
				{
				
			//	$("#aadharpan").prop("disabled",true);
				$("#err3").hide();
				$("#olspan").hide();
			//	$("#disab").prop("disabled",true);
			$("#bkfile").show();
				}
			else
				{
				$("#err3").hide();
				$("#olspan").hide();
				 $("#disab").prop("disabled",false);
					$("#bkfile").hide();
					$("#ols8").hide();
					$("#allsubmit").prop("disabled",false);
				//$("#aadharpan").prop("disabled",false);
				}
			
			
		

 });
	 
	 
	 $("#disab").click(function()
			 {
		
		 
		var accnor=$("#accno1").val();
		
			//alert(accnor);alert(accontnumbeer);
			
	  			 var bnkname=$("#bnk").val();//bname
	  			 var ifcsc=$("#ifccode1").val();//ifc
	  			 var bfl=$("#bankf").val();
			if(accontnumbeer==accnor || bnkname==bname || ifcsc==ifc || bfl=='' )
				{
				$("#err2").show();
				 //$("#err2").show();

				 $("#disab").prop("disabled",true);
				}
			
			else
						{
					//	alert("dfgg");
						$("#disab").prop("disabled",false);
						}
					
			
			
		/*  if(accontnumbeer==accnor)
				{
				$("#err2").hide();
				 $("#disab").prop("disabled",true);
				
				}
			 if(bnkname==bname)
			{
			$("#err2").hide();
			 $("#disab").prop("disabled",true);
			
			}if(ifcsc==ifc )
			{
				$("#err2").hide();
				 $("#disab").prop("disabled",true);
				
				}
			 if(bfl==' ' )
			{
				$("#err2").hide();
				 $("#disab").prop("disabled",true);
				
				} */
			

			 });
	
	 
	
	 $("#aadharpan").click(function()
			 {
		
	  			var aadhrno= $("#aadhar").val();//aadharName1
	  			var aadhr= $("#aadharno").val();//aadharnub
	  			var pannum= $("#pannumbr").val();//pan
	  			var passNUM= $("#passportno").val();///passnu
	  			var drivlcns= $("#drivinglncno").val();//drivl
	  			var aafil=$("#adhaf").val();
	  			var pfil=$("#panf").val();
	  			var pafil=$("#passf").val();
			if(aadhrno==aadharName1 && aadhr==aadharnub && pannum==pan && passNUM==passnu && drivlcns==drivl )
				{
				$("#err3").show();
				$("#failsa").hide();
			
				 $("#aadharpan").prop("disabled",true);
				}
			else
				{
				$("#err3").hide();
				 $("#aadharpan").prop("disabled",false);
				
				}
			

			 });
	 
	 
	 $('#otpvalidation').keyup(function() {
			$('#olsotp').hide();
		});
	 
	 
	 $("#otpvalidation").change(function(){

		 
		 
		 
		 
		 
			//alert("hi"+OTPSTORE);
			
			var otpvl=$("#otpvalidation").val();    
				
			//alert(otpvl);
			
			
			
			var Pm= $("#umobile").val();
			
			
			
			
			if(otpvl===OTPSTORE && PMob==Pm)
				{
				//alert("right!");
				$("#olsotp").hide();
				//$("#uemailid").prop("disabled",false);
				//$("#promobile").prop("disabled",false);
				//$("#udofb").prop("disabled",false);
				$("#umobile").prop("disabled",false);
				$("#allsubmit").prop("disabled",false);
				$("#motp").prop("disabled",true);
				$("#otpvalidation").prop("disabled",true);
				
				$("#err1").hide();
				$("#olsotp1").hide();
				$("#ols8").hide();
				}
			else
				{
				//alert("wrong!");
					$("#olsotp1").hide();
				$("#olsotp").show();
			//	$("#uemailid").prop("disabled",true);
			//	$("#promobile").prop("disabled",true);
				//$("#udofb").prop("disabled",true);
				//$("#umobile").prop("disabled",true);
				//$("#driver").prop("disabled",true);
				$("#err1").hide();
				
				}
			

			}); 
	 
	 
	 
	 
	 
	 
	 
	 $("#otpvalidation12").change(function(){

			var otpvl=$("#otpvalidation12").val();    
			
			var Pm= $("#promobile").val();
			
			if(otpvl===OTPSTOREP && PRMob==Pm)
				{
			
				$("#olsotp123").hide();
				$("#promobile").prop("disabled",false);
				$("#allsubmit").prop("disabled",false);
				$("#motpp12").prop("disabled",true);
				$("#otpvalidation12").prop("disabled",true);
				$("#err1").hide();
				$("#olsotp12").hide();
				$("#ols8").hide();
				}
			else
				{
				$("#olsotp12").show();
				$("#olsotp123").hide();
				$("#err1").hide();
				
				}
			

			}); 
	 
	 
	 
	 
	// var idols=${successefull};
	 
	 
	// alert(idols);
	 
	</script>
		
		
		
		<script type="text/javascript">
		
		
		var rout ="form1";
   	 /* $.post( 
                "Emp_Edit_Profile",
                { 
              	Routing: rout
              },
                function(data) {
              	
               // alert(data);
                 var obj = jQuery.parseJSON(data);
                // alert("siva"+obj.reason1);
                
                 $("#aadhar123").hide();
				 $("#personalD").hide();
				  $("#commadd").hide();
				   $("#peraddr").hide();
				    $("#bankD").hide();
                
				    $("#aadhar123").hide();
                
                
                
                
                
                 var re1=obj.reason1;
 	             	  if(obj.GetRouting=="form1" && obj.Statusp==1001 )
 	             		  {
 	             		  $("#fails").show();
  	             		 $("#succ").hide();
  	             		$("#err1").hide();
  	             		$("#uemailid").prop("disabled",true);
  	              	 $("#umobile").prop("disabled",true);
  	              	 $("#promobile").prop("disabled",true);
  	              	 $("#udofb").prop("disabled",true);
  	              	$("#driver").prop("disabled",true);
 	             		  }
 	             	  else
 	             		  {
 	             		//  alert("reason1");
 	             		$("#fails").hide();
 	             		$("#reason1").val(re1);
 	             		 $("#succ").hide();
 	             		$("#err1").hide();
 	             		$("#uemailid").prop("disabled",false);
 	              	 $("#umobile").prop("disabled",false);
 	              	 $("#promobile").prop("disabled",false);
 	              	 $("#udofb").prop("disabled",false);
 	              	$("#driver").prop("disabled",false);
 	             		  
 	             		  
 	             		  }
 	             	  
 	             	  
 	             	
                }
             ); */
	var backStatus=0;	
	//all details submitted list	
   	var rout ="form41";
	
	 $.post( 
             "Emp_Edit_Profile",
             { 
           	Routing: rout
           		                	},
             function(data) {
           	
            //  alert(data);
              var obj = jQuery.parseJSON(data);
              
	             	// alert(obj.GetRouting);
	             //	 alert(obj.Statusb);
            			  $("#uemailid").prop("disabled",true);
	  	              	 $("#umobile").prop("disabled",true);
	  	              	 $("#promobile").prop("disabled",true);
	  	              	 $("#udofb").prop("disabled",true);
	             	  if(obj.GetRouting=="form41" && obj.Statusb==1001)
	             		  {
	             		  
	             		 backStatus=obj.Statusb;
	             		  
	             		 $("#failsb").show();
	             		 $("#err2").hide();
	             		$("#accno1").prop("disabled",true);
	             		$("#bnk").prop("disabled",true);
	             		$("#ifccode1").prop("disabled",true);
	             		$("#bankf").prop("disabled",true);
	             		$("#disab").prop("disabled",true);
	             		$("#uemailid").prop("disabled",true);
	  	              	 $("#umobile").prop("disabled",true);
	  	              	 $("#promobile").prop("disabled",true);
	  	              	 $("#udofb").prop("disabled",true);
	  	              	$("#driver").prop("disabled",true);
	  	              $("#country2").prop("disabled",true);
                 	 $("#state2").prop("disabled",true);
                 	 $("#city2").prop("disabled",true);
                 	 
                 	
                 	 $("#addressp").prop("disabled",true);
                 	$("#addressp1").prop("disabled",true);
                 	
                 	 $("#addressp2").prop("disabled",true);
                 	
                 	 $("#addressp3").prop("disabled",true);
                 	
                 	  $("#pin2").prop("disabled",true);
                 	  $("#fails2").prop("disabled",true);
                 	  $("#PERMANENT").prop("disabled",true);             		  
                 	 $("#country1").prop("disabled",true);
                	 $("#state1").prop("disabled",true);
                	 $("#city1").prop("disabled",true);
                	 $("#address").prop("disabled",true);
                	
                	 $("#address").prop("disabled",true);
                	 $("#address1").prop("disabled",true);
                	 $("#address11").prop("disabled",true);
                		 $("#address111ols").prop("disabled",true);
                		
                		 
                		 $("#pin").prop("disabled",true);
                		 $("#commu").prop("disabled",true);
                		 $("#aadharpan").prop('disabled',true);
                    	 $("#aadharno").prop("disabled",true);
              			 $("#aadhar").prop("disabled",true);
              			$("#pannumbr").prop("disabled",true);
              			 $("#adhaf").prop("disabled",true);
              			 $("#panf").prop("disabled",true);
              			$("#passportno").prop("disabled",true);
              			 $("#passf").prop("disabled",true);
              			$("#drivinglncno").prop("disabled",true);
              			
              			$("#ch5").prop('disabled',true);
              			$("#ch6").prop('disabled',true);
              			$("#ch7").prop('disabled',true);
              			$("#ch8").prop('disabled',true);
              			$("#ch11").prop('disabled',true);
              			$("#chkTwo").prop('disabled',true);
              			$("#chkThree").prop('disabled',true);
              			$("#chkfour").prop('disabled',true);
              			$("#ch9").prop('disabled',true); 
						$("#ch10").prop('disabled',true); 
						 $("#ch12").prop('disabled',true);
						 $("#btn2").prop('disabled',true);
						 
              		
              			
	             		  }
	             	  else{
	             		  
	             	  }
             }
          );
		
	 
	 var rout ="form3";
	 
	/*  $.post( 
             "Emp_Edit_Profile",
             { 
           	Routing: rout,
           },
             function(data) {
           		 var obj2 = jQuery.parseJSON(data);
           		// alert(obj.reason2);
            		if(obj2.GetRouting=="form3" && obj2.Statusper==1001 )
	             		  {
            			 $("#fails2").show();
            			 $("#editerr1").hide();
            			 $("#country2").prop("disabled",true);
                    	 $("#state2").prop("disabled",true);
                    	 $("#city2").prop("disabled",true);
                    	 
                    	
                    	 $("#addressp").prop("disabled",true);
                    	$("#addressp1").prop("disabled",true);
                    	
                    	 $("#addressp2").prop("disabled",true);
                    	
                    	 $("#addressp3").prop("disabled",true);
                    	
                    	  $("#pin2").prop("disabled",true);
                    	  $("#fails2").prop("disabled",true);
                    	  $("#PERMANENT").prop("disabled",true);
                    	  
	             		  }
	             	  
             }
          ); */
	 var rout ="form2";
/* 	 $.post( 
             "Emp_Edit_Profile",
             {
           	Routing: rout
           	
           	
          },
             function(data) {
           		   var obj1 = jQuery.parseJSON(data);
           		// alert(obj.reason3);
           		if(obj1.GetRouting=="form2" && obj1.Statusc==1001 )
             		  {
             		  
           		 $("#fails1").show();
           		 $("#succ1").hide();
           		$("#editerr").hide();
           		$("#country1").prop("disabled",true);
            	 $("#state1").prop("disabled",true);
            	 $("#city1").prop("disabled",true);
            	 $("#address").prop("disabled",true);
            	

            	 $("#address1").prop("disabled",true);
            	 $("#address11").prop("disabled",true);
            		 $("#address111").prop("disabled",true);
            		 $("#address111").prop("disabled",true);
            		 
            		 $("#pin").prop("disabled",true);
            		 $("#commu").prop("disabled",true);
           		 
           		 
             		  }
             	
             }
          );
		
 */		
	 var rout ="form51";
		
	/*  $.post( 
              "Emp_Edit_Profile",
              { 
            	Routing: rout
            		                	},
              function(data) {
            	
              // alert(data);
               var obj = jQuery.parseJSON(data);
                	
                	 var Statusa1=obj.Statusa;
	             	//alert("obulesu"+Statusa1);
	             	//alert("ols reason"+obj.reason4);
	             	
	             	if(Statusa1==1001)
	             		{
	             	
            		  $("#failsa").show();
            		$("#err3").hide();
            		  $("#aadharpan").prop('disabled',true);
            	 $("#aadharno").prop("disabled",true);
      			 $("#aadhar").prop("disabled",true);
      			$("#pannumbr").prop("disabled",true);
      			 $("#adhaf").prop("disabled",true);
      			 $("#panf").prop("disabled",true);
      			$("#passportno").prop("disabled",true);
      			 $("#passf").prop("disabled",true);
      			$("#drivinglncno").prop("disabled",true);
	             		}
	             	else
	             		{
	             		
	             		}
	             	
	             	  
              }
           );
 */		
	 
	 $("#umobile").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	 
	 $("#promobile").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg1").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	  
	 
	 $("#promobile").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg1").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	 
	 $("#aadharno").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg2").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	 
	
/* -------------------------------------------------------------------------------------- */		
	 
	  $('#adhaf').keyup(function() {
			 
			  $("#err3").hide();
			  $("#aadharpan").prop("disabled",false);
			  
				});
			
		 
	 
	 
	 function validateFormaalldatasubmit()
		{
	
		 
		// $("#allsubmit").prop("disabled",false);
		 
		 
		 if($("#ch5").prop('checked')==true||$("#ch6").prop('checked')==true||$("#ch7").prop('checked')==true||$("#ch8").prop('checked')==true)
			{
		
			}
		
			 else
			 {
			 
			
			 }
		 
		
		 			
		 			
		 			
		 
		 
		 $("#uemailid").change(function()
				 {
			var eml=$("#uemailid").val();
			//var regex =  /^[A-Za-z]{3,15}.{1}[a-z0-9]{3,15}@[a-z]{4,7}\.[a-z]{3,4}$/;
			
			var regex = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
					//alert(ols);alert(eml);
				if(!regex.test(eml))
					{
					$("#ols1").show();
					
					$("#allsubmit").prop("disabled",true);
					$("#err1").hide();
				
					}
				
				else{
					$("#ols1").hide();
				
				if(ols==eml)
					{
					$("#ols2").show();
					
					
					$("#allsubmit").prop("disabled",true);
					$("#err1").hide();
					
					}
				else
					{
					$("#err1").hide();
					$("#ols2").hide();
					
					$("#allsubmit").prop("disabled",false);
					
					}
				}

				 }); 
		 
		 
		 $("#umobile").change(function()
				 {
			var umo=$("#umobile").val();
			 var phoneno1 = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
		
				if(umo.length == 0 && mobile==umo)
						{
						
						//alert("empty");
						
						$("#err1").hide();
						$("#ols12").hide();
						$("#ols11").show();
						$("#ols7").hide();
						 $("#olsotp1").hide();
						 $("#olsotp").hide();
						 $("#ols8").hide();
						 $("#ols7").hide();

						
						}
				else{
					
				if(!phoneno1.test(umo))
					{
					//alert("empty1");
					$("#ols11").show();
					$("#driver").prop("disabled",true);
					$("#err1").hide();
					
				
					}
				else
					{
					$("#ols11").hide();
					if(mobile==umo)
					{
						$("#motp").prop("disabled",true);
					$("#ols12").show();
					$("#err1").hide();
					}
				else
					{
					
					//alert("sdfg");
					$("#err1").hide();
					$("#ols12").hide();
					$("#ols11").hide();
					$("#ols7").show();
					$("#otpvalidation").val('');
					$("#motp").prop("disabled",false);
					
					}
					}
				}
				 });
		//promobile valid
		$('#promobile').keyup(function() {
			$("#err1").hide();
			$("#ols1pro").hide();
			$("#driver").prop("disabled",false);

				});
		$("#promobile").change(function()
				 {
			var pumo=$("#promobile").val();
			 var phoneno11 = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	
				if(!phoneno11.test(pumo))
					{
					$("#ols1p").show();
					 $("#err1").hide();
					 $("#ols8").hide();
					}
				else
					{
					$("#ols1p").hide();
				if(promob==pumo)
					{
					$("#ols1pro").show();
					$("#motpp12").prop("disabled",true);
					$("#err1").hide();
					 $("#ols8").hide();
					 $("#ols1p").hide();
					}
				else
					{
					$("#err1").hide();
					$("#ols1pro").hide();
					$("#showgetotp").show();
					$("#olsotp12").hide();
					$("#motpp12").prop("disabled",false);
					
					
					}
					}

				 });


		 
		$("#accno1").change(function()
				 {
			var accnor=$("#accno1").val();
			if(accontnumbeer==accnor)
					{
					$("#olsacc").show();
					 $("#err2").hide();
					}
				else
					{
					$("#olsacc").hide();
					 $("#err2").hide();
					
					}
				

				 });
		
		
		
		
		// aadhar details
		
		
	/* 	var aadhrno= $("#aadhar").val();aadharName1
	  			var aadhr= $("#aadharno").val();aadharnub
	  			var pannum= $("#pannumbr").val();pan
	  			var passNUM= $("#passportno").val();passnu
	  			var drivlcns= $("#drivinglncno").val();drivl
	  			var aafil=$("#adhaf").val();
	  			var pfil=$("#panf").val();
	  			var pafil=$("#passf").val();
	  			
			if(aadhrno==aadharName1 && aadhr==aadharnub && pannum==pan && passNUM==passnu && drivlcns==drivl )
				{
				$("#err3").show();
				$("#failsa").hide();
			
				 $("#aadharpan").prop("disabled",true);
				}
			else
				{
				$("#err3").hide();
				 $("#aadharpan").prop("disabled",false);
				
				}
		
		// bank detasils

 			 var bnkname=$("#bnk").val();//bname
 			 var ifcsc=$("#ifccode1").val();//ifc
 			 var bfl=$("#bankf").val();
		if(accontnumbeer==accnor && bnkname==bname && ifcsc==ifc )
			{
			$("#err2").show();
			 

			 $("#disab").prop("disabled",true);
			}
		
		else
					{
				
					$("#disab").prop("disabled",false);
					}
				
		
		// permanet address
		
		
		
				var country2 = $("#country2").val();
            	var state2 = $("#state2").val();
            	var city2 = $("#city2").val();
            	var addresso2 = $("#addressp").val();
            	var address12 = $("#addressp1").val();
            	
            	var address102 = $("#addressp2").val();
            	
            	var address132 = $("#addressp3").val();
            	
            	var pin2 =  $("#pin2").val(); 
            	var rout ="form3";
            	
            	
            	
            	if(state2==pstate && city2==pcity && addresso2==peraddr1 && address12==peradd2 && address102==peradd3 && address132==peradd4)
            	{
            		
            		alert("hi");
            		$("#PERMANENT").prop("disabled",true);
            		$("#editerr1").show();
            		
            	}
            	
            	else{
            		$("#PERMANENT").prop("disabled",false);

		
		
		
            	}
		// comunication
		
            	var country = $("#country1").val();
            	var state = $("#state1").val();
            	var city11 = $("#city1").val();
            	var addressI = $("#address").val();
            	

            	var address1I = $("#address1").val();
            	var address11I = $("#address11").val();
            	var address111I = $("#address111ols").val();
            	
            	var pin =  $("#pin").val();
            	var rout ="form2";
				
				if(state==cstate && city11==ccity && commadd1==addressI && commaddr2==address1I && commaddr3==address11I && commaddr4==address111I )
					{
					//alert("hiolstryty");
					$("#editerr").show();
						$("#commu").prop("disabled",true);
					}
				else{
					
					$("#commu").prop("disabled",false);
		
		
				}
		 // personal
		 
		  		email = $("#uemailid").val();
            	 mob = $("#umobile").val();
            	 prom = $("#promobile").val();
            	 dofbr = $("#udofb").val();
            	var rout ="form1";
            
            	
            	
            	
            	if(mobile==mob && promob==prom && ols==email && dofbr==dofb )
            		{
					$("#ols1").show();
					$("#allsubmit").prop("disabled",true);
            		}
            	
            	
            	else{
		 
				
            	}
				
				 */
				
				
				
				
				
				
			}
		
		 
	/// close 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 var rout ="reasons";
		
	 $.post( 
              "Emp_Edit_Profile",
              { 
            	Routing: rout
            		                	},
              function(data) {
            	
           // alert(data);
               var obj = jQuery.parseJSON(data);
                	
                	 var aa=obj.a1; var bb=obj.a2; var cc=obj.a3; var dd=obj.a4;
                	 var ee=obj.a5; var ff=obj.a6; var gg=obj.a7; var hh=obj.a8; var ii=obj.a9; var jj=obj.a10; var kk=obj.a11;
                	// alert(cc);
                	 if(aa.trim.length==0 && bb.trim.length==0&& cc.trim.length==0&& dd.trim.length==0&& ee.trim.length==0
                			 && ff.trim.length==0&& gg.trim.length==0&& hh.trim.length==0&& ii.trim.length==0&& jj.trim.length==0
                			 && kk.trim.length==0)
                		 {
                		//alert("fghfhf");
                		 $("#showReasons").show();
                		 
                		 }
                	 else
                		 {
                		 $("#showReasons").hide(); 
                	// alert("obulesu");
                		 }
                	
                	 
                	 if(aa.trim.length==0)
                			 {
                		 $("#empr1").hide();
                		 
                			 }
                	 else
                		 {
                		 $("#empr1").show();
                		 $("#empr1").val(aa);
                		 
                		 }
                	 
                	 if(bb.trim.length==0)
        			 {
        		 $("#empr2").hide();
        			 }
        	 else
        		 {
        		 $("#empr2").show();
        		 $("#empr2").val(bb);
        		 
        		 }
                	 if(cc.trim.length==0)
        			 {
        		 $("#empr3").hide();
        			 }
        	 else
        		 {
        		 $("#empr3").show();
        		 $("#empr3").val(cc);
        		 }
                	 if(dd.trim.length==0)
        			 {
        		 $("#empr4").hide();
        			 }
        	 else
        		 {
        		 $("#empr4").show();
        		 $("#empr4").val(dd);
        		 }
                	 if(ee.trim.length==0)
        			 {
        		 $("#empr5").hide();
        			 }
        	 else
        		 {
        		 $("#empr5").show();
        		 $("#empr5").val(ee);
        		 }
                	 if(ff.trim.length==0)
        			 {
        		 $("#empr6").hide();
        			 }
        	 else
        		 {
        		 $("#empr6").show();
        		 $("#empr6").val(ff);
        		 }
                	 if(gg.trim.length==0)
        			 {
        		 $("#empr7").hide();
        			 }
        	 else
        		 {
        		 $("#empr7").show();
        		 $("#empr7").val(gg);
        		 }
                	 
                	 if(hh.trim.length==0)
        			 {
        		 $("#empr8").hide();
        			 }
        	 else
        		 {
        		 $("#empr8").show();
        		 $("#empr8").val(hh);
        		 }
                	 if(ii.trim.length==0)
        			 {
        		 $("#empr9").hide();
        			 }
        	 else
        		 {
        		 $("#empr9").show();
        		 $("#empr9").val(ii);
        		 }
                	 if(jj.trim.length==0)
        			 {
        		 $("#empr10").hide();
        			 }
        	 else
        		 {
        		 $("#empr10").show();
        		 $("#empr10").val(jj);
        		 }
                	 if(kk.trim.length==0)
        			 {
        		 $("#empr11").hide();
        			 }
        	 else
        		 {
        		 $("#empr11").show();
        		 $("#empr11").val(kk);
        		 }
                	 
                	
                	 
                	 
                	 
                	 
              }
           );
		 
		
		 
		function olsreas12()
		{
			
			//alert("ghgh");
			$("#myModal").modal('show');
		}
		
		 
		 
	 
	 
	
	 
		</script>

<script type="text/javascript">

$("#addressp").keyup(function()
		 {
			
	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });

$("#addressp1").keyup(function()
		 {

	$$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	

$("#addressp2").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	

$("#addressp3").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	

$("#pin2").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	


$("#address").keyup(function()
		 {
			
	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });

$("#address1").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	

$("#address11").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	

$("#address111ols").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	

$("#pin").keyup(function()
		 {

	$("#allsubmit").prop("disabled",false);
	$("#err2").hide();
		 });	




</script>


		<script>
		
		 $("#allsubmit").click(function()
				 {
			
			//communication
			 var country = $("#country1").val();
        	var state = $("#state1").val();
        	var city11 = $("#city1").val();
        	var addressI = $("#address").val();
        	var address1I = $("#address1").val();
        	var address11I = $("#address11").val();
        	var address111I = $("#address111ols").val();
        // aadhar	
        	var aadhrno= $("#aadharno").val();
        	var aadhrname1= $("#aadhar").val();
        	
  			var pannum= $("#pannumbr").val();//pan
  			var passNUM= $("#passportno").val();//passnu
  			var drivlcns= $("#drivinglncno").val();//drivl
  			var aafil=$("#adhaf").val();
  			var pfil=$("#panf").val();
  			var pafil=$("#passf").val();
  		//permanet addr
  		
  		var country2 = $("#country2").val();
	var state2 = $("#state2").val();
	var city2 = $("#city2").val();
	var addresso2 = $("#addressp").val();
	var address12 = $("#addressp1").val();
	var address102 = $("#addressp2").val();
	var address132 = $("#addressp3").val();
	var pin2 =  $("#pin2").val(); 
       var pin =  $("#pin").val();
    // personal 
    email = $("#uemailid").val();
	 mob = $("#umobile").val();
	 prom = $("#promobile").val();
	 dofbr = $("#udofb").val();
// bank 
	var accnor=$("#accno1").val();
 var bnkname=$("#bnk").val();//bname
	 var ifcsc=$("#ifccode1").val();//ifc
	 var bfl=$("#bankf").val();

	
			 
			 
			 
			 	//alert("Fgdgdfg"+backStatus);
						if(backStatus==1001)
				{
							$("#allsubmit").prop("disabled",true);
						//	alert("ggdg1");

				}
						else{
							//ch11,chkTwo,chkThree,chkfour	
				if($("#ch5").prop('checked')==true||$("#ch6").prop('checked')==true||$("#ch7").prop('checked')==true||$("#ch8").prop('checked')==true||$("#ch11").prop('checked')==true||$("#chkTwo").prop('checked')==true||$("#chkThree").prop('checked')==true||$("#chkfour").prop('checked')==true||$("#ch9").prop('checked')==true ||
						$("#ch10").prop('checked')==true || $("#ch12").prop('checked')==true || $("#btn2").prop('checked')==true)
					{
					//alert("ggdg2");
		  			//|| $("#olspass").is(":visible")
		  			//|| $("#olsDriv").is(":visible")

					$("#allsubmit").prop("disabled",false);
					
					 if($("#ols7").is(":visible")||$("#olsotp1").is(":visible")||$("#olsotp").is(":visible")  || $("#ols1p").is(":visible") || $("#ols1pro").is(":visible") || $("#showgetotp").is(":visible") || $("#olsotp12").is(":visible") || $("#olsotp123").is(":visible") || 
							 $("#olsacc").is(":visible") ||  $("#bkfile").is(":visible") ||  $("#ols11").is(":visible") || $("#ols1p").is(":visible") ||  $("#invalidaadha").is(":visible") || $("#olspan").is(":visible") || $("#pannumberv").is(":visible") || $("#passvalidation").is(":visible") || 
					   $("#olspass").is(":visible") ||  $("#drivringlic").is(":visible"))
				     	{
						 
						//;alert("hi");
				     		$("#ols8").show();
				     		$("#allsubmit").prop("disabled",true);
				     	}
					 

		           
						if(state==cstate && city11==ccity && commadd1==addressI && commaddr2==address1I && commaddr3==address11I && commaddr4==address111I && state2==pstate && city2==pcity && addresso2==peraddr1 && address12==peradd2 && address102==peradd3 && address132==peradd4 && accontnumbeer==accnor && bnkname==bname && ifcsc==ifc && mobile==mob && promob==prom && ols==email && dofbr==dofb &&
								aadharName1==aadhrname1 && aadharnub==aadhrno && pan==pannum && passnu==passNUM && drivl==drivlcns)
							{
							
					//	alert("hiolstryty");
							
							$("#err2").show();
							$("#allsubmit").prop("disabled",true);
							}
						
						
					 
					}
						
				
				
				else{
					
					$("#err2").show();
					$("#allsubmit").prop("disabled",true);	
					/*  $(this).val('Please wait ...')
				      .attr('disabled','disabled');
				    $('#theform').submit();					
					 */
					
					
					
						}
			 
				
					
							}
						
					 
						
						
						
						
				 });
		 
	
		 
		 
		 
		</script>
		
		
		
		<script type="text/javascript">
		
		function edit123()
		{
			alert("hii");
			$("#myModal").modal('show');
			
		
		}
			 
		
		
		</script>
		
		
		
		
		
	<!-- Modal -->
 <!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Reason for Reject</h4>
            </div>
            <div class="modal-body">
             Email:<input type="text" name="email_reason" value=" "id="emailre" readonly="readonly"> 
             Mobile:<input type="text" name="email_reason" value=" "id="emailre" readonly="readonly">
             Personal Mobile:<input type="text" name="email_reason" value=" "id="emailre" readonly="readonly">
            </div>
           <Span id="suberr" style='color:red;margin-bottom: 20px;' hidden = "hidden">save is not accepted without reject reason</Span>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="SendtoHr()">Save</button>
            </div>
        </div>
    </div>
</div> 
 -->

 <!-- <div class="text-center">
                
                <button type="button" id="olsreas" onclick="olsreas12()" class="btn btn-primary" >Rejected Reasons</button>
            </div>
		
 -->








		<!-- Vendor -->
		<!-- <script src="assets/vendor/jquery/jquery.js"></script> -->
		<script src="assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
	<!--  <script src="assets/vendor/nanoscroller/nanoscroller.js"></script>  -->
 <script src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script> 
	
	
		<!-- Specific Page Vendor -->
		<script src="assets/vendor/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
		<script src="assets/vendor/jquery-ui-touch-punch/jquery.ui.touch-punch.js"></script>
		<script src="assets/vendor/jquery-appear/jquery.appear.js"></script>
		
		
		<!-- Theme Base, Components and Settings -->
		<!-- <script src="assets/javascripts/theme.js"></script> -->
		
		<!-- Theme Custom -->
		<script src="assets/javascripts/theme.custom.js"></script>
		
		<!-- Theme Initialization Files -->
		<script src="assets/javascripts/theme.init.js"></script>
		<!-- <script src="http://someothersite.com/external.js"></script> -->
		<!-- Examples -->
		
		
		<!-- <script src="assets/javascripts/dashboard/examples.dashboard.js"></script> -->
		<!-- <script src="assets/javascripts/ui-elements/examples.modals.js"></script> -->
	<!-- 	<script src="assets/javascripts/pages/examples.calendar.js"></script> -->
		<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
	</body>
</html>





