**TASK 1**

Uraditi sve zadatke sa vje�bi!

**TASK 2**

Napisati klasu koja opisuje jednu firmu. Firmu opisuju sljede�i atributi:

1. Ime firme

2. Direktor firme (koristiti Employee klasu)

3. Niz zaposlenih radnika (koristiti Employee klasu)

Bitno je naglasiti da se i direktor smatra **zaposlenikom** u firmi, ali se **ne** nalazi u nizu zaposlenih radnika.


Svaki radnik (Employee) je objekat opisan sljede�im atributima:

1. Ime osobe

2. Spol

3. Mjese�na plata

Svaki atribut je private i svaki ima get metodu. Samo atribut koji opisuje mjese�nu platu ima set

metodu. Pored toga, klasa Employee treba sadr�avati i konstruktor koji inicijalizira sve atribute.



Metode koje se nalaze u klasi koja opisuje firmu su:

1. Metoda koja vra�a koliko je zaposlenih u firmi

2. Metoda koja vra�a koliko ukupno se daje novca za zaposlene, tj. njihove plate

3. Metoda koja odre�uje koliko ima zaposlenih �ena u firmi

4. Metoda koja pove�aje svim zaposlenim platu za datu sumu novca

5. toString metoda koja stavlja ime firme, ime direktora i broj radnika u String