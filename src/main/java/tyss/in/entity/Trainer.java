package tyss.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long phone;
	private String subject;
	
	@OneToOne
	private TrainerDetails trainer;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public TrainerDetails getTrainer() {
		return trainer;
	}



	public void setTrainer(TrainerDetails trainer) {
		this.trainer = trainer;
	}

	


	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", phone=" + phone + ", subject=" + subject + ", trainer="
				+ trainer + "]";
	}
	
	
	



	public Trainer(String name, long phone, String subject, TrainerDetails trainer) {
		super();
		this.name = name;
		this.phone = phone;
		this.subject = subject;
		this.trainer = trainer;
	}



	public Trainer()
	{
		
	}
	
	
	
	
	

	
}
