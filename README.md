# Keyra

**Keyra** is a lightweight, scalable Single Sign-On (SSO) system built with **Java (Quarkus)** and **TypeScript**.  
It centralizes user authentication and authorization, issuing **JWTs signed with RSA keys** for secure token validation across distributed applications and microservices.

## ✨ Features

- 🔐 Centralized user authentication and authorization
- 🪪 JWT-based session management with RSA key signing
- 📦 Microservice-ready architecture
- 🌍 RESTful API for seamless integration
- ⚡ Fast boot and low memory footprint using Quarkus
- 🧪 Built-in testing and dev mode
- 🐳 Container-ready with Docker/Podman support

---

## 📦 Tech Stack

- **Backend**: Java (Quarkus)
- **Frontend/Admin Panel (optional)**: TypeScript (e.g., React or Svelte)
- **Database**: PostgreSQL
- **Security**: JWT (RS256), SmallRye JWT, Role-based access
- **ORM & Migration**: Hibernate ORM with Panache, Flyway
- **Build Tool**: Maven

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL
- Podman or Docker (optional for containerization)

### Clone the Repository

```bash
git clone https://github.com/your-username/keyra.git
cd keyra
