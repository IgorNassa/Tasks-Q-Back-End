# Task-Q API — Backend

Backend do **Task-Q**, uma plataforma corporativa gamificada para gestão de projetos, tarefas, equipes e produtividade.

Este repositório contém exclusivamente a **API REST do Task-Q**, desenvolvida utilizando **Java e Spring Boot**.

> Projeto Full Stack desenvolvido com foco em boas práticas de Engenharia de Software, organização arquitetural, escalabilidade e evolução incremental.

---

## 🚀 Sobre o Task-Q

O **Task-Q** é uma plataforma de gestão corporativa que combina **produtividade, colaboração e gamificação**.

A plataforma permite que equipes organizem projetos e tarefas enquanto colaboradores evoluem através de mecanismos como **XP, níveis, conquistas e reconhecimento**.

A proposta é construir inicialmente uma aplicação simples e funcional, mantendo uma arquitetura preparada para receber novos módulos conforme o produto evolui.

---

## 🛠️ Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven
* JWT para autenticação

---

## 🏗️ Arquitetura

O backend será organizado principalmente por **domínios de negócio**, permitindo que cada módulo evolua de maneira independente.

```text
src/main/java/.../taskq

├── auth/
├── user/
├── workspace/
├── project/
├── task/
├── gamification/
├── activity/
├── common/
└── config/
```

Cada domínio poderá possuir seus próprios:

```text
controller
service
repository
entity
dto
mapper
enums
```

Fluxo básico da aplicação:

```text
HTTP Request
     ↓
Controller
     ↓
Service
     ↓
Repository
     ↓
PostgreSQL
```

---

## 🧩 Domínios

### User

Gerenciamento dos usuários e colaboradores da plataforma.

### Workspace

Representa o ambiente corporativo onde usuários e projetos são organizados.

### Project

Gerenciamento dos projetos existentes dentro de um Workspace.

### Task

Gerenciamento das tarefas, responsáveis, prioridades, status e prazos.

### Gamification

Sistema responsável pela progressão dos usuários através de XP e níveis.

### Activity

Registro das principais atividades realizadas dentro da plataforma.

---

## 📦 Entidades

```text
User
Workspace
WorkspaceMember

Project
ProjectMember

Task
TaskLabel
ChecklistItem

Comment
Activity

XpTransaction
```

Enums principais:

```text
Role

ProjectStatus
ProjectPriority

TaskStatus
TaskPriority

ActivityType

XpReason
XpReferenceType
```

---

## 🔗 Endpoints iniciais

```http
POST   /api/users
GET    /api/users

POST   /api/projects
GET    /api/projects

POST   /api/tasks
PATCH  /api/tasks/{id}/status
```

Novos endpoints serão adicionados conforme a evolução da API.

---

## 🎮 Gamificação

Um dos principais diferenciais do Task-Q será seu sistema de gamificação.

Usuários poderão possuir:

```text
XP
Level
```

As movimentações de experiência serão registradas através de `XpTransaction`.

Exemplo:

```text
Tarefa concluída
       ↓
     +20 XP
       ↓
XpTransaction
       ↓
XP atualizado
       ↓
Nível recalculado
```

Essa estrutura permitirá futuramente implementar:

* Rankings
* Conquistas
* Badges
* Missões
* Streaks
* Recompensas

---

## 🗺️ Roadmap

### Task-Q V1 — Foundation

* Usuários
* Workspaces
* Projetos
* Tarefas
* Status
* Prioridades
* XP básico

### Task-Q V2 — Collaboration

* Comentários
* Checklists
* Atividades
* Notificações

### Task-Q V3 — Gamification

* XP avançado
* Níveis
* Ranking
* Conquistas
* Badges
* Missões

### Task-Q V4 — Platform

* Feed corporativo
* Analytics
* Administração
* Recursos avançados de colaboração

---

## 🌐 Frontend

O frontend será desenvolvido separadamente utilizando **Angular**.

```text
Angular
   ↓
HTTP / REST
   ↓
Task-Q API
   ↓
Spring Boot
   ↓
Spring Data JPA
   ↓
PostgreSQL
```

---

## 👥 Equipe

O Task-Q será desenvolvido por uma equipe de **4 integrantes**.

A divisão do desenvolvimento será feita principalmente por funcionalidades e domínios, permitindo que todos os integrantes tenham contato tanto com:

**Angular → Frontend**

quanto com:

**Spring Boot → Backend**

O projeto será desenvolvido incrementalmente, evitando complexidade prematura e priorizando uma fundação sólida antes da implementação de recursos mais avançados.

---

## 🎯 Objetivo

Construir uma aplicação Full Stack corporativa, funcional e escalável utilizando o **Task-Q** como ambiente para aplicação prática dos conceitos de:

* Java
* Spring Boot
* APIs REST
* JPA
* PostgreSQL
* Angular
* Engenharia de Software
* Arquitetura de aplicações
* Design Systems

A prioridade é simples:

> **Construir uma excelente fundação antes de adicionar complexidade.**
