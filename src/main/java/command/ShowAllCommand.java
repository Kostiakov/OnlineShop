package command;

import service.ServiceImpl;

public class ShowAllCommand implements Command {
	
	@Override
	public void execute() {
		ServiceImpl service = new ServiceImpl();
		System.out.println(service.getProducts());
	}

}
