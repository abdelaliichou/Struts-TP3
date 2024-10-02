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
    <title><s:text name="inscription.titre"/></title>

    </head>
<body>


<h1><s:text name="inscription.h1"/></h1>

<s:form action="inscription" method="POST">
    <s:textfield name="pseudo" id="id:pseudo" key="connexion.form.pseudo"/>
    <s:password name="mdp" id="id:mdp" key="connexion.form.mdp"/>
    <s:submit/>

</s:form>



</body>
</html>
