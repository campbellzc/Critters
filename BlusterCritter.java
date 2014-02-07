import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter {
	private int c;
	
	public BlusterCritter(int c) {
		super();
		this.c = c;
	}
	public ArrayList<Actor> getActors() 
	{
		ArrayList<Actor> bugs = new ArrayList<Actor>();
		
		Location blank = getLocation();
		for (int r = blank.getRow() - 2; r <= blank.getRow() + 2; r++) {
			for (int z = blank.getCol() - 2; z <= blank.getCol() + 2; z++) {
				Location blank2 = new Location(r,z);

				if (getGrid().isValid(blank2)) {
					if ((getGrid().get(blank2)) instanceof Critter) {
						
						bugs.add(getGrid().get(blank2));
						//System.out.println("arraylist size = " + bugs.size());
					}
				}
			}
		}

		return bugs;
	}
	public void processActors(ArrayList<Actor> actors) 
	{ 
		for (Actor a : actors)
		{
			if (!(a instanceof Rock) && !(a instanceof Critter)) {
				a.removeSelfFromGrid();
			}
		}
		if (this.c > (actors.size()-1)) {
			brighten();
			//System.out.println("Brightened");
		} else {
			darken();
			//System.out.println("Darkened");
		}

	} 
	public void darken() {
		Color c = getColor();
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();

		
			red -= 10;
		
		
			green -= 10;
		
		
			blue -= 10;
		if (red < 0) {
			red = 0;
		}
		if (green < 0) {
			green = 0;
		}
		if (blue < 0) {
			blue = 0;
		}

		setColor(new Color(red, green, blue));
	}
	public void brighten() {
		Color c = getColor();
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();

		
		red += 10;
		
		
		green += 10;
		
		
		blue += 10;
		if (red > 255) {
			red = 255;
		}
		if (green > 255) {
			green = 255;
		}
		if (blue > 255) {
			blue = 255;
		}

		setColor(new Color(red, green, blue));
	}
}