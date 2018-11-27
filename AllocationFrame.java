package ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AllocationFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	Progress progress;
	Tools tool=new Tools();
	
	public AllocationFrame(Progress pro) {
		progress=pro;
		initialize();
		progress.currentState();
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AllocationFrame frame = new AllocationFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	
	public AllocationFrame() {
		initialize();
	}

	
	private void initialize() {
		setTitle("\u5206\u914DAllocation");
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
		
		JTextField[][] textField = new JTextField[progress.n][progress.m];
		
		JButton sureButton = new JButton("\u786E\u5B9A");
		sureButton.setFont(new Font("����", Font.PLAIN, 20));
		sureButton.setBounds(418, 304, 93, 46);
		panel.add(sureButton);
		sureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//������--ȷ��
				int[][] AllocationPa = new int[progress.n][progress.m];
				for(int i=0;i<progress.n;i++) {
					for(int j=0;j<progress.m;j++) {
						AllocationPa[i][j]=tool.getTextToInt(textField[i][j]);
					}
				}
				
				boolean test=true;
				for(int i=0;i<progress.n;i++) {
					for(int j=0;j<progress.m;j++) {
						if(AllocationPa[i][j]<0) {
							test=false;
							break;
						}
					}
				}
				if(test) {
					progress.inputAllocation(AllocationPa);
				
					//��ת���´���
					setVisible(false);
					new ResourceFrame(progress).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"���벻�Ϸ���δ���룡");	//��������
				}
			}
		});
		
		JButton clearButton = new JButton("\u6E05\u7A7A");
		clearButton.setFont(new Font("����", Font.PLAIN, 20));
		clearButton.setBounds(128, 304, 93, 46);
		panel.add(clearButton);
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// ������--���
				for(int i=0;i<progress.n;i++) {
					for(int j=0;j<progress.m;j++) {
						textField[i][j].setText("");
					}
				}
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		int y=20;   //��һ����ʼλ��
		for(int i=0;i<progress.n+1;i++) {
			int x=20;    //��һ����ʼλ��
			JLabel[][] lblNewLabel = new JLabel[progress.n+1][progress.m+1];
			if(i==0) {
				for(int j=1;j<progress.m+1;j++) {
					x+=80;
					lblNewLabel[i][j-1] = new JLabel("��Դ"+j);
					lblNewLabel[i][j-1].setBounds(x, y, 60, 20);
					panel.add(lblNewLabel[i][j-1]);
				}
			}
			else {
				int j=0;
				lblNewLabel[i][j] = new JLabel("����"+(i-1));
				lblNewLabel[i][j].setBounds(x, y, 60, 20);
				panel.add(lblNewLabel[i][j]);
				x+=80;
				for(j=0;j<progress.m;j++) {
					textField[i-1][j] = new JTextField();
					textField[i-1][j].setBounds(x, y, 60, 20);
					panel.add(textField[i-1][j]);
					textField[i-1][j].setColumns(10);
					x+=80;
				}
			}
			y+=20;
		}	
		
	}
	

}
