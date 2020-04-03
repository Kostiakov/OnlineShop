package command;

public class DeleteCommand implements Command {
	
	Button button;
	
	public DeleteCommand(Button button) {
		this.button=button;
	}

	@Override
	public void execute() {
		button.deleteItem();
	}

}
