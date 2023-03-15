create index IX_13FFD5A1 on CdsDemands_CdsDemand (domainId, head);
create unique index IX_EE56F3A9 on CdsDemands_CdsDemand (headId);
create index IX_ED57E6E8 on CdsDemands_CdsDemand (userId, head);
create index IX_F1C034A2 on CdsDemands_CdsDemand (uuid_[$COLUMN_LENGTH:75$], companyId, head);
create index IX_2C674750 on CdsDemands_CdsDemand (uuid_[$COLUMN_LENGTH:75$], groupId);
create unique index IX_1B61C0EE on CdsDemands_CdsDemand (uuid_[$COLUMN_LENGTH:75$], head);

create index IX_69D6F921 on CdsDemands_CdsDemandGdprInfo (demandId);
create index IX_81C8002D on CdsDemands_CdsDemandGdprInfo (uuid_[$COLUMN_LENGTH:75$]);

create unique index IX_BE9E32E4 on CdsDemands_CdsDemandVersion (demandId, version);
create index IX_7DB1D50B on CdsDemands_CdsDemandVersion (domainId, version);
create index IX_125C2664 on CdsDemands_CdsDemandVersion (userId, version);
create index IX_96F89A6A on CdsDemands_CdsDemandVersion (uuid_[$COLUMN_LENGTH:75$], companyId, version);
create index IX_930B4B60 on CdsDemands_CdsDemandVersion (uuid_[$COLUMN_LENGTH:75$], groupId);
create unique index IX_97964CBE on CdsDemands_CdsDemandVersion (uuid_[$COLUMN_LENGTH:75$], version);