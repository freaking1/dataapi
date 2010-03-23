<%-- 
    Document   : result
    Created on : Mar 22, 2010, 12:03:17 PM
    Author     : frank
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="au.nsw.data.wsdladdress.TypeTableInstance" %>
<%@page import="net.sf.json.JSONObject" %>

<%
            JSONObject result = (JSONObject) session.getAttribute("result");
            String type = (String) session.getAttribute("type");
            TypeTableInstance instance = new TypeTableInstance();
            String address = (String) instance.addresstable.get(type);

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/result.css">
        <title>NSW Explorer Data API Results</title>
    </head>
    <body>
        <div id="logo"><a href="index.jsp" title="Home"><img src="images/logo.png" alt="NSW Explorer Data API"/></a></div>
        <div id="content">
            <div id="title">JSON Responce:</div>
            <div id="json">
                <pre><%out.write(result.toString(4));%></pre>
            </div>
            <div id="wsdl"><a href="<%=address%>" target="_blank">Service WSDL Address</a></div>
        </div>
        <div id="footer">
            <ul class="right">
                <li><a href="index.jsp" title="Back to Home">Home</a></li>
                <li>|</li>
                <li><a href="about.html" title="About Us">About</a></li>
                <li>|</li>
                <li><a href="http://apps4nsw.uservoice.com/forums/35904-apps/suggestions/587233-nsw-explorer-data-api?ref=title" title="Send feedback">Feedback</a></li>
            </ul>
        </div>
    </body>
</html>
