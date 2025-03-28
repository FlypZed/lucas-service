package eci.arep.lucas_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class LucasProxy {

    private final String[] services = {
            "http://172.31.82.52:8080",
            "http://172.31.83.191:8080"
    };
    private int currentService = 0;

    @GetMapping("/proxy")
    public String delegateRequest(@RequestParam("value") int value) {
        try {
            String serviceUrl = services[currentService] + "/lucasseq?value=" + value;
            currentService = (currentService + 1) % services.length;

            URL url = new URL(serviceUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            return "{\"error\":\"Unable to process request.\"}";
        }
    }
}
