package com.xlegoz.trpger.script;

import com.xlegoz.trpger.util.Config;

public class Scripts {

    private String scripts;
    
    private Scripts() {
        scripts = Config.getScripts();
    }
    
    public static void exec() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                new Scripts();
            }
            
        });
    }
    
}
