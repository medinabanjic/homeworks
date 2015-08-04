**TASK #1 – OBIČNA CHAT APLIKACIJA**

Napraviti mrežnu aplikaciju na kojoj kontinualno mogu komunicirati, tj. chatati, Client i Server. Ovo 

smo već uradili. Server pošalje neku poruku Clientu-u, pa zatim Client Server-u, pa ponovo Server 

šalje Client-u, itd. 

Ovaj put dodati GUI na to tako da postoji polje gdje se unosi poruka, kao i neka komponenta koja 

prikazuje dosadašnje poruke. 

**TASK #2 – DODATNE FUNKCIJE**

Prethodnoj aplikaciji dodati par funkcionalnosti:

- Ukoliko se pošalje poruka tipa /web www.google.ba onda se na drugom računaru treba 

otvoriti browser i pokrenuti navedena stranica (u ovom slučaju google.ba).

- Ukoliko se pošalje poruka tipa /open C:/Program Files/Games/Minesweeper.exe onda

se na drugom računaru treba pokrenuti dati file (u ovom slučaju igra minesweeper). Dati 

direktorij i file se nalaze na drugom računaru, ne na prvom.

- Ukoliko se pošalje poruka tipa /delete C:/Program Files/Games/Minesweeper.exe

onda se treba obrisati dati file sa drugog računara.

- Ukoliko se pošalje poruka tipa /list C:/Documents onda će drugi računar poslati prvom 

spisak direktorija koji se nalaze na datoj lokaciji (u ovom slučaju Documents folder sa C diska). 

Zatim, prvi računar ispisuje sebi taj spisak direktorija.