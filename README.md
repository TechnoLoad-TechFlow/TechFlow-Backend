# TechFlow Backend

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE.md)

API REST de **TechFlow**, la plataforma de TechnoLoad para administrar flotas de maquinaria, alquileres, mantenimiento y operaciones de campo. Está construida con Java 21, Spring Boot, DDD y CQRS.

## Alcance funcional

- **IAM y perfiles**: registro, inicio de sesión con JWT, roles, perfiles y organizaciones.
- **Flota**: categorías, registro de maquinaria y cambios de estado.
- **Alquileres**: solicitudes, confirmaciones, rechazos y cancelaciones.
- **Mantenimiento**: mantenimiento preventivo y reportes de averías.
- **Operaciones**: inicio y cierre de servicios, horas trabajadas y validación.
- **Suscripciones y facturación**: gestión de planes, suscripciones y comprobantes.
- **Operación técnica**: health check, documentación OpenAPI y outbox transaccional para eventos de dominio.

Las rutas principales comienzan en `/api/v1`; la documentación interactiva está disponible en `/swagger-ui/index.html`.

## Arquitectura

El código se organiza por contextos delimitados: `iam`, `profiles`, `fleet`, `rental`, `maintenance`, `operations`, `subscription`, `billing` y `shared`.

- Los comandos y consultas están separados (CQRS).
- Los agregados de dominio no dependen de JPA; la persistencia usa entidades y ensambladores paralelos.
- Los eventos de dominio se guardan en `outbox_events` dentro de la misma transacción y se publican posteriormente.
- Los errores HTTP usan `ProblemDetail` (RFC 9457).

## Requisitos

- Java 21+
- MySQL 8+
- Docker (opcional)

## Configuración local

```bash
git clone https://github.com/TechnoLoad-TechFlow/TechFlow-Backend.git
cd TechFlow-Backend
export JWT_SECRET='una-clave-local-de-al-menos-32-caracteres'
./mvnw spring-boot:run
```

Por defecto el perfil `dev` usa MySQL local (`root` / `password`, base `techflow`). Ajusta estas variables según corresponda:

| Variable | Uso |
|---|---|
| `DATABASE_URL`, `DATABASE_PORT`, `DATABASE_NAME` | Conexión a MySQL |
| `DATABASE_USER`, `DATABASE_PASSWORD` | Credenciales de MySQL |
| `JWT_SECRET` | Clave de firma para los tokens JWT |
| `CORS_ALLOWED_ORIGINS` | Orígenes web permitidos, separados por coma |
| `PORT` | Puerto HTTP (por defecto `8080`) |

Verifica la ejecución en `http://localhost:8080/health`.

También puedes iniciar el API y MySQL para desarrollo local con:

```bash
docker compose up --build
```

## Despliegue

La imagen ejecuta el perfil `prod`, que requiere `JWT_SECRET` y valida el esquema de base de datos en lugar de modificarlo automáticamente.

```bash
docker build -t techflow-backend .
docker run -p 8080:8080 \
  -e DATABASE_URL=... -e DATABASE_NAME=... \
  -e DATABASE_USER=... -e DATABASE_PASSWORD=... \
  -e JWT_SECRET=... \
  -e CORS_ALLOWED_ORIGINS=https://tu-frontend.example \
  techflow-backend
```

## Integraciones pendientes de producción

Los adaptadores de Mercado Pago y SUNAT incluidos son simulaciones de desarrollo. Antes de usarlos para cobros o emisión fiscal reales, deben sustituirse por integraciones verificadas, con credenciales gestionadas de forma segura y pruebas de extremo a extremo.

## Licencia y atribución

Esta adaptación para TechnoLoad se basa en la arquitectura del proyecto público MaquiControl Backend de AndesHeavyTech, distribuido bajo licencia MIT. Se conserva su aviso de copyright en [LICENSE.md](LICENSE.md). Consulta [CONTRIBUTING.md](CONTRIBUTING.md) para colaborar.
