package ga.notenoughsnow.main;


import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Node {
	
	Vector2 grid_pos;
	boolean active;
	int color = 0;
	int dist = 20;
	int neighbor_max = 5;
	int neighbor_range = 5;

	ArrayList<Weight> targets = new ArrayList<Weight>();
	
	
	public Node(int x,int y) {
		
		grid_pos = new Vector2(x,y);
		active = false;
		  
	}
	
	public void add_weights() {
		
		
		
		Vector2 target = connect(App.r,grid_pos,dist);
		
	    for (int i= 0; i<App.r.nextInt(10); i++)
		connect(App.r,target,neighbor_range);
	
	}
	
	private Vector2 connect(Random r,Vector2 start,int dist) {
		
		Vector2 target = new Vector2();

		
		do {
			target.x = (int) ((r.nextInt(2*dist+1)-dist) + start.x);
			
		} while(!(target.x >=0 && target.x < App.width));
		
		do {
			target.y = (int) ((r.nextInt(2*dist+1)-dist) + start.y);
			
		} while(!(target.y >=0 && target.y < App.height));
		 
		
		Node target_node =  App.grid.get((int) (target.x*App.width+target.y));
		targets.add(new Weight(target_node));
		
		return target;
	}
	
	
	public void bump() {
		
		for (Weight w : targets) {
			if ( w.threshhold > w.value ) {
				w.threshhold = w.threshhold - w.value;
			}
			else {
				w.threshhold = w.threshhold - w.value + 1;
				signal(w.target);
			}
			
			//if ( w.value < 1 )  w.value = w.value+0.01f;

		}
		
	}

	public void signal(Node target) {
		color = 255;
		active = true;
			App.next_active_nodes.add(target);
		
	}
	
	public void signal() {
		color = 255;
		active = true;
			for ( Weight w : targets)
			App.next_active_nodes.add(w.target);
		
	}
	
	public void disable() {
		color = 50;
		active = false;
		

	}

	@Override
	public String toString() {
		return grid_pos.toString();
	}

	
}
