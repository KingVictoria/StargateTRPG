package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import research.Tech;

public class Reader {
	
	public static void makeTech() throws FileNotFoundException {
		File f = new File("./Stargate TRPG/techs.txt");
		Scanner scan = new Scanner(f);
		
		String name;
		String desc;
		double diff;
		String[] comp;
		
		ArrayList<String> components;
		while(scan.hasNext()) {
			components = new ArrayList<>();
			scan.next("T:");
			name = scan.nextLine().trim();
			scan.next();
			scan.next("desc:");
			desc = scan.nextLine().trim();
			scan.next("diff:");
			diff = Double.parseDouble(scan.nextLine());
			scan.next("comp:");
			String next = scan.next();
			String component = "";
			while(!next.equals("}")) {
				if(next.charAt(0) == '"') {
					if(component.length() > 0) components.add(component.trim());
					component = "";
				}
				component += next.replaceAll("\"", "") + " ";
				next = scan.next();
			}
			if(component.length() > 0) components.add(component.trim());
			comp = new String[components.size()];
			for(int i = 0; i < comp.length; i++)
				comp[i] = components.get(i);
			Main.techs.add(new Tech(name, desc, diff, comp));
		}
		
		scan.close();
		
	}
	
}
