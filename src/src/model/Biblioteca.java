package model;

import java.util.ArrayList;

public class Biblioteca {

    // Lista de livros cadastrados na biblioteca
    private ArrayList<Livro> listaDelivros = new ArrayList<>();

    // Lista de usuários cadastrados
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    // Lista de empréstimos realizados
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    // Construtor da classe Biblioteca
    public Biblioteca() {
        this.listaDelivros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    // ----------------------
    // Métodos principais
    // ----------------------

    /**
     * Lista todos os livros que estão disponíveis para empréstimo.
     */
    public void listarLivrosDisponiveis() {
        boolean encontrouDisponivel = false;
        for (Livro livro : listaDelivros) {
            if (livro.getStatusDisponivel()) {
                System.out.println("Livro disponível: " + livro.getTitulo());
                encontrouDisponivel = true;
            }
        }
        if (!encontrouDisponivel) {
            System.out.println("Não há livros disponíveis no momento.");
        }
    }

    /**
     * Realiza um empréstimo com base nos IDs do livro e do usuário.
     */
    public void realizarEmprestimo(int idLivro, int idUsuario) {
        Livro livro = buscarLivroPorId(idLivro);
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (livro != null && usuario != null) {
            realizarEmprestimo(livro, usuario);
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    /**
     * Realiza a devolução de um livro por um determinado usuário.
     */
    public void devolverLivro(Livro livro, Usuario usuario) {
        if (!livro.getStatusDisponivel()) {
            boolean emprestimoEncontrado = false;
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getLivro().equals(livro) && emprestimo.getUsuario().equals(usuario)) {
                    emprestimos.remove(emprestimo);
                    livro.setStatusDisponivel(true);
                    System.out.println("Livro devolvido com sucesso!");
                    emprestimoEncontrado = true;
                    break;
                }
            }
            if (!emprestimoEncontrado) {
                System.out.println("Nenhum empréstimo correspondente encontrado.");
            }
        } else {
            System.out.println("Este livro já está disponível.");
        }
    }

    /**
     * Lista todos os empréstimos que estão ativos (livros não devolvidos).
     */
    public void emprestimosAtivos() {
        boolean encontrouEmprestimoAtivo = false;

        for (Emprestimo emprestimo : emprestimos) {
            if (!emprestimo.getLivro().getStatusDisponivel()) {
                emprestimo.exibirEmprestimo();
                System.out.println("-----------------------------");
                encontrouEmprestimoAtivo = true;
            }
        }

        if (!encontrouEmprestimoAtivo) {
            System.out.println("Não há empréstimos ativos no momento.");
        }
    }

    // ----------------------
    // Métodos auxiliares
    // ----------------------

    /**
     * Adiciona um novo livro à lista da biblioteca.
     */
    public void adicionarLivro(Livro livro) {
        listaDelivros.add(livro);
        System.out.println("Livro adicionado com sucesso: " + livro.getTitulo());
    }

    /**
     * Adiciona um novo usuário à biblioteca.
     */
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso: " + usuario.getNomeUsuario());
    }

    /**
     * Busca e retorna um livro pelo seu ID.
     */
    public Livro buscarLivroPorId(int id) {
        for (Livro livro : listaDelivros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    /**
     * Busca e retorna um usuário pelo seu ID.
     */
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == id) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Realiza o empréstimo de um livro para um usuário, caso o livro esteja disponível.
     */
    private void realizarEmprestimo(Livro livro, Usuario usuario) {
        if (livro.getStatusDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, usuario);
            emprestimos.add(emprestimo);
            livro.setStatusDisponivel(false); // marca como emprestado
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

}
