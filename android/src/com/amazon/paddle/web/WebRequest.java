package com.amazon.paddle.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.amazon.paddle.credential.User;
import com.amazon.paddle.global.Global;

public class WebRequest {
    
    /*
     *  http://www.xyzws.com/Javafaq/how-to-use-httpurlconnection-post-data-to-web-server/139
     *  
     *  String urlParameters =
        "fName=" + URLEncoder.encode("???", "UTF-8") +
        "&lName=" + URLEncoder.encode("???", "UTF-8")
     * 
     */
    public static String executeGet(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;  
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", 
               "application/x-www-form-urlencoded");
            
            connection.setRequestProperty("Content-Length", "" + 
               Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  
            
            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                  connection.getOutputStream ());
            wr.writeBytes (urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response    
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer(); 
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect(); 
            }
        }
    }
}
