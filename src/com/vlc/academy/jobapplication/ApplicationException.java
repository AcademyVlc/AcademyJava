package com.vlc.academy.jobapplication;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
        // public ApplicationException(){
        //        super("ApplicationException");
        //    }
    }
}
