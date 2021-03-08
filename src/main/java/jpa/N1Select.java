package jpa;

import test.testjpa.domain.Section;
import test.testjpa.domain.Tableau;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class N1Select {
    private EntityManager manager;

    public N1Select(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("bddNone");
        EntityManager manager = factory.createEntityManager();
        N1Select test = new N1Select(manager);


        TypedQuery<Tableau> q = test.manager.createQuery("select t from Tableau t", Tableau.class);
        long start = System.currentTimeMillis();
        List<Tableau> res = q.getResultList();


        for (Tableau t : res) {
            for (Section s : t.getSections()) {
                System.out.println("Section name : " + s.getName());
            }
        }

        long end = System.currentTimeMillis();
        long duree = end - start;
        System.err.println("temps d'exec = " + duree);

        System.out.println(".. done");
    }
}
