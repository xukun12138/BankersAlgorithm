package ViewFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Font;

public class BackError2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JFrame frame;
	Progress a;
	String str;
	JTextArea getMessage;
	
	public BackError2(Progress b,String s) {
		a=b;
		str=s;
		initialize();
		
	}

	/**
	 * Create the frame.
	 */
	public BackError2() {
		initialize();
	}
	
	private void initialize() {
		setTitle("\u8D44\u6E90\u8BF7\u6C42\u5B89\u5168\u6027\u68C0\u67E5");
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
		
		JButton button = new JButton("continue");
		button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		button.setBounds(251, 296, 138, 46);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new RequestFrame(a).setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 69, 411, 197);
		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		getMessage = new JTextArea();
		scrollPane.setViewportView(getMessage);
		getMessage.setEditable(false);//不可编辑
		getMessage.setBorder(new TitledBorder("算法分析过程"));//设置标题
		getMessage.setLineWrap(true);//设置自动换行
		getMessage.setWrapStyleWord(true);//设置以单词为整体换行，(即不会将单词切割成两半)
		
		Thread tt=new myThread();
		tt.start();
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				new RequestFrame(a).setVisible(true);
			}
		});
		
	}
	
	
	public class myThread extends Thread{
		public void run() {
			for(int i=0;i<a.list.size();i++) {
				getMessage.append(a.list.get(i)+"\r\n");
				//每次添加信息时刷新文本区域 将滚动条显示在末尾 即显示最新一次输入
				getMessage.setCaretPosition(getMessage.getText().length());
				getMessage.paintImmediately(getMessage.getBounds());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				getMessage.append("\r\n"+str);
				//每次添加信息时刷新文本区域 将滚动条显示在末尾 即显示最新一次输入
				getMessage.setCaretPosition(getMessage.getText().length());
			}

		}

}
