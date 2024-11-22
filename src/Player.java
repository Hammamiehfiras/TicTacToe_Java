public class Player {
    // Fält för att hålla spelarens namn och marker (X eller O)
    private final String name;
    private final char marker;

    // Konstruktor för att skapa en spelare med namn och marker
    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
    }

    // Getter för att få spelarens namn
    public String getName() {
        return name;
    }

    // Getter för att få spelarens marker (X eller O)
    public char getMarker() {
        return marker;
    }
}
