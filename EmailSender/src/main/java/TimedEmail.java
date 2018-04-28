import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimedEmail {
    Timer timer;

    public TimedEmail(Date time) {
        timer = new Timer();
        timer.schedule(new RemindTask(), time);
    }
    class RemindTask extends TimerTask {
        public void run() {
            SendMail sendMail = new SendMail();
            Mails mails = null;
            try {
                mails = sendMail.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sendMail.generateAndSendEmail(mails);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            System.out.println("Email sent.");
            timer.cancel();
        }
    }
}