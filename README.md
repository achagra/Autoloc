# AutoLoc — Système de Gestion de Location de Véhicules

## 📌 Contexte

AutoLoc est une application de gestion de location de véhicules permettant à des clients de réserver des véhicules auprès d'agences, et aux employés de gérer le parc, les contrats, les paiements et la maintenance.

---

## 👥 Acteurs (Séance 1)

### 1. Client
Personne physique qui souhaite louer un véhicule auprès d'une agence AutoLoc.

### 2. Agent d'agence
Employé travaillant au sein d'une agence, chargé des opérations courantes : gestion des réservations, remise des véhicules, encaissement des paiements.

### 3. Responsable d'agence (Manager)
Employé responsable de la supervision d'une agence : gestion du parc de véhicules, validation des contrats, suivi de la maintenance, supervision des agents.

### 4. Administrateur
Utilisateur disposant des droits les plus élevés sur le système : gestion globale des agences, des employés, des catégories de véhicules et des paramètres de l'application.

---

## 🎯 Cas d'utilisation par acteur

### 👤 Client
- S'inscrire / créer un compte
- Consulter les véhicules disponibles
- Rechercher un véhicule (par catégorie, agence, dates de disponibilité)
- Effectuer une réservation
- Annuler une réservation
- Consulter l'historique de ses réservations
- Signer un contrat de location
- Effectuer un paiement
- Consulter ses factures / paiements

### 🧑‍💼 Agent d'agence
- Consulter les réservations de l'agence
- Confirmer / annuler une réservation
- Remettre un véhicule au client (début de location)
- Récupérer un véhicule (fin de location)
- Enregistrer un paiement
- Générer un contrat de location
- Consulter la disponibilité des véhicules
- Signaler un incident ou besoin de maintenance

### 🧑‍💻 Responsable d'agence (Manager)
- Gérer le parc de véhicules de l'agence (ajout, modification, retrait)
- Superviser les agents de l'agence
- Valider les contrats de location
- Planifier une maintenance de véhicule
- Consulter les statistiques de l'agence (taux d'occupation, revenus)
- Gérer les équipements associés aux véhicules
- Consulter et suivre les réservations en cours

### 🛠️ Administrateur
- Gérer les agences (création, modification, suppression)
- Gérer les employés (création de comptes, attribution des rôles)
- Gérer les catégories de véhicules
- Superviser l'ensemble des agences et véhicules
- Consulter les statistiques globales de l'application
- Gérer les modes de paiement acceptés
- Configurer les paramètres généraux du système

---

## 🔄 Cas d'utilisation partagés / transverses
- S'authentifier (Login)
- Se déconnecter
- Modifier son profil
- Consulter les notifications

---

## 📝 Notes
Cette liste constitue une première version des acteurs et cas d'utilisation identifiés en **Séance 1**. Elle sera affinée et complétée lors des séances suivantes (ajout de diagrammes de cas d'utilisation UML, détail des scénarios, gestion des exceptions, etc.).
