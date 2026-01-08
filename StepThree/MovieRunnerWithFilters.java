
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerWithFilters 
{
     public void printAverageRatings()
    {
        ThirdRatings s = new ThirdRatings("ratings.csv");
        ArrayList<Rating> rating = s.getAverageRatings(35);
        Collections.sort(rating);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie size = "+ MovieDatabase.size());
        System.out.println("Number of Raters = "+ s.getRaterSize());
        System.out.println("Find out movies: " + rating.size());
        for( Rating i : rating)
        {
            System.out.println("movieTitle: " + s.getTitle(i.getItem()) + " average Rating: " + i.getValue());
        }
    }
    
    public void getAverageRatingOneMovie()
    {
    ThirdRatings s = new ThirdRatings("ratings.csv");
    ArrayList<Rating> rating = s.getAverageRatings(0);
    String title = "Vacation";
    for(Rating i : rating)
    {
        if(s.getTitle(i.getItem()).equals(title))
        {
            System.out.println(i.getValue());
            return;
        }
    }
    System.out.println( "MOVIE TITTLE NOT FOUND");
    }
    public void printAverageRatingsByYear()
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ThirdRatings s = new ThirdRatings("ratings.csv");
        ArrayList<Rating> rating = s.getAverageRatingsByFilter(20,new YearAfterFilter(2000));
        System.out.println("number of movies: " + rating.size());
        System.out.println("Number of Raters = "+ s.getRaterSize());
        Collections.sort(rating);
        for(Rating i : rating)
        {
            System.out.println("Title: " + MovieDatabase.getTitle(i.getItem()) + " rating: " + i.getValue() + "Year: " + MovieDatabase.getYear(i.getItem()));
        }
        
    }
    public void printAverageRatingsByGenre()
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ThirdRatings s = new ThirdRatings("ratings.csv");
        ArrayList<Rating> rating = s.getAverageRatingsByFilter(20,new GenreFilter("Comedy"));
        System.out.println("number of movies: " + rating.size());
        System.out.println("Number of Raters = "+ s.getRaterSize());
        Collections.sort(rating);
        for(Rating i : rating)
        {
            System.out.println("Title: " + MovieDatabase.getTitle(i.getItem()) + " rating: " + i.getValue() + "Genres: " + MovieDatabase.getGenres(i.getItem()));
        }

    }
    public void printAverageRatingsByMinutes()
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ThirdRatings s = new ThirdRatings("ratings.csv");
        ArrayList<Rating> rating = s.getAverageRatingsByFilter(5,new MinutesFilter(105,135));
        System.out.println("number of movies: " + rating.size());
        System.out.println("Number of Raters = "+ s.getRaterSize());
        Collections.sort(rating);
        for(Rating i : rating)
        {
            System.out.println("Title: " + MovieDatabase.getTitle(i.getItem()) + " rating: " + i.getValue() + "Minutes: " + MovieDatabase.getMinutes(i.getItem()));
        }
        System.out.println("number of movies: " + rating.size());
        System.out.println("Number of Raters = "+ s.getRaterSize());
    }
    public void printAverageRatingsByDirectors()
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ThirdRatings s = new ThirdRatings("ratings.csv");
        ArrayList<Rating> rating = s.getAverageRatingsByFilter(1,new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        System.out.println("number of movies: " + rating.size());
        System.out.println("Number of Raters = "+ s.getRaterSize());
        Collections.sort(rating);
        for(Rating i : rating)
        {
            System.out.println("Title: " + MovieDatabase.getTitle(i.getItem()) + " rating: " + i.getValue() + "Directors: " + MovieDatabase.getDirector(i.getItem()));
        }
    }
    
    public void printAverageRatingsByDirectorsAndMinutes()
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ThirdRatings s = new ThirdRatings("ratings.csv");
        AllFilters all = new AllFilters();
        all.addFilter(new MinutesFilter(90,180));
        all.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        ArrayList<Rating> rating = s.getAverageRatingsByFilter(3, all);
        Collections.sort(rating);
        System.out.println("number of movies: " + rating.size());
        System.out.println("number of Raters: " + s.getRaterSize());
        for(Rating i : rating)
        {
            System.out.println("Title: " + MovieDatabase.getTitle(i.getItem()) + " rating: " + i.getValue() + "Directors: " + MovieDatabase.getDirector(i.getItem()) + "Minutes: " + MovieDatabase.getMinutes(i.getItem()));
        }
        
    }
    public void printAverageRatingsByYearAfterAndGenres()
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ThirdRatings s = new ThirdRatings("ratings.csv");
        AllFilters all = new AllFilters();
        all.addFilter(new YearAfterFilter(1990));
        all.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> rating = s.getAverageRatingsByFilter(8, all);
        Collections.sort(rating);
        System.out.println("number of movies: " + rating.size());
        System.out.println("number of Raters: " + s.getRaterSize());
        for(Rating i : rating)
        {
            System.out.println("Title: " + MovieDatabase.getTitle(i.getItem()) + " rating: " + i.getValue() + "Year: " + MovieDatabase.getYear(i.getItem()) + "Genres: " + MovieDatabase.getGenres(i.getItem()));
        }
        
    }
}
