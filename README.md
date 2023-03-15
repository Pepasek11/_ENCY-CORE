# ENCY 3 @  Liferay


Dokumentaci k projektu najdete ve slozce [docs](docs/readme.md)

```
ency
├── configs
│ ├── common
│ ├── dev
│ ├── local
│ ├── prod
│ └── uat
├── modules
│ ├── apps  	            - Aplikace
│ │ ├── cds-demands  	    - CDS pozadavky
│ │ ├── delegations  	    - Modul pro definici zastupu
│ │ └── meta-cds     	    - Slovnik DSA
│ ├── core  	            - Core ency moduly, poskytuji univerzalni sluzby a modifikace liferay
│ │ ├── cdn           	    - CDN (js knihovny, css, grafika ....).
│ │ ├── common              - Univerzalni logika pro ostatni moduly - helpre ... .
│ │ ├── connection    	    - Definice/sprava/poskytovani connection do ruznych db. 
│ │ ├── data-provider  	    - Definice custom data providrov. 
│ │ ├── ency-security-sso   - Vlastni implementace token based sso security. 
│ │ ├── scheduler           - Deprecated. Custom scheduler 
│ │ └── workflow            - Semanta like workflow in Liferay. 
│ ├── e3          		    - POZASTAVENO: skupina core modulu emulujicich Ency a poskytujici zakladni univerzalni rozhrani pro tvorbu aplikaci. 
│ │ ├── e3-api      	    - Spolecna logika a ciselniky core casti. 
│ │ ├── e3-app-api  	    - Api pro definici a logiku Ency byznys aplikace. 
│ │ ├── e3-app-impl 	    - Implementace logiky pro obsluhu Ency byznys aplikace. 
│ │ ├── e3-entry-api        - Entry API:  drzi data o instanci Aplikace (hodnoty poli, auditni info, verze ..). 
│ │ ├── e3-entry-service    - Implementace Entry API. 
│ │ ├── e3-field-api        - Field API: Definice pro ruzne typy poli, podporovanych Ency.
│ │ ├── e3-field-impl       - Implementace Field API. 
│ │ ├── e3-ui-taglib        - Definice Ency tagu pro ulehceni vyvoje UI u Ency aplikaci . 
│ │ ├── e3-ui-web-api       - Api pro verejne rozhrani ke nektere spolecne web logike . 
│ │ └── e3-ui-web           - Univerzalni E3 Wev portlet a spolecna web logika (assets, search ...) 
│ └── e3-common     	    - Univerzalni logika pro ostatni moduly - helpre ... .
│   └── e3-common-js        - Common Javascript balicky (typicky pro react a npm zavislosti)  
└── themes
```
