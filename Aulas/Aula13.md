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
import model.Cadastrocliente;


public class CadastroclienteJpaController implements Serializable {
     public CadastroclienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cadastrocliente cadastrocliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cadastrocliente);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Cadastrocliente cadastrocliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cadastrocliente);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(Cadastrocliente cadastrocliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(cadastrocliente));
        em.getTransaction().commit();
        em.close();
    }

    public Cadastrocliente find(Object id) {
        EntityManager em = emf.createEntityManager();
        Cadastrocliente cadastrocliente = em.find(Cadastrocliente.class, id);
        em.close();
        return cadastrocliente;
    }

    public List<Cadastrocliente> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cadastrocliente.class));
        List<Cadastrocliente> result = em.createQuery(cq).getResultList();
        em.close();
        return result;
    }

    public List<Cadastrocliente> findRange(int[] range) {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cadastrocliente.class));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        List<Cadastrocliente> result = q.getResultList();
        em.close();
        return result;
    }

    public int count() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Cadastrocliente> rt = cq.from(Cadastrocliente.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        int count = ((Long) q.getSingleResult()).intValue();
        em.close();
        return count;
    }
}
```
