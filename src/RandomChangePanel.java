
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public abstract class RandomChangePanel extends WordPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The last time the word on this panel changed
	 */
	private long changeTime;
	private JLabel label;
	
	public RandomChangePanel() {
		super();
		this.setChangeTime(System.currentTimeMillis());
		this.setLabel(new JLabel(this.chooseWord()));
		this.getLabel().setForeground(Color.WHITE);
		this.getLabel().setFont(new Font("Serif", Font.BOLD, 28));
		this.add(label);
		this.setOpaque(true);
	}
	
	public long getChangeTime() {
		return changeTime;
	}

	private void setChangeTime(long changeTime) {
		this.changeTime = changeTime;
	}

	protected JLabel getLabel() {
		return label;
	}

	private void setLabel(JLabel label) {
		this.label = label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public abstract Color getColor();
	public abstract double changeProb();
	public abstract String chooseWord();

	/* (non-Javadoc)
	 * @see WordPanel#doTick()
	 */
	@Override
	public void doTick() {
		this.setBackground(getColor());
		if(Math.random()<this.changeProb()) {
			this.changeText();
		}
		this.repaint();
	}

	public void changeText() {
		this.getLabel().setText(this.chooseWord());
		this.setChangeTime(System.currentTimeMillis());
	}
	
	@Override
	public void onClick(MouseEvent e) {
		this.changeText();
	}

}