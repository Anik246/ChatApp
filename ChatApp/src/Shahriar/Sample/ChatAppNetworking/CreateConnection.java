/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shahriar.Sample.ChatAppNetworking;


import java.util.HashMap;

public class CreateConnection implements Runnable{
    
    HashMap<String, Information> clientList;
    NetworkUtil nc;
    public CreateConnection(HashMap<String,Information> cList, NetworkUtil nConnection){
        clientList=cList;
        nc=nConnection;    
    }
        
    
    @Override
    public void run() {
        Object userObj=nc.read();
        String username=(String)userObj;
        
        System.out.println("User : "+username+" connected");
        
        clientList.put(username,new Information(username,nc));

        new Thread(new ReaderWriterServerThread(username,nc,clientList)).start();
        
    }
    
}
