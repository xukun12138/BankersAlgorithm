package ViewFrame;

import javax.swing.JTextField;

public class Tools {
	public int getTextToInt(JTextField a) {
		String s=a.getText().toString();
		int n;
		if (s.equals(""))
			return -1;
		else {
		    n=Integer.parseInt(s);
		    return n;
		}
	}
}
