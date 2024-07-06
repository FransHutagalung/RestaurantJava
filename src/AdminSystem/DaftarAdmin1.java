
package AdminSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DaftarAdmin1 {
    public static Statement stm ; 
    public static Connection con ;
     public static void Config (){
        String dbURL = "jdbc:mysql://localhost:3306/restaurant";
        String username = "root";
        String password = "adhihutagalung";
       //  DaftarAdmin1 kon = new DaftarAdmin1();
        try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, username, password);
        stm = con.createStatement();
            System.out.println("Koneksi Berhasil ");
            
//String s = "select * from tb_mahasiswa";
//ResultSet oke =stm.executeQuery(s);
//ResultSetMetaData dataku = oke.getMetaData();

        
        } catch (Exception ex){
            System.out.println("Koneksi gagal " +ex.getMessage());
            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    }
    public static void main(String[] args) {
        Config();
        String s = "HiKamu ";
        System.out.println(s.substring(0, 2));
    }
}
