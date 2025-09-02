package com.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void testAdicionarLivro() {
        biblioteca.adicionarLivro("Dom Casmurro");
        biblioteca.adicionarLivro("1984");

        List<String> livros = biblioteca.listarLivros();
        assertEquals("Deve haver 2 livros na lista", 2, livros.size());
        assertTrue(livros.contains("Dom Casmurro"));
        assertTrue(livros.contains("1984"));
    }

    @Test
    public void testRemoverLivro() {
        biblioteca.adicionarLivro("O Senhor dos Anéis");

        assertTrue("Deve retornar true ao remover um livro existente",
                biblioteca.removerLivro("O Senhor dos Anéis"));
        assertFalse("O livro não deve mais estar na lista",
                biblioteca.listarLivros().contains("O Senhor dos Anéis"));

        assertFalse("Deve retornar false ao tentar remover um livro que não existe",
                biblioteca.removerLivro("Livro Inexistente"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListarLivrosImutavel() {
        biblioteca.adicionarLivro("A Revolução dos Bichos");
        List<String> livros = biblioteca.listarLivros();

        // Deve lançar UnsupportedOperationException
        livros.add("Novo Livro");
    }
}
