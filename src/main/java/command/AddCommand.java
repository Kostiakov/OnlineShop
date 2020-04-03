package command;

public class AddCommand implements Command {
	
	Button button;
	
	public AddCommand(Button button) {
		this.button=button;
	}

	@Override
	public void execute() {
		button.addItem();
	}

}
