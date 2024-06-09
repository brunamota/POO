# Aula 13 - Interfaces Gráficas de gerenciamento de dados

Model-View-Controller é um padrão em design de software comumente usado para implementar interfaces de usuário, dados e lógica de controle. Ele enfatiza a separação entre a lógica de negócios e a exibição do software. Esta “separação de preocupações” proporciona uma melhor divisão do trabalho e uma melhor manutenção.

As três partes do padrão de design de software MVC podem ser descritas da seguinte forma:

1. Model: Gerencia dados e lógica de negócios. Define quais dados o aplicativo deve conter.
2. View: Lida com layout e exibição. Define como os dados do aplicativo devem ser exibidos
3. Controller: Direciona comandos para o modelo e visualiza peças. Contém lógica que atualiza o modelo e/ou visualização em resposta à entrada dos usuários do aplicativo.

![Sem Título-1](https://github.com/brunamota/POO/assets/66503956/11ae183d-3ec9-4b08-8163-a2039f82e0be)

Passo a passo da aula:

:white_check_mark: [Instalar o WorkBench](https://dev.mysql.com/downloads/file/?id=528489)

:white_check_mark: 


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
