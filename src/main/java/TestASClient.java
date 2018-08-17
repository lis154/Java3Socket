import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

class TestASClient {
    public static void main(String[] args) throws InterruptedException {

        try
        {
            Socket socket = new Socket("localhost", 3348);
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            DataInputStream ois = new DataInputStream(socket.getInputStream());

            System.out.println("Client connected to socket.");

            while(!socket.isOutputShutdown()){

                    Students students = new Students("Ivan", 15);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(students);
                    out.flush();
                    students.printSt();
                    System.out.println("Client sent message & start waiting for data from server...");
                    Thread.sleep(2000);

                    break;


            }

            System.out.println("Closing connections & channels on clentSide - DONE.");

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
