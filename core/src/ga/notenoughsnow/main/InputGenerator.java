package ga.notenoughsnow.main;

import java.util.HashSet;
import java.util.Set;

import ga.notenoughsnow.main.InputType.InputSource;
import ga.notenoughsnow.main.InputType.SignalFrequency;

public class InputGenerator {

    static Set<InputNeuron> input_list = new HashSet<InputNeuron>();
    
    /**
     * 
     * @param source
     * @param sig_type
     * @param frequency 1 for constant
     */
    public InputGenerator(InputSource source,SignalFrequency sig_type,int frequency) {
    	
    	
    	
    	switch(source) {
    	case LEFT: {
    		
    		
    		
    	if(sig_type == SignalFrequency.RANDOM) {
    		
    		for (int i = 0; i < Envirement.height; i= i + 1) {
    	
    			int a = App.r.nextInt(frequency)+1;
    			input_list.add(new InputNeuron(App.grid.get(i),a));
    		}
    	}
    	else if(sig_type == SignalFrequency.UNIFORM){
    		
    		for (int i = 0; i < Envirement.height; i= i + 1) {
    	    	
    			input_list.add(new InputNeuron(App.grid.get(i),frequency));
    		}
    	}
    	else {
			int a = App.r.nextInt(frequency)+1;

    		for (int i = 0; i < Envirement.height; i= i + 1) {
    	    	
    			input_list.add(new InputNeuron(App.grid.get(i),a));
    		}
    	}
    		
    	}break;
    	
    	case RIGHT:{
    		for (int j = 0; j < Envirement.height; j= j + 1)
				input_list.add(new InputNeuron(App.grid.get((Envirement.width-1)*Envirement.width + j),5));
    		
    	}break;
    	
    	case TOP: {
    		
    		for (int i = 0; i < Envirement.width; i= i + 1) 
				input_list.add(new InputNeuron(App.grid.get(i*Envirement.width + Envirement.height-1),5));
    		
    	} break;
    	
    	case BOTTOM:{
    			for (int i = 0; i < Envirement.width; i= i + 1) 
        				input_list.add(new InputNeuron(App.grid.get(i*Envirement.width),5));
    	 }
    		 break;
    	
    	case MIDDLE: {
    		
    		for (int i = 0; i < Envirement.width; i= i + 1) 
    			for (int j = 0; j < Envirement.height; j= j + 1)
    				input_list.add(new InputNeuron(App.grid.get(i*Envirement.width+j),5));
    		
    		break;
    	}
    	}
    	
    	
    }
    
    public InputGenerator() {}
	
    public void addPoint(int i, int j,int frequency) {
    	

    	if(i<Envirement.width && j<Envirement.height) {
        	input_list.add(new InputNeuron(App.grid.get(i*Envirement.width+j),5));
    	}
    	else { 
    		throw new IndexOutOfBoundsException("The selected coordinates are outside of the envirement's range");
    	}
    }

    
    int i = 0;
	public void generate() {
		
		for (InputNeuron n :input_list) {
			if (i % n.frequency == 0) n.neuron.signal();
			else n.neuron.disable();
		}
		
	i++;
	}

}
