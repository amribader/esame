# Giochiamo a Wordle

Obiettivo dell'esercizio è progettare e realizzare un insieme di classi Java che permetta di simulare partite di Wordle con differenti strategie di gioco.

I componenti forniti tracciano una strutturazione del programma basata sul pattern *Chain of Responsibility*.

L’anello della catena è una interfaccia che definisce un solo metodo:

```java
public interface Chain {
  String chooseWord(@NotNull Collection<String> candidates,
          @NotNull Answers feedback) throws FailedStrategyError;
}
```

Il parametro `candidates` è una collezione di parole tra cui scegliere quella che verrà usata nel prossimo tentativo del giocatore, il parametro `feedback`  è una struttura iterabile con i risultati precedenti tentativi.
In questo modo è possibile inanellare diverse strategie di gioco.
Se applicando una strategia si riduce il numero di candidati a meno di 10, ne ritorna 1, altrimenti passa la collezione ridotta (ma con più di 10 elementi) al prossimo anello della catena.

L'anello finale dovrebbe essere un NULL Object che ritorna un elemento a caso (per esempio il primo) fra quelli rimasti.

Il **primo anello da implementare** è quindi appunto questo null object. Vanno poi realizzate altre strategie, che potranno 
poi essere utilizzati per ottenere strategie complesse assemblando catene diverse composte da queste 
strategie elementari (**di cui dovete implementarne almeno due**):

- togliere le parole già provate (`DiscardTriedWords`)
- togliere le parole che non rispettano i `RIGHT` marking (`ConsiderRightHints`)
- togliere le parole che non rispettano i `WRONG_PLACE` marking (cioè sopravvivono le 
  parole che non hanno la lettera in quella posizione, ma ce l’hanno in altra posizione) (`ConsiderWrongPlaceHints`)
- togliere le parole che non rispettano i `NOT_FOUND` marking (`ConsiderNotFoundHints`)

Un ulteriore anello (**obbligatorio da implementare**) che è parametrico anche rispetto a quanti turni iniziali si applica è:

- togliere le parole che usano lettere già usate in precedenza (tipico uso nei primi 2 o 3 turni), e sceglierne una. Nei
  turni successivi non fa nulla.

Infine può essere utile implementare anche un anello con cui sia possibile specificare la prima parola da tentare (`SmartChoiceFirstWord`).

**TUTTE LE CLASSI DATE POSSONO ESSERE DA VOI MODIFICATE (CANCELLATE, COMPLETATE) PER ADERIRE A VOSTRE IDEE DI PROGETTAZIONE**

## ALTRE RICHIESTE E DOMANDA

Dentro al codice ci sono dei commenti **TODO** da sistemare opportunamente.

Altri pattern non obbligatori ma che sicuramente potrebbero esser utilmente usati sono: `Strategy` e `Template`.

Domanda: Commentare brevemente i vari pattern usati nella vostra soluzione.

## CONSEGNA

Creare uno file `.zip` il contenuto della directory `src` e il `build.gradle` e l'eventuale file contenente la risposta alla domanda.

Farne l'upload sul sito `https://upload.di.unimi.it`



