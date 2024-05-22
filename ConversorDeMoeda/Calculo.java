
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Calculo {

   public String moedaOrigem;
   public String moedaDestino;
   public int valor;

   Calculo(String moedaOrigem, String moedaDestino, double valor){
        this.moedaDestino = moedaDestino;
        this.moedaOrigem = moedaOrigem;
        this.valor = (int) valor;
    }
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public void setMoedaOrigem(String moedaOrigem) {
        this.moedaOrigem = moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public void setMoedaDestino(String moedaDestino) {
        this.moedaDestino = moedaDestino;
    }


public void realizarConversao() {
    try {
// Substitua "SUA-API-KEY" pela sua chave de API
        String uri = "https://v6.exchangerate-api.com/v6/84c8e4c989e04ba2a02baea8/pair/" + moedaOrigem + "/" + moedaDestino;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        if (jsonResponse.get("result").getAsString().equals("success")) {
            double taxaDeCambio = jsonResponse.get("conversion_rate").getAsDouble();
            double valorConvertido = valor * taxaDeCambio;
            System.out.println("Valor convertido: " + String.format("%.2f", valorConvertido) + " " + moedaDestino);
        } else {
            System.out.println("Erro ao obter a taxa de câmbio.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}
