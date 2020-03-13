package cinema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Id
{
	@XmlElement(name = "id")
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
}
