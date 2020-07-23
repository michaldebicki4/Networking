package com.michaldebicki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code = " + responseCode);


            if(responseCode != 200){
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();

//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String,List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("----key = "+ key);
//                for (String string: value){
//                    System.out.println("value = " + value);
//                }
//            }

////            URI uri = url.toURI();
////            URI uri = new URI("http://username:password@server.com:5000/catalogue/phones?os=android#samsung");
////            URI baseUri = new URI("http://username:password@server.com:5000");
////            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
////            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
////            URI uri3 = new URI("/stores/locations?zip=12345");
////
////            URI resolveUri1 = baseUri.resolve(uri1);
////            URI resolveUri2 = baseUri.resolve(uri2);
////            URI resolveUri3 = baseUri.resolve(uri3);
////
//////            URI uri = new URI("hello");
////            URL url = resolveUri1.toURL();
////            System.out.println("URL1 = " + url);
////            URL ur2 = resolveUri1.toURL();
////            System.out.println("URL2 = " + ur2);
////            URL ur3 = resolveUri1.toURL();
////            System.out.println("URL3 = " + ur3);
////
////            URI revitalizedURI = baseUri.relativize(resolveUri2);
////            System.out.println("Relative URI =" + revitalizedURI );
////
////
////            System.out.println("Scheme = " + uri.getScheme());
////            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
////            System.out.println("Authority = " + uri.getAuthority());
////            System.out.println("User info = " + uri.getUserInfo());
////            System.out.println("Host = " + uri.getHost());
////            System.out.println("Port = " + uri.getPort());
////            System.out.println("Path = " + uri.getPath());
////            System.out.println("Query = " + uri.getQuery());
////            System.out.println("Fragment = " + uri.getFragment());
////
//            String line = "";
//            while (line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();
        } catch (IOException e) {
            System.out.println("IO Exception " + e.getMessage());
        }
//        catch (MalformedURLException e){
//            System.out.println("URL malformed " + e.getMessage());
//        }
    }
}
