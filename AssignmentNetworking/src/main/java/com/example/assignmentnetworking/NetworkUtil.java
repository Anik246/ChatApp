package com.example.assignmentnetworking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkUtil {
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;



    public  NetworkUtil(Socket sock) throws IOException {
        socket=sock;
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
    }

    public  NetworkUtil(String s, int port) throws IOException{
        socket=new Socket(s, port);
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
    }

    public void write(Object obj){
        try {
            oos.writeObject(obj);
        } catch (IOException ex) {
            System.out.println("Failed to write");

        }
    }

    public Object read(){
        Object obj;
        try {
            obj = ois.readObject();
        } catch (Exception ex) {
            System.out.println("Failed to read");
            return null;
        }
        return obj;
    }

    public Socket getSocket() {
        return socket;
    }
}