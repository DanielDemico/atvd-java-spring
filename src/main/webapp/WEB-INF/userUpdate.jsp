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
            <input type="number" name="id" value="${usuario.id}" />

            <label>Nome</label>
            <input type="text" name="nome" value="${usuario.nome}"/>
            <label>Idade</label>
            <input type="number" name="idade" value="${usuario.idade}"/>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>