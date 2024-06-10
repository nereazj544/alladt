El comando `INNER JOIN` se utiliza en SQL para combinar filas de dos o más tablas basadas en una condición relacionada entre ellas. Solo devuelve las filas donde existe una coincidencia en ambas tablas.

Aquí tienes algunos ejemplos de cómo usar `INNER JOIN` en diferentes contextos:

### Ejemplo Básico

Supongamos que tienes dos tablas, `empleados` y `departamentos`:

```sql
CREATE TABLE empleados (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    departamento_id INT,
    PRIMARY KEY (id)
);

CREATE TABLE departamentos (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY (id)
);
```

Para seleccionar los nombres de los empleados junto con los nombres de los departamentos en los que trabajan, puedes usar `INNER JOIN` de la siguiente manera:

```sql
SELECT empleados.nombre AS empleado_nombre, departamentos.nombre AS departamento_nombre
FROM empleados
INNER JOIN departamentos ON empleados.departamento_id = departamentos.id;
```

### Ejemplo con Múltiples Condiciones

Supongamos que también tienes una tabla `proyectos` y deseas combinarla con `empleados` y `departamentos`:

```sql
CREATE TABLE proyectos (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    empleado_id INT,
    PRIMARY KEY (id)
);
```

Para obtener una lista de proyectos con los nombres de los empleados y los nombres de los departamentos, puedes hacer:

```sql
SELECT proyectos.nombre AS proyecto_nombre, empleados.nombre AS empleado_nombre, departamentos.nombre AS departamento_nombre
FROM proyectos
INNER JOIN empleados ON proyectos.empleado_id = empleados.id
INNER JOIN departamentos ON empleados.departamento_id = departamentos.id;
```

### Ejemplo con Alias

Para hacer la consulta más legible, puedes usar alias para las tablas:

```sql
SELECT e.nombre AS empleado_nombre, d.nombre AS departamento_nombre
FROM empleados e
INNER JOIN departamentos d ON e.departamento_id = d.id;
```

### Ejemplo con Filtros Adicionales

Puedes agregar condiciones adicionales en la cláusula `WHERE`:

```sql
SELECT e.nombre AS empleado_nombre, d.nombre AS departamento_nombre
FROM empleados e
INNER JOIN departamentos d ON e.departamento_id = d.id
WHERE d.nombre = 'Recursos Humanos';
```

### Ejemplo con Subconsulta

Puedes usar una subconsulta con `INNER JOIN`:

```sql
SELECT e.nombre AS empleado_nombre, p.nombre AS proyecto_nombre
FROM empleados e
INNER JOIN (
    SELECT * FROM proyectos WHERE nombre LIKE '%Proyecto%'
) p ON e.id = p.empleado_id;
```

### Ejemplo Completo

Combina todo lo anterior para obtener una consulta más compleja:

```sql
SELECT e.nombre AS empleado_nombre, d.nombre AS departamento_nombre, p.nombre AS proyecto_nombre
FROM empleados e
INNER JOIN departamentos d ON e.departamento_id = d.id
INNER JOIN proyectos p ON e.id = p.empleado_id
WHERE d.nombre = 'Desarrollo' AND p.nombre LIKE '%App%';
```

Estos ejemplos ilustran cómo usar `INNER JOIN` para combinar datos de varias tablas en diferentes situaciones, permitiendo realizar consultas más poderosas y complejas en una base de datos MySQL.
