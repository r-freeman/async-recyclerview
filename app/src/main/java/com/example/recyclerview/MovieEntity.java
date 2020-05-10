package com.example.recyclerview;

public class MovieEntity {
    private int id;
    private String thumbnail;
    private String title;
    private String synopsis;
    private int year;

    public MovieEntity() {

    }

    public MovieEntity(int id, String thumbnail, String title, String synopsis, int year) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
    }

    public MovieEntity(String thumbnail, String title, String synopsis, int year) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", year=" + year +
                '}';
    }
}
