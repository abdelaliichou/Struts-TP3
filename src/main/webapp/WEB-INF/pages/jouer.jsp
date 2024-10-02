<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yoh
  Date: 13/01/2022
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="jouer.titre"/></title>
</head>
<body>
<h1><s:text name="jouer.h1"/> </h1>

<table>

    <tr>
        <td><s:text name="jouer.pseudo"/></td><td>
        <s:property value="pseudo"/>
    </td>
    </tr>

    <tr>
        <td><s:text name="jouer.nbPartiesJouees"/></td>
        <td><s:property value="nbPartiesJouees"/> </td>
    </tr>

    <tr>
        <td><s:text name="jouer.pourcentageWins"/></td>
        <td><s:property value="pourcentageWins"/> </td>
    </tr>

</table>

<s:form action="pileOuFace" method="POST">

    <s:textfield name="choix" key="jouer.form.textfield"/>
    <s:submit/>
</s:form>

</body>
</html>
