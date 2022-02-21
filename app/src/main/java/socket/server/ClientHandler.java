package socket.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final String EXIT = "EXIT";

    public ClientHandler(final Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(this.clientSocket.getInputStream());
            String message = (String) objectInputStream.readObject();
            System.out.println("Message from client: " + message);


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.clientSocket.getOutputStream());
            objectOutputStream.writeObject("Hi client : " + message);
            objectInputStream.close();
            objectOutputStream.close();

            if (message.equalsIgnoreCase(EXIT))
                App.keepListening = false;

        } catch (IOException ioException){
            System.out.println("Got Exception when handling client request :"+ ioException.getMessage());
        } catch (ClassNotFoundException classNotFoundException){
            System.out.println("Got Exception:"+ classNotFoundException.getMessage());
        }

        try {
            this.clientSocket.close();
        } catch (IOException ioException){
            System.err.println("Got Exception while closing client connection:"+ ioException.getMessage());
        }

    }
}
