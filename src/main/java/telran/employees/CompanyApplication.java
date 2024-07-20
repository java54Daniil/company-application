package telran.employees;

import java.util.*;

import telran.io.Persistable;
import telran.view.*;

public class CompanyApplication {

	private static final String FILE_NAME = "employeesTest.data";

	public static void main(String[] args) {
		Company company = new CompanyMapsImpl();
		try {
			((Persistable)company).restore(FILE_NAME);
		} catch (Exception e) {
			
		}
		List<Item> companyItems =
				CompanyApplItems.getCompanyItems(company,
						new HashSet<String>(List.of("Audit", "Development", "QA")));
		companyItems.add(Item.of("Exit & save",
				io -> ((Persistable)company).save(FILE_NAME), true));
		Menu menu = new Menu("Company CLI Application",
				companyItems.toArray(Item[]::new));
		menu.perform(new SystemInputOutput());

	}

}
