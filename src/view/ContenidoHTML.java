package view;

import java.io.File;
import java.util.Scanner;

public class ContenidoHTML {

	public String contenido() {
		String texto = "";
		try {
			File doc = new File("data/html.txt");
			Scanner obj = new Scanner(doc);

			while (obj.hasNextLine())
				texto = texto + obj.nextLine() + "\n";
			obj.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}
		return texto;
	}
}