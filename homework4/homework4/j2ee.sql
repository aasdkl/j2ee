-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 12 月 22 日 07:35
-- 服务器版本: 5.0.96
-- PHP 版本: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `j2ee`
--

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) unsigned zerofill NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`id`, `name`) VALUES
(00000000001, '语文'),
(00000000002, '数学'),
(00000000003, '英文');

-- --------------------------------------------------------

--
-- 表的结构 `score`
--

CREATE TABLE IF NOT EXISTS `score` (
  `id` int(11) unsigned zerofill NOT NULL,
  `student` int(11) NOT NULL,
  `course` int(11) NOT NULL,
  `score` int(3) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `score`
--

INSERT INTO `score` (`id`, `student`, `course`, `score`) VALUES
(00000000001, 1, 1, 89),
(00000000002, 1, 2, 88),
(00000000003, 1, 3, 80),
(00000000004, 2, 1, 88),
(00000000005, 2, 2, 88),
(00000000006, 2, 3, 58),
(00000000007, 3, 1, 0),
(00000000008, 3, 2, 0),
(00000000009, 3, 3, 0);

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) unsigned zerofill NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `name`, `password`) VALUES
(00000000001, '一号', '698d51a19d8a121ce581499d7b701668'),
(00000000002, '二号', 'bcbe3365e6ac95ea2c0343a2395834dd'),
(00000000003, '三号', '310dcbbf4cce62f762a2aaa148d556bd');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
