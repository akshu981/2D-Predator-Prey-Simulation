package MainPackage;


public class Configs {
    

    private  static String imageDir = "/images/";
  
   public static final int flyMoveTicks         = 1;        // Number of ticks before moving
   public static final int flyStarveTicks       = 5;        // Number of ticks before starving
   public static final int flyBreedTicks        = 2;        // Number of ticks it takes before breeding
   public static final int flyMoveRangeInCells  = 2;        //how many cells an organism can move per tick
      
   public static final int spiderMoveTicks         = 6;     // Number of ticks before moving
   public static final int spiderStarveTicks       = 9;     // Number of ticks before starving
   public static final int spiderBreedTicks        = 5;     // Number of ticks it takes before breeding
   public static final int spiderMoveRangeInCells  = 1;     //how many cells an organism can move per tick
   

   
    public Configs()
    {
         
               
    }

    
    public static String getBGPath()
    {
        return imageDir + "bugsBG.jpg";
    }
    
    public static String getFlyImagePath()
    {
        return imageDir + "fly.png";
    }
    
    public static String getSpiderImagePath()
    {
        return imageDir + "spiderweb.png";
    }
    
    public String getImageDir() {
        return imageDir;
    }

    public static String getImageDirStatic() {
        Configs _config = new Configs();
        return _config.imageDir;
    }

    
   
     
    
    
}
