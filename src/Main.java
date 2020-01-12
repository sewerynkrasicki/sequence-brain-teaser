import logic.Game;

public class Main {
    public static void main(String[] args) {
        int[] northLine = {2, 4, 2, 3, 1, 4, 7, 4, 2, 2};
        int[] southLine = {7, 2, 5, 4, 4, 3, 1, 1, 4, 5};
        int[] westLine = {3, 2, 3, 1, 8, 5, 3, 5, 1, 4};
        int[] eastLine = {5, 3, 4, 4, 1, 3, 5, 3, 3, 2};

        Game game = new Game(10, northLine, southLine, eastLine, westLine);
    }
}