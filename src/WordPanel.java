import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public abstract class WordPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract void doTick();
	public abstract void onClick(MouseEvent e);

}