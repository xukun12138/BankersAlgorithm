package ViewFrame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RequestFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private final JPanel panel = new JPanel();
	Progress a;
	Tools tool=new Tools();
	public RequestFrame(Progress pro) {
		a=pro;
		initialize();
		
	}

	/**
	 * Create the frame.
	 */
	public RequestFrame() {
		initialize();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		setTitle("\u9700\u6C42");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 655, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 639, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextField[] textField=new JTextField[a.m];
		JLabel[] lblNewLabel = new JLabel[a.m+1];
		
		JLabel lblNewLabel1 = new JLabel("\u8BF7\u6C42\u8FDB\u7A0B\uFF1A");
		lblNewLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel1.setBounds(128, 66, 104, 38);
		panel.add(lblNewLabel1);
		
		int x=40;
		for(int j=0;j<a.m;j++) {
			x+=80;
			lblNewLabel[j] = new JLabel("资源"+(j+1));
			lblNewLabel[j].setBounds(x, 150, 60, 20);
			panel.add(lblNewLabel[j]);
			textField[j] = new JTextField();
			textField[j].setBounds(x, 180, 60, 20);
			panel.add(textField[j]);
			textField[j].setColumns(10);
		}
		
		String[] s=new String[a.n];
		for(int i=0;i<a.n;i++) {
			s[i]="进程"+i;
		}
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(s));
		comboBox.setBounds(341, 73, 170, 28);
		panel.add(comboBox);
		
		JButton analyzeButton = new JButton("\u5206\u6790");
		analyzeButton.setFont(new Font("楷体", Font.PLAIN, 20));
		analyzeButton.setBounds(407, 304, 104, 46);
		panel.add(analyzeButton);
		analyzeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pro = comboBox.getSelectedItem().toString();	
				char[] abc = pro.toCharArray();
				for (int i=0;i<abc.length;i++)
					System.out.println(abc[i]+"->");
					int x = (int)abc[2]-48;
					int[] RequestPa=new int[a.m];
					boolean test=true;
					for(int j=0;j<a.m;j++) {
						RequestPa[j]=tool.getTextToInt(textField[j]);
						if(RequestPa[j]<0)
							test=false;
					}
					if(test) {
						String s=a.request(x, RequestPa);
						System.out.println("RequestFrame  current");
						a.currentState();
						
						if (s.equals("success")) {
							setVisible(false);
							a.FLAG=false;
							new BackSuccess(a).setVisible(true);
						}else {
							setVisible(false);
							new BackError2(a, s).setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null,"输入不合法或未输入！");	//弹出警告
				}
			}
		});
	
		JButton backButton = new JButton("\u4E3B\u9875\u9762");
		backButton.setFont(new Font("楷体", Font.PLAIN, 20));
		backButton.setBounds(128, 304, 104, 46);
		panel.add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new MainFrame().setVisible(true);
			}
		});
	}

}
