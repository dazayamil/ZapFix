# 👞 ZapFix - Sistema de Gestión de Turnos para Zapatería

**ZapFix** es una aplicación web pensada para digitalizar la gestión de trabajos en una zapatería. Permite registrar turnos de arreglo de calzado, consultar trabajos activos, gestionar estados y visualizar reportes de ingresos y actividad.

---

## 🚀 Tecnologías utilizadas

- ⚙️ **Backend:** Java 17, Spring Boot
- 💾 **Base de datos:** MySQL
- 📬 **API REST:** Spring MVC + JPA + Hibernate
- ✅ **Validaciones:** Jakarta Validation
- 🔐 **Seguridad (futura):** Usuario hardcodeado en memoria
- 🧪 **Pruebas:** Postman
- 🌐 **Frontend:** A definir (React / Angular / Thymeleaf)

---

### 📁 Estructura del proyecto
```bash
src/
├── config/         # Configuraciones generales
├── controller/     # Controladores (endpoints)
├── dto/            # Clases para entrada/salida de datos
├── exception/      # Manejo de errores personalizados
├── model/          # Entidades JPA
├── repository/     # Interfaces que extienden JpaRepository
├── service/        # Lógica de negocio
└── ZapfixApplication.java
```

## 🧠 Funcionalidades

- Registrar nuevo trabajo (cliente + datos del arreglo)
- Listar trabajos activos
- Marcar trabajo como finalizado o cancelado
- Buscar trabajos por nombre o descripción
- Generar reportes (ingresos, trabajos completados/pedidos, filtrado por fecha)

## 🔧 Configuración local
1. Clonar el repositorio
2. Crear una base de datos llamada zapfix y configurar tu archivo application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/zapfix
spring.datasource.username=tu_usuario
spring.datasource.password=tu_clave
spring.jpa.hibernate.ddl-auto=update
```
3. Levantar el proyecto: ./mvnw spring-boot:run


## 👥 Equipo de desarrollo

| Nombre                  | Rol        | GitHub                                      | LinkedIn                                                                        | Email                      |
|-------------------------|------------|---------------------------------------------|---------------------------------------------------------------------------------|----------------------------|
| Yamil Daza Rospilloso   | Backend    | [@daza-yamil](https://github.com/dazayamil) | [linkedin.com/in/yamil-daza](https://www.linkedin.com/in/yamil-daza/)           | dazayamil07@gmail.com      |
| Angel Gabriel Minjares Guerrero | Backend    | [@Gaboux21](https://github.com/Gaboux21)    | [linkedin.com/in/angelgabrielminjares](https://www.linkedin.com/in/angelgabrielminjares) | angelgabrielminjaresm@gmail.com |
| Pedro Purihuaman        | Full Stack | [@puriihuaman](https://github.com/puriihuaman)    | [linkedin.com/in/pedropurihuaman](https://www.linkedin.com/in/pedropurihuaman)  | pedropuriihuaman@gmail.com |

