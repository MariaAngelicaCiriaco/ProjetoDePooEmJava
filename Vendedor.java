import java.util.Scanner;

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

    
    public void criarVendedor() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Cadastro de Vendedor:");
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("CPF: ");
        String cpf = entrada.nextLine();
        System.out.println("Idade: ");
        int idade = entrada.nextInt();
        System.out.println("Endereço: ");
        String endereco = entrada.nextLine();
        System.out.println("Email");
        String email = entrada.nextLine();
        System.out.println("Comissao: ");
        double comissao = entrada.nextDouble();
        System.out.println("Informações do Vendedor: \n Nome:" + nome + " CPF: " + cpf+ " Ideda: "+idade+" Endereço: " +endereco+ " Email: "+ email+ "Comissão: "+comissao);
        
    }



    // public Vendedor criarVendedor(String nomeCompleto, String cpf, int idade, String endereco, String email) {
    //       return new Vendedor(nomeCompleto, cpf, idade, endereco, email, comissao);
    // }


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
        System.out.println("Vendedor excluído: " + getNomeCompleto());
    }

    public double calcularSalario() {
        double salario;
        salario = + this.comissao;
        return salario;
    }

}

