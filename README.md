<h1 align="center">
  Testing OrderCraft
</h1>

## Description
Ce dépôt contient les tests unitaires pour l'application OrderCraft, un projet visant à assurer la fiabilité et la stabilité de la base de code. Les tests unitaires jouent un rôle crucial dans la détection précoce des erreurs, facilitant la maintenance future et optimisant les performances globales de l'application.
## Objectifs du projet
L'objectif principal de ce projet est de renforcer les compétences en programmation Java, en mettant particulièrement l'accent sur le domaine du testing à l'aide de JUnit et Jenkins. Cette initiative vise à fournir une expérience pratique dans l'application des concepts avancés de testing, tout en favorisant une collaboration efficace grâce à l'utilisation de Git et Github.

## Conception
### Database
![db](https://github.com/aitnacer-nabil/orderCraft_test/assets/102745014/0b0569d5-ad57-4b40-973a-63fa21f45517)

### Principales étapes :
Avant d'exécuter les tests, assurez-vous d'avoir configuré correctement les éléments suivants dans votre environnement de développement :

JUnit : Assurez-vous que JUnit est correctement configuré. Vous pouvez utiliser un outil de construction comme Apache Maven pour gérer les dépendances.

Jenkins : Configurez Jenkins pour l'intégration continue. Configurez Jenkins pour récupérer le code depuis votre système de contrôle de version (par exemple, Git ou GitHub) et exécuter les tests unitaires à l'aide de Maven.

Dépendances : Vérifiez que toutes les dépendances nécessaires sont incluses dans votre configuration Maven.

Classes de Test

<h1 align="center">
  Testing OrderCraft
</h1>

## Description
Ce dépôt contient les tests unitaires pour l'application OrderCraft, un projet visant à assurer la fiabilité et la stabilité de la base de code. Les tests unitaires jouent un rôle crucial dans la détection précoce des erreurs, facilitant la maintenance future et optimisant les performances globales de l'application.
## Objectifs du projet
L'objectif principal de ce projet est de renforcer les compétences en programmation Java, en mettant particulièrement l'accent sur le domaine du testing à l'aide de JUnit et Jenkins. Cette initiative vise à fournir une expérience pratique dans l'application des concepts avancés de testing, tout en favorisant une collaboration efficace grâce à l'utilisation de Git et Github.

## Conception
### Database

### Principales étapes :
Avant d'exécuter les tests, assurez-vous d'avoir configuré correctement les éléments suivants dans votre environnement de développement :

JUnit : Assurez-vous que JUnit est correctement configuré. Vous pouvez utiliser un outil de construction comme Apache Maven pour gérer les dépendances.

Jenkins : Configurez Jenkins pour l'intégration continue. Configurez Jenkins pour récupérer le code depuis votre système de contrôle de version (par exemple, Git ou GitHub) et exécuter les tests unitaires à l'aide de Maven.

Dépendances : Vérifiez que toutes les dépendances nécessaires sont incluses dans votre configuration Maven.

Classes de Test

CustomerServiceImplTest

Description : Contient des tests pour la classe CustomerServiceImpl.

Tests :

addCustomer : Teste la méthode addCustomer, assurant l'ajout réussi d'un client.

updateCustomer : Teste la méthode updateCustomer, vérifiant que les détails du client peuvent être mis à jour.

deleteCustomerById : Teste la méthode deleteCustomerById, vérifiant qu'un client est supprimé avec succès.

getAllCustomers : Teste la méthode getAllCustomers, assurant le retour d'une liste de clients non vide.

getCustomerById : Teste la méthode getCustomerById, vérifiant qu'un client est récupéré par ID.

InventoryServiceImplTest

Description : Contient des tests pour la classe InventoryServiceImpl.

Tests :

saveInventory : Teste la méthode saveInventory, assurant qu'un inventaire est sauvegardé avec succès.

getInventoryById : Teste la méthode getInventoryById, vérifiant qu'un inventaire est récupéré par ID.

deleteInventory : Teste la méthode deleteInventory, vérifiant qu'un inventaire est supprimé avec succès.

OrderServiceImplTest

Description : Contient des tests pour la classe OrderServiceImpl.

Tests :

createOrder : Teste la méthode createOrder, assurant la création réussie d'une nouvelle commande.

getOrder : Teste la méthode getOrder, vérifiant qu'une commande est récupérée par ID.

getAllOrders : Teste la méthode getAllOrders, assurant le retour d'une liste de commandes non vide.

updateOrder : Teste la méthode updateOrder, vérifiant que le statut d'une commande peut être mis à jour.

deleteOrderById : Teste la méthode deleteOrderById, vérifiant qu'une commande est supprimée avec succès.

ProductServiceImplTest

Description : Contient des tests pour la classe ProductServiceImpl.

Tests :

getProductById : Teste la méthode getProductById, assurant qu'un produit est récupéré par ID.

saveProduct : Teste la méthode saveProduct, vérifiant qu'un produit est sauvegardé avec succès.

updateProduct : Teste la méthode updateProduct, vérifiant que les détails du produit peuvent être mis à jour.

deleteProductById : Teste la méthode deleteProductById, assurant qu'un produit est supprimé avec succès.

getAllProducts : Teste la méthode getAllProducts, assurant le retour d'une liste de produits non vide.

Exécution des Tests

Exécution Locale :

Exécutez les tests localement à l'aide de votre IDE ou outil de construction préféré.

Intégration Jenkins :

Configurez Jenkins pour déclencher les tests à chaque modification du code.

Consultation des Résultats :

Consultez Jenkins pour obtenir des résultats détaillés des tests et des rapports.

Documentation

Pour des informations détaillées sur chaque test et le but des tests unitaires de l'application OrderCraft, référez-vous aux commentaires intégrés dans les classes de test respectives.

### Screen jenkins
![Screenshot_jenkins](https://github.com/aitnacer-nabil/orderCraft_test/assets/102745014/67cd5755-c2c2-4243-87e9-dcbe8030e172)

## Les outils utilisés <a name = "outils-utilisés"></a>
- IntelliJ IDEA
- Git
- GitHub
- StarUML
- Xampp
- Jenkins
