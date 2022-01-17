package view;

import java.util.Scanner;

public class Lab01Sistema {

    public static void execCadastramento() {
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        String nomeCliente, conf;
        float saldo;

        System.out.println("\n[1] - Cadastramento");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = sc.nextInt();
        System.out.print("Numero da Conta: ");
        numConta = sc.nextInt();
        System.out.print("Nome do Cliente: ");
        nomeCliente = sc.next();
        System.out.print("Saldo: ");
        saldo = sc.nextFloat();
        System.out.print("\nConfirmar cadastramento (S/N): ");
        conf = sc.next().toUpperCase();

        if (conf.equals("S")) {
            System.out.println("Cadastramento realizado");
        } else{
            System.out.println("Cadastramento cancelado");
        }
    }
    
    public static void execSaque(){
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        float saque;
        String conf;
        
        System.out.println("\n[2] - Saque");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = sc.nextInt();
        System.out.print("Numero da Conta: ");
        numConta = sc.nextInt();
        System.out.print("Valor do Saque: ");
        saque = sc.nextFloat();
        
        System.out.print("\nConfirmar saque (S/N): ");
        conf = sc.next().toUpperCase();

        if (conf.equals("S")) {
            System.out.println("Saque realizado");
        } else{
            System.out.println("Saque cancelado");
        }
    }
    
    public static void execDeposito(){
        Scanner sc = new Scanner(System.in);
        int numAgencia, numConta;
        float deposito;
        String conf;
        
        System.out.println("\n[3] - Deposito");
        System.out.print("\nNumero da Agencia: ");
        numAgencia = sc.nextInt();
        System.out.print("Numero da Conta: ");
        numConta = sc.nextInt();
        System.out.print("Valor do Deposito: ");
        deposito = sc.nextFloat();
        
        System.out.print("\nConfirmar deposito (S/N): ");
        conf = sc.next().toUpperCase();

        if (conf.equals("S")) {
            System.out.println("Deposito realizado");
        } else{
            System.out.println("Deposito cancelado");
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
            System.out.println("[9] - Fim");
            System.out.print("\nOpcao: ");

            try {
                opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        execCadastramento();
                        break;
                    case 2:
                        execSaque();
                        break;
                    case 3:
                        execDeposito();
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
