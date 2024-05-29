CREATE TABLE `tasks` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`state` int(1) DEFAULT 1,
	`title` varchar(40),
	`deadline` date,
	PRIMARY KEY (`id`)
)