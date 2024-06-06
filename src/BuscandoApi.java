import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscandoApi {
    public double obterTaxaDeCambio (String moedaEntrada, String moedaEscolha) throws IOException, InterruptedException {
              String chaveApi = "1bd00d382b03b082ed87e233";
        String endereco = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + moedaEntrada;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        // acrescentar o throws para o send, com o add exceptions to method signature

        String json = response.body();

        // System.out.println(response.body());

        Gson gson = new Gson();
        //foi incluido o arquivo jar do Gson - site mvm repository, download do arquivo jar
        // no arq do projeto Project Structure / Modules / Dependencies / + e buscar o arq baixado

        // Converte a resposta JSON para um objeto JsonObject
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Obtém a data da taxa de câmbio
        String dataDeCambio = jsonObject.get("time_last_update_utc").getAsString();

        System.out.println(dataDeCambio);
        // Obtém a taxa de câmbio para a moeda desejada
        double taxaDeCambio = jsonObject
                .getAsJsonObject("conversion_rates")
                .get(moedaEscolha)
                .getAsDouble();
        return taxaDeCambio;




    }


}
