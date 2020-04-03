package command;

public class ShowCommand implements Command {
	
	Button button;
	
	public ShowCommand(Button button) {
		this.button=button;
	}

	@Override
	public void execute() {
		button.showItem();
	}

}
