package ga.notenoughsnow.main;

public class Weight {
	
	float value;
	float threshhold = 1;
	Node target;
	
	public Weight(Node target) {
		
		this.target = target;
		value = App.r.nextFloat(0f, 0.6f);
		
	}

}
