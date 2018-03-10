import ticket.*;

public class TicketMain {

    public static void main(String[] args) {

        Ticket[] ticketArray = new Ticket[args.length / 4];
        int j = 0;

        for (int i = 0; i < args.length; i +=4) {
            if (args[i].equals("return")) {
                ReturnTicket returnTicket = new ReturnTicket(Integer.parseInt(args[i + 1]), args[i + 2], Integer.parseInt(args[i + 3]));
                ticketArray[j] = returnTicket;
            } else if (args[i].equals("simple")) {
                Ticket ticket = new Ticket(Integer.parseInt(args[i + 1]), args[i + 2], Integer.parseInt(args[i + 3]));
                ticketArray[j] = ticket;
            }
            j++;
        }

        double max = ticketArray[0].calculatePrice();

        for(int i = 0; i < ticketArray.length; i++) {
            System.out.println(ticketArray[i]);
            if (ticketArray[i].calculatePrice() > max) {
                max = ticketArray[i].calculatePrice();
            }
        }

        System.out.println("The most expensive ticket costs: " + max);
    }
}
