# 📝 Editor de Texto con Patrón Memento y Flyweight

## 📌 Descripción del Proyecto
Este proyecto implementa un **Editor de Texto** que permite al usuario **escribir, cambiar la fuente y el tamaño del texto**, así como **deshacer los cambios realizados**.  
Para lograr esto, se aplican dos patrones de diseño:  
- **Memento**, para guardar y restaurar el estado del texto (contenido, fuente y tamaño).  
- **Flyweight**, para optimizar el uso de objetos de fuente y evitar duplicaciones innecesarias.

---

## 🧠 Patrón Memento

El patrón **Memento** permite **guardar el estado interno de un objeto sin violar su encapsulamiento**, para luego restaurarlo cuando sea necesario.  
En este proyecto, se usa para **implementar la función “Deshacer”** del editor.

### 🔹 Clases involucradas:
- **Texto (Originator):**  
  Contiene el texto, fuente y tamaño actuales.  
  Puede crear un objeto *Memento* que almacene su estado actual y restaurarlo cuando sea necesario.

- **Memento:**  
  Guarda el estado del texto (contenido, fuente y tamaño).  
  Es un objeto inmutable que solo puede ser leído por el `Texto`.

- **Caretaker:**  
  Administra una pila de *Mementos* guardados.  
  Permite **guardar** un nuevo estado o **deshacer** al estado anterior.

---

## 🎨 Patrón Flyweight

El patrón **Flyweight** se usa para **optimizar la gestión de fuentes**, de modo que no se creen objetos repetidos para cada tipo y tamaño de fuente.

### 🔹 Clases involucradas:
- **FuenteFlyweight (Interface):**  
  Define el método `mostrarFuente()` que aplica el estilo a un texto.

- **Fuente (ConcreteFlyweight):**  
  Implementa la interfaz y define una fuente concreta (nombre y tamaño).

- **FuentesFactory (FlyweightFactory):**  
  Administra un mapa de fuentes reutilizables.  
  Si una fuente con el mismo nombre y tamaño ya existe, la reutiliza.

---

## ⚙️ Funcionamiento del Editor

1. El usuario escribe o cambia el texto.  
2. Cada vez que realiza un cambio, puede **guardar el estado actual** mediante el `Caretaker`.  
3. Si desea **deshacer**, el `Caretaker` restaura el *Memento* anterior, recuperando el texto, la fuente y el tamaño previamente guardados.  
4. El uso del patrón **Flyweight** garantiza que las fuentes se reutilicen eficientemente.

---

## 🧩 Diagrama UML

El siguiente diagrama muestra la estructura del sistema y las relaciones entre los patrones implementados:

<img width="1616" height="503" alt="EditorTexto" src="https://github.com/user-attachments/assets/1efa896e-75f3-494d-8a18-189984ed407d" />

---

## 🎥 Presentación del Proyecto

Puedes ver la presentación completa en el siguiente enlace:  
🔗 [Ver presentación en Canva](https://www.canva.com/design/DAG4BDzx5T8/Qi7nZCRWIipIUGgUUW0VHQ/edit?utm_content=DAG4BDzx5T8&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

---

## 👨‍💻 Tecnologías Utilizadas
- Lenguaje: **Java**
- Librerías: **Swing** (para la interfaz gráfica)
- Paradigma: **Programación orientada a objetos**
- Patrones de diseño: **Memento** y **Flyweight**

---
