# Integration Engine – CloudEagle Assignment

## Overview
This project is a Spring Boot–based, config-driven integration engine that pulls user data from external SaaS applications like Calendly using a generic API client.

## Features
- Dynamic API configuration stored in DB
- Generic API caller
- OAuth-based Calendly integration
- Temporary user storage (ETL style)
- Easily extensible for other SaaS apps (Dropbox, etc.)

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- WebClient
- H2 Database

## API
POST /integrations/calendly/users  
Authorization: Bearer <ACCESS_TOKEN>

## Interview Summary
This project forms the backend foundation for an AI-generated integration builder where integrations can be onboarded without redeployment.
