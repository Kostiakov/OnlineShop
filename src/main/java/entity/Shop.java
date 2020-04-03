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
			System.out.println("�������: 1 ��� ������ ���� �������");
			System.out.println("2 ��� ������ ���������� � ���������� ������");
			System.out.println("3 ��� ���������� ������ � �������");
			System.out.println("4 ��� �������� ������ �� �������");
			System.out.println("5 ��� ������ ���� ������� � �������");
			System.out.println("6 ��� ������ �� ���������");
			int option = scanner.nextInt();
			if(option == 6) {
				break;
			}
			new CommandFactory(cart).getCommand(option).execute();
		}
	}

}
