import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void main(String[] args) throws IOException, MessagingException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 57);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        TimedEmail timedEmail = new TimedEmail(time);
    }

    public void generateAndSendEmail(Mails mails) throws MessagingException {

        for(int i = 0; i < mails.getMails().length; i++) {
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);

            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mails.getMails()[i].getEmailAddress()));
            generateMailMessage.setSubject(mails.getMails()[i].getSubject());
            generateMailMessage.setContent(mails.getMails()[i].getContent(), "text/html");

        /*
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("gergely.papp@flowacademy.hu"));
        generateMailMessage.setSubject("test");
        generateMailMessage.setContent("this is a test email", "text/html");
        */
            Transport transport;
            transport = getMailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com", "papp.gergely.florian@gmail.com", "******");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        }
    }

    public Mails read() throws IOException {
        byte[] db = new byte[0];
        try {
            db = Files.readAllBytes(Paths.get("emails.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Mails mailsArray = null;

        try {
            mailsArray = objectMapper.readValue(db, Mails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(mailsArray);
        return mailsArray;
    }
}
