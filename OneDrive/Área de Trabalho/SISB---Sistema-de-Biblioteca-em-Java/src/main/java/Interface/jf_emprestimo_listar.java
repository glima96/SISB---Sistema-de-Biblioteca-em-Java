/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import ConexaoBanco.Conexao;
import Model.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João Marcos
 */
public class jf_emprestimo_listar extends javax.swing.JInternalFrame {

    /**
     * Creates new form JanelaEscola
     */
    private Conexao conexao;
    String emprestimo_titulo_pesquisa;
    
    public jf_emprestimo_listar() {
        
        this.conexao = new Conexao();
        
        initComponents();
        atualizaTabela(conexao);
         //inicializa a tela com os campos vazios e desabilitados
         //
         atualizaTabela(conexao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscarISBN = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabelaLivro = new javax.swing.JTable();
        lb_titulo_livro_cad = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listar emprestimos");
        setMinimumSize(new java.awt.Dimension(150, 40));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        tabelaLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo","ISBN" , "Ano", "Autores", "Editora" ,"Edição","Exemplar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        painelTabela.setViewportView(tabelaLivro);

        lb_titulo_livro_cad.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lb_titulo_livro_cad.setText("Emprestimos ");

        javax.swing.GroupLayout buscarISBNLayout = new javax.swing.GroupLayout(buscarISBN);
        buscarISBN.setLayout(buscarISBNLayout);
        buscarISBNLayout.setHorizontalGroup(
            buscarISBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarISBNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo_livro_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        buscarISBNLayout.setVerticalGroup(
            buscarISBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarISBNLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(buscarISBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscarISBNLayout.createSequentialGroup()
                        .addComponent(lb_titulo_livro_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(buscarISBN);

        setBounds(0, 0, 1059, 517);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //Anula a janelaEscola
        
        this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buscarISBN;
    private javax.swing.JLabel lb_titulo_livro_cad;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JTable tabelaLivro;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para reescrever todas as linhas da tabela
     * @param 
     */
    private void atualizaTabela(Conexao livro_dao)
    {
        
        try
        {
            
            
            limparTabela();
            
            ArrayList<Livro> listaLivro;
            listaLivro = consultar(); //consulta todos os registros da tabela Escola
            
            //Resgata o modelo da tabela            
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaLivro.getModel();

            for(Livro livro : listaLivro)
            {
                //adiciona em cada linha da tabela da tela o conteúdo de cada posição da listaEscolas
                modeloTabela.addRow(new String[]{livro.getTitulo(),livro.getIsbn(),Integer.toString(livro.getAno()),livro.getAutores(),livro.getEditora(),
                Integer.toString(livro.getEdicao()),Integer.toString(livro.getExemplar())});
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
        }
    }
    public ArrayList<Livro> consultar() {
        
        ArrayList<Livro> lista = new ArrayList<Livro>();
        String sql = "select * from livro inner join emprestimo on livro.exemplar = emprestimo.exemplar_book";
       
        conexao.conectar();
       
        try
        { 
            if(this.conexao.conectar())
            {  
                
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                 
                //recebe o resultado da consulta
                ResultSet resultado = sentenca.executeQuery();
                  
                //percorrer cada linha do resultado
                while(resultado.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Livro livro = new Livro();
                    livro.setAno(resultado.getInt("Ano"));
                    livro.setTitulo(resultado.getString("Titulo"));
                    livro.setEditora(resultado.getString("Editora"));
                    livro.setEdicao(resultado.getInt("Edicao"));
                    livro.setAutores(resultado.getString("Autores"));
                    livro.setIsbn(resultado.getString("ISBN"));
                    livro.setExemplar(resultado.getInt("EXEMPLAR"));
                                        
                   
                    //adiciona cada tupla na listaEscolas que será retornada para a janela Escola
                  lista.add(livro);
                }
                    
                sentenca.close();
                this.conexao.getConnection().close();
                
            }
            
            return lista;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
 
    
    }
        
    /**
     * Método para percorrer cada linha da tabela e realizar a exclusão
     */
    private void limparTabela()
    {
        //percorre a tabela e exclui todas as linhas
        while(tabelaLivro.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) tabelaLivro.getModel();
            dm.getDataVector().removeAllElements();
            
        }
    }
            
}
