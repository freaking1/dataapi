<%--
    Document   : services
    Created on : 24/10/2009, 8:23:36 PM
    Author     : Frank
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@page import="java.util.Hashtable" %>
<%@page import="java.util.Enumeration" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>




<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>


    </head>
    <body>
        <center>
            <table>
                <H1>NSW Explorer DATA API</H1>
            </table>
            <br/>
            <br/>
            <table>

                <s:form action="TransormerAction" method="post" >
                    <tr><td>Suburb</td><td><input name="suburb"></td></tr>
                    <tr><td>Postcode</td><td><input name="postcode"></td></tr>
                    <tr><td>Type</td><td>
                            <select name="type">
                                <option value="park">Parks and Reserves</option>
                                <option value="toilet">Toilets</option>
                                <option value="museum">Musuems and Galleries</option>
                                <option value="restaurant">Restaurants</option>
                                <option value="aquarium">Aquariums</option>
                                <option value="sport">Sport Clubs</option>
                                <option value="supermarket">Supermarkets and Shooping centers</option>
                            </select></td></tr>
                    <tr><td><input type="submit" value="Go"></td></tr>
                 </s:form>
            </table>
        </center>
    </body>
</html>