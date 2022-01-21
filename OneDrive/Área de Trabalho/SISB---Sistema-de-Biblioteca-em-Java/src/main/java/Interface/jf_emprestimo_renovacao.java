/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Interface;

import ConexaoBanco.Conexao;
import Model.Livro;
import Model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.util.concurrent.TimeUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class jf_emprestimo_renovacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form jf_alterar_livro
     */
    private Conexao conexao;
    String exemplar_pesquisa;
    String cpf_pesquisa;
    int dias;
    LocalDate dataEntrega, dataDevolucao;
    String stringDataDevolucao;

    public jf_emprestimo_renovacao() {
        this.conexao = new Conexao();
        initComponents();

        txt_ano_livro.setEditable(false);
        txt_autores_livro.setEditable(false);
        txt_edicao_livro.setEditable(false);
        txt_editora_livro.setEditable(false);
        txt_isbn_livro.setEditable(false);
        txt_titulo_livro.setEditable(false);
        btn_salvar.setEnabled(false);

        txt_nome_usuario.setEditable(false);
        txt_cpf_usuario.setEditable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_isbn_pesquisa_livro_alt = new javax.swing.JLabel();
        txt_exemplar_pesquisa_livro = new javax.swing.JTextField();
        lb_titulo_livro_alt = new javax.swing.JLabel();
        txt_ano_livro = new javax.swing.JTextField();
        txt_isbn_livro = new javax.swing.JTextField();
        lb_autores_livro_alt = new javax.swing.JLabel();
        lb_isbn_livro = new javax.swing.JLabel();
        lb_edicao_livro_alt = new javax.swing.JLabel();
        lb_ano_livro_alt = new javax.swing.JLabel();
        lb_editora_livro_alt = new javax.swing.JLabel();
        txt_titulo_livro = new javax.swing.JTextField();
        txt_autores_livro = new javax.swing.JTextField();
        txt_edicao_livro = new javax.swing.JTextField();
        txt_editora_livro = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_pesquisar_livro = new javax.swing.JButton();
        lb_nome_usuario = new javax.swing.JLabel();
        lb_cpf_usuario = new javax.swing.JLabel();
        txt_nome_usuario = new javax.swing.JTextField();
        txt_cpf_usuario = new javax.swing.JTextField();
        btn_salvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Renovação emprestimo");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_isbn_pesquisa_livro_alt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_isbn_pesquisa_livro_alt.setText("Exemplar");
        getContentPane().add(lb_isbn_pesquisa_livro_alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, -1, -1));

        txt_exemplar_pesquisa_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_exemplar_pesquisa_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        txt_exemplar_pesquisa_livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_exemplar_pesquisa_livroActionPerformed(evt);
            }
        });
        getContentPane().add(txt_exemplar_pesquisa_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, -1, 33));

        lb_titulo_livro_alt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_titulo_livro_alt.setText("Título");
        getContentPane().add(lb_titulo_livro_alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 118, -1, 30));

        txt_ano_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_ano_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(txt_ano_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 363, -1, 30));

        txt_isbn_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_isbn_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(txt_isbn_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 363, -1, 30));

        lb_autores_livro_alt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_autores_livro_alt.setText("Autores");
        getContentPane().add(lb_autores_livro_alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 186, -1, -1));

        lb_isbn_livro.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_isbn_livro.setText("ISBN");
        getContentPane().add(lb_isbn_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 325, -1, 32));

        lb_edicao_livro_alt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_edicao_livro_alt.setText("Edição");
        lb_edicao_livro_alt.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(lb_edicao_livro_alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 325, 60, 32));

        lb_ano_livro_alt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_ano_livro_alt.setText("Ano");
        getContentPane().add(lb_ano_livro_alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 329, -1, -1));

        lb_editora_livro_alt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_editora_livro_alt.setText("Editora");
        lb_editora_livro_alt.setPreferredSize(new java.awt.Dimension(61, 50));
        getContentPane().add(lb_editora_livro_alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 258, -1, 25));

        txt_titulo_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_titulo_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        txt_titulo_livro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_titulo_livroFocusGained(evt);
            }
        });
        txt_titulo_livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_titulo_livroActionPerformed(evt);
            }
        });
        getContentPane().add(txt_titulo_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 154, 330, 30));

        txt_autores_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_autores_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(txt_autores_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 217, 330, 30));

        txt_edicao_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_edicao_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(txt_edicao_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 363, -1, 30));

        txt_editora_livro.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_editora_livro.setMaximumSize(new java.awt.Dimension(600, 30));
        txt_editora_livro.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(txt_editora_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 289, 330, 30));

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 51));
        btn_cancelar.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setAlignmentX(0.5F);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 281, 54));

        btn_pesquisar_livro.setBackground(new java.awt.Color(51, 102, 255));
        btn_pesquisar_livro.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        btn_pesquisar_livro.setForeground(new java.awt.Color(255, 255, 255));
        btn_pesquisar_livro.setText("Pesquisar");
        btn_pesquisar_livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisar_livroActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pesquisar_livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 42, -1, -1));

        lb_nome_usuario.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_nome_usuario.setText("Nome");
        getContentPane().add(lb_nome_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, 30));

        lb_cpf_usuario.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb_cpf_usuario.setText("CPF");
        getContentPane().add(lb_cpf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, -1));

        txt_nome_usuario.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_nome_usuario.setPreferredSize(new java.awt.Dimension(140, 25));
        txt_nome_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nome_usuarioFocusGained(evt);
            }
        });
        txt_nome_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nome_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 330, 30));

        txt_cpf_usuario.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txt_cpf_usuario.setPreferredSize(new java.awt.Dimension(140, 25));
        getContentPane().add(txt_cpf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 330, 30));

        btn_salvar.setBackground(new java.awt.Color(51, 102, 255));
        btn_salvar.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        btn_salvar.setForeground(new java.awt.Color(255, 255, 255));
        btn_salvar.setText("SALVAR");
        btn_salvar.setAlignmentX(0.5F);
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 363, 281, 54));

        setBounds(60, 20, 869, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_titulo_livroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_titulo_livroFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_titulo_livroFocusGained

    private void txt_titulo_livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_titulo_livroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_titulo_livroActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:

        txt_titulo_livro.setText("");
        txt_ano_livro.setText("");
        txt_autores_livro.setText("");
        txt_edicao_livro.setText("");
        txt_editora_livro.setText("");
        txt_isbn_livro.setText("");
        txt_cpf_usuario.setText("");
        txt_nome_usuario.setText("");

        txt_exemplar_pesquisa_livro.setEditable(true);

        txt_exemplar_pesquisa_livro.setText("");


    }//GEN-LAST:event_btn_cancelarActionPerformed

    @SuppressWarnings("empty-statement")
    private void btn_pesquisar_livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisar_livroActionPerformed
        // TODO add your handling code here:

        // Pega o numero do exemplar na caixa de texto e insere na variavel
        exemplar_pesquisa = txt_exemplar_pesquisa_livro.getText();

        //Conecta com o banco
        Conexao c = null;

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                //prepara a sentença com a consulta da string
                // consulta que pega as informações do livro com o exemplar igual ao da pesquisa
                String sql = "select * from livro where exemplar ='" + exemplar_pesquisa + "' and disponibilidade = 0";

                // Variavel que recebe o retorno do select 
                ResultSet resultado;

                // Preparador de sentença, com a sql a ser enviada e a conexão com o banco
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                resultado = sentenca.executeQuery(); //executa o comando no banco
                // se ouver resultado da consulta
                if (resultado.next()) {
                    // se o livro estiver disponivel sera igual a 0
                    if (resultado.getInt("disponibilidade") == 0) {
                        // insere as informações do livro nas caixa de texto na tela
                        txt_titulo_livro.setText(resultado.getString("titulo"));
                        txt_ano_livro.setText(resultado.getString("ano"));
                        txt_autores_livro.setText(resultado.getString("autores"));
                        txt_edicao_livro.setText(resultado.getString("edicao"));
                        txt_editora_livro.setText(resultado.getString("editora"));
                        txt_isbn_livro.setText(resultado.getString("isbn"));
                        // bloqueia a edicao da caixa de texto com o exemplar
                        txt_exemplar_pesquisa_livro.setEditable(false);

                        // agora e a consulta com o usuario que fez o emprestimo 
                        // primeiro pegamos qual cpf esta no emprestimo com a consulta abaixo
                        String sql_emprestimo = "select * from emprestimo where exemplar_book ='" + exemplar_pesquisa + "'";
                        sentenca = this.conexao.getConnection().prepareStatement(sql_emprestimo);

                        resultado = sentenca.executeQuery(); //executa o comando no banco
                        //pegando a data para ser usada logo a frente

                        if (resultado.next()) {
                            cpf_pesquisa = resultado.getString("cpf_user");

                            String data = resultado.getString("d_devolucao");

                            // pegando o usuario que fez o emprestimo 
                            String sql_usuario = "select * from usuario where cpf ='" + cpf_pesquisa + "'";

                            sentenca = this.conexao.getConnection().prepareStatement(sql_usuario);
                            resultado = sentenca.executeQuery();

                            // se tiver resultado na consulta
                            if (resultado.next()) {
                                txt_cpf_usuario.setText(resultado.getString("cpf"));
                                txt_nome_usuario.setText(resultado.getString("nome"));
                            } else {
                                String s = "ERRO select usuario ";
                                JOptionPane.showMessageDialog(null, s);
                            }

                            btn_salvar.setEnabled(true);
                        } else {
                            String s = "ERRO";
                            JOptionPane.showMessageDialog(null, s);
                        }

                    } else {
                        String s = "ERRO disponibilidade livro";
                        JOptionPane.showMessageDialog(null, s);
                    }

                } else {
                    String s = "ERRO";
                    JOptionPane.showMessageDialog(null, s);
                }

                //txt_titulo_livro.setText(resultado.getString());
                //fecha a sentença
                sentenca.close();
                this.conexao.getConnection().close(); //fecha a conexão com o banco

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }//GEN-LAST:event_btn_pesquisar_livroActionPerformed

    private void txt_nome_usuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nome_usuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_usuarioFocusGained

    private void txt_nome_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_usuarioActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // TODO add your handling code here:

        Conexao c = null;

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {

                PreparedStatement sentenca;

                String sql_emprestimo = "select * from emprestimo where exemplar_book ='" + exemplar_pesquisa + "' and devolucao = 0";

                //LocalDate data=dataHoje.plusDays(7)
                PreparedStatement sentenca_emprestimo = this.conexao.getConnection().prepareStatement(sql_emprestimo);

                ResultSet resultado;
                resultado = sentenca_emprestimo.executeQuery(); //executa o comando no banco

                //fecha a sentença
                if (resultado.next()) {
                    String data = resultado.getString("d_devolucao");
                    System.out.println(data);
                    LocalDate dataNova = LocalDate.parse(data);
                    System.out.println("1");
                    String sql_update = "update emprestimo set d_devolucao = '" + dataNova.plusDays(7) + "' where exemplar_book ='" + exemplar_pesquisa + "' and devolucao = 0";
                    sentenca = this.conexao.getConnection().prepareStatement(sql_update);
                    System.out.println("2");
                    sentenca.execute(); //executa o comando no banco
                    sentenca.close(); //fecha a sentença
                    System.out.println("3");
                    //ALERTA DE SUCESSO
                    String s = "SUCESSO";
                    JOptionPane.showMessageDialog(null, s);
                }

            }
        } catch (SQLException ex) {
            String s = "ERRO ao renovar";
            JOptionPane.showMessageDialog(null, s);
        }

        //LIMPANDO AS CAIXAS DE TEXTOS
        txt_titulo_livro.setText("");
        txt_ano_livro.setText("");
        txt_autores_livro.setText("");
        txt_edicao_livro.setText("");
        txt_editora_livro.setText("");
        txt_isbn_livro.setText("");
        txt_cpf_usuario.setText("");
        txt_nome_usuario.setText("");

        txt_exemplar_pesquisa_livro.setEditable(true);

        txt_exemplar_pesquisa_livro.setText("");


    }//GEN-LAST:event_btn_salvarActionPerformed

    private void txt_exemplar_pesquisa_livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_exemplar_pesquisa_livroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_exemplar_pesquisa_livroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_pesquisar_livro;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel lb_ano_livro_alt;
    private javax.swing.JLabel lb_autores_livro_alt;
    private javax.swing.JLabel lb_cpf_usuario;
    private javax.swing.JLabel lb_edicao_livro_alt;
    private javax.swing.JLabel lb_editora_livro_alt;
    private javax.swing.JLabel lb_isbn_livro;
    private javax.swing.JLabel lb_isbn_pesquisa_livro_alt;
    private javax.swing.JLabel lb_nome_usuario;
    private javax.swing.JLabel lb_titulo_livro_alt;
    private javax.swing.JTextField txt_ano_livro;
    private javax.swing.JTextField txt_autores_livro;
    private javax.swing.JTextField txt_cpf_usuario;
    private javax.swing.JTextField txt_edicao_livro;
    private javax.swing.JTextField txt_editora_livro;
    private javax.swing.JTextField txt_exemplar_pesquisa_livro;
    private javax.swing.JTextField txt_isbn_livro;
    private javax.swing.JTextField txt_nome_usuario;
    private javax.swing.JTextField txt_titulo_livro;
    // End of variables declaration//GEN-END:variables

    private Object daysBetween(Date dataInicial, Date dataFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
