#Feedback GraphQL API

Ce projet est une API construite avec Spring Boot , GraphQL, Spring Data JPA, et une base H2 en mémoire. Il permet de gérer les retours utilisateurs (feedbacks) associés à des produits.

# Fonctionnalités

-  Rechercher tous les produits
-  Récupérer les feedbacks d’un produit
-  Calculer la moyenne des avis
-  Ajouter un feedback via une mutation GraphQL

##  Modèle de données

- `User`: utilisateur avec un nom et un email
- `Product`: produit avec nom et description
- `Feedback`: note, commentaire, date, utilisateur et produit

##  Technologies

- Java 17
- Spring Boot 3.1
- GraphQL (spring-boot-starter-graphql)
- Spring Data JPA
- H2 Database
- Lombok

##  Lancer l'application

```bash
./mvnw spring-boot:run
--Exemples de requêtes GraphQL
..Ajouter un Feedback
mutation {
  addFeedback(feedback: {
    userId: 1,
    productId: 2,
    rating: 4,
    comment: "Excellent produit !"
  }) {
    id
    rating
  }
}
..Feedbacks par produit
query {
  feedbacksByProduct(productId: 2) {
    id
    rating
    comment
    date
    user {
      name
    }
  }
}

..Moyenne des notes
query {
  averageRating(productId: 2)
}
.. Tous les produits
query {
  allProducts {
    id
    name
    description
  }
}

