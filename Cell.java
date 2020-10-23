package MainPackage;


import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Cell extends JLabel {
    private int row;
    private int col;
    private int id;
    private boolean isOccupied;
    
    private Organism organism;
    
    private final int size;
    
    public Cell(int iSize, int row, int col, Organism org)
    {
        this.row = row;
        this.col = col;
        this.size = iSize;
        
        setSize(size, size);
        
        if (org  instanceof Fly)
            setBackgroundImage(Configs.getFlyImagePath());   
        else if (org  instanceof Spider)
            setBackgroundImage(Configs.getSpiderImagePath());
        else
        {
           // setText(row + ":" + col );
           // setFont(new java.awt.Font("Tahoma", 1, 9)); 
            
        }
        
         setBorder(BorderFactory.createEtchedBorder());  
        
        
    }
    
    public void setBackgroundImage(String imagePath)
    {
        int iSize = (int)((double)size/1.5);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath)); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(iSize, iSize,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setIcon(imageIcon);
    }
    
    public Organism getOrganism()
    {
        return organism;
    }
  

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setOrganism(Organism critter)
    {
        organism = critter;
    }
    

    
    
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        if (isOccupied==false)
            setIcon(null);
    }
    
    
    
    
}
