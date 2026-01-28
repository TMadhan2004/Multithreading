class FileDownload extends Thread {
    private String fileName;

    FileDownload(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(fileName + " downloading... " + (i * 20) + "%");
            try {
                Thread.sleep(500); //Simulating to create a scenario like downloading
            } catch (InterruptedException e) {
                System.out.println(fileName + " interrupted");
            }
        }
        System.out.println(fileName + " download completed.");
    }
}

public class thread {
    public static void main(String[] args) {

        FileDownload t1 = new FileDownload("Vs code");
        FileDownload t2 = new FileDownload("Anti gravity");
        t1.start();
        t2.start();
    }
}
