# MongoDB
## Tabla de contenido
1. [¿Que es MongoDB?](#que-es-mongodb)
2. [IdEs](#ides)
3. [Maven](#proyecto-maven)


---
# ¿Que es MongoDB?
MongoDB es un sistema de base de datos NoSQL, orientado a documentos y de código abierto.

MongoDB trabaja con archivos _.json_

# IDEs
Con MongoDB se puede trabajar desde:


![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)&nbsp;
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)&nbsp;


> [!NOTE]
> En VS Code existe una extension, no se que hace o como sirve.


# Proyecto Maven
Para poder trabajar con MongoDB se ha de crear un proyecto maven, para eso hay que poner las _chismas_

```
<!-- ** MONGODB -->
        <!-- https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver -->
        <dependency>
            <groupId>org.mongodb</groupId>
            <artifactId>mongo-java-driver</artifactId>
            <version>3.12.14</version>
        </dependency>
```

Si se quiere hace cosas con JSON es posible que se necesite otras _chismas_ de esas, en particular dos repositorios que estan en el pom.xml de este proyecto (_y aqui abajo ⤵️_).

```
<!--https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.json/json -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20240303</version>
        </dependency>
```

