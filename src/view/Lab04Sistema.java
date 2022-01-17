package view;

import java.util.Scanner;
import model.Lab03ContaCorrente;
import model.Lab04Historico;

public class Lab04Sistema {

    public static void execCadastramento() {
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        String nomeCliente, conf;
        double saldo;

        System.out.println("\n[1] - Cadastramento");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = Integer.parseInt(sc.nextLine());
        System.out.print("Numero da Conta: ");
        numConta = Integer.parseInt(sc.nextLine());
        System.out.print("Nome do Cliente: ");
        nomeCliente = sc.nextLine();
        
        System.out.println("Saldo: ");
        do{
            System.out.println("Digite o Valor: ");
            saldo = Double.parseDouble(sc.nextLine());            
        }while(saldo <= 0.0);
        
        System.out.print("\nConfirmar cadastramento (S/N): ");
        conf = sc.next().toUpperCase();

        if (conf.equals("S")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(numAgencia,numConta,nomeCliente,saldo);                        
            conta.gravar();
            System.out.println("Cadastramento realizado");
        } else {
            System.out.println("Cadastramento cancelado");
        }
    }

    public static void execSaque() {
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        double saque;
        String conf;

        System.out.println("\n[2] - Saque");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = Integer.parseInt(sc.nextLine());
        System.out.print("Numero da Conta: ");
        numConta = Integer.parseInt(sc.nextLine());
        
        System.out.println("Valor do Saque: ");
        do{
            System.out.println("Digite o Valor: ");
            saque = Double.parseDouble(sc.nextLine());           
        }while(saque <= 0.0);        

        System.out.println("\nConfirmar saque (S/N): ");
        conf = sc.next().toUpperCase();

        if (conf.equals("S")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(numAgencia,numConta);
            int confSaque = conta.saque(saque);

            if (confSaque == 1) {
                Lab04Historico hist = new Lab04Historico(numAgencia,numConta);
                hist.gravar(1,saque);
                conta.gravar();
                System.out.println("Saque realizado");
            } else {
                System.out.println("Salvo Insuficiente");
            }           
        } else {
            System.out.println("Saque cancelado");
        }
    }

    public static void execDeposito() {
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        double deposito;
        String conf;

        System.out.println("\n[3] - Deposito");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = Integer.parseInt(sc.nextLine());
        System.out.print("Numero da Conta: ");
        numConta = Integer.parseInt(sc.nextLine());
        
        System.out.println("Valor do Deposito: ");
        do{
            System.out.println("Digite o Valor: ");
            deposito = Double.parseDouble(sc.nextLine());          
        }while(deposito <= 0.0);         

        System.out.print("\nConfirmar deposito (S/N): ");
        conf = sc.next().toUpperCase();

        if (conf.equals("S")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(numAgencia,numConta);
            conta.deposito(deposito);
            conta.gravar();
            Lab04Historico hist = new Lab04Historico(numAgencia,numConta);
            hist.gravar(2,deposito);
            System.out.println("Deposito realizado");
        } else {
            System.out.println("Deposito cancelado");
        }
    }
    
    public static void execConsulta(){
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        String conf;
        
        System.out.println("[4] - Consulta\n");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = Integer.parseInt(sc.nextLine());
        System.out.print("Numero da Conta: ");
        numConta = Integer.parseInt(sc.nextLine());
        
        System.out.print("\nConfirmar consulta (S/N): ");
        conf = sc.next().toUpperCase();
        
        if (conf.equals("S")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(numAgencia,numConta);
            conta.imprimir();            
        } else {
            System.out.println("Consulta cancelada");
        }        
    }    
    
    public static void execExtrato(){
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        String conf;
        
        System.out.println("[5] - Extrato\n");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = Integer.parseInt(sc.nextLine());
        System.out.print("Numero da Conta: ");
        numConta = Integer.parseInt(sc.nextLine());
        
        System.out.print("\nConfirmar consulta (S/N): ");
        conf = sc.next().toUpperCase();
        
        if (conf.equals("S")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(numAgencia,numConta);            
            Lab04Historico hist = new Lab04Historico(numAgencia,numConta);
            conta.imprimir(); 
            hist.imprimir();            
        } else {
            System.out.println("Consulta cancelada");
        } 
        
    }
    
    public static void execRemoverContaCorrente(){
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        String conf;
        
        System.out.println("[8] - Remover Conta Corrente\n");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = Integer.parseInt(sc.nextLine());
        System.out.print("Numero da Conta: ");
        numConta = Integer.parseInt(sc.nextLine());
        
        System.out.print("\nConfirmar remoção de conta(S/N): ");
        conf = sc.next().toUpperCase();
        
        if (conf.equals("S")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(numAgencia,numConta);
            conta.removerArquivo();           
            System.out.println("Conta removida!");
        } else {
            System.out.println("Remoção cancelada");
        } 
        
    }

    public static void main(String[] args) {
        int opc = 0;

        while (opc == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escolha uma opção:\n");
            System.out.println("[1] - Cadastramento");
            System.out.println("[2] - Saque");
            System.out.println("[3] - Deposito");
            System.out.println("[4] - Consulta");
            System.out.println("[5] - Extrato");
            System.out.println("[8] - Remover Conta Corrente");
            System.out.println("[9] - Fim");
            System.out.print("\nOpcao: ");

            try {
                opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        execCadastramento();
                        opc = 0;
                        break;
                    case 2:
                        execSaque();
                        opc = 0;
                        break;
                    case 3:
                        execDeposito();
                        opc = 0;
                        break;
                    case 4:
                        execConsulta();
                        opc = 0;
                        break;
                    case 5:
                        execExtrato();
                        opc = 0;
                        break;
                    case 8:
                        execRemoverContaCorrente();
                        opc = 0;
                        break;
                    case 9:
                        System.out.println("Finalizado");
                        break;
                    default:
                        System.out.println("Opcao Invalida!!!\n");
                        opc = 0;
                }
            } catch (Exception e) {
                System.out.println("\nOpcao Inválida!!!\n");
                opc = 0;
            }
        }
    }
}
