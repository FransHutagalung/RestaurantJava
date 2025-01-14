/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelSystemAdmin;

import AdminSystem.KoneksiAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.transitions.TransitionsForm;

/**
 *
 * @author RAVEN
 */
public class Form4 extends TransitionsForm {
    DefaultTableModel model = null ;
    public Statement stm ;
    public Connection con;
    public PreparedStatement prs ;
    public ResultSet rs ;
    public Form4() {
        initComponents();
        KoneksiAdmin kon = new KoneksiAdmin();
        kon.Config();
        stm = kon.stm ;
        con = kon.con ;
        resfreshTable();
    }
    void resfreshTable()
    {
        model = new DefaultTableModel();
        model.addColumn("No");
         model.addColumn("ID Pegawai");
            model.addColumn("Nama  Pegawai");
               model.addColumn("Umur Pegawai");
                  model.addColumn("Jenkel ");
                     model.addColumn("Pendidikan Terakhir");
                         model.addColumn("Jabatan");
                           model.addColumn("Jadwal Kerja");
                             model.addColumn("Gaji");
                                 model.addColumn("No Telp");
                                    model.addColumn("Alamat");
       
                    int no = 0 ;             
        try 
         {
             String s = "select * from pegawai ";
             rs = stm.executeQuery(s);
             while (rs.next())
             {
                 model.addRow(new Object []
                 {
                     ++no , 
                     rs.getString("idPegawai"),
                       rs.getString("namaPegawai"),
                         rs.getString("umur"),
                           rs.getString("jenkel"),
                             rs.getString("pendidikanTerakhir"),
                               rs.getString("jabatan"),
                                 rs.getString("jadwalKerja"),
                                   rs.getString("gaji"),
                                     rs.getString("noTelp"),
                                     rs.getString("alamat")
                 });
                 
             }
             tablePegawai.setModel(model);
         } catch (SQLException e )
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegawai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        namatxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        umurtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pria = new javax.swing.JRadioButton();
        wanita = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        pendterakhir = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jabatantxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jadwalkerja = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        gajitxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        notelptxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamattxt = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cariaku = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("Tambah Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Data");

        jButton3.setText("Hapus Data");

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setText("FORM PEGAWAI");

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePegawai);

        jLabel2.setText("NAMA PEGAWAI");

        jLabel3.setText("UMUR PEGAWAI");

        jLabel4.setText("JENIS KELAMIN");

        buttonGroup1.add(pria);
        pria.setText("Pria");

