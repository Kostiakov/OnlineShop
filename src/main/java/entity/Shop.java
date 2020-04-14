package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import command.CommandFactory;
import service.ServiceImpl;

public class Shop {

	public static void main(String[] args) {
		
		ServiceImpl service = new ServiceImpl();

		List<Products> listNew = service.getProducts();
		List<Products> cart = new ArrayList<>();

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter: 1 to show all products");
			System.out.println("2 to show information about specific product");
			System.out.println("3 to add product to cart");
			System.out.println("4 to delete product from cart");
			System.out.println("5 to show all products in cart");
			System.out.println("6 to exit programm");
			int option = scanner.nextInt();
			if(option == 6) {
				break;
			}
			new CommandFactory(cart).getCommand(option).execute();
		}
	}

}
