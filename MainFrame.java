package ViewFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -2752057241566840135L;
	private JPanel contentPane;
	private JTextField sourceTextField;
	private JTextField processTextField;
	Tools tool=new Tools();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 655, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 639, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel logoLabel = new JLabel("\u94F6\u884C\u5BB6\u7B97\u6CD5");
		logoLabel.setFont(new Font("楷体", Font.PLAIN, 28));
		logoLabel.setBounds(241, 31, 146, 46);
		panel.add(logoLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D44\u6E90\u79CD\u7C7B\u6570\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(153, 111, 120, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8FDB\u7A0B\u6570\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(153, 200, 86, 31);
		panel.add(lblNewLabel_2);
		
		sourceTextField = new JTextField();
		sourceTextField.setBounds(347, 113, 146, 31);
		panel.add(sourceTextField);
		sourceTextField.setColumns(10);
		
		processTextField = new JTextField();
		processTextField.setBounds(347, 202, 146, 31);
		panel.add(processTextField);
		processTextField.setColumns(10);
		
		processTextField.addKeyListener(new KeyListener() {
		    @Override
		    public void keyPressed(KeyEvent e) {		//对回车监听
		        	if(e.getKeyChar() == KeyEvent.VK_ENTER){
		    			int source=tool.getTextToInt(sourceTextField);
		    		    int process=tool.getTextToInt(processTextField);
		        		if(process>0 && source>0 && process<7 && source<7) {
		        			Progress a=new Progress();
		        			a.n=process;
		        			a.m=source;
		        			a.start();
		        			setVisible(false);
		        			new MaxFrame(a).setVisible(true);
		        		}else {
				        	JOptionPane.showMessageDialog(null,"输入不合法或未输入！");	//弹出警告
				        }
		        	}
		    }
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton sureButton = new JButton("\u786E\u5B9A");	//确定
		sureButton.setForeground(new Color(0, 255, 0));
		sureButton.setFont(new Font("楷体", Font.PLAIN, 20));
		sureButton.setBounds(418, 304, 93, 46);
		panel.add(sureButton);
		sureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int source=tool.getTextToInt(sourceTextField);
			    int process=tool.getTextToInt(processTextField);
			    
		//	    System.out.println(process+"hhh"+source);
			    
			    if(process>0 && source>0 && process<7 && source<7) {
			    	Progress a=new Progress();
			    	a.n=process;
			    	a.m=source;
			    	a.start();
			    	setVisible(false);
					new MaxFrame(a).setVisible(true);
			    }else {
			    	JOptionPane.showMessageDialog(null,"输入不合法或未输入！");	//弹出警告
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		
		JButton resetButton = new JButton("\u91CD\u7F6E");	//重置
		resetButton.setForeground(new Color(255, 0, 0));
		resetButton.setFont(new Font("楷体", Font.PLAIN, 20));
		resetButton.setBounds(128, 304, 93, 46);
		panel.add(resetButton);
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sourceTextField.setText("");
				processTextField.setText("");
			}
		});
		
	}
}
