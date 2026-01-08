
/**
 * Write a description of MovieRunnerAverage here.
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerAverage {
    
    public void printAverageRatings()
    {
        SecondRatings s = new SecondRatings("ratedmoviesfull.csv","ratings.csv");
        ArrayList<Rating> rating = s.getAverageRatings(35);
        Collections.sort(rating);
        System.out.println("Movie size = "+ s.getMovieSize());
        System.out.println("Number of Raters = "+ s.getRaterSize());
        for( Rating i : rating)
        {
            System.out.println("movieTitle: " + s.getTitle(i.getItem()) + " average Rating: " + i.getValue());
        }
    }
    public void getAverageRatingOneMovie()
    {
    SecondRatings s = new SecondRatings("ratedmoviesfull.csv","ratings.csv");
    ArrayList<Rating> rating = s.getAverageRatings(0);
    String title = "Vacation";
    for(Rating i : rating)
    {
        if(s.getTitle(i.getItem()).equals(title))
        {
            System.out.println(i.getValue());
        }
    }
    }
}
