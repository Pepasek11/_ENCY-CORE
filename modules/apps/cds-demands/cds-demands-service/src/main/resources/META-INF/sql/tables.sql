create table CdsDemands_CdsDemand (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	headId LONG,
	head BOOLEAN,
	demandId LONG not null primary key,
	title VARCHAR(500) null,
	description TEXT null,
	type_ INTEGER,
	priority INTEGER,
	requestedDelivery DATE null,
	isGDPR BOOLEAN,
	gdprInfo VARCHAR(512) null,
	fiveTracks VARCHAR(512) null,
	requestorId LONG,
	requestorName VARCHAR(256) null,
	requestedForId LONG,
	requestedForName VARCHAR(256) null,
	contactId LONG,
	contactName VARCHAR(256) null,
	domainId LONG,
	domainName VARCHAR(256) null,
	banId LONG,
	banName VARCHAR(256) null,
	spocId LONG,
	spocName VARCHAR(256) null,
	usReasoning VARCHAR(512) null,
	usFrequencyOut INTEGER,
	usAccessDPM BOOLEAN,
	usFolderDPM VARCHAR(256) null,
	usCreateFolderDPM BOOLEAN,
	usGestorFolderDPMId LONG,
	usGestorFolderDPMName VARCHAR(256) null,
	usDPMNotificationMail VARCHAR(256) null,
	bioeId VARCHAR(20) null,
	bioeStateId INTEGER,
	bioeStateName VARCHAR(75) null,
	workEstimate DOUBLE,
	acceptedWorkEstimate DOUBLE,
	expectedDelivery DATE null,
	acceptedDelivery DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(256) null,
	createDate DATE null,
	modifiedDate DATE null,
	urlTitle VARCHAR(256) null,
	state_ VARCHAR(75) null,
	stateByUserId LONG,
	stateByUserName VARCHAR(75) null,
	stateDate DATE null
);

create table CdsDemands_CdsDemandGdprInfo (
	uuid_ VARCHAR(75) null,
	gdprInfoId LONG not null primary key,
	demandId LONG,
	title VARCHAR(500) null,
	description TEXT null,
	isEmployee BOOLEAN,
	employeeCategory VARCHAR(1024) null,
	employeeReasoning VARCHAR(1024) null,
	isClient BOOLEAN,
	clientCategory VARCHAR(1024) null,
	clientReasoning VARCHAR(1024) null,
	userId LONG,
	userName VARCHAR(256) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table CdsDemands_CdsDemandVersion (
	cdsDemandVersionId LONG not null primary key,
	version INTEGER,
	uuid_ VARCHAR(75) null,
	demandId LONG,
	title VARCHAR(500) null,
	description TEXT null,
	type_ INTEGER,
	priority INTEGER,
	requestedDelivery DATE null,
	isGDPR BOOLEAN,
	gdprInfo VARCHAR(512) null,
	fiveTracks VARCHAR(512) null,
	requestorId LONG,
	requestorName VARCHAR(256) null,
	requestedForId LONG,
	requestedForName VARCHAR(256) null,
	contactId LONG,
	contactName VARCHAR(256) null,
	domainId LONG,
	domainName VARCHAR(256) null,
	banId LONG,
	banName VARCHAR(256) null,
	spocId LONG,
	spocName VARCHAR(256) null,
	usReasoning VARCHAR(512) null,
	usFrequencyOut INTEGER,
	usAccessDPM BOOLEAN,
	usFolderDPM VARCHAR(256) null,
	usCreateFolderDPM BOOLEAN,
	usGestorFolderDPMId LONG,
	usGestorFolderDPMName VARCHAR(256) null,
	usDPMNotificationMail VARCHAR(75) null,
	bioeId VARCHAR(20) null,
	bioeStateId INTEGER,
	bioeStateName VARCHAR(75) null,
	workEstimate DOUBLE,
	acceptedWorkEstimate DOUBLE,
	expectedDelivery DATE null,
	acceptedDelivery DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(256) null,
	createDate DATE null,
	modifiedDate DATE null,
	urlTitle VARCHAR(256) null,
	state_ VARCHAR(75) null,
	stateByUserId LONG,
	stateByUserName VARCHAR(75) null,
	stateDate DATE null
);