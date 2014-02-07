import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
public class QuickCrab extends CrabCritter {
	public QuickCrab()
	{
	    setColor(Color.RED);
	}

	
	

	/**
	 * @return list of empty locations immediately to the right and to the left
	 */
	public ArrayList<Location> getMoveLocations()
	{
	    ArrayList<Location> locs = new ArrayList<Location>();
	    int left = getDirection() - 90;
	    int right = getDirection() + 90;
	    
	   	locs.add(getLocationsTwoAway(getLocation(), right));
	   	locs.add(getLocationsTwoAway(getLocation(), left));

	    return locs;
	}

	/**
	 * If the crab critter doesn't move, it randomly turns left or right.
	 */
	public void makeMove(Location loc)
	{
	    if (loc.equals(getLocation()))
	    {
	        double r = Math.random();
	        int angle;
	        if (r < 0.5)
	            angle = Location.LEFT;
	        else
	            angle = Location.RIGHT;
	        setDirection(getDirection() + angle);
	    }
	    else
	        super.makeMove(loc);
	}
	
	/**
	 * Finds the valid adjacent locations of this critter in different
	 * directions.
	 * @param directions - an array of directions (which are relative to the
	 * current direction)
	 * @return a set of valid locations that are neighbors of the current
	 * location in the given directions
	 */
	public ArrayList<Location> getLocationsTwoAway(Location loc, int direction)
	{
	    ArrayList<Location> locs = new ArrayList<Location>();
	    Grid gr = getGrid();
	    
	
	    
	    Location neighborLoc1 = loc.getAdjacentLocation(direction);
	    Location neighborLoc2 = neighborLoc1.getAdjacentLocation(direction);
	    if (gr.isValid(neighborLoc1) && gr.isValid(neighborLoc2)) {
	        locs.add(neighborLoc2);
	    }
	    
	    return locs;
	}  
}