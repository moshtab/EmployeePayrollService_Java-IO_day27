package basic.emplyoeePayrollService.IO;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import basic.emplyoeePayrollService.IO.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeeDetailsWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrOfEmps = { new EmployeePayrollData(1, "Mohsin", 35000),
				new EmployeePayrollData(2, "Sumer", 35000), new EmployeePayrollData(3, "Sofyan", 35000)

		};
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		assertEquals(3, entries);

	}

	@Test
	public void given3EmployeeDetailsWhenReadingToFileShouldMatchEmployeeCounts() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entries = employeePayrollService.readData(IOService.FILE_IO);
		assertEquals(6, entries);

	}

}
