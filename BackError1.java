package ViewFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BackError1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public BackError1() {
		 initialize();
	}
	private void initialize() {
		setTitle("\u7CFB\u7EDF\u5B89\u5168\u6027\u63D0\u793A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 655, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 639, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("    \u5F53\u524D\u7CFB\u7EDF\u4E0D\u5B89\u5168\uFF01\r\n");
		label.setForeground(Color.RED);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 25));
		label.setBounds(194, 83, 256, 108);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u70B9\u51FBcontinue\u8FD4\u56DE\u4E3B\u754C\u9762");
		label_1.setFont(new Font("ËÎÌå", Font.BOLD, 12));
		label_1.setBounds(225, 251, 182, 39);
		panel.add(label_1);
		
		JButton btnContinue = new JButton("continue");
		btnContinue.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// ¼àÌýÆ÷--·µ»Ø°´Å¥
				setVisible(false);
				new MainFrame().setVisible(true);
			}
		});
		btnContinue.setBounds(250, 320, 116, 45);
		panel.add(btnContinue);
	}
}
