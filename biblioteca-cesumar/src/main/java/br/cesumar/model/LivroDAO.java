package br.cesumar.model;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    // Lista que ficará armazenada enquanto o sistema estiver em execução
    private static List<Livro> livros = new ArrayList<>();

    // Cadastra um novo livro
    public static void adicionar(Livro livro) {
        livros.add(livro);
    }

    // Retorna todos os livros cadastrados
    public static List<Livro> listar() {
        return livros;
    }

    // Exclui um livro pelo ISBN
    public static void excluir(String isbn) {
        livros.removeIf(livro -> livro.getIsbn().equals(isbn));
    }

}