- La distinzione tra un viaggio e una prenotazione di un viaggio non mi è risultata chiara, dalla traccia

- L'interpretazione della "data di richiesta" della prenotazione mi è risultata ambigua; significa "data prenotato PER" o "data prenotato IL"?

- Un viaggio non dovrebbe contenere informazione temporale come la data del viaggio. 
  Il QUANDO del viaggio è associato alla prenotazione di quel viaggio, non al viaggio.
  Oppure per viaggio si intendeva in realtà una prenotazione di viaggio? Di nuovo, non c'è stato modo di definire la semantica esatta.

- Da questa ambiguità e dall'impossibilità di poterla chiarire in modo esaustivo, ho definito che un viaggio ha una partenza e una destinazione, 
  e una prenotazione di un viaggio contiene informazioni temporali del viaggio, quindi data per cui è stato prenotato il viaggio ecc.


# Entità (design iniziale)

```

Viaggio
    viaggioId
    dataViaggio
    destinazione
    statoViaggio (enum: in programma, completato)


Dipendente
    dipendenteId
    username
    nome
    cognome
    email
    avatarUrl
    

Prenotazione
    dipendenteId
    viaggioId
    dataPrenotatoPer
    note

```

# Cardinalità di Entità

```

1 dipendente --fa--> N viaggio

1 dipendente --ha--> N prenotazione

1 viaggio --collegato--> 1 dipendente

1 viaggio --ha--> N prenotazione

1 prenotazione --collegato--> 1 viaggio

1 prenotazione --collegato--> 1 dipendente


```






# Logica Query 


## Un dipendente può prenotare un viaggio per una data?

Un dipendente può prenotare un viaggio per una data, solo se quel dipendente
non ha nessuna prenotazione in quella data. 
(quindi indipendentemente da quale viaggio abbia in quella data, se esiste)


### Input/Output 

```

INPUT: dipendente, data per cui prenotare

OUTPUT: si/no

Nell'input, non serve il viaggio, perché nella domanda "il dipendente può prenotare in una data?", 
non è menzionato il viaggio. 

```

### Logica

```

Un dipendente può prenotare un viaggio in una data, solo se quel dipendente
non ha nessuna prenotazione in quella data.

SIGNIFICA

dato un dipendente e una data, non esiste una prenotazione per quel dipendente
 e quella data.

SIGNIFICA

dato un dipendente e una data, il totale delle prenotazioni per quel dipendente
e quella data, è uguale a 0.

SIGNIFICA

il dipendente può prenotare qualsiasi viaggio per quella data.

OVVERO:

nelle prenotazioni:
    cerca il dipendente in input
    AND la data in input
    
    il totale dei risultati di questa espressione è 0:
        SI: il dipendente può prenotare per questa data
        NO: il dipendente non può prenotare per questa data


```

