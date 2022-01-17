package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;

public class Lab04Historico {

    private int numAge;
    private int numConta;
    private int dia;
    private int mes;
    private int ano;
    private int hora;
    private int min;
    private int seg;
    private int codHist;
    private double valor;
    private Vector vetOperacoes;

    public Lab04Historico(int numAge, int numConta) {
        this.numAge = numAge;
        this.numConta = numConta;
    }

    public boolean gravar(int p_hist, double p_valor) {
        FileWriter tArq1;
        PrintWriter tArq2;
        try {
            // Operação I - Abrir o aquivo
            tArq1 = new FileWriter(numAge + "." + numConta + ".hist", true);
            tArq2 = new PrintWriter(tArq1);

            Date hoje = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(hoje);
            dia = cal.get(Calendar.DAY_OF_MONTH);
            // O mês em Java inicia com 0
            mes = cal.get(Calendar.MONTH) + 1;
            ano = cal.get(Calendar.YEAR);
            hora = cal.get(Calendar.HOUR);
            min = cal.get(Calendar.MINUTE);
            seg = cal.get(Calendar.SECOND);

            tArq2.print(numAge + " ");
            tArq2.print(numConta + " ");
            tArq2.print(dia + " ");
            tArq2.print(mes + " ");
            tArq2.print(ano + " ");
            tArq2.print(hora + " ");
            tArq2.print(min + " ");
            tArq2.print(seg + " ");
            tArq2.print(p_hist + " ");
            tArq2.println(p_valor);
            // Operação III - Fechar o arquivo
            tArq2.close();
            return true;
        } catch (IOException tExcept) {
            tExcept.printStackTrace();
            return false;
        }
    }

    public void imprimir() {
        recuperarHistorico();

        if (vetOperacoes.isEmpty()) {
            System.out.println("Sem Transações");
        } else {
            String dados[] = new String[9];
            for (Object dado : vetOperacoes) {
                dados = dado.toString().split(" ");

                DecimalFormat formatter = new DecimalFormat("0000000");
                dados[1] = formatter.format(Integer.parseInt(dados[1]));
                formatter = new DecimalFormat("0000");
                dados[0] = formatter.format(Integer.parseInt(dados[0]));
                dados[4] = formatter.format(Integer.parseInt(dados[4]));
                formatter = new DecimalFormat("00");
                dados[2] = formatter.format(Integer.parseInt(dados[2]));
                dados[3] = formatter.format(Integer.parseInt(dados[3]));
                dados[5] = formatter.format(Integer.parseInt(dados[5]));
                dados[6] = formatter.format(Integer.parseInt(dados[6]));
                dados[7] = formatter.format(Integer.parseInt(dados[7]));

                if (Integer.parseInt(dados[8]) == 1) {
                    dados[8] = "Saque Caixa";
                } else {
                    dados[8] = "Deposito Dinheiro";
                }

                double valorOp = Double.parseDouble(dados[9]);
                NumberFormat fmt;
                fmt = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));
                fmt.setMinimumFractionDigits(2);
                dados[9] = fmt.format(valorOp);
                
                StringBuffer sb = new StringBuffer ();
                sb.append(dados[0]);sb.append(" ");
                sb.append(dados[1]);sb.append(" ");
                sb.append(dados[2]);sb.append("/");
                sb.append(dados[3]);sb.append("/");
                sb.append(dados[4]);sb.append(" - ");
                sb.append(dados[5]);sb.append(":");
                sb.append(dados[6]);sb.append(":");
                sb.append(dados[7]);sb.append(" - ");
                sb.append(dados[8]);sb.append(" ");
                sb.append(dados[9]);
                
                System.out.println(sb);
            }
            System.out.println("-------------------------------");
        }
    }

    public void recuperarHistorico() {
        FileReader tArq1;
        BufferedReader tArq2;
        String tLinha = null;
        vetOperacoes = new Vector();
        try {
            // Operação I - Abrir o arquivo
            tArq1 = new FileReader(numAge + "." + numConta + ".hist");
            tArq2 = new BufferedReader(tArq1);

            // Operação III - Ler atributo/valor e colocar na matriz
            while (true) {
                tLinha = tArq2.readLine();
                if (tLinha == null) {
                    break;
                }
                // Criar vetOperacoes como um atributo do tipo Vector
                vetOperacoes.add(tLinha);
            }
            // Operação IV - Fechar o arquivo
            tArq2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Conta sem movimento");
        } catch (IOException tExcept) {
            tExcept.printStackTrace();
        }
    }
}
