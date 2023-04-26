import model.Movie;

import java.util.LinkedList;
import java.util.List;
public class movieStore {
    static final Movie NOT_FOUND =new Movie("NOT_FOUND","notFound",0);
    List<Movie> movies;

    public movieStore() {
        movies = new LinkedList<Movie>();
    }

    public List<Movie> findByPartialTitle(final String partialTitle) {
        Predicate predicate =new Predicate() {
            public boolean matches(Movie movie1) {
                return movie1.getTitle().toLowerCase().contains(partialTitle.toLowerCase());
            }
        };
        return findBy(predicate);
    }

    private LinkedList<Movie> findBy(Predicate predicate) {
        LinkedList<Movie> result = new LinkedList<Movie>();
        for(Movie movie1: movies){
            if(predicate.matches(movie1)){//case insensitive
                result.add(movie1);
            }
        }
        if(result.isEmpty()){
            result.add(NOT_FOUND);
        }
        return result;
    }

    public void add(Movie title) {
        movies.add(title);
    }

    public List<Movie> findByDirector(final String inputDirector) {
        final Predicate predicate =new Predicate() {
            public boolean matches(Movie movie1) {
                return movie1.getDirector().equals(inputDirector);
            }
        };
        return findBy(predicate);
    }

    public List<Movie> findByReleaseYear(final int from, final int to) {
        Predicate predicate =new Predicate() {
            public boolean matches(Movie movie1) {
                return (movie1.getYear()>from && movie1.getYear()<to);
            }
        };
        return findBy(predicate);
    }
    interface Predicate{
        boolean matches(Movie movie);
    }
}
