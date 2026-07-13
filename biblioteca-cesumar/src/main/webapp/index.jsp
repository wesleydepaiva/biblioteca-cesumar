<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Biblioteca Universidade Cesumar</title>
</head>

<body>

    <h2>Cadastro de Livros</h2>

    <% if(request.getAttribute("erro") != null){ %>

        <p style="color:red;">
            <%= request.getAttribute("erro") %>
        </p>

    <% } %>

    <form action="livro" method="post">

        <p>
            <label>Título:</label><br>
            <input type="text" name="titulo" size="40">
        </p>

        <p>
            <label>Autor:</label><br>
            <input type="text" name="autor" size="40">
        </p>

        <p>
            <label>Ano de Publicação:</label><br>
            <input type="number" name="ano">
        </p>

        <p>
            <label>ISBN:</label><br>
            <input type="text" name="isbn">
        </p>

        <button type="submit">
            Cadastrar Livro
        </button>

    </form>

    <br>

    <a href="lista.jsp">
        Ver livros cadastrados
    </a>

    <br><br>

    <a href="jsf.xhtml">
        Abrir página JSF
    </a>

</body>

</html>