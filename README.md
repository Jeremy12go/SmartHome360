# SmartHome360

Es un sistema inteligente de automatización del hogar que permite a los usuarios controlar dispositivos domésticos (luces, cámaras, termostatos, asistentes virtuales, etc.) a través de una aplicación web moderna.

El sistema soporta múltiples marcas mediante adaptadores y permite crear rutinas, aplicar modos como "noche" o "ahorro energético", y gestionar eventos como humo o intrusión.

---

## Tecnologías

### Backend
- Spring Boot 3.5.0
- Java 17
- Hibernate (JPA)
- PostgreSQL
- Lombok
- Gradle

### Frontend
- React + Vite
- Axios

### DevOps
- Docker
- Docker Compose

---

## Requisitos
Antes de ejecutar la aplicación, se debe tener instalado:
- [Docker desktop](https://docs.docker.com/desktop/)

---

## Instalación y ejecución (con Docker)

### 1. Clona el proyecto

```bash
    git clone https://github.com/tuusuario/SmartHome360.git
    cd SmartHome360
```

### 2. Ejecuta el proyecto
```bash
    docker-compose up --build
```

