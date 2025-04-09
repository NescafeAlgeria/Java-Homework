import java.util.*;
import java.util.concurrent.locks.*;

public class Board {
    private final List<String> submittedWords = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void submitWord(String word, Player player, int points) {
        lock.lock();
        try {
            submittedWords.add(word);
            player.addPoints(points);
            System.out.println(player.getPlayerName() + " submitted word: " + word + " for " + points + " points.");
        } finally {
            lock.unlock();
        }
    }

    public List<String> getSubmittedWords() {
        return submittedWords;
    }
}
