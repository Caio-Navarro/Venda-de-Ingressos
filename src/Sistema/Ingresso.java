package Sistema;

public class Ingresso {
    private String id;
    private double valor;
    private String status;
    private int quantidade;
    
    public Ingresso(String id, double valor, String status, int quantidade){
        this.id = id;
        this.valor = valor;
        this.status = status;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
