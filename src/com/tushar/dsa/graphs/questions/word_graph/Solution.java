package com.tushar.dsa.graphs.questions.word_graph;

import java.util.*;

public class Solution {

    public class Vertex implements Comparable<Vertex> {
        public String val;
        public int distance;
        private List<Vertex> neighbours;

        Vertex(String val){
            this.distance = Integer.MAX_VALUE;
            this.val = val;
            this.neighbours = new ArrayList<>();
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private int findStringDiff(String a, String b){
        int count = 0;
        for (int i=0; i< a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count;
    }

    Map<String, Vertex> vertexMap;

    public Solution(){

    }

    private void makeGraph(List<String> wordList){

        for(int i=0; i<wordList.size(); i++){

            String sWord = wordList.get(i);
            Vertex s;

            if (vertexMap.containsKey(sWord)){
                s = vertexMap.get(sWord);
            } else{
                s = new Vertex(sWord);
                vertexMap.put(sWord, s);
            }

            for(int j=1; j<wordList.size(); j++){

                String tWord = wordList.get(j);
                Vertex t;

                if (vertexMap.containsKey(tWord)){
                    t = vertexMap.get(tWord);
                } else {
                    t = new Vertex(tWord);
                    vertexMap.put(tWord, t);
                }

                if (findStringDiff(s.val, t.val) == 1){
                    s.neighbours.add(t);
                }
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        vertexMap = new HashMap<>();

        wordList.add(0, beginWord);
        makeGraph(wordList);
        if (!vertexMap.containsKey(beginWord) || !vertexMap.containsKey(endWord)){
            return 0;
        }

        Vertex beginVertex = vertexMap.get(beginWord);
        beginVertex.distance = 0;

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        q.add(beginVertex);

        while(!q.isEmpty()){
            Vertex s = q.remove();


            for(Vertex t: s.neighbours){

                int newDistance = s.distance + 1;
                if (newDistance < t.distance){
                    // remove v from priority queue
                    q.remove(t);

                    // update it's values
                    t.distance = newDistance;
                    q.add(t);
                }
            }
        }

        Vertex endVertex = vertexMap.get(endWord);

        if (endVertex == null || endVertex.distance == Integer.MAX_VALUE){
            return 0;
        }

        return endVertex.distance;
    }
}
