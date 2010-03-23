<%--
    Document   : services
    Created on : 24/10/2009, 8:23:36 PM
    Author     : Frank
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.util.Hashtable" %>
<%@page import="java.util.Enumeration" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
        <title>NSW Explorer Data API</title>
    </head>
    <body>
        <div id="logo"><a href="index.jsp" title="Home"><img src="images/logo.png" alt="NSW Explorer Data API"/></a></div>
        <div id="content">
            <s:form action="TransormerAction" method="post">
                <table cellspacing="10">
                    <tr><th>Suburb</th><td><input name="suburb" class="text" type="text" id="suburb"></td></tr>
                    <tr><th>Postcode</th><td><input name="postcode" class="text" type="text" id="postal"></td></tr>
                    <tr>
                        <th>Type</th>
                        <td>
                            <select name="type" class="select">
                                <option value="park">Parks and Reserves</option>
                                <option value="toilet">Toilets</option>
                                <option value="museum">Musuems and Galleries</option>
                                <option value="restaurant">Restaurants</option>
                                <option value="aquarium">Aquariums and Zoos</option>
                                <option value="sport">Sport Clubs</option>
                                <option value="supermarket">Supermarkets and Shooping centers</option>
                            </select>
                        </td>
                    </tr>
                    <tr><th></th><td><input type="button" value="Submit" class="button right" id="button"></td></tr>
                </table>
            </s:form>
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