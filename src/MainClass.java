public class MainClass {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Backend backend = new Backend();
        while (!backend.isBoardFull() && !backend.checkForWin()) {
            // wait for user input
        }
        if (backend.isBoardFull()) {
            System.out.println("Game over: Board is full.");
        } else {
            System.out.println("Game over: " + backend.getCurrentPlayer() + " wins!");
        }
    }
}
