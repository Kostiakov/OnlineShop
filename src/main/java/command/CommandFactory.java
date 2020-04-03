package command;

import java.util.List;

import entity.Products;

public class CommandFactory {
	
	private List<Products> cart;
	
	public CommandFactory(List<Products> cart) {
		this.cart=cart;
	}
	
	public Command getCommand(int option) {
		Command command = null;
		switch (option) {
		case 1:
			command = new ShowAllCommand();
			break;
		case 2:
			command = new ShowElementCommand();
			break;
		case 3:
			command = new AddCommand(cart);
			break;
		case 4:
			command = new DeleteCommand(cart);
			break;
		case 5:
			command = new ShowCartCommand(cart);
			break;
		}
		return command;
	}

}
