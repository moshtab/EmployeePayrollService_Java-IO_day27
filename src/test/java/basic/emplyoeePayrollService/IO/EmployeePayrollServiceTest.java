package basic.emplyoeePayrollService.IO;

import java.util.Arrays;

import org.junit.Test;

import basic.emplyoeePayrollService.IO.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeeDetailsWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrOfEmps = {
				new EmployeePayrollData(1,"Mohsin",35000),
				new EmployeePayrollData(1,"Mohsin",35000),
				new EmployeePayrollData(1,"Mohsin",35000)
				
		};
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
	}

}