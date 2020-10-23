package MainPackage;


public class World {
     
    /**
* The World class stores data about the world by creating a
* worldSize by worldSize array of type Organism.
* null indicates an empty spot, otherwise a valid object
* indicates an ant or doodlebug.  To determine which,
* invoke the virtual function getType of Organism that should return
* ANT if the class is of type ant, and DOODLEBUG otherwise.
*/

	public static int worldSize;
        
	private Organism[][] grid;		// Array of organisms for each cell


	public World(int worldSize)
	{
            this.worldSize = worldSize;
		// Initialize world to empty spaces
		int i,j;

		grid = new Organism[worldSize][worldSize];
		for (i=0; i<worldSize; i++)
		{
			for (j=0; j<worldSize; j++)
			{
				grid[i][j]=null;
			}
		}
	}

        public int getSize()
        {
            return worldSize;
        }
	/**
	* getAt

* * Returns the entry stored in the grid array at x,y.
	* @param x X coordinate of the cell to retrieve
	* @param y Y coordinate of the cell to retrieve
	*/
	public Organism getAt(int x, int y)
	{
		if ((x>=0) && (x<World.worldSize) && (y>=0) && (y<World.worldSize))
			return grid[x][y];
                
		return null;
	}

	/**
	* setAt
	* Sets the entry in the grid array at x,y to the input organism
	* @param x X coordinate of the cell to store
	* @param y Y coordinate of the cell to store
	* @param org Organism object to store in the grid
	*/
      
        
        
	public void setAt(int x, int y, Organism org)
	{
            if ((x>=0) && (x<World.worldSize) && (y>=0) && (y<World.worldSize))
            {
                if (org!=null)
                {
                    org.setX(x);
                    org.setY(y);
                }
                
                grid[x][y] = org;
            }
	}

        public void setAt(Organism org)
	{
            int x = org.getX();
            int y = org.getY();
            
            if ((x>=0) && (x<World.worldSize) && (y>=0) && (y<World.worldSize))
                grid[x][y] = org;
            
	}
	

	/**
	* SimulateOneStep
	* This is the main routine that simulates one turn in the world.
	* First, a flag for each organism is used to indicate if it has moved.
	* This is because we iterate through the grid starting from the top
	* looking for an organism to move . If one moves down, we don't want
	* to move it again when we reach it.
	* First move flies, then ants, and if they are still alive then
	* we breed them.
	*/
	public void SimulateOneStep()
	{
		int i,j;
		
            // First, reset all organisms to not moved, increment tick
		for (i=0; i<World.worldSize; i++)
                {
                    for (j=0; j<World.worldSize; j++)
                    {
                            if (grid[i][j]!=null) 
                            {
                                grid[i][j].setMoved(false);
                                grid[i][j].incrementCounters();
                            }
                    }
                }
                
                try {
		// Loop through cells in order and move flies first
		for (i=0; i<World.worldSize; i++)
			for (j=0; j<World.worldSize; j++)
			{
                            if ((grid[i][j] instanceof Fly))
                            {
                                   if (grid[i][j].getMoved() == false)
                                        grid[i][j].move();
                                   
                            }
			}
                }
                catch(Exception ex)
                {
                    String sErr = ex.getMessage();
                }
                
                // Move spiders
		for (i=0; i<World.worldSize; i++)
			for (j=0; j<World.worldSize; j++)
			{
                            if ((grid[i][j] instanceof Spider))
                            {
                                   if (grid[i][j].getMoved() == false)
                                        grid[i][j].move();  
                            }
			}
                
             
		// Loop through cells in order and check if anyone is starving
		for (i=0; i<World.worldSize; i++)
                {
			for (j=0; j<World.worldSize; j++)
			{
                            // Kill off any flies that haven't eaten recently
                            if ((grid[i][j] != null))
                            {
                                if (grid[i][j].starve())
                                        grid[i][j] = null;
                                
                            }
			}
                }
		// Loop through cells in order and check if we should breed
		for (i=0; i<World.worldSize; i++)
                {
			for (j=0; j<World.worldSize; j++)
			{
                            
				if (grid[i][j]!=null)
					grid[i][j].breed();
				
			}
                }
                
                
                
                
    }
        
        
    public void setRandomOrganisms(String type, int orgCount)
    {
        int i = orgCount;
        while (i > 0 )
        {
            int x = (int) (Math.random() * getSize());
            int y = (int) (Math.random() * getSize());

            if (getAt(x,y)==null) // only when the cell is vacant
            {
                Organism org = null;
                
                if (type.equalsIgnoreCase("fly"))
                   org = new Fly (this, x,y);
                else
                   org = new Spider (this, x,y);

                setAt(x,y,org);
                i--; //decrement organism counter by one 
            } 
        }
        
    }
        
    public boolean isInWorld(int x, int y)
    {
        if (x<0 || y<0)
            return false;
        
       if ( x<worldSize && y<worldSize)
           return true;
       else 
           return false;
    }
        
    
        
        
} // World

