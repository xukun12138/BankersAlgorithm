package ViewFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class ResourceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	Progress progress;
	Tools tool=new Tools();
	
	public ResourceFrame(Progress pro) {
		super();
		progress=pro;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public ResourceFrame() {
		initialize();
	}
	
	private void initialize() {
		setTitle("\u5404\u7C7B\u8D44\u6E90\u603B\u6570resource");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 655, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 639, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextField[] textField=new JTextField[progress.m];
		JLabel[] lblNewLabel = new JLabel[progress.m+1];
		
		int x=40;
		for(int j=1;j<progress.m+1;j++) {
			x+=80;
			lblNewLabel[j-1] = new JLabel("资源"+j);
			lblNewLabel[j-1].setBounds(x, 80, 60, 20);
			panel.add(lblNewLabel[j-1]);
		}
		x=40;
		JLabel j1=new JLabel("\u603B\u7684\u8D44\u6E90\uFF1A");
		j1.setFont(new Font("楷体", Font.PLAIN, 20));
		j1.setBounds(40, 92, 100, 32);
		panel.add(j1);
		
		JButton clearButton = new JButton("\u6E05\u7A7A");
		clearButton.setFont(new Font("楷体", Font.PLAIN, 20));
		clearButton.setBounds(128, 304, 93, 46);
		panel.add(clearButton);
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//监听器--重置
				for(int i=0;i<progress.m;i++) {
					textField[i].setText("");
				}
			}
		});
		
		JButton sureButton = new JButton("\u786E\u5B9A");
		sureButton.setFont(new Font("楷体", Font.PLAIN, 20));
		sureButton.setBounds(418, 304, 93, 46);
		panel.add(sureButton);
		sureButton.addMouseListener(new MouseAdapter() {	//监听器 -确定
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] ResourcePa=new int[progress.m];
				for(int j=0;j<progress.m;j++) {
					ResourcePa[j]=tool.getTextToInt(textField[j]);
				}
				boolean test=true;
				
					for(int j=0;j<progress.m;j++) {
						if(ResourcePa[j]<0) {
							test=false;
							break;
						}
					}
				
				if(test) {
					progress.inputResource(ResourcePa);
					progress.currentState();
					progress.isSafe();
					if (progress.FLAG) {
						setVisible(false);
						progress.FLAG=false;
						new BackSuccess(progress).setVisible(true);
					}else {
						setVisible(false);
						new BackError1().setVisible(true);	//错误页面
					}
				}else {
					JOptionPane.showMessageDialog(null,"输入不合法或未输入！");	//弹出警告
				}
				
			}
		});
		for(int j=0;j<progress.m;j++) {
			x+=80;
			textField[j] = new JTextField();
			textField[j].setBounds(x, 100, 60, 20);
			panel.add(textField[j]);
			textField[j].setColumns(10);
		}
		
	}

}
