package basic.emplyoeePayrollService.IO;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {

	private ArrayList<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(ArrayList<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner s = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(s);
		employeePayrollService.writeEmployeePayrollData();

	}

	private void readEmployeePayrollData(Scanner s) {
		System.out.println("Enter employee ID");
		int id = s.nextInt();
		System.out.println("Enter employee name");
		String name = s.next();
		System.out.println("Enter employee salary");
		double salary = s.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));

	}

	private void writeEmployeePayrollData() {
		System.out.println("\n Writing employee payroll data to console\n" + employeePayrollList);

	}

}
