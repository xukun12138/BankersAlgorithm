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
	
	public BackSuccess(Progress pro){	//���췽��
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
		continueButton.setFont(new Font("����", Font.PLAIN, 16));
		continueButton.setBounds(262, 297, 103, 52);
		panel.add(continueButton);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 69, 411, 197);
		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		getMessage = new JTextArea();
		scrollPane.setViewportView(getMessage);
		getMessage.setEditable(false);//���ɱ༭
		getMessage.setBorder(new TitledBorder("�㷨��������"));//���ñ���
		getMessage.setLineWrap(true);//�����Զ�����
		getMessage.setWrapStyleWord(true);//�����Ե���Ϊ���廻�У�(�����Ὣ�����и������)
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
			//ÿ�������Ϣʱˢ���ı����� ����������ʾ��ĩβ ����ʾ����һ������
			getMessage.setCaretPosition(getMessage.getText().length());
			getMessage.paintImmediately(getMessage.getBounds());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		String s="ȫ�������ѷ�����Դ����ȫ����Ϊ�� ";
		for (int i=0;i<progress.n;i++)
			s += "����"+progress.safeSeq[i]+" ";
			getMessage.append("\r\n"+s);
			//ÿ�������Ϣʱˢ���ı����� ����������ʾ��ĩβ ����ʾ����һ������
			getMessage.setCaretPosition(getMessage.getText().length());
		}

	}
}
