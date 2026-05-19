
# Trashome

La aplicación Trashome atenderá el problema del reciclaje en casa en Guadalajara. 
Actualmente existen pocos sistemas efectivos de separación de basura en 
viviendas. La aplicación propone un sistema de recolección por días, registro de 
viviendas, clasificación de residuos, reportes ciudadanos y control de rutas. 
Además, busca concientizar sobre la importancia del reciclaje y el manejo adecuado 
de residuos. 


## Introduccion

Guadalajara intentó implementar varias veces la separación de basura sin éxito. El 
6 de enero de 2009 se anunció que los ciudadanos debían separar la basura en 
orgánica, sanitaria e inorgánica, y la recolección se realizaría en diferentes días 
según el tipo de residuo. 
Sin embargo, el programa tuvo poca participación y problemas operativos. Se 
reportó que la empresa recolectora recogía los residuos mezclados, lo que provocó 
que muchas personas dejaran de separar la basura.  



## Screenshots

![App Screenshot](https://dummyimage.com/468x300?text=App+Screenshot+Here)

## Desarrollo
Con Trashome se prevé mejorar el reciclaje de basura desde casa. La aplicación indicará por medio de un registro previo de vivienda el día en que se llevará a cabo la recolección.

Se propone un sistema básico de tres recipientes:

| Color | Tipo de Basura | Ejemplos |
|-------|-----------------|----------|
| ![#28a745](https://dummyimage.com/15/28a745/ffffff.png) Verde | Orgánica | restos de comida, cáscaras, hojas |
| ![#007bff](https://dummyimage.com/15/007bff/ffffff.png) Azul | Reciclables | plástico, latas, envases, cartón |
| ![#000000](https://dummyimage.com/15/000000/ffffff.png) Negro | No reciclable | pañales, papel higiénico, colillas |



## Empleado

Cada empleado tendrá que registrarse y asignar la unidad con la que trabajará ese día. También podrá levantar reportes de viviendas que no cumplan con la separación correspondiente. 




## Camiones

La aplicación ayudará a organizar mejor el sistema utilizado mediante un registro de camiones y conductores clasificados por rutas. Se tomará en cuenta las placas del camión, código de empleado y ruta


## Rutas
Se implementa un sistema de registro de rutas donde por medio de un mapa podrás ver las calles e ir registrándolas para crear una ruta. Se piden datos como: el nombre de la ruta, código postal, municipio, frecuencia de recolección, tipo de asentamiento y nombre del asentamiento

## Reportes
El sistema de reportes permitirá registrar incidencias relacionadas con la recolección y separación de residuos. Los empleados podrán generar reportes sobre viviendas que no respeten la clasificación de basura, rutas con problemas de recolección o situaciones detectadas durante el recorrido. Cada reporte incluirá información como el tipo de incidencia, ubicación, fecha, descripción y evidencia fotográfica. Esto ayudará a mejorar el control, seguimiento y eficiencia del sistema de recolección.

## Base de datos

Para el desarrollo del proyecto Trashome se diseñó e implementó una base de datos relacional utilizando un modelo entidad-relación elaborado en Draw.io. El diseño inició con la identificación de las entidades principales del sistema: Empleados, Usuarios, Camiones, Rutas, Residuos y Reportes. Posteriormente se definieron sus atributos principales, como identificadores, nombres, correos electrónicos, direcciones, matrículas, tipos de camión, fechas y descripciones de reportes.

 Después del análisis se establecieron las relaciones entre tablas para garantizar la organización de la información. Por ejemplo, los empleados pueden ser asignados a camiones mediante la tabla EmpCam, los camiones se relacionan con rutas por medio de CamRut, y los reportes se vinculan con empleados y usuarios mediante las tablas RepEmp y RepUs.

Se utilizaron claves primarias (PK) para identificar cada registro y claves foráneas (FK) para conectar las tablas entre sí. Esta estructura permite mantener integridad en los datos, evitar duplicidad de información y facilitar consultas dentro del sistema.


## Características del software utilizado

Sistema operativo Windows 11 

Java JDK 21 

JavaFX SDK 21 

Eclipse IDE 

Scene Builder 

MySQL Server 

Git Bash 

GitHub Desktop 


