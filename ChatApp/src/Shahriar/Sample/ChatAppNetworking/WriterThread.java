
package Shahriar.Sample.ChatAppNetworking;

import java.util.Scanner;


public class WriterThread implements Runnable{
    public NetworkUtil netConnection;
    
    public WriterThread(NetworkUtil nc){
        netConnection=nc;
    }
    

    
    @Override
    public void run() {
        
        Data data=new Data();
        
        while(true){
            
            Scanner in=new Scanner(System.in);
            
            data.message=in.nextLine();            
            try{
                netConnection.write(data.clone());
            }
            catch(Exception ex){
                System.out.println("sending failed");
            }
        }
    }
    
}
