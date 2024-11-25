package com.volumidev.videogameslib;

import java.util.List;

public class SearchResponse {
    private List<Game> results;
    private int number_of_total_results;
    private int limit;
    private int offset;

    // Getters y setters para los campos de la respuesta


    public List<Game> getResults() {
        return results;
    }

    public void setResults(List<Game> results) {
        this.results = results;
    }

    public int getNumber_of_total_results() {
        return number_of_total_results;
    }

    public void setNumber_of_total_results(int number_of_total_results) {
        this.number_of_total_results = number_of_total_results;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
