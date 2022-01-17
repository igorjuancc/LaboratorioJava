package view;

import java.util.Scanner;
import model.Lab02ContaCorrente;

public class Lab02Sistema {

    private static Lab02ContaCorrente conta = new Lab02ContaCorrente();

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
            conta.setNome(nomeCliente);
            conta.setNumAge(numAgencia);
            conta.setNumConta(numConta);
            conta.setSaldo(saldo);
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
            int confSaque = conta.saque(saque);

            if (confSaque == 1) {
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
            conta.deposito(deposito);
            System.out.println("Deposito realizado");
        } else {
            System.out.println("Deposito cancelado");
        }
    }
    
    public static void execImprimir(){
        System.out.println("[4] - Dados Conta Corrente\n");
        conta.imprimir();
    }    

    public static void main(String[] args) {
        int opc = 0;

        while (opc == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escolha uma opção:\n");
            System.out.println("[1] - Cadastramento");
            System.out.println("[2] - Saque");
            System.out.println("[3] - Deposito");
            System.out.println("[4] - Dados Conta Corrente");
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
                        execImprimir();
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
