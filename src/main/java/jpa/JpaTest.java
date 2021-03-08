package jpa;

import test.testjpa.domain.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bddCreate");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createFichesTableaux();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listFiches();
		test.listTableaux();

		manager.close();
		System.out.println(".. done");
	}

	private void createFichesTableaux() {
        Tableau tableau1 = new Tableau();
        tableau1.setName("Tableau");

		Section section1 = new Section();
        section1.setName("en attente");

        Section section2 = new Section();
		section2.setName("en cours");

		Section section3 = new Section();
		section3.setName("réalisé");

		tableau1.add(section1);
		tableau1.add(section2);
		tableau1.add(section3);

        Fiche fiche1 = new Fiche("Diag. de classe");
		Fiche fiche2 = new Fiche("Class User");
		Fiche fiche3 = new Fiche("Class Dossier");
		Fiche fiche4 = new Fiche("Tester Class");

		section1.addFiche(fiche4);
		section2.addFiche(fiche2);
		section2.addFiche(fiche3);
		section3.addFiche(fiche1);

		manager.persist(tableau1);

		manager.persist(section1);
		manager.persist(section2);
		manager.persist(section3);

		manager.persist(fiche1);
		manager.persist(fiche2);
		manager.persist(fiche3);
		manager.persist(fiche4);

    }



	private void listFiches() {
		List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
		System.out.println("nb fiches:" + resultList.size());
		for (Fiche next : resultList) {
			System.out.println("next fiche: " + next.toString());
		}
	}

	private void listTableaux() {
		List<Tableau> resultTab = manager.createQuery("Select a From Tableau a", Tableau.class).getResultList();
		System.out.println("nb tableau:" + resultTab.size());
		for (Tableau next : resultTab) {
			System.out.println("next tab: " + next.toString());
		}
	}

//	private void listSondages(EntityManager entityManager) {
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Sondage> query = criteriaBuilder.createQuery(Sondage.class);
//		Root<SondageDates> from = query.from(SondageDates.class);
//		query.select(from.get("a"))
//				.where(from.get("a").in(1, 2, 3, 4));
//	}
}
