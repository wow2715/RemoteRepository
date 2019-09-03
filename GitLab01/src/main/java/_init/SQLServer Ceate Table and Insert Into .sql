IF OBJECT_ID('dbo.Member', 'U') IS NOT NULL 
  DROP TABLE dbo.Member; 

CREATE TABLE Member(
	pk   int NOT NULL IDENTITY PRIMARY KEY,
	id   varchar(32) NULL,
	pswd varchar(64) NULL,
	name varchar(50) NULL,
)

INSERT INTO Member VALUES 
('kitty', 'k123', '凱蒂貓'), 
('micky', 'm456', '米小薯'), 
('snoopy', 's789', '史努比')
