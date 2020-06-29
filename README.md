# Hazza_MVVM (Clean_Architecture)

Este repositorio contiene una aplicación simple para acceder a la API de categorías Hazza y mostrar una lista de categorías de diversos productos, que muestra detalles cuando se tocan los elementos de la lista (una aplicación maestra / detalle típica) que implementa la arquitectura MVVM utilizando Dagger2, Retrofit, RxJava2, LiveData, RoomDatabase, Enlace de datos y Componente de navegación.

## La aplicación tiene los siguientes paquetes:
1. **data**: Contiene todos los componentes de acceso y manipulación de datos.
2. **di**: Dependencia que proporciona clases usando Dagger2.
3. **ui**: Ver clases junto con sus presentadores correspondientes.
4. **utils**: Clases de utilidad.

## Navigation Component Graph
<p align="center">
    <img src="nav_graph.PNG"/>
</p>
<br>

## Guía de arquitectura de la aplicación
<p align="center">
    <img src="architecture.png"/>
</p>
<br>

## Librerias referenciadas:
1. RxJava2: https://github.com/ReactiveX/RxJava
2. RxAndroid: https://github.com/ReactiveX/RxAndroid
3. Dagger2: https://github.com/MindorksOpenSource/android-dagger2-example
4. Retrofit: https://square.github.io/retrofit/
5. Room: https://developer.android.com/topic/libraries/architecture/room.html
6. AndroidDebugDatabase: https://github.com/amitshekhariitbhu/Android-Debug-Database
7. DataBinding: https://developer.android.com/topic/libraries/data-binding
8. Navigation Component: https://developer.android.com/guide/navigation/navigation-getting-started
<br>

```
