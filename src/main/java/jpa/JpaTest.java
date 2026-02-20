package jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.domain.Concert;
import jpa.domain.Organizer;
import jpa.domain.PremiumTicket;
import jpa.domain.Ticket;

import java.util.List;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			// TODO create and persist entity*

			// 1. Création de l'organisateur
			Organizer liveNation = new Organizer();
			liveNation.setName("Live Nation");

			// 1. On crée une instance de notre classe Concert
			Concert monConcert = new Concert();
			monConcert.setArtist("Daft Punk");
			monConcert.setLocation("Stade de France");
			monConcert.setDate(new java.util.Date());
			monConcert.setPrice(75.0);
			monConcert.setOrganizer(liveNation);

			/// Création d'un concert pour lier les tickets
			Concert metallica = new Concert();
			metallica.setArtist("Metallica");
			manager.persist(metallica);

			// 1. Un ticket classique
			Ticket t1 = new Ticket();
			t1.setSeatNumber("A12");
			t1.setConcert(metallica);

			// 2. Un ticket Premium
			PremiumTicket t2 = new PremiumTicket();
			t2.setSeatNumber("VIP-01");
			t2.setVipService("Champagne");
			t2.setConcert(metallica);

			manager.persist(t1);
			manager.persist(t2);

			liveNation.getConcerts().add(monConcert);


			// 2. On demande au manager de l'enregistrer
			manager.persist(liveNation);

			System.out.println("Concert enregistré avec succès !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		//on teste la lecture de la base de donnée
		test.listConcerts();

			
   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}


	// test de requetes simple
	private void listConcerts() {
		// Requête JPQL pour récupérer tous les objets Concert [cite: 229]
		List<Concert> resultList = manager.createQuery("Select c From Concert c", Concert.class).getResultList();

		System.out.println("Nombre de concerts trouvés : " + resultList.size());
		for (Concert next : resultList) {
			System.out.println("Concert : " + next.getArtist() + " à " + next.getLocation());
		}
	}


}
