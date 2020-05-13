package com.example.recyclerview;

public class MovieEntity {
    private int id;
    private String title;
    private String synopsis;
    private int year;
    private String thumbnail;

    public MovieEntity() {

    }

    public MovieEntity(int id, String title, String synopsis, int year, String thumbnail) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
        this.thumbnail = thumbnail;
    }

    public MovieEntity(String title, String synopsis, int year, String thumbnail) {
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", year=" + year +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
