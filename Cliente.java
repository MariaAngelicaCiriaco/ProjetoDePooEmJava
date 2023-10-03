
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa{
    private double comprovanteDeRenda;

    public Cliente(String nomeCompleto, String cpf, int idade, String endereco, String email,
            double comprovanteDeRenda) {
        super(nomeCompleto, cpf, idade, endereco, email);
        this.comprovanteDeRenda = comprovanteDeRenda;
    }

    public double getComprovanteDeRenda() {
        return comprovanteDeRenda;
    }

    public void setComprovanteDeRenda(double comprovanteDeRenda) {
        this.comprovanteDeRenda = comprovanteDeRenda;
    }


    //metodo para criar um cliente
    public static void criarCliente(List<Cliente> clientes, Cliente cliente){
        clientes.add(cliente);
    }

    //Metodo para consultar um cliente pelo CPF
    public static Cliente consultarCLiente(List<Cliente> clientes, String cpf){
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente nao encontrado!");
        return null;
    }

    //Metodo para atualizar as informaçoes de um cliente por CPF
    public static boolean atualizarCliente(List<Cliente> clientes, String cpf, Cliente novoCliente){
        Cliente clienteExistente = consultarCLiente(clientes, cpf);

        if (clienteExistente != null) {
            int index = clientes.indexOf(clienteExistente);
            clientes.set(index, novoCliente);
            return true;
        }
        return false;
    }

    //Metodo para deletar um cliente através do CPF
    public static boolean excluirCLiente(List<Cliente> clientes, String cpf){
        Cliente clienteExistente = consultarCLiente(clientes, cpf);

        if (clienteExistente != null) {
            clientes.remove(clienteExistente);
            return true;
        }
        return false;
    }

    //Metodo para ler um cliente atraves da entrada do usuario
    public static Cliente lerCliente(){
        Scanner ent = new Scanner(System.in);

        System.out.println("Nome Completo: ");
        String nomeCompleto = ent.nextLine();
        System.out.println("CPF: ");
        String cpf = ent.nextLine();
        System.out.println("Idade: ");
        int idade = ent.nextInt();
        System.out.println("Endereco: ");
        String endereco = ent.nextLine();
        System.out.println("Email: ");
        String email = ent.nextLine();
        System.out.println("Comprovante de Renda: ");
        double comprovanteDeRenda = ent.nextDouble();

        ent.close();

        return new Cliente(nomeCompleto, cpf, idade, endereco, email, comprovanteDeRenda);  
    }

    //Metodo para Realizar pagamento

    public void realizarPagamento(double valor){
        System.out.println("O pagamento no valor de R$: " + valor + "Foi feito pelo cliente: " + getNomeCompleto());
    }

    //Metodo para a solicitação do veiculo
    public void SolicitarVeiculo(Veiculo veiculo){
        System.out.println("O Cliente: " + getNomeCompleto() + "do CPF: " + getCpf() + "Solicitou o veiculo da Marca: " + veiculo.getMarca() + "do modelo:" + veiculo.getModelo());

    }

    @Override
    public String toString() {
        return "O Cliente " + super.toString() + " Comprovante De Renda: " + comprovanteDeRenda;
    }

    
    //Pricisei criar uma classe veiculo provisoria para que eu pudesse fazer o metodo de solicitar veiculo, e adicionei um novo metodo no diagrama


    


}
