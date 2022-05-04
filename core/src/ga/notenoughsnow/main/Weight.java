package ga.notenoughsnow.main;

public class Weight {
	
	float value;
	float threshhold = 1;
	Neuron target;
	
	public Weight(Neuron target) {
		
		this.target = target;
		value = App.r.nextFloat(0.1f, 0.5f);
		
	}

}
