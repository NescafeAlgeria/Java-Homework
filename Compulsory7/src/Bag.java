import java.util.*;

public class Bag {
    private final List<Tile> tiles = new ArrayList<>();
    private final Random rand = new Random();

    public Bag() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int points = rand.nextInt(10) + 1;
            for (int i = 0; i < 10; i++) {
                tiles.add(new Tile(ch, points));
            }
        }
        Collections.shuffle(tiles);
    }

    public synchronized List<Tile> extractTiles(int count) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < count && !tiles.isEmpty(); i++) {
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }

    public synchronized boolean isEmpty() {
        return tiles.isEmpty();
    }
}
