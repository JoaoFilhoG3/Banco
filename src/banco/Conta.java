package banco;

import javax.swing.JOptionPane;

public class Conta {

    private int numeroDaConta;
    private int tipo; //1= corrente e 2 = poupança 
    private double saldo;
    private String dono;
    private boolean status;

    public Conta(int numeroDaConta, int tipo, String dono) {
        this.status = false;
        this.saldo = 0;
        this.numeroDaConta = numeroDaConta;
        this.tipo = tipo;
        this.dono = dono;

    }

    public String getDono() {
        return this.dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(double valor) {
        if (!status) {
            this.saldo = valor;
            this.status = true;

        }
    }

    public void fecharConta() {
        if (saldo > 0){
            int escolha = JOptionPane.showConfirmDialog(null, "Ainda tem saldo na conta, deseja sacar?");
            if (escolha == JOptionPane.OK_OPTION){
                this.sacar(this.saldo);
                this.status = false;
            }
        }else if(saldo < 0){
            int escolha = JOptionPane.showConfirmDialog(null, "Deposite algo antes de fechar.");
            if(escolha == JOptionPane.OK_OPTION){
                this.depositar(this.saldo*-1);
                this.status = false;
            }
        }else{
            this.status = false;
            System.out.println("Fechar conta.");
        }
    }

    public void sacar(double saque) {
        if (saque <= this.saldo) {
            this.saldo = this.saldo - saque;
        } else {
            System.out.println("Você esta sem verba KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
        }
    }

    public void verSaldo() {
        System.out.println("Numero da conta: " + this.numeroDaConta);
        if (this.tipo == 1) {
            System.out.println("tipo da conta: conta corrente");

        } else if (this.tipo == 2) {
            System.out.println("tipo da conta: conta poupança");
        } else {
            System.out.println("valor inválido");
        }
        System.out.println("Saldo da conta: " + this.saldo);
        System.out.println("Dono: " + this.dono);
        System.out.println("Status: " + this.status);

    }

    public void depositar(double deposito) {
        this.saldo = this.saldo + deposito;
    }

    public void pagarMensalidade() {
        if (this.tipo == 1) {
            this.saldo = this.saldo - 24;

        } else if (this.tipo == 2) {
            this.saldo = this.saldo - 12;

        }
    }
    public void transferir(Conta contaDestino,double valor){
        if (valor <= this.saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("você não tem saldo suficiente para efetuar essa tranferência");
        }
    }

}


