CREATE TABLE `houses` (
	`id` INT NOT NULL,
	`adresa` VARCHAR(255) NOT NULL,
	`zona` INT,
	`suprafata` INT,
	`pretMp` DOUBLE,
	`nrNivele` INT,
	`nrCamere` INT,
	`registeredDateTime` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `apartments` (
	`id` INT NOT NULL,
	`adresa` VARCHAR(255) NOT NULL,
	`zona` INT,
	`suprafata` INT,
	`pretMp` DOUBLE,
	`etaj` INT,
	`nrBai` INT,
	`nrCamere` INT,
	`registeredDateTime` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `offices` (
	`id` INT NOT NULL,
	`adresa` VARCHAR(255) NOT NULL,
	`zona` INT,
	`suprafata` INT,
	`pretMp` DOUBLE,
	`nrNivele` INT,
	`etaj` INT,
	`registeredDateTime` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `agents` (
	`id` INT NOT NULL,
	`nume` VARCHAR(255) NOT NULL,
	`zona` INT,
	`registeredDateTime` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);