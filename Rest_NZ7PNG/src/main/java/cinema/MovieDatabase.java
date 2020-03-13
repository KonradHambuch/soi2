package cinema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class MovieDatabase implements IMovieDatabase
{
	static int actid = 0;
	@Override
	public Response getMovie(@PathParam("id") Integer id)
	{
		if(!movies.containsKey(id)) return Response.status(404).build();
		return Response.status(200).entity(movies.get(id)).build();
	}
	@Override
	public Response getAllMovies()
	{
		MovieList ml = new MovieList();
		ml.addAll(movies.values());
		return Response.status(200).entity(ml).build();
	}

	@Override
	public Response postMovie(Movie movie)
	{
		movies.put(actid, movie);
		Id id  = new Id();
		id.setId(actid++);
		return Response.status(200).entity(id).build();
	}

	@Override
	public void putMovie(Integer id, Movie movie)
	{
		if(movies.containsKey(id)) {
			actid++;			
		}
		movies.put(id, movie);
	}

	@Override
	public void deleteMovie(Integer id)
	{
		movies.remove(id);		
	}

	@Override
	public Response find(Integer year, String field)
	{	
		IdList idList = new IdList();
		ArrayList<Entry<Integer, Movie>> moviesInYear = new ArrayList<Entry<Integer, Movie>>();
		for (Entry<Integer, Movie> movie : movies.entrySet())
		{
			if(movie.getValue().getYear() == year) {
				moviesInYear.add(movie);
			}
		}		
		MovieComparator mc = new MovieComparator(field);
		Collections.sort(moviesInYear, mc);
		for (Entry<Integer, Movie> movie : moviesInYear)
		{
			idList.add(movie.getKey());
		}	
		return Response.status(200).entity(idList).build();
		
	}
	
}
