import java.util.Arrays;

public class Mails {

    private Email[] mails;

    public Mails(Email[] mails) {
        this.mails = mails;
    }

    public Mails() {
    }

    public Email[] getMails() {
        return mails;
    }

    public void setMails(Email[] mails) {
        this.mails = mails;
    }

    @Override
    public String toString() {
        return "Mails{" +
                "mails=" + Arrays.toString(mails) +
                '}';
    }
}
