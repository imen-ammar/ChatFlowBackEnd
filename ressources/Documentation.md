<h1 align="center">Documentation</h1>

Ce document permet d'expliquer l'architecture de la partie Back End
# Architecture

<p align="center">
  <img src="images/architecture.png" alt="chatflow-logo" width="700px" height="350px"/>
</p>

## Entités
>Le package "entity" permet de regrouper les différents entités Java. <br>
Les classes utilisent les annotations JPA (@Entity, @Id, @column,...).<br>
Chaque identifiant d'une entité est géré par une séquence.

<p >
  <img src="images/entite_message.png" alt="Message" />
</p>

## Repository
>Le package "repository" permet de regrouper les différents interfaces qui etendent l'interface **JpaRepository.** On a utiliser cette interface parcequ'elle fournit par défaut les méthodes CRUD pour une entité. <br>
Pour étendre l'interface, il faut spécifier le nom de l'entité ainsi que le type de l'identifiant de cette entité.<br>
Vous pouvez aussi spécifier des méthodes avec des requêtes JPQL.

<p>
  <img src="images/repository_message.png" alt="messageRepository" />
</p>


## Services
>Le package "service" permet de regrouper les différents classes de service. 
Chaque classe est annoter par l'annotation **@Service**<br>
Pour chaque classe, on injecte la dépendance vers le reposiory via l'annotation **@Autowired**<br>
<p>
  <img src="images/service_message.png" alt="messageRepository" />
</p>

## Contrôleurs
>Le package "controller" permet de regrouper les différents classes qui exposent les web services REST.<br>
Chaque classe est annoter par les annotations **@RestController** et **@RequestMapping**<br>
Pour chaque classe, on injecte la dépendance vers le service via l'annotation **@Autowired**<br>
<p>
  <img src="images/controller_message.png" alt="messageRepository" />
</p>

## Schéma de la BDD
>Voici le schéma de la BDD généré via pgAdmin
<p>
  <img src="images/bdd.png" alt="schemaBDD" />
</p>


