import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Veiculo{
	private String marca;
    private String modelo;
    private int anoFabricacao;
    private String cor;
    private String estadoDoVeiculo;
    private int quantidade;

    // Construtor
    public Veiculo(String marca, String modelo, int anoFabricacao, String cor, String estadoDoVeiculo, int quantidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.estadoDoVeiculo = estadoDoVeiculo;
        this.quantidade = quantidade;
    }
    
    //Getters e Setters
    public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAnoFabricacao() {
		return anoFabricacao;
	}


	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getEstadoDoVeiculo() {
		return estadoDoVeiculo;
	}


	public void setEstadoDoVeiculo(String estadoDoVeiculo) {
		this.estadoDoVeiculo = estadoDoVeiculo;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	// Método para criar um novo veículo
    public static Veiculo criarVeiculo(String marca, String modelo, int anoFabricacao, String cor, String estadoDoVeiculo, int quantidade) {
        return new Veiculo(marca, modelo, anoFabricacao, cor, estadoDoVeiculo, quantidade);
    }

    // Método para ler os detalhes de um veículo
    public void lerVeiculo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de Fabricação: " + anoFabricacao);
        System.out.println("Cor: " + cor);
        System.out.println("Estado do Veículo: " + estadoDoVeiculo);
        System.out.println("Quantidade em Estoque: " + quantidade);
    }

    // Método para atualizar os detalhes de um veículo
    public void atualizarVeiculo(String marca, String modelo, int anoFabricacao, String cor, String estadoDoVeiculo, int quantidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.estadoDoVeiculo = estadoDoVeiculo;
        this.quantidade = quantidade;
    }

    // Método para excluir um veículo com base na marca e no modelo
    public static void excluirVeiculo(List<Veiculo> veiculos, String marca, String modelo) {
        Iterator<Veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.marca.equals(marca) && veiculo.modelo.equals(modelo)) {
                iterator.remove();
                System.out.println("Veículo removido: " + veiculo.marca + " " + veiculo.modelo);
            }
        }
    }


    // Método para listar os detalhes do veículo
    public static void listarVeiculo(List<Veiculo> veiculos) {
        for (Veiculo veiculo : veiculos) {
            veiculo.lerVeiculo();
            System.out.println("===============");
        }
    }

    // Método para atualizar o estoque de um veículo
    public void atualizarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", anoFabricacao=" + anoFabricacao + ", cor=" + cor
				+ ", estadoDoVeiculo=" + estadoDoVeiculo + ", quantidade=" + quantidade + "]";
	}
    
}