/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.*;
import javax.mail.internet.*;
import javax.mail.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class DaftarPelanggan extends javax.swing.JFrame {
   int  counter = 60;
   boolean isIt = false ;
    String ak = "user";
   int nMata  = 2 ;
   public Statement stm ;
   public Connection con;
   public PreparedStatement prs ;
   public ResultSet rs ;
    public DaftarPelanggan() {
        initComponents();
    
        setLocationRelativeTo(null);
        scaleImage();
        keluarB();
        loginB();
//        defmata();
        defAkun();
        KoneksiAdmin kon = new KoneksiAdmin();
        kon.Config();
        stm = kon.stm;
        con = kon.con;
//          addPlaceHolder(nama);
//        addPlaceHolder(gmailku);
        isBenar.setVisible(false);
//        iyakah();
//        daftarya.setEnabled(false);
    }
    
        public void addPlaceHolder (JTextField text){
        Font font = text.getFont();
        font = font.deriveFont(Font.BOLD | Font.ITALIC);
        text.setFont(font);
        text.setForeground(Color.DARK_GRAY);
        
    }
      public void removePlaceHolder (JTextField text){
        Font font = text.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        text.setFont(font);
        text.setForeground(Color.black);
    }
    public void scaleImage()
    {
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\Koki.jpg");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        jLabel1.setIcon(baru);
        
    }
    void iyakah()
    {
         try{
     String sqly ="INSERT INTO pelanggan (NamaPelanggan , gmail , password ) VALUES ('oki' , 'dian' , 'haha')";
     
      stm.executeUpdate(sqly);
             System.out.println("Berhasil");
//     JOptionPane.showMessageDialog(this, "Akun Berhasil di daftar silahkan kembali login");
       
 } catch(SQLException e)
 {
     e.getMessage();
 }
    }
    
    public void Gmail1(String kodE)
    {
        String kode = "";
//        System.out.println("iya");
         String to = gmail2.getText();
        String from = "adhisetup@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        
        Session session = Session.getDefaultInstance(properties , new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("adhisetup@gmail.com" , "iporevvivndkxgzq");
            }
        });
        try 
        {
            MimeMessage mime =  new MimeMessage(session);
            mime.setFrom(new InternetAddress(from));
            mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mime.setSubject("VERIFIKASI AKUN");
            mime.setText("Hi.. " +nama2.getText() +" Silahkan Gunakan Kode " +kodE +" Untuk Membuka Aplikasi Kamu , Jangan Berikan Kode Ini Kepada Orang Lain"
                    + "Salam Sehat Restaurant Montagne Blue , Terimakasih Telah Bergabung dengan Kami");
            Transport.send(mime);
            System.out.println("Pesan Terkirim");
            
        }
        catch(MessagingException e)
        {
            e.getMessage();
        }
        
    }
    
    public void keluarB()
    {
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\keluar.jpg");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(keluar.getWidth(), keluar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        keluar.setIcon(baru);
    }
    
    public void loginB()
    {
//        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\login.png");
//        Image icon = img.getImage();
//        Image scale = icon.getScaledInstance(log.getWidth(), log.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon baru = new ImageIcon(scale);
//        log.setIcon(baru);
    }
    
