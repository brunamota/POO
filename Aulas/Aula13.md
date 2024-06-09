# Aula 13 - Interfaces Gráficas de gerenciamento de dados

Model-View-Controller é um padrão em design de software comumente usado para implementar interfaces de usuário, dados e lógica de controle. Ele enfatiza a separação entre a lógica de negócios e a exibição do software. Esta “separação de preocupações” proporciona uma melhor divisão do trabalho e uma melhor manutenção.

As três partes do padrão de design de software MVC podem ser descritas da seguinte forma:

1. Model: Gerencia dados e lógica de negócios. Define quais dados o aplicativo deve conter.
2. View: Lida com layout e exibição. Define como os dados do aplicativo devem ser exibidos
3. Controller: Direciona comandos para o modelo e visualiza peças. Contém lógica que atualiza o modelo e/ou visualização em resposta à entrada dos usuários do aplicativo.

![Sem Título-1](https://github.com/brunamota/POO/assets/66503956/11ae183d-3ec9-4b08-8163-a2039f82e0be)

Passo a passo da aula:

:white_check_mark: [Instalar o WorkBench](https://dev.mysql.com/downloads/file/?id=528489)

:white_check_mark: Criar um banco para o cadastro do cliente contendo idCadastro e nomeCadastro

:white_check_mark: Criar uma Entity Class from DataBase' para fazer a ligação do banco com a aplicação (model)
     - Usar os pacotes para criação do driver (mysql-connector-java-8.0.11.jar e protobuf-java-2.6.0.jar)

:white_check_mark: Criar um 'JPA Controller Classes from Entity Classes' para criar os comandos do banco em Java (DAO)
     - DAO: Organização Autônoma Descentralizada é uma entidade na qual todos os membros participam da tomada de decisões, pois não existe uma autoridade central. (controller)
     - Copiar esse código de baixo:
``` Java
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import model.Cadastro;

public class CadastroJpaController implements Serializable {
     public CadastroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cadastro cadastro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cadastro);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Cadastro cadastro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cadastro);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(Cadastro cadastro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(cadastro));
        em.getTransaction().commit();
        em.close();
    }

    public Cadastro find(Object id) {
        EntityManager em = emf.createEntityManager();
        Cadastro cadastro = em.find(Cadastro.class, id);
        em.close();
        return cadastro;
    }

    public List<Cadastro> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cadastro.class));
        List<Cadastro> result = em.createQuery(cq).getResultList();
        em.close();
        return result;
    }

    public List<Cadastro> findRange(int[] range) {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cadastro.class));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        List<Cadastro> result = q.getResultList();
        em.close();
        return result;
    }

    public int count() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Cadastro> rt = cq.from(Cadastro.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        int count = ((Long) q.getSingleResult()).intValue();
        em.close();
        return count;
    }
}
```

:white_check_mark: Criar a tela de cadastro (view)

![Captura de tela 2024-06-09 143851](https://github.com/brunamota/POO/assets/66503956/194d8d13-44d2-4de4-ae73-4d3c00c6b675)


