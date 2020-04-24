import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void getHTML(String address) throws Exception {
        URL url = new URL(address);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.replaceAll("<ns2:ws_stag_predmety_SearchSimplePredmety>",
                    "\n<ns2:ws_stag_predmety_SearchSimplePredmety>");
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) throws Exception {
        String param = "?p_zkrPredm=NNPI";
        try {
            getHTML("https://stag-ws.upce.cz/ws/services/rest2/ng_predmety/searchSimplePredmety" + param);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
