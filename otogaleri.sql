-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 25 Nis 2019, 23:38:13
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `otogaleri`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `arabaolusturma`
--

CREATE TABLE `arabaolusturma` (
  `AracTuru` varchar(30) NOT NULL,
  `AracTipi` varchar(30) NOT NULL,
  `Markasi` varchar(30) NOT NULL,
  `Modeli` varchar(30) NOT NULL,
  `Yakiti` text NOT NULL,
  `id` int(11) NOT NULL,
  `durumu` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `calisanolusturma`
--

CREATE TABLE `calisanolusturma` (
  `id` int(11) NOT NULL,
  `adi` varchar(25) NOT NULL,
  `soyadi` varchar(25) NOT NULL,
  `yasi` int(11) NOT NULL,
  `gorevi` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `arabaolusturma`
--
ALTER TABLE `arabaolusturma`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `calisanolusturma`
--
ALTER TABLE `calisanolusturma`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `arabaolusturma`
--
ALTER TABLE `arabaolusturma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `calisanolusturma`
--
ALTER TABLE `calisanolusturma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
