
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter 
{
    private String[] directors;
    
    public DirectorsFilter(String directors)
    {
        this.directors = directors.split(",");
    }
    
    public boolean satisfies(String id)
    {
        for(String i : directors)
        {
            if(MovieDatabase.getDirector(id).contains(i))
            {
                return true;
            }
        }
        return false;
    }
}
