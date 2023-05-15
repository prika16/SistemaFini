package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Usuario;

public class Teste {
	public static void main(String[] args) {
		
		
		

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemafini");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = new Usuario(null, "prika16", "1616");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        System.out.println("Pronto!");


}
}

