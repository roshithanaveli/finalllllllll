CREATE TABLE `user` (
  `userid` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY  (`userid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `trainer` (
  `userid` varchar(50) NOT NULL,
  `trainername` varchar(100) NOT NULL,
  `technology` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `contact` varchar(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY  (`userid`),
  CONSTRAINT `trainer_uid_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `trainee` (
  `userid` varchar(50) NOT NULL,
  `traineename` varchar(100) NOT NULL,
  `technology` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `trainername` varchar(50) NOT NULL,
  `contact` int(11) NOT NULL,
  `domain` varchar(50) NOT NULL,
  `education` varchar(100) NOT NULL,
  `passoutyear` int(4) NOT NULL,
  PRIMARY KEY  (`userid`),
  CONSTRAINT `trainee_uid_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `subject` (
  `subjectid` varchar(10) NOT NULL,
  `subjectname` varchar(50) NOT NULL,
  PRIMARY KEY  (`subjectid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `result` (
  `resultid` varchar(10) NOT NULL,
  `traineeid` varchar(50) NOT NULL,
  `technology` varchar(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `score` int(3) NOT NULL,
  PRIMARY KEY  (`resultid`),
  KEY `result_tid_fk_idx` (`traineeid`),
  CONSTRAINT `result_tid_fk` FOREIGN KEY (`traineeid`) REFERENCES `trainee` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `question` (
  `questionid` varchar(10) NOT NULL,
  `questiondescription` varchar(500) NOT NULL,
  `questiontype` varchar(50) NOT NULL,
  `subjectid` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `trainerid` varchar(50) NOT NULL,
  PRIMARY KEY  (`questionid`),
  KEY `question_sid_fk_idx` (`subjectid`),
  KEY `question_tid_fk_idx` (`trainerid`),
  CONSTRAINT `question_sid_fk` FOREIGN KEY (`subjectid`) REFERENCES `subject` (`subjectid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `question_tid_fk` FOREIGN KEY (`trainerid`) REFERENCES `trainer` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `queans` (
  `answerid` varchar(50) NOT NULL,
  `answerdescription` varchar(100) NOT NULL,
  KEY `queans_aid_fk_idx` (`answerid`),
  CONSTRAINT `queans_aid_fk` FOREIGN KEY (`answerid`) REFERENCES `answer` (`answerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `answer` (
  `answerid` varchar(50) NOT NULL,
  `answerdescription` varchar(500) NOT NULL,
  `questionid` varchar(50) NOT NULL,
  PRIMARY KEY  (`answerid`),
  KEY `answer_qid_fk_idx` (`questionid`),
  CONSTRAINT `answer_qid_fk` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
