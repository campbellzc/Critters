import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


public class KingCrab extends CrabCritter {
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (a instanceof Rock || a instanceof Flower) {
				a.removeSelfFromGrid();
			} else {
				Grid g = getGrid();
				Location x = a.getLocation();
				Location z = x.getAdjacentLocation(a.getLocation().getDirectionToward(getLocation()) + 180);
				if (z == null && g.isValid(z)) {
					if (!g.getOccupiedLocations().contains(z)) {
						a.moveTo(z);
					} else {
						a.removeSelfFromGrid();
					}
				} else {
					a.removeSelfFromGrid();
				}
			}
		}
	}
}