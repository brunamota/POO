# Aula 13 - hora que filho chora e mãe não vê

Não ta pronta essa, não copia

![mvc-diagram](https://github.com/brunamota/POO/assets/66503956/8d4c78ed-52a3-464c-9149-15e73b37d500)

``` Java


package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import model.Clientes;


public class ClientesJpaController implements Serializable {
     public ClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes Clientes) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(Clientes);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Clientes Clientes) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(Clientes);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(Clientes Clientes) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(Clientes));
        em.getTransaction().commit();
        em.close();
    }

    public Clientes find(Object id) {
        EntityManager em = emf.createEntityManager();
        Clientes Clientes = em.find(Clientes.class, id);
        em.close();
        return Clientes;
    }

    public List<Clientes> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Clientes.class));
        List<Clientes> result = em.createQuery(cq).getResultList();
        em.close();
        return result;
    }

    public List<Clientes> findRange(int[] range) {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Clientes.class));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        List<Clientes> result = q.getResultList();
        em.close();
        return result;
    }

    public int count() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Clientes> rt = cq.from(Clientes.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        int count = ((Long) q.getSingleResult()).intValue();
        em.close();
        return count;
    }
}
```
