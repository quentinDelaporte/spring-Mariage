# spring-tp-Mariage

## Sujet

Pour organiser mon mariage j’ai réalisé une application mobile et un site web afin de gérer la présence des invités.

Ils vont pouvoir y notifier, modifier, ou supprimer leur présence.
Ils peuvent être présent

- à la cérémonie
- au vin d’honneur
- au repas

Ils auront le choix entre 3 plats au repas :

- bœuf
- poisson
- végé.

Je souhaiterais voir la liste de mes invités, leur présence et le plat qu’ils ont choisi.
J’ai besoin d’une API RESTfull pour gérer les données en base. Je veux également une sécurité qui ne me permettrais qu’à moi de communiquer avec l’API.

https://docs.google.com/presentation/d/1iutAVyLIoZBWkTJfIlL7LT-S9f9YCGIq/edit?usp=sharing&ouid=105262689044080200565&rtpof=true&sd=true

## Installation

Avant le premier lancement du projet tapez depuis le dossier docker la commande suivante :
docker-compose up --build --force-recreate

Vous pouvez alors lancer le projet.

## Spécification

La base mongo tourne sur le port 27018

Clé d'api: RIOUF4JCRE09FJ9430GH340

## TODO

Retour d'erreur si plat incorrect
