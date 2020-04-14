CREATE DATABASE IF NOT EXISTS `products`;

DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `food`;
DROP TABLE IF EXISTS `nonfood`;

CREATE TABLE `food` (
   id int PRIMARY KEY,
   `calories` int(10) DEFAULT NULL,
   CONSTRAINT `DETAIL` FOREIGN KEY (`id`) REFERENCES `products` (`id`) 
);

CREATE TABLE `nonfood` (
   id int PRIMARY KEY,
   `life time` varchar(128) DEFAULT NULL,
   CONSTRAINT `DETAIL2` FOREIGN KEY (`id`) REFERENCES `products` (`id`) 
);

CREATE TABLE `products` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `amount` int(10) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);