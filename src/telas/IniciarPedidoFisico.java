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
import modelos.Bebida;
import modelos.Fisica;
import modelos.Pedido;
import modelos.Pizza;
import modelos.Sabor;

public final class IniciarPedidoFisico extends javax.swing.JFrame {

    public ArrayList<Bebida> listaBebida = new ArrayList<>();
    public ArrayList<Sabor> listaSabor = new ArrayList<>();
    public ArrayList<Pizza> listaTamanho = new ArrayList<>();
    public ArrayList<Fisica> listaFisico = new ArrayList<>();
    ArrayList<Integer> idSabores = new ArrayList<>();
    public Pedido pedido = new Pedido();
    public double total = 0;
    public String sabores = "";
    public String mensagem = "";

    public IniciarPedidoFisico() throws SQLException {
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonSalva = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedido = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        comboTamanho = new javax.swing.JComboBox<>();
        comboSabor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBebida = new javax.swing.JComboBox<>();
        comboFisico = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        buttonSabor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Pedido");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Realizar Pedido");

        buttonSalva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSalva.setText("Salvar");
        buttonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvaActionPerformed(evt);
            }
        });

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
                "Descriçao"
            }
        ));
        jScrollPane1.setViewportView(tablePedido);

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

        comboFisico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboFisico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Cliente");

        buttonSabor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSabor.setText("Adicionar");
        buttonSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaborActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSair)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSalva))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(67, 67, 67)
                                .addComponent(comboSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSabor))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(62, 62, 62)
                                .addComponent(comboFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSabor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSair)
                    .addComponent(buttonSalva))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed

        this.dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaborActionPerformed
        // TODO add your handling code here:
        String aux = comboSabor.getSelectedItem().toString();
        sabores = sabores + aux + ",";
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
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
        model.addRow(new Object[]{listaSabor.get(id).getNome()});

        idSabores.add(listaSabor.get(id).getId());

    }//GEN-LAST:event_buttonSaborActionPerformed

    private void buttonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvaActionPerformed

        atualizaPedido();

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o pedido abaixo?\n\n" + mensagem, "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (pedido.insereFisico(pedido)) {
                JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir, verifique.");
            }

        }
    }//GEN-LAST:event_buttonSalvaActionPerformed

    private void atualizaPedido() {

        String aux = "";
        int id = -1;

        // pegando id do cliente
        aux = comboFisico.getSelectedItem().toString();
        for (int i = 0; i < listaFisico.size(); i++) {
            if (aux.equals(listaFisico.get(i).getNome())) {
                id = i;
            }
        }
        pedido.setNome_cliente(comboFisico.getSelectedItem().toString());
        pedido.setId_cliente(listaFisico.get(id).getId());

        // pegando id da pizza
        aux = comboTamanho.getSelectedItem().toString();
        for (int i = 0; i < listaTamanho.size(); i++) {
            if (aux.equals(listaTamanho.get(i).getTamanho())) {
                id = i;
            }
        }

        pedido.setId_pizza(listaTamanho.get(id).getId());
        total = total + listaTamanho.get(id).getPreco();

        // pegando id da bebida
        aux = comboBebida.getSelectedItem().toString();
        for (int i = 0; i < listaBebida.size(); i++) {
            if (aux.equals(listaBebida.get(i).getNome())) {
                id = i;

            }
        }
        pedido.setId_bebida(listaBebida.get(id).getId());
        total = total + listaBebida.get(id).getPreco();
        pedido.setIdSabores(idSabores);
        pedido.setValor(total);

        sabores = sabores.substring(0, sabores.length() - 1);
        mensagem = "Cliente: " + pedido.getNome_cliente();
        mensagem = mensagem + "\nTamanho: " + comboTamanho.getSelectedItem().toString();
        mensagem = mensagem + "\nBebida: " + comboBebida.getSelectedItem().toString();
        mensagem = mensagem + "\nSabores: " + sabores;
        mensagem = mensagem + "\nTotal: " + pedido.getValor();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IniciarPedidoFisico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(IniciarPedidoFisico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSabor;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonSalva;
    private javax.swing.JComboBox<String> comboBebida;
    private javax.swing.JComboBox<String> comboFisico;
    private javax.swing.JComboBox<String> comboSabor;
    private javax.swing.JComboBox<String> comboTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePedido;
    // End of variables declaration//GEN-END:variables

}
