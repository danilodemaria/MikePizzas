/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.Fisica;


public class RemoverFisico extends javax.swing.JFrame {

    public RemoverFisico() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        preencheTabela();
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

    private void preencheTabela() throws SQLException {
        ArrayList<Fisica> lista = new ArrayList<Fisica>();
        lista = Fisica.buscaFisico();

        ((DefaultTableCellRenderer) tabelaCliente.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaCliente.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabelaCliente.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabelaCliente.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabelaCliente.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabelaCliente.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tabelaCliente.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();

        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNome(),
                lista.get(i).getEndereco(), lista.get(i).getTelefone(), lista.get(i).getRg(),
                lista.get(i).getCpf()});
        }

        labelJuridico.setText(String.valueOf(lista.size()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelJuridico = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        buttonRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Clientes Fisicos");

        labelJuridico.setText("00");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Remover Cliente Físico");

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endereço", "Telefone", "RG", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);
        if (tabelaCliente.getColumnModel().getColumnCount() > 0) {
            tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(3);
            tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(40);
            tabelaCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        buttonRemover.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        jLabel2.setText("Clientes Cadastrados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(290, 290, 290))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRemover)
                .addGap(326, 326, 326))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelJuridico))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelJuridico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
        int column = 0;
        int row = tabelaCliente.getSelectedRow();
        Fisica pessoa = new Fisica();
        pessoa.setId(Integer.parseInt(tabelaCliente.getModel().getValueAt(row, 0).toString()));
        pessoa.setNome(tabelaCliente.getModel().getValueAt(row, 1).toString());
        pessoa.setEndereco(tabelaCliente.getModel().getValueAt(row, 2).toString());
        pessoa.setTelefone(tabelaCliente.getModel().getValueAt(row, 3).toString());
        pessoa.setRg(tabelaCliente.getModel().getValueAt(row, 4).toString());
        pessoa.setCpf(tabelaCliente.getModel().getValueAt(row, 5).toString());

        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o cliente: " + pessoa.getNome(), "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (pessoa.remover(pessoa)) {
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
                    model.setRowCount(0);
                    preencheTabela();
                    JOptionPane.showMessageDialog(null, "Pessoa fisica removida com sucesso!");
                } catch (SQLException ex) {
                    Logger.getLogger(RemoverBebida.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Houve um problema!");
            }
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RemoverFisico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RemoverFisico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelJuridico;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables
}
