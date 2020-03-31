<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,java.text.DecimalFormat,java.text.NumberFormat"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>

<%-- <jsp:include page="index.jsp"></jsp:include> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#search').keyup(function() {
			searchTable($(this).val());
		});
	});

	function searchTable(inputVal) {
		var table = $('#tblData');
		table.find('tr').each(function(index, row) {
			var allCells = $(row).find('td');
			if (allCells.length > 0) {
				var found = false;
				allCells.each(function(index, td) {
					var regExp = new RegExp(inputVal, 'i');
					if (regExp.test($(td).text())) {
						found = true;
						return false;
					}
				});
				if (found == true)
					$(row).show();
				else
					$(row).hide();
			}
		});
	}
</script>



<script>
	function CallRad(val) {
		var id = val + "g";
		alert("Total Gross Value::"
				+ document.getElementById(val + 'g').innerHTML);
	}
</script>

<style type="text/css">
#scroll {
	/* width:98%; */
	height: 550px;
	overflow-y: scroll;
	overflow-x: scroll;
}

.table  tr:hover td {
	background: #a9a9f5;
}

td,th {
	font-size: 10px;
}
</style>

<title>Insert title here</title>
<%
	Map Basics = (Map) session.getAttribute("Basic");
	Map FinalComponents = (Map) session.getAttribute("FinalComponents");
	Map TaxException = (Map) session.getAttribute("TaxException");
	Map TaxSections = (Map) session.getAttribute("TaxSections");
	ArrayList empids = (ArrayList) session.getAttribute("empids");
	ArrayList taxempids = (ArrayList) session.getAttribute("taxempids");

	String ProposedMonths = (String) session
			.getAttribute("ProposedMonths");

	int Total_Months = 0;
	java.util.Iterator empseq = taxempids.iterator();
	
	
	

	//java.util.Iterator empseq = empids.iterator();
%>
</head>
<body>

	<form method="post">

		<div class="container">
			<table class="table" id="tblData" border='1'>
				<th>ID</th>
				<th>Employee Name</th>
				<th>PAID GROSS</th>
				<th>CTC<Br>(Paid &To be Paid Gross)<br/> 1 
				</th>
				<th >CA<br/> 2 
				</th>
				<th>HRA<br/>3
				</th>
				<th >Child Education<br/> 4 
				</th>
				<th >Medical<br/> 5 
				</th>
				<th >LTA<br>(Declared)<br/>6 
				</th>
				<th >Exemption On<br/>
					Salary Heads<br/> (7=SUM(2 to 6))
				</th>
				<th>After Deduction<br>8=SUM(1-7)
				</th>
				<th >Professional Tax <br/>
					 9
				</th>
				<th>After Deduction <br/> 10=SUM(8-9)
				</th>
				<th>LetOut Property(Eligible) <br/>11
				</th>
				<th>Other Income(Eligible) <br/>12
				</th>
				<th>After Addition <br/>13=SUM(10+11+12))
				</th>
				<th >House Loan Interest
					Deduction(Eligible)<br/>14
				</th>
				<th >Qualifying
					Amount(80C,80CCC,80CCD)<br/>15
				</th>
				<th >Qualifying Amount(80G)<br/>16
				</th>
				<th >Qualifying Amount (80D
					to 80TTA)<br>17
				</th>
				<th>Aggregate Amount(after deductions)<br/>(18=13-(14+15+16+17))
				</th>
				
				
				
				
				 <th > Tax On taxable Income (19)</th>
   
  
  <th > Tax Rebate U/s 87A <br>20 </th>
  
  <th>Tax after Rebate (U/s 87A) (21=(19-20))</th>
  
   <th>  Surcharge(with relief who have taxable income>50L) <br>(22) </th>
   
   <th style="background-color:#FFFFE0;" > Relief Amount </th>
     <!--  <th> Tax On Total Income <br>(21) </th> -->
      
      <th> Education cess <br>(23=21*3%) </th>
      
      <th>Total Tax <br>(24= (21+22+23)) </th>
      
      <th style="background-color:#FFFFE0;" >Tax Deducted till Date <br>(25)</th>
      <th>To Be Paid Tax <br>(26=(24-25))</th>
      <th>Paid Months <br>27</th>
      <th>Proposed Months <br>28</th>
      <th>Total Calculated Months <br>(29=(27+28))</th>
      <th>TDS For Month <br>(30=26/28)</th>
				</tr>
				<%
					NumberFormat formatter = new DecimalFormat("#0.00");
    int SNO=1;
					while (empseq.hasNext()) {

						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-Disposition",
								"attachement; filename=" + "TDS.xls");

						String empid = empseq.next().toString();
						Double gross = 0.0, pt = 0.0, income = 0.0;
