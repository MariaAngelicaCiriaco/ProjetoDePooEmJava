
public class Principal {

    public static void main(String[] args) {

        
        Vendedor v = new Vendedor("Paulo", "1234", 34, "Rua av", "ann@gmail.com", 10);

        v.lerVendedor();
        System.out.println(v);
        v.atualizarVendedor("Ana", "986-0", 20, "Av13", "wskdu", 12);

        
        
        
    }
}
