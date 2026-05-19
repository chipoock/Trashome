
# Trashome

La aplicación Trashome atenderá el problema del reciclaje en casa en Guadalajara. 
Actualmente existen pocos sistemas efectivos de separación de basura en 
viviendas. La aplicación propone un sistema de recolección por días, registro de 
viviendas, clasificación de residuos, reportes ciudadanos y control de rutas. 
Además, busca concientizar sobre la importancia del reciclaje y el manejo adecuado 
de residuos. 

<img width="967" height="602" alt="image" src="https://github.com/user-attachments/assets/409a0723-807b-4adc-a66b-cc6368b74518" />



## Introduccion

Guadalajara intentó implementar varias veces la separación de basura sin éxito. El 
6 de enero de 2009 se anunció que los ciudadanos debían separar la basura en 
orgánica, sanitaria e inorgánica, y la recolección se realizaría en diferentes días 
según el tipo de residuo. 
Sin embargo, el programa tuvo poca participación y problemas operativos. Se 
reportó que la empresa recolectora recogía los residuos mezclados, lo que provocó 
que muchas personas dejaran de separar la basura.  

La intención es romper con el sistema actual y concientizar a las personas sobre la importancia del reciclaje, también se busca agregar un sistema de reportes donde el empleado pueda reportar viviendas que no separaron residuos, y el usuario pueda reportar incumplimientos en días de recolección o mezcla de basura.




## Desarrollo
Con Trashome se prevé mejorar el reciclaje de basura desde casa. La aplicación indicará por medio de un registro previo de vivienda el día en que se llevará a cabo la recolección.

Se propone un sistema básico de tres recipientes:

| Color | Tipo de Basura | Ejemplos |
|-------|-----------------|----------|
| ![#28a745](https://dummyimage.com/15/28a745/ffffff.png) Verde | Orgánica | restos de comida, cáscaras, hojas |
| ![#007bff](https://dummyimage.com/15/007bff/ffffff.png) Azul | Reciclables | plástico, latas, envases, cartón |
| ![#000000](https://dummyimage.com/15/000000/ffffff.png) Negro | No reciclable | pañales, papel higiénico, colillas |



## Calendario
Este Calendario por medio de un registro previo muestra de manera interactiva los días correspondientes al tipo de recolección que se llevara a cabo en tu localidad, tendrás acceso al nombre de los trabajadores, así como la matricula del camión, el nombre de la ruta y un apartado con información para las personas que no están familiarizadas con el reciclaje donde podrán consultar el tipo de residuos que admite cada contenedor.

<img width="1146" height="630" alt="image" src="https://github.com/user-attachments/assets/cbde8f27-8f19-4111-84b5-b4da3e039dd6" />


## Empleado

Cada empleado tendrá que registrarse y asignar la unidad con la que trabajará ese día, podrá levantar reportes de viviendas que no cumplan con la separación correspondiente. 

<img width="1297" height="711" alt="image" src="https://github.com/user-attachments/assets/c6c39d51-f922-4fb4-8dea-1879cf5654a0" />



## Camiones

La aplicación ayudará a organizar mejor el sistema utilizado mediante un registro de camiones y conductores clasificados por rutas. Se tomará en cuenta la Matricula del camión, Código de empleado, Tipo de contenedor (Orgánico, Reciclable, inorgánico) y nombre de la Ruta

<img width="1157" height="637" alt="image" src="https://github.com/user-attachments/assets/97dc86df-00e9-4340-b1f5-c2d2ccbbc92c" />


## Rutas
Se implementa un sistema de registro de rutas donde por medio de un mapa podrás ver las calles e ir registrándolas para crear una ruta. Se piden datos como: el nombre de la ruta, código postal, municipio, frecuencia de recolección y tipo de asentamiento.

<img width="1209" height="665" alt="image" src="https://github.com/user-attachments/assets/2a831091-a9ce-4c11-83c7-33d623211dbe" />


## Reportes
El sistema de reportes permitirá registrar incidencias relacionadas con la recolección y separación de residuos. Los empleados podrán generar reportes sobre viviendas que no respeten la clasificación de basura, rutas con problemas de recolección o situaciones detectadas durante el recorrido. Cada reporte incluirá información como el tipo de incidencia, ubicación, fecha, descripción y evidencia fotográfica. Esto ayudará a mejorar el control, seguimiento y eficiencia del sistema de recolección.

<img width="1919" height="1076" alt="image" src="https://github.com/user-attachments/assets/12c63801-5542-4085-8212-53b4e61e4f64" />


## Base de datos

Para el desarrollo del proyecto Trashome se diseñó e implementó una base de datos relacional utilizando un modelo entidad-relación elaborado en Draw.io. El diseño inició con la identificación de las entidades principales del sistema: Empleados, Usuarios, Camiones, Rutas, Residuos y Reportes. Posteriormente se definieron sus atributos principales, como identificadores, nombres, correos electrónicos, direcciones, matrículas, tipos de camión, fechas y descripciones de reportes.

 Después del análisis se establecieron las relaciones entre tablas para garantizar la organización de la información. Por ejemplo, los empleados pueden ser asignados a camiones mediante la tabla EmpCam, los camiones se relacionan con rutas por medio de CamRut, y los reportes se vinculan con empleados y usuarios mediante las tablas RepEmp y RepUs.

Se utilizaron claves primarias (PK) para identificar cada registro y claves foráneas (FK) para conectar las tablas entre sí. Esta estructura permite mantener integridad en los datos, evitar duplicidad de información y facilitar consultas dentro del sistema.

<img width="1358" height="621" alt="image" src="https://github.com/user-attachments/assets/e4974a0a-6948-4208-a641-3e6ab8ff91bb" />

<img width="1430" height="558" alt="image" src="https://github.com/user-attachments/assets/5ce35a2e-d28b-4445-8a7d-4e4c209d5be9" />

<img width="920" height="536" alt="image" src="https://github.com/user-attachments/assets/e5f1d97f-b03d-481b-8ab5-88ea48d47df8" />


<img width="1270" height="484" alt="image" src="https://github.com/user-attachments/assets/2a1f614e-43c2-4e4f-9afa-1205612ad8df" />





## Características del software utilizado

Sistema operativo Windows 11 

Java JDK 21 

JavaFX SDK 21 

Eclipse IDE 

Scene Builder 

MySQL Server 

Git Bash 

GitHub Desktop 


