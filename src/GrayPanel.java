import java.awt.Color;

public class GrayPanel extends RandomChangePanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MAX_TONE = 255;
	private double halftime;

	public GrayPanel(double halftime) {
		super();
		this.halftime = halftime;
	}

	@Override
	public Color getColor() {
		int tone = (int) (MAX_TONE/(1+(System.currentTimeMillis()-this.getChangeTime())/this.halftime));
		return new Color(tone, tone, tone);
	}

	@Override
	public double changeProb() {
		// TODO Auto-generated method stub
		return 0.000001;
	}

	@Override
	public String chooseWord() {
		// TODO Auto-generated method stub
		return Application.randomString();
	}

}
