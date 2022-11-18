# spb-dvdstore-0
dvd store - mise en place de spring

## exo-7 : valoriser une propriété de type File
- FileMovieRepository : ajout de la propriété file

## exo-6 : exploiter le conteneur léger de Spring
- Mise en place de SPRING-CONTEXT
- Création du fichier applicationContext

## exo-5 : changement de perspective
- d'une construction des classes sur la vision/configuration client
- on passe à une vision composant et fonctionnalité
==> renommage des classes en conséquences : 
GoLiveMovieRepository => FileMovieRepository

## exo-4 : injection des implémentations
au niveau de App injection:
- du service au niveau du controller
- du repository au niveau du service

## exo-3 : création des interfaces
- MovieRepository
- MovieService
Aucune injection de dépendance
Le programme plante donc car aucune instanciation n'est faite dans le code.

## exo-2 : Respository alternatif et couche de contrôle
- ajout d'un second repo permettant de stocker les movies dans un fichier
- dans le service, instanciation de ce nouveau repo.
- du coup débranchement du premier repo