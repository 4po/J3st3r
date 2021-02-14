J3st3r
======

Jester est un outil expérimental (c'est-à-dire inachevé) de test de l'API. Il produit vos actions sous forme d'instructions Java à l'aide de REST Assured qui peuvent ensuite être refaites en tests réutilisables.
Jester peut GET, éditer ou importer et POSTER des réponses JSON, affirmer sur les réponses ou SUPPRIMER des points terminaux de l'API.



Construction de Jester
===============

Clonez ou téléchargez le code source et l'un ou l'autre :

Ouvrez le dossier "Jester" dans NetBeans ou votre IDE préféré, et construisez-le.

Construisez un paquet à partir de la ligne de commande avec :

        mvn package 



Le bouffon en marche
==============

Une fois la construction terminée, double-cliquez sur "Jester-0.2.jar" dans le dossier "target" ou démarrez à partir de la ligne de commande avec :

    java -jar target/Jester-0.2.jar
    



Test du bouffon
============
Jester peut GET, POST, DELETE, affirmer des valeurs dans les réponses et toutes ces opérations génèrent des déclarations Java en utilisant soit Junit4 soit Junit5.


POST
----
Vous pouvez soit importer des données JSON depuis "Fichier -> Importer", soit les créer en insérant des clés et des valeurs dans l'objet vide (ce qui peut être un peu instable, avec un minimum de vérification d'erreurs).
Cliquez ensuite sur l'icône "POST". Il existe une option dans les "Paramètres" pour analyser uniquement les réponses GET.


GET
---
Saisissez un URI dans le champ de texte et cliquez sur "GET". L'arborescence sera (ou devrait être) mise à jour avec une représentation graphique de la réponse. Vous pouvez maintenant l'éditer et l'afficher.


SUPPRIMER
------
Envoi d'une simple demande d'EFFACER.


AFFICHEZ
------
Faites un clic droit sur une valeur de l'arbre et affirmez-la.


Edition JSON
------------
Vous pouvez insérer, supprimer et modifier des éléments JSON avec un certain contrôle d'erreur. L'édition de données dans un tableau fonctionne, mais pas la création de nouveaux éléments de tableau. 

Cookies et en-têtes
-----------------
Les cookies et les en-têtes personnalisés peuvent être inclus dans les demandes en les ajoutant aux zones de texte sous la forme d'une liste de paires clé=valeur séparées par des virgules - par exemple

    q=test&type=debug




Paramètres d'interrogation
----------------
Ajoutez des paramètres de requête à la demande en les ajoutant à l'URI - par exemple

    q=test&type=debug


Dans le cadre de droite, des instructions Java sont générées. Celles-ci devraient pouvoir être exécutées à partir d'un EDI, etc. après un petit nettoyage.



