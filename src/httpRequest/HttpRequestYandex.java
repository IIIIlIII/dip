package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpRequestYandex{
    public void httpRequestYandex(String nameP, ArrayList arLongitude, ArrayList arLatitude){
        nameP = fit(nameP);
        String yandex = "https://geocode-maps.yandex.ru/1.x/?format=json&apikey=8a520284-9af4-4c0c-89b5-5cd53b11ae5b&geocode=";
        String query = yandex+nameP;
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                //System.out.println(sb.toString());
            } else {
                System.out.println("fail:" + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        String s = sb.toString();
        String str1 = new String();
        String str2 = new String();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                if (s.charAt(i + 1) == 'o')
                    if (s.charAt(i + 2) == 's')
                        if (s.charAt(i + 3) == '"')
                            if (s.charAt(i + 4) == ':')
                                if (s.charAt(i + 5) == '"') {
                                    while (s.charAt(i + 6) != ' ') {
                                        str1 += s.charAt(i + 6);
                                        i++;
                                    }
                                    while (s.charAt(i + 7) != '"') {
                                        str2 += s.charAt(i + 7);
                                        i++;
                                    }
                                    break;
                                }
            }

        }
        //System.out.println(str1 + ' ' + str2);
        float longitude = Float.parseFloat(str1);
        float latitude = Float.parseFloat(str2);
        arLongitude.add(longitude);
        arLatitude.add(latitude);
    }
    private String fit(String nameP){
        //System.out.println(nameP);
        char [] charr = nameP.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            if ((charr[i] == ' ')&&(charr[i+1]!=',')) {
                charr[i] = '+';
            }
        }
        nameP="";
        for(int i=0;i<charr.length;i++) {
            nameP += charr[i];
        }
        //System.out.println(nameP);
        String s1 ;
        String s2 ;
        for(int i = 0; i<nameP.length();i++){
            if ((nameP.charAt(i) == ' ')&&(nameP.charAt(i+1)==',')){
                s1 = nameP.substring(0,i);
                s2 = nameP.substring(i+1);
                nameP = s1+s2;
            }
        }
        //System.out.println(nameP);
        return nameP;
    }
}

