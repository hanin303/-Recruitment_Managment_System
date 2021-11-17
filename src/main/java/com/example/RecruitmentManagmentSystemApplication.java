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
import com.example.entities.Cv;
import com.example.entities.Interview;
import com.example.entities.OffreEmploi;
import com.example.entities.Questions;

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
		
	}

}
