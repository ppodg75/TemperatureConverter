<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="atj.TemperatureConverterService" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Temperature converter</title>
<meta name="author" content="Piotr Podgórski" >
<meta name="keywords" content="JSP, Temperature Converter, Servlet">
<meta name="description" content="Temperature Converter - Fahrenheit to Celsius and vice versa">


<style>
.result {
	color: blue;
	marign-top: 10px;
	marign-bottom: 10px;
}

.error {
	color: red;
	marign-top: 10px;
	marign-bottom: 10px;
}
</style>
</head>
<%!
 String opt(TemperatureConverterService.ConvertionDirection d, boolean sel) {
	return "<option value=\"" + d.toString() + "\""+ (sel?" selected":"") +">" +d.getDesc() + " </option>";
 }  
%>
<%
  String dir = (request.getAttribute("convDir")!=null)?(String)request.getAttribute("convDir"):"";
  Double temp = (request.getAttribute("temp")!=null)?(Double)request.getAttribute("temp"):0.0;  
%>
<body>
    <fieldset>
	<legend>Temperature converter</legend>
	<form action="/TemperatureConverter/convert" method="GET">
		<select name="convDir" id="convDir">
		  <% for(TemperatureConverterService.ConvertionDirection  cd :
				  TemperatureConverterService.ConvertionDirection.values()) {
               out.print(opt(cd, dir.equals(cd.toString())));			  
		  }
	      %>
		</select>
	    <input type=text value='<%= temp %>' name="temp" placeholder="0.0" />		
		<input type="submit" value="convert" />
		<div class="result"><% if (request.getAttribute("res")!=null) {
		out.print(request.getAttribute("res")); } %></div>
		
		<div class="error"><% if (request.getAttribute("err")!=null) {
		out.print(request.getAttribute("err")); } %></div>
	</form>
	</fieldset>

</body>
</html>