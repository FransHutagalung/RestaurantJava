/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelSystemAdmin;

import AdminSystem.KoneksiAdmin;
import raven.transitions.TransitionsForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Form5 extends TransitionsForm {

   public Statement stm ;
   public Connection con;
   public PreparedStatement prs ;
   public PreparedStatement prs1 ;
   public ResultSet rs ;
   public DefaultTableModel modelku = null ;
   public DefaultTableModel model2 = null ;
   public DefaultTableModel model3 = null ;
   public static   String wjk = "";
   public static String pil = "";
    public static String kopes = "";
     public static String namaPem = "";
      public static String totalHargaa = "";
      public static String penghapusan = "";
      public static boolean langsung = false ;
      String keseluruhan = "";
      String namaakhir= "";
    public Form5() {
        initComponents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();  
   tanggal.setText(dtf.format(now));
        KoneksiAdmin kon = new KoneksiAdmin();
        kon.Config();
        stm = kon.stm ;
        con = kon.con ;
        namaKoki.setEditable(false);
        kodepesanantxt.setEditable(false);
        namaKurir.setEditable(false);
        kodepes.setEditable(false);
        LoadTable1();
        LoadTable2();
         LoadTable3();
        
    }
     public void Gmail1( String kodePesanan , String nama ,String Harga , String Tertuju , String namaKurir , String nomorwaKurir)
    {
        String kode = "";
//        System.out.println("iya");
         String to = Tertuju;
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
            mime.setSubject("PENGIRIMAN PAKET MAKANAN");
            mime.setText("Hi.. " +nama +" Pesanan Anda Kode Pesanan ,  " +kodePesanan +" Telah Selesai Dibuat Pesanan Sedang Diantar Ke Alamat Tujuan ,  Siapkan uang Seharga Rp." +Harga  +" Kurir = " +namaKurir +" No Telp : "  +nomorwaKurir);
            Transport.send(mime);
            System.out.println("Pesan Terkirim");
            
        }
        catch(MessagingException e)
        {
            e.getMessage();
        }
        
    }
    
    void LoadTable1()
    {
        modelku = new DefaultTableModel();
     modelku.addColumn("idPesanan");
        modelku.addColumn("Nama Pembeli");
        modelku.addColumn("Pesanan");
        modelku.addColumn("Total Harga ");
        modelku.addColumn("Alamat Pemesanan");
        modelku.addColumn("Sub Total");
        modelku.addColumn("Total");
        
//        model.addColumn("Jumlah Pemesanan");
//        model.addColumn("Tanggal Transaksi");
        modelku.addColumn("No Telp");
//        s = "idPenjualan";
//        model.addColumn("Jenis Pangan");
//        model.addColumn("Status Peminjaman ");
        try{
            int no = 0 ;
            String sql = "select idPesanan , namaPembeli , Pesanan , totalHarga ,AlamatPengiriman , subTotal , totalBarang , noTelp from riwayatadmin where TanggalTransaksi = curdate() AND status ='NO' and kodekoki is null and kodepesanan is null order by idPesanan"  ;
            rs = stm.executeQuery(sql);  
            while(rs.next()){
                modelku.addRow(new Object[]{
//                    ++no ,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    "Rp." +rs.getString(4),
                    rs.getString(5),
//                    rs.getInt(5),
                    rs.getString(6),
                        rs.getString(7) ,
                         rs.getString(8),
                         
                
                });
            }
            tabel1.setModel(modelku);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    void LoadTable2()
    {
        model2 = new DefaultTableModel();
        model2.addColumn("Kode Pesanan");
        model2.addColumn("Kode Koki");
        model2.addColumn("Nama Pembeli");
        model2.addColumn("Pesanan");
        model2.addColumn("Total Harga");
        model2.addColumn("Alamat Pengiriman");
        model2.addColumn("Sub Total");
        model2.addColumn("Total Barang");  
        model2.addColumn("No telp ");
        
        
        try {
            String sqly = "select kodePesanan ,kodeKoki, namaPembeli , Pesanan , totalHarga ,AlamatPengiriman , subTotal , totalBarang , noTelp from riwayatadmin where TanggalTransaksi = curdate() AND status ='NO' AND kodePesanan is not null AND kodeKoki is not null";
            rs = stm.executeQuery(sqly);
            while(rs.next())
            {
                model2.addRow(new Object[]{
                rs.getString(1),
                     rs.getString(2),
                      rs.getString(3),
                       rs.getString(4),
                        rs.getString(5),
                         rs.getString(6),
                     rs.getString(7),
                      rs.getString(8),
                       rs.getString(9),
                });
            }
            tabel2.setModel(model2);
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
        }
    }
public void LoadTable3(){
   model3 = new DefaultTableModel();
   model3.addColumn("Kode Pesanan");
        model3.addColumn("Kode Koki");
        model3.addColumn("Kode Kurir");
        model3.addColumn("Nama Pembeli");
        model3.addColumn("Pesanan");
        model3.addColumn("Total Harga");
        model3.addColumn("Alamat Pengiriman");
        model3.addColumn("Sub Total");
        model3.addColumn("Total Barang");  
        model3.addColumn("No telp ");
        
    try {
       String sqly = "SELECT * FROM riwayatadmin WHERE kodePesanan is not null and kodeKoki is not null and kodeKurir is not null and status = 'NO'";
       rs = stm.executeQuery(sqly);
       while(rs.next()){
           model3.addRow(new Object []{
               rs.getString(12),
               rs.getString(7),
             rs.getString(8),
          rs.getString(2),
     rs.getString(3),
        rs.getString(5),
          rs.getString(6),
                       rs.getString(4),
                                      rs.getString(11)







           });
       }
       tabel3.setModel(model3);
    } catch (SQLException e)
    {
        System.out.println(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        kodepesanantxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namaKoki = new javax.swing.JTextField();
        kk1 = new javax.swing.JLabel();
        kodeKurir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        kodeKoki = new javax.swing.JTextField();
        kodepes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nk1 = new javax.swing.JLabel();
        namaKurir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setText("FORM Penyortingan");

        jButton1.setText("KE KOKI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("KE KURIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("KODE PESANAN");

        jLabel6.setText("NAMA KOKI");

        kk1.setText("KODE  KURIR");

        kodeKurir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodeKurirKeyPressed(evt);
            }
        });

        jLabel8.setText("KODE KOKI");

        kodeKoki.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodeKokiKeyPressed(evt);
            }
        });

        jLabel9.setText("KODE PESANAN");

        nk1.setText("NAMA KURIR");

        jLabel11.setText("TANGGAL");

        tanggal.setText("tanggal");

        tabel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabel2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tabel2);

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel1);

        jPanel1.setBackground(new java.awt.Color(226, 222, 131));

        jLabel2.setText("Pesanan Yang Sedang Dimasak");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\koki1.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(226, 222, 131));

        jLabel13.setText("Pesanan Dari Pelanggan");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\customer.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(226, 222, 131));

        jLabel15.setText("Pesanan Yang Sedang Diantar");

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\kurir.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabel3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel3);

        jButton3.setText("SELESAI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(226, 222, 131));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jButton5.setText("SEGARKAN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Hapus Data");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5)
                                        .addGap(13, 13, 13))))
                            .addComponent(jScrollPane3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(kodepes, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kk1)
                                    .addComponent(nk1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kodepesanantxt, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kodeKoki, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(namaKoki, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton1)
                                            .addComponent(jButton6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kodeKurir, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                            .addComponent(namaKurir))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))))
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(tanggal)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kodepesanantxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(kodeKoki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(namaKoki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(kodepes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(kk1)
                                            .addComponent(kodeKurir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(namaKurir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nk1)
                                            .addComponent(jButton2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(namaKoki.getText().equals(""))
{
    JOptionPane.showMessageDialog(this, "Field Koki Harus Diisi ");
} else {
        try {
    String sqly = "UPDATE riwayatadmin SET kodePesanan = ? , kodeKoki = ? WHERE idPesanan = ? ";
        prs = con.prepareStatement(sqly);
        prs.setString(1, kodepesanantxt.getText());
         prs.setString(2, kodeKoki.getText());
         
          prs.setString(3, (modelku.getValueAt(tabel1.getSelectedRow(), 0).toString()));
           prs.executeUpdate();
         
              JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
            model2.addRow(new Object [] {
                kodepesanantxt.getText(),
                kodeKoki.getText(),
                modelku.getValueAt(tabel1.getSelectedRow(), 1).toString(),
                 modelku.getValueAt(tabel1.getSelectedRow(), 2).toString(),
                   modelku.getValueAt(tabel1.getSelectedRow(), 3).toString(),
                     modelku.getValueAt(tabel1.getSelectedRow(), 4).toString(),
                       modelku.getValueAt(tabel1.getSelectedRow(), 5).toString(),
                         modelku.getValueAt(tabel1.getSelectedRow(), 6).toString(),
                           modelku.getValueAt(tabel1.getSelectedRow(), 7).toString(),
                 
            });
              modelku.removeRow(tabel1.getSelectedRow());
          
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
        }
//    try 
//    {
//        String sqly ="";
//    } catch (SQLException e)
//    {
//        JOptionPane.showMessageDialog(this, e.getMessage());
//    }
//        DefaultTableModel model2 = new DefaultTableModel();
//     model2.addColumn("Kode Pesanan");
        // TODO add your handling code here:
//        try {
//             String sqly = "select * from pegawai where IdPegawai = ? and Jabatan = Koki";
//             prs = con.prepareStatement(sqly);
//             prs.setString(1,kodeKoki.getText());
//             rs = prs.executeQuery();
//             while(rs.next())
//             {
//                 namaKoki.setText( rs.getString(1));
//             }
//        } catch (SQLException e)
//        {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
//if(namaKoki.getText().equals(""))
//{
//    JOptionPane.showMessageDialog(this, "Field Koki Harus Diisi ");
//}
}
kodepesanantxt.setText("");
kodeKoki.setText("");
namaKoki.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kodeKokiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeKokiKeyPressed
        // TODO add your handling code here:
            try {
             String sqly = "select NamaPegawai from pegawai where IdPegawai = ? and Jabatan = 'Koki'";
             prs = con.prepareStatement(sqly);
             prs.setString(1,kodeKoki.getText());
             rs = prs.executeQuery();
             while(rs.next())
             {
                 namaKoki.setText( rs.getString(1));
             }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_kodeKokiKeyPressed

    private void kodeKurirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeKurirKeyPressed
        // TODO add your handling code here:
        try 
        {
              String sqly = "select NamaPegawai from pegawai where IdPegawai = ? and Jabatan = 'Kurir'";
              prs = con.prepareStatement(sqly);
             prs.setString(1,kodeKurir.getText());
             rs = prs.executeQuery();
             while(rs.next())
             {
                 namaKurir.setText( rs.getString(1));
             }
              
        } catch (SQLException e)
        {
           JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_kodeKurirKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nama = "",namaku ="" ;
        if(langsung){
             String boy = model2.getValueAt(tabel2.getSelectedRow(), 4).toString();
  String haha = boy.substring(3);
        try {
      //   String sql = "UPDATE detailpenjualan SET status = 'YES'  WHERE namaPembeli = ? AND harga = ?";
         
          String sql1 = "UPDATE riwayatadmin SET status = 'YES', kodekurir = 'NOPE'  WHERE  kodePesanan = ? ";
    //     prs = con.prepareStatement(sql);
          prs1 = con.prepareStatement(sql1);
     //    prs.setString(1, namaakhir);
      //   prs.setString(2, keseluruhan);
          prs1.setString(1,  kodepes.getText());
        //    prs1.setString(2, haha);
         //  prs.executeUpdate();
            prs1.executeUpdate();
           
           JOptionPane.showMessageDialog(this, "Berhasil Update Data non Kurir");
           model2.removeRow(tabel2.getSelectedRow());
     } 
     catch (SQLException e)
     {
           JOptionPane.showMessageDialog(this, e.getMessage());
     }
             try {
         String sql = "UPDATE detailpenjualan SET status = 'YES'  WHERE namaPembeli = ? AND harga = ?";
         
         
         prs = con.prepareStatement(sql);
         
         prs.setString(1, namaakhir);
         prs.setString(2, keseluruhan);
         // prs1.setString(1, model2.getValueAt(tabel2.getSelectedRow(), 0).toString());
        //    prs1.setString(2, haha);
           prs.executeUpdate();
         //   prs1.executeUpdate();
           
         //  JOptionPane.showMessageDialog(this, "Berhasil Update Data non Kurir");
           model2.removeRow(tabel2.getSelectedRow());
     } 
     catch (SQLException e)
     {
           JOptionPane.showMessageDialog(this, e.getMessage());
     }
        
        langsung = false ;
        jButton2.setText("KE KURIR");
        } else {
      
        try {
            String s = "select gmail from pelanggan where NamaPelanggan ='" +wjk +"'";
          //  prs = con.prepareStatement(s);
          //  prs.setString(1, model3.getValueAt(tabel3.getSelectedRow(), 3).toString());
            rs = stm.executeQuery(s);
            while(rs.next()) {
                namaku = rs.getString("gmail");
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
         String namaKurirr ="" , noTelp ="" ;
         try {
             String s = "SELECT * FROM pegawai WHERE idPegawai = ? ";
             prs = con.prepareStatement(s);
             prs.setString(1, kodeKurir.getText());
             rs = prs.executeQuery();
             while(rs.next()){
                 namaKurirr = rs.getString("namaPegawai");
                 noTelp = rs.getString("noTelp");
                 
             }
         } catch (SQLException e)
         {
             
         }
         
  //  Gmail1( String kodePesanan , String nama ,String Harga , String Tertuju , String namaKurir , String nomorwaKurir)
   Gmail1(kopes ,wjk , pil
           , namaku , namaKurirr , noTelp );
        try {
            String sqly = "select namaPegawai ,noTelp from pegawai where idPegawai = ?";
            PreparedStatement stat = con.prepareStatement(sqly);
            stat.setString(1, kodeKurir.getText());
             rs = stat.executeQuery();
             while (rs.next()){
                 nama = rs.getString(sqly);
             }
        } catch (SQLException e){
            
        }
        if(kodepes.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Field Kode Harus Diisi ");
        }
        else  if(namaKurir.getText().equals(""))
        {
              JOptionPane.showMessageDialog(this, "Field Kurir Harus Diisi ");
        } else 
        {
            
        
        try 
        {
            String sqly = "UPDATE riwayatadmin set kodekurir = ? where kodepesanan = ? ";
            prs = con.prepareStatement(sqly);
            prs.setString(1, kodeKurir.getText());
            prs.setString(2, kodepes.getText());
            prs.executeUpdate();
            JOptionPane.showMessageDialog(this, "Berhasil Update Data with Kurir ");
            model3.addRow(new Object []{
                model2.getValueAt(tabel2.getSelectedRow(), 0),
                 model2.getValueAt(tabel2.getSelectedRow(), 1),
                 kodeKurir.getText(),
                  model2.getValueAt(tabel2.getSelectedRow(), 2),
                   model2.getValueAt(tabel2.getSelectedRow(), 3),
                    model2.getValueAt(tabel2.getSelectedRow(), 4),
                     model2.getValueAt(tabel2.getSelectedRow(), 5),
                      model2.getValueAt(tabel2.getSelectedRow(), 6),
                       model2.getValueAt(tabel2.getSelectedRow(), 7),
                        model2.getValueAt(tabel2.getSelectedRow(), 8),
            });
                    model2.removeRow(tabel2.getSelectedRow());
            
//   model3.addColumn("Kode Pesanan");
//        model3.addColumn("Kode Koki");
//        model3.addColumn("Kode Kurir");
//        model3.addColumn("Nama Pembeli");
//        model3.addColumn("Pesanan");
//        model3.addColumn("Total Harga");
//        model3.addColumn("Alamat Pengiriman");
//        model3.addColumn("Sub Total");
//        model3.addColumn("Total Barang");  
//        model3.addColumn("No telp ");
//              model2.addColumn("Kode Pesanan");
//        model2.addColumn("Kode Koki");
//        model2.addColumn("Nama Pembeli");
//        model2.addColumn("Pesanan");
//        model2.addColumn("Total Harga");
//        model2.addColumn("Alamat Pengiriman");
//        model2.addColumn("Sub Total");
//        model2.addColumn("Total Barang");  
//        model2.addColumn("No telp ");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        }
        } 
        kodepes.setText("");
          kodeKurir.setText("");
        namaKurir.setText("");
        kk1.setVisible(true);
        nk1.setVisible(true);
        kodeKurir.setVisible(true);
        namaKurir.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        // TODO add your handling code here:
       // try {
//       if(model)
               String s ="";
        String y ="";
        String kodeno = "";
        try 
        {
              s =  "select *from riwayatadmin ORDER BY kodePesanan DESC LIMIT 1";
              rs = stm.executeQuery(s);
              while(rs.next())
              {
                    String hasil = rs.getString("kodePesanan");
                    y = hasil.substring(0, 3);
                    System.out.println(y);
        
                    kodeno = hasil.substring(3, 6);
                    System.out.println(kodeno);
              }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        int k = Integer.parseInt(kodeno) + 1;
        String akh = y + String.valueOf(k);
        kodepesanantxt.setText(akh);
//        String sqly = "UPDATE riwayatadmin SET kodePesanan = ? , kodeKoki = ? WHERE idPesanan = ? ";
//        prs = con.prepareStatement(sqly);
//        prs.setString(1, kodepesanantxt.getText());
//         prs.setString(2, kodeKoki.getText());
//         
//          prs.setString(3, (model.getValueAt(tabel1.getSelectedRow(), 0).toString()));
//        } catch (SQLException e)
//        {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        
//        }
penghapusan = modelku.getValueAt(tabel1.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_tabel1MouseClicked

    private void tabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseClicked
        // TODO add your handling code here:
        if(model2.getValueAt(tabel2.getSelectedRow(), 5).toString().equals("RESTAURANT MONTAGNE BLUE")){
             kodepes.setText(model2.getValueAt(tabel2.getSelectedRow(), 0).toString());
            jButton2.setText("SELESAI");
            langsung = true ;
               kk1.setVisible(false);
        nk1.setVisible(false);
        kodeKurir.setVisible(false);
        namaKurir.setVisible(false);
        } else {
        kodepes.setText(model2.getValueAt(tabel2.getSelectedRow(), 0).toString());
           wjk = model2.getValueAt(tabel2.getSelectedRow(), 2).toString();
        pil = model2.getValueAt(tabel2.getSelectedRow(), 4).toString();
        kopes =  model2.getValueAt(tabel2.getSelectedRow(), 0).toString();
    //    JOptionPane.showConfirmDialog(this, wjk + pil + kopes);
        keseluruhan = model2.getValueAt(tabel2.getSelectedRow(), 4).toString().substring(3);
        namaakhir = model2.getValueAt(tabel2.getSelectedRow(), 2).toString();
    }
    }//GEN-LAST:event_tabel2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  String boy = model3.getValueAt(tabel3.getSelectedRow(), 5).toString();
  String haha = boy.substring(3);
        try {
         String sql = "UPDATE detailpenjualan SET status = 'YES' WHERE namaPembeli = ? AND harga = ?";
          String sql1 = "UPDATE riwayatadmin SET status = 'YES' WHERE namaPembeli = ? AND totalHarga = ?";
         prs = con.prepareStatement(sql);
          prs1 = con.prepareStatement(sql1);
         prs.setString(1, model3.getValueAt(tabel3.getSelectedRow(), 3).toString());
          prs1.setString(1, model3.getValueAt(tabel3.getSelectedRow(), 3).toString());
           prs.setString(2, haha);
            prs1.setString(2, haha);
           prs.executeUpdate();
            prs1.executeUpdate();
           
           JOptionPane.showMessageDialog(this, "Berhasil");
           model3.removeRow(tabel3.getSelectedRow());
     } 
     catch (SQLException e)
     {
           JOptionPane.showMessageDialog(this, e.getMessage());
     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel3MouseClicked
        // TODO add your handling code here:
//        wjk = model3.getValueAt(tabel3.getSelectedRow(), 3).toString();
//        pil = model3.getValueAt(tabel3.getSelectedRow(), 2).toString();
//        kopes =  model3.getValueAt(tabel3.getSelectedRow(), 0).toString();
//        JOptionPane.showConfirmDialog(this, wjk + pil + kopes);
        
              
                 totalHargaa =  model3.getValueAt(tabel3.getSelectedRow(), 5).toString();
    }//GEN-LAST:event_tabel3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        LoadTable1();
        LoadTable2();
       LoadTable3();
       kodepes.setText("");
       kodepesanantxt.setText("");
       kodeKoki.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            String s = "DELETE FROM riwayatadmin WHERE idPesanan = ?";
            prs = con.prepareStatement(s);
            prs.setString(1, penghapusan);
            prs.executeUpdate();
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Data ");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
          LoadTable1();
        LoadTable2();
       LoadTable3();
       kodepesanantxt.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel kk1;
    private javax.swing.JTextField kodeKoki;
    private javax.swing.JTextField kodeKurir;
    private javax.swing.JTextField kodepes;
    private javax.swing.JTextField kodepesanantxt;
    private javax.swing.JTextField namaKoki;
    private javax.swing.JTextField namaKurir;
    private javax.swing.JLabel nk1;
    private javax.swing.JTable tabel1;
    private javax.swing.JTable tabel2;
    private javax.swing.JTable tabel3;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
