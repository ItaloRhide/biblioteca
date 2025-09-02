import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BibliotecaTest {

    @Test
    void testAdicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Dom Casmurro");

        List<String> livros = biblioteca.listarLivros();
        assertTrue(livros.contains("Dom Casmurro"), "O livro deve estar na lista após ser adicionado.");
    }

    @Test
    void testRemoverLivroExistente() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("1984");
        boolean removido = biblioteca.removerLivro("1984");

        assertTrue(removido, "O livro deve ser removido com sucesso.");
        assertFalse(biblioteca.listarLivros().contains("1984"), "O livro não deve mais estar na lista.");
    }

    @Test
    void testRemoverLivroInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        boolean removido = biblioteca.removerLivro("Livro Fantasma");

        assertFalse(removido, "Remover um livro inexistente deve retornar false.");
    }

    @Test
    void testListarLivrosImutavel() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("O Senhor dos Anéis");

        List<String> livros = biblioteca.listarLivros();

        assertThrows(UnsupportedOperationException.class, () -> {
            livros.add("Tentativa de Inserção Externa");
        }, "A lista deve ser imutável e não permitir modificações externas.");
    }
}
