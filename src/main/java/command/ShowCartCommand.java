package command;

import java.util.List;

import entity.Products;

public class ShowCartCommand implements Command {
	
	private List<Products> cart;
	
	public ShowCartCommand(List<Products> cart) {
		this.cart=cart;
	}

	@Override
	public void execute() {
		System.out.println(cart);
	}

}
