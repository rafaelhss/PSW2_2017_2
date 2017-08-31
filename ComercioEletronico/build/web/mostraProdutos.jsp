<%-- 
    Document   : mostraProdutos
    Created on : 31/08/2017, 19:47:02
    Author     : Rafael.Soares
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:if test="${fn:length(requestScope.mensagem) > 0}">
            <script>
                alert('${requestScope.mensagem}');
            </script>
        </c:if>
    </head>
    <body>
        <a href="Carrinho">Ver Carrinho</a>
        <h1>Nossos produtos:</h1>
        <table border="1px">
            <td>
                Nome
            </td>
            <td>
                Classificacao
            </td>
            <c:forEach items="${requestScope.produtos}" var="produto">
                <tr>
                    <td>
                        ${produto.nome}
                        <c:if test="${desconto > 0}">
                            -${desconto}%
                        </c:if>
                    </td>
                    <td>
                        (${produto.tipo})
                    </td>
                    
                    <td>
                        <a href="AddCarrinho?id=${produto.id}">comprar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
