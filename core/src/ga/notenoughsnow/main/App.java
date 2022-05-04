package ga.notenoughsnow.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
 

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;


public class App extends Game {

    public static OrthographicCamera camera;
    public ShapeRenderer shapeRenderer;
    public ShapeRenderer GUI_shapeRenderer;
    public Stage stage;
    private Label saturation_label;
    private float saturation;
    
    Envirement env;

    public static int block = 10;
    
    public static int screen_width = 800;
    public static int screen_height = 800;
    public static int GUI_height = 200;


    
    static ArrayList<Neuron> grid = new ArrayList<Neuron>();

    static Set<Neuron> prev_active_nodes = new HashSet<Neuron>();
    static Set<Neuron> active_nodes = new HashSet<Neuron>();
    static Set<Neuron> next_active_nodes = new HashSet<Neuron>();
    

	static Random r = new Random();
	
	@Override
	public void create () { 
		
		
		setScreen(new Sandbox(this));
	
		
        stage = new Stage();
        saturation_label = new Label("", new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        saturation_label.setPosition(0,10);
        
        stage.addActor(saturation_label);
        
        
		camera = new OrthographicCamera(screen_width,screen_height);
		camera.zoom = (float)(Envirement.height*block)/(screen_height - GUI_height);
		camera.position.x = Envirement.width*block/2;
		camera.position.y = Envirement.height*block/2 - GUI_height*camera.zoom/2;

		shapeRenderer = new ShapeRenderer();
		GUI_shapeRenderer = new ShapeRenderer();
		
		
	}

	@Override
	public void render (){
		super.render();
		
				
				update();
				
				GUI_shapeRenderer.begin(ShapeType.Filled);
				 GUI_shapeRenderer.setColor(Color.BLACK);
				 GUI_shapeRenderer.rect(0, 0, 800, 200);
				 
				 GUI_shapeRenderer.end();
				camera.update();
				 shapeRenderer.setProjectionMatrix(camera.combined);
				 shapeRenderer.begin(ShapeType.Filled);
				 
				 for (Neuron n : grid) {
					 shapeRenderer.setColor(n.color);
					 shapeRenderer.box(n.grid_pos.x*block, n.grid_pos.y*block, 0, block, block, 0);
				 }
				 
				 shapeRenderer.end();
				 
				 
		        camera.update();
		        stage.act();
		        stage.draw();
		        

			}
			
			private int i = 0 ;
		    private int label_control;

			public void update() {
				
				if (i > 60) {
					for ( Neuron n : grid ) {
						for ( Weight w : n.targets) {
							//if (w.value > 0) w.value = w.value / 2f;
						}
					}
					i = 0;
				}
				
				

				for(Neuron n : prev_active_nodes) {
					n.disable();
				}

				for(Neuron n : active_nodes) {
					n.bump();
				}
				
				saturation = (float)active_nodes.size()/Envirement.space_size;
				

		        if ( label_control>5) {
		        	saturation_label.setText(String.format("Saturation : %f", saturation));
		        	label_control = 0;
		        }


				prev_active_nodes.clear();
				prev_active_nodes.addAll(active_nodes);
				active_nodes.clear();
				active_nodes.addAll(next_active_nodes);
				next_active_nodes.clear();
				
				i++;
				label_control++;
				

	}
	
	@Override
	public void dispose () {
	}
}
