package basic.emplyoeePayrollService.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
	public String payrollFileName = "payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String empDataString = employee.toString().concat("\n");
			empBuffer.append(empDataString);
		});
		try {
			Files.write(Paths.get(payrollFileName), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public void printData() {
		try {
			Files.lines(new File(payrollFileName).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(payrollFileName).toPath()).count();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return entries;
	}

}
