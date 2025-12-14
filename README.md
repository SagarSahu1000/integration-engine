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

## OAuth2 Authentication Flow (Calendly)

This project implements the OAuth2 Authorization Code flow for Calendly.

- Step 1: Get Authorization Code

User is redirected to Calendly for authorization:

https://auth.calendly.com/oauth/authorize
?response_type=code
&client_id=YOUR_CLIENT_ID
&redirect_uri=http://localhost:8080/oauth/callback

After successful login and consent, Calendly redirects back with an authorization code.

- Step 2: Exchange Code for Access Token

The backend exchanges the authorization code for an access token by calling:

POST https://auth.calendly.com/oauth/token

The received access token is stored securely and used for API calls.
In a production setup, tokens should be stored in a secure vault and refreshed automatically.

## API Usage
Fetch Calendly Users

Once authenticated, user data can be fetched using:
GET http://localhost:8080/integrations/calendly/users
Authorization: Bearer <ACCESS_TOKEN>

## Processing Flow

- Calls Calendly API using the generic API client
- Parses the response dynamically
- Stores fetched users in a temporary table (temp_user)

## Summary
This project forms the backend foundation for an AI-generated integration builder where integrations can be onboarded without redeployment.
