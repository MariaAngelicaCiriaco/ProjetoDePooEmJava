public class Vendedor extends Pessoa {
    private double comissao;
    public Vendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double comissao) {
        super(nomeCompleto, cpf, idade, endereco, email);
        this.comissao = comissao;
    }
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    


    
}
