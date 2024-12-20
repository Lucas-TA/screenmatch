package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.exceptions.InvalidYearFormat;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Title;
import br.com.alura.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("exit")) {
            System.out.println("Search a movie: ");
            search = URLEncoder.encode(scanner.nextLine(), StandardCharsets.UTF_8);

            if (search.equalsIgnoreCase("exit")) {
                break;
            }
            String address = "https://www.omdbapi.com/?t=" + search +"&apikey=6ebb20a8";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(titleOmdb);

                //try {
                Title title = new Title(titleOmdb);
                System.out.println("Title converted");
                System.out.println(title);

                titles.add(title);
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("An argument error occurred in the searched address: ");
                System.out.println(e.getMessage());
            } catch (InvalidYearFormat e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);

        FileWriter writer = new FileWriter("titles.json");
        writer.write(gson.toJson(titles));
        writer.close();

        System.out.println("Program finished.");
    }
}