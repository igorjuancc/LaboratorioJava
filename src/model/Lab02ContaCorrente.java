package model;

public class Lab02ContaCorrente {
    private int numAge;
    private int numConta;
    private String nome;
    private double saldo;

    public Lab02ContaCorrente() {
    }

    public int getNumAge() {
        return numAge;
    }

    public void setNumAge(int numAge) {
        this.numAge = numAge;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public int saque(double pValor){
        if(saldo >= pValor){
            saldo = saldo - pValor;
            return 1;
        }else{
            return 0;
        }        
    }
    
    public void deposito (double pValor){
        saldo = saldo + pValor;
    }
    
    public void imprimir(){
        System.out.println("Cliente: " + nome);
        System.out.println("Numero da Agencia: " + numAge);
        System.out.println("Numero da Conta: " + numConta);
        System.out.println("Saldo em Conta: " + saldo);
    }
}
