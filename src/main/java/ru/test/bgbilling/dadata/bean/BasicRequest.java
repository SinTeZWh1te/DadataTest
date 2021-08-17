package ru.test.bgbilling.dadata.bean;

/**
 * @author sintezwh1te
 */
public class BasicRequest {
    private String query;
    private Integer count;

    public BasicRequest(String query) {
        this.query = query;
    }

    public BasicRequest(String query, Integer count) {
        this.query = query;
        this.count = count;
    }

    public String getQuery() {
        return query;
    }

    public int getCount() {
        return count == null ? 10 : count;
    }
}
