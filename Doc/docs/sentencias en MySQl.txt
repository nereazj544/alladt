
### 1. Sentencias de Definición de Datos (DDL)
- **CREATE DATABASE**:
  ```sql
  CREATE DATABASE mi_base_de_datos;
  ```
- **DROP DATABASE**:
  ```sql
  DROP DATABASE mi_base_de_datos;
  ```
- **CREATE TABLE**:
  ```sql
  CREATE TABLE empleados (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    puesto VARCHAR(50),
    salario DECIMAL(10, 2),
    PRIMARY KEY (id)
  );
  ```
- **DROP TABLE**:
  ```sql
  DROP TABLE empleados;
  ```
- **ALTER TABLE**:
  ```sql
  ALTER TABLE empleados ADD COLUMN fecha_contratacion DATE;
  ```
- **TRUNCATE TABLE**:
  ```sql
  TRUNCATE TABLE empleados;
  ```

### 2. Sentencias de Manipulación de Datos (DML)
- **SELECT**:
  ```sql
  SELECT * FROM empleados;
  ```
- **INSERT INTO**:
  ```sql
  INSERT INTO empleados (nombre, puesto, salario) VALUES ('Juan Pérez', 'Desarrollador', 50000.00);
  ```
- **UPDATE**:
  ```sql
  UPDATE empleados SET salario = 55000.00 WHERE nombre = 'Juan Pérez';
  ```
- **DELETE**:
  ```sql
  DELETE FROM empleados WHERE nombre = 'Juan Pérez';
  ```

### 3. Sentencias de Control de Datos (DCL)
- **GRANT**:
  ```sql
  GRANT SELECT, INSERT ON mi_base_de_datos.* TO 'usuario'@'localhost';
  ```
- **REVOKE**:
  ```sql
  REVOKE INSERT ON mi_base_de_datos.* FROM 'usuario'@'localhost';
  ```

### 4. Sentencias de Control de Transacciones (TCL)
- **START TRANSACTION**:
  ```sql
  START TRANSACTION;
  ```
- **COMMIT**:
  ```sql
  COMMIT;
  ```
- **ROLLBACK**:
  ```sql
  ROLLBACK;
  ```
- **SAVEPOINT**:
  ```sql
  SAVEPOINT sp1;
  ```
- **RELEASE SAVEPOINT**:
  ```sql
  RELEASE SAVEPOINT sp1;
  ```
- **SET TRANSACTION**:
  ```sql
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
  ```

### 5. Sentencias de Control de Sesiones
- **SET**:
  ```sql
  SET NAMES 'utf8';
  SET AUTOCOMMIT = 0;
  ```

### 6. Sentencias de Administración
- **SHOW**:
  ```sql
  SHOW DATABASES;
  SHOW TABLES;
  ```
- **DESCRIBE** o **DESC**:
  ```sql
  DESCRIBE empleados;
  ```
- **EXPLAIN**:
  ```sql
  EXPLAIN SELECT * FROM empleados;
  ```
- **USE**:
  ```sql
  USE mi_base_de_datos;
  ```
- **ANALYZE TABLE**:
  ```sql
  ANALYZE TABLE empleados;
  ```
- **OPTIMIZE TABLE**:
  ```sql
  OPTIMIZE TABLE empleados;
  ```

### 7. Sentencias de Índices
- **CREATE INDEX**:
  ```sql
  CREATE INDEX idx_nombre ON empleados (nombre);
  ```
- **DROP INDEX**:
  ```sql
  DROP INDEX idx_nombre ON empleados;
  ```

### 8. Sentencias de Procedimientos Almacenados y Funciones
- **CREATE PROCEDURE**:
  ```sql
  CREATE PROCEDURE obtener_empleados()
  BEGIN
    SELECT * FROM empleados;
  END;
  ```
- **CREATE FUNCTION**:
  ```sql
  CREATE FUNCTION obtener_salario_promedio() RETURNS DECIMAL(10,2)
  BEGIN
    DECLARE salario_promedio DECIMAL(10,2);
    SELECT AVG(salario) INTO salario_promedio FROM empleados;
    RETURN salario_promedio;
  END;
  ```
- **DROP PROCEDURE**:
  ```sql
  DROP PROCEDURE obtener_empleados;
  ```
- **DROP FUNCTION**:
  ```sql
  DROP FUNCTION obtener_salario_promedio;
  ```
- **CALL**:
  ```sql
  CALL obtener_empleados();
  ```

### 9. Sentencias de Triggers (Disparadores)
- **CREATE TRIGGER**:
  ```sql
  CREATE TRIGGER actualiza_saldo
  AFTER INSERT ON pagos
  FOR EACH ROW
  BEGIN
    UPDATE cuentas SET saldo = saldo + NEW.monto WHERE id = NEW.cuenta_id;
  END;
  ```
- **DROP TRIGGER**:
  ```sql
  DROP TRIGGER actualiza_saldo;
  ```

### 10. Sentencias de Vistas
- **CREATE VIEW**:
  ```sql
  CREATE VIEW vista_empleados AS
  SELECT nombre, puesto FROM empleados WHERE salario > 30000;
  ```
- **DROP VIEW**:
  ```sql
  DROP VIEW vista_empleados;
  ```

### 11. Sentencias de Usuarios
- **CREATE USER**:
  ```sql
  CREATE USER 'nuevo_usuario'@'localhost' IDENTIFIED BY 'password';
  ```
- **DROP USER**:
  ```sql
  DROP USER 'nuevo_usuario'@'localhost';
  ```
- **ALTER USER**:
  ```sql
  ALTER USER 'nuevo_usuario'@'localhost' IDENTIFIED BY 'nuevo_password';
  ```

### 12. Sentencias de Seguridad
- **RENAME USER**:
  ```sql
  RENAME USER 'usuario'@'localhost' TO 'nuevo_usuario'@'localhost';
  ```
- **SET PASSWORD**:
  ```sql
  SET PASSWORD FOR 'usuario'@'localhost' = PASSWORD('nuevo_password');
  ```

### 13. Sentencias de Logs
- **FLUSH**:
  ```sql
  FLUSH TABLES;
  FLUSH LOGS;
  ```

Estos ejemplos cubren una variedad de operaciones básicas que se pueden realizar en MySQL.
