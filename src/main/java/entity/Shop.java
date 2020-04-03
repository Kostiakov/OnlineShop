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
			System.out.println("Введите: 1 для вывода всех товаров");
			System.out.println("2 для вывода информации о конкретном товаре");
			System.out.println("3 для добавления товара в корзину");
			System.out.println("4 для удаления товара из корзины");
			System.out.println("5 для вывода всех товаров в корзине");
			System.out.println("6 для выхода из программы");
			int option = scanner.nextInt();
			if(option == 6) {
				break;
			}
			new CommandFactory(cart).getCommand(option).execute();
		}
	}

}
