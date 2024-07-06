
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class gnail {
     public static void main(String[] args) {
        String to = "adhimarnaek@gmail.com";
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
            mime.setSubject("Ini Contoh");
            mime.setText("Silahkan Login Ke Aplikasi Kami hehhe apa kabar jamu dimana dan kemana wkwk okelah");
            Transport.send(mime);
            System.out.println("Pesan Terkirim");
            
        }
        catch(MessagingException e)
        {
            e.getMessage();
        }
        
    }
}
