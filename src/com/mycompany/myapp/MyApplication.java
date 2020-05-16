package com.mycompany.myapp;


import com.mycompany.myapp.gui.Stock.HomeForm;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import com.mycompany.myapp.gui.BaseForm;
import com.mycompany.myapp.gui.CleanModern;
/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme_1");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
       /* UIBuilder ui = new UIBuilder();
        Container cnt = ui.createContainer(theme, "GUI 1");
        Form f=(Form)cnt;
        Label lbnom=(Label) ui.findByName("Label", cnt);
        Button btn=(Button) ui.findByName("Button", cnt);
        TextField tnom=(TextField) ui.findByName("TextField", cnt);
        btn.addActionListener((e)->{
        lbnom.setText("Hello"+tnom.getName());
    });
        f.show();*/
       //new HomeForm(theme).show();
       new HomeForm(theme).show();
        
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
