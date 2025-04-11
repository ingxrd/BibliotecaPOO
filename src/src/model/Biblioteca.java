package model;
import java.util.ArrayList;

public class Biblioteca {
    // Armazena Livros
    private ArrayList<Livro> listaDelivros = new ArrayList<Livro>();


    // Amazena Usuáros
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    // Armazena empréstimos
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    // Listar livros disponíveis

    public void listarLivrosDisponiveis() {
        boolean todosLivrosDisponiveis = false;
        for (Livro livro : listaDelivros) {
            if (livro.getStatusDisponivel()) {
                System.out.println("Livros disponiveis" + livro.getTitulo());
                boolean oLivroEstaDisponivel = true;
            }
        }
        if (!todosLivrosDisponiveis) {
            System.out.println("Não há livros disponíveis no momento");
        }
    }


    //  - Realizar um empréstimo (verificar se o livro está disponível)
    public void realizarEmprestimo(Livro livro, Usuario usuario){

    }

}
