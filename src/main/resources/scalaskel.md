L’échoppe de monade sur Scalaskel.
==============

Sur la planète Scalaskel, une planète en marge de la galaxie, aux confins de l'univers, la monnaie se compte en cents,
comme chez nous. 100 cents font un groDessimal. Le groDessimal est la monnaie standard utilisable partout sur toutes les
planètes de l’univers connu. C'est un peu compliqué à manipuler, mais si on ne s'en sert pas y'a toujours des erreurs
d'arrondis incroyables quand on les soustrais ou on les divise, c’est idiot, mais c’est comme ça.  Sur Scalaskel, on
utilise rarement des groDessimaux, on utilise des pièces plus petites : Le **Foo** vaut **1 cent**, le **Bar** vaut
 **7 cents**, le **Qix** vaut **11 cents** et le **Baz** vaut **21 cents**.

Vous tenez une échoppe de monade et autres variables méta-syntaxique sur Scalaskel. Pour faire face à l’afflux de
touristes étrangers avec les poches remplies de groDessimaux vous avez besoin d’écrire un programme qui pour toute
somme de 1 à 100 cents, vous donnera toutes les décompositions possibles en pièces de **Foo**, **Bar**, **Qix** ou
 **Baz**.

Par exemple, 1 cent ne peut se décomposer qu’en une seule pièce Foo.
Par contre 7 cents peuvent se décomposer soit en 7 pièces Foo, soit en 1 pièce Bar.
Serveur Web
Votre serveur doit répondre aux requetes http GET de la forme `http://serveur/scalaskel/change/X`, `X` étant une valeur
en cents de 1 à 100 cents.

La réponse attendue est un json de la forme :

[{“foo”: w, “bar”, x, “qix”, y, “baz”: z}, …]

Exemples
Pour `http://serveur/scalaskel/change/1` il faut répondre :

[ {“foo”: 1} ]

Pour `http://serveur/scalaskel/change/7` il faut répondre :

[ {“foo”: 7}, {“bar”: 1} ]


L’ordre des valeurs dans le tableau json, ainsi que le formatage n’a pas d’importance à partir du moment ou c’est du json valide, il s’entends.

Bon courage !
