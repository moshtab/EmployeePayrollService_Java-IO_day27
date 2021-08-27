package basic.emplyoeePayrollService.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
	public String payrollFileName = "payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach( employee ->{
			String empDataString = employee.toString().concat("\n");
			empBuffer.append(empDataString);
		});
		try {
			Files.write(Paths.get(payrollFileName), empBuffer.toString().getBytes());
		}catch(IOException e) {
			e.getStackTrace();
		}
		
	}

}
