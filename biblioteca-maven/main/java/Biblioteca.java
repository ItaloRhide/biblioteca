import java.util.*;

public class Biblioteca {
    private List<String> livros = new ArrayList<>();

    public void adicionarLivro(String livro) {
        livros.add(livro);
    }

    public boolean removerLivro(String livro) {
        return livros.remove(livro);
    }

    public List<String> listarLivros() {
        return Collections.unmodifiableList(livros);
    }

}
