import java.awt.Color;

public class RandomPanel extends WordPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	
	public RandomPanel() {
		super();
		this.color = new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
	}

	public Color getColor() {
		return new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
	}
	
	public String getWord() {
		return "test";
	}
	
	public double changeProb() {
		return 0.01;
	}

}
