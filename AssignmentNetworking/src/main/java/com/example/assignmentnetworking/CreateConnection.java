
package com.example.assignmentnetworking;
import java.util.HashMap;


public class CreateConnection implements Runnable{
    
    HashMap<String, Information> clientList;
    NetworkUtil nc;
    public CreateConnection(HashMap<String,Information> cList, NetworkUtil nConnection){
        clientList=cList;
        nc=nConnection;
        Thread t = new Thread();
        t.start();
    }
        
    
    @Override
    public void run() {
        Object userObj=nc.read();
        String username=(String)userObj;
        
        System.out.println("User : "+username+" connected");
        
        clientList.put(username,new Information(username,nc));
        System.out.println("HashMap updated"+clientList);
        new Thread(new ReaderWriterServer(username,nc,clientList)).start();
        
    }
    
}
