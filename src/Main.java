import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws
            MessagingException {
        Properties properties =new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        String username = "bekzodshodiyev999@gmail.com";
        String password = "lvlbqddgfjetpyuf";
        Session session = getSession(properties,username,password);
        Message message = new MimeMessage(session
        );

        message.setSubject("Assalomu Aleykum");
        message.setText("Sizga Eng yaxshi o'qtuvchi unvoni berildi tabriklaymiz");
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO,new
                InternetAddress("bekzodshodiyev999@gmail.com"));
        Transport.send(message);
        System.out.println("success");
    }
    private static Session getSession(Properties
                                              properties, String username, String password) {
        return Session.getInstance(properties, new
                Authenticator() {
                    @Override
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(username,
                                password);
                    }
                });
    }
}