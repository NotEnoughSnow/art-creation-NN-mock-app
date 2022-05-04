package ga.notenoughsnow.main;


import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Neuron extends NeuronType {
	
	boolean active;
	Color color = new Color(8/255f,8/255f,8/255f,1);
	

	ArrayList<Weight> targets = new ArrayList<Weight>();
	
	
	public Neuron(int x,int y,int dist,int n_count,int n_range) {
		
		grid_pos = new Vector2(x,y);
		this.dist = dist;
		this.neighbor_max = n_count;
		this.neighbor_range = n_range;
		
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
			
		} while(!(target.x >=0 && target.x < Envirement.width));
		
		do {
			target.y = (int) ((r.nextInt(2*dist+1)-dist) + start.y);
			
		} while(!(target.y >=0 && target.y < Envirement.height));
		 
		
		Neuron target_node =  App.grid.get((int) (target.x*Envirement.width+target.y));
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

	public void signal(Neuron target) {
		color.set(255/255f,0,100/255f,1);
		active = true;
			App.next_active_nodes.add(target);
		
	}
	
	public void signal() {
		color.set(1,0,0,1);
		active = true;
			for ( Weight w : targets)
			App.next_active_nodes.add(w.target);
		
	}
	
	public void disable() {
		color.set(85/255f,50/255f,60/255f,1);
		active = false;
		

	}

	@Override
	public String toString() {
		return grid_pos.toString();
	}

	
}
