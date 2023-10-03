public abstract class Pessoa{
    private String nomeCompleto;
    private String cpf;
    protected static int idade;
    private String endereco;
    private String email;


    public Pessoa(String nomeCompleto, String cpf, int idade, String endereco, String email) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.email = email;
    }


    public String getNomeCompleto() {
        return nomeCompleto;
    }


    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Nome Completo: " + nomeCompleto + ", CPF: " + cpf + ", Idade: " + idade + ", Endereço: " + endereco
                + ", Email: " + email;
    }

}
