# SSO modul Ency

### Kontext
Autentikace v bance je dělaná přes IIS který je napojen na Tomcat pomocí BonCode 
connectoru přes AJP protokol. Po autentikaci je nastavena hlavička `auth-user` a 
Tomcat taky nastaví daný login do remote user vlastnost `HttpServletRequest`. Tento
login je vo formátu `domena\ja*****`.

Nativní Liferay podpora SSO pomocí tokenu naráži v bankovním prostředí a nastavení 
na dvě problémy:

* pokud je nastaven remoteHost v `HttpServletRequest`, pak se již Fitry které 
zabezpečují SSO nevykonávají. Očekává se, že remoteHost již obsahuje validní UID

* login s doménou nemůže být jako screen name a tudíz jako Liferay login (lomítko 
je nepodporovaný znak)


### Řešení
Pro vyřešení SSO přihlášení bylo tedy nutno udělat nekolik opatření:

* Vlastní `HttpServletRequestWrapper`  - `EncyHttpServletRequestWrapper`, 
který testuje zda je remoteHost nastaven a obsahuje login s doménou (testuje 
přitomnost zpětného lomítka ). Pokud je to login s doménou, pak vrací null a 
přeněcháva tak možnost ověřit uživatele AutoLogin třídám.  
* Nový filter na začátku řetězce, který obalí request
* Vlastní implementaci `AutoLogin`, která oveří uživatele podle zadané hlavičky
  (typicky `remote-user`)