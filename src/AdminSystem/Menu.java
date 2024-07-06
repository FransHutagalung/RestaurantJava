package AdminSystem;



import java.awt.Desktop;
import java.net.URI;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import swing.EventCallBack;
import swing.EventTextField;
import JOptionPane1.MessageDialog;
import com.sun.glass.events.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import swing.EventCallBack;
import swing.EventTextField;
public class Menu extends javax.swing.JFrame {
public static String totalMakanan = "haha";
public static String totalHargaMakan = "haha";
private List<String> kemenu ;
static int mulai ;
static int mulaidetik;
static int mulaiMenit ;
String semua= "";
String semua1 = "";
public static String subTotal ="";
public static List <String> semuaMakanan = new ArrayList<>();
static List <String> namaMakanan = new ArrayList<>();
static List <String>  namaMinuman = new ArrayList<>();
static List <String> hargaMakanan = new ArrayList<>();
static List <String>  hargaMinuman = new ArrayList<>();
static List <String> stokMakanan = new ArrayList<>();
static List <String>  stokMinuman = new ArrayList<>();
static List <Byte> gambarMakan = new ArrayList<>();
public static  int nTotal = 0 ;
public static int nBarang = 0 ; 
public static int nGambar = 0 ;
int nGelap = 1;
    int [] myArr = new int [37];
    int [] myArr2 = new int [37];
    int [] hargaAkhirr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public Statement stm ; 
    public Connection con ;
    public PreparedStatement pst ;
    public ResultSet rs ;
    private ImageIcon imigicon  =  new ImageIcon() ;
    public Menu() {
        kemenu = new ArrayList<String>();
        LoginPelanggan log = new LoginPelanggan();
        String sks = log.namaAkhir ;
        int nop = 1 ;
        initComponents();
        PanelRiwayat pan = new PanelRiwayat();
        add(pan);
        panelcaribarang.setVisible(false);
//        mencari.setVisible(false);
        waktuku();
        KoneksiAdmin kon = new KoneksiAdmin();
//        System.out.println(semua);
        kon.Config();
        stm = kon.stm ;
        con = kon.con ;
        Loadminum();
        Load1();
        Load2();
        LoadGambar1();
        LoadGambar2();
        LoadGambar3();
        LoadGambar4();
        LoadGambar5();
        LoadGambar6();
        LoadGambar7();
        LoadGambar8();
        LoadGambar9();
        LoadGambar10();
        LoadGambar11();
        LoadGambar12();
        LoadGambar2();
        LoadGambar13();
        LoadGambar14();
        LoadGambar15();
        LoadGambar16();
        LoadGambar17();
        LoadGambar18();
        LoadGambar19();
        LoadGambar20();
        LoadGambar21();
        LoadGambar22();
        LoadGambar23();
        LoadGambar24();
        LoadGambarMinum1();
        LoadGambarMinum2();
                
        LoadGambarMinum3();
        LoadGambarMinum4();
        LoadGambarMinum5();
        LoadGambarMinum6();
        LoadGambarMinum7();
        LoadGambarMinum8();
        LoadGambarMinum9();
               LoadGambarMinum10();
                       LoadGambarMinum11();
                       LoadGambarMinum12();
        supera();
        superb();
        setUp();
        restoku();
        Calendar c = Calendar.getInstance();
        int timeComp = c.get(Calendar.HOUR_OF_DAY);
        tabku.setSelectedIndex(0);
        haha();
        troliku();
//        pencariantab.setVisible(false);
        tabku.setTitleAt(2, "");
        
        // UNTUK PENCARIAN 
//        String s12 = cari.getText();
            cari.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                
                //  Test
//                  mencari.setVisible(true);
                        tabku.setSelectedIndex(2);
                        tabku.setTitleAt(2, cari.getText());
                try {
                    for (int i = 1; i <= 100; i++) {
//                        mencari.setText("Mencari  " + "*");
                        Thread.sleep(18);
                    }
                    
//                    cari.setText("Pencarian Untuk " +cari.getText());
//                    tabku.setSelectedIndex(2);
                    tabku.setTitleAt(2, cari.getText());
//                    cari.setText("");
                    call.done();
//                      JOptionPane.showMessageDialog(cari, "Mencari" +cari);
                    if(namaMakanan.contains(cari.getText()))
                    {
//                      
                      
                        
                        int n = namaMakanan.indexOf(cari.getText());
                       
                        minumm13.setText(namaMakanan.get(n));
                        hargaminum13.setText(hargaMakanan.get(n));
                     //   panelcaribarang.setVisible(true);
                        try {
           pst = con.prepareStatement("SELECT * FROM barang WHERE namaBarang = ?");
           pst.setString(1, minumm13.getText());
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(gami9.getWidth(), gami9.getHeight(), Image.SCALE_SMOOTH);
                
                gami9.setIcon(new ImageIcon(mm2));
           }
                        } catch (SQLException e)
                        {
                            
                        }
                        stokminum13.setText(stokMakanan.get(n));
                          panelcaribarang.setVisible(true);
                         cari.setText("");
                         
                    } else if(namaMinuman.contains(cari.getText()))
                    {
                        panelcaribarang.setVisible(true);
                        int n = namaMinuman.indexOf(cari.getText());
                        minumm13.setText(namaMinuman.get(n));
                        hargaminum13.setText(hargaMinuman.get(n));
                                                try {
           pst = con.prepareStatement("SELECT * FROM barang WHERE namaBarang = ?");
           pst.setString(1, minumm13.getText());
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(gami9.getWidth(), gami9.getHeight(), Image.SCALE_SMOOTH);
                
                gami9.setIcon(new ImageIcon(mm2));
           }
                        } catch (SQLException e)
                        {
                            
                        }

                        stokminum13.setText(stokMinuman.get(n));
                          panelcaribarang.setVisible(true);
                         cari.setText("");
                    }
                    else 
                    {
                        cari.setText("");
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }
    void gambargan(String s )
    {
 
      // gambarMakanatas.setIcon(baru);  
    }
    void haha()
    {
        semua1 = semuaMakanan.toString();
//        System.out.println(semua1);
    }
    void gaga(String bk)
    {
        uc.setText(bk);
    }
    void waktuku()
    {
         Calendar cal = Calendar.getInstance();

         int jam = cal.get(Calendar.HOUR_OF_DAY);
         System.out.println(jam);
        
       
         int minute = cal.get(Calendar.MINUTE);
         System.out.println(minute); // 9 
       
         int detik = cal.get(Calendar.SECOND);
         System.out.println(detik);
        
        
        int jamHabis = 23;
        int menithabis = 48 ; // 3 
        int detikhabis = 45 ;
        
         mulai = jamHabis - jam ;
         mulaiMenit = menithabis - minute;
         mulaidetik = detikhabis - detik ;

         if(mulaidetik < 0)
         {
            mulaiMenit -= 1;

            mulaidetik = 60 - detik + detikhabis;
         }

        if(mulaiMenit < 0)
        {
            mulai -= 1;
            
//            mulaiMenit = Math.abs(mulaiMenit);
            mulaiMenit = 60 - minute + menithabis;
            
//            mulaiMenit = 60 -
        }
                boolean state = true ;

          Thread t = new Thread(){
          public void run()
           {
            for(;;)
             {
              if(state)
               {
                try{
                  sleep(1000);
                      
                      mulaidetik -=1;
//                     if(mulaidetik%2==0)
//                     {
//                         lbldiskon.setText("");
//                     } else if (mulaidetik%2!=0)
//                     {
//                         lbldiskon.setText(".");
//                     }
                         if(mulaidetik<0)
                           {
//                         ms = 0 ;
                            mulaidetik = 59 ;
                         mulaiMenit--;
                    }
                    if(mulaiMenit < 0){
                        mulaiMenit = 59;
//                        ms = 0 ;
                        mulai--;
                    }
//                    System.out.println("detik "+mulaidetik);
//                    System.out.println("menit "+mulaiMenit);
//                    System.out.println("Jam "+mulai);
detiklabel.setText(String.valueOf(mulaidetik));
menitlabel.setText(String.valueOf(mulaiMenit));
jamlabel.setText(String.valueOf(mulai));
//                ms++;
                }
                catch(Exception e)
                {
                    
                }
            }
            else {
                break ;
            }
        }
    }
};
t.start();
    }
    void setUp()
    {
        LoginPelanggan log = new LoginPelanggan();
        String usn = log.namaAkhir;
        uc.setText("Selamat Malam " +usn);
    }
    void Loadminum()
    {
        try {
            String sql = "SELECT namaBarang , hargaBarang , stoBarang   FROM barang WHERE jenisBarang = 'MINUMAN'";
            rs = stm.executeQuery(sql);
            while(rs.next())
            {
                 namaMinuman.add(rs.getString("namaBarang"));
                hargaMinuman.add(rs.getString("hargaBarang"));
                stokMinuman.add(rs.getString("stoBarang"));
            }
        }
        catch (SQLException e)
        {
            
        }
    }
    void Load1()
    {
      try 
        {
            String sql1 = "SELECT namaBarang , hargaBarang , stoBarang   FROM barang WHERE jenisBarang = 'MAKANAN'";
            rs = stm.executeQuery(sql1);
            int count = 0 ;
            while(rs.next())
            {
//                String s1 = rs.getString(1);
                namaMakanan.add(rs.getString("namaBarang"));
                hargaMakanan.add(rs.getString("hargaBarang"));
                stokMakanan.add(rs.getString("stoBarang"));
//                 gambarMakan.add(rs.getByte("gambarBarang"));
//                for(int i = 0 ; i < 12 ; i++)
//                {
//                    namaBarang[i] = rs.getString(1);
//                     hargaBarang[i] = rs.getString(2);
//                      stokBarang[i] = rs.getString(3);
//                }
                
           
                
            }
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
    }
    }
    public void Load2()
    {
        makan1.setText(namaMakanan.get(0));
        makan2.setText(namaMakanan.get(1));
        makan3.setText(namaMakanan.get(2));
        makan4.setText(namaMakanan.get(3));
        makan5.setText(namaMakanan.get(4));
        makan6.setText(namaMakanan.get(5));
        makan7.setText(namaMakanan.get(6));
        makan8.setText(namaMakanan.get(7));
        makan9.setText(namaMakanan.get(8));
        makan10.setText(namaMakanan.get(9));
        makan11.setText(namaMakanan.get(10));
        makan12.setText(namaMakanan.get(11));
        makan13.setText(namaMakanan.get(12));
        makan14.setText(namaMakanan.get(13));
        makan15.setText(namaMakanan.get(14));
        makan16.setText(namaMakanan.get(15));
        makan17.setText(namaMakanan.get(16));
        makan18.setText(namaMakanan.get(17));
        makan19.setText(namaMakanan.get(18));
        makan20.setText(namaMakanan.get(19));
        makan21.setText(namaMakanan.get(20));
        makan22.setText(namaMakanan.get(21));
        makan23.setText(namaMakanan.get(22));
        makan24.setText(namaMakanan.get(23));
        minumm1.setText(namaMinuman.get(0));
        minumm2.setText(namaMinuman.get(1));
        minumm3.setText(namaMinuman.get(2));
        minumm4.setText(namaMinuman.get(3));
        minumm5.setText(namaMinuman.get(4));
        minumm6.setText(namaMinuman.get(5));
        minumm7.setText(namaMinuman.get(6));
        minumm8.setText(namaMinuman.get(7));
        minumm9.setText(namaMinuman.get(8));
        minumm10.setText(namaMinuman.get(9));
        minumm11.setText(namaMinuman.get(10));
        minumm12.setText(namaMinuman.get(11));
        harga1.setText(hargaMakanan.get(0));
         hargaa1.setText(hargaMakanan.get(0));
        harga2.setText(hargaMakanan.get(1));
        harga3.setText(hargaMakanan.get(2));
        harga4.setText(hargaMakanan.get(3));
        harga5.setText(hargaMakanan.get(4));
        harga6.setText(hargaMakanan.get(5));
        harga7.setText(hargaMakanan.get(6));
        harga8.setText(hargaMakanan.get(7));
        harga9.setText(hargaMakanan.get(8));
        harga10.setText(hargaMakanan.get(9));
        harga11.setText(hargaMakanan.get(10));
        harga12.setText(hargaMakanan.get(11));
        harga13.setText(hargaMakanan.get(12));
        harga14.setText(hargaMakanan.get(13));
        harga15.setText(hargaMakanan.get(14));
        harga16.setText(hargaMakanan.get(15));
        harga17.setText(hargaMakanan.get(16));
        harga18.setText(hargaMakanan.get(17));
        harga19.setText(hargaMakanan.get(18));
        harga20.setText(hargaMakanan.get(19));
        harga21.setText(hargaMakanan.get(20));
        harga22.setText(hargaMakanan.get(21));
        harga23.setText(hargaMakanan.get(22));
        harga24.setText(hargaMakanan.get(23));
        
        hargaminum1.setText( hargaMinuman.get(0));
         hargaminum2.setText( hargaMinuman.get(1));
          hargaminum3.setText( hargaMinuman.get(2));
           hargaminum4.setText( hargaMinuman.get(3));
            hargaminum5.setText( hargaMinuman.get(4));
             hargaminum6.setText( hargaMinuman.get(5));
              hargaminum7.setText( hargaMinuman.get(6));
               hargaminum8.setText( hargaMinuman.get(7));
                hargaminum9.setText( hargaMinuman.get(8));
          hargaminum10.setText( hargaMinuman.get(9));
           hargaminum11.setText( hargaMinuman.get(10));
            hargaminum12.setText( hargaMinuman.get(11));
        stok1.setText(stokMakanan.get(0));
        stok2.setText(stokMakanan.get(1));
        stok3.setText(stokMakanan.get(2));
        stok4.setText(stokMakanan.get(3));
        stok5.setText(stokMakanan.get(4));
        stok6.setText(stokMakanan.get(5));
        stok7.setText(stokMakanan.get(6));
        stok8.setText(stokMakanan.get(7));
        stok9.setText(stokMakanan.get(8));
        stok10.setText(stokMakanan.get(9));
        stok11.setText(stokMakanan.get(10));
        stok12.setText(stokMakanan.get(11));
        stok13.setText(stokMakanan.get(12));
        stok14.setText(stokMakanan.get(13));
        stok15.setText(stokMakanan.get(14));
        stok16.setText(stokMakanan.get(15));
        stok17.setText(stokMakanan.get(16));
        stok18.setText(stokMakanan.get(17));
        stok19.setText(stokMakanan.get(18));
        stok20.setText(stokMakanan.get(19));
        stok21.setText(stokMakanan.get(20));
        stok22.setText(stokMakanan.get(21));
        stok23.setText(stokMakanan.get(22));
        stok24.setText(stokMakanan.get(23));
        stokminum1.setText(stokMinuman.get(0));
         stokminum2.setText(stokMinuman.get(1));
          stokminum3.setText(stokMinuman.get(2));
           stokminum4.setText(stokMinuman.get(3));
            stokminum5.setText(stokMinuman.get(4));
             stokminum6.setText(stokMinuman.get(5));
              stokminum7.setText(stokMinuman.get(6));
               stokminum8.setText(stokMinuman.get(7));
                stokminum9.setText(stokMinuman.get(8));
                 stokminum10.setText(stokMinuman.get(9));
                  stokminum11.setText(stokMinuman.get(10));
                   stokminum12.setText(stokMinuman.get(11));
    }
    void gantiWarna()
    {
        if(nGelap%2==0)
        {
            // [102,102,102]
            panelatas.setBackground(new Color(102,102,102));
            paneltengah.setBackground(new Color(102,102,102));
            panelsudut.setBackground(new Color(102,102,102));
            panelsamping.setBackground(new Color(102,102,102));
        }
        else 
        {
            // [51,255,255]
            panelatas.setBackground(new Color(51,255,255));
            paneltengah.setBackground(new Color(51,255,255));
            panelsudut.setBackground(new Color(51,255,255));
            panelsamping.setBackground(new Color(255,204,204));
        }
    }
    
