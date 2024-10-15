package tyss.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String y_ChannelName;
	private String hobbies;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getY_ChannelName() {
		return y_ChannelName;
	}
	public void setY_ChannelName(String y_ChannelName) {
		this.y_ChannelName = y_ChannelName;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	
	@Override
	public String toString() {
		return "TrainerDetails [id=" + id + ", y_ChannelName=" + y_ChannelName + ", hobbies=" + hobbies + "]";
	}
	public TrainerDetails(String y_ChannelName, String hobbies) {
		super();
		this.y_ChannelName = y_ChannelName;
		this.hobbies = hobbies;
	}
	
	public TrainerDetails()
	{
		
	}
	

}
