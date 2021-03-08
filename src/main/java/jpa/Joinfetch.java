package jpa;

import test.testjpa.domain.Section;
import test.testjpa.domain.Tableau;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Joinfetch {
    private EntityManager manager;

    public Joinfetch(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("bddNone");
        EntityManager manager = factory.createEntityManager();
        Joinfetch test = new Joinfetch(manager);


        TypedQuery<Tableau> q = test.manager.createQuery("select distinct t from Tableau t join fetch t.sections s",Tableau.class);
        long start = System.currentTimeMillis();
        List<Tableau> res = q.getResultList();

        for (Tableau t : res) {
            for (Section s : t.getSections()) {
                System.out.println("Section name : " + s.getName());
            }
        }

        long end = System.currentTimeMillis();
        long duree = end - start;
        System.err.println("temps d'exec = " +  duree);

        System.out.println(".. done");
    }
}
