Vous allez créer une application qui permet de gérer un voyage scolaire pour tout un lycée.
Il vous faudra gérer les participants qui peuvent être des lycéens ou des profs, mais aussi les cars
 permettant de les conduire sur le lieu de voyage.

1. saisir de nouveaux passagers (profs ou lycéens). Chaque lycéen fait partie d’une classe (qui est juste une chaîne de caractère, je n’attends pas une classe Classe).
2. saisir de nouveaux cars. Un car doit obligatoirement avoir un nombre de places maximum.
3. mettre des passagers dans un car en respectant les règles de gestion (voir plus loin)
4. afficher les cars avec leurs passagers
5. vérifier que tous les cars peuvent partir en respectant les règles de gestion (voir plus loin)

Voici les règles de gestion de l’application :
1. un bus ne peut pas prendre plus de passagers qu’il n’a de places
2. un car ne peut pas partir s’il n’y a pas au moins un prof pour 10 lycéens maximum
3. il ne peut pas y avoir plus de 3 classes différentes dans un car
4. un car ne part pas à vide (s’il n’y a personne dedans)
5. Un lycéen a obligatoirement un nom de classe

Procéder dans cet ordre :
travailler la BO (mise en place de classes avec héritage et associations)
	travailler sur les fonctionnalités une à une et tester à chaque fois.
	puis faire de même pour chaque contrainte.