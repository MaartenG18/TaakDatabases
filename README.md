# Taak Databases

## Huidig database schema

[![](https://mermaid.ink/img/pako:eNqNVFFvmzAQ_ivIjxNFIRBC0bSHqX3LpmmdNqmyNHn4SpwaGxkT1kX577sATnC6TSNIOX933-e785kDKTUHUpBSsra9E6wyrKaKCwOlFVoF779QNfiCe8uaBoIDVQE-G62qIIAB-y74CAplg0CCqiyMwIM14hQndcmsQPDoq32GtpOWMfsn2bPT17dix2dCG92A8elS6-ZjV9dgZrQnYbfgCVXQi3JrZ1qfwLQai_bUmhE8J_FDawkMTcZrofw6oWZCOnLJ5B2zcNoIOcYCrrraJ1SguEvTYYqxq6g90l-jPcPse3TN2_HViF0vpBTVdVf2M8-5GKeFbX6eqXwD3qJnx53E0LDeodf0S26zqvnrakEovnGjcJYVqi23KLvHmLYCeZVaa5mxm9kAUeXOiZKYkuDtzc07NBdR9AZX4zz8O8ZrElWXar3geAweJ5WqSfivEZdZpsrfwG3rWGjOtlTTxfo_5fFHQoLTjcPG8eoOR0QJjncNlBRocmaeKcFmYRzrrH54USUprOkgJF2DBwPTTSfFE5Mtog1Tj1rXLgiXpDiQn6S4XUdJkq3yfLHKs3WepiF5IUWyjtJ4uYzzLMtv8zROjyH5NfCX0WKV5Ovs9CbxYpWuQwJcWG0-TB-a059L437wTFkcfwP4C3xQ?type=png)](https://mermaid.live/edit#pako:eNqNVFFvmzAQ_ivIjxNFIRBC0bSHqX3LpmmdNqmyNHn4SpwaGxkT1kX577sATnC6TSNIOX933-e785kDKTUHUpBSsra9E6wyrKaKCwOlFVoF779QNfiCe8uaBoIDVQE-G62qIIAB-y74CAplg0CCqiyMwIM14hQndcmsQPDoq32GtpOWMfsn2bPT17dix2dCG92A8elS6-ZjV9dgZrQnYbfgCVXQi3JrZ1qfwLQai_bUmhE8J_FDawkMTcZrofw6oWZCOnLJ5B2zcNoIOcYCrrraJ1SguEvTYYqxq6g90l-jPcPse3TN2_HViF0vpBTVdVf2M8-5GKeFbX6eqXwD3qJnx53E0LDeodf0S26zqvnrakEovnGjcJYVqi23KLvHmLYCeZVaa5mxm9kAUeXOiZKYkuDtzc07NBdR9AZX4zz8O8ZrElWXar3geAweJ5WqSfivEZdZpsrfwG3rWGjOtlTTxfo_5fFHQoLTjcPG8eoOR0QJjncNlBRocmaeKcFmYRzrrH54USUprOkgJF2DBwPTTSfFE5Mtog1Tj1rXLgiXpDiQn6S4XUdJkq3yfLHKs3WepiF5IUWyjtJ4uYzzLMtv8zROjyH5NfCX0WKV5Ovs9CbxYpWuQwJcWG0-TB-a059L437wTFkcfwP4C3xQ)

## Beschrijving van het huidige databaseschema

### Entiteiten/modellen en hun properties

Om de database van *De Vrolijke Zweters* uit te werken, zijn 6 enititeiten/modellen gebruikt. De eerste entiteit is een Wedstrijd, deze bevat een wedstrijd_id dat uniek is. Ook de naam, start- en eindlocatie, datum en inschrijvingsgeld zitten in deze entiteit. Aangezien elke Wedstrijd uit meerdere Etappes bestaat, is dit de volgende entiteit. Deze bevat een etappe_id, de lengte van de etappe en de locatie. Via het etappe_id, kan deze telkens aan de juiste wedstrijd gelinkt worden waartoe deze behoort. Daarnaast is er een entiteit Persoon die een aantal kenmerken heeft: persoon_id, email, geboortedatum, gender, naam, voornaam en zodat elke persoon kan inloggen heeft deze ook een wachtwoord en admin-boolean. Als een persoon is ingelogd, kan deze zich inschrijven voor een wedstrijd als vrijwilliger of als loper. De entiteit Loper heeft er bovenop de kenmerken van Persoon nog een paar extra namelijk de fitheid en het gewicht. Naast deze kenmerken heeft elke Loper nog een uniek loopNummer. Ook de entiteit van de Vrijwilligers bevat twee extra kenmerken bovenop deze van persoon: vrijwilliger_id en taak. Met het vrijwilliger_id kan de juiste persoon aan de juiste wedstrijd gelinkt worden. Om de verschillende resultaten per etappe bij te houden heeft de entiteit EtappeResultaat een property tijd. Voor elke Loper worden er apart EtappeResultaten aangemaakt, die op hun beurt gelinkt zijn met de etapperesultaat_id aan de bijhorende Etappe. Op deze manier kan elk resultaat aan de juiste loper en de juiste etappe (en ook de wedstrijd dus) gelinkt worden.

### Relaties tussen entiteiten/modellen

Een persoon kan zich nooit of juist meermaals inschrijven als loper en/of als vrijwilliger, vandaar is de relatie tussen persoon en vrijwilliger/loper een 1-op-veel relatie. Want elke loper/vrijwilliger wordt maar aan één persoon gekoppeld

Een wedstrijd kan georganiseerd worden met 0 of meer vrijwilligers en elke vrijwilliger kan helpen bij 1 wedstrijd. Aangezien deze vrijwilliger telkens apart voor elke wedstrijd aangemaakt worden. Vandaar de keuze van een 1-op-veel relatie.

Elke wedstrijd kan bestaan uit 1 of meerdere etappes maar elke etappe kan maar aan 1 wedstijd gelinkt worden. Sommige wedstrijden zijn kort genoeg om maar uit 1 etappe te bestaan, bijvoorbeeld een kids-run maar een wedstrijd kan natuurlijk ook uit meerdere etappes bestaan. Dus de relatie tussen een wedstrijd en een etappe is een 1-op-veel relatie.

Voor elke loper die zich inschrijft worden het aantal etapperesultaten gegenereerd als dat er etappes zijn dus vandaar 1 of meer etapperesultaten per loper en per etapperesultaat exact 1 loper.

Elke etappe heeft evenveel etapperesultaten als het aantal lopers bij die wedstrijd vermenigvuldigd met het aantal etappes in die bepaalde wedstrijd. Elk etapperesultaat is dan ook aan exact 1 etappe gelinkt maar een etappe bevat dus 1 of meerdere etapperesultaten, een 1-op-veel relatie.