ProposedMonths=Basics.get(empid+".ProposedMonths").toString();
						gross = Double.parseDouble(Basics.get(empid + ".gross")
								.toString());
						pt = Double.parseDouble(Basics.get(empid + ".Pt").toString());
						income = gross - pt;
						Total_Months = (Integer.parseInt(Basics.get(empid + ".pm")
								.toString())) + (Integer.parseInt(ProposedMonths));
						
						
						
						 Double FinalTax_Month=0.00;
							// System.out.println("Income :: "+income);
							if(Integer.parseInt(ProposedMonths)!=0){
							
							    FinalTax_Month=(((Double.parseDouble(TaxSections.get(empid+"ANN_tx_Paid").toString() ))-(Double.parseDouble(TaxSections.get(empid+"_TDS_F").toString()))) / Integer.parseInt(ProposedMonths));
							}else{
								
								FinalTax_Month=(((Double.parseDouble(TaxSections.get(empid+"ANN_tx_Paid").toString() ))-(Double.parseDouble(TaxSections.get(empid+"_TDS_F").toString()))));
							}

						// System.out.println("Income :: "+income);
				%>
				<tr>
 <td ><%=SNO%></td>
					<td><%=empid%></td>
					<td><%=Basics.get(empid + ".callname")%></td>
					
					<td align='right'> <%=formatter.format(Double.parseDouble(FinalComponents.get(empid+"-gross").toString())) %></td>
					
					<td align='right'><%=formatter.format(Double.parseDouble(FinalComponents
						.get(empid + "-ANN_gross").toString()))%></td>

					<td align='right' ><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + "_CA_M_y").toString()))%></td>
					<td align='right' ><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + ".Basi40_RE_y").toString()))%></td>
					<td align='right'><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + ".ChildEdu_y").toString()))%></td>
					<td align='right' ><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + ".Medical_y").toString()))%></td>
					<td align='right' ><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "_LTA_P").toString()))%></td>
					<td align='right' ><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + ".ANN_ExmpAmount").toString()))%></td>
					<td align='right'><%=formatter.format(Double.parseDouble(FinalComponents
						.get(empid + "-ANN_gross_ExAmt").toString()))%>
					</td>
					<td align='right' ><%=formatter.format(Double.parseDouble(FinalComponents
						.get(empid + "-ANN_Pt").toString()))%>
					</td>
					<td align='right'><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + ".ANN_FinalIncome_B").toString()))%>
					</td>

					<td align='right'><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "INHR").toString()))%>
					</td>
					<td align='right'><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "_OTHERINCOME").toString()))%>
					</td>
					<td align='right'><%=formatter.format(Double.parseDouble(TaxException.get(
						empid + ".ANN_FinalIncome").toString()))%>
					</td>

					<td align='right' ><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "_RENTINTEREST_E").toString()))%>
					</td>

					<td align='right' ><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "_80C_E_y").toString()))%>
					</td>

					<td align='right' ><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "S_80G_E").toString()))%>
					</td>

					<td align='right' ><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "_80D_E").toString()))%>
					</td>

					<td align='right'><%=formatter.format(Double.parseDouble(TaxSections.get(
						empid + "ANN_TxamT").toString()))%>
					</td>





           <!--  -->

					 <td align='right' style="background-color:#FFFFE0;"> <%= formatter.format(Double.parseDouble(TaxSections.get(empid+"_ANN_Before_Dedu_tax").toString()))  %> </td> 
    
    
    <!-- - -->
    <td align='right' style="background-color:#FFFFE0;"> <%=formatter.format(Double.parseDouble(TaxSections.get(empid+"_ANN_EmpTaxAddl_E").toString()))  %> </td>
    
    <!-- This Line Is Changed For Surcharge Amount Caliculation -->
    <td><%=formatter.format( Double.parseDouble(TaxSections.get(empid+"_ANN_Emp_Tax_E").toString()) - Double.parseDouble(TaxSections.get(empid+"_ANN_SURCHARGE").toString())) %></td> 
    
    
   <td align='right' > <%= formatter.format(Double.parseDouble(TaxSections.get(empid+"_ANN_SURCHARGE").toString()))  %> </td>
   
   
   <td align='right' > <%= formatter.format(Double.parseDouble(TaxSections.get(empid+"_ANN_Before_Dedu_Relif").toString()))  %> </td>
   
   
   <%-- <td align='right' >  <%= formatter.format(Double.parseDouble(TaxSections.get(empid+"_ANN_Emp_Tax_E").toString()))    %> </td> --%>
   
   <td align='right' >  <%=formatter.format(Double.parseDouble(TaxSections.get(empid+"ANN_Educess").toString())) %> </td>
   
   
   <td align='right' >  <%=formatter.format(Double.parseDouble(TaxSections.get(empid+"ANN_tx_Paid").toString())) %> </td>
   
   <td align='right' style="background-color:#FFFFE0;"><%=formatter.format(Double.parseDouble(TaxSections.get(empid+"_TDS_F").toString())) %></td>
  
   <td align='right' ><%=(Double.parseDouble(TaxSections.get(empid+"ANN_tx_Paid").toString() ))-Double.parseDouble(TaxSections.get(empid+"_TDS_F").toString()) %></td>
  
   <td align='right' ><%=Integer.parseInt(Basics.get(empid+".pm").toString()) %></td>
   
    <td align='right' ><%=ProposedMonths %></td>
     <td align='right' ><%=Total_Months %></td>
   
      <td align='right' ><%=formatter.format(FinalTax_Month) %> </td>
				</tr>

				<%
 SNO++;
					}
				%>

			</table>
		</div>
		
		
	</form>

</body>
</html>