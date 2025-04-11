package model;
import java.time.LocalDate;

public class Emprestimo {

    // Chamo as classes que foram criadas que armazenam essas informações
    private Livro livro;
    private Usuario usuario;

    // Atributos específicos do emprestimo
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(14); // Prazo para devolução.
        livro.setStatusDisponivel(false);
    }

    // MÉTODO PARA DEVOLVER LIVRO. Será chamado em Biblioteca.
    public void devolverLivro() {
        livro.setStatusDisponivel(true);
    }

    // Método para exibir Empréstimo
    public void exibirEmprestimo() {
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Usuário: " + usuario.getNomeUsuario());
        System.out.println("Data do Empréstimo: " + dataEmprestimo);
        System.out.println("Data de Devolução: " + dataDevolucao);
    }

    // GETTERS DE DATA EMPRESTIMO E DEVOLUÇÃO
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }


}