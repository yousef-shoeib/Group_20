package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JButtonStateController implements DocumentListener{
private JButton button;
	
	public JButtonStateController(JButton button) {
		this.button = button;
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		setButtonState(e);
	}

	private void setButtonState(DocumentEvent e) {
		button.setEnabled(e.getDocument().getLength() > 0);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		setButtonState(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		setButtonState(e);
	}
}