     public void LoadGambar1()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "1");
           rs = pst.executeQuery();
           if(rs.next())
           {
             
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr1.getWidth(), makangbr1.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr1.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
     public void LoadGambarMinum2()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "26");
           rs = pst.executeQuery();
           if(rs.next())
           {
             
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku2.getWidth(), minumanku2.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku2.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void LoadGambarMinum1()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? ");
           pst.setString(1, "25");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku1.getWidth(), minumanku1.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku1.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     public void LoadGambarMinum3()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "27");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku3.getWidth(), minumanku3.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku3.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
      public void LoadGambarMinum4()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "28");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku4.getWidth(), minumanku4.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku4.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
       public void LoadGambarMinum5()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "29");
           rs = pst.executeQuery();
           if(rs.next())
           {
                
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku5.getWidth(), minumanku5.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku5.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        public void LoadGambarMinum6()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "30");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku6.getWidth(), minumanku6.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku6.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
         public void LoadGambarMinum7()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "31");
           rs = pst.executeQuery();
           if(rs.next())
           {
//                System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku7.getWidth(), minumanku7.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku7.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
          public void LoadGambarMinum8()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "32");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku8.getWidth(), minumanku8.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku8.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
           public void LoadGambarMinum9()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "33");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku9.getWidth(), minumanku9.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku9.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
            public void LoadGambarMinum10()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "34");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku10.getWidth(), minumanku10.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku10.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
             public void LoadGambarMinum11()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "35");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku11.getWidth(), minumanku11.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku11.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
              public void LoadGambarMinum12()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Minuman'");
           pst.setString(1, "36");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(minumanku12.getWidth(), minumanku12.getHeight(), Image.SCALE_SMOOTH);
                
                minumanku12.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     public void LoadGambar13()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "13");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr13.getWidth(), makangbr13.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr13.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
      public void LoadGambar14()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "14");
           rs = pst.executeQuery();
           if(rs.next())
           {
             //   System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr14.getWidth(), makangbr14.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr14.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
       public void LoadGambar15()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "15");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr15.getWidth(), makangbr15.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr15.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        public void LoadGambar16()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "16");
           rs = pst.executeQuery();
           if(rs.next())
           {
                System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr16.getWidth(), makangbr16.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr16.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
         public void LoadGambar17()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "17");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr17.getWidth(), makangbr17.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr17.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
          public void LoadGambar18()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "18");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr18.getWidth(), makangbr18.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr18.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
           public void LoadGambar19()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "19");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr19.getWidth(), makangbr19.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr19.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
            public void LoadGambar20()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "20");
           rs = pst.executeQuery();
           if(rs.next())
           { 
               //System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr20.getWidth(), makangbr20.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr20.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
             public void LoadGambar21()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "21");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr21.getWidth(), makangbr21.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr21.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
              public void LoadGambar22()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "22");
           rs = pst.executeQuery();
           if(rs.next())
           {
                
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr22.getWidth(), makangbr22.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr22.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
               public void LoadGambar23()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "23");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr23.getWidth(), makangbr23.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr23.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
                public void LoadGambar24()
    {
//        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ? and jenisBarang = 'Makanan'");
           pst.setString(1, "24");
           rs = pst.executeQuery();
           if(rs.next())
           {
                
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr24.getWidth(), makangbr24.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr24.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        public void LoadGambar2()
    {
//
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "2");
           rs = pst.executeQuery();
           if(rs.next())
           {
              
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr2.getWidth(), makangbr2.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr2.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
                 public void LoadGambar3()
    {
       
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "3");
           rs = pst.executeQuery();
           if(rs.next())
           {
               
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr3.getWidth(), makangbr3.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr3.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
          public void LoadGambar4()
    {
        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "4");
           rs = pst.executeQuery();
           if(rs.next())
           { 
               //System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr4.getWidth(), makangbr4.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr4.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
           public void LoadGambar5()
    {
        //System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "5");
           rs = pst.executeQuery();
           if(rs.next())
           {
             
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr5.getWidth(), makangbr5.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr5.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
            public void LoadGambar6()
    {
       
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "6");
           rs = pst.executeQuery();
           if(rs.next())
           {
             
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr6.getWidth(), makangbr6.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr6.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
             public void LoadGambar7()
    {
      
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "7");
           rs = pst.executeQuery();
           if(rs.next())
           {
               // System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr7.getWidth(), makangbr7.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr7.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
              public void LoadGambar8()
    {
        System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "8");
           rs = pst.executeQuery();
           if(rs.next())
           {
              //  System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr8.getWidth(), makangbr8.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr8.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
               public void LoadGambar9()
    {
     //   System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "9");
           rs = pst.executeQuery();
           if(rs.next())
           {
            //    System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr9.getWidth(), makangbr9.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr9.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
                public void LoadGambar10()
    {
        
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "10");
           rs = pst.executeQuery();
           if(rs.next())
           {
             //   System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr10.getWidth(), makangbr10.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr10.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
                 public void LoadGambar11()
    {
    //    System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "11");
           rs = pst.executeQuery();
           if(rs.next())
           {
                System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr11.getWidth(), makangbr11.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr11.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
                  public void LoadGambar12()
    {
    //    System.out.println("k");
       try {
           // TODO add your handling code here:
           pst = con.prepareStatement("SELECT * FROM barang WHERE idBarang = ?");
           pst.setString(1, "12");
           rs = pst.executeQuery();
           if(rs.next())
           {
//                System.out.println("ada");
                byte [] imageData = rs.getBytes("gambarBarang");
                imigicon = new ImageIcon(imageData);
                Image mm = imigicon.getImage();
                Image mm2 = mm.getScaledInstance(makangbr12.getWidth(), makangbr12.getHeight(), Image.SCALE_SMOOTH);
                
                makangbr12.setIcon(new ImageIcon(mm2));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void supera()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\makansuper.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(jLabel35.getWidth(), jLabel35.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        jLabel35.setIcon(baru);
    
    }
        public void superb()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\historyorder.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(historyOrder.getWidth(), historyOrder.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        historyOrder.setIcon(baru);
    
    }
                public void troliku()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\logotroli.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(labeltroli.getWidth(), labeltroli.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        labeltroli.setIcon(baru);
    
    }
                               public void restoku()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\restoikon.jpg");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(labelrestoran.getWidth(), labelrestoran.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        labelrestoran.setIcon(baru);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gam = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        panelsamping = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel33 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        totalSemua = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        labeltroli = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        BAYAR = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        paneltengah = new javax.swing.JPanel();
        tabku = new tabbed.MaterialTabbed();
        jPanel4 = new javax.swing.JPanel();
        panelBarang8 = new AdminSystem.PanelBarang();
        minumanku1 = new javax.swing.JLabel();
        minumm1 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        hargaminum1 = new javax.swing.JLabel();
        stokminum1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        banyak25 = new javax.swing.JSpinner();
        jCheckBox25 = new javax.swing.JCheckBox();
        panelBarang13 = new AdminSystem.PanelBarang();
        minumanku2 = new javax.swing.JLabel();
        minumm2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        hargaminum2 = new javax.swing.JLabel();
        stokminum2 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        banyak26 = new javax.swing.JSpinner();
        jCheckBox26 = new javax.swing.JCheckBox();
        panelBarang14 = new AdminSystem.PanelBarang();
        minumanku3 = new javax.swing.JLabel();
        minumm3 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        hargaminum3 = new javax.swing.JLabel();
        stokminum3 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        banyak27 = new javax.swing.JSpinner();
        jCheckBox27 = new javax.swing.JCheckBox();
        panelBarang15 = new AdminSystem.PanelBarang();
        minumanku4 = new javax.swing.JLabel();
        minumm4 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        hargaminum4 = new javax.swing.JLabel();
        stokminum4 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        banyak28 = new javax.swing.JSpinner();
        jCheckBox28 = new javax.swing.JCheckBox();
        panelBarang16 = new AdminSystem.PanelBarang();
        minumanku5 = new javax.swing.JLabel();
        minumm5 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        hargaminum5 = new javax.swing.JLabel();
        stokminum5 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        banyak29 = new javax.swing.JSpinner();
        jCheckBox29 = new javax.swing.JCheckBox();
        panelBarang17 = new AdminSystem.PanelBarang();
        minumanku6 = new javax.swing.JLabel();
        minumm6 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        hargaminum6 = new javax.swing.JLabel();
        stokminum6 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        banyak30 = new javax.swing.JSpinner();
        jCheckBox36 = new javax.swing.JCheckBox();
        panelBarang18 = new AdminSystem.PanelBarang();
        minumanku12 = new javax.swing.JLabel();
        minumm12 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        hargaminum12 = new javax.swing.JLabel();
        stokminum12 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        banyak36 = new javax.swing.JSpinner();
        jCheckBox35 = new javax.swing.JCheckBox();
        panelBarang19 = new AdminSystem.PanelBarang();
        minumanku11 = new javax.swing.JLabel();
        minumm11 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        hargaminum11 = new javax.swing.JLabel();
        stokminum11 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        banyak35 = new javax.swing.JSpinner();
        jCheckBox34 = new javax.swing.JCheckBox();
        panelBarang20 = new AdminSystem.PanelBarang();
        minumanku9 = new javax.swing.JLabel();
        minumm9 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        hargaminum9 = new javax.swing.JLabel();
        stokminum9 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        banyak33 = new javax.swing.JSpinner();
        jCheckBox32 = new javax.swing.JCheckBox();
        panelBarang21 = new AdminSystem.PanelBarang();
        minumanku10 = new javax.swing.JLabel();
        minumm10 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        hargaminum10 = new javax.swing.JLabel();
        stokminum10 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        banyak34 = new javax.swing.JSpinner();
        jCheckBox33 = new javax.swing.JCheckBox();
        panelBarang22 = new AdminSystem.PanelBarang();
        minumanku7 = new javax.swing.JLabel();
        minumm7 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        hargaminum7 = new javax.swing.JLabel();
        stokminum7 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        banyak31 = new javax.swing.JSpinner();
        jCheckBox30 = new javax.swing.JCheckBox();
        panelBarang23 = new AdminSystem.PanelBarang();
        minumanku8 = new javax.swing.JLabel();
        minumm8 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        hargaminum8 = new javax.swing.JLabel();
        stokminum8 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        banyak32 = new javax.swing.JSpinner();
        jCheckBox31 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        panelBarang1 = new AdminSystem.PanelBarang();
        makangbr1 = new javax.swing.JLabel();
        makan1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        harga1 = new javax.swing.JLabel();
        stok1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        banyak1 = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        panelBarang2 = new AdminSystem.PanelBarang();
        makangbr3 = new javax.swing.JLabel();
        makan3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        harga3 = new javax.swing.JLabel();
        stok3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        banyak3 = new javax.swing.JSpinner();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        panelBarang3 = new AdminSystem.PanelBarang();
        makangbr2 = new javax.swing.JLabel();
        makan2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        harga2 = new javax.swing.JLabel();
        stok2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        banyak2 = new javax.swing.JSpinner();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        panelBarang5 = new AdminSystem.PanelBarang();
        makangbr4 = new javax.swing.JLabel();
        makan4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        harga4 = new javax.swing.JLabel();
        stok4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        banyak4 = new javax.swing.JSpinner();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        panelBarang6 = new AdminSystem.PanelBarang();
        makangbr5 = new javax.swing.JLabel();
        makan5 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        harga5 = new javax.swing.JLabel();
        stok5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        banyak5 = new javax.swing.JSpinner();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelBarang7 = new AdminSystem.PanelBarang();
        makangbr6 = new javax.swing.JLabel();
        makan6 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        harga6 = new javax.swing.JLabel();
        stok6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        banyak6 = new javax.swing.JSpinner();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        panelBarang4 = new AdminSystem.PanelBarang();
        makangbr7 = new javax.swing.JLabel();
        makan7 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        harga7 = new javax.swing.JLabel();
        stok7 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        banyak7 = new javax.swing.JSpinner();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        panelBarang9 = new AdminSystem.PanelBarang();
        makangbr9 = new javax.swing.JLabel();
        makan9 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        harga9 = new javax.swing.JLabel();
        stok9 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        banyak9 = new javax.swing.JSpinner();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel69 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        panelBarang10 = new AdminSystem.PanelBarang();
        makangbr8 = new javax.swing.JLabel();
        makan8 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        harga8 = new javax.swing.JLabel();
        stok8 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        banyak8 = new javax.swing.JSpinner();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        panelBarang11 = new AdminSystem.PanelBarang();
        makangbr10 = new javax.swing.JLabel();
        makan10 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        harga10 = new javax.swing.JLabel();
        stok10 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        banyak10 = new javax.swing.JSpinner();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        panelBarang12 = new AdminSystem.PanelBarang();
        makangbr11 = new javax.swing.JLabel();
        makan11 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        harga11 = new javax.swing.JLabel();
        stok11 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        banyak11 = new javax.swing.JSpinner();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel43 = new javax.swing.JLabel();
        panel12 = new AdminSystem.PanelBarang();
        makangbr12 = new javax.swing.JLabel();
        makan12 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        harga12 = new javax.swing.JLabel();
        stok12 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        banyak12 = new javax.swing.JSpinner();
        jCheckBox12 = new javax.swing.JCheckBox();
        jLabel44 = new javax.swing.JLabel();
        panelBarang36 = new AdminSystem.PanelBarang();
        makangbr13 = new javax.swing.JLabel();
        makan13 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        harga13 = new javax.swing.JLabel();
        stok13 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        banyak13 = new javax.swing.JSpinner();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        panelBarang37 = new AdminSystem.PanelBarang();
        makangbr14 = new javax.swing.JLabel();
        makan14 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        harga14 = new javax.swing.JLabel();
        stok14 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        banyak14 = new javax.swing.JSpinner();
        jCheckBox14 = new javax.swing.JCheckBox();
        jLabel52 = new javax.swing.JLabel();
        panelBarang38 = new AdminSystem.PanelBarang();
        makangbr15 = new javax.swing.JLabel();
        makan15 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        harga15 = new javax.swing.JLabel();
        stok15 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        banyak15 = new javax.swing.JSpinner();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel54 = new javax.swing.JLabel();
        panelBarang39 = new AdminSystem.PanelBarang();
        makangbr16 = new javax.swing.JLabel();
        makan16 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        harga16 = new javax.swing.JLabel();
        stok16 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        banyak16 = new javax.swing.JSpinner();
        jCheckBox16 = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        panelBarang40 = new AdminSystem.PanelBarang();
        makangbr17 = new javax.swing.JLabel();
        makan17 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        harga17 = new javax.swing.JLabel();
        stok17 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        banyak17 = new javax.swing.JSpinner();
        jCheckBox17 = new javax.swing.JCheckBox();
        jLabel61 = new javax.swing.JLabel();
        panelBarang41 = new AdminSystem.PanelBarang();
        makangbr18 = new javax.swing.JLabel();
        makan18 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        harga18 = new javax.swing.JLabel();
        stok18 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        banyak18 = new javax.swing.JSpinner();
        jCheckBox18 = new javax.swing.JCheckBox();
        jLabel62 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        panelBarang42 = new AdminSystem.PanelBarang();
        makangbr19 = new javax.swing.JLabel();
        makan19 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        harga19 = new javax.swing.JLabel();
        stok19 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        banyak19 = new javax.swing.JSpinner();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel84 = new javax.swing.JLabel();
        panelBarang43 = new AdminSystem.PanelBarang();
        makangbr20 = new javax.swing.JLabel();
        makan20 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        harga20 = new javax.swing.JLabel();
        stok20 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        banyak20 = new javax.swing.JSpinner();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel89 = new javax.swing.JLabel();
        panelBarang44 = new AdminSystem.PanelBarang();
        makangbr21 = new javax.swing.JLabel();
        makan21 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        harga21 = new javax.swing.JLabel();
        stok21 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        banyak21 = new javax.swing.JSpinner();
        jCheckBox21 = new javax.swing.JCheckBox();
        jLabel94 = new javax.swing.JLabel();
        panelBarang45 = new AdminSystem.PanelBarang();
        makangbr22 = new javax.swing.JLabel();
        makan22 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        harga22 = new javax.swing.JLabel();
        stok22 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        banyak22 = new javax.swing.JSpinner();
        jCheckBox22 = new javax.swing.JCheckBox();
        jLabel99 = new javax.swing.JLabel();
        panelBarang46 = new AdminSystem.PanelBarang();
        makangbr23 = new javax.swing.JLabel();
        makan23 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        harga23 = new javax.swing.JLabel();
        stok23 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        banyak23 = new javax.swing.JSpinner();
        jCheckBox23 = new javax.swing.JCheckBox();
        jLabel104 = new javax.swing.JLabel();
        panelBarang47 = new AdminSystem.PanelBarang();
        makangbr24 = new javax.swing.JLabel();
        makan24 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        harga24 = new javax.swing.JLabel();
        stok24 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        banyak24 = new javax.swing.JSpinner();
        jCheckBox24 = new javax.swing.JCheckBox();
        jLabel109 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pencariantab = new javax.swing.JPanel();
        panelcaribarang = new AdminSystem.PanelBarang();
        gami9 = new javax.swing.JLabel();
        minumm13 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        hargaminum13 = new javax.swing.JLabel();
        stokminum13 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        banyak37 = new javax.swing.JSpinner();
        jCheckBox37 = new javax.swing.JCheckBox();
        cari = new swing.TextFieldAnimation();
        myButton2 = new button.MyButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        panelsudut = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        myButton1 = new button.MyButton();
        jPanel9 = new javax.swing.JPanel();
        jamlabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        menitlabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        detiklabel = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        panelatas = new javax.swing.JPanel();
        uc = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        historyOrder = new javax.swing.JLabel();
        gami8 = new javax.swing.JLabel();
        latar = new switchbutton.SwitchButton();
        jLabel4 = new javax.swing.JLabel();
        labelrestoran = new javax.swing.JLabel();
        uc1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pesanMakan = new javax.swing.JTextArea();
        hargaa1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        gam.setText("jLabel1");

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel37.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel71.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel93.setText("DISKON :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelsamping.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TROLI ANDA");

        jLabel32.setText("DAFTAR PESANAN");

        hargaaMakan.setColumns(20);
        hargaaMakan.setRows(5);
        jScrollPane2.setViewportView(hargaaMakan);

        jLabel33.setText("HARGA");

        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("TOTAL PEMBELANJAAN      Rp.");

        totalmenu.setColumns(20);
        totalmenu.setRows(5);
        totalmenu.setAutoscrolls(false);
        jScrollPane3.setViewportView(totalmenu);

        qty.setColumns(20);
        qty.setRows(5);
        jScrollPane4.setViewportView(qty);

        jLabel7.setText("QTY");

        BAYAR.setText("BAYAR");
        BAYAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAYARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelsampingLayout = new javax.swing.GroupLayout(panelsamping);
        panelsamping.setLayout(panelsampingLayout);
        panelsampingLayout.setHorizontalGroup(
            panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsampingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsampingLayout.createSequentialGroup()
                        .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelsampingLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(panelsampingLayout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BAYAR, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(totalSemua))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelsampingLayout.createSequentialGroup()
                            .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelsampingLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelsampingLayout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(jLabel96))
                                .addGroup(panelsampingLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labeltroli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        panelsampingLayout.setVerticalGroup(
            panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsampingLayout.createSequentialGroup()
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsampingLayout.createSequentialGroup()
                        .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(labeltroli, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelsampingLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsampingLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelsampingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalSemua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAYAR)
                    .addComponent(jButton2))
                .addGap(434, 434, 434))
        );

        paneltengah.setBackground(new java.awt.Color(0, 255, 255));

        panelBarang8.setBackground(new java.awt.Color(0, 153, 255));

        minumanku1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm1.setText("NAMA MAKANAN");

        jLabel45.setText("Rp.");

        hargaminum1.setText("Harga");

        stokminum1.setText("123");

        jLabel48.setText("Tersedia");

        banyak25.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak25StateChanged(evt);
            }
        });

        jCheckBox25.setText("Troli");
        jCheckBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang8Layout = new javax.swing.GroupLayout(panelBarang8);
        panelBarang8.setLayout(panelBarang8Layout);
        panelBarang8Layout.setHorizontalGroup(
            panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang8Layout.createSequentialGroup()
                .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang8Layout.createSequentialGroup()
                        .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang8Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm1))
                            .addGroup(panelBarang8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang8Layout.createSequentialGroup()
                                        .addComponent(stokminum1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel48))
                                    .addGroup(panelBarang8Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum1))))
                            .addComponent(jCheckBox25))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang8Layout.setVerticalGroup(
            panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang8Layout.createSequentialGroup()
                        .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(hargaminum1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum1)
                            .addComponent(jLabel48)))
                    .addComponent(banyak25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jCheckBox25))
        );

        panelBarang13.setBackground(new java.awt.Color(0, 153, 255));

        minumanku2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm2.setText("NAMA MAKANAN");

        jLabel51.setText("Rp.");

        hargaminum2.setText("Harga");

        stokminum2.setText("123");

        jLabel56.setText("Tersedia");

        banyak26.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak26StateChanged(evt);
            }
        });

        jCheckBox26.setText("Troli");
        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang13Layout = new javax.swing.GroupLayout(panelBarang13);
        panelBarang13.setLayout(panelBarang13Layout);
        panelBarang13Layout.setHorizontalGroup(
            panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang13Layout.createSequentialGroup()
                .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang13Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang13Layout.createSequentialGroup()
                        .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang13Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm2))
                            .addGroup(panelBarang13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang13Layout.createSequentialGroup()
                                        .addComponent(stokminum2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel56))
                                    .addGroup(panelBarang13Layout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum2))))
                            .addComponent(jCheckBox26))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang13Layout.setVerticalGroup(
            panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang13Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang13Layout.createSequentialGroup()
                        .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(hargaminum2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum2)
                            .addComponent(jLabel56)))
                    .addComponent(banyak26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jCheckBox26))
        );

        panelBarang14.setBackground(new java.awt.Color(0, 153, 255));

        minumanku3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm3.setText("NAMA MAKANAN");

        jLabel59.setText("Rp.");

        hargaminum3.setText("Harga");

        stokminum3.setText("123");

        jLabel64.setText("Tersedia");

        banyak27.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak27StateChanged(evt);
            }
        });

        jCheckBox27.setText("Troli");
        jCheckBox27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang14Layout = new javax.swing.GroupLayout(panelBarang14);
        panelBarang14.setLayout(panelBarang14Layout);
        panelBarang14Layout.setHorizontalGroup(
            panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang14Layout.createSequentialGroup()
                .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang14Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang14Layout.createSequentialGroup()
                        .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang14Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm3))
                            .addGroup(panelBarang14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang14Layout.createSequentialGroup()
                                        .addComponent(stokminum3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel64))
                                    .addGroup(panelBarang14Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum3))))
                            .addComponent(jCheckBox27))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang14Layout.setVerticalGroup(
            panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang14Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang14Layout.createSequentialGroup()
                        .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(hargaminum3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum3)
                            .addComponent(jLabel64)))
                    .addComponent(banyak27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox27))
        );

        panelBarang15.setBackground(new java.awt.Color(0, 153, 255));

        minumanku4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm4.setText("NAMA MAKANAN");

        jLabel67.setText("Rp.");

        hargaminum4.setText("Harga");

        stokminum4.setText("123");

        jLabel72.setText("Tersedia");

        banyak28.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak28StateChanged(evt);
            }
        });

        jCheckBox28.setText("Troli");
        jCheckBox28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang15Layout = new javax.swing.GroupLayout(panelBarang15);
        panelBarang15.setLayout(panelBarang15Layout);
        panelBarang15Layout.setHorizontalGroup(
            panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang15Layout.createSequentialGroup()
                .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku4, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang15Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang15Layout.createSequentialGroup()
                        .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang15Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm4))
                            .addGroup(panelBarang15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang15Layout.createSequentialGroup()
                                        .addComponent(stokminum4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel72))
                                    .addGroup(panelBarang15Layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum4))))
                            .addComponent(jCheckBox28))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang15Layout.setVerticalGroup(
            panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang15Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang15Layout.createSequentialGroup()
                        .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(hargaminum4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum4)
                            .addComponent(jLabel72)))
                    .addComponent(banyak28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox28))
        );

        panelBarang16.setBackground(new java.awt.Color(0, 153, 255));

        minumanku5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm5.setText("NAMA MAKANAN");

        jLabel76.setText("Rp.");

        hargaminum5.setText("Harga");

        stokminum5.setText("123");

        jLabel80.setText("Tersedia");

        banyak29.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak29StateChanged(evt);
            }
        });

        jCheckBox29.setText("Troli");
        jCheckBox29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang16Layout = new javax.swing.GroupLayout(panelBarang16);
        panelBarang16.setLayout(panelBarang16Layout);
        panelBarang16Layout.setHorizontalGroup(
            panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang16Layout.createSequentialGroup()
                .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang16Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang16Layout.createSequentialGroup()
                        .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang16Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm5))
                            .addGroup(panelBarang16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang16Layout.createSequentialGroup()
                                        .addComponent(stokminum5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel80))
                                    .addGroup(panelBarang16Layout.createSequentialGroup()
                                        .addComponent(jLabel76)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum5))))
                            .addComponent(jCheckBox29))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang16Layout.setVerticalGroup(
            panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang16Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang16Layout.createSequentialGroup()
                        .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(hargaminum5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum5)
                            .addComponent(jLabel80)))
                    .addComponent(banyak29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox29))
        );

        panelBarang17.setBackground(new java.awt.Color(0, 153, 255));

        minumanku6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm6.setText("NAMA MAKANAN");

        jLabel82.setText("Rp.");

        hargaminum6.setText("Harga");

        stokminum6.setText("123");

        jLabel85.setText("Tersedia");

        banyak30.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak30StateChanged(evt);
            }
        });

        jCheckBox36.setText("Troli");
        jCheckBox36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang17Layout = new javax.swing.GroupLayout(panelBarang17);
        panelBarang17.setLayout(panelBarang17Layout);
        panelBarang17Layout.setHorizontalGroup(
            panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang17Layout.createSequentialGroup()
                .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku6, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang17Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang17Layout.createSequentialGroup()
                        .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang17Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm6))
                            .addGroup(panelBarang17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang17Layout.createSequentialGroup()
                                        .addComponent(stokminum6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel85))
                                    .addGroup(panelBarang17Layout.createSequentialGroup()
                                        .addComponent(jLabel82)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum6))))
                            .addComponent(jCheckBox36))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang17Layout.setVerticalGroup(
            panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang17Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang17Layout.createSequentialGroup()
                        .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(hargaminum6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum6)
                            .addComponent(jLabel85)))
                    .addComponent(banyak30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox36))
        );

        panelBarang18.setBackground(new java.awt.Color(0, 153, 255));

        minumanku12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm12.setText("NAMA MAKANAN");

        jLabel87.setText("Rp.");

        hargaminum12.setText("Harga");

        stokminum12.setText("123");

        jLabel90.setText("Tersedia");

        banyak36.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak36StateChanged(evt);
            }
        });

        jCheckBox35.setText("Troli");
        jCheckBox35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang18Layout = new javax.swing.GroupLayout(panelBarang18);
        panelBarang18.setLayout(panelBarang18Layout);
        panelBarang18Layout.setHorizontalGroup(
            panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang18Layout.createSequentialGroup()
                .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku12, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang18Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak36, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang18Layout.createSequentialGroup()
                        .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang18Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm12))
                            .addGroup(panelBarang18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang18Layout.createSequentialGroup()
                                        .addComponent(stokminum12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel90))
                                    .addGroup(panelBarang18Layout.createSequentialGroup()
                                        .addComponent(jLabel87)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum12))))
                            .addComponent(jCheckBox35))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang18Layout.setVerticalGroup(
            panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang18Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang18Layout.createSequentialGroup()
                        .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(hargaminum12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum12)
                            .addComponent(jLabel90)))
                    .addComponent(banyak36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jCheckBox35))
        );

        panelBarang19.setBackground(new java.awt.Color(0, 153, 255));

        minumanku11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm11.setText("NAMA MAKANAN");

        jLabel92.setText("Rp.");

        hargaminum11.setText("Harga");

        stokminum11.setText("123");

        jLabel95.setText("Tersedia");

        banyak35.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak35StateChanged(evt);
            }
        });

        jCheckBox34.setText("Troli");
        jCheckBox34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang19Layout = new javax.swing.GroupLayout(panelBarang19);
        panelBarang19.setLayout(panelBarang19Layout);
        panelBarang19Layout.setHorizontalGroup(
            panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang19Layout.createSequentialGroup()
                .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku11, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang19Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak35, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang19Layout.createSequentialGroup()
                        .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang19Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm11))
                            .addGroup(panelBarang19Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang19Layout.createSequentialGroup()
                                        .addComponent(stokminum11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel95))
                                    .addGroup(panelBarang19Layout.createSequentialGroup()
                                        .addComponent(jLabel92)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum11))))
                            .addComponent(jCheckBox34))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang19Layout.setVerticalGroup(
            panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang19Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang19Layout.createSequentialGroup()
                        .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(hargaminum11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum11)
                            .addComponent(jLabel95)))
                    .addComponent(banyak35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox34)
                .addContainerGap())
        );

        panelBarang20.setBackground(new java.awt.Color(0, 153, 255));

        minumanku9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm9.setText("NAMA MAKANAN");

        jLabel97.setText("Rp.");

        hargaminum9.setText("Harga");

        stokminum9.setText("123");

        jLabel100.setText("Tersedia");

        banyak33.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak33StateChanged(evt);
            }
        });

        jCheckBox32.setText("Troli");
        jCheckBox32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang20Layout = new javax.swing.GroupLayout(panelBarang20);
        panelBarang20.setLayout(panelBarang20Layout);
        panelBarang20Layout.setHorizontalGroup(
            panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang20Layout.createSequentialGroup()
                .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku9, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang20Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang20Layout.createSequentialGroup()
                        .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang20Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm9))
                            .addGroup(panelBarang20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang20Layout.createSequentialGroup()
                                        .addComponent(stokminum9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel100))
                                    .addGroup(panelBarang20Layout.createSequentialGroup()
                                        .addComponent(jLabel97)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum9))))
                            .addComponent(jCheckBox32))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang20Layout.setVerticalGroup(
            panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang20Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang20Layout.createSequentialGroup()
                        .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(hargaminum9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum9)
                            .addComponent(jLabel100)))
                    .addComponent(banyak33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(jCheckBox32))
        );

        panelBarang21.setBackground(new java.awt.Color(0, 153, 255));

        minumanku10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm10.setText("NAMA MAKANAN");

        jLabel102.setText("Rp.");

        hargaminum10.setText("Harga");

        stokminum10.setText("123");

        jLabel105.setText("Tersedia");

        banyak34.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak34StateChanged(evt);
            }
        });

        jCheckBox33.setText("Troli");
        jCheckBox33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang21Layout = new javax.swing.GroupLayout(panelBarang21);
        panelBarang21.setLayout(panelBarang21Layout);
        panelBarang21Layout.setHorizontalGroup(
            panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang21Layout.createSequentialGroup()
                .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku10, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang21Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak34, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang21Layout.createSequentialGroup()
                        .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang21Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm10))
                            .addGroup(panelBarang21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang21Layout.createSequentialGroup()
                                        .addComponent(stokminum10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel105))
                                    .addGroup(panelBarang21Layout.createSequentialGroup()
                                        .addComponent(jLabel102)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum10))))
                            .addComponent(jCheckBox33))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang21Layout.setVerticalGroup(
            panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang21Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang21Layout.createSequentialGroup()
                        .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(hargaminum10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum10)
                            .addComponent(jLabel105)))
                    .addComponent(banyak34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox33))
        );

        panelBarang22.setBackground(new java.awt.Color(0, 153, 255));

        minumanku7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm7.setText("NAMA MAKANAN");

        jLabel107.setText("Rp.");

        hargaminum7.setText("Harga");

        stokminum7.setText("123");

        jLabel110.setText("Tersedia");

        banyak31.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak31StateChanged(evt);
            }
        });

        jCheckBox30.setText("Troli");
        jCheckBox30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang22Layout = new javax.swing.GroupLayout(panelBarang22);
        panelBarang22.setLayout(panelBarang22Layout);
        panelBarang22Layout.setHorizontalGroup(
            panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang22Layout.createSequentialGroup()
                .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku7, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang22Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang22Layout.createSequentialGroup()
                        .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang22Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm7))
                            .addGroup(panelBarang22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang22Layout.createSequentialGroup()
                                        .addComponent(stokminum7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel110))
                                    .addGroup(panelBarang22Layout.createSequentialGroup()
                                        .addComponent(jLabel107)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum7))))
                            .addComponent(jCheckBox30))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang22Layout.setVerticalGroup(
            panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang22Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang22Layout.createSequentialGroup()
                        .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel107)
                            .addComponent(hargaminum7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum7)
                            .addComponent(jLabel110)))
                    .addComponent(banyak31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(jCheckBox30))
        );

        panelBarang23.setBackground(new java.awt.Color(0, 153, 255));

        minumanku8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm8.setText("NAMA MAKANAN");

        jLabel112.setText("Rp.");

        hargaminum8.setText("Harga");

        stokminum8.setText("123");

        jLabel115.setText("Tersedia");

        banyak32.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak32StateChanged(evt);
            }
        });

        jCheckBox31.setText("Troli");
        jCheckBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBarang23Layout = new javax.swing.GroupLayout(panelBarang23);
        panelBarang23.setLayout(panelBarang23Layout);
        panelBarang23Layout.setHorizontalGroup(
            panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang23Layout.createSequentialGroup()
                .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanku8, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang23Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBarang23Layout.createSequentialGroup()
                        .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang23Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm8))
                            .addGroup(panelBarang23Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBarang23Layout.createSequentialGroup()
                                        .addComponent(stokminum8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel115))
                                    .addGroup(panelBarang23Layout.createSequentialGroup()
                                        .addComponent(jLabel112)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum8))))
                            .addComponent(jCheckBox31))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBarang23Layout.setVerticalGroup(
            panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang23Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanku8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang23Layout.createSequentialGroup()
                        .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(hargaminum8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum8)
                            .addComponent(jLabel115)))
                    .addComponent(banyak32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(jCheckBox31))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panelBarang8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panelBarang22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBarang17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBarang18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panelBarang8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBarang22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBarang14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBarang15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBarang20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBarang21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panelBarang13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarang23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelBarang17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBarang16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelBarang18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(panelBarang19, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)))))
                .addGap(113, 113, 113))
        );

        tabku.addTab("MINUMAN", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarang1.setBackground(new java.awt.Color(0, 153, 255));

        makangbr1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\iconku.jpg")); // NOI18N

        makan1.setText("SATE KAMBING");

        jLabel3.setText("Rp.");

        harga1.setText("50000");

        stok1.setText("123");

        jLabel6.setText("Tersedia");

        banyak1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak1StateChanged(evt);
            }
        });

        jCheckBox1.setText("TROLI");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang1Layout = new javax.swing.GroupLayout(panelBarang1);
        panelBarang1.setLayout(panelBarang1Layout);
        panelBarang1Layout.setHorizontalGroup(
            panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang1Layout.createSequentialGroup()
                        .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang1Layout.createSequentialGroup()
                                .addComponent(stok1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(panelBarang1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga1)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(panelBarang1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))))
        );
        panelBarang1Layout.setVerticalGroup(
            panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang1Layout.createSequentialGroup()
                        .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(harga1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok1)
                            .addComponent(jLabel6))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(banyak1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBox1))
                .addGap(4, 4, 4))
        );

        jPanel5.add(panelBarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 200));

        panelBarang2.setBackground(new java.awt.Color(0, 153, 255));

        makangbr3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan3.setText("NAMA MAKANAN");

        jLabel8.setText("Rp.");

        harga3.setText("Harga");

        stok3.setText("123");

        jLabel11.setText("Tersedia");

        banyak3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak3StateChanged(evt);
            }
        });

        jCheckBox3.setText("TROLI");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang2Layout = new javax.swing.GroupLayout(panelBarang2);
        panelBarang2.setLayout(panelBarang2Layout);
        panelBarang2Layout.setHorizontalGroup(
            panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang2Layout.createSequentialGroup()
                .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(makan3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBarang2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makangbr3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBarang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang2Layout.createSequentialGroup()
                        .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang2Layout.createSequentialGroup()
                                .addComponent(stok3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(panelBarang2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga3)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBarang2Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))))
        );
        panelBarang2Layout.setVerticalGroup(
            panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBarang2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(harga3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok3)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jLabel19)))
                    .addGroup(panelBarang2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(banyak3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        jPanel5.add(panelBarang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        panelBarang3.setBackground(new java.awt.Color(0, 153, 255));

        makangbr2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan2.setText("NAMA MAKANAN");

        jLabel13.setText("Rp.");

        harga2.setText("Harga");

        stok2.setText("123");

        jLabel16.setText("Tersedia");

        banyak2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak2StateChanged(evt);
            }
        });

        jCheckBox2.setText("TROLI");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang3Layout = new javax.swing.GroupLayout(panelBarang3);
        panelBarang3.setLayout(panelBarang3Layout);
        panelBarang3Layout.setHorizontalGroup(
            panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang3Layout.createSequentialGroup()
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makangbr2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addGroup(panelBarang3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(makan2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBarang3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang3Layout.createSequentialGroup()
                        .addComponent(stok2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(panelBarang3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(harga2))
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang3Layout.createSequentialGroup()
                        .addComponent(banyak2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14))))
        );
        panelBarang3Layout.setVerticalGroup(
            panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang3Layout.createSequentialGroup()
                        .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(harga2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok2)
                            .addComponent(jLabel16)))
                    .addComponent(banyak2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jCheckBox2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(panelBarang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 200));

        panelBarang5.setBackground(new java.awt.Color(0, 153, 255));

        makangbr4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan4.setText("NAMA MAKANAN");

        jLabel18.setText("Rp.");

        harga4.setText("Harga");

        stok4.setText("123");

        jLabel21.setText("Tersedia");

        banyak4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak4StateChanged(evt);
            }
        });

        jCheckBox4.setText("TROLI");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang5Layout = new javax.swing.GroupLayout(panelBarang5);
        panelBarang5.setLayout(panelBarang5Layout);
        panelBarang5Layout.setHorizontalGroup(
            panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang5Layout.createSequentialGroup()
                        .addGroup(panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang5Layout.createSequentialGroup()
                                .addComponent(stok4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addGroup(panelBarang5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga4)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBarang5Layout.createSequentialGroup()
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20))))
        );
        panelBarang5Layout.setVerticalGroup(
            panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBarang5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang5Layout.createSequentialGroup()
                                .addComponent(banyak4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(panelBarang5Layout.createSequentialGroup()
                                .addGroup(panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(harga4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelBarang5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(stok4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4))))))
        );

        jPanel5.add(panelBarang5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 150, -1));

        panelBarang6.setBackground(new java.awt.Color(0, 153, 255));

        makangbr5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan5.setText("NAMA MAKANAN");

        jLabel23.setText("Rp.");

        harga5.setText("Harga");

        stok5.setText("123");

        jLabel26.setText("Tersedia");

        banyak5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak5StateChanged(evt);
            }
        });

        jCheckBox6.setText("TROLI");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang6Layout = new javax.swing.GroupLayout(panelBarang6);
        panelBarang6.setLayout(panelBarang6Layout);
        panelBarang6Layout.setHorizontalGroup(
            panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang6Layout.createSequentialGroup()
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27))
                    .addGroup(panelBarang6Layout.createSequentialGroup()
                        .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang6Layout.createSequentialGroup()
                                .addComponent(stok5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26))
                            .addGroup(panelBarang6Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga5)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang6Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel22)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang6Layout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addGap(57, 57, 57)))
        );
        panelBarang6Layout.setVerticalGroup(
            panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang6Layout.createSequentialGroup()
                        .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(harga5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok5)
                            .addComponent(jLabel26)))
                    .addComponent(banyak5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox6)
                    .addComponent(jLabel27)))
            .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang6Layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(jLabel22)
                    .addContainerGap(91, Short.MAX_VALUE)))
            .addGroup(panelBarang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang6Layout.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addGap(81, 81, 81)))
        );

        jPanel5.add(panelBarang6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 200));

        panelBarang7.setBackground(new java.awt.Color(0, 153, 255));

        makangbr6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan6.setText("NAMA MAKANAN");

        jLabel28.setText("Rp.");

        harga6.setText("Harga");

        stok6.setText("123");

        jLabel31.setText("Tersedia");

        banyak6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak6StateChanged(evt);
            }
        });

        jCheckBox5.setText("TROLI");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jLabel29.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang7Layout = new javax.swing.GroupLayout(panelBarang7);
        panelBarang7.setLayout(panelBarang7Layout);
        panelBarang7Layout.setHorizontalGroup(
            panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang7Layout.createSequentialGroup()
                .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makangbr6, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addGroup(panelBarang7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(makan6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBarang7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang7Layout.createSequentialGroup()
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29))
                    .addGroup(panelBarang7Layout.createSequentialGroup()
                        .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang7Layout.createSequentialGroup()
                                .addComponent(stok6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31))
                            .addGroup(panelBarang7Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga6)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBarang7Layout.setVerticalGroup(
            panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang7Layout.createSequentialGroup()
                        .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(harga6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok6)
                            .addComponent(jLabel31)))
                    .addComponent(banyak6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(panelBarang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(jLabel29)))
        );

        jPanel5.add(panelBarang7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 152, 200));

        panelBarang4.setBackground(new java.awt.Color(0, 153, 255));

        makangbr7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan7.setText("NAMA MAKANAN");

        jLabel50.setText("Rp.");

        harga7.setText("Harga");

        stok7.setText("123");

        jLabel53.setText("Tersedia");

        banyak7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak7StateChanged(evt);
            }
        });

        jCheckBox7.setText("TROLI");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang4Layout = new javax.swing.GroupLayout(panelBarang4);
        panelBarang4.setLayout(panelBarang4Layout);
        panelBarang4Layout.setHorizontalGroup(
            panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang4Layout.createSequentialGroup()
                .addGroup(panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makangbr7, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addGroup(panelBarang4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(makan7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBarang4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang4Layout.createSequentialGroup()
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30))
                    .addGroup(panelBarang4Layout.createSequentialGroup()
                        .addGroup(panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang4Layout.createSequentialGroup()
                                .addComponent(stok7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53))
                            .addGroup(panelBarang4Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga7)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBarang4Layout.setVerticalGroup(
            panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang4Layout.createSequentialGroup()
                        .addGroup(panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(harga7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok7)
                            .addComponent(jLabel53)))
                    .addComponent(banyak7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jCheckBox7))
            .addGroup(panelBarang4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30))
        );

        jPanel5.add(panelBarang4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        panelBarang9.setBackground(new java.awt.Color(0, 153, 255));

        makangbr9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan9.setText("NAMA MAKANAN");

        jLabel55.setText("Rp.");

        harga9.setText("Harga");

        stok9.setText("123");

        jLabel58.setText("Tersedia");

        banyak9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak9StateChanged(evt);
            }
        });

        jCheckBox9.setText("TROLI");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jLabel69.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel74.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel77.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang9Layout = new javax.swing.GroupLayout(panelBarang9);
        panelBarang9.setLayout(panelBarang9Layout);
        panelBarang9Layout.setHorizontalGroup(
            panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr9, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox9)
                    .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBarang9Layout.createSequentialGroup()
                            .addComponent(stok9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel58))
                        .addGroup(panelBarang9Layout.createSequentialGroup()
                            .addComponent(jLabel55)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(harga9))))
                .addGap(18, 18, 18)
                .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang9Layout.createSequentialGroup()
                        .addComponent(banyak9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel77))))
            .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang9Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel69)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang9Layout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jLabel74)
                    .addGap(57, 57, 57)))
        );
        panelBarang9Layout.setVerticalGroup(
            panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang9Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang9Layout.createSequentialGroup()
                        .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang9Layout.createSequentialGroup()
                                .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel55)
                                    .addComponent(harga9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stok9)
                                    .addComponent(jLabel58)))
                            .addComponent(banyak9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jCheckBox9))
                    .addGroup(panelBarang9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel77))))
            .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang9Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel69)
                    .addContainerGap(89, Short.MAX_VALUE)))
            .addGroup(panelBarang9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang9Layout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jLabel74)
                    .addGap(79, 79, 79)))
        );

        jPanel5.add(panelBarang9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, 197));

        panelBarang10.setBackground(new java.awt.Color(0, 153, 255));

        makangbr8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan8.setText("NAMA MAKANAN");

        jLabel60.setText("Rp.");

        harga8.setText("Harga");

        stok8.setText("123");

        jLabel63.setText("Tersedia");

        banyak8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak8StateChanged(evt);
            }
        });

        jCheckBox8.setText("TROLI");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang10Layout = new javax.swing.GroupLayout(panelBarang10);
        panelBarang10.setLayout(panelBarang10Layout);
        panelBarang10Layout.setHorizontalGroup(
            panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr8, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang10Layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38))
                    .addGroup(panelBarang10Layout.createSequentialGroup()
                        .addGroup(panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang10Layout.createSequentialGroup()
                                .addComponent(stok8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel63))
                            .addGroup(panelBarang10Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga8)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang10Layout.setVerticalGroup(
            panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang10Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang10Layout.createSequentialGroup()
                        .addGroup(panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(harga8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok8)
                            .addComponent(jLabel63)))
                    .addComponent(banyak8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel38)))
        );

        jPanel5.add(panelBarang10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, 197));

        panelBarang11.setBackground(new java.awt.Color(0, 153, 255));

        makangbr10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan10.setText("NAMA MAKANAN");

        jLabel65.setText("Rp.");

        harga10.setText("Harga");

        stok10.setText("123");

        jLabel68.setText("Tersedia");

        banyak10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak10StateChanged(evt);
            }
        });

        jCheckBox10.setText("TROLI");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang11Layout = new javax.swing.GroupLayout(panelBarang11);
        panelBarang11.setLayout(panelBarang11Layout);
        panelBarang11Layout.setHorizontalGroup(
            panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr10, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang11Layout.createSequentialGroup()
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel40))
                    .addGroup(panelBarang11Layout.createSequentialGroup()
                        .addGroup(panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang11Layout.createSequentialGroup()
                                .addComponent(stok10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel68))
                            .addGroup(panelBarang11Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga10)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang11Layout.setVerticalGroup(
            panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang11Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang11Layout.createSequentialGroup()
                        .addGroup(panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBarang11Layout.createSequentialGroup()
                                .addGroup(panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel65)
                                    .addComponent(harga10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBarang11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stok10)
                                    .addComponent(jLabel68)))
                            .addComponent(banyak10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jCheckBox10))
                    .addGroup(panelBarang11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel40))))
        );

        jPanel5.add(panelBarang11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, 197));

        panelBarang12.setBackground(new java.awt.Color(0, 153, 255));

        makangbr11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan11.setText("NAMA MAKANAN");

        jLabel70.setText("Rp.");

        harga11.setText("Harga");

        stok11.setText("123");

        jLabel73.setText("Tersedia");

        banyak11.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak11StateChanged(evt);
            }
        });

        jCheckBox11.setText("TROLI");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        jLabel43.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang12Layout = new javax.swing.GroupLayout(panelBarang12);
        panelBarang12.setLayout(panelBarang12Layout);
        panelBarang12Layout.setHorizontalGroup(
            panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr11, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang12Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan11)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang12Layout.createSequentialGroup()
                        .addComponent(jCheckBox11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43))
                    .addGroup(panelBarang12Layout.createSequentialGroup()
                        .addGroup(panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang12Layout.createSequentialGroup()
                                .addComponent(stok11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel73))
                            .addGroup(panelBarang12Layout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga11)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang12Layout.setVerticalGroup(
            panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang12Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang12Layout.createSequentialGroup()
                        .addGroup(panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBarang12Layout.createSequentialGroup()
                                .addGroup(panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel70)
                                    .addComponent(harga11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBarang12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stok11)
                                    .addComponent(jLabel73)))
                            .addComponent(banyak11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jCheckBox11))
                    .addGroup(panelBarang12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel43))))
        );

        jPanel5.add(panelBarang12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, 197));

        panel12.setBackground(new java.awt.Color(0, 153, 255));

        makangbr12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan12.setText("NAMA MAKANAN");

        jLabel75.setText("Rp.");

        harga12.setText("Harga");

        stok12.setText("123");

        jLabel78.setText("Tersedia");

        banyak12.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak12StateChanged(evt);
            }
        });

        jCheckBox12.setText("TROLI");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        jLabel44.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panel12Layout = new javax.swing.GroupLayout(panel12);
        panel12.setLayout(panel12Layout);
        panel12Layout.setHorizontalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr12, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panel12Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan12)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel44))
                    .addGroup(panel12Layout.createSequentialGroup()
                        .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel12Layout.createSequentialGroup()
                                .addComponent(stok12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel78))
                            .addGroup(panel12Layout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga12)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panel12Layout.setVerticalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel12Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel12Layout.createSequentialGroup()
                        .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel12Layout.createSequentialGroup()
                                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel75)
                                    .addComponent(harga12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stok12)
                                    .addComponent(jLabel78)))
                            .addComponent(banyak12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jCheckBox12))
                    .addGroup(panel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel44))))
        );

        jPanel5.add(panel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, -1, 197));

        panelBarang36.setBackground(new java.awt.Color(0, 153, 255));

        makangbr13.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan13.setText("NAMA MAKANAN");

        jLabel176.setText("Rp.");

        harga13.setText("Harga");

        stok13.setText("123");

        jLabel177.setText("Tersedia");

        banyak13.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak13StateChanged(evt);
            }
        });

        jCheckBox13.setText("TROLI");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        jLabel46.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel47.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel49.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang36Layout = new javax.swing.GroupLayout(panelBarang36);
        panelBarang36.setLayout(panelBarang36Layout);
        panelBarang36Layout.setHorizontalGroup(
            panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr13, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang36Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang36Layout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel49))
                    .addGroup(panelBarang36Layout.createSequentialGroup()
                        .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang36Layout.createSequentialGroup()
                                .addComponent(stok13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel177))
                            .addGroup(panelBarang36Layout.createSequentialGroup()
                                .addComponent(jLabel176)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga13)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang36Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel46)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang36Layout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jLabel47)
                    .addGap(57, 57, 57)))
        );
        panelBarang36Layout.setVerticalGroup(
            panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang36Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang36Layout.createSequentialGroup()
                        .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel176)
                            .addComponent(harga13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok13)
                            .addComponent(jLabel177)))
                    .addComponent(banyak13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox13)
                    .addComponent(jLabel49)))
            .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang36Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel46)
                    .addContainerGap(89, Short.MAX_VALUE)))
            .addGroup(panelBarang36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang36Layout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jLabel47)
                    .addGap(79, 79, 79)))
        );

        jPanel5.add(panelBarang36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        panelBarang37.setBackground(new java.awt.Color(0, 153, 255));

        makangbr14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan14.setText("NAMA MAKANAN");

        jLabel178.setText("Rp.");

        harga14.setText("Harga");

        stok14.setText("123");

        jLabel179.setText("Tersedia");

        banyak14.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak14StateChanged(evt);
            }
        });

        jCheckBox14.setText("TROLI");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        jLabel52.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang37Layout = new javax.swing.GroupLayout(panelBarang37);
        panelBarang37.setLayout(panelBarang37Layout);
        panelBarang37Layout.setHorizontalGroup(
            panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr14, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang37Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang37Layout.createSequentialGroup()
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel52))
                    .addGroup(panelBarang37Layout.createSequentialGroup()
                        .addGroup(panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang37Layout.createSequentialGroup()
                                .addComponent(stok14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel179))
                            .addGroup(panelBarang37Layout.createSequentialGroup()
                                .addComponent(jLabel178)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga14)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang37Layout.setVerticalGroup(
            panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang37Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang37Layout.createSequentialGroup()
                        .addGroup(panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel178)
                            .addComponent(harga14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok14)
                            .addComponent(jLabel179)))
                    .addComponent(banyak14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox14)
                    .addComponent(jLabel52)))
        );

        jPanel5.add(panelBarang37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, -1));

        panelBarang38.setBackground(new java.awt.Color(0, 153, 255));

        makangbr15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan15.setText("NAMA MAKANAN");

        jLabel180.setText("Rp.");

        harga15.setText("Harga");

        stok15.setText("123");

        jLabel181.setText("Tersedia");

        banyak15.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak15StateChanged(evt);
            }
        });

        jCheckBox15.setText("TROLI");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        jLabel54.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang38Layout = new javax.swing.GroupLayout(panelBarang38);
        panelBarang38.setLayout(panelBarang38Layout);
        panelBarang38Layout.setHorizontalGroup(
            panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr15, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang38Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan15)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang38Layout.createSequentialGroup()
                        .addComponent(jCheckBox15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel54))
                    .addGroup(panelBarang38Layout.createSequentialGroup()
                        .addGroup(panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang38Layout.createSequentialGroup()
                                .addComponent(stok15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel181))
                            .addGroup(panelBarang38Layout.createSequentialGroup()
                                .addComponent(jLabel180)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga15)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang38Layout.setVerticalGroup(
            panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang38Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang38Layout.createSequentialGroup()
                        .addGroup(panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel180)
                            .addComponent(harga15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok15)
                            .addComponent(jLabel181)))
                    .addComponent(banyak15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox15)
                    .addComponent(jLabel54)))
        );

        jPanel5.add(panelBarang38, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, 197));

        panelBarang39.setBackground(new java.awt.Color(0, 153, 255));

        makangbr16.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan16.setText("NAMA MAKANAN");

        jLabel182.setText("Rp.");

        harga16.setText("Harga");

        stok16.setText("123");

        jLabel183.setText("Tersedia");

        banyak16.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak16StateChanged(evt);
            }
        });

        jCheckBox16.setText("TROLI");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        jLabel57.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang39Layout = new javax.swing.GroupLayout(panelBarang39);
        panelBarang39.setLayout(panelBarang39Layout);
        panelBarang39Layout.setHorizontalGroup(
            panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr16, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang39Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan16)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang39Layout.createSequentialGroup()
                        .addComponent(jCheckBox16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel57))
                    .addGroup(panelBarang39Layout.createSequentialGroup()
                        .addGroup(panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang39Layout.createSequentialGroup()
                                .addComponent(stok16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel183))
                            .addGroup(panelBarang39Layout.createSequentialGroup()
                                .addComponent(jLabel182)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga16)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang39Layout.setVerticalGroup(
            panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang39Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang39Layout.createSequentialGroup()
                        .addGroup(panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel182)
                            .addComponent(harga16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok16)
                            .addComponent(jLabel183)))
                    .addComponent(banyak16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox16)
                    .addComponent(jLabel57)))
        );

        jPanel5.add(panelBarang39, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, -1, 197));

        panelBarang40.setBackground(new java.awt.Color(0, 153, 255));

        makangbr17.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan17.setText("NAMA MAKANAN");

        jLabel184.setText("Rp.");

        harga17.setText("Harga");

        stok17.setText("123");

        jLabel185.setText("Tersedia");

        banyak17.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak17StateChanged(evt);
            }
        });

        jCheckBox17.setText("TROLI");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jLabel61.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang40Layout = new javax.swing.GroupLayout(panelBarang40);
        panelBarang40.setLayout(panelBarang40Layout);
        panelBarang40Layout.setHorizontalGroup(
            panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr17, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang40Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan17)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang40Layout.createSequentialGroup()
                        .addComponent(jCheckBox17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel61))
                    .addGroup(panelBarang40Layout.createSequentialGroup()
                        .addGroup(panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang40Layout.createSequentialGroup()
                                .addComponent(stok17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel185))
                            .addGroup(panelBarang40Layout.createSequentialGroup()
                                .addComponent(jLabel184)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga17)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang40Layout.setVerticalGroup(
            panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang40Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang40Layout.createSequentialGroup()
                        .addGroup(panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel184)
                            .addComponent(harga17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok17)
                            .addComponent(jLabel185)))
                    .addComponent(banyak17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox17)
                    .addComponent(jLabel61)))
        );

        jPanel5.add(panelBarang40, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, 197));

        panelBarang41.setBackground(new java.awt.Color(0, 153, 255));

        makangbr18.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan18.setText("NAMA MAKANAN");

        jLabel186.setText("Rp.");

        harga18.setText("Harga");

        stok18.setText("123");

        jLabel187.setText("Tersedia");

        banyak18.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak18StateChanged(evt);
            }
        });

        jCheckBox18.setText("TROLI");
        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });

        jLabel62.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel66.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        jLabel79.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang41Layout = new javax.swing.GroupLayout(panelBarang41);
        panelBarang41.setLayout(panelBarang41Layout);
        panelBarang41Layout.setHorizontalGroup(
            panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr18, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang41Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan18)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang41Layout.createSequentialGroup()
                        .addComponent(jCheckBox18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel79))
                    .addGroup(panelBarang41Layout.createSequentialGroup()
                        .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang41Layout.createSequentialGroup()
                                .addComponent(stok18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel187))
                            .addGroup(panelBarang41Layout.createSequentialGroup()
                                .addComponent(jLabel186)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga18)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang41Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel62)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang41Layout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jLabel66)
                    .addGap(57, 57, 57)))
        );
        panelBarang41Layout.setVerticalGroup(
            panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang41Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr18, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang41Layout.createSequentialGroup()
                        .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel186)
                            .addComponent(harga18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok18)
                            .addComponent(jLabel187)))
                    .addComponent(banyak18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox18)
                    .addComponent(jLabel79)))
            .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBarang41Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel62)
                    .addContainerGap(89, Short.MAX_VALUE)))
            .addGroup(panelBarang41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang41Layout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jLabel66)
                    .addGap(79, 79, 79)))
        );

        jPanel5.add(panelBarang41, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, -1, 197));

        panelBarang42.setBackground(new java.awt.Color(0, 153, 255));

        makangbr19.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan19.setText("NAMA MAKANAN");

        jLabel188.setText("Rp.");

        harga19.setText("Harga");

        stok19.setText("123");

        jLabel189.setText("Tersedia");

        banyak19.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak19StateChanged(evt);
            }
        });

        jCheckBox19.setText("TROLI");
        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });

        jLabel84.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang42Layout = new javax.swing.GroupLayout(panelBarang42);
        panelBarang42.setLayout(panelBarang42Layout);
        panelBarang42Layout.setHorizontalGroup(
            panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr19, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang42Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan19)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang42Layout.createSequentialGroup()
                        .addComponent(jCheckBox19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel84))
                    .addGroup(panelBarang42Layout.createSequentialGroup()
                        .addGroup(panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang42Layout.createSequentialGroup()
                                .addComponent(stok19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel189))
                            .addGroup(panelBarang42Layout.createSequentialGroup()
                                .addComponent(jLabel188)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga19)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang42Layout.setVerticalGroup(
            panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang42Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang42Layout.createSequentialGroup()
                        .addGroup(panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel188)
                            .addComponent(harga19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok19)
                            .addComponent(jLabel189)))
                    .addComponent(banyak19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox19)
                    .addComponent(jLabel84)))
        );

        jPanel5.add(panelBarang42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, 197));

        panelBarang43.setBackground(new java.awt.Color(0, 153, 255));

        makangbr20.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan20.setText("NAMA MAKANAN");

        jLabel190.setText("Rp.");

        harga20.setText("Harga");

        stok20.setText("123");

        jLabel191.setText("Tersedia");

        banyak20.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak20StateChanged(evt);
            }
        });

        jCheckBox20.setText("TROLI");
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });

        jLabel89.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang43Layout = new javax.swing.GroupLayout(panelBarang43);
        panelBarang43.setLayout(panelBarang43Layout);
        panelBarang43Layout.setHorizontalGroup(
            panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr20, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang43Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan20)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang43Layout.createSequentialGroup()
                        .addComponent(jCheckBox20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel89))
                    .addGroup(panelBarang43Layout.createSequentialGroup()
                        .addGroup(panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang43Layout.createSequentialGroup()
                                .addComponent(stok20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel191))
                            .addGroup(panelBarang43Layout.createSequentialGroup()
                                .addComponent(jLabel190)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga20)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang43Layout.setVerticalGroup(
            panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang43Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang43Layout.createSequentialGroup()
                        .addGroup(panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel190)
                            .addComponent(harga20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok20)
                            .addComponent(jLabel191)))
                    .addComponent(banyak20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox20)
                    .addComponent(jLabel89)))
        );

        jPanel5.add(panelBarang43, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, -1, 197));

        panelBarang44.setBackground(new java.awt.Color(0, 153, 255));

        makangbr21.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan21.setText("NAMA MAKANAN");

        jLabel192.setText("Rp.");

        harga21.setText("Harga");

        stok21.setText("123");

        jLabel193.setText("Tersedia");

        banyak21.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak21StateChanged(evt);
            }
        });

        jCheckBox21.setText("TROLI");
        jCheckBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox21ActionPerformed(evt);
            }
        });

        jLabel94.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang44Layout = new javax.swing.GroupLayout(panelBarang44);
        panelBarang44.setLayout(panelBarang44Layout);
        panelBarang44Layout.setHorizontalGroup(
            panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr21, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang44Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan21)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang44Layout.createSequentialGroup()
                        .addComponent(jCheckBox21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel94))
                    .addGroup(panelBarang44Layout.createSequentialGroup()
                        .addGroup(panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang44Layout.createSequentialGroup()
                                .addComponent(stok21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel193))
                            .addGroup(panelBarang44Layout.createSequentialGroup()
                                .addComponent(jLabel192)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga21)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang44Layout.setVerticalGroup(
            panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang44Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang44Layout.createSequentialGroup()
                        .addGroup(panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel192)
                            .addComponent(harga21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok21)
                            .addComponent(jLabel193)))
                    .addComponent(banyak21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox21)
                    .addComponent(jLabel94)))
        );

        jPanel5.add(panelBarang44, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, -1, 197));

        panelBarang45.setBackground(new java.awt.Color(0, 153, 255));

        makangbr22.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan22.setText("NAMA MAKANAN");

        jLabel194.setText("Rp.");

        harga22.setText("Harga");

        stok22.setText("123");

        jLabel195.setText("Tersedia");

        banyak22.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak22StateChanged(evt);
            }
        });

        jCheckBox22.setText("TROLI");
        jCheckBox22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox22ActionPerformed(evt);
            }
        });

        jLabel99.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang45Layout = new javax.swing.GroupLayout(panelBarang45);
        panelBarang45.setLayout(panelBarang45Layout);
        panelBarang45Layout.setHorizontalGroup(
            panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr22, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang45Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan22)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang45Layout.createSequentialGroup()
                        .addComponent(jCheckBox22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel99))
                    .addGroup(panelBarang45Layout.createSequentialGroup()
                        .addGroup(panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang45Layout.createSequentialGroup()
                                .addComponent(stok22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel195))
                            .addGroup(panelBarang45Layout.createSequentialGroup()
                                .addComponent(jLabel194)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga22)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang45Layout.setVerticalGroup(
            panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang45Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang45Layout.createSequentialGroup()
                        .addGroup(panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel194)
                            .addComponent(harga22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok22)
                            .addComponent(jLabel195)))
                    .addComponent(banyak22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox22)
                    .addComponent(jLabel99)))
        );

        jPanel5.add(panelBarang45, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 660, -1, 197));

        panelBarang46.setBackground(new java.awt.Color(0, 153, 255));

        makangbr23.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan23.setText("NAMA MAKANAN");

        jLabel196.setText("Rp.");

        harga23.setText("Harga");

        stok23.setText("123");

        jLabel197.setText("Tersedia");

        banyak23.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak23StateChanged(evt);
            }
        });

        jCheckBox23.setText("TROLI");
        jCheckBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox23ActionPerformed(evt);
            }
        });

        jLabel104.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang46Layout = new javax.swing.GroupLayout(panelBarang46);
        panelBarang46.setLayout(panelBarang46Layout);
        panelBarang46Layout.setHorizontalGroup(
            panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr23, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang46Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan23)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang46Layout.createSequentialGroup()
                        .addComponent(jCheckBox23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel104))
                    .addGroup(panelBarang46Layout.createSequentialGroup()
                        .addGroup(panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang46Layout.createSequentialGroup()
                                .addComponent(stok23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel197))
                            .addGroup(panelBarang46Layout.createSequentialGroup()
                                .addComponent(jLabel196)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga23)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang46Layout.setVerticalGroup(
            panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang46Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBarang46Layout.createSequentialGroup()
                        .addGroup(panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel196)
                            .addComponent(harga23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok23)
                            .addComponent(jLabel197)))
                    .addComponent(banyak23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelBarang46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox23)
                    .addComponent(jLabel104)))
        );

        jPanel5.add(panelBarang46, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, -1, 197));

        panelBarang47.setBackground(new java.awt.Color(0, 153, 255));

        makangbr24.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        makan24.setText("NAMA MAKANAN");

        jLabel198.setText("Rp.");

        harga24.setText("Harga");

        stok24.setText("123");

        jLabel199.setText("Tersedia");

        banyak24.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak24StateChanged(evt);
            }
        });

        jCheckBox24.setText("TROLI");
        jCheckBox24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox24ActionPerformed(evt);
            }
        });

        jLabel109.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\komposisi.png")); // NOI18N

        javax.swing.GroupLayout panelBarang47Layout = new javax.swing.GroupLayout(panelBarang47);
        panelBarang47.setLayout(panelBarang47Layout);
        panelBarang47Layout.setHorizontalGroup(
            panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makangbr24, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBarang47Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(makan24)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarang47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang47Layout.createSequentialGroup()
                        .addComponent(jCheckBox24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel109))
                    .addGroup(panelBarang47Layout.createSequentialGroup()
                        .addGroup(panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBarang47Layout.createSequentialGroup()
                                .addComponent(stok24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel199))
                            .addGroup(panelBarang47Layout.createSequentialGroup()
                                .addComponent(jLabel198)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga24)))
                        .addGap(18, 18, 18)
                        .addComponent(banyak24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBarang47Layout.setVerticalGroup(
            panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang47Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(makan24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makangbr24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarang47Layout.createSequentialGroup()
                        .addGroup(panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBarang47Layout.createSequentialGroup()
                                .addGroup(panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel198)
                                    .addComponent(harga24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBarang47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stok24)
                                    .addComponent(jLabel199)))
                            .addComponent(banyak24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jCheckBox24))
                    .addGroup(panelBarang47Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel109))))
        );

        jPanel5.add(panelBarang47, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 660, -1, 197));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 870, -1, 50));

        jScrollPane5.setViewportView(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabku.addTab("MAKANAN", jPanel1);

        panelcaribarang.setBackground(new java.awt.Color(0, 153, 255));

        gami9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\umi.png")); // NOI18N

        minumm13.setText("NAMA MAKANAN");

        jLabel81.setText("Rp.");

        hargaminum13.setText("Harga");

        stokminum13.setText("123");

        jLabel83.setText("Tersedia");

        banyak37.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                banyak37StateChanged(evt);
            }
        });

        jCheckBox37.setText("Troli");
        jCheckBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelcaribarangLayout = new javax.swing.GroupLayout(panelcaribarang);
        panelcaribarang.setLayout(panelcaribarangLayout);
        panelcaribarangLayout.setHorizontalGroup(
            panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcaribarangLayout.createSequentialGroup()
                .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcaribarangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gami9, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcaribarangLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(banyak37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelcaribarangLayout.createSequentialGroup()
                        .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelcaribarangLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(minumm13))
                            .addGroup(panelcaribarangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelcaribarangLayout.createSequentialGroup()
                                        .addComponent(stokminum13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel83))
                                    .addGroup(panelcaribarangLayout.createSequentialGroup()
                                        .addComponent(jLabel81)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hargaminum13))))
                            .addComponent(jCheckBox37))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelcaribarangLayout.setVerticalGroup(
            panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcaribarangLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(minumm13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gami9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelcaribarangLayout.createSequentialGroup()
                        .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(hargaminum13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelcaribarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stokminum13)
                            .addComponent(jLabel83)))
                    .addComponent(banyak37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jCheckBox37))
        );

        javax.swing.GroupLayout pencariantabLayout = new javax.swing.GroupLayout(pencariantab);
        pencariantab.setLayout(pencariantabLayout);
        pencariantabLayout.setHorizontalGroup(
            pencariantabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pencariantabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(880, Short.MAX_VALUE))
        );
        pencariantabLayout.setVerticalGroup(
            pencariantabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pencariantabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        tabku.addTab("tab3", pencariantab);

        cari.setAnimationColor(new java.awt.Color(102, 255, 255));
        cari.setHintText("Cari Menu ");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariKeyTyped(evt);
            }
        });

        myButton2.setText("LOGOUT");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneltengahLayout = new javax.swing.GroupLayout(paneltengah);
        paneltengah.setLayout(paneltengahLayout);
        paneltengahLayout.setHorizontalGroup(
            paneltengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltengahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltengahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(477, 477, 477))
            .addGroup(paneltengahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneltengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        paneltengahLayout.setVerticalGroup(
            paneltengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltengahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabku, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(760, 760, 760)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377))
        );

        panelsudut.setBackground(new java.awt.Color(102, 255, 255));

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("DISKON BESAR BESARAN SUPER BUNDLE");

        myButton1.setText("BELI SEKARANG");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        jamlabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jamlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jamlabel.setText("00");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jamlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jamlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menitlabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        menitlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menitlabel.setText("00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menitlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(menitlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        detiklabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        detiklabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detiklabel.setText("00");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(detiklabel, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(detiklabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel35.setText("jLabel35");

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Berakhir Dalam :");

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("JANGAN SAMPAI KEHABISAN YA");

        javax.swing.GroupLayout panelsudutLayout = new javax.swing.GroupLayout(panelsudut);
        panelsudut.setLayout(panelsudutLayout);
        panelsudutLayout.setHorizontalGroup(
            panelsudutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsudutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsudutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel34)
                    .addGroup(panelsudutLayout.createSequentialGroup()
                        .addGroup(panelsudutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelsudutLayout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36)
                            .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(224, 224, Short.MAX_VALUE))
        );
        panelsudutLayout.setVerticalGroup(
            panelsudutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsudutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsudutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsudutLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel42)
                        .addGap(12, 20, Short.MAX_VALUE))
                    .addGroup(panelsudutLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelsudutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelsudut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsudut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelatas.setBackground(new java.awt.Color(51, 255, 255));

        uc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uc.setText("Selamat Siang Frans");

        jLabel41.setText("KUMPULKAN KOIN UNTUK MENDAPATKAN BONUS ");

        historyOrder.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\akun.png")); // NOI18N
        historyOrder.setText("KUMPULKAN KOIN UNTUK MENDAPATKAN BONUS DAN HADIAH MENARIK");
        historyOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyOrderMouseClicked(evt);
            }
        });

        gami8.setText("RIWAYAT ");

        latar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                latarMouseClicked(evt);
            }
        });

        jLabel4.setText("Mode Gelap");

        uc1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        uc1.setText("RESTORAN MONTAGNE BLUE");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\restoran.png")); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\notif.png")); // NOI18N

        jLabel12.setText("NOTIFIKASI");

        jLabel86.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\tentang.png")); // NOI18N
        jLabel86.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
        });

        jLabel88.setText("TENTANG");

        javax.swing.GroupLayout panelatasLayout = new javax.swing.GroupLayout(panelatas);
        panelatas.setLayout(panelatasLayout);
        panelatasLayout.setHorizontalGroup(
            panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(uc, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelatasLayout.createSequentialGroup()
                        .addComponent(uc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelrestoran, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelatasLayout.createSequentialGroup()
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel88)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelatasLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelatasLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)))
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(historyOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gami8))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelatasLayout.createSequentialGroup()
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(latar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );
        panelatasLayout.setVerticalGroup(
            panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelatasLayout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uc1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(uc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel41))
                    .addGroup(panelatasLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(latar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelatasLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(historyOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gami8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel88)))
                    .addGroup(panelatasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelrestoran, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pesanMakan.setColumns(20);
        pesanMakan.setRows(5);
        jScrollPane1.setViewportView(pesanMakan);

        jButton1.setText("BAYAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("REFRESH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneltengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelsamping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hargaa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(hargaa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paneltengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelsamping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//      final int maxX = 450 ;
//      final int maxY = 50 ;
//      Thread Animasi = new Thread(new Runnable(){
//          @Override
//          public void run() {
//              int x = 10 ;
//              int y = 10 ;
//              while(true)
//              {
//                  uc.setLocation(x, y);
//                  x += 10 ;
//                  try {
//                      Thread.sleep(200);
//                  } catch(Exception e)
//                  {
//                      
//                  }
//              }
//         
//          }
//          
//      });
//      Animasi.start();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//   MessageDialog obj = new MessageDialog(this);
//        obj.showMessage("Restoran Montagne Blue", "Apakah anda yajin Ingin Mengkonfirmasi Semua Pembelian Yang Ada di Troli Anda Selanjutnya Akan Ke menu Pembayaran.");
//        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
//            System.out.println("User click ok");
//               Pembayaran bayar = new Pembayaran();
////          bayar.menumakanan.append(semua);
////          bayar.menumakanan.setText(semua);
//          bayar.setVisible(true);
////          this.dispose();
//            
//        } else {
//            System.out.println("User click cancel");
//            this.dispose();
//        }
//         Pembayaran bayar = new Pembayaran();
//            bayar.menumakanan.setText(semua);
          Pembayaran bayar = new Pembayaran();
//          bayar.menumakanan.append(semua);
          totalMakanan = pesanMakan.getText();
          totalHargaMakan = hargaaMakan.getText();
          bayar.setVisible(true);
//          this.dispose();
           
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jCheckBox1.setSelected(false);
          jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
              jCheckBox4.setSelected(false);
                jCheckBox5.setSelected(false);
                  jCheckBox6.setSelected(false);
                    jCheckBox7.setSelected(false);
                      jCheckBox8.setSelected(false);
                        jCheckBox9.setSelected(false);
                          jCheckBox10.setSelected(false);
                            jCheckBox11.setSelected(false);
                              jCheckBox12.setSelected(false);
                              jCheckBox13.setSelected(false);
                              jCheckBox14.setSelected(false);
                              jCheckBox15.setSelected(false);
                              jCheckBox16.setSelected(false);
                              jCheckBox17.setSelected(false);
                              jCheckBox18.setSelected(false);
                              jCheckBox19.setSelected(false);
                              jCheckBox20.setSelected(false);
                              jCheckBox21.setSelected(false);
                              jCheckBox22.setSelected(false);
                              jCheckBox23.setSelected(false);
                              jCheckBox24.setSelected(false);
                              jCheckBox25.setSelected(false);
                              jCheckBox26.setSelected(false);
                              jCheckBox27.setSelected(false);
                              jCheckBox28.setSelected(false);
                              jCheckBox29.setSelected(false);
                              jCheckBox30.setSelected(false);
                              jCheckBox31.setSelected(false);
                              jCheckBox32.setSelected(false);
                              jCheckBox33.setSelected(false);
                              jCheckBox34.setSelected(false);
                              jCheckBox35.setSelected(false);
                              jCheckBox36.setSelected(false);
                              banyak1.setValue(0);
                                banyak2.setValue(0);
                                  banyak3.setValue(0);
                                    banyak4.setValue(0);
                                      banyak5.setValue(0);
                                        banyak6.setValue(0);
                                          banyak7.setValue(0);
                                            banyak8.setValue(0);
                                    banyak9.setValue(0);
                                      banyak10.setValue(0);
                                        banyak11.setValue(0);
                                          banyak12.setValue(0);
                                          banyak13.setValue(0);
                                          banyak14.setValue(0);
                                          banyak15.setValue(0);
                                          banyak16.setValue(0);
                                          banyak17.setValue(0);
                                          banyak18.setValue(0);
                                          banyak19.setValue(0);
                                          banyak20.setValue(0);
                                          banyak21.setValue(0);
                                          banyak22.setValue(0);
                                          banyak23.setValue(0);
                                          banyak24.setValue(0);
                                          banyak25.setValue(0);
                                          banyak26.setValue(0);
                                          banyak27.setValue(0);
                                          banyak28.setValue(0);
                                          banyak29.setValue(0);
                                          banyak30.setValue(0);
                                          banyak31.setValue(0);
                                          banyak32.setValue(0);
                                          banyak33.setValue(0);
                                          banyak34.setValue(0);
                                          banyak35.setValue(0);
                                          banyak36.setValue(0);
//                                            banyak1.setValue(0);
        pesanMakan.setText("");
        hargaaMakan.setText("");
        totalSemua.setText("");
        totalmenu.setText("");
        jCheckBox1.setEnabled(true);
          jCheckBox2.setEnabled(true);
            jCheckBox3.setEnabled(true);
              jCheckBox4.setEnabled(true);
                jCheckBox5.setEnabled(true);
                  jCheckBox6.setEnabled(true);
                    jCheckBox7.setEnabled(true);
                      jCheckBox8.setEnabled(true);
                        jCheckBox9.setEnabled(true);
                          jCheckBox11.setEnabled(true);
                            jCheckBox12.setEnabled(true);
                            qty.setText("");
                            subTotal = "";
                            nTotal = 0 ;
//                              jCheckBox1.setEnabled(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void latarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_latarMouseClicked
        // TODO add your handling code here:
        nGelap++;
           if(nGelap%2==0)
        {
            // [102,102,102]
            panelatas.setBackground(new Color(102,102,102));
            paneltengah.setBackground(new Color(102,102,102));
             panelsudut.setBackground(new Color(102,102,102));
              panelsamping.setBackground(new Color(102,102,102));
        }
        else 
        {
            // [51,255,255]
            panelatas.setBackground(new Color(51,255,255));
            paneltengah.setBackground(new Color(51,255,255));
            panelsudut.setBackground(new Color(51,255,255));
            panelsamping.setBackground(new Color(255,204,204));
        }
    }//GEN-LAST:event_latarMouseClicked

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
      panelcaribarang.setVisible(false);
    }//GEN-LAST:event_cariKeyPressed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
    //    DaftarAdmin keluar1 = new DaftarAdmin();
//        keluar1.setVisible(true);
     //   this.dispose();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void jCheckBox24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox24ActionPerformed
        // TODO add your handling code here:
        String judul = makan24.getText() +"        " ;
        subTotal += myArr[23] +"\n";
        qty.append(String.valueOf(myArr[23] )+"\n");
        nBarang += (Integer)banyak24.getValue();

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[23]) +"\n");
        nTotal += hargaAkhirr[23] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox24.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan24.getText());
        semua += makan24.getText() +"\n";
    }//GEN-LAST:event_jCheckBox24ActionPerformed

    private void banyak24StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak24StateChanged
        // TODO add your handling code here:
        if((Integer)banyak24.getValue() <= 0 )
        {
            banyak24.setValue(0);
        }
        int n = (Integer)banyak24.getValue();
        myArr[23] = n ;
        int nk = Integer.parseInt(harga24.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[23] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[23] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak24StateChanged

    private void jCheckBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox23ActionPerformed
        // TODO add your handling code here:
        String judul = makan23.getText() +"        ";
        nBarang += (Integer)banyak23.getValue();
        subTotal += myArr[22] +"\n";
        qty.append(String.valueOf(myArr[22]) +"\n");
        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[22]) +"\n");
        nTotal += hargaAkhirr[22] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox23.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan23.getText());
        semua += makan23.getText() +"\n";
    }//GEN-LAST:event_jCheckBox23ActionPerformed

    private void banyak23StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak23StateChanged
        // TODO add your handling code here:
        if((Integer)banyak23.getValue() <= 0 )
        {
            banyak23.setValue(0);
        }
        int n = (Integer)banyak23.getValue();
        myArr[22] = n ;
        int nk = Integer.parseInt(harga23.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[22] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[22] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak23StateChanged

    private void jCheckBox22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox22ActionPerformed
        // TODO add your handling code here:
        String judul = makan22.getText() +"        ";
        nBarang += (Integer)banyak22.getValue();
           subTotal += myArr[21] +"\n";
        qty.append(String.valueOf(myArr[21]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[21]) +"\n");
        nTotal += hargaAkhirr[21] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox22.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan22.getText());
        semua += makan22.getText() +"\n";
    }//GEN-LAST:event_jCheckBox22ActionPerformed

    private void banyak22StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak22StateChanged
        // TODO add your handling code here:
        if((Integer)banyak22.getValue() <= 0 )
        {
            banyak22.setValue(0);
        }
        int n = (Integer)banyak22.getValue();
        myArr[21] = n ;
        int nk = Integer.parseInt(harga22.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[21] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[21] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak22StateChanged

    private void jCheckBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox21ActionPerformed
        // TODO add your handling code here:
        String judul = makan21.getText() +"        ";
        nBarang += (Integer)banyak21.getValue();
           subTotal += myArr[20] +"\n";
        qty.append(String.valueOf(myArr[20])+"\n");
        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[20]) +"\n");
        nTotal += hargaAkhirr[20] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox21.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan21.getText());
        semua += makan21.getText() +"\n";
    }//GEN-LAST:event_jCheckBox21ActionPerformed

    private void banyak21StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak21StateChanged
        // TODO add your handling code here:
        if((Integer)banyak21.getValue() <= 0 )
        {
            banyak21.setValue(0);
        }
        int n = (Integer)banyak21.getValue();
        myArr[20] = n ;
        int nk = Integer.parseInt(harga21.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[20] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[20] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak21StateChanged

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
        String judul = makan20.getText() +"        "  ;
        nBarang += (Integer)banyak20.getValue();
           subTotal += myArr[19] +"\n";
        qty.append(String.valueOf(myArr[19]) +"\n");
        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[19]) +"\n");
        nTotal += hargaAkhirr[19] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox20.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan20.getText());
        semua += makan20.getText() +"\n";
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void banyak20StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak20StateChanged
        // TODO add your handling code here:
        if((Integer)banyak20.getValue() <= 0 )
        {
            banyak20.setValue(0);
        }
        int n = (Integer)banyak20.getValue();
        myArr[19] = n ;
        int nk = Integer.parseInt(harga20.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[19] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[19] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak20StateChanged

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
        String judul = makan19.getText() +"        "  ;
        nBarang += (Integer)banyak19.getValue();
           subTotal += myArr[18] ;
        qty.append(String.valueOf(myArr[18]));

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[18]) +"\n");
        nTotal += hargaAkhirr[18] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox19.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan19.getText());
        semua += makan19.getText() +"\n";
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void banyak19StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak19StateChanged
        // TODO add your handling code here:
        if((Integer)banyak19.getValue() <= 0 )
        {
            banyak19.setValue(0);
        }
        int n = (Integer)banyak19.getValue();
        myArr[18] = n ;
        int nk = Integer.parseInt(harga19.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[18] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[18] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak19StateChanged

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        // TODO add your handling code here:
        String judul = makan18.getText() +"        "  ;
        nBarang += (Integer)banyak18.getValue();
           subTotal += myArr[17] +"\n";
        qty.append(String.valueOf(myArr[17]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[17]) +"\n");
        nTotal += hargaAkhirr[17] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox18.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan18.getText());
        semua += makan18.getText() +"\n";
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void banyak18StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak18StateChanged
        // TODO add your handling code here:
        if((Integer)banyak18.getValue() <= 0 )
        {
            banyak18.setValue(0);
        }
        int n = (Integer)banyak18.getValue();
        myArr[17] = n ;
        int nk = Integer.parseInt(harga18.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[17] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[17] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak18StateChanged

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
        String judul = makan17.getText() +"        " ;
        nBarang += (Integer)banyak17.getValue();
           subTotal += myArr[16] +"\n";
        qty.append(String.valueOf(myArr[16]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[16]) +"\n");
        nTotal += hargaAkhirr[16] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox17.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan17.getText());
        semua += makan17.getText() +"\n";
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void banyak17StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak17StateChanged
        // TODO add your handling code here:
        if((Integer)banyak17.getValue() <= 0 )
        {
            banyak17.setValue(0);
        }
        int n = (Integer)banyak17.getValue();
        myArr[16] = n ;
        int nk = Integer.parseInt(harga17.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[16] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[16] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak17StateChanged

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
        String judul = makan16.getText() +"        "  ;
        nBarang += (Integer)banyak16.getValue();
           subTotal += myArr[15] +"\n";
        qty.append(String.valueOf(myArr[15]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[15]) +"\n");
        nTotal += hargaAkhirr[15] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox16.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan16.getText());
        semua += makan16.getText() +"\n";
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void banyak16StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak16StateChanged
        // TODO add your handling code here:
        if((Integer)banyak16.getValue() <= 0 )
        {
            banyak16.setValue(0);
        }
        int n = (Integer)banyak16.getValue();
        myArr[15] = n ;
        int nk = Integer.parseInt(harga16.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[15] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[15] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak16StateChanged

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
        String judul = makan15.getText() +"        " ;
        nBarang += (Integer)banyak15.getValue();
           subTotal += myArr[14] +"\n";
        qty.append(String.valueOf(myArr[14]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[14]) +"\n");
        nTotal += hargaAkhirr[14] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox15.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan15.getText());
        semua += makan15.getText() +"\n";
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void banyak15StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak15StateChanged
        // TODO add your handling code here:
        if((Integer)banyak15.getValue() <= 0 )
        {
            banyak15.setValue(0);
        }
        int n = (Integer)banyak15.getValue();
        myArr[14] = n ;
        int nk = Integer.parseInt(harga15.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[14] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[14] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak15StateChanged

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
        String judul = makan14.getText() +"        "  ;
        nBarang += (Integer)banyak14.getValue();
           subTotal += myArr[13] +"\n";
        qty.append(String.valueOf(myArr[13]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[13]) +"\n");
        nTotal += hargaAkhirr[13] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox14.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan14.getText());
        semua += makan14.getText() +"\n";
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void banyak14StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak14StateChanged
        // TODO add your handling code here:
        if((Integer)banyak14.getValue() <= 0 )
        {
            banyak14.setValue(0);
        }
        int n = (Integer)banyak14.getValue();
        myArr[13] = n ;
        int nk = Integer.parseInt(harga14.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[13] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[13] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak14StateChanged

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
        String judul = makan13.getText() +"        " ;
        nBarang += (Integer)banyak13.getValue();
           subTotal += myArr[12]+"\n";
        qty.append(String.valueOf(myArr[12]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[12]) +"\n");
        nTotal += hargaAkhirr[12] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       totalSemua.setText(String.valueOf(nTotal));
        jCheckBox13.setEnabled(false);
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan13.getText());
        semua += makan13.getText() +"\n";
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void banyak13StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak13StateChanged
        // TODO add your handling code here:
        if((Integer)banyak13.getValue() <= 0 )
        {
            banyak13.setValue(0);
        }
        int n = (Integer)banyak13.getValue();
        myArr[12] = n ;
        int nk = Integer.parseInt(harga13.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[12] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[12] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak13StateChanged

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        // TODO add your handling code here:
        String judul = makan12.getText() +"        "  ;
        nBarang += (Integer)banyak12.getValue();
           subTotal += myArr[11] +"\n";
        qty.append(String.valueOf(myArr[11]) +"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[11]) +"\n");
        nTotal += hargaAkhirr[11] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox12.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan12.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void banyak12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak12StateChanged
        // TODO add your handling code here:
        if((Integer)banyak12.getValue() <= 0 )
        {
            banyak12.setValue(0);
        }
        int n = (Integer)banyak12.getValue();
        myArr[11] = n ;
        int nk = Integer.parseInt(harga12.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[11] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[11] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak12StateChanged

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
        String judul = makan11.getText() +"        ";
        nBarang += (Integer)banyak11.getValue();
           subTotal += myArr[10] +"\n";
        qty.append(String.valueOf(myArr[10]) +"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[10]) +"\n");
        nTotal += hargaAkhirr[10] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox11.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan11.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void banyak11StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak11StateChanged
        // TODO add your handling code here:
        if((Integer)banyak11.getValue() <= 0 )
        {
            banyak11.setValue(0);
        }
        int n = (Integer)banyak11.getValue();
        myArr[10] = n ;
        int nk = Integer.parseInt(harga11.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[10] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[10] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak11StateChanged

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
        String judul = makan10.getText() +"        "  ;
        pesanMakan.append(judul +"\n");
           subTotal += myArr[9] +"\n";
        qty.append(String.valueOf(myArr[9]) +"\n");
        nBarang += (Integer)banyak10.getValue();
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[9]) +"\n");
        nTotal += hargaAkhirr[9] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox10.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan10.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void banyak10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak10StateChanged
        // TODO add your handling code here:
        if((Integer)banyak10.getValue() <= 0 )
        {
            banyak10.setValue(0);
        }
        int n = (Integer)banyak10.getValue();
        myArr[9] = n ;
        int nk = Integer.parseInt(harga10.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[9] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[9] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak10StateChanged

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
        String judul = makan8.getText() +"        " ;
        nBarang += (Integer)banyak8.getValue();
           subTotal += myArr[7] +"\n";
        qty.append(String.valueOf(myArr[7]) +"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[7]) +"\n");
        nTotal += hargaAkhirr[7] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox8.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan8.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void banyak8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak8StateChanged
        // TODO add your handling code here:
        if((Integer)banyak8.getValue() <= 0 )
        {
            banyak8.setValue(0);
        }
        int n = (Integer)banyak8.getValue();
        myArr[7] = n ;
        int nk = Integer.parseInt(harga8.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[7] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[7] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak8StateChanged

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
        String judul = makan9.getText() +"        "  ;
        nBarang += (Integer)banyak9.getValue();
           subTotal += myArr[8] +"\n";
        qty.append(String.valueOf(myArr[8]) +"\n");
        
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[8]) +"\n");
        nTotal += hargaAkhirr[8] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox9.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan9.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void banyak9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak9StateChanged
        // TODO add your handling code here:
        if((Integer)banyak9.getValue() <= 0 )
        {
            banyak9.setValue(0);
        }
        int n = (Integer)banyak9.getValue();
        myArr[8] = n ;
        int nk = Integer.parseInt(harga9.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[8] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[8] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak9StateChanged

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
        String judul = makan7.getText() +"        "  ;
        nBarang += (Integer)banyak7.getValue();  
        subTotal += myArr[6] +"\n";
        qty.append(String.valueOf(myArr[6]) +"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[6]) +"\n");
        nTotal += hargaAkhirr[6] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox7.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan7.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void banyak7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak7StateChanged
        // TODO add your handling code here:
        if((Integer)banyak7.getValue() <= 0 )
        {
            banyak7.setValue(0);
        }
        int n = (Integer)banyak7.getValue();
        myArr[6] = n ;
        int nk = Integer.parseInt(harga7.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[6] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[6] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak7StateChanged

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
        String judul = makan6.getText() +"        "  ;
        nBarang += (Integer)banyak6.getValue();
           subTotal += myArr[5] +"\n";
        qty.append(String.valueOf(myArr[5]) +"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[5]) +"\n");
        nTotal += hargaAkhirr[5] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox5.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan6.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void banyak6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak6StateChanged
        // TODO add your handling code here:
        if((Integer)banyak6.getValue() <= 0 )
        {
            banyak6.setValue(0);
        }
        int n = (Integer)banyak6.getValue();
        myArr[5] = n ;
        int nk = Integer.parseInt(harga6.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[5] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[5] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak6StateChanged

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
        String judul = makan5.getText() +"        "  ;
        nBarang += (Integer)banyak5.getValue();
           subTotal += myArr[4] +"\n";
        qty.append(String.valueOf(myArr[4])+"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[4]) +"\n");

        nTotal += hargaAkhirr[4] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox6.setEnabled(false);
        semua += judul +"\n";
        kemenu.add(makan5.getText());
        System.out.println(semuaMakanan);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void banyak5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak5StateChanged
        // TODO add your handling code here:
        if((Integer)banyak5.getValue() <= 0 )
        {
            banyak5.setValue(0);
        }
        int n = (Integer)banyak5.getValue();
        myArr[4] = n ;
        int nk = Integer.parseInt(harga5.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[4] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[4] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak5StateChanged

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        String judul = makan4.getText() +"        "  ;
        nBarang += (Integer)banyak4.getValue();
           subTotal += myArr[3];
        qty.append(String.valueOf(myArr[3]));
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[3]) +"\n");
        nTotal += hargaAkhirr[3] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox4.setEnabled(false);
        //       semua += judul +"\n";
        kemenu.add(makan4.getText());
        System.out.println(semuaMakanan);
        semua+=semuaMakanan;
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void banyak4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak4StateChanged
        // TODO add your handling code here:
        if((Integer)banyak4.getValue() <= 0 )
        {
            banyak4.setValue(0);
        }
        int n = (Integer)banyak4.getValue();
        myArr[3] = n ;
        int nk = Integer.parseInt(harga4.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[3] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[3] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak4StateChanged

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        String judul = makan2.getText() +"        " ;
        nBarang += (Integer)banyak2.getValue();
           subTotal += myArr[1] +"\n";
        qty.append(String.valueOf(myArr[1])+"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[1]) +"\n");

        nTotal += hargaAkhirr[1] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox2.setEnabled(false);
        semua += makan2.getText() +"\n";
        kemenu.add(makan2.getText());
        //        System.out.println(semuaMakanan);
        //        semua+=semuaMakanan;
        semua += makan2.getText() +"\n";
        System.out.println(semua +" oke");
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void banyak2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak2StateChanged
        if((Integer)banyak2.getValue() <= 0 )
        {
            banyak2.setValue(0);
        }
        int n = (Integer)banyak2.getValue();
        myArr[1] = n ;
        int nk = Integer.parseInt(harga2.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[1] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[1] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak2StateChanged

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        String judul = makan3.getText() +"        "  ;
        nBarang += (Integer)banyak3.getValue();
           subTotal += myArr[2] +"\n";
        qty.append(String.valueOf(myArr[2]) +"\n");
        pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[2]) +"\n");
        nTotal += hargaAkhirr[2] ;
        totalSemua.setText(String.valueOf(nTotal));
        jCheckBox3.setEnabled(false);
        //       semua += judul +"\n";
        kemenu.add(makan3.getText());
        System.out.println(semuaMakanan);
        semua+=semuaMakanan;
        semua += makan3.getText() +"\n";
        System.out.println(semua +" oke");

    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void banyak3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak3StateChanged
        // TODO add your handling code here:
        if((Integer)banyak3.getValue() <= 0 )
        {
            banyak3.setValue(0);
        }
        int n = (Integer)banyak3.getValue();
        myArr[2] = n ;
        int nk = Integer.parseInt(harga3.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[2] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[2] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak3StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        String judul = makan1.getText() +"        "  ;
        nBarang += (Integer)banyak1.getValue();
           subTotal += myArr[0]+"\n";
        qty.append(String.valueOf(myArr[0]) +"\n");
        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[0]) +"\n");
        nTotal += hargaAkhirr[0] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan1.getText());
        semua += makan1.getText() +"\n";

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void banyak1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak1StateChanged

        if((Integer)banyak1.getValue() <= 0 )
        {
            banyak1.setValue(0);
        }
        int n = (Integer)banyak1.getValue();
        myArr[0] = n ;
        n = myArr[0];
        int nk = Integer.parseInt(harga1.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[0] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[0] = hargaAkhir ;
        String banyak = String.valueOf(n);
        //       String judul = makan1.getText() +"        "  +banyak;
        //       pesanMakan.append(judul +"\n");
        //       hargaaMakan.append(String.valueOf(hargaAkhir) +"\n");

    }//GEN-LAST:event_banyak1StateChanged

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        nBarang += 1 ;
        totalmenu.append("Paket Burger King" +"\n");
        hargaaMakan.append("120.000" +"\n");
         qty.append( "1" +"\n");
        nTotal += 120000;
         totalSemua.setText(String.valueOf(nTotal));
    }//GEN-LAST:event_myButton1ActionPerformed

    private void banyak25StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak25StateChanged
        // TODO add your handling code here:
              if((Integer)banyak25.getValue() <= 0 )
        {
            banyak25.setValue(0);
        }
        int n = (Integer)banyak25.getValue();
        myArr[24] = n ;
        int nk = Integer.parseInt(hargaminum1.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[24] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[24] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak25StateChanged

    private void jCheckBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox25ActionPerformed
        // TODO add your handling code here:
            String judul = minumm1.getText() +"        " ;
        nBarang += (Integer)banyak25.getValue();
             subTotal += myArr[24]+"\n";
        qty.append(String.valueOf(myArr[24]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[24]) +"\n");
        nTotal += hargaAkhirr[24] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(minumm1.getText());
        semua += minumm1.getText() +"\n";
    }//GEN-LAST:event_jCheckBox25ActionPerformed

    private void banyak26StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak26StateChanged
        // TODO add your handling code here:
                if((Integer)banyak26.getValue() <= 0 )
        {
            banyak26.setValue(0);
        }
        int n = (Integer)banyak26.getValue();
        myArr[25] = n ;
        int nk = Integer.parseInt(hargaminum2.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[25] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[25] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak26StateChanged

    private void banyak27StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak27StateChanged
        // TODO add your handling code here:
                if((Integer)banyak27.getValue() <= 0 )
        {
            banyak27.setValue(0);
        }
        int n = (Integer)banyak27.getValue();
        myArr[26] = n ;
        int nk = Integer.parseInt(hargaminum3.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[26] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[26] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak27StateChanged

    private void banyak28StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak28StateChanged
        // TODO add your handling code here:
                if((Integer)banyak28.getValue() <= 0 )
        {
            banyak28.setValue(0);
        }
        int n = (Integer)banyak28.getValue();
        myArr[27] = n ;
        int nk = Integer.parseInt(hargaminum4.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[27] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[27] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak28StateChanged

    private void banyak29StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak29StateChanged
        // TODO add your handling code here:
                if((Integer)banyak29.getValue() <= 0 )
        {
            banyak29.setValue(0);
        }
        int n = (Integer)banyak29.getValue();
        myArr[28] = n ;
        int nk = Integer.parseInt(hargaminum5.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[28] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[28] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak29StateChanged

    private void banyak30StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak30StateChanged
        // TODO add your handling code here:
                if((Integer)banyak30.getValue() <= 0 )
        {
            banyak30.setValue(0);
        }
        int n = (Integer)banyak30.getValue();
        myArr[29] = n ;
        int nk = Integer.parseInt(hargaminum6.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[29] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[29] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak30StateChanged

    private void banyak31StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak31StateChanged
        // TODO add your handling code here:
                if((Integer)banyak31.getValue() <= 0 )
        {
            banyak31.setValue(0);
        }
        int n = (Integer)banyak31.getValue();
        myArr[30] = n ;
        int nk = Integer.parseInt(hargaminum7.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[30] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[30] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak31StateChanged

    private void banyak32StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak32StateChanged
        // TODO add your handling code here:
                if((Integer)banyak32.getValue() <= 0 )
        {
            banyak32.setValue(0);
        }
        int n = (Integer)banyak32.getValue();
        myArr[31] = n ;
        int nk = Integer.parseInt(hargaminum8.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[31] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[31] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak32StateChanged

    private void banyak33StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak33StateChanged
        // TODO add your handling code here:
                if((Integer)banyak33.getValue() <= 0 )
        {
            banyak33.setValue(0);
        }
        int n = (Integer)banyak33.getValue();
        myArr[32] = n ;
        int nk = Integer.parseInt(hargaminum9.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[32] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[32] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak33StateChanged

    private void banyak34StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak34StateChanged
        // TODO add your handling code here:
                if((Integer)banyak34.getValue() <= 0 )
        {
            banyak34.setValue(0);
        }
        int n = (Integer)banyak34.getValue();
        myArr[33] = n ;
        int nk = Integer.parseInt(hargaminum10.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[33] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[33] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak34StateChanged

    private void banyak35StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak35StateChanged
        // TODO add your handling code here:
                if((Integer)banyak35.getValue() <= 0 )
        {
            banyak35.setValue(0);
        }
        int n = (Integer)banyak35.getValue();
        myArr[34] = n ;
        int nk = Integer.parseInt(hargaminum11.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[34] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[34] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak35StateChanged

    private void banyak36StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak36StateChanged

        // TODO add your handling code here
                if((Integer)banyak36.getValue() <= 0 )
        {
            banyak36.setValue(0);
        }
        int n = (Integer)banyak36.getValue();
        myArr[35] = n ;
        int nk = Integer.parseInt(hargaminum12.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[35] = hargaAkhir;
        //     nTotal += hargaAkhir ;
        myArr2[35] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak36StateChanged

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
         String judul = minumm2.getText() +"        ";
        nBarang += (Integer)banyak26.getValue();
             subTotal += myArr[25]+"\n";
        qty.append(String.valueOf(myArr[25]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[25]) +"\n");
        nTotal += hargaAkhirr[25] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(minumm2.getText());
        semua += minumm2.getText() +"\n";
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jCheckBox27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox27ActionPerformed
        // TODO add your handling code here:
         String judul = minumm3.getText() +"        "  ;
        nBarang += (Integer)banyak27.getValue();
        subTotal += myArr[26]+"\n";
        qty.append(String.valueOf(myArr[26]) +"\n");

        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[26]) +"\n");
        nTotal += hargaAkhirr[26] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(minumm3.getText());
        semua += minumm3.getText() +"\n";
    }//GEN-LAST:event_jCheckBox27ActionPerformed

    private void jCheckBox28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox28ActionPerformed
        // TODO add your handling code here:
         String judul = minumm4.getText() +"        ";
        nBarang += (Integer)banyak28.getValue();
             subTotal += myArr[27]+"\n";
        qty.append(String.valueOf(myArr[27]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[27]) +"\n");
        nTotal += hargaAkhirr[27] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm4.getText());
        semua += minumm4.getText() +"\n";
    }//GEN-LAST:event_jCheckBox28ActionPerformed

    private void jCheckBox29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox29ActionPerformed
        // TODO add your handling code here:
          String judul = minumm5.getText() +"        " ;
        nBarang += (Integer)banyak29.getValue();
             subTotal += myArr[28]+"\n";
        qty.append(String.valueOf(myArr[28]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[28]) +"\n");
        nTotal += hargaAkhirr[28] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm5.getText());
        semua += minumm5.getText() +"\n";
    }//GEN-LAST:event_jCheckBox29ActionPerformed

    private void jCheckBox36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox36ActionPerformed
        // TODO add your handling code here:
          String judul = minumm6.getText() +"        "  ;
        nBarang += (Integer)banyak30.getValue();
             subTotal += myArr[29]+"\n";
        qty.append(String.valueOf(myArr[29]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[29]) +"\n");
        nTotal += hargaAkhirr[29] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm6.getText());
        semua += minumm6.getText() +"\n";
    }//GEN-LAST:event_jCheckBox36ActionPerformed

    private void jCheckBox30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox30ActionPerformed
        // TODO add your handling code here:
          String judul = minumm7.getText() +"        " ;
        nBarang += (Integer)banyak31.getValue();
             subTotal += myArr[30]+"\n";
        qty.append(String.valueOf(myArr[30]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[30]) +"\n");
        nTotal += hargaAkhirr[30] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm7.getText());
        semua += minumm7.getText() +"\n";
    }//GEN-LAST:event_jCheckBox30ActionPerformed

    private void jCheckBox31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox31ActionPerformed
        // TODO add your handling code here:
          String judul = minumm8.getText() +"        "  ;
        nBarang += (Integer)banyak32.getValue();
             subTotal += myArr[31]+"\n";
        qty.append(String.valueOf(myArr[31]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[31]) +"\n");
        nTotal += hargaAkhirr[31] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm8.getText());
        semua += minumm8.getText() +"\n";
    }//GEN-LAST:event_jCheckBox31ActionPerformed

    private void jCheckBox32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox32ActionPerformed
        // TODO add your handling code here:
          String judul = minumm9.getText() +"        " ;
        nBarang += (Integer)banyak33.getValue();
             subTotal += myArr[32]+"\n";
        qty.append(String.valueOf(myArr[32]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[32]) +"\n");
        nTotal += hargaAkhirr[32] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm9.getText());
        semua += minumm9.getText() +"\n";
    }//GEN-LAST:event_jCheckBox32ActionPerformed

    private void jCheckBox33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox33ActionPerformed
        // TODO add your handling code here:
          String judul = minumm10.getText() +"        " ;
        nBarang += (Integer)banyak34.getValue();
             subTotal += myArr[33]+"\n";
        qty.append(String.valueOf(myArr[33]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[33]) +"\n");
        nTotal += hargaAkhirr[33] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm10.getText());
        semua += minumm10.getText() +"\n";
    }//GEN-LAST:event_jCheckBox33ActionPerformed

    private void jCheckBox34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox34ActionPerformed
        // TODO add your handling code here:
          String judul = minumm11.getText() +"        " ;
        nBarang += (Integer)banyak35.getValue();
             subTotal += myArr[34]+"\n";
        qty.append(String.valueOf(myArr[34]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[34]) +"\n");
        nTotal += hargaAkhirr[34] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm11.getText());
        semua += minumm11.getText() +"\n";
    }//GEN-LAST:event_jCheckBox34ActionPerformed

    private void jCheckBox35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox35ActionPerformed
        // TODO add your handling code here:
          String judul = minumm12.getText() +"        " ;
        nBarang += (Integer)banyak36.getValue();
             subTotal += myArr[35]+"\n";
        qty.append(String.valueOf(myArr[35]) +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[35]) +"\n");
        nTotal += hargaAkhirr[35] ;
        totalSemua.setText(String.valueOf(nTotal));
        kemenu.add(minumm12.getText());
        semua += minumm12.getText() +"\n";
    }//GEN-LAST:event_jCheckBox35ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     ArrayList <String> updatemakan = new ArrayList<>();
        try 
        {
            String sql1 = "SELECT namaBarang , hargaBarang , stoBarang   FROM barang WHERE jenisBarang = 'MAKANAN'";
            rs = stm.executeQuery(sql1);
            int count = 0 ;
            while(rs.next())
            {
//                String s1 = rs.getString(1);
                namaMakanan
                        .add(rs.getString("namaBarang"));
                hargaMakanan.add(rs.getString("hargaBarang"));
                stokMakanan.add(rs.getString("stoBarang"));
//                 gambarMakan.add(rs.getByte("gambarBarang"));
//                for(int i = 0 ; i < 12 ; i++)
//                {
//                    namaBarang[i] = rs.getString(1);
//                     hargaBarang[i] = rs.getString(2);
//                      stokBarang[i] = rs.getString(3);
//                }
                
           
                
            }
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
    }
    makan1.setText(namaMakanan.get(0));
        makan2.setText(namaMakanan.get(1));
        makan3.setText(namaMakanan.get(2));
        makan4.setText(namaMakanan.get(3));
        makan5.setText(namaMakanan.get(4));
        makan6.setText(namaMakanan.get(5));
        makan7.setText(namaMakanan.get(6));
        makan8.setText(namaMakanan.get(7));
        makan9.setText(namaMakanan.get(8));
        makan10.setText(namaMakanan.get(9));
        makan11.setText(namaMakanan.get(10));
        makan12.setText(namaMakanan.get(11));
        makan13.setText(namaMakanan.get(12));
        makan14.setText(namaMakanan.get(13));
        makan15.setText(namaMakanan.get(14));
        makan16.setText(namaMakanan.get(15));
        makan17.setText(namaMakanan.get(16));
        makan18.setText(namaMakanan.get(17));
        makan19.setText(namaMakanan.get(18));
        makan20.setText(namaMakanan.get(19));
        makan21.setText(namaMakanan.get(20));
        makan22.setText(namaMakanan.get(21));
        makan23.setText(namaMakanan.get(22));
        makan24.setText(namaMakanan.get(23));
        minumm1.setText(namaMinuman.get(0));
        minumm2.setText(namaMinuman.get(1));
        minumm3.setText(namaMinuman.get(2));
        minumm4.setText(namaMinuman.get(3));
        minumm5.setText(namaMinuman.get(4));
        minumm6.setText(namaMinuman.get(5));
        minumm7.setText(namaMinuman.get(6));
        minumm8.setText(namaMinuman.get(7));
        minumm9.setText(namaMinuman.get(8));
        minumm10.setText(namaMinuman.get(9));
        minumm11.setText(namaMinuman.get(10));
        minumm12.setText(namaMinuman.get(11));
        harga1.setText(hargaMakanan.get(0));
         hargaa1.setText(hargaMakanan.get(0));
        harga2.setText(hargaMakanan.get(1));
        harga3.setText(hargaMakanan.get(2));
        harga4.setText(hargaMakanan.get(3));
        harga5.setText(hargaMakanan.get(4));
        harga6.setText(hargaMakanan.get(5));
        harga7.setText(hargaMakanan.get(6));
        harga8.setText(hargaMakanan.get(7));
        harga9.setText(hargaMakanan.get(8));
        harga10.setText(hargaMakanan.get(9));
        harga11.setText(hargaMakanan.get(10));
        harga12.setText(hargaMakanan.get(11));
        harga13.setText(hargaMakanan.get(12));
        harga14.setText(hargaMakanan.get(13));
        harga15.setText(hargaMakanan.get(14));
        harga16.setText(hargaMakanan.get(15));
        harga17.setText(hargaMakanan.get(16));
        harga18.setText(hargaMakanan.get(17));
        harga19.setText(hargaMakanan.get(18));
        harga20.setText(hargaMakanan.get(19));
        harga21.setText(hargaMakanan.get(20));
        harga22.setText(hargaMakanan.get(21));
        harga23.setText(hargaMakanan.get(22));
        harga24.setText(hargaMakanan.get(23));
        
        hargaminum1.setText( hargaMinuman.get(0));
         hargaminum2.setText( hargaMinuman.get(1));
          hargaminum3.setText( hargaMinuman.get(2));
           hargaminum4.setText( hargaMinuman.get(3));
            hargaminum5.setText( hargaMinuman.get(4));
             hargaminum6.setText( hargaMinuman.get(5));
              hargaminum7.setText( hargaMinuman.get(6));
               hargaminum8.setText( hargaMinuman.get(7));
                hargaminum9.setText( hargaMinuman.get(8));
          hargaminum10.setText( hargaMinuman.get(9));
           hargaminum11.setText( hargaMinuman.get(10));
            hargaminum12.setText( hargaMinuman.get(11));
        stok1.setText(stokMakanan.get(0));
        stok2.setText(stokMakanan.get(1));
        stok3.setText(stokMakanan.get(2));
        stok4.setText(stokMakanan.get(3));
        stok5.setText(stokMakanan.get(4));
        stok6.setText(stokMakanan.get(5));
        stok7.setText(stokMakanan.get(6));
        stok8.setText(stokMakanan.get(7));
        stok9.setText(stokMakanan.get(8));
        stok10.setText(stokMakanan.get(9));
        stok11.setText(stokMakanan.get(10));
        stok12.setText(stokMakanan.get(11));
        stok13.setText(stokMakanan.get(12));
        stok14.setText(stokMakanan.get(13));
        stok15.setText(stokMakanan.get(14));
        stok16.setText(stokMakanan.get(15));
        stok17.setText(stokMakanan.get(16));
        stok18.setText(stokMakanan.get(17));
        stok19.setText(stokMakanan.get(18));
        stok20.setText(stokMakanan.get(19));
        stok21.setText(stokMakanan.get(20));
        stok22.setText(stokMakanan.get(21));
        stok23.setText(stokMakanan.get(22));
        stok24.setText(stokMakanan.get(23));
        stokminum1.setText(stokMinuman.get(0));
         stokminum2.setText(stokMinuman.get(1));
          stokminum3.setText(stokMinuman.get(2));
           stokminum4.setText(stokMinuman.get(3));
            stokminum5.setText(stokMinuman.get(4));
             stokminum6.setText(stokMinuman.get(5));
              stokminum7.setText(stokMinuman.get(6));
               stokminum8.setText(stokMinuman.get(7));
                stokminum9.setText(stokMinuman.get(8));
                 stokminum10.setText(stokMinuman.get(9));
                  stokminum11.setText(stokMinuman.get(10));
                   stokminum12.setText(stokMinuman.get(11));
