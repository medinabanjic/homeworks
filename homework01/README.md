**TASK 1**

Napisati klasu koja opisuje jednu **kasu**. Kasa sadr�i:

- Atribut (private) koji opisuje ime, npr. �Moja kasa�, �Za more�, �Crni fond�, itd.

- Atribut (private) koji opisuje trenutnu sumu novca u kasi

- Konstruktor koji inicijalizira ime objekta (ne i trenutnu sumu novca)

- Metoda koja dodaje novac u kasu, npr. dodaj 20 u kasu bi bilo addMoney(20)

- Metoda koja vadi sav novac iz kase, npr. ako je bilo 20 onda �e postati 0

- Metoda koja ispisuje koliko novca ima u kasi na sljede�i na�in:

- Ako nema nikako onda ispisuje �It is empty...�

- Ako ima izme�u 1 i 20 ispisuje �There�s some, but not much.�

- Ako ima izme�u 21 i 100 ispisuje �There�s some.�

- Ako ima 101 ili vi�e onda ispisuje �There�s a lot.�



**TASK 2**

Napisati klasu koja opisuje jednu **�ivotinju**. �ivotinju opisuju sljede�i atributi:

- Atribut (private) koji opisuje ime �ivotinje

- Atribut (private) koji opisuje da li je �ivotinja aktivna danju ili no�u

- Atribut (private) koji opisuje koliko je �ivotinji potrebno vode

- Vrijednost 1 zna�i da je �ivotinja aktivna danju

- Vrijednost 2 zna�i da je �ivotinja aktivna no�u

- Vrijednost 1 zna�i da je �ivotinji potrebno malo vode

- Vrijednost 2 zna�i da je �ivotinji potrebno vi�e vode

- Vrijednost 3 zna�i da je �ivotinji potrebno mnogo vode

- Napraviti konstruktor koji inicijalizira ta tri atributa

Pored toga, sve te �ivotinje dijele isto stani�te. Stani�te je potrebno predstaviti u istoj klasi kao i �ivotinje, 

tj. bez kori�tenja dodatnih klasa. To stani�te je opisano sa dvije varijable:

- Da li je no� ili dan (private) koje je po default-u 1

- Koliko vode ima stani�te (private) koje je po default-u 1

- Vrijednost 1 zna�i da je dan

- Vrijednost 2 zna�i da je no�

- Vrijednost 0 zna�i da stani�te nema vode

- Vrijednost 1 zna�i da stani�te posjeduje malo vode

- Vrijednost 2 zna�i da stani�te posjeduje vi�e vode

- Vrijednost 3 zna�i da stani�te posjeduje mnogo vode

�ivotinje imaju samo jednu metodu:

- Isprintati kakvo je trenutno stanje �ivotinje

- Ukoliko doba dana odgovara �ivotinji i ona ima dovoljno vode za sebe

  Isprintati �It�s fine. The animal is active and has water.�

- Ukoliko doba dana odgovara, ali nema dovoljno vode

  Isprintati �The animal is active, but does not have enough water.�

- Ukoliko doba dana ne odgovara, ali ima dovoljno vode

  Isprintati �The animal is not active, but has enough water.�

- Ukoliko doba dana ne odgovara, niti ima dovoljno vode

  Isprintati �The animal is not active and it does not have enough water.�

Postoji jo� jedna metoda koja uti�e na stani�te:

- Promijeni doba dana

  Ako je bila no� onda postaje dan (nakon poziva metode)

  Ako je bio dan onda postaje no� (nakon poziva metode)

- Promijeni koliko vode trenutno ima (static set metoda)



