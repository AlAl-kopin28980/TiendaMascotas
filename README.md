# TiendaMascotas

# Grupo 2
    Antonella Pincheira Poblete
    Pablo Vargas Pino
# Casos de uso
![img.png](casos.png)

# UML
![img.png](UML.png)

# Prototipo de interfaz
![img.png](Prototipo.png)

# Patrones utilizados
    Factory: Cada animal tiene un distinto rango de parámetros que simula algunos de la vida real. En la vida real, estos parametros no son decididos por un humano, por lo que es mejor crear una "fábrica" que asigne estos de forma random.
    Este patrón nos ayuda a evitar escribir cuatro parametros distintos en cada creación de mascota, y además simula el poco control que tenemos sobre estos en la naturaleza.
    Una "fabrica" de mascotas tiene la habilidad de crear cualquiera de las mascotas que tenemos, e internamente asigna felicidad, hambre y salud iniciales, junto al color del animal.
    
    Decorator: En la vida real, hay insumos para mascotas que tienen distintos valores nutricionales, medicinales y son más gustados por mascotas.
    Esto lo replicamos con un insumo generico que luego es "decorado" con distintos atributos que mejoran la salud, hambre y felicidad de la mascota que los consume.


# Avances 
    Semana 0: Creamos diagramas UML (de clase y uso), y en base a eso contruimos parte de la base, principalmente relacionado a mascotas.
    Creamos un pequeño mockup de cómo nos gustaría hacer la interfaz gráfica, junto a un prototipo en código.
    
    Semana 1: Implementamos nuevos patrones de diseño que ayudan con la creación y complejidad de las mascotas y los elementos con los que se relacionan.
    Se establece un sistema de valor monetario para las mascotas, dependiente de sus atributos.

    Semana 2: Creamos clase jugador que puede comprar insumos, mascotas y habitats. Habitats ahora tienen un tamaño que les permite agregar una cantidad limitada de mascotas.

# Siguientes pasos
    Seguir con los elementos con los que se relacionan las mascotas y lograr una lógica firme.
    Crear una clase para el jugador y definir sus interacciones y habilidades.
    Seguir evolucionando nuestros prototipos gráficos.

# Ideas para (posible) futura implementación
    Cada cierto tiempo cosas como felicidad, limpieza del habitad y salud disminuyen. Hambre aumenta.
    Al jugar la felicidad aumenta, pero el hambre también.
    Si los atributos están en un rango negativo para la mascota, su precio disminuye.
    Medicinas y alimento pueden ser comprados en distintas cantidades, afectando su precio.
    Habitats tienen un maximo de mascotas, depenidendo de su tamaño (futuramente se puede agregar un sistema de "upgrades").
    Jugador puede rechazar la oferta de un comprador de comprar la mascota. Lo mismo va para el comprador.
    

    