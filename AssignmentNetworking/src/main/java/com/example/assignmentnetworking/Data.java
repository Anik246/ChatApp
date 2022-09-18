package com.example.assignmentnetworking;

import java.io.Serializable;


public class Data implements Serializable{
    
    public String message;           
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();
    }  
}
  