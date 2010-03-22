<%-- 
    Document   : result
    Created on : Mar 22, 2010, 12:03:17 PM
    Author     : frank
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="au.nsw.data.wsdladdress.TypeTableInstance" %>
<%
            String result = (String) session.getAttribute("result");
            String type = (String) session.getAttribute("type");
            TypeTableInstance instance = new TypeTableInstance();
            String address = (String) instance.addresstable.get(type);

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <Script Language="JavaScript">
            
            function load(url) {
                var load = window.open(url,'','scrollbars=yes,menubar=no,height=600,width=800,resizable=yes,toolbar=no,location=no,status=no');
            }
            // -->
        </Script>
    </head>
    <body>
        <center>
            <h2>
            <div><a href="javascript:load('<%=address%>')">Service Wsdl Address</a></div>
            </h2>
            <br>
            <br>
            <div>
                <%=result%>
            </div>

            <div></div>
        </center>
    </body>
</html>
