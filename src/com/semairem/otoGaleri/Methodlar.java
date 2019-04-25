package com.semairem.otoGaleri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Methodlar {
	private static Connection con = null;
//	-------------------------------------------------------------------------------------------------------------------

	public static void arabaEkleme() {
		Scanner scanner=new Scanner(System.in);
		OtoGaleri otoGaleri = new OtoGaleri();
		int id = otoGaleri.getId();
		String durumu=otoGaleri.getDurumu();
		System.out.println("Arac�n Durumunu Yaz�n�z");
		durumu=scanner.next();
		System.out.println("Ara� T�r�n� Giriniz(Otomobil, Kamyon, Motor vb)");
		String aracTuru = otoGaleri.getAracTuru();
		aracTuru = scanner.next();
		System.out.println("Ara� Tipini Giriniz(Sat�l�k/Kiral�k)");
		String aracTipi = otoGaleri.getAracTuru();
		aracTipi = scanner.next();
		System.out.println("Arac�n Modelini Giriniz");
		String modeli = otoGaleri.getModeli();
		modeli = scanner.next();
		System.out.println("Yak�t T�r�n� Giriniz");
		String yakiti = otoGaleri.getYakiti();
		yakiti = scanner.next();
		System.out.println("araban�n Markas�n� Giriniz");
		String markasi = otoGaleri.getMarkasi();
		markasi = scanner.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			String sorgu = "INSERT INTO arabaOlusturma ( aracTuru, aracTipi,  markasi, modeli, yakiti,id,durumu) VALUES"
					+ " (?,?,?,?,?,?,?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setString(1, aracTuru);
			prepareStatement.setString(2, aracTipi);
			prepareStatement.setString(3, markasi);
			prepareStatement.setString(4, modeli);
			prepareStatement.setString(5, yakiti);
			prepareStatement.setInt(6, id);
			prepareStatement.setString(7, durumu);

			prepareStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu. Ba�lant� bile kapat�lamad�.");
			}
		}
		System.out.println("Kay�t eklendi");
	}
	
//	----------------------------------------------------------------------------------------------------------------------

	public static void araclariListeleme() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from arabaOlusturma");
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				System.out.println("No    Arac�n T�r�       Arac�n Tipi      Arac�n Modeli      Arac�n Yak�t�     Arac�n Markas�    Arac�n Durumu");
				System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "      -      " + modeli + "   -    " + yakiti + "   -    " + markasi+"   -   "+durumu);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu. Ba�lant� bile kapat�lamad�.");
			}
		}
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------
	
	public static void calisanEkleme()
	{
		Scanner scanner=new Scanner(System.in);
		Calisan calisan=new Calisan();
		int id=calisan.getId();
		System.out.println("�al��an�n Ad�n� Giriniz");
		String adi=calisan.getAdi();
		adi = scanner.next();
		System.out.println("�al��an�n Soyad�n� Giriniz");
		String soyadi=calisan.getSoyadi();
		soyadi = scanner.next();
		System.out.println("�al��an�n Ya��n� Giriniz");
		int yasi=calisan.getYasi();
		yasi = scanner.nextInt();
		System.out.println("�al��an�n G�revini Yaz�n�z");
		String gorevi=calisan.getGorevi();
		gorevi = scanner.next();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			String sorgu = "INSERT INTO calisanOlusturma ( id, adi, soyadi, yasi, gorevi) VALUES"
					+ " (?,?,?,?,?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, adi);
			prepareStatement.setString(3, soyadi);
			prepareStatement.setInt(4, yasi);
			prepareStatement.setString(5, gorevi);
			
			

			prepareStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu. Ba�lant� bile kapat�lamad�.");
			}
		}
		System.out.println("Kay�t eklendi");
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------
	
	public static void calisanlariListeleme()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from calisanolusturma");
			while (rs.next()) {
				int id = rs.getInt(1);
				String adi = rs.getString(2);
				String soyadi = rs.getString(3);
				String yasi = rs.getString(4);
				String gorevi = rs.getString(5);
				
				System.out.println(id + " " + adi + " " + soyadi + " " + yasi + " " + gorevi);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu. Ba�lant� bile kapat�lamad�.");
			}
		}
		
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------
	
	public static void araclariSecme() {
		Scanner scanner=new Scanner(System.in);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from arabaOlusturma");
			
			System.out.println("Kiralamak veya Sat�n Almak �stede�iniz Arac�n Numaras�n� Yaz�n�z");
			int al�nacakArabaninIdNumarasi=scanner.nextInt();
			for(int i=0;i<=al�nacakArabaninIdNumarasi;i++)
			{
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				if(id==al�nacakArabaninIdNumarasi){
					System.out.println(id + " " + aracTuru + " " + aracTipi + " " + modeli + " " + yakiti + " " + markasi+durumu);
					System.out.println("Kiralamak Veya Sat�n Almak �stedi�inize Emin Misiniz?(evet/hay�r)");
					String secim=scanner.next();
					
					switch (secim) {
					case "evet":
						durumu="Se�ildi";
						System.out.println("No  Arac�n T�r�   Arac�n Tipi     Arac�n Modeli    Arac�n Yak�t�   Arac�n Markas�   Arac�n Durumu");
						System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "   -    " + modeli + "   -    " + yakiti + "   -    " + markasi+"   -   "+durumu);
						break;
						
					case "hay�r":
						
						break;

					default:
						System.out.println("Hatal� Se�im Yapt�n�z");
						break;
					}
					
				}
			}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu. Ba�lant� bile kapat�lamad�.");
			}
		}
	}
	
//	------------------------------------------------------------------------------------------------------------------------------
 public static void aracSorgulama() {
	 
	 Scanner scanner =new Scanner(System.in);
	 System.out.println("1.Ara� Tipi");
	 System.out.println("2.Ara� T�r�");
	 System.out.println("3.Markas�");
	 System.out.println("4.Modeli");
	 System.out.println("5.Yak�t T�r�");
	 System.out.println("L�tfen ara� sorgulatmak i�in sorgulamk istedi�iniz ba�l���n numaras�n� yaz�n�z");
	 int secimNumarasi=scanner.nextInt();
//	 System.out.println("istedi�iniz �zelli�i yaz�n�z");
//	 String secimOzelligi =scanner.next();
	 
	 Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/otoGaleri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from arabaOlusturma");
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				
				
				switch (secimNumarasi) {
				case 1:
					
					
					System.out.println(aracTipi);
					break;
					
				case 2:
					System.out.println(aracTuru);
					break;
						
				case 3:
					System.out.println(markasi);
					break;
	
				case 4:
					System.out.println(modeli);
					break;
	
				case 5:
					System.out.println(yakiti);
					break;
	
	

				default:
					break;
				}
				
				
				
				
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu. Ba�lant� bile kapat�lamad�.");
			}
		}
	 
	 
	 
	 
 }

}
