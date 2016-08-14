package amadeuszx.habitica;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import org.json.*;

/**
 *
 * @author MarcinAmadeuszOlszewski
 */
public class Mechanika {

    private final String LOGIN;
    private final String HASLO;

    private String najlepszeZadanie;
    private String uiidNajlepszeZadanie;

    public Mechanika(String LOGIN, String HASLO) {
        this.LOGIN = LOGIN;
        this.HASLO = HASLO;
    }

    public String fireballX10(String czar) {
        StringBuilder wynik = new StringBuilder();
        if (uiidNajlepszeZadanie == null) {
            wynik.append("Wczytuję listę zadań by znaleźć najlepsze...\n");
            dzialajZadania();
        }
        try {
            for (int i = 1; i <= 10; i++) {
                wynik.append(i);
                wynik.append("\t");
                wynik.append(najlepszeZadanie);
                wynik.append("\t");
                if (dzialajZaklecia(czar, uiidNajlepszeZadanie)) {
                    wynik.append("trafiony...\n");
                } else {
                    wynik.append("pudło...\n");
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wynik.toString();
    }

    public String dzialajZaklecia(String zaklecie) {
        String wynik = "Zaklęcie rozwiało się w nicość...";
        if (dzialajZaklecia(zaklecie, null)) {
            wynik = "BUM! Z fascynacją obserwujesz efekty czaru...";
        }
        return wynik;
    }

    public boolean dzialajZaklecia(String zaklecie, String cel) {
        try {
            String link = "https://habitica.com/api/v3/user/class/cast/" + zaklecie;
            if (cel != null) {
                link += "?targetId=" + cel;
            }
            HttpURLConnection uc = polaczenie(link, "POST");
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
            return br.readLine() != null;
        } catch (IOException ex) {
            Logger.getLogger(Mechanika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String dzialajKupNapoj() {
        String wynik = "Nie zadziałał";
        try {
            String link = "https://habitica.com/user/buy-health-potion";
            HttpURLConnection uc = polaczenie(link, "POST");
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
            if (br.readLine() != null) {
                wynik = "Kupiony - wypity";
            }
        } catch (IOException ex) {
            Logger.getLogger(Mechanika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wynik;
    }

    public String piszNaCzat(String wiadomosc, String idGrupy) {
        try {
            String wiadomoscDoLinku = "message=" + wiadomosc;
            byte[] postData = wiadomoscDoLinku.getBytes(StandardCharsets.UTF_8);

            String link = "https://habitica.com/api/v3/groups/" + idGrupy + "/chat";
            HttpURLConnection uc = polaczenie(link, "POST");
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            uc.setDoOutput(true);
            uc.setRequestProperty("Content-Length", String.valueOf(postData.length));
            uc.getOutputStream().write(postData);
            Reader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(Mechanika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dzialajCzat(idGrupy);
    }

    public String dzialajListaGraczy() {
        String wynik = "";
        try {
            JSONObject object = polaczenieGet("https://habitica.com/api/v3/groups/party/members?includeAllPublicFields=true");
            JSONArray data = object.getJSONArray("data");
            StringBuilder buildier = new StringBuilder(2048);
            if (data.length() < 30) {
                for (int i = 0; i < data.length(); i++) {
                    buildier.append(data.getJSONObject(i).getJSONObject("profile").getString("name"));
                    buildier.append("\t\t");
                    buildier.append(data.getJSONObject(i).getJSONObject("stats").getInt("hp"));
                    buildier.append("\n");
                }
            }
            wynik = buildier.toString();
        } catch (IOException | JSONException ex) {
            Logger.getLogger(Mechanika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wynik;
    }

    public String dzialajZadania() {
        String wynik = "";
        try {
            JSONObject object = polaczenieGet("https://habitica.com/api/v3/tasks/user");
            JSONArray data = object.getJSONArray("data");
            StringBuilder buildier = new StringBuilder(2048);
            long maximum = Long.MIN_VALUE;
            for (int i = 0; i < data.length(); i++) {
                long value = data.getJSONObject(i).getLong("value");
                if (data.getJSONObject(i).has("completed")) {
                    buildier.append(data.getJSONObject(i).getBoolean("completed"));
                    if (value >= maximum) {
                        maximum = value;
                        uiidNajlepszeZadanie = data.getJSONObject(i).getString("id");
                        najlepszeZadanie = data.getJSONObject(i).getString("text");
                    }
//                    System.out.println(data.get(i));
                } else {
                    buildier.append("---");
                }
                buildier.append("\t");
                buildier.append(value);
                buildier.append("\t");
                buildier.append(data.getJSONObject(i).getString("type"));
                buildier.append("\t");
                buildier.append(data.getJSONObject(i).getString("text"));
                buildier.append("\n");

            }
            wynik = buildier.toString();
//            System.out.println(najlepszeZadanie);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(Mechanika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wynik;
    }

    public String dzialajCzat(String idCzatu) {
        String wynik = "";
        try {
            JSONObject object = polaczenieGet("https://habitica.com/api/v3/groups/" + idCzatu + "/chat");
            JSONArray data = object.getJSONArray("data");
            StringBuilder buildier = new StringBuilder(2048);
            for (int i = data.length() - 1; i >= 0; i--) {
                LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(data.getJSONObject(i).getLong("timestamp")), ZoneId.of("Europe/Warsaw"));
                buildier.append(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                buildier.append(df.format(new Timestamp(data.getJSONObject(i).getLong("timestamp"))));
                buildier.append("\t");
                if (data.getJSONObject(i).has("user")) {
                    buildier.append(data.getJSONObject(i).getString("user"));
                } else {
                    buildier.append("-----");
                }
                buildier.append("\t\t");
                StringBuilder tekst = new StringBuilder(data.getJSONObject(i).getString("text"));
                usowanieNowejLinii(tekst); 
                dzielenieDlugiejLini(tekst);
                buildier.append(tekst);
                buildier.append("\n");
            }
            wynik = buildier.toString();
        } catch (IOException | JSONException ex) {
            Logger.getLogger(Mechanika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wynik;
    }

    private void dzielenieDlugiejLini(StringBuilder tekst) {
        if (tekst.length() > 200) {
            int dziel = tekst.length() / 200;
            for (int j = 1; j <= dziel; j++) {
                tekst.insert(j * 200, "\n\t\t\t\t");
            }
        }
    }

    private void usowanieNowejLinii(StringBuilder tekst) {
        int nowaLinia = tekst.indexOf("\n");
        while (nowaLinia >= 0) {
            tekst.replace(nowaLinia, nowaLinia + 1, "");
            nowaLinia = tekst.indexOf("\n");
        }
    }

    private JSONObject polaczenieGet(String link) throws IOException {
        HttpURLConnection uc = polaczenie(link, "GET");
        InputStream is = uc.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String linia = br.readLine();
        br.close();

        return new JSONObject(linia);
    }

    private HttpURLConnection polaczenie(String link, String metoda) throws ProtocolException, IOException, MalformedURLException {
        URL url = new URL(link);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.setRequestProperty("Content-Type", "application/json");
        uc.setRequestProperty("Accept-Charset", "UTF-8");
        uc.setRequestProperty("x-api-user", LOGIN);
        uc.setRequestProperty("x-api-key", HASLO);
        uc.setRequestMethod(metoda);
        return uc;
    }

    public String getNajlepszeZadanie() {
        return najlepszeZadanie;
    }

}
