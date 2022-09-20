
package com.example.assignmentnetworking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ServerMain {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(33333);
        System.out.println("Server Started...");
        HashMap<String, Information> clientList = new HashMap<String, Information>();
        while (true) {
            Socket socket = serverSocket.accept();
            NetworkUtil networkUtil = new NetworkUtil(socket);

           new CreateConnection(clientList, networkUtil);

        }

    }
}
