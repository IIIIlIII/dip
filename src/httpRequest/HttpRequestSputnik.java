package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpRequestSputnik {
    public void httpRequestSputnik(String nameP,ArrayList arLongitude,ArrayList arLatitude){
        nameP = fit(nameP);
        String sputnik = "http://search.maps.sputnik.ru/search?q=";
        String query1 = sputnik+nameP;
        //String query2= null;
//        try {
//            query2 = new String(query1.getBytes("UTF-8"), "windows-1251");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        try {
            connection = (HttpURLConnection) new URL(query1).openConnection();
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
                System.out.println(sb.toString());
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
            if (s.charAt(i) == 'l') {
                if (s.charAt(i + 1) == 'a')
                    if (s.charAt(i + 2) == 't')
                        if (s.charAt(i + 3) == '"')
                            if (s.charAt(i + 4) == ':'){
                                while (s.charAt(i + 5) != ',') {
                                    str1 += s.charAt(i + 5);
                                    i++;
                                }
                                while (s.charAt(i + 12) != '}') {
                                    str2 += s.charAt(i + 12);
                                    i++;
                                }
                            }

            }

        }
        System.out.println(str2 + "   " + str1);
        if((str1!=null)&&(str2!=null)) {
            float longitude = Float.parseFloat(str2);
            float latitude = Float.parseFloat(str1);
            arLongitude.add(longitude);
            arLatitude.add(latitude);
        }
    }
    private String fit(String nameP){
        System.out.println(nameP);
        String s3 ;
        String s4;
        String s5 ="%20";
        for (int i = 0; i < nameP.length(); i++) {
            if ((nameP.charAt(i) == ' ')&&(nameP.charAt(i+1)!=',')) {
                s3 = nameP.substring(0,i);
                s4 = nameP.substring(i+1);
                nameP = s3+s5+s4;
            }
        }
        System.out.println(nameP);
        String s1;
        String s2;
        for(int i = 0; i<nameP.length(); i++){
            if ((nameP.charAt(i) == ' ')&&(nameP.charAt(i+1)==',')){
                s1 = nameP.substring(0,i);
                s2 = nameP.substring(i+1);
                nameP = s1+s2;
            }
        }
        System.out.println(nameP);
        return nameP;
    }
}

