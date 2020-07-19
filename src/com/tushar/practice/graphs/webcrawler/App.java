package com.tushar.practice.graphs.webcrawler;

public class App {
    public static void main(String[] args){
        WebCrawler crawler = new WebCrawler(1000);
        crawler.crawlTheWeb("https://aajtak.intoday.in");
    }

}
