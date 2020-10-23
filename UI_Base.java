package MainPackage;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRootPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergey
 */
public class UI_Base extends javax.swing.JFrame {

    public static enum  FormSize {SMALL, MEDIUM}; 
    private JLabel lblBG = new JLabel();
    
    public UI_Base()
    {
        //getRootPane().setContentPane(lblBG);
    }
    
    
     public UI_Base(String sBG)
    {
        setDefaults();
         setContentPane(new JLabel(new ImageIcon(getClass().getResource(sBG))));
    }
   
    public UI_Base(String sBG, int iWidth, int iHeight) 
    {
        initSettings( sBG,  iWidth,  iHeight);
    }

    
      public void initSettings(String bGImagePath, int iWidth, int iHeight)
      {
          initComponents();
          setSize(iWidth, iHeight);
         
            //setBackgroundImageScale(bGImagePath, iWidth, iHeight);
            setDefaults();
         
   
    }
    
      
    private void setDefaults()
    {
         // setUndecorated(true);
 
          setResizable(false);
          setPosition();
          
         // setAlwaysOnTop(true);
          setBorder();
    }
   
    public void setBorder()
    {
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#182943")));
    }
   
    private void setBG(String sImageName)
    {
         setContentPane(new JLabel(new ImageIcon(getClass().getResource(Configs.getImageDirStatic() + "/" + sImageName))));
         
       
    }
    
  
     
    private void setPosition()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }
    
    public void setBackgroundImageScale(String imagePath, int iWidth, int iHeight)
    {
        ImageIcon imageIcon =  new javax.swing.ImageIcon(getClass().getResource("/images/bugsBG60.jpg")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(iWidth, iHeight,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        lblBGImage.setIcon(imageIcon);
       // lblBGImage. repaint();
         lblBGImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
         getRootPane().setContentPane(lblBG);
        //repaint();
       
        //lblBG.set
        
       // setConte
       
    }
    public void removeMenu()
    {
        menuFile.remove(itemExit);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBGImage = new javax.swing.JLabel();
        barFileMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemExit = new javax.swing.JMenuItem();

        lblBGImage.setText("Background label");

        menuFile.setText("File");

        itemExit.setText("Exit");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExitActionPerformed(evt);
            }
        });
        menuFile.add(itemExit);

        barFileMenu.add(menuFile);

        setJMenuBar(barFileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBGImage)
                .addGap(0, 2081, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBGImage)
                .addGap(0, 1168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemExitActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barFileMenu;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JLabel lblBGImage;
    private javax.swing.JMenu menuFile;
    // End of variables declaration//GEN-END:variables
}
