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
     - [mysql-connector-j-8.4.0.zip](https://github.com/user-attachments/files/15754422/mysql-connector-j-8.4.0.zip)
     - [protobuf-java-2.4.1.zip](https://github.com/user-attachments/files/15754427/protobuf-java-2.4.1.zip)


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

Código do View para um norteador, mas como está sendo criado com o GUI nem toda parte do código pode ser copiada diretamente para o JFrame telaCadastro.

```Java
public class telaCadastro extends javax.swing.JFrame {
    CadastroJpaController daoCadastro;

    public telaCadastro() {
        initComponents();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MaisUmTestePU");
        daoCadastro = new CadastroJpaController(emf);
        atualizaTabela();
    }
    
    public void atualizaTabela(){
        List<Cadastro> lista = this.daoCadastro.findAll();
        DefaultTableModel tabela = (DefaultTableModel) tabelaClientes.getModel();
        tabela.setRowCount(0);
        
        for(Cadastro c: lista){
            Object[] obj = new Object[]{
                c.getIdcadastro(), c.getNomeCliente()
            };
            tabela.addRow(obj);
        }
    }
    
    public void preencheDado(){
        int linhaSelecionada = tabelaClientes.getSelectedRow();
        
        if(linhaSelecionada < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        }else{
            int codigo = Integer.parseInt(tabelaClientes.getValueAt(linhaSelecionada, 0).toString());
            Cadastro c = this.daoCadastro.find(codigo);
            tfCodigo.setText(String.valueOf(c.getIdcadastro()));
            tfNome.setText(c.getNomeCliente());
        }

    //a partir daqui, esse métodos tem que ser criado juntos ao NetBeans
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {                                       
            tfCodigo.setText("");
            tfNome.setText("");
    }                                      

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Cadastro cadastro = new Cadastro();
        cadastro.setNomeCliente(tfNome.getText());
        
        try {
            this.daoCadastro.create(cadastro);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            atualizaTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }                                        

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {                                         
       int codigo = Integer.parseInt(tfCodigo.getText());
       Cadastro c = this.daoCadastro.find(codigo);
       c.setNomeCliente(tfNome.getText());
           
        try {
           this.daoCadastro.edit(c);
           JOptionPane.showMessageDialog(null, "Cadastro alterado");
           atualizaTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        } 
    }                                        

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int codigo = Integer.parseInt(tfCodigo.getText());
        Cadastro c = this.daoCadastro.find(codigo);

        try {
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir esse cadastro?","Excluir Cliente",JOptionPane.YES_NO_OPTION);
            if(i == JOptionPane.YES_OPTION) {
               this.daoCadastro.remove(c);
               JOptionPane.showMessageDialog(null, "Cadastro removido");
                atualizaTabela();
            }else{
                JOptionPane.showMessageDialog(null, "Operação cancelada");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }                                         

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {                                            
        preencheDado();
    }                                           

    private void tabelaClientesKeyReleased(java.awt.event.KeyEvent evt) {                                           
        preencheDado();
    }
}
```

