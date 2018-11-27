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

public class BackSuccess extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea getMessage;
	Progress progress;
	
	public BackSuccess(Progress pro){	//构造方法
		progress=pro;
		initialize();
//		myPrint();
	}
	/**
	 * Create the frame.
	 */
	public BackSuccess() {
		initialize();
	}
	
	public void initialize() {
		setTitle("\u5B89\u5168\u6027\u5E8F\u5217");
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
		
		JButton continueButton = new JButton("continue");
		continueButton.setFont(new Font("宋体", Font.PLAIN, 16));
		continueButton.setBounds(262, 297, 103, 52);
		panel.add(continueButton);
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
		continueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				progress.currentState();
				new RequestFrame(progress).setVisible(true);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Thread thread=new myThread();
		thread.start();
		
	}

public class myThread extends Thread{
	public void run() {
		for(int i=0;i<progress.list.size();i++) {
			getMessage.append(progress.list.get(i)+"\r\n");
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
		String s="全部进程已分配资源，安全序列为： ";
		for (int i=0;i<progress.n;i++)
			s += "进程"+progress.safeSeq[i]+" ";
			getMessage.append("\r\n"+s);
			//每次添加信息时刷新文本区域 将滚动条显示在末尾 即显示最新一次输入
			getMessage.setCaretPosition(getMessage.getText().length());
		}

	}
}