//        Load1();
//        Loadminum();
//        Load2();
//        cobaAjalah();
//        LoadGambar1();
//        LoadGambar2();
//        LoadGambar3();
//        LoadGambar4();
//        LoadGambar5();
//        LoadGambar6();
//        LoadGambar7();
//        LoadGambar8();
//        LoadGambar9();
//        LoadGambar10();
//        LoadGambar11();
//        LoadGambar12();
//        LoadGambar2();
//        LoadGambar13();
//        LoadGambar14();
//        LoadGambar15();
//        LoadGambar16();
//        LoadGambar17();
//        LoadGambar18();
//        LoadGambar19();
//        LoadGambar20();
//        LoadGambar21();
//        LoadGambar22();
//        LoadGambar23();
//        LoadGambar24();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void historyOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyOrderMouseClicked
        // TODO add your handling code here:
//       PanelRiwayat pan = new PanelRiwayat();
//        add(pan);
//        pan.setVisible(true);
        RiwayatPembayaran pem = new RiwayatPembayaran();
        pem.setVisible(true);
    }//GEN-LAST:event_historyOrderMouseClicked

    private void banyak37StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_banyak37StateChanged
        // TODO add your handling code here:
        if((Integer)banyak37.getValue() <= 0 )
        {
            banyak37.setValue(0);
        }
        int n = (Integer)banyak37.getValue();
        myArr[36] = n ;
        int nk = Integer.parseInt(hargaminum13.getText());
        int hargaAkhir = n * nk ;
        hargaAkhirr[36] = hargaAkhir;
        //       nTotal += hargaAkhir ;
        myArr2[36] = hargaAkhir ;
        String banyak = String.valueOf(n);
    }//GEN-LAST:event_banyak37StateChanged

    private void jCheckBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox37ActionPerformed
        // TODO add your handling code here:
          String judul = minumm13.getText() +"        "  ;
        nBarang += (Integer)banyak37.getValue();
           subTotal += myArr[36]+"\n";
        qty.append(String.valueOf(myArr[36]) +"\n");
        //  pesanMakan.append(judul +"\n");
        totalmenu.append(judul +"\n");
        hargaaMakan.append(String.valueOf(myArr2[36]) +"\n");
        nTotal += hargaAkhirr[36] ;
        totalSemua.setText(String.valueOf(nTotal));
        //       semuaMakanan.add(makan1.getText());
        //       System.out.println(semuaMakanan);
        //       semua+=semuaMakanan;
        kemenu.add(makan1.getText());
        semua += makan1.getText() +"\n";
    }//GEN-LAST:event_jCheckBox37ActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void BAYARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAYARActionPerformed
        // TODO add your handling code here:
            Pembayaran bayar = new Pembayaran();
