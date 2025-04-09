import java.util.*;

public class Player extends Thread {
    private final String name;
    private final Bag bag;
    private final Board board;
    private final Set<String> dictionary;
    private final List<Tile> hand = new ArrayList<>();
    private int score = 0;

    public Player(String name, Bag bag, Board board, Set<String> dictionary) {
        this.name = name;
        this.bag = bag;
        this.board = board;
        this.dictionary = dictionary;
    }

    public String getPlayerName() {
        return name;
    }

    public void addPoints(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    private String tryCreateWord() {
        StringBuilder sb = new StringBuilder();
        for (Tile tile : hand) {
            sb.append(tile.getLetter());
        }

        List<String> permutations = getPermutations(sb.toString());
        for (String perm : permutations) {
            if (dictionary.contains(perm)) {
                return perm;
            }
        }
        return null;
    }

    private List<String> getPermutations(String letters) {
        List<String> result = new ArrayList<>();
        permute("", letters, result);
        return result;
    }

    private void permute(String prefix, String rest, List<String> result) {
        if (!prefix.isEmpty()) result.add(prefix);
        for (int i = 0; i < rest.length(); i++) {
            permute(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1), result);
        }
    }

    @Override
    public void run() {
        while (!bag.isEmpty()) {
            synchronized (bag) {
                hand.addAll(bag.extractTiles(7 - hand.size()));
            }

            if (hand.isEmpty()) break;

            String word = tryCreateWord();
            if (word != null) {
                int points = 0;
                Iterator<Tile> it = hand.iterator();
                for (char ch : word.toCharArray()) {
                    while (it.hasNext()) {
                        Tile tile = it.next();
                        if (tile.getLetter() == ch) {
                            points += tile.getPoints();
                            it.remove();
                            break;
                        }
                    }
                }

                board.submitWord(word, this, points);

                synchronized (bag) {
                    hand.addAll(bag.extractTiles(word.length()));
                }

            } else {
                hand.clear();
                synchronized (bag) {
                    hand.addAll(bag.extractTiles(7));
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(name + " finished with score: " + score);
    }
}
