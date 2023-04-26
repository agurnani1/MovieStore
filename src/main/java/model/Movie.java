package model;

public class Movie {
    int releaseYear;
    String title;
    String director;

    public Movie(String name, String inDir, int year){
        this.title=name;
        this.director=inDir;
        this.releaseYear=year;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDirector(){
        return this.director;
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public int getYear() {
        return this.releaseYear;
    }
}
