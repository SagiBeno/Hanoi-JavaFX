# Hanoi-JavaFX

## Rövid beszámoló a megvalósításról

A feladat megvalósítása során a legnagyobb kihívást a **játékszabályok és a grafikus felület összehangolása** jelentette. Különösen figyelni kellett arra, hogy a felhasználói műveletek (kattintások) mindig a játék aktuális állapotának megfelelően legyenek kezelve, és a grafikus megjelenítés ezt helyesen tükrözze.

A problémát azzal oldottam meg, hogy a programot **modell–nézet–vezérlő (MVC)** szemléletben építettem fel. A játékszabályok és az állapotkezelés a `HanoiModel` osztályban kaptak helyet, míg a grafikus felület kezelése és az eseménykezelés a `HanoiController` feladata lett. Ez a szétválasztás átláthatóbbá tette a kódot, és lehetővé tette a játékmenet logikájának önálló tesztelését.

Tervezési döntés volt a **két kattintásos vezérlés** alkalmazása (forrás rúd kiválasztása, majd cél rúd kiválasztása), mivel ez egyszerűen megvalósítható, és jól illeszkedik a Hanoi tornyai játék működéséhez. A felhasználói élmény javítása érdekében a kiválasztott rúd vizuális kiemelést kap, valamint a lépésszám és a játék állapota szöveges visszajelzés formájában jelenik meg.

A tesztelés során elsősorban a **modell logikájára** helyeztem a hangsúlyt, amelyet egységtesztekkel ellenőriztem. A grafikus felület működését manuálisan teszteltem, mivel a JavaFX felület automatikus tesztelése jelentősen összetettebb lenne.

A feladat megoldása során sikerült elmélyíteni a JavaFX alkalmazások felépítésével, az eseménykezeléssel és a játékszabályok programozásával kapcsolatos ismereteimet.
