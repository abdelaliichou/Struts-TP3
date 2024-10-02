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
    <title><s:text name="resultat.titre"/></title>
</head>
<body>
<h1><s:text name="resultat.h1"/></h1>

<ul>
    <li><s:text name="resultat.prediction"/>
        <s:property value="partieCourante.prediction"/> </li>
    <li><s:text name="resultat.tirage"/>
    <s:property value="partieCourante.tirage"/> </li>
    <li>
        <s:if test="partieCourante.partieGagnante">
            <s:text name="resultat.victoire"/>
        </s:if>
        <s:else>

            <s:text name="resultat.defaite"/>
        </s:else>

    </li>

    <li><s:text name="resultat.nbPartiesJouees"/>
        <s:property value="nbPartiesJouees"/></li>
    <li><s:text name="resultat.pourcentageWins"/>
        <s:property value="pourcentageWins"/> </li>

</ul>


<ul>

    <li>
        <s:a action="rejouer"><s:text name="resultat.rejouer"/></s:a>
        </li>
    <li><s:a action="deconnexion"><s:text name="resultat.quitter"/></s:a> </li>
</ul>


</body>
</html>
