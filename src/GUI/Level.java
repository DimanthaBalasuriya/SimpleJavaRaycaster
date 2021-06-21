package GUI;

import Engine.Game;

public class Level extends javax.swing.JFrame {

    public Level() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lv2 = new javax.swing.JLabel();
        lv3 = new javax.swing.JLabel();
        lv4 = new javax.swing.JLabel();
        lv1 = new javax.swing.JLabel();
        lv7 = new javax.swing.JLabel();
        lv6 = new javax.swing.JLabel();
        lv5 = new javax.swing.JLabel();
        btn_back1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lv2.setForeground(new java.awt.Color(255, 204, 0));
        lv2.setText("FIND THE CARMAK WEAPON");
        lv2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv2MouseClicked(evt);
            }
        });

        lv3.setForeground(new java.awt.Color(255, 204, 0));
        lv3.setText("DESTROY LAB STRUCTURE");
        lv3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv3MouseClicked(evt);
            }
        });

        lv4.setForeground(new java.awt.Color(255, 204, 0));
        lv4.setText("FOREST TEMPLE SECRET");
        lv4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv4MouseClicked(evt);
            }
        });

        lv1.setForeground(new java.awt.Color(255, 204, 0));
        lv1.setText("GET TO THE LAB");
        lv1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv1MouseClicked(evt);
            }
        });

        lv7.setForeground(new java.awt.Color(255, 204, 0));
        lv7.setText("FINAL WAR");
        lv7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv7MouseClicked(evt);
            }
        });

        lv6.setForeground(new java.awt.Color(255, 204, 0));
        lv6.setText("GOLDEN FINIX");
        lv6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv6MouseClicked(evt);
            }
        });

        lv5.setForeground(new java.awt.Color(255, 204, 0));
        lv5.setText("RESCUE AMANDA");
        lv5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lv5MouseClicked(evt);
            }
        });

        btn_back1.setBackground(new java.awt.Color(51, 0, 255));
        btn_back1.setForeground(new java.awt.Color(255, 204, 0));
        btn_back1.setText("BACK");
        btn_back1.setBorder(null);
        btn_back1.setBorderPainted(false);
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/DiamondWarGuiHome.png"))); // NOI18N
        jLabel1.setText("Forward");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(520, 520, 520)
                                .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv6))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(lv5))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(lv7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addComponent(lv3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(lv1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(lv2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(lv4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(380, 380, 380)
                                .addComponent(lv6))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(350, 350, 350)
                                .addComponent(lv5))
                        .addComponent(jLabel1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void lv1MouseClicked(java.awt.event.MouseEvent evt) {
        Game game = new Game();
        this.dispose();
    }

    private void lv2MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void lv3MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void lv4MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void lv5MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void lv6MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void lv7MouseClicked(java.awt.event.MouseEvent evt) {

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Level().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btn_back1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lv1;
    private javax.swing.JLabel lv2;
    private javax.swing.JLabel lv3;
    private javax.swing.JLabel lv4;
    private javax.swing.JLabel lv5;
    private javax.swing.JLabel lv6;
    private javax.swing.JLabel lv7;
}
