import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String LIST_PATH = "words_alpha.txt";
	public WordPanel[] words;
	
	private static String[] wordList;

	@Override
	public void run() {
		while (true) {
			for (WordPanel p : words) {
				p.doTick();
			} 
		}
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File(LIST_PATH));
			while(scanner.hasNext()) {
				strings.add(scanner.nextLine());
			}
			wordList = strings.toArray(new String[0]);
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		JFrame frame = new JFrame("RandomType");
		frame.setSize(1200, 400);
		Application application = new Application(6, 8);
		frame.setContentPane(application);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public Application(int rows, int cols) {
		this.setLayout(new GridLayout(rows, cols));
		int num = rows*cols;
		words = new WordPanel[num];
		for(int i=0; i<num; i++) {
			words[i] = new GrayPanel(100);
			this.add(words[i]);
		}
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public static String randomString() {
		int random = (int) (Math.random()*wordList.length);
		return wordList[random];
	}

}
