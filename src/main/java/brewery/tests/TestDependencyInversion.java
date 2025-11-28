package brewery.tests;

import brewery.domain.beer.Beer;
import brewery.domain.beer.Lager;
import brewery.domain.beer.Witbier;
import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.FermentationStrategy;
import brewery.domain.production.fermentation.SlowFermentationStrategy;
import brewery.domain.production.brewing.BrewingUnit;
import brewery.infrastructure.logging.ActivityLogger;
import brewery.patterns.command.CleanCommand;
import brewery.patterns.command.Command;
import brewery.patterns.command.StartBrewingCommand;
import brewery.patterns.observer.Observer;
import brewery.patterns.observer.Subject;

// Tydzień 3, Odwracanie zależności (Dependency Inversion Principle - DIP)
// Moduły wysokopoziomowe nie powinny zależeć od modułów niskopoziomowych.
// Oba powinny zależeć od abstrakcji.
// Struktura:
// 1. Interfejsy: Command, Observer, Subject
// 2. Klasy abstrakcyjne: Beer, BrewingState, FermentationStrategy
// 3. Klasy implementacyjne (po jednej dla każdej abstrakcji)

public class TestDependencyInversion {

    // Implementacja Subject - klasa pomocnicza
    static class SimpleSubject implements Subject {
        private final java.util.List<Observer> observers = new java.util.ArrayList<>();

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }
    }

    // Klasa wysokopoziomowa zarządzająca komendami, nie zależy od konkretnych implementacji
    static class CommandExecutor {
        // zależność od interfejsu, nie od implementacji
        private Command command;

        public CommandExecutor (Command command) {
            this.command = command;
        }

        public void process() {
            System.out.println("Przetwarzam komendę...");
            command.execute();
            System.out.println("Komenda wykonana.");
        }

        public void setCommand(Command newCommand) {
            this.command = newCommand;
        }
    }

    // Klasa wysokopoziomowa zarządzająca obserwatorami, nie zależy od konkretnych implementacji
    static class NotificationManager {
        // Zależność od interfejsu, nie od implementacji
        private Subject subject;

        public NotificationManager(Subject subject) {
            this.subject = subject;
        }

        public void registerObserver(Observer observer) {
            subject.registerObserver(observer);
            System.out.println("Obserwator zarejestrowany");
        }

        public void triggerNotification(String message) {
            subject.notifyObservers(message);
        }
    }

    // Klasa wysokopoziomowa zarządzająca produkcją piwa, nie zależy od konkretnych typów piwa
    static class BeerProductionManager {
        // Zależność od abstrakcji, nie od konkretnej klasy
        private Beer beer;

        public BeerProductionManager(Beer beer) {
            this.beer = beer;
        }

        public void produceBeer() {
            System.out.println("Rozpoczynam produkcję piwa...");
            System.out.println("Nazwa: " + beer.getName());
            System.out.println("Styl: " + beer.getStyle());
            System.out.println("Alkohol: " + beer.getAlcoholContent() + "%");
            System.out.println("Produkcja zakończona");
        }

        public void changeBeerType(Beer newBeer) {
            this.beer = newBeer;
        }
    }

    // Klasa wysokopoziomowa zarządzająca fermentacją, nie zależy od konkretnych strategii
    static class FermentationManager {
        // Zależność od abstrakcji, nie od konkretnej klasy
        private FermentationStrategy strategy;

        public FermentationManager(FermentationStrategy strategy) {
            this.strategy = strategy;
        }

        public void startFermentation() {
            System.out.println("Rozpoczynam fermentację...");
            strategy.ferment();
            System.out.println("Fermentacja zakończona");
        }

        public void changeStrategy(FermentationStrategy newStrategy) {
            this.strategy = newStrategy;
        }
    }

    //DEMO
    public static void main(String[] args) {
        System.out.println("===Demo zasady odwracania zależności (DIP):===");

        //TEST 1: Interejs Command
        System.out.println("Test 1: Zależność od interfejsu Command");
        BrewingUnit brewingUnit = new BrewingUnit();

        // CommandExecutor zależy od interfejsu Command
        Command startCommand = new StartBrewingCommand(brewingUnit);
        CommandExecutor executor = new CommandExecutor(startCommand);
        System.out.println("Komenda 1:");
        executor.process();

        // Zmiana implementacji
        Command cleanCommand = new CleanCommand(brewingUnit);
        executor.setCommand(cleanCommand);
        System.out.println("\nKomenda 2 (zmieniona implementacja):");
        executor.process();
        System.out.println("\nModul wysokopoziomowy CommandExecutor nie zależy od konkretnych klas.\n");


        //TEST 2: Interfejs Observer i Subject
        System.out.println("Test 2: Zależność od interfejsów Observer i Subject");

        //NotificationManager zależy od interfejsu Subject
        Subject subject = new SimpleSubject();
        NotificationManager notificationManager = new NotificationManager(subject);

        // Rejestracja obserwatora
        Observer logger = new ActivityLogger();
        notificationManager.registerObserver(logger);

        System.out.println("Wysyłanie powiadomienia...");
        notificationManager.triggerNotification("Nowa partia piwa została dodana do magazynu.");
        System.out.println("\nModul wysokopoziomowy nie zależy od konkretnych klas.\n");


        //TEST 3: Klasa abstrakcyjna Beer
        System.out.println("Test 3: Zależność od klasy abstrakcyjnej Beer");

        //BeerProductionManager zależy od klasy abstrakcyjnej Beer
        Beer lager = new Lager("Pilsner");
        BeerProductionManager productionManager = new BeerProductionManager(lager);

        System.out.println("Produkcja 1:");
        productionManager.produceBeer();

        // Zmiana typu piwa
        Beer witbier = new Witbier("Perła Witbier");
        productionManager.changeBeerType(witbier);
        System.out.println("\nProdukcja 2 (zmieniony typ piwa):");
        productionManager.produceBeer();
        System.out.println("\nModul wysokopoziomowy BeerProductionManager nie zależy od konkretnych klas.\n");


        //TEST 4: Klasa abstrakcyjna FermentationStrategy
        System.out.println("Test 4: Zależność od klasy abstrakcyjnej FermentationStrategy");

        //FermentationManager zależy od klasy abstrakcyjnej FermentationStrategy
        FermentationStrategy slowStrategy = new SlowFermentationStrategy();
        FermentationManager fermentationManager = new FermentationManager(slowStrategy);

        System.out.println("Fermentacja 1:");
        fermentationManager.startFermentation();

        // Zmiana strategii fermentacji
        FermentationStrategy fastStrategy = new FastFermentationStrategy();
        fermentationManager.changeStrategy(fastStrategy);
        System.out.println("\nFermentacja 2 (zmieniona strategia):");
        fermentationManager.startFermentation();
        System.out.println("\nModul wysokopoziomowy FermentationManager nie zależy od konkretnych klas.\n");


        // PODSUMOWANIE
        System.out.println("Wykorzystane interfejsy i klasy abstrakcyjne:");
        System.out.println("1. Interfejs Command - implementacje: StartBrewingCommand, CleanCommand");
        System.out.println("2. Interfejs Observer - implementacja: Logger");
        System.out.println("3. Interfejs Subject - implementacja: SimpleSubject");
        System.out.println("4. Klasa abstrakcyjna Beer - implementacje: Lager, Witbier");
        System.out.println("5. Klasa abstrakcyjna FermentationStrategy - implementacje: SlowFermentationStrategy, FastFermentationStrategy");
        System.out.println("6. Klasa abstrakcyjna BrewingState - implementacje: IdleState, BrewingState");
        System.out.println("\nPodsumowanie: W powyższych testach moduły wysokopoziomowe (CommandExecutor, NotificationManager, BeerProductionManager, FermentationManager) nie zależały od konkretnych implementacji klas niskopoziomowych.");
        System.out.println("Zamiast tego zależały od abstrakcji (interfejsów i klas abstrakcyjnych), co jest zgodne z zasadą odwracania zależności (DIP).");
    }
}
