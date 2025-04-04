<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Atualizar Usuario</title>
    </head>
    <body>
        <h1>Editar Usuario</h1>
        <form action="/home/update" method="post">
            <input type="hidden" name="id" value="${user.id}" />
            <label>Nome</label>
            <input type="text" name="Nome" value="${user.nome}"/>
            <label>Idade</label>
            <input type="number" name="Idade" value="${user.idade}"/>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>