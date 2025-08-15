Calculadora de Conversiones

Una aplicación de escritorio desarrollada en **JavaFX** que permite convertir unidades entre diferentes sistemas. 
Ideal para estudiantes, profesionales y cualquier persona que necesite realizar conversiones rápidas y precisas.
__________________________________________________________________________________________________________________

>Características<

- Conversión entre unidades de medida (ej. longitud, peso, temperatura)
- Interfaz gráfica amigable creada con **Scene Builder**
- Entrada de datos mediante campo de texto
- Selección de unidad origen y destino con ComboBox
- Historial de conversiones en tiempo real
- Botón para limpiar campos y reiniciar la interfaz
__________________________________________________________________________________________________________________

 >Requisitos<

- Java 17 o superior
- JavaFX SDK (versión 17.0.6 recomendada)
- IntelliJ IDEA (u otro IDE compatible)
- Scene Builder (opcional para editar la interfaz)
__________________________________________________________________________________________________________________

>Estructura del Proyecto<

Calculadora_Con/
├── src/
│   ├── calculadora/
│   │   ├── Main.java
│   │   ├── Controller.java
│   │   ├── ConversionUtils.java
│   │   └── ConversionType.java
├── resources/
│   └── calculadora/
│       └── calculadora.fxml
__________________________________________________________________________________________________________________

  ¿Cómo ejecutar?

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/Calc_conversiones.git
2. Abre el proyecto en IntelliJ IDEA

3.Configurar JavaFX:
Ve a Archivo > Estructura del proyecto > Bibliotecas
Añade el SDK de JavaFX
En Configuración de ejecución , agrega opciones de VM :
--module-path /ruta/a/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
4. EjecutaHelloApplication.java
__________________________________________________________________________________________________________________

> Instrucciones de uso<
1. Ingresa un valor en el campo de texto
2. Selecciona la unidad de origen y la unidad de destino
3. Haz clic en Convertir
4. El resultado aparecerá debajo y se agregará al historial .
5. Para limpiar los campos, haz clic en Limpiar
__________________________________________________________________________________________________________________

>Personalización<
Puedes modificar el archivo hello-view.fxml con Scene Builder para cambiar estilos, agregar nuevas unidades o mejorar la interfaz visual.
__________________________________________________________________________________________________________________

>Créditos<
Desarrollado por Aby Lara como parte de su aprendizaje en JavaFX 💙 Con apoyo deConstructor de escenas yOpenJFX
__________________________________________________________________________________________________________________

>Licencia<
Este proyecto está bajo la licencia MIT. Puedes usarlo, modificarlo y compartirlo libremente.
__________________________________________________________________________________________________________________
