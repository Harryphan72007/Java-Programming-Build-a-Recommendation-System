
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * Date : January 6th, 2025
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;
    /*
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }*/
    public SecondRatings(String moviefile, String ratingsfile)
    {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingsfile);
    }
    public int getMovieSize()
    {
        return myMovies.size();
    }
    public int getRaterSize()
    {
        return myRaters.size();
    }
    private double getAverageByID(String movieID, int minimalRaters)
    {
        double avg = 0.0;
        int cnt = 0;
        for(Rater rater : myRaters)
        {
            double rating = rater.getRating(movieID);
            if(rating != -1)
            {
            avg = avg + rater.getRating(movieID);
            cnt++;
            }
        }
        if(cnt >= minimalRaters) return avg/cnt;
        return 0.0;
    }
    public ArrayList<Rating> getAverageRatings(int minimalRaters)
    {
        ArrayList<Rating> ans = new ArrayList<Rating>();
        for(Movie movie: myMovies)
        {
            double avg = getAverageByID(movie.getID(), minimalRaters);
            if(avg != 0.0)
            {
                Rating a = new Rating(movie.getID(), avg);
                ans.add(a);
            }
        }
        return ans;
    }
    public String getTitle(String id)
    {
        for(Movie movie: myMovies)
        {
            if(movie.getID().compareTo(id) == 0)
            {
                return movie.getTitle();
            }
        }
        return "This movie is not available";
    }
    public String getID(String title)
    {
        for(Movie movie : myMovies)
        {
            if(movie.getTitle().compareTo(title) == 0)
            {
                return movie.getID();
            }
        }
        return "NO SUCH TITLE";
    }
}