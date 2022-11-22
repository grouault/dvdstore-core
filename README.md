# spb-dvdstore-0
dvd store - mise en place de spring

## exo-19 : DVDStore - About Us Page
- ajout de la vue
- ajout de la locale

## exo-19 : DVDStore - About Us
- Mise en place du controller Spring MVC

## exo-18 : fichier statiques hors de l'application
- mise en commentaire

## exo-17-18 : Ressource web statiques
- changer le port et le context
- fichier static sur le système de fichier

## exo-16 : mettre en place le serveur d'application
- mise en place du starter : spring-boot-starter-web

## exo-15 : standard maven
- mise en place de spring-boot avec les starters maven

## exo-14 : passer à Spring-Boot
- ajout de la librairie spring-boot-autoconfigure

## exo-13 : déplacer les annotations vers la classe exécutable
On peut se passer des classes spécifique de configuration,
en mettant l'annotation @Config sur la classe App
La classe App est une classe exécutable.
La machine virtuelle va lancer la méthode static main.
La classe ne sera alors instancier qu'à l'exécution du code suivant :
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
L'objet sera placé dans le container léger de Spring

## exo-12 : se passer du fichier xml
- @Configuration
- @ComponentScan
- @PropertySource

## exo-11 : détection automatique des beans
- @ComponentScan

## exo-10 : annotation du chemin du fichier .csv
- @Value et fichier application.properties

## exo-9 : annotation des dépendances
- context:annotation-config
- @Autowired

## exo-8 : injection automatique des dépendances
- autowire byType

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