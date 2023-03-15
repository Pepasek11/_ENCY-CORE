create table ency_connection (
	connectionId LONG not null primary key,
	name VARCHAR(30) null,
	driver VARCHAR(20) null,
	url VARCHAR(1024) null,
	serverAddress VARCHAR(1024) null,
	serverPort VARCHAR(7) null,
	databaseName VARCHAR(100) null,
	integratedSecurity BOOLEAN,
	username VARCHAR(100) null,
	password_ VARCHAR(100) null,
	additionalParams VARCHAR(75) null
);