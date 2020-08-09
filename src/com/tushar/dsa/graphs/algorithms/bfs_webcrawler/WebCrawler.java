package com.tushar.dsa.graphs.algorithms.bfs_webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue;
    private Set<String> visited;
    private int maxUrls;


    public WebCrawler(int maxUrls) {
        this.queue = new LinkedList<>();
        this.visited = new HashSet<>();
        this.maxUrls = maxUrls;
    }

    public void crawlTheWeb(String root) {
        queue.add(root);
        visited.add(root);

        int urlsVisited = 1;

        while (!queue.isEmpty()) {

            if (urlsVisited == maxUrls) {
                System.out.println("Reached maxUrls: " + urlsVisited);
                queue.clear();
                break;
            }

            String currentUrl = queue.remove();
            String rawHtml = readUrl(currentUrl);
            System.out.println("Visiting URL: " + currentUrl + ", content: " + rawHtml);


            urlsVisited++;

            String regExp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regExp);

            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String nextUrl = matcher.group();

                if (!visited.contains(nextUrl)) {
                    visited.add(nextUrl);
                    System.out.println("Found new URL: " + nextUrl);
                    queue.add(nextUrl);
                }
            }

        }
    }

    private String readUrl(String currentUrl) {
        StringBuilder rawHtml = new StringBuilder();

        try {
            URL url = new URL(currentUrl);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                String inputLine = "";

                while ((inputLine = in.readLine()) != null) {
                    rawHtml.append(inputLine);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: couldn't read content of url: " + currentUrl);
        }

        return rawHtml.toString();
    }


}
