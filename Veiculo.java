import java.io.*; 
import java.util.ArrayList;
import java.util.List;
public class Veiculo {
	private String marca;
    private String modelo;
    private int anoDeFabricacao;
    private String cor;
    private String estadoDoVeiculo;
    private int quantidade;

    public Veiculo(String marca, String modelo, int anoDeFabricacao, String cor, String estadoDoVeiculo, int quantidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.cor = cor;
        this.estadoDoVeiculo = estadoDoVeiculo;
        this.quantidade = quantidade;
    }

    // Métodos getters e setters 
    
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

	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
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
    public static Veiculo criarVeiculoEmArquivo(String marca, String modelo, int anoDeFabricacao, String cor, String estadoDoVeiculo, int quantidade, String nomeArquivo) {
        Veiculo veiculo = new Veiculo(marca, modelo, anoDeFabricacao, cor, estadoDoVeiculo, quantidade);
        List<Veiculo> veiculos = lerVeiculosEmArquivo(nomeArquivo);
        veiculos.add(veiculo);
        salvarVeiculosEmArquivo(veiculos, nomeArquivo);
        return veiculo;
    }

	public void atualizarVeiculoEmArquivo(String nomeArquivo) {
        List<Veiculo> veiculos = lerVeiculosEmArquivo(nomeArquivo);
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).marca.equals(this.marca) && veiculos.get(i).modelo.equals(this.modelo)) {
                veiculos.set(i, this);
                salvarVeiculosEmArquivo(veiculos, nomeArquivo);
                break;
            }
        }
    }

    public static void excluirVeiculoEmArquivo(String marca, String modelo, String nomeArquivo) {
        List<Veiculo> veiculos = lerVeiculosEmArquivo(nomeArquivo);
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).marca.equals(marca) && veiculos.get(i).modelo.equals(modelo)) {
                veiculos.remove(i);
                salvarVeiculosEmArquivo(veiculos, nomeArquivo);
                break;
            }
        }
    }

    public static void listarVeiculosEmArquivo(String nomeArquivo) {
        List<Veiculo> veiculos = lerVeiculosEmArquivo(nomeArquivo);
        for (Veiculo veiculo : veiculos) {
            veiculo.lerVeiculo();
            System.out.println("===============");
        }
    }

    public void atualizarEstoqueEmArquivo(int quantidade, String nomeArquivo) {
        this.quantidade += quantidade;
        atualizarVeiculoEmArquivo(nomeArquivo);
    }

    public void lerVeiculo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de Fabricação: " + anoDeFabricacao);
        System.out.println("Cor: " + cor);
        System.out.println("Estado do Veículo: " + estadoDoVeiculo);
        System.out.println("Quantidade em Estoque: " + quantidade);
    }

    public static List<Veiculo> lerVeiculosEmArquivo(String nomeArquivo) {
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String marca = "";
            String modelo = "";
            int anoDeFabricacao = 0;
            String cor = "";
            String estadoDoVeiculo = "";
            int quantidade = 0;

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                if (linha.startsWith("Marca: ")) {
                    marca = linha.substring("Marca: ".length()).trim();
                } else if (linha.startsWith("Modelo: ")) {
                    modelo = linha.substring("Modelo: ".length()).trim();
                } else if (linha.startsWith("Ano de Fabricação: ")) {
                    anoDeFabricacao = Integer.parseInt(linha.substring("Ano de Fabricação: ".length()).trim());
                } else if (linha.startsWith("Cor: ")) {
                    cor = linha.substring("Cor: ".length()).trim();
                } else if (linha.startsWith("Estado do Veículo: ")) {
                    estadoDoVeiculo = linha.substring("Estado do Veículo: ".length()).trim();
                } else if (linha.startsWith("Quantidade em Estoque: ")) {
                    quantidade = Integer.parseInt(linha.substring("Quantidade em Estoque: ".length()).trim());

                    Veiculo veiculo = new Veiculo(marca, modelo, anoDeFabricacao, cor, estadoDoVeiculo, quantidade);
                    veiculos.add(veiculo);

                    marca = "";
                    modelo = "";
                    anoDeFabricacao = 0;
                    cor = "";
                    estadoDoVeiculo = "";
                    quantidade = 0;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao carregar os veículos do arquivo: " + nomeArquivo + "\n");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número.");
            e.printStackTrace();
        }

        return veiculos;
    }

    public static void salvarVeiculosEmArquivo(List<Veiculo> veiculos, String nomeArquivo) {
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Veiculo veiculo : veiculos) {
                printWriter.println("Marca: " + veiculo.getMarca());
                printWriter.println("Modelo: " + veiculo.getModelo());
                printWriter.println("Ano de Fabricação: " + veiculo.getAnoDeFabricacao());
                printWriter.println("Cor: " + veiculo.getCor());
                printWriter.println("Estado do Veículo: " + veiculo.getEstadoDoVeiculo());
                printWriter.println("Quantidade em Estoque: " + veiculo.getQuantidade());
                printWriter.println();
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os veículos no arquivo: " + nomeArquivo + "\n");
            e.printStackTrace();
        }
    }

    public static Veiculo buscarVeiculoEmArquivo(String marca, String modelo, String nomeArquivo) {
        List<Veiculo> veiculos = lerVeiculosEmArquivo(nomeArquivo);
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMarca().equals(marca) && veiculo.getModelo().equals(modelo)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", anoDeFabricacao=" + anoDeFabricacao + ", cor="
                + cor + ", estadoDoVeiculo=" + estadoDoVeiculo + ", quantidade=" + quantidade + "]";
    }

    public boolean isVendido() {
        return false;
    }
}
	
	    


  