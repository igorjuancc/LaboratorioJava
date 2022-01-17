package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Lab05ContaCorrenteEspecial extends Lab03ContaCorrente {

    private double limite;

    public Lab05ContaCorrenteEspecial(int numAge, int numConta, String nome, double saldo, double limite) {
        super(numAge, numConta, nome, saldo);
        this.limite = limite;
    }
    
    public Lab05ContaCorrenteEspecial(int agencia, int conta) {
        super(agencia, conta);
        recuperarLimite();
    }
    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean gravaLimite() {
        FileWriter tArq1;
        PrintWriter tArq2;

        try {
            // Operação I - Abrir o aquivo
            tArq1 = new FileWriter(getNumAge() + "." + getNumConta() + ".esp");
            tArq2 = new PrintWriter(tArq1);

            tArq2.println(getLimite());
            // Operação III - Fechar o arquivo
            tArq2.close();

            return true;
        } catch (IOException tExcept) {
            tExcept.printStackTrace();
            return false;
        }
    }
    
    private void recuperarLimite(){
        FileReader tArq1;
        BufferedReader tArq2;
        try {
            // Operação I - Abrir o arquivo
            tArq1 = new FileReader(getNumAge() + "." + getNumConta() + ".esp");
            tArq2 = new BufferedReader(tArq1);
            limite = Double.parseDouble(tArq2.readLine());            
            tArq2.close();
        } catch (IOException tExcept) {
            tExcept.printStackTrace();
        }
    }

    @Override
    public int saque(double pValor) {
        if ((saldo + limite) >= pValor) {
            saldo = saldo - pValor;
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean removerArquivo() {
        super.removerArquivo();
        File tArq1;
        tArq1 = new File(getNumAge() + "." + getNumConta() + ".esp");
        tArq1.delete();
        return true;
    }
    
    @Override
    public void imprimir() {
        NumberFormat formatter;
        formatter = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));
        formatter.setMinimumFractionDigits(2);
        
        System.out.println("Agencia: " + numAge);
        System.out.println("Conta: " + numConta);
        System.out.println("Nome: " + nome);
        System.out.println("Saldo: " + formatter.format(saldo));
        System.out.println("Limite: " + formatter.format(limite));
    }
    
}
