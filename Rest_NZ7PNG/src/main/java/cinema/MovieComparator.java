package cinema;

import java.util.Comparator;
import java.util.Map.Entry;

public class MovieComparator implements Comparator<Entry<Integer, Movie>>
{
	private String field;
	public MovieComparator(String f)
	{
		field = f;
	}
	@Override
	public int compare(Entry<Integer, Movie> e1, Entry<Integer, Movie> e2)
	{
			if(field.equals("Title")) {
				
				return e1.getValue().getTitle().compareTo(e2.getValue().getTitle());
			}
			else if(field.equals("Director")) {
				return e1.getValue().getDirector().compareTo(e2.getValue().getDirector());
			}		
			else return 0;
	}	
}
