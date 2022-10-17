# TaakDatabases

## Database schema

[![](https://mermaid.ink/img/pako:eNqdVE1vgkAQ_Stkjg0Y0UZl0zQx1aSm1YM1Nmm4bGDErbBLcK21xP_e5cOKCNp2LuzOzHvzZphsDI5wEQg4Pl2vB4x6EQ1sril7RXctI_buajaYjcaNDdqdYRwvcxXbMt9nHkbniGYF4lmEVamn5Oo0lDQMMUtMMcckw7g_Xq7mKREJX9_3MEDkT0mP6sRlhsnwZyAbftSVEYcqOfGJmlpQRSBv9ARfpzL9M1nlOPMk5if3kUu00WRW9IqQb4IAo1KAUxoQbTLvTx8e-9Oj_0OIKIlpVcEFk0tk5RoebpmzlOXKiAupeiy490X9591dbSajG_Rnw9loPKzgrBhsfBleXwzTXRjV6i9ue6HI9iDhjPBfE5eUrsr-6pZ_pcFH7kmsaylb__jiDP7In83XoZJhTRsHAx3UlgaUuerxSTXYoLYtQBuIOro0Wtlg873KoxspXnbcASKjDeqwCV0qMX-rgCyov1bekHIgMXwCMcxuw0qs3TVvW1a31dVhB6TdaFlNs902rWbPslq9Tmevw5cQisLUAV0mRTTOH8Pkk1K-pfG0xP4bBqZ_Qg)](https://mermaid.live/edit#pako:eNqdVE1vgkAQ_Stkjg0Y0UZl0zQx1aSm1YM1Nmm4bGDErbBLcK21xP_e5cOKCNp2LuzOzHvzZphsDI5wEQg4Pl2vB4x6EQ1sril7RXctI_buajaYjcaNDdqdYRwvcxXbMt9nHkbniGYF4lmEVamn5Oo0lDQMMUtMMcckw7g_Xq7mKREJX9_3MEDkT0mP6sRlhsnwZyAbftSVEYcqOfGJmlpQRSBv9ARfpzL9M1nlOPMk5if3kUu00WRW9IqQb4IAo1KAUxoQbTLvTx8e-9Oj_0OIKIlpVcEFk0tk5RoebpmzlOXKiAupeiy490X9591dbSajG_Rnw9loPKzgrBhsfBleXwzTXRjV6i9ue6HI9iDhjPBfE5eUrsr-6pZ_pcFH7kmsaylb__jiDP7In83XoZJhTRsHAx3UlgaUuerxSTXYoLYtQBuIOro0Wtlg873KoxspXnbcASKjDeqwCV0qMX-rgCyov1bekHIgMXwCMcxuw0qs3TVvW1a31dVhB6TdaFlNs902rWbPslq9Tmevw5cQisLUAV0mRTTOH8Pkk1K-pfG0xP4bBqZ_Qg)

## Beschrijving van het databaseschema

### Entiteiten/modellen en hun properties

Om de database van *De Vrolijke Zweters* uit te werken, zijn 6 enititeiten/modellen gebruikt. De eerste entiteit is een Wedstrijd, deze bevat een wedstrijdId dat uniek is en de lengte van de wedstrijd. Daarnaast is er een entiteit Loper die een aantal kenmerken heeft: naam, voornaam, fitheid, gewicht en leeftijd. Naast deze kenmerken heeft een Loper ook een uniek loperId waar in combinatie met de wedstijdId een uniek loopnummer voor elke wedstrijd gegenereerd wordt. Ook de entiteit van de Vrijwilligers bevat enkele kenmerken zoals naam, voornaam, taak. Elke Vrijwilliger heeft ook een wedstrijdId waardoor deze persoon gelinkt wordt aan de wedstrijd waar hij/zij bij helpt. Om de verschillende tijden per etappe bij te houden heeft de entiteit Etappe een loperId zodat de tijd van een loper op elke etappe kan worden bijgehouden. Naast deze eigenschappen heeft een Etappe ook een lengte en een locatie. Bovendien heeft deze entiteit ook nog een wedstrijdId zodat elke etappe gelinkt kan worden aan de wedstrijd waartoe deze etappe behoort. Om het klassement van een wedstrijd bij te houden, heeft de entiteit WedstrijdKlassement een totale tijd, een loperId om deze tijd aan de juiste loper te linken en een etappeId die zorgt voor een link met de etappe en dus ook de wedstijd van deze etappe. Ten slotte is er nog een AlgemeenKlassement. Deze entiteit heeft een loperId die zorgt voor de link tussen de loper en de tijden van alle wedstrijden samen.

### Relaties tussen entiteiten/modellen

Een wedstrijd kan georganiseerd worden met 1 of meer vrijwilligers en de vrijwilligers kunnen helpen bij 1 of meerdere wedstrijden. Aangezien een wedstrijd zonder vrijwilligers niet kan doorgaan en als je, als vrijwilliger, bij geen enkele wedstrijd helpt, wordt je ook niet beschouwd als vrijwilliger. Vandaar de keuze van een veel-op-veel relatie. Voor de lopers kunnen we zeggen dat ze deel kunnen nemen aan 0 of meer wedstrijden en dat een wedstijd 1 of meer lopers heeft want zonder lopers kan een wedstrijd niet doorgaan. We hebben gekozen voor een relatie van 0 of meer omdat niet elke loper bij alle wedstrijden moet of kan meelopen. Elke wedstrijd kan bestaan uit 1 of meerder etappes maar elke etappe kan maar aan 1 wedstijd gelinkt worden. Sommige wedstrijden zijn kort genoeg om maar uit 1 etappe te bestaan, bijvoorbeeld een kids-run maar een wedstrijd kan natuurlijk ook uit meerdere etappes bestaan. Aangezien de wedstrijden over heel Vlaanderen georganiseerd worden, gaan we ervan uit dat alle etappes maar in 1 wedstrijd voorkomen. Dus de relatie tussen een wedstrijd en een etappe is een 1-op-veel relatie.

Elke loper die deelneemt aan een wedstrijd loopt 1 of meer etappes aangezien een wedstrijd altijd uit 1 of meer etappes bestaat en elke etappe kan door 1 of meer lopers gelopen worden want zonder lopers is er geen wedstrijd. Omdat we voor elke etappe de tijd van een loper bijhouden bekomen we een veel-op-veel relatie tussen deze entiteiten.

Elke etappe kan 1 of meer keer voorkomen in het wedstrijdklassement omdat een etappe voor elke loper, die deze etappe heeft gelopen, terugkeert in het wedstrijdklassement. Maar omgekeerd is er geen link want een wedstrijdklassement komt niet voor in een etappe dus vandaar de 0.

Elke loper kan 0 of 1 keer voorkomen in een wedstrijdklassement en elk wedstrijdklassement kan 1 of meer lopers hebben. Aangezien niet alle lopers deelnemen aan alle wedstrijden kan het zijn dat een loper niet in een wedstrijdklassement zit. Om een wedstrijdklassement te maken daarentegen is er altijd minstens 1 loper nodig.

Elk wedstrijdklassement kan maar exact 1 keer voorkomen in het algemeen klassement en elk algemeen klassement kan uit 1 of meerdere wedstrijdklassementen bestaan. Want wij beschouwen het algemeen klassement als het klassement waarbij alle tijden per wedstrijdklassement van een loper opgeteld worden. Aangezien er in de ene richten een 1 of meer relatie is en dit omgekeerd 1 is, spreken we hier van een 1-op-veel relatie.

Elke loper kan 0 of 1 keer voorkomen in een algemeen klassement en elk algemeen klassement bestaat uit 1 of meer lopers. Als een loper nog geen enkele wedstrijd heeft gelopen, kan het zijn dat hij/zij niet voorkomt in het algemeen klassement. Maar om een algemeen klassement op te maken zijn er natuurlijk wel 1 of meer lopers nodig.
