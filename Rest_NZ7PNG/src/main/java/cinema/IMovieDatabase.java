package cinema;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("MovieDatabase") 
public interface IMovieDatabase
{
	static Map<Integer, Movie>	movies = new HashMap<Integer, Movie>();
	
	@GET
	@Path("/movies")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	Response getAllMovies();
	
	@GET
	@Path("/movies/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	Response getMovie(@PathParam("id") Integer id);
	
	@POST
	@Path("/movies")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	Response postMovie(Movie movie);
	
	@PUT
	@Path("/movies/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void putMovie(@PathParam("id") Integer id, Movie movie);
	
	@DELETE
	@Path("/movies/{id}")
	void deleteMovie(@PathParam("id") Integer id);
	
	@GET
	@Path("/movies/find")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	Response find(@QueryParam("year") Integer year, @QueryParam("orderby") String field);
	
}
