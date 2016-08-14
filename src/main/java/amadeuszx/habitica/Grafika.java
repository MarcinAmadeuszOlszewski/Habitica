package amadeuszx.habitica;

import static amadeuszx.habitica.enumy.Czary.*;
import static amadeuszx.habitica.enumy.Czaty.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author MarcinAmadeuszOlszewski
 */
public class Grafika extends javax.swing.JFrame {

    public Grafika() {
        initComponents();
        setTitle("Habitica");
        String[] dane = Autoryzacja.dane();
        mechanik = new Mechanika(dane[0], dane[1]);
        if (wybranyCzat == null) {
            czatDruzynyActionPerformed(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        wynik = new javax.swing.JTextArea();
        wiadomosc = new javax.swing.JTextField();
        wyslijWiadomosc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        czatGildii = new javax.swing.JButton();
        czatDruzyny = new javax.swing.JButton();
        zdrowieDruzyny = new javax.swing.JButton();
        listaZadan = new javax.swing.JButton();
        plomienie = new javax.swing.JButton();
        manaRozdawanie = new javax.swing.JButton();
        leczenie = new javax.swing.JButton();
        napojLeczacy = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wynik.setColumns(20);
        wynik.setRows(5);
        jScrollPane1.setViewportView(wynik);

        wiadomosc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                wiadomoscKeyPressed(evt);
            }
        });

        wyslijWiadomosc.setText("wyslij");
        wyslijWiadomosc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyslijWiadomoscActionPerformed(evt);
            }
        });

        czatGildii.setText("Czat Gildii Poland");
        czatGildii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                czatGildiiActionPerformed(evt);
            }
        });

        czatDruzyny.setText("Czat drużyny");
        czatDruzyny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                czatDruzynyActionPerformed(evt);
            }
        });

        zdrowieDruzyny.setText("Zdrowie drużyny");
        zdrowieDruzyny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zdrowieDruzynyActionPerformed(evt);
            }
        });

        listaZadan.setText("Lista zadań");
        listaZadan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaZadanActionPerformed(evt);
            }
        });

        plomienie.setText("plomienie x10");
        plomienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plomienieActionPerformed(evt);
            }
        });

        manaRozdawanie.setText("rozdawanie many");
        manaRozdawanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manaRozdawanieActionPerformed(evt);
            }
        });

        leczenie.setText("leczenie wszystkich");
        leczenie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leczenieActionPerformed(evt);
            }
        });

        napojLeczacy.setText("Napój leczący");
        napojLeczacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                napojLeczacyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(czatDruzyny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(czatGildii, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(zdrowieDruzyny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listaZadan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plomienie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(manaRozdawanie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(leczenie, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(napojLeczacy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(czatDruzyny)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(czatGildii)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listaZadan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zdrowieDruzyny)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(napojLeczacy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plomienie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manaRozdawanie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leczenie))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wiadomosc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(wyslijWiadomosc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wiadomosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wyslijWiadomosc)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plomienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plomienieActionPerformed
        wyslijWiadomosc.setEnabled(false);
        wynik.setText(mechanik.fireballX10(FIREBALL.idCzaru()));
    }//GEN-LAST:event_plomienieActionPerformed

    private void leczenieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leczenieActionPerformed
        wyslijWiadomosc.setEnabled(false);
        wynik.setText(mechanik.dzialajZaklecia(BLESSING.idCzaru()));
    }//GEN-LAST:event_leczenieActionPerformed

    private void zdrowieDruzynyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zdrowieDruzynyActionPerformed
        wyslijWiadomosc.setEnabled(false);
        wynik.setText(mechanik.dzialajListaGraczy());
    }//GEN-LAST:event_zdrowieDruzynyActionPerformed

    private void listaZadanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaZadanActionPerformed
        wyslijWiadomosc.setEnabled(false);
        wynik.setText(mechanik.dzialajZadania());
    }//GEN-LAST:event_listaZadanActionPerformed

    private void manaRozdawanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manaRozdawanieActionPerformed
        wyslijWiadomosc.setEnabled(false);
        wynik.setText(mechanik.dzialajZaklecia(ETERYCZNY.idCzaru()));
    }//GEN-LAST:event_manaRozdawanieActionPerformed

    private void napojLeczacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_napojLeczacyActionPerformed
        wyslijWiadomosc.setEnabled(false);
        wynik.setText(mechanik.dzialajKupNapoj());
    }//GEN-LAST:event_napojLeczacyActionPerformed

    private void wyslijWiadomoscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyslijWiadomoscActionPerformed
        wyslijWiadomosc.setEnabled(true);
        if (!wiadomosc.getText().isEmpty()) {
            wynik.setText(mechanik.piszNaCzat(wiadomosc.getText(), wybranyCzat));
            wiadomosc.setText("");
        }
    }//GEN-LAST:event_wyslijWiadomoscActionPerformed

    private void czatDruzynyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_czatDruzynyActionPerformed
        wyslijWiadomosc.setEnabled(true);
        wybranyCzat = DRUZYNA.idCzatu();
        wynik.setText(mechanik.dzialajCzat(wybranyCzat));
    }//GEN-LAST:event_czatDruzynyActionPerformed

    private void czatGildiiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_czatGildiiActionPerformed
        wyslijWiadomosc.setEnabled(true);
        wybranyCzat = POLAND.idCzatu();
        wynik.setText(mechanik.dzialajCzat(wybranyCzat));
    }//GEN-LAST:event_czatGildiiActionPerformed

    private void wiadomoscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wiadomoscKeyPressed
        if (wyslijWiadomosc.isEnabled() && !wiadomosc.getText().isEmpty() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            wyslijWiadomoscActionPerformed(null);
        }
    }//GEN-LAST:event_wiadomoscKeyPressed

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
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Grafika().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton czatDruzyny;
    private javax.swing.JButton czatGildii;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton leczenie;
    private javax.swing.JButton listaZadan;
    private javax.swing.JButton manaRozdawanie;
    private javax.swing.JButton napojLeczacy;
    private javax.swing.JButton plomienie;
    private javax.swing.JTextField wiadomosc;
    private javax.swing.JTextArea wynik;
    private javax.swing.JButton wyslijWiadomosc;
    private javax.swing.JButton zdrowieDruzyny;
    // End of variables declaration//GEN-END:variables
    private final Mechanika mechanik;
    private String wybranyCzat;
}
