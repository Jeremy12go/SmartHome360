

En caso de no observar usuarios en el inicio.
ejecutar lo siguiente
```bash
    docker-compose down -v
    docker volume rm smarthome360_db-data
    docker-compose up --build

```