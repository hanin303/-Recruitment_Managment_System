package com.example;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CVRepository;
import com.example.dao.InterviewRepository;
import com.example.dao.OffreEmploiRepository;
import com.example.dao.QuestionnaireRepository;
import com.example.dao.QuestionsRepository;
import com.example.dao.RoleRepository;
import com.example.dao.UserRepository;
import com.example.entities.Admin;
import com.example.entities.Condidats;
import com.example.entities.Cv;
import com.example.entities.Interview;
import com.example.entities.Interviewer;
import com.example.entities.OffreEmploi;
import com.example.entities.Questionnaire;
import com.example.entities.Questions;
import com.example.entities.Recruteur;
import com.example.entities.Role;
import com.example.entities.User;

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
	private InterviewRepository interviewRepository;
	
	
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
		Cv cv1 = new Cv(1,"cv1.pdf");
		Cv cv2 = new Cv(2,"cv2.pdf");
		CvRep.save(cv1);
		CvRep.save(cv2);

		//Ajouter 2 roles
		Role role1=new Role(1L, "user");
		Role role2=new Role(2L, "admin");
		roleRepository.save(role1);
		roleRepository.save(role2);

		//Ajouter 2 users
		Date date1=new Date("12/12/2012");
		Date date2=new Date("1/1/2015");
		Date date3=new Date("10/1/2015");
		
		User u3=new Interviewer(1L,"nour", "guerfali", "aaaa", "aaaa", 1111111, 12345678, "photo", "c1",cv1,"1234",date1);
		User u4=new Recruteur(1L,"Hanin", "benJemaa", "aaaa", "aaaa", 1111111, 12345678, "photo", "c1",cv1,"1234",date1);
		User u6=new Recruteur(1L,"asma", "bbbbbb", "aaaa", "aaaa", 1111111, 12345678, "photo", "c1",cv1,"1234",date3);
		User u7=new Recruteur(1L,"Hend", "hend", "aaaa", "aaaa", 1111111, 12345678, "photo", "c1",cv1,"1234",date2);
		User u2=new Condidats(2L,"ilhem", "ben salhha", "bbbb", "bbbb", 2222222,  8888888, "photo2", "c2",cv2);
		User u5=new Admin();
		u5.setCin(12345678);
		u5.setEmail("ahmed@gmail.com");
		u5.setPrenom("ahmed");
		u5.setNom("ben saber");
		userRepository.save(u3);
		userRepository.save(u4);
		userRepository.save(u2);
		u3.getRoles().add(role1);
		userRepository.save(u3);
		userRepository.save(u5);
		userRepository.save(u6);
		userRepository.save(u7);


		
		
		Date date=new Date();
		Interview i=new Interview();
		i.setInterviewDate(date);
		i.setLocation("ssssssss");
		interviewRep.save(i);
	
		
	/*	System.out.println("size $$$$$$$  Inter : "+interviewRepository.findAllInterviews().size());
		
		Collection<Interview> l1=interviewRepository.findAllInterviews();
		Collection l = null;
		int j;
		l.addAll(l1);		

		System.out.println("**** : "+l.toString());*/
		List<String>s=userRepository.findAllUsers();
		String annee1=s.get(0).charAt(0)+""+s.get(0).charAt(1)+""+s.get(0).charAt(2)+""+s.get(0).charAt(3);
		String annee2=s.get(1).charAt(0)+""+s.get(1).charAt(1)+""+s.get(1).charAt(2)+""+s.get(1).charAt(3);
		
		System.out.println("**** : "+userRepository.findAllUsers().toString());
		
		System.out.println("**** : "+s.get(0).charAt(5));
		System.out.println("**** : "+s.get(1).charAt(5));
		System.out.println("annee : "+annee1.toString());
		System.out.println("annee : "+annee2.toString());
		System.out.println("**** : "+s.get(1));
		System.out.println("**** : "+s.get(0));
		
		List<String> a =new ArrayList<String> ();
		
		for(int j=0;j<s.size();j++) {
			String nb=s.get(j).charAt(5)+"";
			String annee=s.get(j).charAt(0)+""+s.get(j).charAt(1)+""+s.get(j).charAt(2)+""+s.get(j).charAt(3);
			
			a.add(annee);
			a.add(nb);
			
		}
		
		System.out.println("listaaaaaaa : "+a.get(0)+" "+a.get(1)+" "+a.get(2)+" "+a.get(3));
		
		//System.out.println("size"+s.size());
		
	/*	for(int j=0;j<userRepository.findAllUsers().size();j++) {
			List<Recruteur> user1= userRepository.findAllUsers();
			System.out.println("**** : "+user1.get(j).toString());
		}
		*/
		
	}
	
	

}
