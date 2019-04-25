package com.semairem.otoGaleri;

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Program {


	private static Connection con = null;

	static Scanner scanner = new Scanner(System.in);



	public static void main(String[] args) {

		boolean donguDevamEdiyor = true;
		do {
			
			System.out.println("");
			Menu.menuYazdir();
			System.out.println("");
			System.out.print("Seçiminiz=");
			System.out.println("");
			int secim = scanner.nextInt();
			switch (secim) {

			case 1:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Sorgulanacak");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.aracSorgulama();
				System.out.println("");
				
				break;

			case 2:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.arabaEkleme();
				System.out.println("");
				break;

			case 3:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Kiralanacak Veya Satýn Alýnacak");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.araclariListeleme();
				Methodlar.araclariSecme();
				
					
				

				break;

			case 4:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.araclariListeleme();
				System.out.println("");

				break;

			case 5:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çalýþanlar Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.calisanlariListeleme();
				System.out.println("");
				
				break;

			case 6:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çalýþan Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.calisanEkleme();
				System.out.println("");

				break;

			case 7:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çýkýþ Yapýlacak");
				System.out.println("-------------------------------");
				System.out.println("");
				donguDevamEdiyor = false;

				break;

			default:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Hatalý Seçim Yaptýnýz");
				System.out.println("-------------------------------");
				System.out.println("");

				break;
			}
		} while (donguDevamEdiyor);
	}

	
}