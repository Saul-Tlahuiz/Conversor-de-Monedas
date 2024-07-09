import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public Monedas buscarMoneda(String codigoMoneda){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ec4fbc60482ef5118532af12/latest/"+codigoMoneda);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Monedas.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre esa divisa.");
        }
    }
}