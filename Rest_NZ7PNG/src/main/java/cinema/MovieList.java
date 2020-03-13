package cinema;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class MovieList
{
	@XmlElement(name = "movie")
	private ArrayList<Movie> movies;
	MovieList(){
		movies = new ArrayList<Movie>();
	}
	public void add(Movie movie) {
		movies.add(movie);
	}
	public void addAll(Collection<Movie> ml) {
		movies.addAll(ml);
	}
	
}
