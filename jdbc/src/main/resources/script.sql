-- Create social_network scheme
CREATE SCHEMA `social_network` ;

-- create Users table
CREATE TABLE `social_network`.`Users` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `birthdate` DATETIME NULL,
  PRIMARY KEY (`id`));

-- create Friendships table
CREATE TABLE `social_network`.`Friendships` (
  `(userid1` INT NOT NULL,
  `(userid2` INT NOT NULL,
  `timestamp` DATETIME NOT NULL);

-- create Posts table
CREATE TABLE `social_network`.`Posts` (
  `id` INT NOT NULL,
  `userId` INT NULL,
  `text` VARCHAR(45) NULL,
  `timestamp` DATETIME NULL,
  PRIMARY KEY (`id`));

-- create Likes table
CREATE TABLE `social_network`.`Likes` (
  `postid` INT NOT NULL,
  `userid` INT NOT NULL,
  `timestamp` DATETIME NOT NULL);

-- added foreign keys
ALTER TABLE `social_network`.`Likes`
ADD INDEX `userid_idx` (`userid` ASC),
ADD INDEX `postid_idx` (`postid` ASC);
ALTER TABLE `social_network`.`Likes`
ADD CONSTRAINT `userid`
  FOREIGN KEY (`userid`)
  REFERENCES `social_network`.`Users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `postid`
  FOREIGN KEY (`postid`)
  REFERENCES `social_network`.`Posts` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `social_network`.`Friendships`
ADD INDEX `userid1_idx` (`(userid1` ASC),
ADD INDEX `userid2_idx` (`(userid2` ASC);
ALTER TABLE `social_network`.`Friendships`
ADD CONSTRAINT `userid1`
  FOREIGN KEY (`(userid1`)
  REFERENCES `social_network`.`Users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `userid2`
  FOREIGN KEY (`(userid2`)
  REFERENCES `social_network`.`Users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `social_network`.`Posts`
ADD INDEX `userIdKey_idx` (`userId` ASC);
ALTER TABLE `social_network`.`Posts`
ADD CONSTRAINT `userIdKey`
  FOREIGN KEY (`userId`)
  REFERENCES `social_network`.`Users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;