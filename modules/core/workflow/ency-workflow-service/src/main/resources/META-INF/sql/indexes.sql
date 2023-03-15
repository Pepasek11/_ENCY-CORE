create index IX_2FB16F84 on ency_workflow (active_);
create unique index IX_117314CE on ency_workflow (className[$COLUMN_LENGTH:1000$]);
create index IX_13620CEF on ency_workflow (uuid_[$COLUMN_LENGTH:75$]);

create unique index IX_C260BEAA on ency_workflowinstance (className[$COLUMN_LENGTH:1000$], classPK);
create index IX_865344EE on ency_workflowinstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_38242EF0 on ency_workflowinstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2DFCE357 on ency_workflowlink (companyId, workflowId);
create index IX_25AB7ECC on ency_workflowlink (groupId, companyId, className[$COLUMN_LENGTH:1000$], folderClassName[$COLUMN_LENGTH:1000$], folderPK);
create index IX_44E1E353 on ency_workflowlink (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_82212295 on ency_workflowlink (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B450D3F1 on ency_workflowstate (active_);
create index IX_3F79A89C on ency_workflowstate (uuid_[$COLUMN_LENGTH:75$]);
create unique index IX_41E0E85 on ency_workflowstate (workflowId, name[$COLUMN_LENGTH:200$]);

create index IX_A205A821 on ency_workflowstateinstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_76BC2E3 on ency_workflowstateinstance (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_3480C51B on ency_workflowstateinstance (workflowId);
create index IX_386B0D50 on ency_workflowstateinstance (workflowInstanceId);

create index IX_80CF9DCF on ency_workflowtransition (active_);
create unique index IX_2D87EC1 on ency_workflowtransition (stateId, name[$COLUMN_LENGTH:200$]);
create index IX_AE3D51FA on ency_workflowtransition (uuid_[$COLUMN_LENGTH:75$]);
create index IX_D8594CA8 on ency_workflowtransition (workflowId);

create index IX_A2541603 on ency_workflowtransitioninstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_12E04145 on ency_workflowtransitioninstance (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_5ED58AB2 on ency_workflowtransitioninstance (workflowInstanceId);