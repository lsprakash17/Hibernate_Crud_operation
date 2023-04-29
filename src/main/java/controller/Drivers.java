package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import dao.Driver;

public class Drivers {
	public static void main(String[] args) throws Exception {
		Driver d = new Driver();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter the option");
			System.out.println(
					"1.Add details\n2.Update Name by ID\n3.Remove details by ID\n4.Fetch only video by ID\n5.Fetch all details Ecxept video by id\n6.fetch id and name \n7.EXIT\n");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the url");
				FileInputStream f = new FileInputStream(sc.next());
				byte[] b = new byte[f.available()];
				f.read(b);
				System.out.println("Enter the address");
				String address = sc.next();
				System.out.println("Enter the phno");
				long phno = sc.nextLong();
				d.add(name, b, address, phno);
				break;
			case 2:
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the new name");
				String newname = sc.next();
				d.update(id, newname);
				break;
			case 3:
				System.out.println("Enter the id");
				int ide = sc.nextInt();
				Driver gh = new Driver();
				gh.remove(ide);
				break;
			case 4:
				System.out.println("Enter the id");
				int ids = sc.nextInt();
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter the path");
				String src = sc2.nextLine();
				Driver g = new Driver();
				FileOutputStream j = new FileOutputStream(src);
				g.fetchvid(ids);
				break;
			case 5:
				System.out.println("Enter the id ");
				int idc = sc.nextInt();
				d.fetchall(idc);
				break;
			case 6:
				d.fetchidname();
				break;
			case 7:
				flag = false;
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
}
