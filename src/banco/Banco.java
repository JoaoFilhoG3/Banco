package banco;

public class Banco {

    public static void main(String[] args) {
        Conta c1 = new Conta(1, 2, "João Filho");
        Conta c2 = new Conta(2, 1, "Icaro   ");

        c1.abrirConta(2000);
        c2.abrirConta(100);

        c1.verSaldo();
        System.out.println("");
        c2.verSaldo();

        c1.transferir(c2, 500);

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        c1.verSaldo();
        System.out.println("");
        c2.verSaldo();
    }

}
