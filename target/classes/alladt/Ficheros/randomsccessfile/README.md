# RandomAccessFile 
Es importante saber que cada tipo de variable ocupa un numero de bytes.

- Long: 8 bytes
- Integer (int): 4 bytes
- Short: 2 bytes
- Byte: 1 byte
- Double: 8 bytes
- Float: 4 bytes
- Boolean: 1 byte
- Char: 2 bytes
- String: 2 bytes por cada caracter.
------
Segun lo que se tenga se suma, si se quiere sacar un nº expecifico se ha de hacer (X - 1) * nº bytes

Por ejemplo:
```
int [] id = {1,2,3,4,5,6,7,8,9} // Int = 4
String[] nombre = {
                "Kilari Miracle",
                "Galio (Tablei) Miracle",
                "Alyssa O’Doherty",
                "Brantley (Bran) Slora",
                "Kirian Slora",
                "Bahir Loughty",
                "Coral Loughty",
                "Gemma Berrycloth",
                "Bosco Berrycloth" }; //String 2 * 10 (sf.setLength(10);)

int[] edad = { 18, 17, 18, 17, 18, 17, 17, 18 }; // Int = 4

/*
    ! Lo que seria:  4 + 4 + 20 = 28 bytes
    Entonces si queremos el 8 haremos: (X - 1) * 28;
    X es 8.
    (8-1)*28 = 196 (Esa es la posicion del id 8)


*/ 

```
