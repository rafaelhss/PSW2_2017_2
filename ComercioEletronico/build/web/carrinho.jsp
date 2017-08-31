<%-- 
    Document   : carrinho
    Created on : 31/08/2017, 20:08:28
    Author     : Rafael.Soares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seu Carrinho</h1>
        <table>
            <td>
                Nome
            </td>
            <c:forEach items="${requestScope.carrinho}" var="produto">
                <tr>
                    <td>
                        ${produto.nome}
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="Logoff">Logoff</a> <br/>
        <a href="ListarProdutos">voltar</a>
    </body>
</html>
