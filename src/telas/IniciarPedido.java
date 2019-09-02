package telas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.Bebida;
import modelos.Fisica;
import modelos.Juridica;
import modelos.Pedido;
import modelos.Pizza;
import modelos.Sabor;

public class IniciarPedido extends javax.swing.JFrame {

    public ArrayList<Bebida> listaBebida = new ArrayList<>();
    public ArrayList<Sabor> listaSabor = new ArrayList<>();
    public ArrayList<Pizza> listaTamanho = new ArrayList<>();
    public ArrayList<Fisica> listaFisico = new ArrayList<>();
    public ArrayList<Juridica> listaJuridica = new ArrayList<>();
    public Pedido pedido = new Pedido();
    public double total = 0;

    public IniciarPedido() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        preencheComboBox();
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    public boolean fechar() {
        this.dispose();
        return true;
    }

    public void preencheComboBox() throws SQLException {

        listaBebida = Bebida.buscaBebidas();
        listaSabor = Sabor.buscaSabores();
        listaTamanho = Pizza.buscaPizzas();
        listaFisico = Fisica.buscaFisico();
        listaJuridica = Juridica.buscaJuridico();

        for (int i = 0; i < listaBebida.size(); i++) {
            comboBebida.addItem(listaBebida.get(i).getNome());
        }

        for (int i = 0; i < listaSabor.size(); i++) {
            comboSabor.addItem(listaSabor.get(i).getNome());
        }

        for (int i = 0; i < listaTamanho.size(); i++) {
            comboTamanho.addItem(listaTamanho.get(i).getTamanho());
        }

        for (int i = 0; i < listaFisico.size(); i++) {
            comboFisico.addItem(listaFisico.get(i).getNome());
        }

        for (int i = 0; i < listaJuridica.size(); i++) {
            comboJuridico.addItem(listaJuridica.get(i).getNome());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonSalva = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedido = new javax.swing.JTable();
        textTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTamanho = new javax.swing.JComboBox<>();
        comboSabor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBebida = new javax.swing.JComboBox<>();
        radioFisico = new javax.swing.JRadioButton();
        radioJuridico = new javax.swing.JRadioButton();
        comboFisico = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboJuridico = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        buttoAdicionarSabor = new javax.swing.JButton();
        buttoAdicionarTam = new javax.swing.JButton();
        buttonAdicionarBebida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Pedido");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Realizar Pedido");

        buttonSalva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSalva.setText("Salvar");

        buttonSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        tablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descriçao", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tablePedido);

        textTotal.setEditable(false);
        textTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textTotal.setForeground(new java.awt.Color(0, 0, 204));
        textTotal.setText("0,00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tamanho");

        comboTamanho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        comboSabor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboSabor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Sabor");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Bebida");

