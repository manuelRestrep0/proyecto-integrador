# PROYECTO INTEGRADOR MAKAIA 

En este proyecto se hizo uso de todo lo aprendido durante el bootcamp para realizar un sistema de envios que permite automatizar la gestión de envios.
La aplicación tiene como funcionalidades el registro de clientes, de empleados y de envios. Cada registro tiene diferentes validaciones necesarias para añadir 
la información a la base de datos.
Fuera de esto, tambien se puede obtener la información de los clientes y empleados dada su cedula; Para obtener la información de un envio es necesario su numero guia, 
tambien esta la posibilidad de filtrar los envios por su estado actual. 

El proyecto esta hecho principalmente con las siguientes tecnologías: 

[![My Skills](https://skills.thijs.gg/icons?i=java,mysql,git)](https://skills.thijs.gg)

Ademas se hizo uso de Spring boot para utilizar diferentes librerias tales como:

<ol>
	<li>Rest-api</li>
	<li>Swagger</li>
	<li>Spring data</li>
	<li>Spring security</li>
	<li>JUnit</li>
	<li>Github Desktop</li>
</ol>


La integración continua se implementó con Github Actions y el despliegue del servicio se hizo por medio de Railway,
se encuentra en el siguiente dominio: 

### https://proyecto-integrador-production-e6df.up.railway.app/swagger-ui/index.html#/



# Endpoints:

### POST http://localhost:8080/api/v1/cliente  (Registrar un cliente.)
  El body de la solicitud recibe los siguientes parametros: 
  ```java {.highlight .highlight-source-java .bg-black}
    {
    "cedula": Integer,
    "nombre": String,
    "apellido": String,
    "celular": String,
    "correo": String,
    "direccionResidencial": String,
    "ciudad": String,
    }
```
  Ejemplo de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
    "cedula":100001,
    "nombre":"Prueba",
    "apellido":"apellido",
    "celular":"3001234567",
    "correo":"example@hotmail.com",
    "direccionResidencial":"donde vives",
    "ciudad":"tu ciudad"
    }
```

### DELETE http://localhost:8080/api/v1/cliente/{{cedula}}  (Eliminar cliente por su cedula.)
  La petición recibe el numero de cedula de un cliente y retorna un String confirmando que la operación
  ocurrió de manera satisfactoria siempre que es estado de la petición sea 200.
```java {.highlight .highlight-source-java .bg-black}
    Se elimino correctamente
```

### GET http://localhost:8080/api/v1/cliente/{{cedula}}  (Obtener cliente por su cedula.)
  La petición recibe el numero de cedula de un cliente y retorna la información asociada a este cliente.
  
  Ejemplo de la respuesta:
  ```java {.highlight .highlight-source-java .bg-black}
     {
      "cedula": 123,
      "nombre": "Juan Manuel",
      "apellido": "Restrepo",
      "celular": "3024261812",
      "correo": "example@hotmail.com",
      "direccionResidencial": "carrera10",
      "ciudad": "medellin"
    }
  ```

### POST http://localhost:8080/api/v1/empleado  (Registrar empleado.)

  El body de la solicitud recibe los siguientes parametros:
    
  ```java {.highlight .highlight-source-java .bg-black}
    {
    "cedula": Integer,
    "nombre": String,
    "apellido": String,
    "celular": String,
    "correo": String,
    "direccionResidencial": String,
    "ciudad": String,
    "antiguedad": 0,
    "rh": "string",
    "tipoEmpleado": "string"
    }
  ```
  
  Ejemplo de la petición:
  
  ```java {.highlight .highlight-source-java .bg-black}
    {
      "cedula":9009,
      "nombre":"Prueba empleado",
      "apellido":"apellido",
      "celular":"celular",
      "correo":"example@hotmail.com",
      "direccionResidencial":"donde vives",
      "ciudad":"tu ciudad",
      "antiguedad":9,
      "rh":"a+",
      "tipoEmpleado":"COORDINADOR"
    }
```

### DELETE http://localhost:8080/api/v1/empleados/{{cedula}}  (Eliminar empleado por su cedula.)
  La petición recibe el numero de cedula de un empleado y retorna un String confirmando que la operación
  ocurrió de manera satisfactoria siempre que es estado de la petición sea 200.
    
  ```java {.highlight .highlight-source-java .bg-black}
      Se elimino correctamente
  ```

### GET http://localhost:8080/api/v1/empleados/{{cedula}}  (Obtener empleado por su cedula.)
  La petición recibe el numero de cedula de un empleado y retorna la información asociada a este empleado.
    
  Ejemplo de la respuesta:
 ```java {.highlight .highlight-source-java .bg-black}
    {
      "cedula":9009,
      "nombre":"Prueba empleado",
      "apellido":"apellido",
      "celular":"celular",
      "correo":"example@hotmail.com",
      "direccionResidencial":"donde vives",
      "ciudad":"tu ciudad",
      "antiguedad":9,
      "rh":"a+",
      "tipoEmpleado":"COORDINADOR"
    }
```

### POST http://localhost:8080/api/v1/envio  (Registrar envio.)

  El body de la solicitud recibe los siguientes parametros:
    
  ```java {.highlight .highlight-source-java .bg-black}
    {
    "cedulaCliente":Integer,
    "ciudadOrigen":String,
    "ciudadDestino":String,
    "direccionDestino":String,
    "nombreRecibe":String,
    "numRecibe":String,
    "valorDeclaradoPaquete":Double,
    "peso":Integer
}
  ```
  Y responde con el numero guia y el estado del envio:
  ```java {.highlight .highlight-source-java .bg-black}
      {
      numeroGuia=Integer
      estadoEnvio=String
      }
 ``` 
  Ejemplo de la petición:
  
  ```java {.highlight .highlight-source-java .bg-black}
    {
    "cedulaCliente":123,
    "ciudadOrigen":"medellin",
    "ciudadDestino":"bogota",
    "direccionDestino":"direccion llegada",
    "nombreRecibe":"nombre quien recibe",
    "numRecibe":"num de quien recibe",
    "valorDeclaradoPaquete":99.0,
    "peso":5
    }
```

```java {.highlight .highlight-source-java .bg-black}
      {
      numeroGuia=4
      estadoEnvio='RECIBIDO'
      }
 ``` 


### GET http://localhost:8080/api/v1/envio/{{numeroGuia}}  (Obtener un envio por su numero guia.)
  La peticion recibe el numero guia y devuelve toda la informacion relacionada al envio
  
  Ejemplo respuesta: 
  
  ```java {.highlight .highlight-source-java .bg-black}
      {
		"cedulaCliente": 123,
		"ciudadOrigen": "medellin",
		"ciudadDestino": "bogota",
		"direccionDestino": "direccion llegada",
		"nombreRecibe": "nombre quien recibe",
		"numRecibe": "num de quien recibe",
		"valorDeclaradoPaquete": 99.0,
		"peso": 5,
		"valorEnvio": 50000.0,
		"estadoEnvio": "RECIBIDO"
	}
 ``` 


### PATCH http://localhost:8080/api/v1/envio?guia&estado&empleado  (Actualizar el estado de un envio.)

  Recibe el numero guia, el estado al que se quiere actualizar el envio y la cedula del empleado 
  para hacer las validaciones y proceder con la actualización del envio.
  
  Los estados a los que se puede actualizar son: EN RUTA y ENTREGADO.
  
  
  El empleado debe ser REPARTIRDOR o COORDINADOR para poder realizar la operación. 
  
  
  Ejemplo de la petición:
  https://proyecto-integrador-production-e6df.up.railway.app/api/v1/envio?guia=4&estado=EN RUTA&empleado=9009
  
  Y la respuesta: 
  
  ```java {.highlight .highlight-source-java .bg-black}
      {
       numeroGuia=4
       ultimoEstado='EN RUTA'
      }
 ``` 

### GET http://localhost:8080/api/v1/envio?estado&cedulaEmpleado  (Filtrar los envios por su estado de envio.)

  Recibe el estado de envio en el que se quiere filtrar los envios de la base de datos y la cedula del empleado.
  
  Si la cedula no se encuentra en la base de datos de empleados, no se realiza la operación.
  
  Ejemplo de respuesta:
  
  ```java {.highlight .highlight-source-java .bg-black}
     [
	{
		"cedulaCliente": 123,
		"ciudadOrigen": "medellin",
		"ciudadDestino": "bogota",
		"direccionDestino": "direccion llegada",
		"nombreRecibe": "nombre quien recibe",
		"numRecibe": "num de quien recibe",
		"valorDeclaradoPaquete": 99.0,
		"peso": 5,
		"valorEnvio": 50000.0,
		"estadoEnvio": "EN RUTA"
	},
	{
		"cedulaCliente": 123,
		"ciudadOrigen": "medellin",
		"ciudadDestino": "bogota",
		"direccionDestino": "direccion llegada",
		"nombreRecibe": "nombre quien recibe",
		"numRecibe": "num de quien recibe",
		"valorDeclaradoPaquete": 99.0,
		"peso": 5,
		"valorEnvio": 50000.0,
		"estadoEnvio": "EN RUTA"
	}
]
 ``` 
 
 # Diagrama UML
 
![image](https://user-images.githubusercontent.com/94997816/232940825-fd70ff82-06a7-4ae4-bbbb-d84e2372ca8a.png)

# Diagrama Entidad-Relación

![image](https://user-images.githubusercontent.com/94997816/232358215-f7fe1ee5-14bf-4204-9057-92b4ded816f6.png)

