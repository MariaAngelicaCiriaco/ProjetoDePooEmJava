import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Venda{
    private String status;
    private LocalDate data;
    private double valor;
    private Veiculo veiculo;
    private Cliente cliente;
    private Vendedor vendedor;

    public Venda(String status, LocalDate data, double valor, Veiculo veiculo, Cliente cliente, Vendedor vendedor) {
        this.status = status;
        this.data = data;
        this.valor = valor;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public static void criarVenda(List <Venda> vendas, Venda venda ){
        vendas.add(venda);
    }

    public static Venda consultarVenda(List <Venda> vendas, LocalDate data){
        for (Venda venda : vendas) {
            if (venda.getData().equals(data)){
                return venda;
            }
        }
        System.out.println("Venda nao encontrada!");
        return null;
    }

    //atualizar vendas
    public static boolean atualizarVenda(List <Venda> vendas, LocalDate data, Venda novaVenda){
        Venda vendaExistente = consultarVenda(vendas, data);
        if (vendaExistente != null) {
            int index = vendas.indexOf(vendaExistente);
            vendas.set(index, novaVenda);
            return true;
        }
        return false;

    }

    //deletar venda
    public static boolean deletarVenda(List <Venda> vendas, LocalDate data){
        Venda vendaExistente = consultarVenda(vendas, data);
        if (vendaExistente != null) {
            vendas.remove(vendaExistente);
            return true;
        }
        return false;
    }

    //Ler vendas
    public static Venda lerVenda(List <Veiculo> veiculos, List <Cliente> clientes, List <Vendedor> vendedores){
        Scanner ent = new Scanner(System.in);

        System.out.print("Status da Venda: ");
        String status = ent.nextLine();
        System.out.print("Data da Venda (DD-MM-AAAA): ");
        String stringData = ent.nextLine();
        LocalDate data = LocalDate.parse(stringData);
        System.out.println("Valor da Venda");
        double valor = ent.nextDouble();

        //listar os veiculos disponiveis
        System.out.println("Veiculos Disponiveis: ");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (!veiculo.isVendido()) {
                System.out.println("O veiculo " + i + ". " + veiculo.getMarca() + veiculo.getModelo());  
            }    
        }

        System.out.println(" Selecione o veiculo (Digite um numero): ");
        int veiculoIndex = ent.nextInt();
        ent.nextLine();
        Veiculo veiculoSelecionado = veiculos.get(veiculoIndex);

        //Listagem dos Clientes
        System.out.println("Clientes no Sistema: ");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println("O Cliente: " + i + ". " + cliente.getNomeCompleto());

        }

        System.out.println("Selecione um Cliente ( Digite o numero ): ");
        int  clienteIndex = ent.nextInt();
        ent.nextLine();
        Cliente clienteEscolhido = clientes.get(clienteIndex);


        System.out.println("Vendedores disponiveis: ");
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor vendedor = vendedores.get(i);
            System.out.println("O vendedor: " + i + " . " + vendedor.getNomeCompleto());   
        }

        System.out.println("Selecione um Vendedor ( Digite o numero ): ");
        int vendedorIndex = ent.nextInt();
        ent.nextLine();
        Vendedor vendedorEscolhido = vendedores.get(vendedorIndex);

        ent.close();

        return new Venda(status, data, valor, veiculoSelecionado, clienteEscolhido, vendedorEscolhido);
    }

    //Criar uma Solicitação de venda
    public static Venda criarSolicitacao(List <Cliente> clientes, List <Veiculo> veiculos, Cliente cliente, Vendedor vendedor){
        Scanner ent = new Scanner(System.in);

        System.out.println("Solicitacao de Veiculo: ");
        System.out.print("Data da Solicitacao (DD-MM-AAAA): ");
        String dataString = ent.nextLine();
        LocalDate data = LocalDate.parse(dataString);

        //listar veiculos disponiveis para solicitação
        System.out.println("Veiculos disponiveis para a solicitacao: ");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (!veiculo.isVendido()) {
                System.out.println("O veiculo: " + i + ". " + veiculo.getMarca() + veiculo.getModelo());
            }
        }

        System.out.println(" Selecione o veiculo (Digite um numero): ");
        int veiculoIndex = ent.nextInt();
        ent.nextLine();
        Veiculo veiculoSelecionado = veiculos.get(veiculoIndex);

        System.out.println("Solicitacao Criada!!");
        String status = "Pendente";

        ent.close();

        return new Venda(status, data, 0, veiculoSelecionado, cliente, vendedor);
    }

    //Falar com o grupo antes de adicionar esse Metodo:
    /*  public void calcularValorVenda(){
        double precoVeiculo = veiculo.getPreco();
        valor = precoVeiculo;
        System.out.println("Valor o valor da venda foi de R$" + valor);
    }*/

    //Listar Solicitação Pendente
    public static void listarSolicitacoesPententes(List <Venda> vendas){
        System.out.println("Solicitacoes Pendentes: ");
        for (Venda venda : vendas) {
            if ("Pendente".equalsIgnoreCase(venda.status)) {
                System.out.println(" DATA: " + venda.getData());
                System.out.println(" CLIENTE: " + venda.getCliente().getNomeCompleto());
                System.out.println(" VEICULO: " + venda.getVeiculo().getMarca() + " " + venda.getVeiculo().getModelo());
                System.out.println("-------------------------");
            } 
        }
    }

    public static void listarRegistroDeVendas(List <Venda> vendas){
        System.out.println("Registro de Vendas: ");
        for (Venda venda : vendas) {
            System.out.println(" STATUS: " + venda.getStatus());
            System.out.println(" DATA: " + venda.getData());
            System.out.println(" VALOR: " + venda.getValor());
            System.out.println(" CLIENTE: " + venda.getCliente().getNomeCompleto());
            System.out.println(" VEICULO: " + venda.getVeiculo().getMarca() + " " + venda.getVeiculo().getModelo());
            System.out.println(" VENDEDOR: " + venda.getVendedor().getNomeCompleto());
            System.out.println("-------------------------"); 
        }
    }

    public static void excluirSolicitacao(List <Venda> vendas){
        Scanner ent = new Scanner(System.in);

        System.out.println("Digite a data da Solicitacao para ser excluida (DD-MM-AAAA): ");
        String dataString = ent.nextLine();
        LocalDate data = LocalDate.parse(dataString);

        Venda solicitacaoParaExcluir = null;

        for (Venda venda : vendas) {
            if ("Pendente".equalsIgnoreCase(venda.getStatus()) && venda.getData().equals(data)) {
                solicitacaoParaExcluir = venda;
                break;
            }
        }

        if (solicitacaoParaExcluir != null) {
            vendas.remove(solicitacaoParaExcluir);
            System.out.println(" Solicitacao Excluida!!");
        }else{
            System.out.println(" A solicitacao nao esta pendente ou nao existe!");
        }

        ent.close();
    }
}