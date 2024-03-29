// Import des bibliothèques nécessaires
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client1 {

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

            // Q1.5 - Récupération de la page HTML
            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = " ";
            while ((line = rd.readLine()) != null) {
                result.append(line);
                result.append("\n"); // pour avoir le saut de ligne
            }

            // Affichage de la page HTML
            String page = result.toString();
            System.out.println(page);

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
