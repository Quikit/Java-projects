package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerMain {
    public static void main(String[] args)  {
        try {

            int serverPort = 8080;
            String NameOfServer = "Server";
            String NameOfClient;

            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server socket created on " + serverPort);
            Socket clientSocket = serverSocket.accept();           // ожидаем клиента

            BufferedReader writerMassage = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            writer.println(NameOfServer);                          // отсылаем своё имя клиенту
            NameOfClient = reader.readLine();                      // считываем имя клиента
            System.out.println(NameOfClient + " joins the server");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(NameOfClient + ": " + line);
            }

        } catch (IOException e){
            System.out.println("The connection is lost.");
        }
    }
}
