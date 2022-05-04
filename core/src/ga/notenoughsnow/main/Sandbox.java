package ga.notenoughsnow.main;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class Sandbox implements Screen {
	
	private App app;
	private InputGenerator inGen;
	
	public Sandbox(App app) {
		this.app = app;
		
		NeuronInfo n_info = new NeuronInfo(20,5,5);
		
		new Envirement(60,60,n_info);
		
		inGen = new InputGenerator(InputType.InputSource.LEFT,InputType.SignalFrequency.UNIFORM,50);
		
		//inGen = new InputGenerator();
		//inGen.addPoint(0, 0,1);
		//inGen.addPoint(0, 1,1);

	}

	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0, 1);

		inGen.generate();
		
	}

	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	

}
