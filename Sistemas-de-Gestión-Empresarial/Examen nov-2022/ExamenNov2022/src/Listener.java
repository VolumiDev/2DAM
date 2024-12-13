import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
	private Luncher l;
	
	public Listener(Luncher l) {
		super();
		this.l = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "btnEvaluation": 
			InternalEvaluation ev = new InternalEvaluation();
			l.getContentPane().removeAll();
			l.getContentPane().add(ev);
			break;
		}
	}

}
