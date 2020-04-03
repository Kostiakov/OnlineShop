package command;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entity.Products;
import service.ServiceImpl;

public class ShowElementCommand implements Command {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		ServiceImpl service = new ServiceImpl();
		List<Products> listNew = service.getProducts();
		System.out.println("Введите название товара");
		String productName = scanner.next();
		List<Products> someProducts = listNew.stream().filter(i -> i.getName().equals(productName))
				.collect(Collectors.toList());
		if (someProducts.isEmpty()) {
			System.out.println("Такого товара нет");
			return;
		}
		System.out.println(someProducts);
	}

}
