import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestAsServer {
    public static void main(String[] args) throws InterruptedException {

        ServerSocket server = null;
        try {

            server= new ServerSocket(3348);
            Socket client = server.accept();


            System.out.print("Connection accepted.");

            ObjectInputStream in1 = new ObjectInputStream(client.getInputStream());
            Students objectReceived = (Students) in1.readObject();


            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream  created");

                objectReceived.printSt();
                out.flush();
                client.close();
                Thread.sleep(2000);

            out.close();
            client.close();
            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

