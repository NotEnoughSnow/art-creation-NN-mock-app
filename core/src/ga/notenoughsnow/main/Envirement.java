package ga.notenoughsnow.main;

public class Envirement {
	
	public static int width;
    public static int height;
    public static int space_size ;
    
    public Envirement(int width, int height,NeuronInfo n_info) {
    	Envirement.width = width;
    	Envirement.height = height;
    	space_size = width*height; 
    	
    	
    	fill_grid(n_info);
    	assign_weights();
    	
    }
    
    private void fill_grid(NeuronInfo n_info) {
    	
    	for (int i = 0; i < Envirement.width; i= i + 1) 
			for (int j = 0; j < Envirement.height; j= j + 1)
				App.grid.add(new Neuron(i,j,20,5,5));
    }
    
    private void assign_weights() {
    	
    	for ( Neuron n : App.grid)
			n.add_weights();
    }
    
}
