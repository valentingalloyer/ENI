Version 1 :
-----------
Suivant les principes vus de division en deux couches (BLL et IHM) et une BO
Vous devez faire un logiciel de gestion des notes d'éléves (nom, prenom, note, classe).
Voici les fonctionnalités attendues :
- saisie des eleves avec leurs notes
- calcul de la moyenne générale
- calcul de la moyenne par classe
- qui est le meilleur élève



Remarque : les éleves saisies seront stockée dans une Liste static en attribut de votre Manager
ex : private static List<Eleve> lstEleves = new ArrayList<Eleve>();



Version 2 :
-----------
Nous avons besoin d'une nouvelle version de ce gestionnaire. Cette nouvelle version ajoutera 5 à toutes les notes.
Attention un éléve ne peut pas avoir plus de 20.
C'est le développeur de la BLL qui a la charge de choisir entre l'implémentation de base ou cette nouvelle implémentation.




Version 3 :
-----------
Faire en sorte que le développeur de l'IHM puisse choisir un mode NOTATION CLASSIQUE ou un mode NOTATION GENTILLE 