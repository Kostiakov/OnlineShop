package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import command.AddCommand;
import command.Button;
import command.Command;
import command.CompoundCommand;
import command.ShowCommand;
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
			System.out.println("�������: 1 ��� ������ ���� �������");
			System.out.println("2 ��� ������ ���������� � ���������� ������");
			System.out.println("3 ��� ���������� ������ � �������");
			System.out.println("4 ��� �������� ������ �� �������");
			System.out.println("5 ��� ������ ���� ������� � �������");
			System.out.println("6 ��� ������ �� ���������");
			int option = scanner.nextInt();
			if (option == 1) {
				System.out.println(listNew);
			}
			if (option == 2) {
				System.out.println("������� �������� ������");
				String productName = scanner.next();
				List<Products> someProducts = listNew.stream().filter(i -> i.getName().equals(productName))
						.collect(Collectors.toList());
				if (someProducts.isEmpty()) {
					System.out.println("������ ������ ���");
					continue;
				}
				System.out.println(someProducts);
			}
			if (option == 3) {
				System.out.println("������� �������� ������");
				String productName = scanner.next();
				List<Products> someProducts = listNew.stream().filter(i -> i.getName().equals(productName))
						.collect(Collectors.toList());
				if (someProducts.isEmpty()) {
					System.out.println("������ ������ ���");
					continue;
				}
				System.out.println("������� ����������");
				Integer productAmount = scanner.nextInt();
				Products theProduct = someProducts.get(0);
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
			if (option == 4) {
				System.out.println("������� �������� ������");
				String productDelete = scanner.next();
				Predicate<Products> theProducts = pr -> pr.getName().equals(productDelete);
				cart.removeIf(theProducts);
			}
			if (option == 5) {
				System.out.println(cart);
			}
			if (option == 6) {
				break;
			}
		}
	}

}
