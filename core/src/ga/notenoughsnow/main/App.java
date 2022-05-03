package ga.notenoughsnow.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

public class App extends ApplicationAdapter {

    public static OrthographicCamera camera;
    public ShapeRenderer shapeRenderer;
	@Override
	public void create () {
		camera = new OrthographicCamera(800,800);
		camera.position.x = 400;
		camera.position.y = 400;


		shapeRenderer = new ShapeRenderer();
		
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		
		camera.update();
		 shapeRenderer.setProjectionMatrix(camera.combined);
		 shapeRenderer.begin(ShapeType.Filled);
		 shapeRenderer.setColor(Color.WHITE);
		 shapeRenderer.line(0, 0, 0, 100, 100, 0);
		 shapeRenderer.end();
		 
       camera.update();
       
	}
	
	@Override
	public void dispose () {
	}
}
