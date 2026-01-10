
public class start extends javax.swing.JFrame {

    public start() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESS1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESS2.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        jLabel3.setText("CHOOSE A RESUME TEMPLATE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2021-07-09 at 12.54.35 PM.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new replace().setVisible(true);        
        this.setVisible(false);
        replace.location = replace.file_loc1;                
        replace.jTextArea1.setLineWrap(true);
        replace.jTextArea1.setWrapStyleWord(true);
        replace.jTextArea4.setLineWrap(true);
        replace.jTextArea4.setWrapStyleWord(true);
        replace.jTextArea5.setLineWrap(true);
        replace.jTextArea5.setWrapStyleWord(true);
        replace.jTextArea6.setLineWrap(true);
        replace.jTextArea6.setWrapStyleWord(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new replace().setVisible(true);        
        this.setVisible(false);
        replace.location = replace.file_loc2;         
        replace.jTextArea1.setLineWrap(true);
        replace.jTextArea1.setWrapStyleWord(true);
        replace.jTextArea4.setLineWrap(true);
        replace.jTextArea4.setWrapStyleWord(true);
        replace.jTextArea5.setLineWrap(true);
        replace.jTextArea5.setWrapStyleWord(true);
        replace.jTextArea6.setLineWrap(true);
        replace.jTextArea6.setWrapStyleWord(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
