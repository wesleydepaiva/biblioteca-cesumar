<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cesumar.model.Livro" %>
<%@ page import="br.cesumar.model.LivroDAO" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Lista de Livros</title>
</head>

<body>

<h2>Livros Cadastrados</h2>

<table border="1" cellpadding="8">

    <tr>
        <th>Título</th>
        <th>Autor</th>
        <th>Ano</th>
        <th>ISBN</th>
        <th>Ação</th>
    </tr>

<%
List<Livro> livros = LivroDAO.listar();

for(Livro livro : livros){
%>

<tr>

    <td><%= livro.getTitulo() %></td>
    <td><%= livro.getAutor() %></td>
    <td><%= livro.getAno() %></td>
    <td><%= livro.getIsbn() %></td>

    <td>

        <a href="livro?isbn=<%= livro.getIsbn() %>"
           onclick="return confirm('Deseja realmente excluir este livro?');">

            Excluir

        </a>

    </td>

</tr>

<%
}
%>

</table>

<br>

<a href="index.jsp">
    Cadastrar novo livro
</a>

</body>

</html>