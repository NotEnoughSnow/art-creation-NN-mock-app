package ga.notenoughsnow.main;

public class InputType {
	
	
	public enum InputSource {
		LEFT,
		RIGHT,
		TOP,
		BOTTOM,
		MIDDLE
	};
	
	/**
	 * 
	 * uniform : all input will pulse given the frequency
	 * random : all input will independently pulse with random frequencies will given upper_bound
	 * random_uniform : all input will uniformly pulse with random frequencies given from upper_bound
	 */
	public enum SignalFrequency {
		UNIFORM,
		RANDOM,
		RANDOM_UNIFORM
	};

}
