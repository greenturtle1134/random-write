
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class WordPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The last time the word on this panel changed
	 */
	private long changeTime;
	private JLabel label;
	
	public WordPanel() {
		super();
		this.setChangeTime(System.currentTimeMillis());
		this.setLabel(new JLabel(this.getWord()));
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
	public abstract String getWord();

	public void doTick() {
		this.setBackground(getColor());
		if(Math.random()<this.changeProb()) {
			this.getLabel().setText(this.getWord());
			this.setChangeTime(System.currentTimeMillis());
		}
		this.repaint();
	}

}