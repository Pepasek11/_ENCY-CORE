## Setting up connection to the LDAP

### Setting up certificates for LDAPS

#### Get certificates
Download certificates from [https://admin.intranet.csob.cz/Public/Certifikaty/]()

#### Add certificates to javakeystore
keytool.exe -genkey -alias lr -keyalg RSA -keystore lrTrustStore.jks -keysize 2048
keytool.exe -import -trustcacerts -alias S1S005U1 -file S1S005U1.cer -keystore lrTrustStore

#### Link to keystore 
When using non standard keystore, and you do not have set custom keystore in environment variables, then use following parameters when starting Liferay:
```
-Djavax.net.ssl.trustStore="<path_to_keystore>" -Djavax.net.ssl.trustStorePassword=<keystore_password> -Djavax.net.ssl.trustStoreType=jks
```
  
#### Basic set up of an LDAP connection (TDA)
```
Config > Instance Settings > LDAP > Servers
```
Add server

Base Provider URL:
```
ldaps://S1S005U1.TDA001.AD.ACC.SYS:636
```
* if you added all TDA servers certificates, you can use common address `TDA001.AD.ACC.SYS` 
   
Base DN:
```
OU=0002,DC=TDA001,DC=AD,DC=ACC,DC=SYS
```

Principal:
```
CN=JD90231,OU=Managed Service Accounts,OU=0002,DC=TDA001,DC=AD,DC=ACC,DC=SYS
```

Import seach filter example:
```
(&(objectClass=user)(mail=*)(sn=*))
```