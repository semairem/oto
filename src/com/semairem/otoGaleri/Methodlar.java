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
		System.out.println("Aracýn Durumunu Yazýnýz");
		durumu=scanner.next();
		System.out.println("Araç Türünü Giriniz(Otomobil, Kamyon, Motor vb)");
		String aracTuru = otoGaleri.getAracTuru();
		aracTuru = scanner.next();
		System.out.println("Araç Tipini Giriniz(Satýlýk/Kiralýk)");
		String aracTipi = otoGaleri.getAracTuru();
		aracTipi = scanner.next();
		System.out.println("Aracýn Modelini Giriniz");
		String modeli = otoGaleri.getModeli();
		modeli = scanner.next();
		System.out.println("Yakýt Türünü Giriniz");
		String yakiti = otoGaleri.getYakiti();
		yakiti = scanner.next();
		System.out.println("arabanýn Markasýný Giriniz");
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
				System.out.println("Hata oluþtu. Baðlantý bile kapatýlamadý.");
			}
		}
		System.out.println("Kayýt eklendi");
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
				System.out.println("No    Aracýn Türü       Aracýn Tipi      Aracýn Modeli      Aracýn Yakýtý     Aracýn Markasý    Aracýn Durumu");
				System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "      -      " + modeli + "   -    " + yakiti + "   -    " + markasi+"   -   "+durumu);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluþtu. Baðlantý bile kapatýlamadý.");
			}
		}
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------
	
	public static void calisanEkleme()
	{
		Scanner scanner=new Scanner(System.in);
		Calisan calisan=new Calisan();
		int id=calisan.getId();
		System.out.println("Çalýþanýn Adýný Giriniz");
		String adi=calisan.getAdi();
		adi = scanner.next();
		System.out.println("Çalýþanýn Soyadýný Giriniz");
		String soyadi=calisan.getSoyadi();
		soyadi = scanner.next();
		System.out.println("Çalýþanýn Yaþýný Giriniz");
		int yasi=calisan.getYasi();
		yasi = scanner.nextInt();
		System.out.println("Çalýþanýn Görevini Yazýnýz");
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
				System.out.println("Hata oluþtu. Baðlantý bile kapatýlamadý.");
			}
		}
		System.out.println("Kayýt eklendi");
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
				System.out.println("Hata oluþtu. Baðlantý bile kapatýlamadý.");
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
			
			System.out.println("Kiralamak veya Satýn Almak Ýstedeðiniz Aracýn Numarasýný Yazýnýz");
			int alýnacakArabaninIdNumarasi=scanner.nextInt();
			for(int i=0;i<=alýnacakArabaninIdNumarasi;i++)
			{
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				if(id==alýnacakArabaninIdNumarasi){
					System.out.println(id + " " + aracTuru + " " + aracTipi + " " + modeli + " " + yakiti + " " + markasi+durumu);
					System.out.println("Kiralamak Veya Satýn Almak Ýstediðinize Emin Misiniz?(evet/hayýr)");
					String secim=scanner.next();
					
					switch (secim) {
					case "evet":
						durumu="Seçildi";
						System.out.println("No  Aracýn Türü   Aracýn Tipi     Aracýn Modeli    Aracýn Yakýtý   Aracýn Markasý   Aracýn Durumu");
						System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "   -    " + modeli + "   -    " + yakiti + "   -    " + markasi+"   -   "+durumu);
						break;
						
					case "hayýr":
						
						break;

					default:
						System.out.println("Hatalý Seçim Yaptýnýz");
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
				System.out.println("Hata oluþtu. Baðlantý bile kapatýlamadý.");
			}
		}
	}
	
//	------------------------------------------------------------------------------------------------------------------------------
 public static void aracSorgulama() {
	 
	 Scanner scanner =new Scanner(System.in);
	 System.out.println("1.Araç Tipi");
	 System.out.println("2.Araç Türü");
	 System.out.println("3.Markasý");
	 System.out.println("4.Modeli");
	 System.out.println("5.Yakýt Türü");
	 System.out.println("Lütfen araç sorgulatmak için sorgulamk istediðiniz baþlýðýn numarasýný yazýnýz");
	 int secimNumarasi=scanner.nextInt();
//	 System.out.println("istediðiniz özelliði yazýnýz");
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
				System.out.println("Hata oluþtu. Baðlantý bile kapatýlamadý.");
			}
		}
	 
	 
	 
	 
 }

}
