package com.hie2j.volleyjsonrequest;

public class Weather {
    private String date;
    private String low;
    private String high;
    private String type;

    public Weather(String date, String low, String high, String type) {
        this.date = date;
        this.low = low;
        this.high = high;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
