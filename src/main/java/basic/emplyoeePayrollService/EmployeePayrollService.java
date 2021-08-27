package basic.emplyoeePayrollService.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner s = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(s);
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);

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

	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println("\n Writing employee payroll data to console\n" + employeePayrollList);
		} else if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
	}

	public void printData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().printData();
		}
	}

	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO)) {
			return new EmployeePayrollFileIOService().countEntries();
		}
		return 0;
	}

}
