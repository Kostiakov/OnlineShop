package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import command.AddCommand;
import command.Command;
import command.CompoundCommand;
import command.DeleteCommand;
import command.ShowAllCommand;
import command.ShowCartCommand;
import command.ShowElementCommand;
import service.ServiceImpl;

public class Shop {

	public static void main(String[] args) {
		
		
		/*
		Button button = new Button();
		new ShowCommand(button).execute();
		
		List <Command> list = new ArrayList<>();
		list.add(new ShowCommand(button));
		list.add(new AddCommand(button));
		CompoundCommand compound = new CompoundCommand(list);
		compound.execute();
		*/
		
		
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
			if (option == 1) {
				new ShowAllCommand().execute();
			}
			if (option == 2) {
				new ShowElementCommand().execute();
			}
			if (option == 3) {
				new AddCommand(cart).execute();
			}
			if (option == 4) {
				new DeleteCommand(cart).execute();
			}
			if (option == 5) {
				new ShowCartCommand(cart).execute();
			}
			if (option == 6) {
				break;
			}
		}
	}

}
