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
        <link rel="stylesheet" type="text/css" href="css/style.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/result.css">
        <script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
        <%--<script type="text/javascript" src="js/share.min.js"></script>--%>
        <script type="text/javascript" src="js/index.js"></script>
        <script type="text/javascript" src="js/json.js"></script>
        <script type="text/javascript" src="js/json.prettyprint.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
            <%--var text = <%=result%>.toJSONString(true);--%>
   <%--                 var myFormattedString = FormatJSON(<%=result%>);
            $("#json").append(myFormattedString);--%>
                    })
        </script>
        <title>NSW Explorer Data API Results</title>
    </head>
    <body>
        <div id="logo"><a href="index.jsp" title="Home"><img src="images/logo.png" alt="NSW Explorer Data API"/></a></div>
        <div id="content">
            <div id="json">
                <%=result%>
            </div>
            <div id="wsdl"><a href="<%=address%>" target="_blank">Service WSDL Address</a></div>
        </div>
        <div id="footer">
            <ul class="right">
                <li><a href="#" title="Back to Home">Home</a></li>
                <li>|</li>
                <li><a href="about.html" title="About Us">About</a></li>
                <li>|</li>
                <li><a href="http://apps4nsw.uservoice.com/forums/35904-apps/suggestions/587233-nsw-explorer-data-api?ref=title" title="Send feedback">Feedback</a></li>
            </ul>
        </div>
    </body>
</html>
