package browser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.ArrayList;

import javax.lang.model.type.ErrorType;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

public class mybrowser extends JFrame implements HyperlinkListener {
	/**
	 * 
	 */
	private JButton back, forward, game;

	private JTextField locationtextfield;
	private JEditorPane displaycontent;

	ArrayList<String> pagelist = new ArrayList<>();
	ArrayList<String> pagel = new ArrayList<>();

	public mybrowser() {
		super("JBROW");
		setSize(800, 700);

		super.setResizable(true);
		super.setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				actionexit();

			}

		});

		JMenuBar menubar = new JMenuBar();

		JMenu filemenu = new JMenu("MENU");
		filemenu.addSeparator();
		filemenu.setMnemonic(KeyEvent.VK_M);

		JMenuItem item = new JMenuItem("EXIT");
		item.setMnemonic(KeyEvent.VK_X);
		JMenuItem item2 = new JMenuItem("HISTORY");
		item.setMnemonic(KeyEvent.VK_H);
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				actionexit();
			}
		});
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				history();
			}
		});
		filemenu.add(item);
		filemenu.add(item2);
		menubar.add(filemenu);

		setJMenuBar(menubar);

		// BUTTONPANEL

		JPanel buttonpanel = new JPanel();
		JPanel buttonpanel2 = new JPanel();
		game = new JButton();
		game.setText("Bored ?");
		game.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TTT obj = new TTT();
			}
		});
		buttonpanel.add(game);
		back = new JButton();
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				back();
			}
		});

		back.setText("<<Back");
		back.setEnabled(false);
		back.setBackground(Color.ORANGE);
		forward = new JButton();
		forward.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				forward();
			}
		});

		forward.setText("forward>>");
		forward.setEnabled(false);
		forward.setBackground(Color.GREEN);

		buttonpanel.add(back);
		buttonpanel.add(forward);

		locationtextfield = new JTextField(45);
		locationtextfield.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					actionGo();
				}
			}
		});

		buttonpanel.add(locationtextfield);
		JButton goButton = new JButton("GO");
		/* goButton.setBackground(Color.white); */
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionGo();
			}
		});
		buttonpanel.add(goButton);
		buttonpanel.setBackground(Color.BLACK);

		// Set up page display.
		displaycontent = new JEditorPane();
		displaycontent.setContentType("text/html");
		displaycontent.setBackground(Color.CYAN);
		displaycontent.setEditable(false);
		displaycontent.addHyperlinkListener(this);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(buttonpanel, BorderLayout.NORTH);

		getContentPane().add(new JScrollPane(displaycontent), BorderLayout.CENTER);
		getContentPane().setBackground(Color.BLACK);

	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent event) {
		HyperlinkEvent.EventType eventType = event.getEventType();
		if (eventType == HyperlinkEvent.EventType.ACTIVATED) {
			if (event instanceof HTMLFrameHyperlinkEvent) {
				HTMLFrameHyperlinkEvent linkEvent = (HTMLFrameHyperlinkEvent) event;
				HTMLDocument document = (HTMLDocument) displaycontent.getDocument();
				document.processHTMLFrameHyperlinkEvent(linkEvent);
			} else {
				showpage(event.getURL(), true);
			}
		}
	}

	public static void main(String[] args) {

		mybrowser browser = new mybrowser();
		browser.show();

	}

	public void actionexit() {
		System.exit(0);
	}

	public void back() {

		URL currURL = displaycontent.getPage();

		int currI = pagelist.indexOf(currURL);
		try {

			showpage(new URL((String) pagelist.get(currI - 1)), false);

		} catch (Exception e) {

		}

	}

	public void forward() {
		URL currURL = displaycontent.getPage();

		int currI = pagelist.indexOf(currURL);
		try {

			showpage(new URL((String) pagelist.get(currI + 1)), false);

		} catch (Exception e) {

		}
	}

	public void actionGo() {
		URL url = verifyUrl(locationtextfield.getText());
		if (url != null) {
			showpage(url, true);
		} else {
			invalidurl();
		}

	}

	private void invalidurl() {
		JOptionPane.showMessageDialog(this, ERROR, "Error ,INVALID_URL,TRY AGAIN", JOptionPane.ERROR_MESSAGE);

	}

	public void history() {

		for (int i = 0; i < pagel.size(); i++) {
			System.out.println(pagel.get(i));
		}

	};

	private void showpage(URL page, boolean addtolist) {
		//// add loading sign
		try {
			URL currURL = displaycontent.getPage();

			displaycontent.setPage(page);

			URL newURL = displaycontent.getPage();
			if (addtolist) {

				int listsize = pagelist.size();
				if (listsize > 0) {
					int currlistI = pagelist.indexOf(newURL.toString());

					if (currlistI < listsize) {
						for (int i = listsize - 1; i > currlistI; i--) {
							pagelist.remove(i);
						}
					}

				}
				pagelist.add(newURL.toString());
				pagel.add(newURL.toString());

			}

			locationtextfield.setText(newURL.toString());

			updatebuttons();

		} catch (Exception e) {

			// showError("Unabl to load page");

		}

	}

	private void updatebuttons() {
		if (pagelist.size() < 2) {
			back.setEnabled(false);
			forward.setEnabled(false);
		}

		else {
			URL currURL = displaycontent.getPage();
			int currI = pagelist.indexOf(currURL);
			if (currI >= 2) {
				back.setEnabled(true);
			}
			if (currI < pagelist.size()) {
				forward.setEnabled(true);
			}

		}

	}

	private URL verifyUrl(String url) {
		url = url.toLowerCase();
		if (!url.startsWith("http://")) {
			return null;
		}
		URL verifiedURL = null;
		try {
			verifiedURL = new URL(url);
		} catch (Exception e) {

		}

		return verifiedURL;

	}
}
