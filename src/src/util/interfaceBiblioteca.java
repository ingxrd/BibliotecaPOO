package util;

import model.*;
import java.util.Scanner;

/**
 * Classe responsável pela interação com o usuário através de um menu.
 * Utiliza métodos da classe Biblioteca para realizar operações.
 */
public class interfaceBiblioteca {

    // Scanner para capturar entrada do usuário
    private Scanner scanner = new Scanner(System.in);

    // Instância da biblioteca que será manipulada
    private Biblioteca biblioteca = new Biblioteca();

    /**
     * Exibe o menu principal e trata as opções do usuário em um loop contínuo.
     */
    public void menu() {
        while (true) {
            System.out.println("\n=== Menu Biblioteca ===");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Listar livros disponíveis");
            System.out.println("4. Realizar empréstimo");
            System.out.println("5. Devolver livro");
            System.out.println("6. Listar empréstimos ativos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 4:
                    realizarEmprestimo();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    biblioteca.emprestimosAtivos();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    return; // Encerra o loop e o programa
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    /**
     * Cadastra um novo livro com dados fornecidos pelo usuário.
     */
    private void cadastrarLivro() {
        System.out.println("=== Cadastro de Livro ===");
        System.out.print("ID do Livro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa quebra de linha
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Limpa quebra de linha

        Livro livro = new Livro(id, titulo, autor, ano);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    /**
     * Cadastra um novo usuário com dados fornecidos pelo usuário.
     */
    private void cadastrarUsuario() {
        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("ID do Usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa quebra de linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine(); // <- Adiciona essa linha

        Usuario usuario = new Usuario(id, nome, email); // Agora funciona
        biblioteca.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    /**
     * Solicita dados para realizar um empréstimo de livro.
     */
    private void realizarEmprestimo() {
        System.out.println("=== Realizar Empréstimo ===");
        System.out.print("ID do Livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do Usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        biblioteca.realizarEmprestimo(idLivro, idUsuario);
    }

    /**
     * Solicita dados para realizar a devolução de um livro.
     */
    private void devolverLivro() {
        System.out.println("=== Devolver Livro ===");
        System.out.print("ID do Livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do Usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        Livro livro = biblioteca.buscarLivroPorId(idLivro);
        Usuario usuario = biblioteca.buscarUsuarioPorId(idUsuario);

        if (livro != null && usuario != null) {
            biblioteca.devolverLivro(livro, usuario);
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }
}
