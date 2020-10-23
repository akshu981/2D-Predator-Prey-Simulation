package MainPackage;

/**
* Definition for the Organism base class.
* Each organism has a reference back to
* the World object so it can move itself
* about in the world.
*/
abstract class Organism
{
	protected int x,y;		// Position in the world
        
	protected boolean hasMoved;	// Bool to indicate if hasMoved this turn
        
	protected int breedTicks;	// Number of ticks it takes before breeding
	protected int starveTicks;	// Number of ticks before starving
	protected int moveTicks;	// Number of ticks before moving
        
        protected int moveRangeInCells; //how many cells an organism can move per tick
           
        protected int counterMoveTicks;         // Number of ticks since last move
        protected int counterBreedTicks;	// Number of ticks since breeding
	protected int counterStarveTicks;	// Number of ticks since last feeding
     
     protected World world;	// Reference to the world object so we can update its grid when we move around in the world


        
	public Organism(int breedTicks, int starveTicks, int moveTicks, int moveRangeInCells)
	{
		world = null;
		hasMoved = false;
                
                this.moveTicks = moveTicks;
		this.breedTicks = breedTicks;
                this.starveTicks = starveTicks;
                this.moveRangeInCells = moveRangeInCells;
                
		x=0;
		y=0;
	}

	public Organism(int breedTicks, int starveTicks, int moveTicks, int moveRangeInCells, World world, int x, int y)
	{
		this(breedTicks, starveTicks, moveTicks, moveRangeInCells);
		this.x=x;
		this.y=y;
		this.world = world;
                this.world.setAt(x,y,this);
                
	}

        
 /*       
    public void resetCounterMoveTicks() {
        this.counterMoveTicks = 0;
    }

    public void resetCounterBreedTicks() {
        this.counterBreedTicks = counterBreedTicks;
    }
*/
     public void resetCounterStarveTicks() {
        this.counterBreedTicks = counterBreedTicks;
    }
  
             
 
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    public boolean getMoved()
    {
            return hasMoved;
    }

    public void setMoved(boolean moved)
    {
            this.hasMoved = moved;
    }

        

    
    public void incrementCounters()
    {
        counterBreedTicks++;
        counterStarveTicks++;
        counterMoveTicks++;    
    }
       
    
	/**
	* Determines whether or not this organism should breed
	*/
	public abstract void breed();

	/**
	* Determines how this organism should move
	*/
	public abstract void move();
/**
	* Determines if this organism starves
	*/
	public abstract boolean starve();

        public abstract WorldCell cellToMove(int range);
	
} // Organism
