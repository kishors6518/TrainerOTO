package tyss.in.app;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tyss.in.entity.Trainer;
import tyss.in.entity.TrainerDetails;

public class App {
	static Scanner sc=new Scanner(System.in);
	EntityManagerFactory factory;
	EntityManager manager;
	EntityTransaction transaction;
	
	public void addTrainer() {
		factory=Persistence.createEntityManagerFactory("varun");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		
		Trainer t1=new Trainer("Varun Sir", 789456124512l, "J2EE", new TrainerDetails("Varun","To teach deep"));
		Trainer t2=new Trainer("Tejus Sir", 8956232454l, "Java", new TrainerDetails("Tejus", "Give opportunity"));
		transaction.begin();
		manager.persist(t1);
		manager.persist(t2);
		manager.persist(t1.getTrainer());
		manager.persist(t2.getTrainer());
		transaction.commit();
		
	}
	
	public void updateTrainer() {
		factory=Persistence.createEntityManagerFactory("varun");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		System.out.println("Enter Id of Trainer for update");
		int id=sc.nextInt();
		App a=new App();
		Trainer tr=a.findTrainer(id);
		if(tr!=null)
		{
			manager.merge(tr);
		}
		else
		{
			System.out.println("Trainer not found");
		}
		
	}
	
	public Trainer findTrainer(int id)
	{
		factory=Persistence.createEntityManagerFactory("varun");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		Trainer trainer=manager.find(Trainer.class,id);
		if(trainer!=null)
		{
			return trainer;
		}
		else
		{
			return null;
		}
		
	}
	
	public void deleteTrainer() {
		System.out.println("Enter ID for delete Trainer");
		int id=sc.nextInt();
		factory=Persistence.createEntityManagerFactory("varun");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		Trainer t=manager.find(Trainer.class,id);
		manager.remove(t);
		System.out.println("Trainer Deleted");
	}
	
	public void findAllTrainer() {
		factory=Persistence.createEntityManagerFactory("varun");
		manager=factory.createEntityManager();
		jakarta.persistence.Query query=manager.createQuery("SELECT t FROM Trainer t");
		List<Trainer> list=query.getResultList();
		System.out.println(list);		
	}
	
	public static void main(String[] args) {
		App a=new App();
		
		System.out.println("Welcome in Trainers Table");
		System.out.println("Press 1.Add Trainer \n      2.Update Trainer \n      3.Find Trainer \n      4.Find all Trainers \n      5.Delete Trainer");
		int op=sc.nextInt();
		switch (op) {
		case 1:
			a.addTrainer();
			break;

		case 2:
			a.updateTrainer();
			break;
			
		case 3:
			System.out.println("Enter id for find Trainer");
			int id=sc.nextInt();
			Trainer tr=a.findTrainer(id);
			if(tr!=null)
			{
				System.out.println(tr);
			}
			else
			{
				System.out.println("Trainer not found");
			}
			break;
			
		case 4:
			System.out.println("All Trainers");
			a.findAllTrainer();
			break;
	}

	
	}




}
