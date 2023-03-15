create table delegations_delegatedrole (
	mvccVersion LONG default 0 not null,
	roleId LONG not null primary key,
	title VARCHAR(256) null,
	code_ VARCHAR(256) null,
	description VARCHAR(1024) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(256) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table delegations_delegation (
	mvccVersion LONG default 0 not null,
	delegationId LONG not null primary key,
	roleId LONG,
	delegatingUserId LONG,
	delegatedUserId LONG,
	groupId LONG,
	note VARCHAR(1024) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(256) null,
	createDate DATE null,
	modifiedDate DATE null
);