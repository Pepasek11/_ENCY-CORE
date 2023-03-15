create unique index IX_80990D7B on Delegations_DelegatedRole (code_[$COLUMN_LENGTH:256$]);
create index IX_A971ADA3 on Delegations_DelegatedRole (groupId);

create index IX_2BABDE88 on Delegations_Delegation (groupId, roleId, delegatedUserId);
create index IX_394C4B49 on Delegations_Delegation (groupId, roleId, delegatingUserId);

create unique index IX_C5A9B55B on delegations_delegatedrole (code_[$COLUMN_LENGTH:256$]);
create index IX_ECF7DD83 on delegations_delegatedrole (groupId);

create index IX_F8407648 on delegations_delegation (groupId, roleId, delegatedUserId);
create index IX_FF4AAB89 on delegations_delegation (groupId, roleId, delegatingUserId);