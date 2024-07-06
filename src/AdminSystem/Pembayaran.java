/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminSystem;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.net.URI;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pembayaran extends javax.swing.JFrame {
public static Statement stm ;
public static Connection con ;
public static ResultSet rs ;
public static PreparedStatement prs ;
public static PreparedStatement prs1 ;
     
//    
//    List <String> daftarMakan ;
    String all = "";
    String ggl ="";
    public static String kecku = "";
    DefaultComboBoxModel model = null;
    public Pembayaran() {
        initComponents();
        setLocationRelativeTo(null);
           KoneksiAdmin kon = new KoneksiAdmin();

     
        kon.Config();
        peringatan2.setVisible(false);
        peringatan1.setVisible(false);
        menumakanan.setLineWrap(true);
         menumakanan.setWrapStyleWord(false);
        // menuharga.setLineWrap(true);
       //  menuharga.setWrapStyleWord(false);
        stm = kon.stm ;
        con = kon.con ;
        supera();
//        hargaSemua();
        defLurah();
//         List <String> daftarMakan  = menu.getList();
//         System.out.println(daftarMakan);
         Menu menu = new Menu();
//         int nk = menu.nTotal;
//         int kemas = 4000;
//         int ongkir = 6000;
//         
//         labelsubtotal.setText(String.valueOf(nk));
//         hargapengemasan.setText(String.valueOf(kemas));
//         hargaongkir.setText(String.valueOf(ongkir));
//         totaltxt.setText(all);
         
//         String hk = menu.semua;
//         menumakanan.append(hk);
      menumakanan.setText(menu.totalmenu.getText());
      
      menuharga.setText
        (menu.hargaaMakan.getText());
      qty.setText(menu.qty.getText());
      int barku = menu.nTotal ;
      labelsubtotal.setText(String.valueOf(barku));

        labelpengemasan.setVisible(false);
        labelongkir.setVisible(false);
        hargapengemasan.setVisible(false);
        hargaongkir.setVisible(false);     
        panelpembayaran.setVisible(false);
        alamatPrefix.setEditable(false);
        labelpem1.setVisible(false);
        labelpem2.setVisible(false);
        panelpembayaran.setVisible(false);
        alamatPrefix.setEditable(false);
        labelpem1.setVisible(false);
        labelpem2.setVisible(false);
//            getAll();
                  if(makanditempat.isSelected())
        {
            labelpem1.setVisible(true);
            labelpem2.setVisible(true);
            System.out.println("iya");
        }
                  if(makandirumah.isSelected())
                  {
                      System.out.println("kakka");
                  }
                  bbk();
//                  if(makanditempat2.isSelected())
//                  {
//                      System.out.println("hahha");
//                  }
        
    }
    

//    void hargaSemua()
//    {
//        Menu menu = new Menu();
//         String hk = menu.semua;
//         menumakanan.append(hk);
//    }
    void bbk()
    {
//        System.out.println("k");
    }
    public void getAll()
    {
        if(makanditempat.isSelected())
        {
            labelpem1.setVisible(true);
            labelpem2.setVisible(true);
        }
    }
    public void defLurah()
    {
        String [] Tuntungan = {
            "Namo Gajah" ,
"Simpang Selayang " ,
"Mangga" ,
"Sido Mulyo" ,
"Lau Cih" ,
"Tanjung Selamat" ,
"Baru Ladang Bambu" ,
"Kemenangan Tani" ,
"Simalingkar B"};
        String [] amplas = {

    "Amplas" , "Bangun Mulia" , "Harjosari I" , "Harjosari II", "Sitirejo II" , "Sitirejo III" , "Timbang Deli"

};
        String [] medanarea= {

    "Kotamatsum I" ,"Kotamatsum II" ,  "Kotamatsum IV" ,  "Tegal Sari I" ,  "Tegal Sari II" , "Tegal Sari III" , "Pandau Hulu II" , "Sei Rengas II" , "Sei Rengas Permata", "Pasar Merah Timur" , "Sukaramai I" , "Sukaramai II"

};
        
        String [] medanbarat = {

    "Glugur Kota" ,  "Karang Berombak" , "Kesawan" ,"Pulo Brayan Kota" , "Sei Agul" , "Silalas" };
        
        
        String [] medanbaru = { 	

    "Babura" ,"Darat" , "Merdeka" , "Padang Bulan" , " Petisah Hulu" , " Titi Rantai"

};
        
        String [] medanbelawan = {

    "Bagan Deli" ,  "Belawan Bahagia" , "Belawan Bahari" ,  "Belawan Sicanang" , "Belawan I" ,  "Belawan II"

};
        String [] medandeli = { 	

    "Kota Bangun" ,  "Mabar "  , "Mabar Hilir" , "Tanjung Mulia"  , "Tanjung Muli Hilir " ,"Titi Papan"

};
        String [] medandenai = {

    "Binjai" ,"Denai"  , "Medan Tenggara" ,  "Tegalsari Mandala I" , "Tegalsari Mandala II" , "Tegalsari Mandala III"

};
        
        String [] medanhelvetia = { 	

    "Cinta Damai" ,  "Dwikora" ,  "Helvetia" ,  "Helvetia Tengah",  "Helvetia Timur" ,  "Sei Sikambing C II" ,  "Tanjung Gusta"

};
        String [] medanjohor = {

    "Gedung Johor" , "Kedai Durian" , "Kwala Bekala" , "Pangkalan Masyhur" , "Sukamaju" ,  "Titi Kuning"

};

        String [] medankota ={

    "Kotamatsum III" , "Mesjid" ,  "Pandau Hulu I"  , "Pasar Baru" ,  "Pasar Merah Barat" , "Pusat Pasar" , "Sei Rengas I" , "Sitirejo I" , "Sudirejo I" ,"Sudirejo II" ,"Teladan Barat", "Teladan Timur"

};

String [] medanlabuhan = {

    "Besar" , "Martubung" ,  "Nelayan Indah" ,"Pekan Labuhan" ,  "Sei Mati" , "Tangkahan"

};

String [] medanmaimun = { 	

    "Aur" ,  "Hamdan", "Jati" ,"Kampung Baru" ,"Sei Mati" , "Sukaraja"

};
 String [] medanmarelan = {

    "Labuhan Deli", "Paya Pasir" ,"Rengas Pulau" ,"Tanah Enam Ratus" ,"Terjun"

};
 String [] medanperjuangan = {

    "Tegal Rejo" , "Sidorame Barat I" , "Sidorame Barat II" , "Sidorame Timur" ,"Sei Kera Hilir I" ,"Sei Kera Hilir II" ,"Sei Kera Hulu Pahlawan", "Pandau Hilir"
         

};
 String [] medanpetisah = {

    "Petisah Tengah" , "Sei Putih Barat" , "Sei Putih Tengah" ,"Sei Putih Timur I", "Sei Putih Timur II", "Sei Sikambing D", "Sekip"

};
 
 String [] medanpolonia = { 	

    "Anggrung" , "Madras Hulu" , "Polonia" , "Sari Rejo" ,"Suka Damai"

};
 
String [] medansunggal = { 	

    "Babura Sunggal" ,"Lalang" , "Sei" , "Sikambing B" , "Simpang Tanjung" , "Sunggal" ,  "Tanjung Rejo"

};

String [] medanselayang = {

    "Asam Kumbang" ,"Beringin" , "Padang Bulan Selayang I" , "Padang Bulan Selayang II" , "Sempakata" , "Tanjung Sari"

};

String [] medantimur = { 	

    "Durian" , "Gaharu" , "Gang Buntu" , "Glugur Darat I" , "Glugur Darat II" , "Perintis"  ,"Pulo Brayan Bengkel", "Pulo Brayan Bengkel Baru" , "Pulo Brayan Darat I" ,"Pulo Brayan Darat II", "Sidodadi"

};

String [] medantembung = {

    "Bandar Selamat" , "Bantan" , "Bantan Timur" , "Indra Kasih" , "Sidorejo" ,"Sidorejo Hilir" , "Tembung"

};








//        model = new DefaultComboBoxModel();
        String sk = kecamatan.getSelectedItem().toString();
        if(kecamatan.getSelectedItem().toString().equals("Medan Tuntungan"))
        {
             kecku = "Medan Tuntungan ";
             def1(Tuntungan);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Amplas"))
        {
             kecku = "Medan Amplas";
             def1(amplas);
        }
         else if(kecamatan.getSelectedItem().toString().equals("Medan Johor"))
        {
             kecku = "Medan Johor";
             def1(medanjohor);
        }
         else if(kecamatan.getSelectedItem().toString().equals("Medan Denai"))
        {
             kecku = "Medan Denai";
             def1(medandenai);
        } else if(kecamatan.getSelectedItem().toString().equals("Medan Area"))
        {
             kecku = "Medan Area";
             def1(medanarea);
        }  else if(kecamatan.getSelectedItem().toString().equals("Medan Kota"))
        {
             kecku = "Medan Kota";
             def1(medankota);
        }  else if(kecamatan.getSelectedItem().toString().equals("Medan Maimun"))
        {
             kecku = "Medan Maimun";
             def1(medanmaimun);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Polonia"))
        {
             kecku = "Medan Polonia";
             def1(medanmaimun);
        }else if(kecamatan.getSelectedItem().toString().equals("Medan Polonia"))
        {
             kecku = "Medan Polonia";
             def1(medanpolonia);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Baru"))
        {
             kecku = "Medan Baru";
             def1(medanbaru);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Selayang"))
        {
             kecku = "Medan Selayang";
             def1(medanselayang);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Sunggal"))
        {
             kecku = "Medan Sunggal";
             def1(medansunggal);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Helvetia"))
        {
             kecku = "Medan Helvetia";
             def1(medanhelvetia);
        } else if(kecamatan.getSelectedItem().toString().equals("Medan Petisah"))
        {
             kecku = "Medan Petisah";
             def1(medanpetisah);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Barat"))
        {
             kecku = "Medan Barat";
             def1(medanbarat);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Timur"))
        {
             kecku = "Medan Maimun";
             def1(medantimur);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Perjuangan"))
        {
             kecku = "Medan Perjuangan";
             def1(medanperjuangan);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Tembung"))
        {
             kecku = "Medan Tembung";
             def1(medantembung);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Deli"))
        {
             kecku = "Medan Deli";
             def1(medandeli);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Labuhan"))
        {
             kecku = "Medan Labuhan";
             def1(medanlabuhan);
        }    else if(kecamatan.getSelectedItem().toString().equals("Medan Marelan"))
        {
             kecku = "Medan Marelan";
             def1(medanmarelan);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Belawan"))
        {
             kecku = "Medan Belawan";
             def1(medanbelawan);
        }
        
        
    }
        public void supera()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\lokasi.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(gugel.getWidth(), gugel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        gugel.setIcon(baru);
    
    }
    public void def1( String [] kecamatan)
    {
//            
            
            model = new DefaultComboBoxModel(kecamatan);
            
            kelurahan.removeAllItems();
            kelurahan.setModel(model);
            
//            
//            String sk2 = kelurahan.getSelectedItem().toString();
//            alamatPrefix.append("Kec. " +kecku );
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonKuning1 = new radio_button.ButtonKuning();
        buttonKuning2 = new radio_button.ButtonKuning();
        jLabel10 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelpengemasan = new javax.swing.JLabel();
        labelongkir = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel9 = new javax.swing.JLabel();
        hargapengemasan = new javax.swing.JLabel();
        hargaongkir = new javax.swing.JLabel();
        labelsubtotal = new javax.swing.JLabel();
        totaltxt = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        myButton2 = new button.MyButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        qty = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        makanditempat = new javax.swing.JRadioButton();
        makandirumah = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        gugel = new javax.swing.JLabel();
        labelpem1 = new javax.swing.JLabel();
        labelpem2 = new javax.swing.JLabel();
        panelpembayaran = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        noPembayaran = new textfield.TextField();
        jLabel2 = new javax.swing.JLabel();
        noTelpon = new textfield.TextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatPrefix = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        peringatan2 = new javax.swing.JLabel();
        cod = new javax.swing.JRadioButton();
        bri = new javax.swing.JRadioButton();
        bca = new javax.swing.JRadioButton();
        dana = new javax.swing.JRadioButton();
        ovo = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        peringatan1 = new javax.swing.JLabel();
        kecamatan = new javax.swing.JComboBox<>();
        kelurahan = new javax.swing.JComboBox<>();
        myButton1 = new button.MyButton();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("TOTAL PESANAN ANDA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 11, -1, -1));

        jLabel6.setText("SUBTOTAL       Rp.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 449, -1, -1));

        labelpengemasan.setText("PENGEMASAN        Rp.");
        jPanel1.add(labelpengemasan, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 476, -1, -1));

        labelongkir.setText("ONGKOS KIRIM         Rp.");
        jPanel1.add(labelongkir, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 501, -1, -1));

        menumakanan.setColumns(20);
        menumakanan.setRows(5);
        jScrollPane3.setViewportView(menumakanan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 150, 388));

        jLabel9.setText("TOTAL        Rp.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 533, -1, -1));

        hargapengemasan.setText("0");
        jPanel1.add(hargapengemasan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 476, 77, -1));

        hargaongkir.setText("0");
        jPanel1.add(hargaongkir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 501, -1, -1));

        labelsubtotal.setText("0");
        jPanel1.add(labelsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 449, -1, -1));

        totaltxt.setText("0");
        jPanel1.add(totaltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 533, 60, -1));

        menuharga.setColumns(20);
        menuharga.setRows(5);
        jScrollPane4.setViewportView(menuharga);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 80, 390));

        myButton2.setText("< MENU UTAMA");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        qty.setColumns(20);
        qty.setRows(5);
        jScrollPane5.setViewportView(qty);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 30, 390));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\iconbank.png")); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 20, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\iconbank.png")); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 20, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\iconbank.png")); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 20, 20));

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));

        jLabel11.setText("TAHAP AKHIR PEMESANAN");

        buttonGroup1.add(makanditempat);
        makanditempat.setText("makan di tempat");
        makanditempat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makanditempatActionPerformed(evt);
            }
        });

        buttonGroup1.add(makandirumah);
        makandirumah.setText("makan di rumah");
        makandirumah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makandirumahActionPerformed(evt);
            }
        });

        jLabel7.setText("BUKA GOOGLE MAP ?");

        gugel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gugelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(makanditempat)
                        .addGap(18, 18, 18)
                        .addComponent(makandirumah)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gugel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gugel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makanditempat)
                            .addComponent(makandirumah)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelpem1.setText("Silahkan Kunjungi Restoran Kami di Jalan.Muara Takus No.48B , Samping Sun Plaza Medan");

        labelpem2.setText("Makanan Akan Langsung Disiapkan 10 Menit Setelah Submit ");

        panelpembayaran.setBackground(new java.awt.Color(255, 255, 255));
        panelpembayaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("METODE PEMBAYARAN :");
        panelpembayaran.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 354, -1, 30));

        alamat.setColumns(20);
        alamat.setRows(5);
        alamat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alamatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                alamatMousePressed(evt);
            }
        });
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alamatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alamatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamatKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(alamat);

        panelpembayaran.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 157, 360, 45));

        noPembayaran.setLabelText("Masukkan Nomor Pembayaran");
        panelpembayaran.add(noPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 202, -1));

        jLabel2.setText("Pilih  Kecamatan:");
        panelpembayaran.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, -1));

        noTelpon.setLabelText("Nomor Telepon Yang Bisa Dihubungi :");
        noTelpon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noTelponKeyPressed(evt);
            }
        });
        panelpembayaran.add(noTelpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 211, -1));

        jLabel3.setText("Pilih Kelurahan :");
        panelpembayaran.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, -1, -1));

        alamatPrefix.setColumns(20);
        alamatPrefix.setRows(5);
        alamatPrefix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alamatPrefixMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(alamatPrefix);

        panelpembayaran.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 204, 361, 90));

        jLabel4.setText("Alamat Tujuan :");
        panelpembayaran.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 132, -1, -1));

        peringatan2.setBackground(new java.awt.Color(255, 0, 51));
        peringatan2.setForeground(new java.awt.Color(255, 0, 51));
        peringatan2.setText("SILAHKAN ISI FIELD INI  !!");
        panelpembayaran.add(peringatan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        cod.setText("Cash On Delivery");
        panelpembayaran.add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        bri.setText("BRI");
        panelpembayaran.add(bri, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        bca.setText("BCA");
        panelpembayaran.add(bca, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        dana.setText("DANA");
        panelpembayaran.add(dana, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        ovo.setText("OVO");
        panelpembayaran.add(ovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\iconbank.png")); // NOI18N
        panelpembayaran.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 20, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\telpon.png")); // NOI18N
        panelpembayaran.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        peringatan1.setBackground(new java.awt.Color(255, 0, 51));
        peringatan1.setForeground(new java.awt.Color(255, 0, 51));
        peringatan1.setText("SILAHKAN ISI FIELD INI  !!");
        panelpembayaran.add(peringatan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        kecamatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medan Denai", "Medan Maimun", "Medan Baru", "Medan Permai", "Medan Tuntungan", "Medan Amplas ", "Medan Johor", "Medan Kota", "Medan Selayang", "Medan Denai", "Medan Helvetia", "Medan Petisah", "Medan Barat", "Medan Timur", "Medan Perjuangan", "Medan Deli", "Medan Labuhan" }));
        panelpembayaran.add(kecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        panelpembayaran.add(kelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 210, -1));

        myButton1.setText("SUBMIT");
        myButton1.setRadius(34);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelpem1)
                                    .addComponent(labelpem2))
                                .addGap(0, 109, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelpembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelpem1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelpem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelpembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makandirumahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makandirumahActionPerformed
        // TODO add your handling code here:
        labelpem1.setVisible(false);
         labelpem2.setVisible(true);
       
//        String namaPembayaran = "";
//        if(cod.isSelected())
//        {
//            namaPembayaran = "COD";
//        } else  if(bca.isSelected())
//        {
//            namaPembayaran = "BCA";
//        }
//        else if(bri.isSelected())
//        {
//            namaPembayaran = "BRI";
//        }
//         else if(cod.isSelected())
//        {

//            namaPembayaran = "DANA";
//        }
//         else if(cod.isSelected())
//        {
//            namaPembayaran = "COD";
//        }
//        
//        labelpem1.setVisible(false);
//        labelpem2.setVisible(false);
        panelpembayaran.setVisible(true);
//          int nk = menu.nTotal;
//          
//           totaltxt.setText(String.valueOf(nk));
//           labelsubtotal.setText(String.valueOf(nk));
          labelpengemasan.setVisible(true);
        labelongkir.setVisible(true);
        hargapengemasan.setVisible(true);
        hargaongkir.setVisible(true);
        Menu menu = new Menu();
         int nk = menu.nTotal;
         int kemas = 4000;
         hargapengemasan.setText(String.valueOf(kemas));
         int ongkir = 6000;
         hargaongkir.setText(String.valueOf(ongkir));
         int total = nk + kemas + ongkir ;
         totaltxt.setText(String.valueOf(total));
//          LoginAdmin log = new LoginAdmin();
//        String usn = log.namaAkhir;
//         
//         labelsubtotal.setText(String.valueOf(nk));
//         hargapengemasan.setText(String.valueOf(kemas));
//         hargaongkir.setText(String.valueOf(ongkir));
//         totaltxt.setText(String.valueOf(total));
//         
//         try {
//             String sqly = "INSERT INTO detailpenjualan(tanggalTransaksi ,namaPembeli , harga , NamaMakanan , AlamatTertuju , noTelp ,jenisPembayaran , banyakBarang) VALUES (  curdate() ,? , ? , ? ,? ,? ,? , ?)";
//             prs = con.prepareStatement(sqly);
//             
//         }
//         catch (SQLException e)
//         {
//             
//         }
        
    }//GEN-LAST:event_makandirumahActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed


        // TODO add your handling code here:
        LoginPelanggan log = new LoginPelanggan();
        String usn = log.namaAkhir;
        Menu menu = new Menu();
        int nbar = menu.nBarang ;
         int nk = menu.nTotal;
         if(makandirumah.isSelected()){
        String namaPembayaran = "";
        if(cod.isSelected())
        {
            namaPembayaran = "COD";
        } else  if(bca.isSelected())
        {
            namaPembayaran = "BCA";
        }
        else if(bri.isSelected())
        {
            namaPembayaran = "BRI";
        }
         else if(cod.isSelected())
        {
            namaPembayaran = "DANA";
        }
         else if(cod.isSelected())
        {
            namaPembayaran = "COD";
        }   else if(ovo.isSelected())
        {
            namaPembayaran = "OVO";
        }
//        if(noTelpon.getText().equals(""))
//        {
//            peringatan.setVisible(true);
//        }
            labelpem1.setVisible(false);
        labelpem2.setVisible(false);
//        panelpembayaran.setVisible(true);
          labelpengemasan.setVisible(true);
        labelongkir.setVisible(true);
        hargapengemasan.setVisible(true);
        hargapengemasan.setText("Rp.4.000");
        hargaongkir.setVisible(true);
        hargaongkir.setText("Rp.5.0000");
//        Menu menu = new Menu();
//         int nk = menu.nTotal;
         int kemas = 4000;
         int ongkir = 5000;
         int total = nk + kemas + ongkir ;
//          LoginAdmin log = new LoginAdmin();
//        String usn = log.namaAkhir;
         
         labelsubtotal.setText(String.valueOf(nk));
         hargapengemasan.setText(String.valueOf(kemas));
         hargaongkir.setText(String.valueOf(ongkir));
         totaltxt.setText(String.valueOf(total));
           if(noTelpon.getText().equals("") )
        {
            peringatan2.setVisible(true);
        } else if(noPembayaran.getText().equals("")){
            peringatan1.setVisible(true);
        }
           else {
               
           
         try {
             String sqly = "INSERT INTO riwayatadmin (namaPembeli , totalHarga , Pesanan , AlamatPengiriman , noTelp ,jenisPembayaran , totalBarang, subTotal  , tanggalTransaksi  , status) VALUES (?,?,?,?,?,?,?,? , CURDATE() , 'NO')";
            PreparedStatement prs1 = con.prepareStatement(sqly);
             
             prs1.setString(1, usn);
              prs1.setInt(2, nk);
               prs1.setString(3, menumakanan.getText());
                 prs1.setString(4, alamatPrefix.getText());
                   prs1.setString(5, noTelpon.getText());
                    prs1.setString(6, namaPembayaran);
                     prs1.setInt(7, nbar);
                  prs1.setString(8, qty.getText());
//                     prs.setString(8, "curdate");
           prs1.executeUpdate();
            
             String sql = "INSERT INTO detailpenjualan (namaPembeli , NamaMakanan ,banyakBarang , harga , AlamatTertuju , tanggalTransaksi , status ) values (?,?,?,?,?, curdate(), 'NO') ";
             prs= con.prepareStatement(sql);
             prs.setString(1, usn);
             prs.setString(2,  menumakanan.getText());
             prs.setInt(3, nbar);
             prs.setInt(4, nk);
             prs.setString(5, alamatPrefix.getText());
             prs.executeUpdate();
             JOptionPane.showMessageDialog(this,"Terimakasih silahkan Tunggu Pesanan Anda ");
         }
         catch (SQLException e)
         {
                    JOptionPane.showMessageDialog(this,"Kesalahan di sini" + e.getMessage());
         }
           }
        } 
         else   if(makanditempat.isSelected()){
             try {
                 
                 String sqly = "INSERT INTO riwayatadmin (namaPembeli , totalharga , Pesanan , AlamatPengiriman ,  totalBarang,subTotal , tanggalTransaksi , status) VALUES (?,?,?,?,?,? , curdate() , 'NO') ";
                 prs = con.prepareStatement(sqly);
                 prs.setString(1, usn);
                  prs.setInt(2, nk);
                   prs.setString(3, menumakanan.getText());
                    prs.setString(4, "RESTAURANT MONTAGNE BLUE");
                     prs.setInt(5, nbar);
                     prs.setString(6, qty.getText());
                  prs.executeUpdate();
                    String sql = "INSERT INTO detailpenjualan (namaPembeli , NamaMakanan ,banyakBarang , harga , AlamatTertuju , tanggalTransaksi , status ) values (?,?,?,?,?, curdate(), 'NO') ";
             prs1 = con.prepareStatement(sql);
                    prs1.setString(1, usn);
             prs1.setString(2,  menumakanan.getText());
             prs1.setInt(3, nbar);
             prs1.setInt(4, nk);
             prs1.setString(5, "RESTAURANT MONTAGNE BLUE");
//             prs.setString(5, alamatPrefix.getText());
             prs1.executeUpdate();
                   
              
                      JOptionPane.showMessageDialog(this,"Terimakasih silahkan datang ke restaurant kami");
                   
             } catch(SQLException e)
             {
                   JOptionPane.showMessageDialog(this,"Kesalahan" + e.getMessage());
             }
         }
         else {
             JOptionPane.showMessageDialog(this, "SILAHKAN PILIH SALAH SATU METODE PEMBAYARAN");
         }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void makanditempatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makanditempatActionPerformed
        // TODO add your handling code here:
        labelpem1.setVisible(true);
        labelpem2.setVisible(true);
        panelpembayaran.setVisible(false);
             labelpengemasan.setVisible(false);
        labelongkir.setVisible(false);
        hargapengemasan.setVisible(false);
        hargaongkir.setVisible(false); 
        
          Menu menu = new Menu();
           int nk = menu.nTotal;
          
           totaltxt.setText(String.valueOf(nk));
           labelsubtotal.setText(String.valueOf(nk));
//        kecamatan.set
//        kelurahan.setEditable(false);
//        alamat.setEditable(false);
    }//GEN-LAST:event_makanditempatActionPerformed

    private void kecamatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kecamatanActionPerformed
         String [] Tuntungan = {
            "Namo Gajah" ,
"Simpang Selayang " ,
"Mangga" ,
"Sido Mulyo" ,
"Lau Cih" ,
"Tanjung Selamat" ,
"Baru Ladang Bambu" ,
"Kemenangan Tani" ,
"Simalingkar B"};
        String [] amplas = {

    "Amplas" , "Bangun Mulia" , "Harjosari I" , "Harjosari II", "Sitirejo II" , "Sitirejo III" , "Timbang Deli"

};
        String [] medanarea= {

    "Kotamatsum I" ,"Kotamatsum II" ,  "Kotamatsum IV" ,  "Tegal Sari I" ,  "Tegal Sari II" , "Tegal Sari III" , "Pandau Hulu II" , "Sei Rengas II" , "Sei Rengas Permata", "Pasar Merah Timur" , "Sukaramai I" , "Sukaramai II"

};
        
        String [] medanbarat = {

    "Glugur Kota" ,  "Karang Berombak" , "Kesawan" ,"Pulo Brayan Kota" , "Sei Agul" , "Silalas" };
        
        
        String [] medanbaru = { 	

    "Babura" ,"Darat" , "Merdeka" , "Padang Bulan" , " Petisah Hulu" , " Titi Rantai"

};
        
        String [] medanbelawan = {

    "Bagan Deli" ,  "Belawan Bahagia" , "Belawan Bahari" ,  "Belawan Sicanang" , "Belawan I" ,  "Belawan II"

};
        String [] medandeli = { 	

    "Kota Bangun" ,  "Mabar "  , "Mabar Hilir" , "Tanjung Mulia"  , "Tanjung Muli Hilir " ,"Titi Papan"

};
        String [] medandenai = {

    "Binjai" ,"Denai"  , "Medan Tenggara" ,  "Tegalsari Mandala I" , "Tegalsari Mandala II" , "Tegalsari Mandala III"

};
        
        String [] medanhelvetia = { 	

    "Cinta Damai" ,  "Dwikora" ,  "Helvetia" ,  "Helvetia Tengah",  "Helvetia Timur" ,  "Sei Sikambing C II" ,  "Tanjung Gusta"

};
        String [] medanjohor = {

    "Gedung Johor" , "Kedai Durian" , "Kwala Bekala" , "Pangkalan Masyhur" , "Sukamaju" ,  "Titi Kuning"

};

        String [] medankota ={

    "Kotamatsum III" , "Mesjid" ,  "Pandau Hulu I"  , "Pasar Baru" ,  "Pasar Merah Barat" , "Pusat Pasar" , "Sei Rengas I" , "Sitirejo I" , "Sudirejo I" ,"Sudirejo II" ,"Teladan Barat", "Teladan Timur"

};

String [] medanlabuhan = {

    "Besar" , "Martubung" ,  "Nelayan Indah" ,"Pekan Labuhan" ,  "Sei Mati" , "Tangkahan"

};

String [] medanmaimun = { 	

    "Aur" ,  "Hamdan", "Jati" ,"Kampung Baru" ,"Sei Mati" , "Sukaraja"

};
 String [] medanmarelan = {

    "Labuhan Deli", "Paya Pasir" ,"Rengas Pulau" ,"Tanah Enam Ratus" ,"Terjun"

};
 String [] medanperjuangan = {

    "Tegal Rejo" , "Sidorame Barat I" , "Sidorame Barat II" , "Sidorame Timur" ,"Sei Kera Hilir I" ,"Sei Kera Hilir II" ,"Sei Kera Hulu Pahlawan", "Pandau Hilir"
         

};
 String [] medanpetisah = {

    "Petisah Tengah" , "Sei Putih Barat" , "Sei Putih Tengah" ,"Sei Putih Timur I", "Sei Putih Timur II", "Sei Sikambing D", "Sekip"

};
 
 String [] medanpolonia = { 	

    "Anggrung" , "Madras Hulu" , "Polonia" , "Sari Rejo" ,"Suka Damai"

};
 
String [] medansunggal = { 	

    "Babura Sunggal" ,"Lalang" , "Sei" , "Sikambing B" , "Simpang Tanjung" , "Sunggal" ,  "Tanjung Rejo"

};

String [] medanselayang = {

    "Asam Kumbang" ,"Beringin" , "Padang Bulan Selayang I" , "Padang Bulan Selayang II" , "Sempakata" , "Tanjung Sari"

};

String [] medantimur = { 	

    "Durian" , "Gaharu" , "Gang Buntu" , "Glugur Darat I" , "Glugur Darat II" , "Perintis"  ,"Pulo Brayan Bengkel", "Pulo Brayan Bengkel Baru" , "Pulo Brayan Darat I" ,"Pulo Brayan Darat II", "Sidodadi"

};

String [] medantembung = {

    "Bandar Selamat" , "Bantan" , "Bantan Timur" , "Indra Kasih" , "Sidorejo" ,"Sidorejo Hilir" , "Tembung"

};
        if(kecamatan.getSelectedItem().toString().equals("Medan Tuntungan"))
        {
             kecku = "Medan Tuntungan ";
             def1(Tuntungan);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Amplas"))
        {
             kecku = "Medan Amplas";
             def1(amplas);
        }
         else if(kecamatan.getSelectedItem().toString().equals("Medan Johor"))
        {
             kecku = "Medan Johor";
             def1(medanjohor);
        }
         else if(kecamatan.getSelectedItem().toString().equals("Medan Denai"))
        {
             kecku = "Medan Denai";
             def1(medandenai);
        } else if(kecamatan.getSelectedItem().toString().equals("Medan Area"))
        {
             kecku = "Medan Area";
             def1(medanarea);
        }  else if(kecamatan.getSelectedItem().toString().equals("Medan Kota"))
        {
             kecku = "Medan Kota";
             def1(medankota);
        }  else if(kecamatan.getSelectedItem().toString().equals("Medan Maimun"))
        {
             kecku = "Medan Maimun";
             def1(medanmaimun);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Polonia"))
        {
             kecku = "Medan Polonia";
             def1(medanmaimun);
        }else if(kecamatan.getSelectedItem().toString().equals("Medan Polonia"))
        {
             kecku = "Medan Polonia";
             def1(medanpolonia);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Baru"))
        {
             kecku = "Medan Baru";
             def1(medanbaru);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Selayang"))
        {
             kecku = "Medan Selayang";
             def1(medanselayang);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Sunggal"))
        {
             kecku = "Medan Sunggal";
             def1(medansunggal);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Helvetia"))
        {
             kecku = "Medan Helvetia";
             def1(medanhelvetia);
        } else if(kecamatan.getSelectedItem().toString().equals("Medan Petisah"))
        {
             kecku = "Medan Petisah";
             def1(medanpetisah);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Barat"))
        {
             kecku = "Medan Barat";
             def1(medanbarat);
        }
        else if(kecamatan.getSelectedItem().toString().equals("Medan Timur"))
        {
             kecku = "Medan Maimun";
             def1(medantimur);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Perjuangan"))
        {
             kecku = "Medan Perjuangan";
             def1(medanperjuangan);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Tembung"))
        {
             kecku = "Medan Tembung";
             def1(medantembung);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Deli"))
        {
             kecku = "Medan Deli";
             def1(medandeli);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Labuhan"))
        {
             kecku = "Medan Labuhan";
             def1(medanlabuhan);
        }    else if(kecamatan.getSelectedItem().toString().equals("Medan Marelan"))
        {
             kecku = "Medan Marelan";
             def1(medanmarelan);
        }
            else if(kecamatan.getSelectedItem().toString().equals("Medan Belawan"))
        {
             kecku = "Medan Belawan";
             def1(medanbelawan);
        }
    }//GEN-LAST:event_kecamatanActionPerformed

    private void noTelponKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noTelponKeyPressed
        // TODO add your handling code here:
        peringatan2.setVisible(false);
    }//GEN-LAST:event_noTelponKeyPressed

    private void kelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelurahanActionPerformed
        alamatPrefix.setText("");
          alamatPrefix.append("Kec. " +kecku );
//          ggl = kelurahan.getSelectedItem().toString();
//        alamatPrefix.append(" Kel . "+ggl);
    }//GEN-LAST:event_kelurahanActionPerformed

    private void alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyTyped
//        char c = evt.getKeyChar();
////        if(evt.getKeyChar() == )
//        String s = "";
//        s+=c;
//        alamatPrefix.append( s);
    }//GEN-LAST:event_alamatKeyTyped

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
//            menumakanan.setText(menu.totalmenu.getText());
//      menuharga.append(menu.hargaaMakan.getText());
//      qty.setText(menu.qty.getText());
        Menu men = new Menu();
        men.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void gugelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gugelMouseClicked
    try {
        // TODO add your handling code here:
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://maps.app.goo.gl/1Q6kMFKPoVVdSnrK7"));
    } catch (URISyntaxException ex) {
        Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_gugelMouseClicked

    private void alamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyPressed
        // TODO add your handling code here:
          String kel = kelurahan.getSelectedItem().toString();
//        alamatPrefix.append(alamat.getText());
    }//GEN-LAST:event_alamatKeyPressed

    private void alamatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alamatMouseClicked
        // TODO add your handling code here:
         String kel = kelurahan.getSelectedItem().toString();
        alamatPrefix.append("Kel ."+kel + "   ");
    }//GEN-LAST:event_alamatMouseClicked

    private void alamatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyReleased
        // TODO add your handling code here:
//         alamatPrefix.append(alamat.getText());
    }//GEN-LAST:event_alamatKeyReleased

    private void alamatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alamatMousePressed
        // TODO add your handling code here:
//        alamatPrefix.append(alamat.getText());
    }//GEN-LAST:event_alamatMousePressed

    private void alamatPrefixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alamatPrefixMouseClicked
        // TODO add your handling code here:
        alamatPrefix.append(alamat.getText());
    }//GEN-LAST:event_alamatPrefixMouseClicked

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
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JTextArea alamatPrefix;
    private javax.swing.JRadioButton bca;
    private javax.swing.JRadioButton bri;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private radio_button.ButtonKuning buttonKuning1;
    private radio_button.ButtonKuning buttonKuning2;
    private javax.swing.JRadioButton cod;
    private javax.swing.JRadioButton dana;
    private javax.swing.JLabel gugel;
    private javax.swing.JLabel hargaongkir;
    private javax.swing.JLabel hargapengemasan;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> kecamatan;
    private javax.swing.JComboBox<String> kelurahan;
    private javax.swing.JLabel labelongkir;
    private javax.swing.JLabel labelpem1;
    private javax.swing.JLabel labelpem2;
    private javax.swing.JLabel labelpengemasan;
    private javax.swing.JLabel labelsubtotal;
    private javax.swing.JRadioButton makandirumah;
    private javax.swing.JRadioButton makanditempat;
    public static final javax.swing.JTextArea menuharga = new javax.swing.JTextArea();
    public static final javax.swing.JTextArea menumakanan = new javax.swing.JTextArea();
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private textfield.TextField noPembayaran;
    private textfield.TextField noTelpon;
    private javax.swing.JRadioButton ovo;
    private javax.swing.JPanel panelpembayaran;
    private javax.swing.JLabel peringatan1;
    private javax.swing.JLabel peringatan2;
    private javax.swing.JTextArea qty;
    private javax.swing.JLabel totaltxt;
    // End of variables declaration//GEN-END:variables
}
