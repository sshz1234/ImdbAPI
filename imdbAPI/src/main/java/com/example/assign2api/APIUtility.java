package com.example.assign2api;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    public static void ReadToFile()  {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-top-100-movies.p.rapidapi.com/"))
                .header("x-rapidapi-key", "6c74b3f3dbmsh48c5a40246a790ep18f3eajsn271d1fdb0c82")
                .header("x-rapidapi-host", "imdb-top-100-movies.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<Path> response = client.send(
                    request,
                    HttpResponse
                        .BodyHandlers
                        .ofFile(Paths.get("src/main/resources/com/example/assign2api/javaApiFetched.json"))
            );
            System.out.println(response.body());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}