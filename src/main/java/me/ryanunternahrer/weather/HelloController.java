package me.ryanunternahrer.weather;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.weatherapi.com/v1/current.json?key=<YOUR_KEY>&q=206.83.102.228&aqi=yes")).method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());

        welcomeText.setText("Welcome to a Weather App");
    }
}