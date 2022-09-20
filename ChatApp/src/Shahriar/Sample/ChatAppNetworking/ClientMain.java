
package Shahriar.Sample.ChatAppNetworking;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import java.util.Scanner;


public class ClientMain {
   public static void main(String[] args) throws IOException {

       Socket socket = new Socket();
       try {
           socket.connect(new InetSocketAddress("www.google.com", 80));
       } catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println("Client Started--- ");
       System.out.println(socket.getLocalAddress().getHostAddress());
       NetworkUtil nc=new NetworkUtil(socket.getLocalAddress().getHostAddress(),12345);

        System.out.println("Enter your username");
        Scanner in=new Scanner(System.in);
        String username=in.next();
        nc.write(username);

        Thread readerThread=new Thread(new ReaderThread(nc));
        Thread writerThread=new Thread(new WriterThread(nc));
        
        readerThread.start();
        writerThread.start();
        
        try{
            readerThread.join();
            writerThread.join();
        }
        catch(Exception e){
            System.out.println("Thread exited");
        }
    }
}