        comboBebida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboBebida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        radioFisico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radioFisico.setSelected(true);
        radioFisico.setText("Fisico");
        radioFisico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioFisicoMouseClicked(evt);
            }
        });
        radioFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFisicoActionPerformed(evt);
            }
        });

        radioJuridico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radioJuridico.setText("Juridico");
        radioJuridico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioJuridicoMouseClicked(evt);
            }
        });
        radioJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioJuridicoActionPerformed(evt);
            }
        });

        comboFisico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboFisico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fisico");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Juridico");

        comboJuridico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboJuridico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        comboJuridico.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tipo Cliente");

        buttoAdicionarSabor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttoAdicionarSabor.setText("Adicionar");
        buttoAdicionarSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoAdicionarSaborActionPerformed(evt);
            }
        });

        buttoAdicionarTam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttoAdicionarTam.setText("Adicionar");
        buttoAdicionarTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoAdicionarTamActionPerformed(evt);
            }
        });

        buttonAdicionarBebida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonAdicionarBebida.setText("Adicionar");
        buttonAdicionarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarBebidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSair)
                        .addGap(248, 248, 248)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonSalva))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioFisico)
                        .addGap(18, 18, 18)
                        .addComponent(radioJuridico))
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttoAdicionarSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(comboFisico, 0, 174, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(comboJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(buttoAdicionarTam, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBebida, 0, 121, Short.MAX_VALUE)
                            .addComponent(buttonAdicionarBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioFisico)
                    .addComponent(radioJuridico)
                    .addComponent(comboFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(comboJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttoAdicionarSabor)
                    .addComponent(buttoAdicionarTam)
                    .addComponent(buttonAdicionarBebida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalva)
                    .addComponent(buttonSair))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void radioFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFisicoActionPerformed
        // TODO add your handling code here:
        if (radioFisico.isSelected()) {
            radioFisico.setSelected(false);
            radioJuridico.setSelected(true);
            comboFisico.setEnabled(false);
            comboJuridico.setEnabled(true);
        } else {
            radioFisico.setSelected(true);
            radioJuridico.setSelected(false);
            comboFisico.setEnabled(true);
            comboJuridico.setEnabled(false);
        }
    }//GEN-LAST:event_radioFisicoActionPerformed

    private void radioJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioJuridicoActionPerformed
        // TODO add your handling code here:
        if (radioJuridico.isSelected()) {
            radioJuridico.setSelected(false);
            radioFisico.setSelected(true);
            comboFisico.setEnabled(true);
            comboJuridico.setEnabled(false);
        } else {
            radioJuridico.setSelected(true);
            radioFisico.setSelected(false);
            comboFisico.setEnabled(false);
            comboJuridico.setEnabled(true);
        }
    }//GEN-LAST:event_radioJuridicoActionPerformed

    private void radioJuridicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioJuridicoMouseClicked
        if (radioJuridico.isSelected()) {
            radioJuridico.setSelected(false);
            radioFisico.setSelected(true);
            comboFisico.setEnabled(true);
            comboJuridico.setEnabled(false);
        } else {
            radioJuridico.setSelected(true);
            radioFisico.setSelected(false);
            comboFisico.setEnabled(false);
            comboJuridico.setEnabled(true);
        }
    }//GEN-LAST:event_radioJuridicoMouseClicked

    private void radioFisicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioFisicoMouseClicked
        // TODO add your handling code here:
        if (radioFisico.isSelected()) {
            radioFisico.setSelected(false);
            radioJuridico.setSelected(true);
            comboFisico.setEnabled(false);
            comboJuridico.setEnabled(true);
        } else {
            radioFisico.setSelected(true);
            radioJuridico.setSelected(false);
            comboFisico.setEnabled(true);
            comboJuridico.setEnabled(false);
        }
    }//GEN-LAST:event_radioFisicoMouseClicked

    private void buttoAdicionarSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoAdicionarSaborActionPerformed
        // TODO add your handling code here:
        String aux = comboTamanho.getSelectedItem().toString();
        int id = -1;
        for (int i = 0; i < listaTamanho.size(); i++) {
            if (aux.equals(listaTamanho.get(i).getTamanho())) {
                id = i;
            }
        }

        ((DefaultTableCellRenderer) tablePedido.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablePedido.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablePedido.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
        model.addRow(new Object[]{listaTamanho.get(id).getTamanho(), listaTamanho.get(id).getPreco()});
        total = total + listaTamanho.get(id).getPreco();
        textTotal.setText(String.valueOf(total));

    }//GEN-LAST:event_buttoAdicionarSaborActionPerformed

    private void buttoAdicionarTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoAdicionarTamActionPerformed
        // TODO add your handling code here:
        String aux = comboSabor.getSelectedItem().toString();
        int id = -1;
        for (int i = 0; i < listaSabor.size(); i++) {
            if (aux.equals(listaSabor.get(i).getNome())) {
                id = i;
            }
        }

        ((DefaultTableCellRenderer) tablePedido.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablePedido.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablePedido.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
        model.addRow(new Object[]{listaSabor.get(id).getNome(), "----"});


    }//GEN-LAST:event_buttoAdicionarTamActionPerformed

    private void buttonAdicionarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarBebidaActionPerformed
        // TODO add your handling code here:
        String aux = comboBebida.getSelectedItem().toString();
        int id = -1;
        for (int i = 0; i < listaBebida.size(); i++) {
            if (aux.equals(listaBebida.get(i).getNome())) {
                id = i;
            }
        }

        ((DefaultTableCellRenderer) tablePedido.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablePedido.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablePedido.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
        model.addRow(new Object[]{listaBebida.get(id).getNome(), listaBebida.get(id).getPreco()});
        total = total + listaBebida.get(id).getPreco();
        textTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_buttonAdicionarBebidaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IniciarPedido().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(IniciarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoAdicionarSabor;
    private javax.swing.JButton buttoAdicionarTam;
    private javax.swing.JButton buttonAdicionarBebida;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonSalva;
    private javax.swing.JComboBox<String> comboBebida;
    private javax.swing.JComboBox<String> comboFisico;
    private javax.swing.JComboBox<String> comboJuridico;
    private javax.swing.JComboBox<String> comboSabor;
    private javax.swing.JComboBox<String> comboTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioFisico;
    private javax.swing.JRadioButton radioJuridico;
    private javax.swing.JTable tablePedido;
    private javax.swing.JTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
