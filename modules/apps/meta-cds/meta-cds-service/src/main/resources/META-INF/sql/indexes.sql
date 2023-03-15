create index IX_29791F14 on MetaCds_ColumnEntry (columnFullName[$COLUMN_LENGTH:512$]);
create index IX_E47C0BA5 on MetaCds_ColumnEntry (columnName[$COLUMN_LENGTH:512$]);
create index IX_F00CB094 on MetaCds_ColumnEntry (columnType[$COLUMN_LENGTH:10$]);
create index IX_89DD8E9E on MetaCds_ColumnEntry (companyId, status);
create index IX_64B4D4D8 on MetaCds_ColumnEntry (companyId, userId, status);
create index IX_51A8BD6F on MetaCds_ColumnEntry (dataSize);
create index IX_543A8268 on MetaCds_ColumnEntry (dataType[$COLUMN_LENGTH:32$]);
create index IX_C38E358A on MetaCds_ColumnEntry (databaseName[$COLUMN_LENGTH:128$]);
create index IX_366C54BC on MetaCds_ColumnEntry (description[$COLUMN_LENGTH:2000000$]);
create index IX_20C10120 on MetaCds_ColumnEntry (groupId, status);
create index IX_5F59827D on MetaCds_ColumnEntry (groupId, urlTitle[$COLUMN_LENGTH:256$], status);
create index IX_2CC6A55A on MetaCds_ColumnEntry (groupId, userId, status);
create index IX_74266234 on MetaCds_ColumnEntry (isActive);
create index IX_4890D9B0 on MetaCds_ColumnEntry (isNotNull);
create index IX_B88646B on MetaCds_ColumnEntry (isPrimaryKey);
create index IX_D65363BE on MetaCds_ColumnEntry (systemName[$COLUMN_LENGTH:10$]);
create index IX_B2E8EE23 on MetaCds_ColumnEntry (tableEntryId);
create index IX_C458C479 on MetaCds_ColumnEntry (tableName[$COLUMN_LENGTH:512$]);
create unique index IX_9A79794D on MetaCds_ColumnEntry (urlTitle[$COLUMN_LENGTH:256$]);
create index IX_882E5540 on MetaCds_ColumnEntry (userId, groupId);
create index IX_244BF390 on MetaCds_ColumnEntry (userId, status);
create index IX_952DDC64 on MetaCds_ColumnEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C88A2BE6 on MetaCds_ColumnEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8A01EC67 on MetaCds_SystemEntry (businessOwnerId[$COLUMN_LENGTH:300$]);
create index IX_19B5EF57 on MetaCds_SystemEntry (businessOwnerName[$COLUMN_LENGTH:3000$]);
create index IX_F988E037 on MetaCds_SystemEntry (companyId, status);
create index IX_3D657D71 on MetaCds_SystemEntry (companyId, userId, status);
create index IX_5721B429 on MetaCds_SystemEntry (contactPersonId[$COLUMN_LENGTH:300$]);
create index IX_1E02CE99 on MetaCds_SystemEntry (contactPersonName[$COLUMN_LENGTH:3000$]);
create index IX_D6F70D15 on MetaCds_SystemEntry (description[$COLUMN_LENGTH:2000000$]);
create index IX_B1E1EFBA on MetaCds_SystemEntry (gestorDepartmentId[$COLUMN_LENGTH:300$]);
create index IX_C9A269EA on MetaCds_SystemEntry (gestorDepartmentName[$COLUMN_LENGTH:512$]);
create index IX_9215E4F9 on MetaCds_SystemEntry (groupId, status);
create index IX_380A2B16 on MetaCds_SystemEntry (groupId, urlTitle[$COLUMN_LENGTH:256$], status);
create index IX_668AA033 on MetaCds_SystemEntry (groupId, userId, status);
create index IX_9721307B on MetaCds_SystemEntry (isActive);
create index IX_40DA2EE8 on MetaCds_SystemEntry (isSelfBi);
create index IX_971DC5F3 on MetaCds_SystemEntry (isSlaSigned);
create index IX_21AA19C2 on MetaCds_SystemEntry (role_[$COLUMN_LENGTH:256$]);
create index IX_4E97D58B on MetaCds_SystemEntry (sandboxName[$COLUMN_LENGTH:256$]);
create index IX_8712D613 on MetaCds_SystemEntry (snowAssetTagId[$COLUMN_LENGTH:300$]);
create index IX_16331E03 on MetaCds_SystemEntry (snowAssetTagName[$COLUMN_LENGTH:3000$]);
create index IX_EA7F486B on MetaCds_SystemEntry (stewardDepartment[$COLUMN_LENGTH:3000$]);
create index IX_2AB01AF4 on MetaCds_SystemEntry (stewardId[$COLUMN_LENGTH:300$]);
create index IX_4792AEA4 on MetaCds_SystemEntry (stewardName[$COLUMN_LENGTH:3000$]);
create index IX_13CF9F27 on MetaCds_SystemEntry (systemCode);
create index IX_25D3BC45 on MetaCds_SystemEntry (systemName[$COLUMN_LENGTH:10$]);
create index IX_E016A742 on MetaCds_SystemEntry (systemTitle[$COLUMN_LENGTH:200$]);
create index IX_31646134 on MetaCds_SystemEntry (systemType[$COLUMN_LENGTH:20$]);
create unique index IX_BD744794 on MetaCds_SystemEntry (urlTitle[$COLUMN_LENGTH:256$]);
create index IX_F9833919 on MetaCds_SystemEntry (userId, groupId);
create index IX_934EB097 on MetaCds_SystemEntry (userId, status);
create index IX_4E7573AB on MetaCds_SystemEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_378CE8ED on MetaCds_SystemEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_808E7232 on MetaCds_TableEntry (companyId, status);
create index IX_1162E46C on MetaCds_TableEntry (companyId, userId, status);
create index IX_A8C988E4 on MetaCds_TableEntry (contactPersonId[$COLUMN_LENGTH:300$]);
create index IX_A5086094 on MetaCds_TableEntry (contactPersonName[$COLUMN_LENGTH:3000$]);
create index IX_AE247750 on MetaCds_TableEntry (description[$COLUMN_LENGTH:2000000$]);
create index IX_E3BDB9B4 on MetaCds_TableEntry (groupId, status);
create index IX_C079211 on MetaCds_TableEntry (groupId, urlTitle[$COLUMN_LENGTH:256$], status);
create index IX_1B1B89EE on MetaCds_TableEntry (groupId, userId, status);
create index IX_747F6820 on MetaCds_TableEntry (isActive);
create index IX_AAF4BD47 on MetaCds_TableEntry (systemEntryId, tableDatabase[$COLUMN_LENGTH:128$]);
create index IX_9E808446 on MetaCds_TableEntry (systemEntryId, tableType[$COLUMN_LENGTH:10$]);
create index IX_24829EAA on MetaCds_TableEntry (systemName[$COLUMN_LENGTH:10$]);
create index IX_EF7C0EFD on MetaCds_TableEntry (tableDatabase[$COLUMN_LENGTH:128$]);
create index IX_521F1B7C on MetaCds_TableEntry (tableFullName[$COLUMN_LENGTH:512$]);
create index IX_CF207C0D on MetaCds_TableEntry (tableName[$COLUMN_LENGTH:512$]);
create index IX_DAB120FC on MetaCds_TableEntry (tableType[$COLUMN_LENGTH:10$]);
create unique index IX_9AD27F39 on MetaCds_TableEntry (urlTitle[$COLUMN_LENGTH:256$]);
create index IX_4B2B0DD4 on MetaCds_TableEntry (userId, groupId);
create index IX_14BD87C on MetaCds_TableEntry (userId, status);
create index IX_31C83650 on MetaCds_TableEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A58A10D2 on MetaCds_TableEntry (uuid_[$COLUMN_LENGTH:75$], groupId);