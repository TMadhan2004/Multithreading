class TicketBooking implements Runnable {
    private int availableTickets = 5;
    @Override
    public synchronized void run() {
        String user = Thread.currentThread().getName();

        if (availableTickets > 0) {
            System.out.println(user + " is booking a ticket");
            try {
                Thread.sleep(400); // processing time to simulate the threading process
            } catch (InterruptedException e) {
                System.out.println(user + " interrupted");
            }
            availableTickets--;
            System.out.println(user + " booked successfully. Tickets left: " + availableTickets);
        } else {
            System.out.println(user + " failed. No tickets available.");
        }
    }
}

public class runnable {
    public static void main(String[] args) {
        TicketBooking bookingTask = new TicketBooking();
        Thread t1 = new Thread(bookingTask, "abc");
        Thread t2 = new Thread(bookingTask, "xyz");
        Thread t3 = new Thread(bookingTask, "lmn");
        Thread t4 = new Thread(bookingTask, "opq");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
