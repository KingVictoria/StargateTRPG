package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import research.Tech;

public class Main {
	
	public static ArrayList<Tech> techs = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		Reader.makeTech();
		
		Scanner scan = new Scanner(System.in);
		
		main:
		while(true) {
			String input = scan.nextLine();
			
			if(input.equalsIgnoreCase("list")) {
				for(Tech tech: techs) System.out.println(tech.name());
				continue main;
			}
			
			if(input.equalsIgnoreCase("end") || input.equalsIgnoreCase("exit")) {
				break;
			}
			
			if(input.equalsIgnoreCase("help")) {
				System.out.println("list               - Lists all techs");
				System.out.println("end                - Exits program");
				System.out.println("search <substring> - Lists all techs with that substring");
				continue main;
			}
			
			if(input.contains("search ")) {
				input = input.replaceAll("search ", "").toLowerCase().trim();
				for(Tech tech: techs) {
					if(tech.name().toLowerCase().contains(input)) {
						System.out.println(tech.name());
					}
				}
				continue main;
			}
			
			if(input.contains("info ")) {
				input = input.replaceAll("info ", "").toLowerCase().trim();
				for(Tech tech: techs) {
					if(tech.name().toLowerCase().equals(input)) {
						System.out.println("Name: " + tech.name());
						System.out.println(" - Desc: " + tech.desc());
						System.out.println(" - Diff: " + tech.diff());
						System.out.print(" - Comp: ");
						for(int i = 0; i < tech.comp().length - 1; i++)
							System.out.print(tech.comp()[i] + ", ");
						System.out.println(tech.comp()[tech.comp().length - 1]);
					}
				}
				continue main;
			}
			
			if(input.equalsIgnoreCase("clear")) {
				for(int i = 0; i < 100; i++) System.out.println();
				continue main;
			}
			
			System.out.println("Input Invalid");
		}
		
		scan.close();
		
	}

}
