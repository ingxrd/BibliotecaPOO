package model;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean statusDisponivel;

    public Livro(int idLivro, String titulo, String autor, int anoPublicacao, boolean statusDisponivel){
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.statusDisponivel = true;
    }

    // GETTER E SETTER DE ID

    public int getId() {
        return idLivro;
    }

    public void setidLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    // GETTER E SETTER DE TÍTULO

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // GETTER E SETTER DE AUTOR
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // GETTER E SETTER DE ANO PUBLICAÇÃO
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    // GETTER E SETTER STATUS DISPONÍVEL
    public boolean getStatusDisponivel() {
        return statusDisponivel;
    }

    public void setStatusDisponivel(boolean statusDisponivel) {
        this.statusDisponivel = statusDisponivel;
    }
}
