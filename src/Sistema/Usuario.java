package Sistema;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private int ingressosComprados;
    
    public Usuario(String login, String senha, String nome, String cpf, String email, int id){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngressosComprados() {
        return ingressosComprados;
    }

    public void setIngressosComprados(int ingressosComprados) {
        this.ingressosComprados = ingressosComprados;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
