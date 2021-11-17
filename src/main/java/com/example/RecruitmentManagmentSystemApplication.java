package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CVRepository;
import com.example.dao.InterviewRepository;
import com.example.dao.OffreEmploiRepository;
import com.example.dao.QuestionsRepository;
import com.example.dao.RoleRepository;
import com.example.dao.UserRepository;
import com.example.dao.UserRoleRepository;
import com.example.entities.Cv;
import com.example.entities.Interview;
import com.example.entities.OffreEmploi;
import com.example.entities.Questions;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.entities.UserRole;

@SpringBootApplication
public class RecruitmentManagmentSystemApplication implements CommandLineRunner{

	@Autowired
	private OffreEmploiRepository OffreRep;
	@Autowired
	private CVRepository CvRep;
	@Autowired
	  private InterviewRepository interviewRep;
	@Autowired
	  private QuestionsRepository questionsRep;
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository urRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RecruitmentManagmentSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Ajouter deux offres
		OffreEmploi Offre1 = new OffreEmploi(1,"Offre1","Description Offre 1", 10,new Date());
		OffreEmploi Offre2 = new OffreEmploi(2,"Offre2","Description Offre 2", 20,new Date());
		OffreRep.save(Offre1);
		OffreRep.save(Offre2);
		
		//Ajouter deux cv
		Cv cv1 = new Cv(1,"cv1.pdf");
		Cv cv2 = new Cv(2,"cv2.pdf");
		CvRep.save(cv1);
		CvRep.save(cv2);
		
		//AjouterInterview 
		Interview interview1 = interviewRep.save(new Interview(1L, new Date(),"physicall","Bizerte"));
		Interview interview2 = interviewRep.save(new Interview(2L, new Date(),"virtual","Tunis"));
		Interview interview3 = interviewRep.save(new Interview(3L,  new Date(),"physicall","Ariana"));
		//AjouterQuestions
		Questions questions1 = questionsRep.save(new Questions(1L, "Introduce yourself"));
		Questions questions2 = questionsRep.save(new Questions(2L, "what are your skills?"));
		Questions questions3 = questionsRep.save(new Questions(3L,  "How old are you?"));
		
		//Ajouter 2 users
		Date date1=new Date("12/12/2012");
		User u1=new User(1L, "nour", "guerfali", "aaaa", "aaaa", "aaa", 1111111, date1, 12345678, "photo", "c1");
		User u2=new User(2L, "ilhem", "ben salhha", "bbbb", "bbbb", "bbbb", 2222222, date1, 8888888, "photo2", "c2");
		userRepository.save(u1);
		userRepository.save(u2);
		
		
		//Ajouter 2 roles
		Role role1=new Role(1L, "user");
		Role role2=new Role(2L, "admin");
		roleRepository.save(role1);
		roleRepository.save(role2);
		
		
		//Ajouter 2 UserRole
		UserRole uRole1=new UserRole(1l);
		UserRole uRole2=new UserRole(2L);
		urRepository.save(uRole1);
		urRepository.save(uRole2);
		
		
	}

}
