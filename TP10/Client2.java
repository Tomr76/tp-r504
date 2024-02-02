// Import des bibliothèques nécessaires
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client2 {

    public static void main(String[] args) {
        // Q1.2 - Vérifier le nombre d'arguments
        if (args.length == 0) {
            System.err.println("Erreur : Veuillez spécifier l'URL du serveur en argument.");
            System.exit(1);
        }

        // Q1.3 - Création du client et de la requête HTTP "GET"
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "http://" + args[0];
        HttpGet request = new HttpGet(url);

        // Q1.4 - Exécution de la requête HTTP
        try {
            System.out.println("Executing request " + request.getRequestLine());
            CloseableHttpResponse resp = client.execute(request);

            // Q2.1 - Utilisation d'InputStreamReader directement
            InputStreamReader isr = new InputStreamReader(resp.getEntity().getContent());

            // Lire le flux JSON directement avec un parseur JSON (non inclus dans ce code)

            resp.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
