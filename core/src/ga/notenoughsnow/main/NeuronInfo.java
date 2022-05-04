package ga.notenoughsnow.main;

public class NeuronInfo {

	public int connection_range;
	public int neighbor_count;
	public int neighbor_range;
	
	public NeuronInfo(int connection_range, int neighbor_count, int neighbor_range) {
		this.connection_range = connection_range;
		this.neighbor_count = neighbor_count;
		this.neighbor_range = neighbor_range;
	}

}
