
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * Date : January 6th, 2025
 */

import java.util.*;

public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;
    /*
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }*/
    public ThirdRatings(String ratingsfile)
    {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }
    public int getMovieSize()
    {
        return MovieDatabase.size();
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
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String movie: movies)
        {
            double avg = getAverageByID(movie, minimalRaters);
            if(avg != 0.0)
            {
                Rating a = new Rating(movie, avg);
                ans.add(a);
            }
        }
        return ans;
    }
    public String getTitle(String id)
    {
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String movie: movies)
        {
            if(movie.compareTo(id) == 0)
            {
                return MovieDatabase.getTitle(id);
            }
        }
        return "This movie is not available";
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria)
    {
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> ans = new ArrayList<Rating>();
        for(String movie: movies)
        {
            double avg = getAverageByID(movie, minimalRaters);
            if(avg != 0.0)
            {
                Rating a = new Rating(movie, avg);
                ans.add(a);
            }
        }
        return ans;
    }
    /*
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
    }*/
}