//          bayar.menumakanan.append(semua);
          totalMakanan = pesanMakan.getText();
          totalHargaMakan = hargaaMakan.getText();
          String s = totalmenu.getText();
          String s2 = hargaaMakan.getText();
          String s3 = qty.getText();
          
          bayar.setVisible(true);
          this.dispose();
//          totalmenu.setText(s);
//          hargaaMakan.setText(s2);
//          qty.setText(s3);
    }//GEN-LAST:event_BAYARActionPerformed

    private void cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyTyped
        // TODO add your handling code here:
          panelcaribarang.setVisible(true);
    }//GEN-LAST:event_cariKeyTyped

    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
        // TODO add your handling code here:
        About bt = new About();
        bt.setVisible(true);
    }//GEN-LAST:event_jLabel86MouseClicked
   public void cobaAjalah(){
       JOptionPane.showMessageDialog(this, "Telah Di - Klik");
   }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAYAR;
    private javax.swing.JSpinner banyak1;
    private javax.swing.JSpinner banyak10;
    private javax.swing.JSpinner banyak11;
    private javax.swing.JSpinner banyak12;
    private javax.swing.JSpinner banyak13;
    private javax.swing.JSpinner banyak14;
    private javax.swing.JSpinner banyak15;
    private javax.swing.JSpinner banyak16;
    private javax.swing.JSpinner banyak17;
    private javax.swing.JSpinner banyak18;
    private javax.swing.JSpinner banyak19;
    private javax.swing.JSpinner banyak2;
    private javax.swing.JSpinner banyak20;
    private javax.swing.JSpinner banyak21;
    private javax.swing.JSpinner banyak22;
    private javax.swing.JSpinner banyak23;
    private javax.swing.JSpinner banyak24;
    private javax.swing.JSpinner banyak25;
    private javax.swing.JSpinner banyak26;
    private javax.swing.JSpinner banyak27;
    private javax.swing.JSpinner banyak28;
    private javax.swing.JSpinner banyak29;
    private javax.swing.JSpinner banyak3;
    private javax.swing.JSpinner banyak30;
    private javax.swing.JSpinner banyak31;
    private javax.swing.JSpinner banyak32;
    private javax.swing.JSpinner banyak33;
    private javax.swing.JSpinner banyak34;
    private javax.swing.JSpinner banyak35;
    private javax.swing.JSpinner banyak36;
    private javax.swing.JSpinner banyak37;
    private javax.swing.JSpinner banyak4;
    private javax.swing.JSpinner banyak5;
    private javax.swing.JSpinner banyak6;
    private javax.swing.JSpinner banyak7;
    private javax.swing.JSpinner banyak8;
    private javax.swing.JSpinner banyak9;
    private swing.TextFieldAnimation cari;
    private javax.swing.JLabel detiklabel;
    private javax.swing.JLabel gam;
    private javax.swing.JLabel gami8;
    private javax.swing.JLabel gami9;
    private javax.swing.JLabel harga1;
    private javax.swing.JLabel harga10;
    private javax.swing.JLabel harga11;
    private javax.swing.JLabel harga12;
    private javax.swing.JLabel harga13;
    private javax.swing.JLabel harga14;
    private javax.swing.JLabel harga15;
    private javax.swing.JLabel harga16;
    private javax.swing.JLabel harga17;
    private javax.swing.JLabel harga18;
    private javax.swing.JLabel harga19;
    private javax.swing.JLabel harga2;
    private javax.swing.JLabel harga20;
    private javax.swing.JLabel harga21;
    private javax.swing.JLabel harga22;
    private javax.swing.JLabel harga23;
    private javax.swing.JLabel harga24;
    private javax.swing.JLabel harga3;
    private javax.swing.JLabel harga4;
    private javax.swing.JLabel harga5;
    private javax.swing.JLabel harga6;
    private javax.swing.JLabel harga7;
    private javax.swing.JLabel harga8;
    private javax.swing.JLabel harga9;
    private javax.swing.JTextField hargaa1;
    public static final javax.swing.JTextArea hargaaMakan = new javax.swing.JTextArea();
    private javax.swing.JLabel hargaminum1;
    private javax.swing.JLabel hargaminum10;
    private javax.swing.JLabel hargaminum11;
    private javax.swing.JLabel hargaminum12;
    private javax.swing.JLabel hargaminum13;
    private javax.swing.JLabel hargaminum2;
    private javax.swing.JLabel hargaminum3;
    private javax.swing.JLabel hargaminum4;
    private javax.swing.JLabel hargaminum5;
    private javax.swing.JLabel hargaminum6;
    private javax.swing.JLabel hargaminum7;
    private javax.swing.JLabel hargaminum8;
    private javax.swing.JLabel hargaminum9;
    private javax.swing.JLabel historyOrder;
    public static final javax.swing.JButton jButton1 = new javax.swing.JButton();
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jamlabel;
    private javax.swing.JLabel labelrestoran;
    private javax.swing.JLabel labeltroli;
    private switchbutton.SwitchButton latar;
    private javax.swing.JLabel makan1;
    private javax.swing.JLabel makan10;
    private javax.swing.JLabel makan11;
    private javax.swing.JLabel makan12;
    private javax.swing.JLabel makan13;
    private javax.swing.JLabel makan14;
    private javax.swing.JLabel makan15;
    private javax.swing.JLabel makan16;
    private javax.swing.JLabel makan17;
    private javax.swing.JLabel makan18;
    private javax.swing.JLabel makan19;
    private javax.swing.JLabel makan2;
    private javax.swing.JLabel makan20;
    private javax.swing.JLabel makan21;
    private javax.swing.JLabel makan22;
    private javax.swing.JLabel makan23;
    private javax.swing.JLabel makan24;
    private javax.swing.JLabel makan3;
    private javax.swing.JLabel makan4;
    private javax.swing.JLabel makan5;
    private javax.swing.JLabel makan6;
    private javax.swing.JLabel makan7;
    private javax.swing.JLabel makan8;
    private javax.swing.JLabel makan9;
    private javax.swing.JLabel makangbr1;
    private javax.swing.JLabel makangbr10;
    private javax.swing.JLabel makangbr11;
    private javax.swing.JLabel makangbr12;
    private javax.swing.JLabel makangbr13;
    private javax.swing.JLabel makangbr14;
    private javax.swing.JLabel makangbr15;
    private javax.swing.JLabel makangbr16;
    private javax.swing.JLabel makangbr17;
    private javax.swing.JLabel makangbr18;
    private javax.swing.JLabel makangbr19;
    private javax.swing.JLabel makangbr2;
    private javax.swing.JLabel makangbr20;
    private javax.swing.JLabel makangbr21;
    private javax.swing.JLabel makangbr22;
    private javax.swing.JLabel makangbr23;
    private javax.swing.JLabel makangbr24;
    private javax.swing.JLabel makangbr3;
    private javax.swing.JLabel makangbr4;
    private javax.swing.JLabel makangbr5;
    private javax.swing.JLabel makangbr6;
    private javax.swing.JLabel makangbr7;
    private javax.swing.JLabel makangbr8;
    private javax.swing.JLabel makangbr9;
    private javax.swing.JLabel menitlabel;
    private javax.swing.JLabel minumanku1;
    private javax.swing.JLabel minumanku10;
    private javax.swing.JLabel minumanku11;
    private javax.swing.JLabel minumanku12;
    private javax.swing.JLabel minumanku2;
    private javax.swing.JLabel minumanku3;
    private javax.swing.JLabel minumanku4;
    private javax.swing.JLabel minumanku5;
    private javax.swing.JLabel minumanku6;
    private javax.swing.JLabel minumanku7;
    private javax.swing.JLabel minumanku8;
    private javax.swing.JLabel minumanku9;
    private javax.swing.JLabel minumm1;
    private javax.swing.JLabel minumm10;
    private javax.swing.JLabel minumm11;
    private javax.swing.JLabel minumm12;
    private javax.swing.JLabel minumm13;
    private javax.swing.JLabel minumm2;
    private javax.swing.JLabel minumm3;
    private javax.swing.JLabel minumm4;
    private javax.swing.JLabel minumm5;
    private javax.swing.JLabel minumm6;
    private javax.swing.JLabel minumm7;
    private javax.swing.JLabel minumm8;
    private javax.swing.JLabel minumm9;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private AdminSystem.PanelBarang panel12;
    private AdminSystem.PanelBarang panelBarang1;
    private AdminSystem.PanelBarang panelBarang10;
    private AdminSystem.PanelBarang panelBarang11;
    private AdminSystem.PanelBarang panelBarang12;
    private AdminSystem.PanelBarang panelBarang13;
    private AdminSystem.PanelBarang panelBarang14;
    private AdminSystem.PanelBarang panelBarang15;
    private AdminSystem.PanelBarang panelBarang16;
    private AdminSystem.PanelBarang panelBarang17;
    private AdminSystem.PanelBarang panelBarang18;
    private AdminSystem.PanelBarang panelBarang19;
    private AdminSystem.PanelBarang panelBarang2;
    private AdminSystem.PanelBarang panelBarang20;
    private AdminSystem.PanelBarang panelBarang21;
    private AdminSystem.PanelBarang panelBarang22;
    private AdminSystem.PanelBarang panelBarang23;
    private AdminSystem.PanelBarang panelBarang3;
    private AdminSystem.PanelBarang panelBarang36;
    private AdminSystem.PanelBarang panelBarang37;
    private AdminSystem.PanelBarang panelBarang38;
    private AdminSystem.PanelBarang panelBarang39;
    private AdminSystem.PanelBarang panelBarang4;
    private AdminSystem.PanelBarang panelBarang40;
    private AdminSystem.PanelBarang panelBarang41;
    private AdminSystem.PanelBarang panelBarang42;
    private AdminSystem.PanelBarang panelBarang43;
    private AdminSystem.PanelBarang panelBarang44;
    private AdminSystem.PanelBarang panelBarang45;
    private AdminSystem.PanelBarang panelBarang46;
    private AdminSystem.PanelBarang panelBarang47;
    private AdminSystem.PanelBarang panelBarang5;
    private AdminSystem.PanelBarang panelBarang6;
    private AdminSystem.PanelBarang panelBarang7;
    private AdminSystem.PanelBarang panelBarang8;
    private AdminSystem.PanelBarang panelBarang9;
    private javax.swing.JPanel panelatas;
    private AdminSystem.PanelBarang panelcaribarang;
    private javax.swing.JPanel panelsamping;
    private javax.swing.JPanel panelsudut;
    private javax.swing.JPanel paneltengah;
    private javax.swing.JPanel pencariantab;
    public javax.swing.JTextArea pesanMakan;
    public static final javax.swing.JTextArea qty = new javax.swing.JTextArea();
    private javax.swing.JLabel stok1;
    private javax.swing.JLabel stok10;
    private javax.swing.JLabel stok11;
    private javax.swing.JLabel stok12;
    private javax.swing.JLabel stok13;
    private javax.swing.JLabel stok14;
    private javax.swing.JLabel stok15;
    private javax.swing.JLabel stok16;
    private javax.swing.JLabel stok17;
    private javax.swing.JLabel stok18;
    private javax.swing.JLabel stok19;
    private javax.swing.JLabel stok2;
    private javax.swing.JLabel stok20;
    private javax.swing.JLabel stok21;
    private javax.swing.JLabel stok22;
    private javax.swing.JLabel stok23;
    private javax.swing.JLabel stok24;
    private javax.swing.JLabel stok3;
    private javax.swing.JLabel stok4;
    private javax.swing.JLabel stok5;
    private javax.swing.JLabel stok6;
    private javax.swing.JLabel stok7;
    private javax.swing.JLabel stok8;
    private javax.swing.JLabel stok9;
    private javax.swing.JLabel stokminum1;
    private javax.swing.JLabel stokminum10;
    private javax.swing.JLabel stokminum11;
    private javax.swing.JLabel stokminum12;
    private javax.swing.JLabel stokminum13;
    private javax.swing.JLabel stokminum2;
    private javax.swing.JLabel stokminum3;
    private javax.swing.JLabel stokminum4;
    private javax.swing.JLabel stokminum5;
    private javax.swing.JLabel stokminum6;
    private javax.swing.JLabel stokminum7;
    private javax.swing.JLabel stokminum8;
    private javax.swing.JLabel stokminum9;
    private tabbed.MaterialTabbed tabku;
    private javax.swing.JTextField totalSemua;
    public static final javax.swing.JTextArea totalmenu = new javax.swing.JTextArea();
    private javax.swing.JLabel uc;
    private javax.swing.JLabel uc1;
    // End of variables declaration//GEN-END:variables
}
