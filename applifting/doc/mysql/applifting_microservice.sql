USE db;
CREATE TABLE `User` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL CHECK ('email' LIKE '_%@_%.__%'),
	`access token` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `MonitoredEndpoint` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`url` VARCHAR(255) NOT NULL,
	`date of creation` DATETIME NOT NULL,
	`date of last check` DATETIME NOT NULL,
	`monitored interval` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `MonitoringResult` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`date of check` DATETIME NOT NULL,
	`returned http status code` INT NOT NULL,
	`returned payload` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

-- Show tables; 