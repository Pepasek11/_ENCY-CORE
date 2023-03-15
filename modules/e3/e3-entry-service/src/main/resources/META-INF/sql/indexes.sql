create index IX_D4B4AFC0 on E3Entry (entry_xid[$COLUMN_LENGTH:256$], head);
create index IX_33C9E0DA on E3Entry (groupId, status, head);
create unique index IX_45346919 on E3Entry (headId);
create index IX_1E70C4E3 on E3Entry (parent_id, parent_field[$COLUMN_LENGTH:128$], head);
create index IX_2AAFBE04 on E3Entry (status, head);
create index IX_DB64CA12 on E3Entry (uuid_[$COLUMN_LENGTH:75$], companyId, head);
create unique index IX_E7C3DE94 on E3Entry (uuid_[$COLUMN_LENGTH:75$], groupId, head);
create index IX_ECC4317E on E3Entry (uuid_[$COLUMN_LENGTH:75$], head);

create unique index IX_FB0CBFD2 on E3EntryVersion (entry_id, version);
create index IX_51F4F3CC on E3EntryVersion (entry_xid[$COLUMN_LENGTH:256$], version);
create index IX_F3C6D072 on E3EntryVersion (groupId, status, version);
create index IX_B9AF53C9 on E3EntryVersion (parent_id, parent_field[$COLUMN_LENGTH:128$], version);
create index IX_A7A96A8 on E3EntryVersion (status, version);
create index IX_3B523DA on E3EntryVersion (uuid_[$COLUMN_LENGTH:75$], companyId, version);
create unique index IX_28441C18 on E3EntryVersion (uuid_[$COLUMN_LENGTH:75$], groupId, version);
create index IX_6551494E on E3EntryVersion (uuid_[$COLUMN_LENGTH:75$], version);