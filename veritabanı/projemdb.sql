-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 25 Haz 2023, 08:49:53
-- Sunucu sürümü: 8.0.31
-- PHP Sürümü: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `projemdb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `arızalar`
--

CREATE TABLE `arızalar` (
  `arıza_ID` int NOT NULL,
  `arıza` varchar(500) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kul_ad` varchar(25) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `arızalar`
--

INSERT INTO `arızalar` (`arıza_ID`, `arıza`, `kul_ad`) VALUES
(11, '110 numaralı odada sular kesik.', 'Hamza'),
(12, 'Yemekhanedeki tuvaletlerin lavabosu çalışmıyor.', 'Hasan');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `kID` int NOT NULL,
  `kul_ad` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `sifre` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yetki` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `blok` int NOT NULL,
  `Cinsiyet` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `izinli_gun` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`kID`, `kul_ad`, `sifre`, `yetki`, `blok`, `Cinsiyet`, `izinli_gun`) VALUES
(1, 'enes', '123', 'Yönetici', 1, 'Erkek', 0),
(9, 'alper', '1234', 'Kullanıcı', 2, 'Erkek', 10),
(10, 'hamza', '000', 'Kullanıcı', 3, 'Kadın', 0),
(11, 'basri', '011', 'Yönetici', 1, 'Kadın', 0),
(12, 'hasan', '000', 'Kullanıcı', 2, 'Erkek', 0),
(13, 'Kazım', '111', 'Kullanıcı', 3, 'Erkek', 0),
(14, 'oguz', '000', 'Yönetici', 1, 'Kadın', 0),
(16, 'Uğur', '888', 'Yönetici', 1, 'Erkek', 0),
(21, 'Sinem', '777', 'Yönetici', 1, 'Kadın', 0);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `arızalar`
--
ALTER TABLE `arızalar`
  ADD PRIMARY KEY (`arıza_ID`);

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`kID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `arızalar`
--
ALTER TABLE `arızalar`
  MODIFY `arıza_ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `kID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
