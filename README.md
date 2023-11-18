# tjv_semestralka

## Popis

Aplikace bude pracovat s databází lezeckých cest, lezců a lezeckých center. Uživatel (lezec) bude moci vyhledávat v seznamu lezeckých cest a center a zaznamenávat cesty, které vylezl.

### Dotaz navíc
Možnost doporučení cest pro lezce. Vypíšou se cesty, které lezec ještě nelezl, má na ně dostatečné schopnosti a má budget na návštěvu lezeckého centra, ve kterém se nachází.

### Komplexní business operace
Lezci se přepočítá síla na základě obtížností cest, které vylezl.


## Spuštění


### server
In climbers2 directory:

docker compose up

### client
In client directory:

To run: docker run -it --name client-container --network container:app_container client-image

To stop (open another terminal): docker stop client-container
