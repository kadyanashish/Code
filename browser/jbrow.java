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

public class jbrow extends JFrame implements HyperlinkListener {
	/**
	 * 
	 */
	private JButton back, forward, game, history, Refresh;
	private JTextField locationtextfield;
	private JEditorPane displaycontent;

	ArrayList<String> pagelist = new ArrayList<>();

	int pageIdx = -1;

	public jbrow() {
		super("JBROW");
		setSize(1000, 1000);

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
		history = new JButton();
		Refresh = new JButton();
		Refresh.setText("Refresh");
		game.setText("Bored ?");
		history.setText("oki ." + "");
		history.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				history();

			}
		});

		game.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TTT obj = new TTT();
			}
		});

		buttonpanel2.add(history);
		buttonpanel.add(game);
		buttonpanel2.add(Refresh);
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
		getContentPane().add(buttonpanel2, BorderLayout.CENTER);

		getContentPane().add(new JScrollPane(displaycontent), BorderLayout.CENTER);
		getContentPane().setBackground(Color.BLACK);

	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		jbrow browser = new jbrow();
		browser.show();

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
				int psize = pagelist.size();
				for (int i = pageIdx + 1; i < psize; i++) {
					pagelist.remove(i);
				}

				pageIdx++;

				locationtextfield.setText(event.getURL().toString());
				showpage(event.getURL(), true);
			}
		}
	}

	public void back() {

		pageIdx--;
		try {
			locationtextfield.setText(pagelist.get(pageIdx));
			showpage(new URL((String) pagelist.get(pageIdx)), false);

		} catch (Exception e) {

		}

	}

	public void forward() {
		pageIdx++;
		try {
			locationtextfield.setText(pagelist.get(pageIdx));
			showpage(new URL((String) pagelist.get(pageIdx)), false);

		} catch (Exception e) {

		}
	}

	public void history() {

		for (int i = 0; i < pagelist.size(); i++) {
			System.out.println(pagelist.get(i));
		}

	};

	private void showpage(URL page, boolean addtolist) {
		//// add loading sign
		try {
			displaycontent.setPage(page);
			if (addtolist) {
				if (pagelist.size() > 0 && pagelist.indexOf(page.toString()) == pagelist.size() - 1) {
					// nothing to do
				} else {
					pagelist.add(page.toString());
				}
			}

			updatebuttons();

		} catch (Exception e) {

			// showError("Unabl to load page");

		}

	}

	private void updatebuttons() {
		back.setEnabled(false);
		forward.setEnabled(false);

		if (pageIdx > 0) {
			back.setEnabled(true);
		}

		if (pageIdx < pagelist.size() - 1) {
			forward.setEnabled(true);
		}
	}

	public void actionGo() {
		URL url = verifyUrl(locationtextfield.getText());
		if (url != null) {
			int psize = pagelist.size();
			for (int i = pageIdx + 1; i < psize; i++) {
				pagelist.remove(i);
			}

			pageIdx++;

			showpage(url, true);
		} else {
			invalidurl();
		}

	}

	public void actionexit() {
		System.exit(0);

	}

	private void invalidurl() {
		JOptionPane.showMessageDialog(this, ERROR, "Error ,INVALID_URL,TRY AGAIN", JOptionPane.ERROR_MESSAGE);
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
