package basic.emplyoeePayrollService.NIOdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOdemo {

	public static void main(String[] args) throws IOException {
		readFiles();
		writeFiles();
		walkFiles();
		checkFileExists();
		deleteFileIfExists();
		createDirectory();
		createEmptyFile();
		listFilesDirectories();
		walkAndDeleteFilesInDirectory();

	}

	private static void readFiles() throws IOException {
		Path path = Paths.get("src/main/java/resources/m.txt");
		System.out.println(new String(Files.readAllBytes(path)));

	}

	private static void writeFiles() throws IOException {
		Path path = Paths.get("src/main/java/resources/q.txt");
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String data = b.readLine();
		Files.write(path, data.getBytes());
	}

	private static void walkFiles() throws IOException {
		Path path = Paths.get("src/main/java/resources");

		Files.walk(path).filter(Files::isRegularFile).forEach(System.out::println);

	}

	private static void checkFileExists() {
		Path path = Paths.get("src/main/java/resources/demo.txt");
		System.out.println(Files.exists(path));
	}

	private static void deleteFileIfExists() throws IOException {
		Path path = Paths.get("src/main/java/resources/w.txt");
		System.out.println(Files.deleteIfExists(path));

	}

	private static void createDirectory() {

		Path path = Paths.get("src/main/java/resources/a/");
		try {
			Files.createDirectory(path);
		} catch (IOException e) {
			System.out.println("Directory already exists");
		}
	}

	private static void createEmptyFile() {
		Path path = Paths.get("src/main/java/resources/empty.txt");
		try {
			Files.createFile(path);
		} catch (IOException e) {
			System.out.println("File already Exists");
		}

	}

	private static void listFilesDirectories() throws IOException {
		Path path = Paths.get("src/main/java/resources/list.txt");

		Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);

	}

	private static void walkAndDeleteFilesInDirectory() throws IOException {
		Path path4 = Paths.get("src/main/java/resources");
		Files.walk(path4).forEach(path5 -> {
			try {
				Files.deleteIfExists(path5);

			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});

	}

}