//    public void defmata()
//    {
//        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\OneDrive\\Documents\\mata.png");
//        Image icon = img.getImage();
//        Image scale = icon.getScaledInstance(sandimata.getWidth(), sandimata.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon baru = new ImageIcon(scale);
//        sandimata.setIcon(baru);
//    }
    
    public void defAkun()
    {
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\akun2.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(akun.getWidth(), akun.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        akun.setIcon(baru);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        keluar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        akun = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kodeku = new javax.swing.JTextField();
        isBenar = new javax.swing.JLabel();
        myButton1 = new button.MyButton();
        KODEKU = new button.MyButton();
        daftarya = new button.MyButton();
        nama2 = new textfield.TextField();
        sandi = new textfield.PasswordField();
        gmail2 = new textfield.TextField();
        jLabel9 = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();

        jButton1.setText("LOGIN");

        jLabel3.setText("Lupa Kata Sandi Anda ? ");
        jLabel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel3FocusLost(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\Koki.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel7.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel7.setText("RESTAURANT");

        jLabel8.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        jLabel8.setText("MONTAGNE BLUE");

        jLabel5.setText("Makanan yang Lezat ");

        jLabel6.setText("Berasal dari Koki yang Tulus");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(jLabel6))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 510));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DAFTAR");

        keluar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\keluar.jpg")); // NOI18N
        keluar.setText("jLabel3");
        keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        akun.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\keluar.jpg")); // NOI18N
        akun.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel4.setText("<< KEMBALI KE MENU LOGIN");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Kode Verifikasi");

        kodeku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kodekuFocusGained(evt);
            }
        });
        kodeku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kodekuKeyTyped(evt);
            }
        });

        isBenar.setText("KODE VERIFIKASI BENAR !!");

        myButton1.setText("LOGIN");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        KODEKU.setText("KIRIM KODE");
        KODEKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KODEKUActionPerformed(evt);
            }
        });

        daftarya.setText("DAFTAR");
        daftarya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftaryaActionPerformed(evt);
            }
        });

        nama2.setLabelText("Masukkan Nama Pengguna");

        sandi.setLabelText("Masukkan Kata Sandi");
        sandi.setShowAndHide(true);

        gmail2.setLabelText("Masukkan Gmail Anda");

        jLabel9.setText("Kirim Ulang Kode dalam ");

        waktu.setText("60");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)
                                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isBenar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sandi, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(akun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(kodeku, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(KODEKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(waktu)))
                        .addGap(0, 84, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(daftarya, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(akun, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(nama2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sandi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KODEKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(waktu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isBenar)
                .addGap(37, 37, 37)
                .addComponent(daftarya, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 470, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_keluarMouseClicked

    private void jLabel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel3FocusGained
       jLabel3.setText("<HTML><u>Lupa Kata Sandi Anda?</u></HTML>");
    }//GEN-LAST:event_jLabel3FocusGained

    private void jLabel3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel3FocusLost
      jLabel3.setText("Lupa Kata Sandi Anda ?");
    }//GEN-LAST:event_jLabel3FocusLost

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setText("<HTML><u>Lupa Kata Sandi Anda?</u></HTML>");
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setText("Lupa Kata Sandi Anda ?");
    }//GEN-LAST:event_jLabel3MouseExited

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
       LoginPelanggan me = new LoginPelanggan();
       me.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void KODEKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KODEKUActionPerformed
    
  Random rd = new Random();
  String [] angka = new String[4];
  for(int i = 0 ; i < 4 ; i++)
  {
      int bebas ;
      bebas = rd.nextInt(10);
      angka[i] = String.valueOf(bebas) ;
  }
        String hasil = angka[0] +angka[1] + angka[2] + angka[3];
          ak = hasil ;
//        ak = hasil ;
//        System.out.println(hasil);
//        Gmail1(hasil);
         String kode = "";
//        System.out.println("iya");
System.out.println(gmail2.getText());
         String to = gmail2.getText();
        String from = "adhisetup@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        
        Session session = Session.getDefaultInstance(properties , new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("adhisetup@gmail.com" , "iporevvivndkxgzq");
            }
        });
//        adhihutagalung01@gmail.com
        try 
        {
            String pes1 = "Hi.. " +nama2.getText() +" Silahkan Gunakan Kode "  +hasil +" Untuk Membuka Aplikasi Kamu , Jangan Berikan Kode Ini Kepada Orang Lain";
            MimeMessage mime =  new MimeMessage(session);
            mime.setFrom(new InternetAddress(from));
            mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mime.setSubject("VERIFIKASI AKUN");
            mime.setText(pes1);
            Transport.send(mime);
            System.out.println("Pesan Terkirim");
            
        }
        catch(MessagingException e)
        {
            e.getMessage();
        }
//        int counter ;
//boolean isIt = false ;
KODEKU.setEnabled(false);
            Timer timer = new Timer(); //new timer
//        counter = 60; //setting the counter to 10 sec
        TimerTask task = new TimerTask() {         
            public void run() {                
                waktu.setText(Integer.toString(counter)); //the timer lable to counter.
                counter --;
                if (counter == -1){
                    timer.cancel(); 
                    KODEKU.setEnabled(true);
                } else if(isIt){
                    timer.cancel();
                    isIt = false;
                }
            }
        };
    timer.scheduleAtFixedRate(task, 1000, 1000); 
    }//GEN-LAST:event_KODEKUActionPerformed

    private void kodekuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodekuKeyTyped
        System.out.println("Kamu ngetik " +evt.getKeyChar());
        
        String sk2 = kodeku.getText() ;
        System.out.println(sk2);
//        ak = sk2;
        if(kodeku.getText().equals(ak))
        {
            isBenar.setVisible(true);
//            daftarya.setVisible(true);
        }
    }//GEN-LAST:event_kodekuKeyTyped

    private void kodekuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kodekuFocusGained
        String s = kodeku.getText();
        System.out.println(s);
    }//GEN-LAST:event_kodekuFocusGained

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton2ActionPerformed

    private void daftaryaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftaryaActionPerformed
if(!kodeku.getText().equals(ak))
{
    JOptionPane.showMessageDialog(this, "KODE VERIFIKASI ANDA SALAH SILAHKAN ULANGI ");
}
else 
 try{
     String sqly ="insert into pelanggan (NamaPelanggan,gmail,password) values ('" +nama2.getText() +"' , '" +gmail2.getText() +"' , '" +sandi.getText() +"')";
     System.out.println(sandi.getText());
      stm.executeUpdate(sqly);
      
     JOptionPane.showMessageDialog(this, "Akun Berhasil di daftar silahkan kembali login");
     
 } catch(SQLException e)
 {
     
 }
    }//GEN-LAST:event_daftaryaActionPerformed

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
            java.util.logging.Logger.getLogger(DaftarPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton KODEKU;
    private javax.swing.JLabel akun;
    private button.MyButton daftarya;
    private textfield.TextField gmail2;
    private javax.swing.JLabel isBenar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel keluar;
    private javax.swing.JTextField kodeku;
    private button.MyButton myButton1;
    private textfield.TextField nama2;
    private textfield.PasswordField sandi;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}
