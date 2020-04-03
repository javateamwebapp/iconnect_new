package iconnect.hhcl.forgotpwd;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import net.sf.jasperreports.engine.xml.JRFontFactory.ChartFontFactory;
public class SMSGatewayCenterAPI{
	public static void main(String[] args){
		Random random = new Random();
		Map map=new HashMap();
		String generatedPassword = String.format("%04d", random.nextInt(10000));
		map=CallSmsData("9014212135" , generatedPassword);
		System.out.println("MAP DATA" +map.toString());
	}
	public static synchronized  Map CallSmsData(String Mobile,String Otp){
		Map map=new HashMap();
		String message="Request Not Processed Please contact admin..!";
		String ErrorCode="2002";
		try{
			Date mydate = new Date(System.currentTimeMillis());
			String data = "";
			data += "APIKey="+URLEncoder.encode("xcX1hfrrMkCD3Eu7bq6F5w" ,"UTF-8");
			data += "&senderid="+URLEncoder.encode("HETERO" ,"UTF-8");
			data +="&channel="+URLEncoder.encode("OTP","UTF-8");
			data += "&DCS="+URLEncoder.encode( "0" ,"UTF-8");
			data += "&route="+URLEncoder.encode( "1" ,"UTF-8");
			data += "&flashsms="+URLEncoder.encode("0" ,"UTF-8");
			data += "&number="+URLEncoder.encode( ""+Mobile+"" ,"UTF-8") ;
			data += "&text="+URLEncoder.encode(""+Otp+" is OTP for password change in your iConnect. OTP is valid for 15 mins. Please do not  share with anyone." ,"UTF-8");
			URL url = new URL("http://login.smsgatewayhub.com/api/mt/SendSMS?" + data);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Accept", "application/json");
			conn.setUseCaches(false); conn.connect();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuffer buffer = new StringBuffer();
			while((line = rd.readLine()) != null){
				buffer.append(line).append("\n");
			}
		//System.out.println(buffer.toString());
			rd.close();
			conn.disconnect();
			// Start Jason object Retriving */
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(buffer.toString());
			//System.out.println(jsonObject);
			ErrorCode = (String) jsonObject.get("ErrorCode");
			//System.out.println(ErrorCode);
			message = (String) jsonObject.get("ErrorMessage");
			//System.out.println(message);
			if(ErrorCode.equalsIgnoreCase("000")){
				message="Success";
			}else if(ErrorCode.equalsIgnoreCase("001"))
			{
				message="001 login details cannot be blank";
			}
			else if(ErrorCode.equalsIgnoreCase("003"))
			{
				message="003 sender cannot be blank";
			}
			else if(ErrorCode.equalsIgnoreCase("004"))
			{
				message="004 message text cannot be blank";
			}
			else if(ErrorCode.equalsIgnoreCase("005"))
			{
				message="005 message data cannot be blank";
			}
			else if(ErrorCode.equalsIgnoreCase("006"))
			{
				message="006 error: generic error description";
			}
			else if(ErrorCode.equalsIgnoreCase("007"))
			{
				message="007 username or password is invalid";
			}
			else if(ErrorCode.equalsIgnoreCase("008"))
			{
				message="008 account not active";
			}
			else if(ErrorCode.equalsIgnoreCase("009"))
			{
				message="009 account locked, contact your account manager";
			}
			else if(ErrorCode.equalsIgnoreCase("010"))
			{
				message="010 api restriction";
			}
			else if(ErrorCode.equalsIgnoreCase("011"))
			{
				message="011 ip address restriction";
			}
			else if(ErrorCode.equalsIgnoreCase("012"))
			{
				message="012 invalid length of message text";
			}
			else if(ErrorCode.equalsIgnoreCase("013"))
			{
				message="013 mobile numbers not valid";
			}
			else if(ErrorCode.equalsIgnoreCase("014"))
			{
				message="014 account locked due to spam message contact support";
			}
			else if(ErrorCode.equalsIgnoreCase("015"))
			{
				message="015 senderid not valid";
			}
			else if(ErrorCode.equalsIgnoreCase("017"))
			{
				message="017 groupid not valid";
			}
			else if(ErrorCode.equalsIgnoreCase("018"))
			{
				message="018 multi message to group is not supported";
			}
			else if(ErrorCode.equalsIgnoreCase("019"))
			{
				message="019 schedule date is not valid";
			}
			else if(ErrorCode.equalsIgnoreCase("020"))
			{
				message="020 message or mobile number cannot be blank";
			}
			else if(ErrorCode.equalsIgnoreCase("021"))
			{
				message="021 insufficient credits";
			}
			else if(ErrorCode.equalsIgnoreCase("022"))
			{
				message="022 invalid jobid";
			}
			else if(ErrorCode.equalsIgnoreCase("023"))
			{
				message="023 parameter missing";
			}
			else if(ErrorCode.equalsIgnoreCase("024"))
			{
				message="024 invalid template or template mismatch";
			}

			else if(ErrorCode.equalsIgnoreCase("025"))
			{
				message="025 {Field} can not be blank or empty";
			}
			else if(ErrorCode.equalsIgnoreCase("026"))
			{
				message="026 invalid date range";
			}
			else if(ErrorCode.equalsIgnoreCase("027"))
			{
				message="027 invalid optin user";
			}
			// End Jason object Retriving */


		}
		catch (Exception e){
			e.printStackTrace();
		}

		map.put("message", message);
		map.put("ErrorCode", ErrorCode);
		map.put("Mobile", Mobile);
		
		return map;
	}
}
