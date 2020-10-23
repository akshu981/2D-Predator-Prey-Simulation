package MainPackage;


import java.util.ArrayList;

/**
 * Start with the Fly class
 */
class Fly extends Organism
{
	
    public Fly(World world, int x, int y)
    {
         super(Configs.flyBreedTicks, Configs.flyStarveTicks, Configs.flyMoveTicks, Configs.flyMoveRangeInCells, world,x,y);
    }

	/**
	* Fly breed
 Increment the tick count for breeding.
	* If it equals our threshold, then clone this ant either
	* above, right, left, or below the current one.
	*/
	public void breed()			// Must define this since virtual
	{
		if (breedTicks == counterBreedTicks)
		{
                      WorldCell cell = cellToMove(1); //pass one as argument to indicate that breeding need to occur in the adjacent cell
                      if (cell != null )
                      {
                          new Fly(world, cell.getX(), cell.getY());
                          counterBreedTicks = 0;
                      }       
		}
	}
        
        
/**
	* Fly Move
 Look for an empty cell up, right, left, or down and try to move there.
	*/
	public void move()			// Must define this since virtual
	{
            this.hasMoved = true; //flag that organism moved
            
            if (counterMoveTicks < moveTicks ) // if not eaten moveTicks long && and not hasMoved moveTicks long then need to move
                return; // no need to move if it is not time
            
           counterMoveTicks=0; //reset move ticks. Below code will move t
            
            
            WorldCell newCell = cellToMove(this.moveRangeInCells);
            if (newCell ==null) // no available moves 
                return;
            
            int newX = newCell.getX();
            int newY = newCell.getY();
                    
            int oldX = x;
            int oldY = y;
            
            Organism newCellOrg = world.getAt(newX,newY );
            
            if ( newCellOrg instanceof Spider) // if the cell the fly is moving is a spider then kill the fly
            {
                Spider spider = (Spider)newCellOrg;
                newCellOrg.resetCounterStarveTicks(); //reset hunber
                spider.setHasEaten();
            }
            else
            {
                world.setAt(newX, newY, this);// move the fly -  pass by reference
            }

             world.setAt(oldX,oldY,null); // remove the fly from old cell


	}

	

	
        public Fly clone()
        {
            Fly fly = new Fly(world, x,y);
            return fly;
        }
        
        public boolean starve()	// Check if a doodlebug starves to death
	{
            // Starve if no food eaten in last STARVE time ticks
            if (starveTicks < counterStarveTicks)
            {
                    return true;
            }
            else
            {
                    return false;
            }
	}
        
        public  WorldCell cellToMove(int iRange)
        {
            
            ArrayList<WorldCell> arCells = new ArrayList<WorldCell>();
          
            //get all cells in vertical directions
            int startPosition = y-iRange;
            for(int i=0; i<=2*iRange; i++)
            {
                int thisY = startPosition+i;
                if (y== thisY)
                    continue;
                boolean isInWorld = world.isInWorld(x,thisY);
                Organism org = world.getAt(x, thisY);
                
                if (isInWorld &&(org == null || (org.getClass()!= getClass()))  )
                    arCells.add(new WorldCell(x,thisY));     
            }
            
             //get all cells in horizontal directions
            startPosition = x-iRange;
            for(int i=0; i<=2*iRange; i++)
            {
                int thisX = startPosition+i;
                if (x== thisX)
                    continue;
                
                boolean isInWorld = world.isInWorld(thisX,y);
                Organism org = world.getAt(thisX,y);
                 if (
                        isInWorld && 
                        (
                                org ==null
                           ||   (org !=null && org.getClass()!= getClass())
                        )  
                    )
                    arCells.add(new WorldCell(thisX, y));  
                 
               // if (isInWorld  &&   world.getAt(thisX,y) instanceof Fly  ) // if within boundaries and not a fly
                //    arCells.add(new WorldCell(thisX, y));     
            }
            /*
            double d = 0.99d;
            int iWhole = 6;
            int result = (int)(d*(double)iWhole+1);
            */
            if (arCells.size()==0)
                return null;
            
            double random = Math.random();
            int iRandom = (int) (random * (double)(arCells.size()));
            
            if (iRandom >=arCells.size())
                iRandom = arCells.size()-1;
            
            return arCells.get(iRandom);
            
        }
                
} // Fly
