# TEST SPRING BOOT

## Authenticacion

- La aplicacion esta protegida por basic auth, datos de acceso:
    ```
    username: test
    password: test123
  ``` 

## Agregar nueva empresa

para agregar una nueva empresa es necesario autenticar y luego insertar datos, 
a continuacion datos body de entrada.

POST: ${lugar_ejecucion}/empresa/

dato de entrada json:
``` json
    {
      "idEmpresa":1,
      "ruc": "10718476412",
      "razonSocial": "juridica",
      "direccion": "LOS CALLES DE AMAUTA",
      "estado": false
    }
  ``` 

## Obtener los tres ultimos registros

Para obtener los tres ultimos registros primo debe de estar lleno la informacion
si no esta devuelve en blanco o si hay menos de 3 devuelve las que estan registradas

GET: ${lugar_ejecucion}/empresa/last-three 

``` json
    [
    {
        "idEmpresa": 1,
        "ruc": "10718476412",
        "razonSocial": "juridica",
        "direccion": "LOS CALLES DE AMAUTA",
        "estado": false
    },
    {
        "idEmpresa": 2,
        "ruc": "10718476412",
        "razonSocial": "juridica",
        "direccion": "LOS CALLES DE AMAUTA",
        "estado": false
    }
]
  ``` 

## Obtener toda la data

GET: ${lugar_ejecucion}/empresa/all