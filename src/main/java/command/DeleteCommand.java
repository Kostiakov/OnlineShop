package command;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import entity.Products;

public class DeleteCommand implements Command {
	
	private List<Products> cart;
	
	public DeleteCommand(List<Products> cart) {
		this.cart=cart;
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¬ведите название товара");
		String productDelete = scanner.next();
		Predicate<Products> theProducts = pr -> pr.getName().equals(productDelete);
		cart.removeIf(theProducts);
	}

}
