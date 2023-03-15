# Connection Module
Connection modul slouzi pro definici pojmenovanych db connection
na ruzne databaze a poskytuje sadu funkci na dotazovani v nich.

### Instalace driveru
#### MS SQL 
1. Stahnout jdbc driver pro mssql
https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server
   
2. Nahrat jdbc ovladac `mssql-jdbc-<verze>.jreXY.jar` do slozky `tomact/lib` 

3. Pro SSO podporu nahrat dll knihovnu `mssql-jdbc_auth-<verze>>.x64.dll` do slozky, ktera je na ceste definovane 
   env promennou `java.library.path`. Pokud nechceme/nemuzeme nastavovat promennu prostredi na stanici, je
   mozne nastavit jenom pro beh Liferayu jako parameter pri spusteni 
   `-Djava.library.path="L:\Liferay\javalib"`
 
