package com.example;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CVRepository;
import com.example.dao.ContactRepository;
//import com.example.dao.ContactRepository;
import com.example.dao.InterviewRepository;
import com.example.dao.OffreEmploiRepository;
import com.example.dao.QuestionnaireRepository;
import com.example.dao.QuestionsRepository;
import com.example.dao.RoleRepository;
import com.example.dao.UserRepository;
import com.example.entities.Condidats;
import com.example.entities.Contact;
//import com.example.entities.Contact;
import com.example.entities.Cv;
import com.example.entities.Interview;
import com.example.entities.Interviewer;
import com.example.entities.OffreEmploi;
import com.example.entities.Questionnaire;
import com.example.entities.Questions;
import com.example.entities.Recruteur;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.web.CondidatRestService;

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
	@Autowired
	  private QuestionnaireRepository questionnaireRep;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	CondidatRestService condRS;
	
	public static void main(String[] args) {
		SpringApplication.run(RecruitmentManagmentSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Ajouter des offres
		OffreEmploi Offre1 = new OffreEmploi(1,"Chef de bureau à Bizerte","Le chef de bureau répond aux objectifs commerciaux qui lui ont été attribués, avec l'aide de son équipe :\r\n" + 
				"\r\n" + 
				"Exerce, au quotidien, un rôle de manager auprès du personnel du bureau.\r\n" + 
				"\r\n" + 
				"Effectue les visites de prospection, de fidélisation des clients et des partenaires.\r\n" + 
				"\r\n" + 
				"Assure le développement de la clientèle, et du relationnel avec les partenaires externes\r\n" + 
				"\r\n" + 
				"Il est responsable de la rentabilité de son bureau et des risques qu'il encourt.\r\n" + 
				"\r\n" + 
				"Analyse les principaux indicateurs de l'activité et veille à ce que ces indicateurs soient en ligne avec les objectifs tracés.\r\n" + 
				"\r\n" + 
				"Veille à l'application rigoureuse des procédures internes de la société" , 10,new Date("09/06/2021"));
		OffreEmploi Offre2 = new OffreEmploi(2,"Commerciaux terrain en Microfinance","Ses missions sont les suivantes :\r\n" + 
				"PROSPECTER : Réaliser des actions de prospection auprès des entrepreneurs\r\n" + 
				"ANALYSER : Analyser l'activité des entrepreneurs sollicitant un crédit\r\n" + 
				"ACCOMPAGNER : Suivre le client après le déboursement du crédit\r\n" + 
				"RECOUVRER : Effectuer les opérations de recouvrement en lien avec la direction d'agence" , 20,new Date());
		OffreEmploi Offre3 = new OffreEmploi(3,"Superviseuse Expérimente","Gestion d'une équipe de télévendeurs\r\n" + 
				"\r\n" + 
				"Participer à l'activité commerciale (phoning) et Veillez a l'atteinte des objectifs\r\n" + 
				"\r\n" + 
				"Reporting avec le responsable hiérarchique\r\n" + 
				"\r\n" + 
				"Formation des futurs collaborateurs" , 10,new Date());
		OffreEmploi Offre4 = new OffreEmploi(4,"BPO Services recrute Formateur","- Mettre en place et assurer les ateliers métier lié aux centres d’appels.\r\n" + 
				"- Élaborer et rédiger les supports de formation continue.\r\n" + 
				"- Contribuer à la préparation et à la mise en place des sessions de formations.\r\n" + 
				"- Animer des formations métier ou produit.\r\n" + 
				"- Intervenir sur des actions de montée en compétence et accompagnement personnalisé des téléopérateurs.", 20,new Date());
		OffreEmploi Offre5 = new OffreEmploi(5,"Responsable Qualité Produit","Reportant au Directeur du site et au chef de département qualité,\r\n" + 
				"Vous êtes au cœur des problématiques qualité sur le périmètre du site : qualité système, qualité production, qualité client.\r\n" + 
				"Vous vous assurez du déploiement de la politique qualité définie par la direction qualité division\r\n" + 
				"Vous élaborez et maintenez le système de management qualité du site dans le respect des référentiels qualité, sécurité et environnement choisis et/ou imposés par les clients et la direction.\r\n" + 
				"Vous représentez le client au cours de la vie série des pièces et des développements produits et process.\r\n" + 
				"Vous réalisez les audits internes.\r\n" + 
				"Vous définissez les mises au point et les plans de qualification des nouveaux moyens." , 10,new Date());
		OffreEmploi Offre6 = new OffreEmploi(6,"Développement DataWarehouses","Développer des procédures stockées en PL/SQL selon le besoin clients.\r\n" + 
				"Développements autour des déclencheurs LDD (Triggers).\r\n" + 
				"Participer aux estimations de complexité des développements sur le produit.\r\n" + 
				"Apporter votre expertise technique pour analyser les incidents soulevés par le client.\r\n" + 
				"Gérer la documentation·" , 20,new Date());
		OffreRep.save(Offre1);
		OffreRep.save(Offre2);
		OffreRep.save(Offre3);
		OffreRep.save(Offre4);
		OffreRep.save(Offre5);
		OffreRep.save(Offre6);

		//Ajouter deux cv
		Cv cv1 = new Cv("cv1.pdf");
		Cv cv2 = new Cv("cv2.pdf");
		CvRep.save(cv1);
		CvRep.save(cv2);

		//Ajouter 2 roles
		Role role1=new Role(1L, "user");
		Role role2=new Role(2L, "admin");
		roleRepository.save(role1);
		roleRepository.save(role2);

		//Ajouter 2 users
		Date date1=new Date("12/12/2012");
		User u3=new Interviewer(1L,"nour", "guerfali", "aaaa", "aaaa", 1111111, 12345678, "photo", "c1",cv1,"1234",date1);
		User u4=new Recruteur(1L,"Hanin", "benJemaa", "aaaa", "aaaa", 1111111, 12345678, "photo", "c1",cv1,"1234",date1);
		User u2=new Condidats(2L,"Mokded", "Maryam", "Maryam@gmail.com", "Bizerte",11427586,53740917, "photoMaryam", "c2",cv2);
		User u5=new Condidats(3L,"Weslati", "Samia", "Samia@gamilcom", "Bizerte", 2222222,53205145, "photoSamia", "c2",cv2);
		User u6=new Condidats(4L,"Ben Salha", "Ilhem", "Ilhem@gmail.com", "Bizerte",114785236,52186359, "photoIlhem", "c2",cv2);
		
		userRepository.save(u4);
		userRepository.save(u2);
		u3.getRoles().add(role1);
		userRepository.save(u3);
		userRepository.save(u5);	
		userRepository.save(u6);

		
		
		//AjouterInterview 
		Interview interview1 = new Interview(1L, new Date(),"RH","virtual","12:48",0);
		Interview interview2 = new Interview(2L, new Date(),"technique","physicall","10:05",0);
		Interview interview3 = new Interview(3L,  new Date(),"téléphonique","virtual","17:00",0);
		
		interviewRep.save(interview1);
		interviewRep.save(interview2);
		interviewRep.save(interview3);
		
		//AjouterQuestions
		Questions questions1 = questionsRep.save(new Questions(1L, "Tell me about yourself , your strengths ? weaknesses"));
		Questions questions2 = questionsRep.save(new Questions(2L, "Why do you want to leave your current job?"));
		Questions questions3 = questionsRep.save(new Questions(3L,  "What makes you the perfect condidate for this position?"));
		Questions questions4 = questionsRep.save(new Questions(4L,  "Where do you see yourself five (ten or fifteen) years from now?"));

		//contact 
	    Contact contact1 = contactRepository.save(new Contact (1L,"hanin", "benjemaa", "hanin@gmail.com", "when will you accept me ?"));
	}

}
