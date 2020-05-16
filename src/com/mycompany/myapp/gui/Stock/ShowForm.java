/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.Stock;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entities.Stock.Produit;
import com.mycompany.myapp.Utils.Statics;
import com.mycompany.myapp.gui.BaseForm;

/**
 *
 * @author Haddad
 */
public class ShowForm extends BaseForm{
      public ShowForm(Form c,Produit p,Resources res) {
        
          
        super(BoxLayout.y());
        Button btnBuy=new Button("Buy");
        Form current = this;
        Form hi = new Form("Show", new FlowLayout(Container.CENTER, Container.CENTER));
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle(p.getNom_Produit());
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);

        
        Container list = new Container(new FlowLayout(Component.CENTER));
      
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());

        list.getAllStyles().setPaddingTop(size / 4);
            
//            TODO 

            Container Prod = new Container(BoxLayout.y());
             Container ProdF = new Container(new FlowLayout(Component.CENTER));
            ProdF.getAllStyles().setPaddingTop(size / 6);
            Label nomP = new Label("Produit : " + p.getNom_Produit());
            Label catP = new Label("Categorie : " + p.getNcat(p.getId_Categorie()));
            Label etatP = new Label("Etat : " + p.getEtat_Produit());
            etatP.getAllStyles().setFgColor(0xff000);
            Label prixP = new Label("Prix : " + p.getPrix_Produit());
            Label sizeP = new Label("Taille : " + p.getTaille_Produit());

     

       
               String urlImage = Statics.IMAGE_URL +p.getUrl();
               Image placeholder = Image.createImage(222, 287);
               EncodedImage enco = EncodedImage.createFromImage(placeholder, true);
               Image imgser = URLImage.createToStorage(enco, "" + p.getUrl(), urlImage , URLImage.RESIZE_SCALE);
               imgser = imgser.scaled(350, 350);
               ImageViewer img = new ImageViewer(imgser);
            
        //img.setWidth(500);
        
        Prod.addAll(img,nomP,catP,prixP,etatP,sizeP);
        ProdF.addAll(Prod);
           
                        
            Prod.setLeadComponent(btnBuy);
            list.add(ProdF);
            
  
        addAll(list);
        
        
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, e-> c.showBack());
    }
    
}



