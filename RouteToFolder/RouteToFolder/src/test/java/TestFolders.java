import java.io.File;

public class TestFolders {

	public static void main(String[] args) {
		File firstPath = new File("/Camel/");
		File secondPath = new File("/Camel1/");
		for (File file : firstPath.listFiles()) {
		    assertTrue(new File(secondPath, file.getName()).exists());
		}


	}

	private static void assertTrue(boolean exists) {
	
		return;
	}

	

}
