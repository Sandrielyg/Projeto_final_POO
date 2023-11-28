package BancoJava;

import utilitarios.Utils;

public class Conta {

    private static int contadorConta = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;


    public Conta(Pessoa pessoa) {
        this.numeroConta = Conta.contadorConta;
        this.pessoa = pessoa;
        this.updateSaldo();
        Conta.contadorConta += 1;
    }


    public int getNumeroConta() {
        return numeroConta;
    }
    public Pessoa getClient() {
        return pessoa;
    }
    public void setClient(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString() {

        return "\nConta: " + this.getNumeroConta() +
                "\nCliente: " + this.pessoa.getName() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo Bancário: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
    	Double taxa = 2.0; 
    	
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - (valor + taxa));
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferencia(Conta contaParaDeposito, Double valor) {
        Double valorComTaxa = valor + 5.0; 

        if (valorComTaxa > 0 && this.getSaldo() >= valorComTaxa) {
            setSaldo(getSaldo() - valorComTaxa);
            contaParaDeposito.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }

}
