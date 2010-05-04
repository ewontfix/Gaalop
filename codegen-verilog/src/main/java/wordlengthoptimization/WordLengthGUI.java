/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WordLengthGUI.java
 *
 * Created on Mar 23, 2010, 10:04:21 AM
 */

package wordlengthoptimization;

import datapath.graph.ModlibWriter;

/**
 * Opens a gui and handles setting of parameter for wordlength optimization.
 *
 * @author fs
 */
public class WordLengthGUI extends javax.swing.JDialog {

    private Options options;

    /** Creates new form WordLengthGUI */
    public WordLengthGUI(java.awt.Frame parent, boolean modal, Options options) {
        super(parent, modal);
        this.options = options;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    optimizerComboBox = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    maxWordlengthField = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    minFraclengthField = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    pipelindedMulitplier = new javax.swing.JCheckBox();
    jLabel4 = new javax.swing.JLabel();
    monteCarloIters = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Wordlength Optimization");
    setAlwaysOnTop(true);
    setModal(true);
    setName("Optimization Parameters"); // NOI18N

    optimizerComboBox.setModel(new javax.swing.DefaultComboBoxModel(options.getPossibleOptimizers()));

    jLabel1.setText("Optimizer:");

    jLabel2.setText("Max. Wordlength:");

    maxWordlengthField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    maxWordlengthField.setText("64");

    jLabel3.setText("Min. Fractionlength:");

    minFraclengthField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    minFraclengthField.setText("0");

    jButton1.setText("Ready");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    pipelindedMulitplier.setText("Pipelined Multiplier");

    jLabel4.setText("Monte Carlo Iterations:");

    monteCarloIters.setText("100000");
    monteCarloIters.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        monteCarloItersActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel3)
                  .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButton1)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(monteCarloIters, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                          .addComponent(minFraclengthField, javax.swing.GroupLayout.Alignment.LEADING)
                          .addComponent(maxWordlengthField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(pipelindedMulitplier))))))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
        .addGap(20, 20, 20))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(40, 40, 40)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(maxWordlengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(pipelindedMulitplier))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(minFraclengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(monteCarloIters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
        .addComponent(jButton1)
        .addGap(41, 41, 41))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // TODO add your handling code here:
      options.setSelectedOptimizer((WordlengthOptimization) optimizerComboBox.getSelectedItem());

      options.setMinFractionlength((Integer.parseInt(minFraclengthField.getText())));
      options.setMaxWordlength((Integer.parseInt(maxWordlengthField.getText())));
      options.setMonteCarloIterations(Integer.parseInt(monteCarloIters.getText()));
      ModlibWriter.mul_pipe = pipelindedMulitplier.isSelected();
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void monteCarloItersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monteCarloItersActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_monteCarloItersActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WordLengthGUI dialog = new WordLengthGUI(new javax.swing.JFrame(), true, new Options());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JTextField maxWordlengthField;
  private javax.swing.JTextField minFraclengthField;
  private javax.swing.JTextField monteCarloIters;
  private javax.swing.JComboBox optimizerComboBox;
  private javax.swing.JCheckBox pipelindedMulitplier;
  // End of variables declaration//GEN-END:variables

}
