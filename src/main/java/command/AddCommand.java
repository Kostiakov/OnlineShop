package command;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entity.Food;
import entity.Nonfood;
import entity.Products;
import service.ServiceImpl;

public class AddCommand implements Command {

	private List<Products> cart;
	
	public AddCommand(List<Products> cart) {
		this.cart=cart;
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		ServiceImpl service = new ServiceImpl();
		List<Products> listNew = service.getProducts();
		System.out.println("Enter name of the product");
		String productName = scanner.next();
		List<Products> someProducts = listNew.stream().filter(i -> i.getName().equals(productName))
				.collect(Collectors.toList());
		if (someProducts.isEmpty()) {
			System.out.println("This product is not in stock");
			return;
		}
		System.out.println("Enter amount");
		Integer productAmount = scanner.nextInt();
		Products theProduct = someProducts.get(0);
		if(productAmount>theProduct.getAmount()) {
			System.out.println("There is no such amount");
			return;
		}
		if (theProduct instanceof Food) {
			Food finalProduct = new Food();
			finalProduct.setName(productName);
			finalProduct.setAmount(productAmount);
			cart.add(finalProduct);
		}
		if (theProduct instanceof Nonfood) {
			Nonfood finalProduct = new Nonfood();
			finalProduct.setName(productName);
			finalProduct.setAmount(productAmount);
			cart.add(finalProduct);
		}
	}

}
