<%@ taglib prefix="s" uri="/struts-tags" %>

<%--
  Created by IntelliJ IDEA.
  User: yoh
  Date: 13/01/2022
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="home.titre"/></title>
</head>
<body>

<h1><s:text name="home.h1"/></h1>


<h2><s:text name="home.h2"/></h2>

<ul>

    <li>
        <s:a action="gotoinscription"><s:text name="home.a.inscription"/></s:a>
  </li>
    <li>
        <s:a action="gotoconnexion"><s:text name="home.a.connexion"/></s:a>
    </li>
</ul>


</body>
</html>