        buttonGroup1.add(wanita);
        wanita.setText("Wanita");
        wanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wanitaActionPerformed(evt);
            }
        });

        jLabel5.setText("PENDIDIKAN TERAKHIR");

        pendterakhir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SMA / Sederajat", "D3", "S1", "S2" }));

        jLabel6.setText("Jabatan ");

        jabatantxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatantxtActionPerformed(evt);
            }
        });

        jLabel7.setText("Jadwal Kerja");

        jadwalkerja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00 - 14:00", "09:30 - 18:00", "14:00 - 20:00", "17:00 - 23:00", " " }));

        jLabel8.setText("Gaji / Bulan");

        jLabel9.setText("No.Telp ");

        jLabel10.setText("Alamat");

        alamattxt.setColumns(20);
        alamattxt.setRows(5);
        jScrollPane2.setViewportView(alamattxt);

        jLabel11.setText("Cari ");

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\tambah.png")); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\hapus1.png")); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\edit.png")); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\clear.png")); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cariaku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariakuKeyPressed(evt);
            }
        });

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

        jButton4.setText("REFRESH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jadwalkerja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jabatantxt)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(namatxt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pendterakhir, javax.swing.GroupLayout.Alignment.LEADING, 0, 298, Short.MAX_VALUE)
                        .addComponent(umurtxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wanita))
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(gajitxt, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                        .addComponent(notelptxt))
                    .addComponent(jLabel3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cariaku, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cariaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(umurtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pria)
                            .addComponent(wanita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pendterakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jabatantxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jadwalkerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gajitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notelptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void wanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wanitaActionPerformed

    private void jabatantxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatantxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jabatantxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String s ="";
        String y ="";
        String kodeno = "";
        try 
        {
              s =  "select *from getLastRecord ORDER BY idPegawai DESC LIMIT 1";
              rs = stm.executeQuery(s);
              while(rs.next())
              {
                    String hasil = rs.getString("idPegawai");
                    y = hasil.substring(0, 3);
        
                    kodeno = hasil.substring(3, 6);
              }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
//        String s =  "select *from getLastRecord ORDER BY id DESC LIMIT 1";
//        String y = s.substring(0, 3);
//        
//        String kodeno = s.substring(3, 6);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        String s ="";
        String y ="";
        String kodeno = "";
        try 
        {
              s =  "select *from pegawai ORDER BY idPegawai DESC LIMIT 1";
              rs = stm.executeQuery(s);
              while(rs.next())
              {
                    String hasil = rs.getString("idPegawai");
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
        String kel = "";
        if(pria.isSelected())
        {
            kel = "Pria";
        }
        else if (wanita.isSelected())
        {
            kel ="wanita";
        }
        try 
            
        {
            String sql = "INSERT INTO pegawai values  (? ,? , ? , ? ,? ,? ,? ,? ,? ,? )";
            prs = con.prepareStatement(sql);
            prs.setString(1, akh);
            prs.setString(2, namatxt.getText());
            prs.setString(3, umurtxt.getText());
            prs.setString(4, kel);
            prs.setString(5, pendterakhir.getSelectedItem().toString());
            prs.setString(6, jabatantxt.getText());
            prs.setString(7, jadwalkerja.getSelectedItem().toString());
            prs.setString(8, gajitxt.getText());
            prs.setString(9, notelptxt.getText());
            prs.setString(10, alamattxt.getText());
            int inserted = prs.executeUpdate();
            if(inserted> 0)
            {
                JOptionPane.showMessageDialog(this, "Berhasil Tambahkan Data Pegawai");
            }
                
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        resfreshTable();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
               String kel = "";
        if(pria.isSelected())
        {
            kel = "Pria";
        }
        else if (wanita.isSelected())
        {
            kel ="wanita";
        }
        try{
            
            String sql = "UPDATE pegawai SET namaPegawai = ? , umur = ? , jenkel = ? , pendidikanTerakhir = ? , jabatan = ? , jadwalKerja = ? , gaji = ? , noTelp = ? , alamat = ? WHERE idPegawai = ?";
            prs = con.prepareStatement(sql);
                prs.setString(1, namatxt.getText());
            prs.setString(2, umurtxt.getText());
            prs.setString(3, kel);
            prs.setString(4, pendterakhir.getSelectedItem().toString());
            prs.setString(5, jabatantxt.getText());
            prs.setString(6, jadwalkerja.getSelectedItem().toString());
            prs.setString(7, gajitxt.getText());
            prs.setString(8, notelptxt.getText());
            prs.setString(9, alamattxt.getText());
             prs.setString(10, model.getValueAt(tablePegawai.getSelectedRow(), 1).toString());
            int inserted = prs.executeUpdate();
            if(inserted> 0)
            {
                JOptionPane.showMessageDialog(this, "Berhasil Edit Data Pegawai");
            }
          
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        resfreshTable();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void tablePegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePegawaiMouseClicked
        // TODO add your handling code here:
        namatxt.setText(model.getValueAt(tablePegawai.getSelectedRow(), 2).toString());
        umurtxt.setText(model.getValueAt(tablePegawai.getSelectedRow(), 3).toString());
        String kel = (model.getValueAt(tablePegawai.getSelectedRow(), 4).toString());
        if(kel.equals("Pria"))
        {
            pria.isSelected();
        } else if (kel.equals("wanita"))
                {
                    wanita.isSelected();
                }
        // SMA / Sederajat, D3, S1, 
        String pendt = model.getValueAt(tablePegawai.getSelectedRow(), 5).toString();
        if(pendt.equals("SMA / Sederajat"))
        {
            pendterakhir.setSelectedIndex(0);
        } else if(pendt.equals("D3"))
        {
            pendterakhir.setSelectedIndex(1);
        } else  if(pendt.equals("S1"))
            
        {
            pendterakhir.setSelectedIndex(2);
        }
        jabatantxt.setText(model.getValueAt(tablePegawai.getSelectedRow(), 6).toString());
        // 08:00 - 14:00
//09:30 - 18:00
//14:00 - 20:00
//17:00 - 23:00
         String jadwal = model.getValueAt(tablePegawai.getSelectedRow(), 7).toString();
         if(jadwal.equals("08:00 - 14:00"))
         {
             jadwalkerja.setSelectedIndex(0);
         }   else if(jadwal.equals("09:30 - 18:00"))
         {
             jadwalkerja.setSelectedIndex(1);
         }    else if(jadwal.equals("14:00 - 20:00"))
         {
             jadwalkerja.setSelectedIndex(2);
         }   else if(jadwal.equals("17:00 - 23:00"))
         {
             jadwalkerja.setSelectedIndex(3);
         }
         gajitxt.setText(model.getValueAt(tablePegawai.getSelectedRow(), 8).toString());
         notelptxt.setText(model.getValueAt(tablePegawai.getSelectedRow(), 9).toString());
         alamattxt.setText(model.getValueAt(tablePegawai.getSelectedRow(), 10).toString());
    }//GEN-LAST:event_tablePegawaiMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        try 
        {
            String sqly = "DELETE FROM pegawai WHERE idPegawai = ?";
            
            prs = con.prepareStatement(sqly);
            prs.setString(1, model.getValueAt(tablePegawai.getSelectedRow(), 1).toString());
            int n = prs.executeUpdate();
            if(n> 0)
            {
                JOptionPane.showMessageDialog(this, "Berhasil Hapus Data");
            }
        } catch (SQLException e)
        {
            
            System.out.println(e.getMessage());
        }
        resfreshTable();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void cariakuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariakuKeyPressed
        // TODO add your handling code here:
                model = new DefaultTableModel();
        model.addColumn("No");
         model.addColumn("ID Pegawai");
            model.addColumn("Nama  Pegawai");
               model.addColumn("Umur Pegawai");
                  model.addColumn("Jenkel ");
                     model.addColumn("Pendidikan Terakhir");
                         model.addColumn("Jabatan");
                           model.addColumn("Jadwal Kerja");
                             model.addColumn("Gaji");
                                 model.addColumn("No Telp");
                                    model.addColumn("Alamat");
       
                    int no = 0 ;             
        try 
         {
             String s = "select * from pegawai where idPegawai = ?  ";
             prs = con.prepareStatement(s);
             prs.setString(1, cariaku.getText());
             rs = prs.executeQuery();
             while (rs.next())
             {
                 model.addRow(new Object []
                 {
                     ++no , 
                     rs.getString("idPegawai"),
                       rs.getString("namaPegawai"),
                         rs.getString("umur"),
                           rs.getString("jenkel"),
                             rs.getString("pendidikanTerakhir"),
                               rs.getString("jabatan"),
                                 rs.getString("jadwalKerja"),
                                   rs.getString("gaji"),
                                     rs.getString("noTelp"),
                                     rs.getString("alamat")
                 });
                 
             }
             tablePegawai.setModel(model);
         } catch (SQLException e )
         {
             System.out.println(e.getMessage());
         }
        
    }//GEN-LAST:event_cariakuKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        resfreshTable();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamattxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cariaku;
    private javax.swing.JTextField gajitxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jabatantxt;
    private javax.swing.JComboBox<String> jadwalkerja;
    private javax.swing.JTextField namatxt;
    private javax.swing.JTextField notelptxt;
    private javax.swing.JComboBox<String> pendterakhir;
    private javax.swing.JRadioButton pria;
    private javax.swing.JTable tablePegawai;
    private javax.swing.JTextField umurtxt;
    private javax.swing.JRadioButton wanita;
    // End of variables declaration//GEN-END:variables
}
