package br.cesumar.controller;

import br.cesumar.model.Livro;
import br.cesumar.model.LivroDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/livro")
public class LivroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anoTexto = request.getParameter("ano");
        String isbn = request.getParameter("isbn");

        // Validação de campos vazios
        if (titulo == null || titulo.trim().isEmpty() ||
            autor == null || autor.trim().isEmpty() ||
            anoTexto == null || anoTexto.trim().isEmpty() ||
            isbn == null || isbn.trim().isEmpty()) {

            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // Validação simples do ISBN
        if (!isbn.matches("\\d+")) {
            request.setAttribute("erro", "O ISBN deve conter apenas números.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        try {

            int ano = Integer.parseInt(anoTexto);

            Livro livro = new Livro(titulo, autor, ano, isbn);

            LivroDAO.adicionar(livro);

            response.sendRedirect("lista.jsp");

        } catch (NumberFormatException e) {

            request.setAttribute("erro", "Ano inválido.");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String isbn = request.getParameter("isbn");

        if (isbn != null && !isbn.isEmpty()) {
            LivroDAO.excluir(isbn);
        }

        response.sendRedirect("lista.jsp");
    }

}
