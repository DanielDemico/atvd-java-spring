<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Spring Boot</title>
    </head>
    <body>
        <h1>Usuarios Cadastrados</h1>
        <div>
            <ul>
            <c:forEach var="user" items="${usuarios}">
                <p>
                    ID: ${user.id} |
                    NOME: ${user.nome} |
                    IDADE: ${user.idade} |
                    ESTUDA: 
                    <c:if test="${not user.estuda}">Não</c:if>
                    <c:if test="${user.estuda}">Sim</c:if>
                </p>
                <a href="/home/updateForm?id=${user.id}">Editar</a>
                <form action="/home/delete" method="post">
                    <input type="hidden" name="id" value="${user.id}" />
                    <button type="submit">Deletar</button>
                </form>
            </c:forEach>
            </ul>
        </div>

        <div>
            <h2>Adicionar Usuarios</h2>
            <form action="/home/insert" method="post">
                <label>Nome</label>
                <input id="nome" name="nome" type="text"/>
                <label>Idade</label>
                <input id="idade" name="idade" type="number"/>
                <label>Estuda?</label>
                <input id="estuda" name="estuda" type="checkbox" value="True"/>
                <button type="submit">Adicionar Usuario</button>
            </form>
        </div>
    </body>
</html>