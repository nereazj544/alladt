Examenes son la semana del 10 al 14
----------------------------------------------------------------------------------------------------------------
# INSTRUCIONES
Para realizar este tipo de programas se ha de crear las instruciones dentro del MySql. En Java hay que invocar a la intefaz (clase): CallableStatament.

Hay que tener encuenta de que se pueden definirse con parametros de:
- Entrada = IN //Por defecto se pone esta si no sé expecifica nada.
- Salida = OUT
- E/S = INOUT

# PROCEDIMIENTOS
Realizan una tarea especifica y no necesariamente tienen que devolver un valor.

Ejemplo de procedimiento:
DELIMITER $$ 
CREATE PROCEDURE subida_sal(d INT, subida INT)
BEGIN UPDATE empleados SET salario = salario + subida WHERE dept_no = d;
COMMIT; 

END$$ DELIMITER ;

Despues dentro del programa, se ha de llamar a la clase, hay que tener en cuenta que hay dos veriones:
- { Call [nombre del procedimiento] }
- { Call [nombre del procedimiento]  (?, ?...)} //Para añadir algun paremetro.


# FUNCIONES
Devuelven un valor (y su nombre)

Ejemplo de Funcion. (En este ejemplo se usan los cursores inplicitos).
> [!IMPORTANT]
> De esta forma es para usar en ORACLE



> [!IMPORTANT]
> De esta forma es para usar en MySql
> Hay que especificar si la función es DETERMINISTIC, NO SQL o READS SQL DATA en su declaración

delimiter $$
CREATE FUNCTION nombre_dep (d int)
RETURNS VARCHAR(15)
DETERMINISTIC
BEGIN
  DECLARE nom VARCHAR(15);
  SET nom = 'NO EXISTE';
  SELECT dnombre INTO nom FROM DEPARTAMENTOS WHERE dept_no = d;
  return nom;
END;


Hay que tener encuenta de que la diferencia principal es de el ? que se coloca al principio. Despues dentro del programa, se ha de llamar a la clase, hay que tener en cuenta que hay dos veriones:
- { ? = Call [nombre del procedimiento] }
- { ? = Call [nombre del procedimiento]  (?, ?...)} //Para añadir algun paremetro.