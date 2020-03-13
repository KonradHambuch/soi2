package cinema;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class Movie
{
	@XmlElement(name  = "title")
	private String Title;
	@XmlElement(name  = "year")
	private int Year;
	@XmlElement(name  = "director")
	private String Director;
	@XmlElement(name  = "actor")
	private ArrayList<String> Actor = new ArrayList<String>();	
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String title)
	{
		Title = title;
	}
	public int getYear()
	{
		return Year;
	}
	public void setYear(int year)
	{
		Year = year;
	}
	public String getDirector()
	{
		return Director;
	}
	public void setDirector(String director)
	{
		Director = director;
	}
	public ArrayList<String> getActor()
	{
		return Actor;
	}
	public void setActor(ArrayList<String> actor)
	{
		Actor = actor;
	}
}
