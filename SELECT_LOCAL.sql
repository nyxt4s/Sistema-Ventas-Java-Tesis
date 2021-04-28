CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_LOCAL`()
BEGIN
select * from local;
END