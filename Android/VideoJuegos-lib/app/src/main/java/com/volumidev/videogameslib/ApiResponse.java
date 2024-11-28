package com.volumidev.videogameslib;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse<T> {

    private String error;

    private int limit;
    private int offset;

    @SerializedName("number_of_page_results")
    private int numberOfPageResults;

    @SerializedName("number_of_total_results")
    private int numberOfTotalResults;

    @SerializedName("status_code")
    private int statusCode;

    private List<T> results;

    private String version;


    // Getters y Setters

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

    public int getNumberOfPageResults() {
        return numberOfPageResults;
    }

    public void setNumberOfPageResults(int numberOfPageResults) {
        this.numberOfPageResults = numberOfPageResults;
    }

    public int getNumberOfTotalResults() {
        return numberOfTotalResults;
    }

    public void setNumberOfTotalResults(int numberOfTotalResults) {
        this.numberOfTotalResults = numberOfTotalResults;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
