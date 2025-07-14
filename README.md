# TiendaMascotas

# Grupo 2
    Antonella Pincheira Poblete
    Pablo Vargas Pino
# Casos de uso
![img.png](casos.png)

# UML de parte Lógica
!![img.png](UMLLog.png)

# UML de parte Gráfica
![img.png](UMLGraph.png)

# UML 
![img.png](UML.png)

# Prototipo de interfaz
![img.png](Prototipo.png)

# Vista de Interfaz Gráfica
![img.png](Interfaz_Final.png)

# Patrones utilizados
    Factory: Cada animal tiene un distinto rango de parámetros que simula algunos de la vida real. En la vida real, estos parametros no son decididos por un humano, por lo que es mejor crear una "fábrica" que asigne estos de forma random.
    Este patrón nos ayuda a evitar escribir cuatro parametros distintos en cada creación de mascota, y además simula el poco control que tenemos sobre estos en la naturaleza.
    Una "fabrica" de mascotas tiene la habilidad de crear cualquiera de las mascotas que tenemos, e internamente asigna felicidad, hambre y salud iniciales, junto al color del animal.
    
    Decorator: En la vida real, hay insumos para mascotas que tienen distintos valores nutricionales, medicinales y son más gustados por mascotas.
    Esto lo replicamos con un insumo generico que luego es "decorado" con distintos atributos que mejoran la salud, hambre y felicidad de la mascota que los consume.

    Singleton: Como hay solo un jugador, es lógico crearlo como un singleton, de forma similar, todas las Tiendas son creadas de la misma forma, y se rellenan de forma automática, por lo que no es necesario tener múltiples.
    En la parte gráfica, MiTienda es única (somos sólo un jugador, con una única tienda), TiendaStock también es única, siguiendo la idea se su contraparte Lógica. Las ventana y Sprites también son definidos como singleton, ya que es mejor crear uno y tener acceso a este que accidentalmente crear más.


# Avances 
    Semana 0: Creamos diagramas UML (de clase y uso), y en base a eso contruimos parte de la base, principalmente relacionado a mascotas.
    Creamos un pequeño mockup de cómo nos gustaría hacer la interfaz gráfica, junto a un prototipo en código.
    
    Semana 1: Implementamos nuevos patrones de diseño que ayudan con la creación y complejidad de las mascotas y los elementos con los que se relacionan.
    Se establece un sistema de valor monetario para las mascotas, dependiente de sus atributos.

    Semana 2: Creamos clase jugador que puede comprar insumos, mascotas y habitats. Habitats ahora tienen un tamaño que les permite agregar una cantidad limitada de mascotas.

    Semana 3: Creación de clase Tienda, encargada de la creación de insumos, mascotas y habitats disponibles para jugador. Implementación de escenas y componentes principales de la interfaz gráfica, comprador puede comprar mascotas y el Jugador puede alimentarlas y jugar con ellas.

    Semana 4: Creación de tests unitarios. Se crea TiendaStock, representación gráfica de Tienda. Habitats son ubicados en MiTienda. Mejoras enn otros aspectos de interacción con mascotas.

    
# Características de nuestra tienda de mascotas
    Cada cierto tiempo cosas como felicidad, limpieza del habitad y salud disminuyen. Hambre aumenta.
    Si los atributos están en un rango negativo para la mascota, su precio disminuye.
    Medicinas y alimento pueden ser comprados en distintas cantidades, afectando su precio.
    Jugador puede rechazar la oferta de un comprador de comprar la mascota. 
    Hay distintos tipos de insumo que mejoran ciertas "stats" de la mascota. 
    Al jugar la felicidad aumenta, pero el hambre también.

# Problemas encontrados y decisiones tomadas
    Iniciar la parte gráfica fue un desafío, pues hay muchos componentes que podían desarrollarse de distintas formas. Pero esto se resolvió desglozando y escogiendo algo por donde empezar y concentrándose en eso.
    Cada uno avanzaba por su cuenta, lo que hizo que cada tanto tuvieramos que juntar los avances para poder notar un progreso.
    No siempre comunicamos nuestros avances, así que pasó que nuestro trabajo se intersectaba, pero siempre alguno de los dos era capaz de reconciliar ambos avances.
    Un punto de decisiones importantes fue como queríamos diferenciar a las mascotas, ya sea con sus habitats o qué podían comer, si sería lo mismo para todos. Finalmente decidimos que la comida es universal, pero los habitats personalizados hasta cierto punto.
    Tratamos de mantener el comportamiento de las mascotas cercano a la realidad, como por ejemplo aumentando hambre al jugar y gastar energía, o disminuyendo su salud cuando se pasa mucho tiempo en algún lugar sucio.
    Las deciciones de nuestro cliente son randoms porque el la vida real no tenemos control sobre las decisiones de otros (de forma general).
    
    
# Propuestas de mejoras para futuros proyectos
    Tener claro desde un comienzo las limitaciones de implementaciones gráficas.
    Mantener en escritura las distintas opciones que se pueden tomar durante el proyecto.
    Establecer metas a cumplir de forma periódica, para poder dimensionar qué falta y obligarse a cumplir ciertos avances.
    Tener una división clara de tareas.

# Autocrítica
    Pablo: Siento que durante las dos primeras semanas no avancé como me hubiera gustado.
    Antonella: Personalmente, siento que no siempre manejé mi tiempo de la mejor manera, en vez de tener mini sesiones durante la semana, tendía a hacer avances grandes en una "sentada". También en más de una ocasión me equivoqué manejando git, pero al menos eso me ayudó a ampliar mi conocimiento.

    