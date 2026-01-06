/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings 
{
    
    public ArrayList<Movie> loadMovies(String filename)
    {
        ArrayList<Movie> movies = new ArrayList<>();
        FileResource file = new FileResource(filename);
        CSVParser parser = file.getCSVParser();
        for(CSVRecord i : parser)
        {
            String id = i.get("id");
            String title = i.get("title");
            String year = i.get("year");
            String genres = i.get("genre");
            String director = i.get("director");
            String country = i.get("country");
            int minutes = Integer.parseInt(i.get("minutes"));
            String poster = i.get("poster");
            Movie themovie = new Movie(id,title,year,genres,director,country,poster,minutes);
            movies.add(themovie);
        }
        return movies;
    }
    public void testLoadMovies()
    {
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
        System.out.println(movies.size());
        int numberofComedy = 0;
        int longmovies = 0;
        for(Movie m : movies)
        {
            System.out.println(m);
            String genre = m.getGenres();
            if(genre.compareTo("Comedy") == 0)
            {
                numberofComedy++;
            }
            int time = m.getMinutes();
            if(time > 150)
            {
                longmovies++;
            }
        }
        System.out.println("movies more than 150 mins: " + longmovies);
        System.out.println("number of Comedy movies: " + numberofComedy);
        HashMap<String, ArrayList<Movie>> Directors = new HashMap<String, ArrayList<Movie>>();
        int Maxx = 0;
        for(Movie m : movies)
        {
            String director = m.getDirector();
            String[] ListDirector = director.split(", ");
            for(String direct : ListDirector)
            {
                if(!Directors.containsKey(direct))
                {
                    ArrayList<Movie> mov = new ArrayList<Movie>();
                    mov.add(m);
                    Directors.put(direct,mov);
                    Maxx = (Maxx < mov.size()) ? mov.size() : Maxx;
                }
                else
                {
                    ArrayList<Movie> mov = Directors.get(direct);
                    mov.add(m);
                    Directors.put(direct,mov);
                    Maxx = (Maxx < mov.size()) ? mov.size() : Maxx;
                }
            }
        }
        System.out.println("Director who direct most movies");
        for(String name : Directors.keySet())
        {
            if(Directors.get(name).size() == Maxx)
            {
                System.out.println( name + ": " + Maxx);
            }
        }
    }
    public static ArrayList<Rater> loadRaters(String filename)
    {
        FileResource file = new FileResource(filename);
        ArrayList<Rater> Raters = new ArrayList<Rater>();
        CSVParser parser = file.getCSVParser();
        for(CSVRecord records : parser)
        {
            String id = records.get("rater_id");
            String movie_id = records.get("movie_id");
            double rate = Double.parseDouble(records.get("rating"));
            int time = Integer.parseInt(records.get("time"));
            boolean mark = false;
            for(Rater j : Raters)
            {
                String idk = j.getID();
                if( idk.compareTo(id) == 0)
                {
                    j.addRating(movie_id,rate);
                    mark = true;
                    break;
                }
            }
            if(mark == false)
            {
                Rater newone = new Rater(id);
                newone.addRating(movie_id,rate);
                Raters.add(newone);
            }
        }
        return Raters;
    }
    public void testLoadRaters()
    {
        ArrayList<Rater> Raters = loadRaters("ratings.csv");
        HashMap< String, ArrayList<String>> mpRater = new HashMap<String,ArrayList<String>>();
        System.out.println(Raters.size());
        int maxx = 0;
        int numberofRatingfor193 =0;
        for(Rater r : Raters)
        {
            System.out.print(r.getID()+ ": ");
            ArrayList<String> items = r.getItemsRated();
            if(r.getID().compareTo("193") == 0)
            {
                numberofRatingfor193 = items.size();
            }
            mpRater.put(r.getID(),items);
            System.out.println(items.size());
            System.out.println();
            maxx = (maxx <items.size()) ? items.size() : maxx;
        }
        System.out.println("Raters with maximum ratings: " + maxx);
        int cnt = 0;
        for(String key : mpRater.keySet())
        {
            if(mpRater.get(key).size() == maxx)
            {
                cnt++;
                System.out.print(key + " ");
            }
        }
        System.out.println(cnt);
        //get movie_id
        String movie_id = "1798709";
        cnt = 0;
        for(String key : mpRater.keySet())
        {
            ArrayList<String> items = mpRater.get(key);
            for(String item : items)
            {
                if( item.compareTo(movie_id)== 0)
                {
                    cnt++;
                }
            }
        }
        System.out.println("number of ratings for "+ "movie_id" + ": "+ cnt);
        ArrayList<String> differentMovie = new ArrayList<>();
        for (Rater i : Raters) 
        {
            ArrayList<String> rating = i.getItemsRated();
            for (String j : rating) 
            {
                if (!differentMovie.contains(j)) 
                {
                    differentMovie.add(j);
                }
            }
        }
        System.out.println("The number of different movies is " + differentMovie.size());
        System.out.println("The number of ratings of rater 193 :" + numberofRatingfor193);
    }
    
    
}
