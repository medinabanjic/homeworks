**TASK #1 – CHECK IF FILE EXISTS**

Napraviti jedan server koji za klijenta provjeraje da li dati file na serverovom računaru postoji. Nije potrebno uraditi GUI za ovaj zadatak. PRIMJER Ukoliko klijent pošalje serveru String „C:/Users/Neko/Desktop/text.txt“ i ukoliko server IMA taj file u tom direktoriju onda server odgovara sa 1, a ukoliko taj file ne postoji onda odgovara sa 0.

**TASK #2 – THREE THREADS OF ONE CLASS**

Napraviti tri Thread-a. Prvi isprinta brojeve od 1 do 10, sa pauzom od 200 [ms] između svakog broja. Drugi isprinta četiri puta „BitCamp“ sa pauzom od 1000 [ms], a treći isprinta pet Random brojeva u rasponu od 1 do 5 sa pauzom od 700 [ms] između svakog. Treći Thread kreće sa radom kada završi drugi, a drugi kreće sa radom kada završi prvi. Kada svi završe zatvara se program. Sva tri Thread-a su bazirani na samo jednoj klasi!

**TASK #3 – INTERRUPTING A THREAD (GUI)**

Napraviti GUI aplikaciju koja ima jedan JLabel i jedan JButton. JLabel je na početku prazan, ali nakon svake sekunde dobija jedno po jedno slovo abecede, pa tako nakon tri sekunde JLabel će imati u sebi „abc“, a nakon pet će imati „abcde“. Klikom na dugme se zaustavi taj proces, ali ne i aplikacija. Koristiti vlastite Thread-ove za ovaj zadatak! Nipošto ne koristiti glavni Thread za JLabel!

**TASK #4 – HTTP IMAGE SERVER**

Napraviti HTTP server kojem klijent daje (upload-uje) sliku u obliku niza byte-ova. Server kod sebe spašava tu sliku i daje joj proizvoljno ime (može biti nasumično, može se generisati na osnovu ip adrese i vremena kada je poslata slika). Nakon uspješnog prebacivanja slike na server, na stranici se pojavljuje link na tu sliku tako da korisnik može otvoriti stranicu gdje se nalazi ta slika. PRIMJER Server prima sliku od klijenta i generiše joj ime 2034317.jpg. Na stranici servera (HTTP protokol) pojavi se novi link koji vodi na stranicu, ukoliko je lokalni računar, localhost/2034317 i tu se pojavi postavljena slika.