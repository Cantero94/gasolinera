# API de Gestión de Estación de Servicio (Gasolinera)

Proyecto académico orientado al desarrollo de una API REST para controlar las operaciones de una gasolinera. El sistema permite trabajar con productos, surtidores, tanques, precios y suministros. Implementado con tecnologías modernas y enfoque modular.

---

### 💻 API en producción

Podés acceder a la versión desplegada de la API en el siguiente enlace:

🌐 [gasolinera.onrender.com](https://gasolinera-aabs.onrender.com)

---

## 🛠 Tecnologías

- Java 17
- Spring Boot (v3+)
- Spring Data JPA + Hibernate
- Base de datos MySQL (o H2 en memoria)
- Lombok
- Maven

---

## 📌 Funcionalidades Principales

- Alta, modificación y baja de surtidores
- Administración de productos combustibles (diésel, gasolina, etc.)
- Histórico de precios por producto
- Gestión de tanques de almacenamiento
- Registro de suministros realizados
- Asociación entre productos y surtidores

---

## 📁 Módulos y Entidades

### `Producto`
- nombre
- descripción
- tipo (gasolina, diésel, etc.)

### `Precio`
- producto asociado
- fechaInicio / fechaFin
- precioPorLitro

### `Tanque`
- código identificador
- capacidad máxima
- nivel actual
- producto almacenado

### `Surtidor`
- código
- fecha de instalación
- estado (activo/inactivo)

### `Suministro`
- surtidor que realiza el suministro
- producto dispensado
- fecha y hora
- volumen
- importe total

### `SurtidorProducto`
- entidad puente entre surtidor y producto

---

## 📡 Endpoints REST

### Productos
- `GET /api/productos/traer`
- `GET /api/productos/traer/{id}`
- `POST /api/productos/crear`
- `PUT /api/productos/editar/{id}` (vía URL o JSON)
- `DELETE /api/productos/borrar/{id}`

### Surtidores
- `GET /api/surtidores/traer`
- `GET /api/surtidores/traer/{id}`
- `POST /api/surtidores/crear`
- `PUT /api/surtidores/editar/{id}` (vía URL o JSON)
- `DELETE /api/surtidores/borrar/{id}`

### Tanques
- `GET /api/tanques/traer`
- `GET /api/tanques/traer/{id}`
- `POST /api/tanques/crear`
- `PUT /api/tanques/editar/{id}` (vía URL o JSON)
- `PUT /api/tanques/editar` (vía JSON)
- `DELETE /api/tanques/borrar/{id}`

### Precios
- `GET /api/precios/traer`
- `GET /api/precios/traer/{id}`
- `POST /api/precios/crear`
- `PUT /api/precios/editar/{id}` (vía URL o JSON)
- `PUT /api/precios/editar` (vía JSON)
- `DELETE /api/precios/borrar/{id}`

### Suministros
- `GET /api/suministros/traer`
- `GET /api/suministros/traer/{id}`
- `POST /api/suministros/crear`
- `DELETE /api/suministros/borrar/{id}`

### Surtidor-Producto
- `GET /api/surtidor-productos/traer`
- `GET /api/surtidor-productos/traer/{id}`
- `POST /api/surtidor-productos/crear`
- `PUT /api/surtidor-productos/editar/{id}` (vía URL o JSON)
- `PUT /api/surtidor-productos/editar` (vía JSON)
- `DELETE /api/surtidor-productos/borrar/{id}`

---

### Importar colección de Postman

Para facilitar las pruebas, podés descargar la colección de endpoints en formato Postman desde el siguiente archivo:

[⬇️ Descargar Gasolinera.postman_collection.json](./Gasolinera.postman_collection.json)