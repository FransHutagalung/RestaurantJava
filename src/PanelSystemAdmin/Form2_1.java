/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelSystemAdmin;

import AdminSystem.KoneksiAdmin;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.transitions.TransitionsForm;

/**
 *
 * @author RAVEN
 */
public class Form2_1 extends TransitionsForm {
private String s = " "; 
   public Statement stm ;
   public Connection con;
   public PreparedStatement prs ;
   public ResultSet rs ;
      DefaultTableModel model = null ;
      public static String hapus ="";
    public Form2_1() {
//        supera();
//        superb();
        initComponents();
         KoneksiAdmin kon = new KoneksiAdmin();
          kon.Config();
        stm = kon.stm ;
        con = kon.con ;
        LoadTable();
        textPemesanan.setEditable(false);
    }
     private void LoadTable()
    {
        
        model = new DefaultTableModel();
        model.addColumn("idTransaksi");
        model.addColumn("Nama Pembeli");
        model.addColumn("Pesanan ");
        model.addColumn("Total Harga");
        model.addColumn("Alamat Pemesanan");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("No Telp");
        s = "idPenjualan";
      //  model.addColumn("Jenis Pangan");
//        model.addColumn("Status Peminjaman ");
        try{
            int no = 0 ;
            String sql = "select * from riwayatadmin  "  ;
            rs = stm.executeQuery(sql);  
            while(rs.next()){
                model.addRow(new Object[]{
                    
                    rs.getString("idPesanan"),
                    rs.getString(2),
                    "Rp. " +rs.getString(3),
                    rs.getString(5),
//                    rs.getInt(5),
                    rs.getString(6),
                        rs.getString(4) ,
                         rs.getString(9),
                           rs.getString(11)
                
                });
            }
            tabeltransaksi.setModel(model);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
        public void supera()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\cari.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(gambarcariku.getWidth(), gambarcariku.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        gambarcariku.setIcon(baru);
         gambarcari1.setIcon(baru);
    
    }
             public void superb()
    {
   
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\hapus.png");
        Image icon = img.getImage();
        Image scale = icon.getScaledInstance(gambarhapus.getWidth(), gambarhapus.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        gambarcariku.setIcon(baru);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltransaksi = new tabledark.TableDark();
        sTanggal = new javax.swing.JTextField();
        myButton1 = new button.MyButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namacari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPemesanan = new javax.swing.JTextArea();
        myButton2 = new button.MyButton();
        gambarhapus = new javax.swing.JLabel();
        gambarcariku = new javax.swing.JLabel();
        gambarcari1 = new javax.swing.JLabel();

        date.setTextRefernce(sTanggal);

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setText("FORM TRANSAKSI PANGAN");

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabeltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeltransaksi);

        myButton1.setText("Calender");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        jButton1.setText("CARI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("CARI NAMA PENGGUNA :");

        jLabel3.setText("CARI TRANSASKI SESUAI TANGGAL");

        jButton2.setText("CARI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("HAPUS HISTORY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        textPemesanan.setColumns(20);
        textPemesanan.setRows(5);
        jScrollPane2.setViewportView(textPemesanan);

        myButton2.setText("SEGARKAN");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(namacari, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(gambarcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gambarcariku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(gambarhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(gambarcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namacari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(gambarcariku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258)
                        .addComponent(gambarhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        date.showPopup();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void tabeltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransaksiMouseClicked
        // TODO add your handling code here:
        textPemesanan.setText(model.getValueAt(tabeltransaksi.getSelectedRow(), 2).toString());
        hapus = model.getValueAt(tabeltransaksi.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_tabeltransaksiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String sTanggal1 = sTanggal.getText();
        String tanggal = sTanggal1.substring(0, 2);
        String bulan  = sTanggal1.substring(3, 5);
        String tahun  = sTanggal1.substring(6, 10);
        String tanggalAkhir = tahun +"-" +bulan +"-"+tanggal;
        
             model = new DefaultTableModel();
//        model.addColumn("No");
        model.addColumn("idTransaksi");
        model.addColumn("Nama Pembeli");
        model.addColumn("Pesanan ");
        model.addColumn("Total Harga");
        model.addColumn("Alamat Pemesanan");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("No Telp");
        s = "idPenjualan";
        model.addColumn("Jenis Pangan");
//        model.addColumn("Status Peminjaman ");
        try{
            int no = 0 ;
         
            String sql = "select * from riwayatadmin where tanggalTransaksi = ? "  ;
            prs = con.prepareStatement(sql);
            prs.setString(1, tanggalAkhir);
            rs = prs.executeQuery();  
            while(rs.next()){
                model.addRow(new Object[]{
                    
                    rs.getString("idPesanan"),
                    rs.getString(2),
                    "Rp. " +rs.getString(3),
                    rs.getString(5),
//                    rs.getInt(5),
                    rs.getString(6),
                        rs.getString(4) ,
                         rs.getString(9),
                           rs.getString(11)
                
                });
            }
            tabeltransaksi.setModel(model);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        LoadTable();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           model = new DefaultTableModel();
//        model.addColumn("No");
        model.addColumn("idTransaksi");
        model.addColumn("Nama Pembeli");
        model.addColumn("Pesanan ");
        model.addColumn("Total Harga");
        model.addColumn("Alamat Pemesanan");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("No Telp");
        s = "idPenjualan";
        model.addColumn("Jenis Pangan");
//        model.addColumn("Status Peminjaman ");
        try{
            int no = 0 ;
         
            String sql = "select * from riwayatadmin where namaPembeli = ? "  ;
            prs = con.prepareStatement(sql);
            prs.setString(1, namacari.getText());
            rs = prs.executeQuery();  
            while(rs.next()){
                model.addRow(new Object[]{
                //   model.addRow(new Object[]{
                    
                    rs.getString("idPesanan"),
                    rs.getString(2),
                    "Rp. " +rs.getString(3),
                    rs.getString(5),
//                    rs.getInt(5),
                    rs.getString(6),
                        rs.getString(4) ,
                         rs.getString(9),
                           rs.getString(11)
                
                });
            }
            tabeltransaksi.setModel(model);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try 
        {
            String sql = "DELETE FROM riwayatadmin WHERE idPesanan = ?";
            prs = con.prepareStatement(sql);
            prs.setString(1, hapus);
            prs.executeUpdate();
            JOptionPane.showMessageDialog(this, "Berhasil Hapus data");
            LoadTable();
        } catch (SQLException e)
        {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel gambarcari1;
    private javax.swing.JLabel gambarcariku;
    private javax.swing.JLabel gambarhapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private javax.swing.JTextField namacari;
    private javax.swing.JTextField sTanggal;
    private tabledark.TableDark tabeltransaksi;
    private javax.swing.JTextArea textPemesanan;
    // End of variables declaration//GEN-END:variables
}
