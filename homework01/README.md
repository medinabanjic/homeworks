**TASK 1**

Napisati klasu koja opisuje jednu **kasu**. Kasa sadrži:

- Atribut (private) koji opisuje ime, npr. “Moja kasa”, “Za more”, “Crni fond”, itd.

- Atribut (private) koji opisuje trenutnu sumu novca u kasi

- Konstruktor koji inicijalizira ime objekta (ne i trenutnu sumu novca)

- Metoda koja dodaje novac u kasu, npr. dodaj 20 u kasu bi bilo addMoney(20)

- Metoda koja vadi sav novac iz kase, npr. ako je bilo 20 onda æe postati 0

- Metoda koja ispisuje koliko novca ima u kasi na sljedeæi naèin:

- Ako nema nikako onda ispisuje “It is empty...”

- Ako ima izmeðu 1 i 20 ispisuje “There’s some, but not much.”

- Ako ima izmeðu 21 i 100 ispisuje “There’s some.”

- Ako ima 101 ili više onda ispisuje “There’s a lot.”



**TASK 2**

Napisati klasu koja opisuje jednu **životinju**. Životinju opisuju sljedeæi atributi:

- Atribut (private) koji opisuje ime životinje

- Atribut (private) koji opisuje da li je životinja aktivna danju ili noæu

- Atribut (private) koji opisuje koliko je životinji potrebno vode

- Vrijednost 1 znaèi da je životinja aktivna danju

- Vrijednost 2 znaèi da je životinja aktivna noæu

- Vrijednost 1 znaèi da je životinji potrebno malo vode

- Vrijednost 2 znaèi da je životinji potrebno više vode

- Vrijednost 3 znaèi da je životinji potrebno mnogo vode

- Napraviti konstruktor koji inicijalizira ta tri atributa

Pored toga, sve te životinje dijele isto stanište. Stanište je potrebno predstaviti u istoj klasi kao i životinje, 

tj. bez korištenja dodatnih klasa. To stanište je opisano sa dvije varijable:

- Da li je noæ ili dan (private) koje je po default-u 1

- Koliko vode ima stanište (private) koje je po default-u 1

- Vrijednost 1 znaèi da je dan

- Vrijednost 2 znaèi da je noæ

- Vrijednost 0 znaèi da stanište nema vode

- Vrijednost 1 znaèi da stanište posjeduje malo vode

- Vrijednost 2 znaèi da stanište posjeduje više vode

- Vrijednost 3 znaèi da stanište posjeduje mnogo vode

Životinje imaju samo jednu metodu:

- Isprintati kakvo je trenutno stanje životinje

- Ukoliko doba dana odgovara životinji i ona ima dovoljno vode za sebe

  Isprintati “It’s fine. The animal is active and has water.”

- Ukoliko doba dana odgovara, ali nema dovoljno vode

  Isprintati “The animal is active, but does not have enough water.”

- Ukoliko doba dana ne odgovara, ali ima dovoljno vode

  Isprintati “The animal is not active, but has enough water.”

- Ukoliko doba dana ne odgovara, niti ima dovoljno vode

  Isprintati “The animal is not active and it does not have enough water.”

Postoji još jedna metoda koja utièe na stanište:

- Promijeni doba dana

  Ako je bila noæ onda postaje dan (nakon poziva metode)

  Ako je bio dan onda postaje noæ (nakon poziva metode)

- Promijeni koliko vode trenutno ima (static set metoda)



