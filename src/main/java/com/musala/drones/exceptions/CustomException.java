package com.musala.drones.exceptions;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.Collection;

public class CustomException extends  RuntimeException{
    private Collection<String> messages;

    public CustomException(String msg){
        super(msg);
    }


    public CustomException(String msg, Exception cause){
        super(msg, cause);
    }


    public CustomException(Collection<String> messages){
        super();
        this.messages= messages;
    }


    public CustomException (Collection<String> messages, Exception cause){
        super(cause);
        this.messages= messages;
    }

    @Override
    public String getMessage(){
        String msg;

        if(this.messages!=null && !this.messages.isEmpty()){
            msg="[";

            for(String message : this.messages){
                msg+=message+",";
            }


        }else msg= super.getMessage();

        return msg;
    }
}
