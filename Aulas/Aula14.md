# Aula 14 - Interfaces Gráficas de gerenciamento de dados

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
