import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserInterface extends JFrame {

	public UserInterface() {
		setTitle("RandomDNAGenerator");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel l1, l2, l3, l4, l5;
		JTextField t1, t2, t3, t4, t5;

		l1 = new JLabel("Min Sequence Length");
		l1.setBounds(50, 50, 150, 30);
		l2 = new JLabel("Max Sequence Length");
		l2.setBounds(50, 125, 150, 30);
		l3 = new JLabel("Number of Sequences");
		l3.setBounds(50, 200, 150, 30);
		l4 = new JLabel("Name of Order");
		l4.setBounds(50, 275, 100, 30);
		l5 = new JLabel("Sequence Start");
		l5.setBounds(50, 350, 100, 30);

		add(l1); add (l2); add(l3); add(l4); add(l5);

		t1 = new JTextField();
		t1.setBounds(250, 50, 100, 30);
		t2 = new JTextField();
		t2.setBounds(250, 125, 100, 30);
		t3 = new JTextField();
		t3.setBounds(250, 200, 100, 30);
		t4 = new JTextField();
		t4.setBounds(250, 275, 100, 30);
		t5 = new JTextField();
		t5.setBounds(250, 350, 100, 30);


		add(t1); add(t2); add(t3); add(t4); add(t5);


		JButton b1 = new JButton("Generate");
		b1.setBounds(150, 400, 150, 30);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int min = new Integer(t1.getText());
					int max = new Integer(t2.getText());
					int seqAmm = new Integer(t3.getText());
					String name = t4.getText();
					int seqStart = new Integer(t5.getText());

					if (!textCheck(min, max, seqAmm)) {
						return;
					}
					if (!t1.getText().equals("") && !t2.getText().equals("") && !t3.getText().equals("") && !t4.getText().equals("") && !t5.getText().equals("")) {
						String path = System.getProperty("user.home") + "/Desktop";
						RandomDNA dna = new RandomDNA(min, max, seqAmm);
						ExportToExcel.Export(path, name, dna.getDNA(), seqStart);
						sucess();
					} else {
						failure();
					}
				} catch (Exception e1) {
					failure();
				}
			}
		});
		add(b1);


		setLayout(null);
	}

	private void failure() {
		JOptionPane.showMessageDialog(this, "Not all fields filled out, or filled out incorrectly");
	}
	private void sucess() {
		JOptionPane.showMessageDialog(this, "Sucessful generation, check desktop");
	}
	private boolean textCheck(int min, int max, int seqAmm) {
		if (min > max) {
			JOptionPane.showMessageDialog(this, "the minimum cannot be greater than the maximum length");
			return false;
		}
		if (min <= 0 || min > 10000) {
			JOptionPane.showMessageDialog(this, "The minimum cannot be less than 0 or larger than 10,000");
			return false;
		}
		if (max <= 0 || max > 10000) {
			JOptionPane.showMessageDialog(this, "The maximum cannot be less than 0 or larger than 10,000");
			return false;
		}
		if (seqAmm <= 0 || seqAmm > 96) {
			JOptionPane.showMessageDialog(this, "Can only have between 1 and 96 sequences per plate");
			return false;
		}
		return true;
	}

}
