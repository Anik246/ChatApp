
package com.example.assignmentnetworking;

public class Reader implements Runnable{
    public NetworkUtil netConnection;
    String msg="";
    public static boolean check = false;
    public Reader(NetworkUtil nc){
        netConnection=nc;
    }
    public void setMessage(String msg){
        this.msg=msg;
    }
    public void StartThread(){
        new Thread(this).start();

    }
    public String getMessage() {
        if(msg!=null)
        return msg;
        else return "";
    }
    
    
    @Override
    public void run() {
        while(true){
            String msg;
            Object obj=netConnection.read();
            msg = (String) obj;

            if(!getMessage().equals(msg));
            {
                setMessage(msg);
                System.out.println("Received : "+msg);
                check = false;
            }

            
        }
    }
    
}
