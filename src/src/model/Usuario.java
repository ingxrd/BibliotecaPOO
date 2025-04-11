package model;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;

    public Usuario (int idUsuario, String nomeUsuario, String emailUsuario){
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
    }

    // GETTER E SETTER DE IDUSUARIO

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    // GETTER E SETTER NOME DO USUÁRIO

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    // GETTER E SETTER DO EMAIL DO USUÁRIO

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
