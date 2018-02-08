# Host: localhost  (Version: 5.5.56)
# Date: 2017-11-15 15:25:44
# Generator: MySQL-Front 5.3  (Build 4.89)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "playerinfo"
#

DROP TABLE IF EXISTS `playerinfo`;
CREATE TABLE `playerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `team` varchar(50) DEFAULT NULL,
  `number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "playerinfo"
#

INSERT INTO `playerinfo` VALUES (1,'James Harden','Houston Rockets','13'),(2,'Stephen Curry','Golden States Warriors','30'),(3,'Chris Paul','Houston Rockets','3'),(4,'Russell Westbrook','Oklahoma Thunders','0'),(5,'LeBron James','Cleveland Cavaliers','23'),(6,'Paul George','Oklahoma Thunders','13'),(7,'John Wall','Washington Wizards','2'),(8,'Kevin Durant','Golden States Warriors','35'),(9,'Kyrie Irving','Boston Celtics','2'),(10,'Lonzo Ball','Los Angels Lakers','2');

#
# Structure for table "team"
#

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `name` varchar(50) NOT NULL DEFAULT '',
  `fullname` varchar(50) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL COMMENT 'location of the team',
  `arena` varchar(50) DEFAULT NULL COMMENT 'arena of the team',
  `year` varchar(10) DEFAULT NULL COMMENT 'year of establishment',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "team"
#

INSERT INTO `team` VALUES ('Bulls','Chicago Bulls','IL','United Center','1966'),('Cavaliers','Cleveland Cavaliers','OH','Quicken Loans Arena ','1970'),('Celtics','Boston Celtics','MA','TD Garden','1946'),('Grizzlies','Memphis Grizzlies','TN','FedExForum','1995'),('Pelicans','New Orleans Pelicans','LA','Smoothie King Center','2002'),('Raptors','Toronto Raptors','-','Air Canada Centre','1995'),('Rockets','Houtston Rockets','TX','Toyota Center','1967'),('Spurs','San Antonio Spurs','TX','AT&T Center ','1967'),('Thunder','Oklahoma City Thunder','OK','Chesapeake Energy Arena','1967'),('Timberwolves','Minnesota Timberwolves','MN','Target Center','1989'),('Warriors','Golden States Warriors','CA','Oracle Arena','1946'),('Wizards','Washington Wizards','D.C.','Capital One Arena','1961');

#
# Structure for table "teaminfo"
#

DROP TABLE IF EXISTS `teaminfo`;
CREATE TABLE `teaminfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "teaminfo"
#

INSERT INTO `teaminfo` VALUES (1,'Rockets','The Rockets compete in the National Basketball Association (NBA), as a member of the league\'s Western Conference Southwest Division. '),(2,'Rockets','The Rockets have won two NBA championships and four Western Conference titles.'),(3,'Rockets','The Rockets, under general manager Daryl Morey, are notable for popularizing the use of advanced statistical analytics in player acquisitions and style of play.'),(4,'Rockets','In September 2017, Houston restaurant billionaire Tilman Fertitta purchase the team with a sale price of $2.2 billion.'),(11,'Bulls','They are known for having one of the NBA\'s greatest dynasties, winning six NBA championships between 1991 and 1998 with two three-peats.'),(12,'Cavaliers',' In 2016, the Cavaliers won their first NBA Championship, marking Cleveland\'s first major sports title since 1964.'),(13,'Cavaliers','Between 2010 and 2014, however, the team won the top pick in the NBA draft lottery three times, first in 2011 where they selected Kyrie Irving, and again in 2013 and 2014.'),(14,'Cavaliers','After the team\'s playoff appearance in 1998, however, the Cavs had six consecutive losing seasons with no playoff action. Cleveland was awarded with the top overall pick in the 2003 draft, and they selected LeBron James.'),(15,'Celtics','They have played the Los Angeles Lakers a record 12 times in the NBA finals, including their most recent appearances in 2008 and 2010, where the Celtics have won nine meetings.'),(16,'Celtics','Four Celtics players (Bob Cousy, Bill Russell, Dave Cowens and Larry Bird) have won the NBA Most Valuable Player Award for an NBA record total of 10 MVP awards.'),(17,'Celtics','The Celtics rose again after struggling through the 1990s to win a championship in 2008 with the help of Kevin Garnett, Paul Pierce, and Ray Allen in what was known as the new \"Big Three\" era.');
