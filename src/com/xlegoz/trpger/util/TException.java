package com.xlegoz.trpger.util;

import com.xlegoz.trpger.TRPGer;
import com.xlegoz.trpger.gui.Popup;

public class TException extends Exception {

    public TException() {
        super();
    }
    
    @Override
    public void printStackTrace() { 
        if (TRPGer.debug) {
            super.printStackTrace();
        } else {
            new Popup("", "");
        }
    }
    
}
