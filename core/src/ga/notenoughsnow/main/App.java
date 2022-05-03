package ga.notenoughsnow.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
 

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;


public class App extends ApplicationAdapter {

    public static OrthographicCamera camera;
    public ShapeRenderer shapeRenderer;
    

    public static int width = 80;
    public static int height = 80;
    public static int block = 10;
     

    
    static ArrayList<Node> grid = new ArrayList<Node>();

    static Set<Node> prev_active_nodes = new HashSet<Node>();
    static Set<Node> active_nodes = new HashSet<Node>();
    static Set<Node> next_active_nodes = new HashSet<Node>();

	static Random r = new Random();
	
	@Override
	public void create () { 

		camera = new OrthographicCamera(800,800);
		camera.position.x = 400;
		camera.position.y = 400;


	shapeRenderer = new ShapeRenderer();
		
		for (int i = 0; i < width; i= i + 1) 
			for (int j = 0; j < height; j= j + 1)
				grid.add(new Node(i,j));
		
		for ( Node n : grid)
			n.add_weights();
		
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
				{
					grid.get(0).signal();
					grid.get(391).signal();
					grid.get(6100).signal();
					grid.get(3600).signal();

					update();
				}
					

				camera.update();
				 shapeRenderer.setProjectionMatrix(camera.combined);
				 shapeRenderer.begin(ShapeType.Filled);
				 
				 for (Node n : grid) {
					 shapeRenderer.setColor(n.color/255f, 0/255f, 0/255f, 1);
					 shapeRenderer.box(n.grid_pos.x*block, n.grid_pos.y*block, 0, block, block, 0);
				 }
				 
				 shapeRenderer.end();

		        camera.update();

			}
			
			int i = 0 ;
			
			public void update() {
				
				if (i%60 == 0) {
					for ( Node n : grid ) {
						for ( Weight w : n.targets) {
							//if (w.value > 0) w.value = w.value / 2f;
						}
					}
				}
				
				i++;
				

				for(Node n : prev_active_nodes) {
					n.disable();
				}

				for(Node n : active_nodes) {
					n.bump();
				}
				
				Gdx.app.log("hi", Integer.toString(active_nodes.size()));
				

				prev_active_nodes.clear();
				
				
				prev_active_nodes.addAll(active_nodes);
				

				active_nodes.clear();
				active_nodes.addAll(next_active_nodes);
				

				
				next_active_nodes.clear();
				
				
	}
	
	@Override
	public void dispose () {
	}
}
