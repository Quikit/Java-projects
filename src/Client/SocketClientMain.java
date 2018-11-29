package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientMain {


    public static void main (String[]args)  {
        try {
            String NameOfClient = "Client";
            String NameOfServer;

            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connection to the server was successful!");
            BufferedReader writerMassage = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(NameOfClient);           // отсылаем серверу своё имя

            while (true) {
                String massage = writerMassage.readLine();
                writer.println(massage);
            }

        } catch (IOException e){
            System.out.println("The server is not responding.");
        }
    }


}
