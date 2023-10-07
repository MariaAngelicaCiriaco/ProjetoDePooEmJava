import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vendedor extends Pessoa {
    private double salario;
    private double comissao;
    
    public Vendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double salario) {
        super(nomeCompleto, cpf, idade, endereco, email);
        this.salario = salario;
        this.comissao = 0 ;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    // Metodos de criar, ler, atualizar e excluir
    public static List<Vendedor> vendedor = new ArrayList<>();

    public static void criarVendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double salario){
        Vendedor novoVendedor = new Vendedor( nomeCompleto, cpf, idade, endereco,  email,  salario);

        vendedor.add(novoVendedor);
        System.out.println("Vendedor criado com sucesso!");
    }

    //vendedor vai ser procurado pelo CPF
    // Vendedor encontrado, sair do loop
    public static void lerVendedor(String cpf) {
        for (Vendedor vendedor : vendedor) {
            if (vendedor.getCpf().equals(cpf)) {
                System.out.println("====== Informações do Vendedor: ======");
                System.out.println("Nome: " + vendedor.getNomeCompleto());
                System.out.println("CPF: " + vendedor.getCpf());
                System.out.println("Endereço: " + vendedor.getEndereco());
                System.out.println("E-mail: " + vendedor.getEmail());
                return;
            }
        }
        System.out.println("Vendedor não encontrado.");
    }

    public static void atualizarVendedor(String cpf, String novoEndereco, String novoEmail) {
        for (Vendedor vendedor : vendedor) {
            if (vendedor.getCpf().equals(cpf)) {
                vendedor.setEndereco(novoEndereco);
                vendedor.setEmail(novoEmail);
                System.out.println("Dados do vendedor atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Vendedor não encontrado!");
    }

    public static void excluirVendedor(String cpf) {
        Iterator<Vendedor> iterator = vendedor.iterator();
        while (iterator.hasNext()) {
            Vendedor vendedor = iterator.next();
            if (vendedor.getCpf().equals(cpf)) {
                iterator.remove();
                System.out.println("Vendedor: "+vendedor.getNomeCompleto()+", excluído com sucesso!");
                return;
            }
        }
        System.out.println("Vendedor não encontrado¹");
    }
    
    public static double calcularSalario(double salario, double comissao) {
        return salario +(salario * ( comissao / 100));
    }


     public static void salvarDados(String nomeArquivo){ 
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo); //cria um escritor de arquivo
            PrintWriter printWriter = new PrintWriter(fileWriter); //cria um buffer de escrita
            
            for (Vendedor vendedor : vendedor) {
                printWriter.println("Nome Compelto: " + vendedor.getNomeCompleto() + "\nCPF: " + vendedor.getCpf() + "\nIdade: " + vendedor.getIdade() + "\nEndereco: " 
                + vendedor.getEndereco() + "\nEmail: " + vendedor.getEmail() +"\nSalario:" +vendedor.getSalario()+"\n"); //escreve os dados da turma no arquivo
            }
            printWriter.close(); //fecha o buffer de escrita
        } catch (IOException e) { //trata exceções de entrada e saída
            System.out.println("Ocorreu um erro ao salvar os dados no arquivo: " + nomeArquivo + "\n");
            e.printStackTrace();
        }
    }

    /**
     * @param nomeArquivo
     */
    public static void lerDados(String nomeArquivo) {
        try {
            FileReader fileReader = new FileReader(nomeArquivo); // cria um leitor de arquivo
            BufferedReader bufferedReader = new BufferedReader(fileReader); // cria um buffer de leitura
    
            String linha;
            while ((linha = bufferedReader.readLine()) != null) { // enquanto houver linhas para ler
                String[] dados = linha.split(";"); // separa os dados da linha
    
                // Certifique-se de que haja dados suficientes na linha antes de criar um Vendedor
                if (dados.length >= 6) {
                    String nomeCompleto = dados[0].trim(); // remova espaços em branco
                    String cpf = dados[1].trim(); // remova espaços em branco
                    int idade = Integer.parseInt(dados[2].trim()); // remova espaços em branco
                    String endereco = dados[3].trim(); // remova espaços em branco
                    String email = dados[4].trim(); // remova espaços em branco
                    double salario = Double.parseDouble(dados[5].trim()); // remova espaços em branco
    
                    // Crie um novo Vendedor com os dados lidos da linha
                    Vendedor vendedor = new Vendedor(nomeCompleto, cpf, idade, endereco, email, salario);
    
                    // Exiba os detalhes do vendedor
                    System.out.println("Nome Completo: " + vendedor.getNomeCompleto());
                    System.out.println("CPF: " + vendedor.getCpf());
                    System.out.println("Idade: " + vendedor.getIdade());
                    System.out.println("Endereco: " + vendedor.getEndereco());
                    System.out.println("Email: " + vendedor.getEmail());
                    System.out.println("Salario: " + vendedor.getSalario());
                    System.out.println();
                }
            }
    
            bufferedReader.close(); // fecha o buffer de leitura
    
        } catch (IOException e) { // trata exceções de entrada e saída
            System.out.println("Ocorreu um erro ao carregar os dados do arquivo: " + nomeArquivo + "\n");
            e.printStackTrace();
        } catch (NumberFormatException e) { // trata exceções de conversão de número
            System.out.println("Erro ao converter número.");
            e.printStackTrace();
        }
    }
    


} 