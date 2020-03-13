package cinema;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class IdList
{
	@XmlElement(name = "id")
	private ArrayList<Integer> ids;
	IdList(){
		ids = new ArrayList<Integer>();
	}
	public void add(int newId) {
		ids.add(newId);
	}

	public ArrayList<Integer> getId()
	{
		return ids;
	}

	public void setId(ArrayList<Integer> ids)
	{
		this.ids = ids;
	}
}