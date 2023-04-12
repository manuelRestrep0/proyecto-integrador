# PROYECTO INTEGRADOR MAKAIA 

En este proyecto se hizo uso de todo lo aprendido durante el bootcamp para realizar un sistema de envios que permite automatizar la gestión de envios.
La aplicación tiene como funcionalidades el registro de clientes, de empleados y de envios. Cada registro tiene diferentes validaciones necesarias para añadir 
la información a la base de datos.
Fuera de esto, tambien se puede obtener la información de los clientes y empleados dada su cedula; Para obtener la información de un envio es necesario su numero guia, 
tambien esta la posibilidad de filtrar los envios por su estado actual. 


## Rutas:

POST http://localhost:8080/api/v1/cliente  (Registrar un cliente.)

DELETE http://localhost:8080/api/v1/cliente/{{cedula}}  (Eliminar cliente por su cedula.)

GET http://localhost:8080/api/v1/cliente/{{cedula}}  (Obtener cliente por su cedula.)

POST http://localhost:8080/api/v1/empleado  (Registrar empleado.)

DELETE http://localhost:8080/api/v1/empleados/{{cedula}}  (Eliminar empleado por su cedula.)

GET http://localhost:8080/api/v1/empleados/{{cedula}}  (Obtener empleado por su cedula.)

POST http://localhost:8080/api/v1/envio  (Registrar envio.)

GET http://localhost:8080/api/v1/envio/{{numeroGuia}}  (Obtener un envio por su numero guia.)

PATCH http://localhost:8080/api/v1/envio  (Actualizar el estado de un envio.)

GET http://localhost:8080/api/v1/envio  (Filtrar los envios por su estado de envio.)
