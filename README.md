# spb-dvdstore-0
dvd store - mise en place de spring

## exo-3 : création des interfaces
- MovieRepository
- MovieService
Aucune injection de dépendance
Le programme plante donc car aucune instanciation n'est faite dans le code.

## exo-2 : Respository alternatif et couche de contrôle
- ajout d'un second repo permettant de stocker les movies dans un fichier
- dans le service, instanciation de ce nouveau repo.
- du coup débranchement du premier repo