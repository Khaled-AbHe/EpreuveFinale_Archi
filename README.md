# EpreuveFinale_Archi

Trello: https://trello.com/b/z9ZbMYg3/mod%C3%A8le-kanban

Il faut avoir Postman pour utiliser l'API

Après avoir lancé le code, l'application va rouler dans http://localhost:8080
- - -
# Admin Service

## Partie Offres
### Get All Offers

Requête: GET

URL: http://localhost:8080/api/admin/allOffers

### Add New Offer

Requête: POST

URL: http://localhost:8080/api/admin/addOffer

#### Parameters:

id (int) - Identifiant unique

trajetId (int)

operateurId (int)

depart (String) - Departure date/time (ISO-8601 format: 2025-12-15T19:30)

prixBase (double)

- - -
## Partie Terminal
### Get All Terminals

Requête: GET

URL: http://localhost:8080/api/admin/allTerminals

### Add New Terminal

Requête: POST

URL: http://localhost:8080/api/admin/addTerminal

#### Parameters:

id (int) - Identifiant unique

code (String) - 3 lettres uniques en majuscule

ville (String)

typeTrajet (TypeTransport) - AERIEN ou FERROVIAIRE