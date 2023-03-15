create table ency_workflow (
	uuid_ VARCHAR(75) null,
	workflowId LONG not null primary key,
	className VARCHAR(1000) null,
	title VARCHAR(1000) null,
	description TEXT null,
	initialStateName VARCHAR(75) null,
	version LONG,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table ency_workflowinstance (
	uuid_ VARCHAR(75) null,
	workflowInstanceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	workflowId LONG,
	workflowVersion LONG,
	className VARCHAR(1000) null,
	classPK LONG,
	workflowContext TEXT null
);

create table ency_workflowlink (
	uuid_ VARCHAR(75) null,
	workflowLinkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	className VARCHAR(1000) null,
	folderClassName VARCHAR(1000) null,
	folderPK LONG,
	workflowId LONG
);

create table ency_workflowstate (
	uuid_ VARCHAR(75) null,
	stateId LONG not null primary key,
	workflowId LONG,
	name VARCHAR(200) null,
	title VARCHAR(1000) null,
	description TEXT null,
	version LONG,
	isInitial BOOLEAN,
	isFinal BOOLEAN,
	isEditable BOOLEAN,
	isSearchable BOOLEAN,
	isPermanent BOOLEAN,
	cssIcon VARCHAR(100) null,
	cssIconColor VARCHAR(10) null,
	cssLabelColor VARCHAR(10) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table ency_workflowstateinstance (
	uuid_ VARCHAR(75) null,
	stateInstanceId LONG not null primary key,
	stateId LONG,
	workflowId LONG,
	workflowInstanceId LONG,
	version LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	completedDate DATE null,
	workflowContext TEXT null
);

create table ency_workflowtransition (
	uuid_ VARCHAR(75) null,
	transitionId LONG not null primary key,
	stateId LONG,
	workflowId LONG,
	version LONG,
	name VARCHAR(200) null,
	title VARCHAR(1000) null,
	description TEXT null,
	targetStateName VARCHAR(200) null,
	targetStateId LONG,
	cssIcon VARCHAR(100) null,
	cssIconColor VARCHAR(10) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null,
	order_ LONG
);

create table ency_workflowtransitioninstance (
	uuid_ VARCHAR(75) null,
	transitionInstanceId LONG not null primary key,
	transitionId LONG,
	stateId LONG,
	stateInstanceId LONG,
	workflowId LONG,
	workflowInstanceId LONG,
	version LONG,
	comment_ VARCHAR(2000) null,
	targetStateId LONG,
	targetStateInstanceId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	workflowContext TEXT null
);