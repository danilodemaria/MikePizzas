package telas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import modelos.Bebida;
import modelos.Pedido;
import modelos.Pizza;
import modelos.Sabor;

public class ExibePedido extends javax.swing.JFrame {

    // Criando novo pedido
    public Pedido pedido = new Pedido();

    public ExibePedido(Pedido pedido) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        preencheInformacoes(pedido);
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

    private void preencheInformacoes(Pedido pedido) throws SQLException {
        // Preenchendo sabores do pedido
        String sabores = Sabor.buscaSabores(pedido.getIdSabores().get(0));
        for (int i = 1; i < pedido.getIdSabores().size(); i++) {
            sabores = sabores + " - " + Sabor.buscaSabores(pedido.getIdSabores().get(i));
        }
        // Setando nome do cliente
        labelCliente.setText(pedido.getNome_cliente());
        // Setando total do pedido
        labelTotal.setText(String.valueOf(pedido.getValor()));
        // Setando bebida do pedido
        labelBebida.setText(Bebida.buscaBebida(pedido));
        // Setando todos os sabores do pedido
        labelSabores.setText(sabores);
        // Setando tamanho da pizza
        labelTamanho.setText(Pizza.buscaPizzas(pedido));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelTamanho = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelBebida = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelSabores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Informaçoes do Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 39, -1, -1));

        labelCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCliente.setText("JOAO JOAO JOAO");
        getContentPane().add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 39, 129, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Total R$");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 158, -1, -1));

        labelTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal.setText("0,00");
        getContentPane().add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 158, 129, -1));

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 199, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tamanho:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 72, -1, -1));

        labelTamanho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTamanho.setText("TAMANHO");
        getContentPane().add(labelTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 72, 129, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Bebida:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 98, -1, -1));

        labelBebida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelBebida.setText("BEBIDA");
        getContentPane().add(labelBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 98, 129, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Sabores:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 125, -1, -1));

        labelSabores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelSabores.setText("SABORES");
        getContentPane().add(labelSabores, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 125, 339, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExibePedido().setVisible(true);
            }
        });
    }

    private ExibePedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelBebida;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelSabores;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JLabel labelTotal;
    // End of variables declaration//GEN-END:variables

}
