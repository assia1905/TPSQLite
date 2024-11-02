# Application de Gestion des Étudiants
- Cette application Android permet de gérer les informations des étudiants en offrant des fonctionnalités d'ajout, de recherche et de suppression. Elle utilise SQLite pour le stockage local des données et RecyclerView pour afficher la liste des étudiants.

# Fonctionnalités
- Ajouter un étudiant : Ajouter un étudiant avec son nom et prénom.
- Rechercher un étudiant : Rechercher un étudiant spécifique par son ID.
- Supprimer un étudiant : Supprimer un étudiant en utilisant son ID.
- Afficher tous les étudiants : Voir la liste des étudiants ajoutés sous forme de liste.
# Structure du Projet
- MainActivity : Affiche la liste des étudiants avec des options pour ajouter, rechercher et supprimer.
- AddEtudiantActivity : Permet l’ajout d’un étudiant via un formulaire.
- EtudiantService : Fournit des fonctions de gestion des étudiants (ajout, suppression, recherche).
- MySQLiteHelper : Gère la base de données SQLite (création, connexion).
# Technologies et Outils
- Kotlin : Langage de programmation principal.
- SQLite : Base de données locale pour stocker les informations des étudiants.
- RecyclerView : Affichage de la liste des étudiants.
- ConstraintLayout : Disposition flexible pour les interfaces utilisateur.
# Installation
- Clonez le dépôt :
 -- git clone https://github.com/assia1905/TPSQLite
- Ouvrez le projet dans Android Studio.
- Synchronisez les dépendances Gradle.
- Exécutez l'application sur un émulateur ou un appareil physique Android.
# Utilisation
- Lancez l'application pour voir la liste des étudiants.
- Cliquez sur Ajouter pour ajouter un nouvel étudiant en entrant un nom et prénom.
- Entrez un ID et appuyez sur Rechercher pour vérifier si un étudiant existe.
- Entrez un ID et appuyez sur Supprimer pour retirer un étudiant de la liste.

# Démonstration Vidéo
- Une démonstration vidéo est disponible ici pour montrer l'ajout, la recherche et la suppression d'étudiants.
    https://github.com/user-attachments/assets/e2f9256a-1b40-4e00-a15d-f93a7e9ae3d4

# Auteur
- Développé par AsSia BOUJNAH.

