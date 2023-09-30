
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

    public static Vendedor criarVendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double comissao) {
        return new Vendedor(nomeCompleto, cpf, idade, endereco, email, comissao);
    }
 
    public void lerVendedor() {
        System.out.println("Informações do vendedor: ");
        System.out.println("Nome: " + getNomeCompleto());
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Email: " + getEmail());
        System.out.println("Comissão: " + comissao);
    }

    public void atualizarVendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double comissao) {
        setNomeCompleto(nomeCompleto);
        setCpf(cpf);
        setIdade(idade);
        setEndereco(endereco);
        setEmail(email);
        this.comissao = comissao;
    }
    public void excluirVendedor() {
        System.out.println("Vendedor excluído: " + getComissao());
    }

    public double calcularSalario() {
        double salario;
        salario = + this.comissao;
        return salario;
    }

}

