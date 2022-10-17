# TaakDatabases

## Database schema

[![](https://mermaid.ink/img/pako:eNqdVE1vgkAQ_Stkjg0Y0UZl0zQx1aSm1YM1Nmm4bGDErbBLcK21xP_e5cOKCNp2LuzOzHvzZphsDI5wEQg4Pl2vB4x6EQ1sril7RXctI_buajaYjcaNDdqdYRwvcxXbMt9nHkbniGYF4lmEVamn5Oo0lDQMMUtMMcckw7g_Xq7mKREJX9_3MEDkT0mP6sRlhsnwZyAbftSVEYcqOfGJmlpQRSBv9ARfpzL9M1nlOPMk5if3kUu00WRW9IqQb4IAo1KAUxoQbTLvTx8e-9Oj_0OIKIlpVcEFk0tk5RoebpmzlOXKiAupeiy490X9591dbSajG_Rnw9loPKzgrBhsfBleXwzTXRjV6i9ue6HI9iDhjPBfE5eUrsr-6pZ_pcFH7kmsaylb__jiDP7In83XoZJhTRsHAx3UlgaUuerxSTXYoLYtQBuIOro0Wtlg873KoxspXnbcASKjDeqwCV0qMX-rgCyov1bekHIgMXwCMcxuw0qs3TVvW1a31dVhB6TdaFlNs902rWbPslq9Tmevw5cQisLUAV0mRTTOH8Pkk1K-pfG0xP4bBqZ_Qg)](https://mermaid.live/edit#pako:eNqdVE1vgkAQ_Stkjg0Y0UZl0zQx1aSm1YM1Nmm4bGDErbBLcK21xP_e5cOKCNp2LuzOzHvzZphsDI5wEQg4Pl2vB4x6EQ1sril7RXctI_buajaYjcaNDdqdYRwvcxXbMt9nHkbniGYF4lmEVamn5Oo0lDQMMUtMMcckw7g_Xq7mKREJX9_3MEDkT0mP6sRlhsnwZyAbftSVEYcqOfGJmlpQRSBv9ARfpzL9M1nlOPMk5if3kUu00WRW9IqQb4IAo1KAUxoQbTLvTx8e-9Oj_0OIKIlpVcEFk0tk5RoebpmzlOXKiAupeiy490X9591dbSajG_Rnw9loPKzgrBhsfBleXwzTXRjV6i9ue6HI9iDhjPBfE5eUrsr-6pZ_pcFH7kmsaylb__jiDP7In83XoZJhTRsHAx3UlgaUuerxSTXYoLYtQBuIOro0Wtlg873KoxspXnbcASKjDeqwCV0qMX-rgCyov1bekHIgMXwCMcxuw0qs3TVvW1a31dVhB6TdaFlNs902rWbPslq9Tmevw5cQisLUAV0mRTTOH8Pkk1K-pfG0xP4bBqZ_Qg)

## Beschrijving van het databaseschema

### Entiteiten/modellen en hun properties

Voor de database van *De Vrolijke Zweters* uit te werken, zijn 6 enititeiten/modellen gebruikt. De eerste entiteit is een wedstrijd, deze bevat een wedstrijdId dat uniek is en de lengte van de wedstrijd. Daarnaast is er een loper die enkele kenmerken heeft zoals naam, voornaam, gewicht, enzovoort. Naast deze kenmerken heeft een loper ook een uniek loperId waar in combinatie met het wedstijdId een uniek loopnummer voor elke wedstrijd gegenereerd wordt. Ook de entiteit van de vrijwilligers bevat enkele kenmerken zoals naam, voornaam, taak. Elke vrijwilliger heeft ook een wedstrijdId waardoor deze persoon gelinkt wordt aan de wedstrijd waar hij/zij bij helpt. Om de verschillende tijden per etappe bij te houden heeft deze entiteit een loperId zodat de tijd van een loper op een etappe kan worden bijgehouden. Naast deze eigenschappen heeft een etappe ook een lengte en een locatie. Bovendien heeft deze entiteit ook nog een wedstrijdId zodat deze etappe gelinkt kan worden aan een wedstrijd. Voor het klassement van een wedstrijd bij te houden. Heeft de entiteit WedstrijdKlassement een totale tijd, een loperId om deze tijd aan een loper te linken en een etappeId die zorgt voor een link met de etappe en dus ook de wedstijd van deze etappe. Ten slotte is er nog een algemeen klassement. Deze entiteit heeft een loperId dat zorgt voor een link tussen een loper en de tijden van alle wedstrijden.

### Relaties tussen entiteiten/modellen

Een wedstrijd kan georganiseerd worden met 1 of meer vrijwilligers en de vrijwilligers kunnen meewerken aan 1 of meer wedstrijden. Voor de lopers kunnen we zeggen dat ze deel kunnen nemen aan 0 of meer wedstrijden en dat een wedstijd 1 of meer lopers heeft. We hebben gekozen voor een relatie van 0 of meer omdat dan niet elke loper die lid is van de organisatie wedstrijden moet meelopen. Elke wedstrijd kan bestaan uit 1 of meerder etappes maar elke etappe kan maar aan 1 wedstijd gelinkt worden. Sommige wedstrijden zijn kort genoeg om maar uit 1 etappe te bestaan, bijvoorbeeld een kids-run. Maar een wedstrijd kan natuurlijk uit meerdere etappes bestaan. Aangezien de wedstrijden over heel Vlaanderen georganiseerd worden gaan we ervan uit dat alle etappes maar in 1 wedstrijd voorkomen. 

Elke loper die deelneemt aan een wedstrijd loopt 1 of meer etappes en elke etappe kan door 1 of meer lopers gelopen worden. Omdat we voor elke etappe de tijd van een loper bij houden bekomen we een veel op veel relatie tussen deze entiteiten.

Elke etappe kan 1 of meer keer voorkomen in het wedstrijdklassement maar een wedstrijd (IK VIND DEZE MISSCHIEN NIET ZO DUIDELIJK).

Elke loper kan 0 of meer keer voorkomen in een wedstrijdklassement en elk wedstrijdklassement kan 1 of meer lopers hebben. Aangezien niet alle lopers deelnemen aan alle wedstrijden kan het zijn een loper niet in een wedstrijdklassement terecht komt. Om een wedstrijdklassement te maken, is er altijd minstens 1 loper nodig.

Elk wedstrijdklassment kan maar 1 keer voorkomen in het algemeen klassement en voor elk algemeen klassement kan uit 1 of meer wedstrijdklassementen bestaan.

Elke loper kan 0 of 1 keer voorkomen in een algemeen klassement en elk algemeen klassement bestaat uit 1 of meer lopers. Als een loper lid is en nog geen wedstrijd heeft gelopen kan het zijn dat hij/zij niet voorkomt in het algemeen klassement. Maar om een algemeen klassement op te maken zijn er 1 of meer lopers nodig.