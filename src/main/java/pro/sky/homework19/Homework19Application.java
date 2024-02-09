package pro.sky.homework19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.homework19.service.DepartmentService;
import pro.sky.homework19.service.EmployeeService;

@SpringBootApplication
public class Homework19Application {
	public static final EmployeeService service = new EmployeeService();
	public static final DepartmentService deptmntService = new DepartmentService();
		public static void main(String[] args) {
		SpringApplication.run(Homework19Application.class, args);
		service.addEmployee("Мирон", "Леонов", 66700, 2);
		service.addEmployee("Иван", "Маслов", 76200, 1);
		service.addEmployee("Максим", "Смирнов", 85100, 1);
		service.addEmployee("Милана", "Елисеева", 86000, 3);
		service.addEmployee("Елизавета", "Ушакова", 91000, 4);
		service.addEmployee("Иван", "Колосов", 92000, 3);
		service.addEmployee("Артемий", "Лапшин", 80400, 2);
		service.addEmployee("Даниил", "Титов", 87750, 5);
		service.addEmployee("Давид", "Соловьев", 54400, 2);
		service.addEmployee("Анастасия", "Анисимова", 83900, 3);

		}

}
