import junit.framework.Assert;
import junit.framework.TestCase;
import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class movieStoreTestCase extends TestCase {

    movieStore movie_Store=new movieStore();
    Movie hp=new Movie("Harry Potter","Rowling",2000);
    Movie sw=new Movie("Star Wars","Shimmer", 1999);
    Movie st=new Movie("STAR Trek", "Harvard", 1998);
    Movie ab=new Movie("Alabama","Yale", 2001);
    Movie bw=new Movie("Bewitched","Georgia", 2002);
    @BeforeEach
    public void setup() {
        movie_Store.add(hp);
        movie_Store.add(ab);
        movie_Store.add(bw);
        movie_Store.add(sw);
        movie_Store.add(st);
    }
    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchResults() throws Exception{
        List<Movie> results =movie_Store.findByPartialTitle("abc");
        Assert.assertEquals(1,results.size());
    }

    //returns at first usage found
    @Test
    public void findsAMovieWhenTitleIsPartiallyMatched() throws Exception{
        List<Movie> results =movie_Store.findByPartialTitle("otter");
        Assert.assertEquals(results.size(), 1);
        assertThat(results,containsInAnyOrder(hp));
    }

    //case in-sensitive:: search for TAR
    @Test
    public void findsAMovieWhenTitlesArePartiallyMatchedCaseInsensitive() throws Exception{
        String partialTex="TAR";
        List<Movie> results =movie_Store.findByPartialTitle(partialTex);
        Assert.assertEquals(2,results.size());
        assertThat(results, containsInAnyOrder(st,sw));//hamcrest method assertThat
    }
    //by director
    @Test
    public void findsAMovieWhenDirectorExactlyMatches() throws Exception{
        String directorName="Shimmer";
        List<Movie> results =movie_Store.findByDirector(directorName);
        Assert.assertEquals(1,results.size());
        assertThat(results, containsInAnyOrder(sw));//hamcrest method assertThat
    }
    //find movies when release year between 2 values
    @Test
    public void findsAMovieWhenReleaseYearBetweenTwoValues() throws Exception{
        List<Movie> results =movie_Store.findByReleaseYear(1999,2002);
        Assert.assertEquals(2,results.size());
        assertThat(results, containsInAnyOrder(ab,hp));//hamcrest method assertThat
    }
}