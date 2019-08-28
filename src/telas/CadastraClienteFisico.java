
package telas;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelos.Fisica;

public class CadastraClienteFisico extends javax.swing.JFrame {

    MaskFormatter mascaracpf;
    public CadastraClienteFisico() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textRG = new javax.swing.JTextField();
        textCPF = new javax.swing.JTextField();
        textTelefone = new javax.swing.JTextField();
        textEndereco = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        buttonCadastra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente Físico");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Cliente Físico");

        jLabel2.setText("Nome");

        jLabel3.setText("Endereço");

        jLabel4.setText("Telefone");

        jLabel5.setText("CPF");

        jLabel6.setText("RG");

        textRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRGActionPerformed(evt);
            }
        });

        try{
            mascaracpf = new MaskFormatter("###.###.###-##");
            mascaracpf.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}

        textCPF  = new JFormattedTextField(mascaracpf);
        textCPF.setCaretPosition(0);
        textCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCPFActionPerformed(evt);
            }
        });

        textTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefoneActionPerformed(evt);
            }
        });

        textEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEnderecoActionPerformed(evt);
            }
        });

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        buttonCadastra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonCadastra.setText("Cadastrar");
        buttonCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(buttonCadastra))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textTelefone)
                                        .addComponent(textCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textRG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonCadastra)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastraActionPerformed
        // TODO add your handling code here:
        Fisica pessoa = new Fisica();
        boolean retorno = false;
        
        pessoa.setNome(textNome.getText().toUpperCase());
        pessoa.setEndereco(textEndereco.getText().toUpperCase());
        pessoa.setTelefone(textTelefone.getText());
        pessoa.setCpf(textCPF.getText());
        pessoa.setRg(textRG.getText());
        
        retorno = pessoa.Cadastra(pessoa);
        
        if(retorno){
            if (JOptionPane.showConfirmDialog(null, "Pessoa física cadastrada, inserir novamente?", "Aviso",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                limpaCampos();
            } else {
                this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Houve algum problema, verifique.");
        }
        
        
    }//GEN-LAST:event_buttonCadastraActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
        textEndereco.requestFocus();
    }//GEN-LAST:event_textNomeActionPerformed

    private void textEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEnderecoActionPerformed
        // TODO add your handling code here:
        textTelefone.requestFocus();
    }//GEN-LAST:event_textEnderecoActionPerformed

    private void textTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefoneActionPerformed
        // TODO add your handling code here:
        textCPF.requestFocus();
    }//GEN-LAST:event_textTelefoneActionPerformed

    private void textCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCPFActionPerformed
        // TODO add your handling code here:
        textRG.requestFocus();
    }//GEN-LAST:event_textCPFActionPerformed

    private void textRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRGActionPerformed
        // TODO add your handling code here:
        buttonCadastraActionPerformed(null);
    }//GEN-LAST:event_textRGActionPerformed

    public void limpaCampos(){
        textNome.setText(null);
        textCPF.setText(null);
        textRG.setText(null);
        textEndereco.setText(null);
        textTelefone.setText(null);
        textNome.requestFocus();
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastraClienteFisico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textEndereco;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textRG;
    private javax.swing.JTextField textTelefone;
    // End of variables declaration//GEN-END:variables

}
