package GUI;

public class Setting extends javax.swing.JFrame {

    public Setting() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btn_back.setBackground(new java.awt.Color(51, 0, 255));
        btn_back.setForeground(new java.awt.Color(255, 204, 0));
        btn_back.setText("BACK");
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Backword");

        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Left");

        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Right");

        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Forward");

        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Exit");

        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Rotate Right");

        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Rotate Left");

        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("W");

        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("S");

        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("A");

        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("F");

        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("Q");

        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("E");

        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("ESC");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/DiamondWarGuiHome.png")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel13))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel12))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel14))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(520, 520, 520)
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel15))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addComponent(jLabel9))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel5)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel10)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel13))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel12))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(380, 380, 380)
                                .addComponent(jLabel14))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(380, 380, 380)
                                .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(350, 350, 350)
                                .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(jLabel15))
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel9))
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
    }

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
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
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btn_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
}
