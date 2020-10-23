package MainPackage;



import java.util.ArrayList;

class Spider extends Organism
{
	 private boolean hasEaten;

    public Spider(World world, int x, int y)
    {
        super(Configs.spiderBreedTicks, Configs.spiderStarveTicks, Configs.spiderMoveTicks, Configs.spiderMoveRangeInCells, world,x,y);
        checkContraints();
    }
   
    
    /***
     * 
     * used in clone method
     */
    public Spider(int breedTicks, int starveTicks, int moveTicks, int moveRangeInCells, World world, int x, int y, boolean hasEaten)
    {
        super(Configs.spiderBreedTicks, Configs.spiderStarveTicks, Configs.spiderMoveTicks, Configs.spiderMoveRangeInCells, world,x,y);
        hasEaten = this.hasEaten;
        checkContraints();
    }
   
        
  
 
    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten() {
        this.hasEaten = true;
    }
	
       

	
        
       private boolean checkContraints()
        {
            boolean bReturn = true;
            //must be able to breed before starve
            if (starveTicks <= breedTicks)
            {
                bReturn = false;
                System.out.print(getClass().toString() + " Class: cannot breed before starving. counterBreedTicks("+counterBreedTicks+"; counterStarveTicks("+counterStarveTicks+")");
            }
            
            //must be able to move before starve
            if (starveTicks <= moveTicks)
            {
                bReturn = false;
                System.out.print(getClass().toString() + " Class: cannot move before starving. MOVE("+moveTicks+"; counterStarveTicks("+counterStarveTicks+")");
            }
            
            return bReturn;
        }
       
        public Spider clone()
        {                  
            Spider newSpider = new Spider( breedTicks,  starveTicks,  moveTicks,  moveRangeInCells,  world,  x,  y,  hasEaten); //world,x,y, hasEaten
            return newSpider;
        }

	/**
	* Spider breed
 Creates a new doodlebug adjacent to the current cell
 if the breedTicks meets the threshold.
	*/
	public void breed()	// Must define this since virtual
	{
		if (hasEaten && breedTicks >= counterBreedTicks)
		{
                    WorldCell newCell = cellToMove(this.moveRangeInCells);
                    if (newCell != null )
                    {
                        new Spider(world, newCell.getX(), newCell.getY());
                        hasEaten=false;     // reset eaten as now spider have not eaten before the next breeding
                        counterBreedTicks = 0;
                    }
                     
		}
	}

        public void move()			
	{
             this.hasMoved = true; //flag that organism moved
            
            if (counterMoveTicks < moveTicks ) // if not eaten moveTicks long && and not hasMoved moveTicks long then need to move
                return; // no need to move if it is not time
            
           counterMoveTicks=0; //reset move ticks. Below code will move the spider
             
            WorldCell newCell = cellToMove(this.moveRangeInCells);
            if (newCell ==null) // no available moves 
            {
                return;
            }
            
            int newX = newCell.getX();
            int newY = newCell.getY();
                    
            int oldX = x;
            int oldY = y;
            
/*  
            //============== For Testing ===================== //
            Organism newCellOrg = world.getAt(newX,newY );
            if( (newX !=x && newCell.getY()!=y ) || (newX ==x && newY==y ))
            {
                int i = 1;
            }

            if( ( Math.abs(newX -x) > moveRangeInCells || Math.abs(newY -y) > moveRangeInCells)  )
            {
                int i = 1;
            }
            //============== END For Testing ===================== //
            
*/
             //Spider spider = new Spider(world, newX, newY);
               world.setAt(newX, newY, this);// move the spider -  pass by reference
               world.setAt(oldX,oldY,null);  // Set current spot to empty. Can't use x and y because they were changed in the line above
             
            
        }
            
  
        public  WorldCell cellToMove(int range)
        {
            int availableCells = 0;
            ArrayList<WorldCell> arCells = new ArrayList<WorldCell>();
          
            //get all cells in vertical directions
            int startPosition = y-range;
            for(int i=0; i<=2*range; i++)
            {
                int thisY = startPosition+i;
                if (y== thisY)
                    continue;
                
                boolean isInWorld = world.isInWorld(x,thisY);
                
                if (isInWorld && world.getAt(x, thisY)==null  ) // move only if the cell is empty  - spiders are shy and can't move to a cell with other fly or spider
                    arCells.add(new WorldCell(x,thisY));     
            }
            
             //get all cells in horizontal directions
            startPosition = x-range;
            for(int i=0; i<=2*range; i++)
            {
                int thisX = startPosition+i;
                if (x== thisX)
                    continue;
                
                boolean isInWorld = world.isInWorld(thisX,y);
                
                if (isInWorld  &&   world.getAt(thisX,y)==null  ) // move only if the cell is empty  - spiders are shy and can't move to a cell with other fly or spider
                    arCells.add(new WorldCell(thisX, y));     
            }
          
            
             if (arCells.size()==0)
                return null;
             
            double random = Math.random();
            int iRandom = (int) (random * (double)(arCells.size()));
            if (iRandom >=arCells.size())
                iRandom = arCells.size()-1;
           
            WorldCell cell=null;
            try {
            cell= arCells.get(iRandom);
            }
            catch(Exception ex)
            {
                String sErr = ex.getMessage();
            }
            
            return cell;
            
        }


	/**
	* Spider starve Returns true or false if a doodlebug should die off because it hasn't eaten enough food.
	*/
        public boolean starve()	// Check if a doodlebug starves to death
	{
		// Starve if no food eaten in last counterStarveTicks time ticks
		if (starveTicks < counterStarveTicks)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	
} // Spider

