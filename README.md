# tjv_semestralka

## Popis

Aplikace pracuje s databází lezeckých cest, lezců a lezeckých center. Uživatel (lezec) může vyhledávat v seznamu lezeckých cest a center a zaznamenávat cesty, které vylezl.

### Dotaz navíc
Možnost doporučení cest pro lezce. Vypíšou se cesty, které lezec ještě nelezl, má na ně dostatečné schopnosti a má budget na návštěvu lezeckého centra, ve kterém se nachází.

### Komplexní business operace
Lezci se přepočítá síla na základě obtížností cest, které vylezl.

## Prerekvizity
* java 17
* gradle
* docker

## Spuštění

### Server
V adresáří climbers2:

* gradle build
* docker compose up

### Klient
V adresáří client:
* gradle build
* docker build -t client-image .
* docker run -it --name client-container --network container:app_container client-image
* To stop (open another terminal): docker rm -f client-container

### Insert script
Po prvotním spuštění aplikace v novém prostředí je databáze prázdná, lze ji ale naplnit vzorovými daty pomocí insert scriptu.

V adresáří climbers2:
* docker compose up
* vložit insertScript.sql do query console a spustit

## Ovládání klienta

* zobrazení příkazů: help
* zobrazení podrobností o příkazu: help [příkaz]

## Zdroje
* Při práci jsem čerpala z ukázkových semestrálek z cvičení a přednášek.
* Ostatní zdroje jsou uvedeny v kódu.
