# Ency Workflow Module

## Todo 
* [ ] Zaslepit generovane metody v Servisech workflow entries, ktere nemaji by dostupne
* [ ] Ukladat verze workflow
* [ ] Ukladat jenom pokud je zmena wf (+ automaticky inkrement verze misto parametru v definici?)
* [x] `*InstanceEntry`  objekty
* [ ] Workflow Manager

#### Eventy
* [ ] Navrhnut jak se bude chovat event logika a jeji handlovani
* [ ] On Before State Entry
* [ ] On Before State Leave
* [ ] On Before Transition
* [ ] On after transition
* [ ] Auto transition after model update

#### Prava
* [ ] Logika na kontrolu prav (view/edit/delete/transition)
* [ ] Filtrovat dostupne transitions
* [ ] Kontrolovat pred prechodem
* [ ] EncyWorkflowedModelPermissionLogic ( v CdsDemandModelResourcePermissionRegistrar)
* [ ] EncyWorkflowStatusModelPreFilterContributor ([see](https://github.com/liferay/liferay-portal/blob/master/modules/apps/portal-search/portal-search/src/main/java/com/liferay/portal/search/internal/spi/model/query/contributor/WorkflowStatusModelPreFilterContributor.java))