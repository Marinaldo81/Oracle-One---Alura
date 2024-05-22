import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ConversoMoeda {
    public static void main(String[] args) throws IOException, InterruptedException {
        int op;
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println(" Programa ---------- Converso de Moeda --------------------");
            System.out.println(" 1 - Real Brasileiro >>>>>>> Renminbi Chinês");
            System.out.println(" 2 -  Renminbi Chinês >>>>>>> Real Brasileiro");
            System.out.println(" 3 - Real Brasileiro >>>>>>> Dólar  Estados Unidoes ");
            System.out.println(" 4 - Dólar Estados Unidos  >>>>>>> Real Brasileiro");
            System.out.println(" 5 - Renminbi Chines  >>>>>>> Dólar  Estados Unidoes ");
            System.out.println(" 6 - Dólar Estados Unidos  >>>>>>> Renminbi Chines");
            System.out.println("7- sair ");
            System.out.println(" Escolha uma opção acima:");
            op = Integer.parseInt(scanner.nextLine());

            if (op >= 1 && op <= 6) {
                String moedaOrigem = "";
                String moedaDestino = "";
                switch (op) {
                    case 1:
                        moedaOrigem = "BRL";
                        moedaDestino = "CNY";
                        break;
                    case 2:
                        moedaOrigem = "CNY";
                        moedaDestino = "BRL";
                        break;
                    case 3:
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 4:
                        moedaOrigem = "USD";
                        moedaDestino = "BRL";
                        break;
                    case 5:
                        moedaOrigem = "CNY";
                        moedaDestino = "USD";
                        break;
                    case 6:
                        moedaOrigem = "USD";
                        moedaDestino = "CNY";
                        break;
                }

                System.out.print("Digite o valor a ser convertido: ");
                double valor = Double.parseDouble(scanner.nextLine());
                Calculo calculo = new Calculo(moedaOrigem, moedaDestino, valor);
                calculo.realizarConversao();
            }


        }while(op != 7);
            scanner.close();







    }