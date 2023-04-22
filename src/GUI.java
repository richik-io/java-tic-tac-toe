import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JButton[][] buttons;
    private Backend backend;

    public GUI() {
        backend = new Backend();
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("-");
                buttons[i][j].addActionListener(this);
                frame.add(buttons[i][j]);
            }
        }
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int row = -1, col = -1;
        // find the button in the array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == button) {
                    row = i;
                    col = j;
                }
            }
        }
        if (row != -1 && col != -1) {
            // try to place the mark on the backend
            if (backend.placeMark(row, col)) {
                // update the button text
                button.setText(Character.toString(backend.getCurrentPlayer()));
                // check for win
                if (backend.checkForWin()) {
                    JOptionPane.showMessageDialog(frame, backend.getCurrentPlayer() + " wins!");
                    System.exit(0);
                } else if (backend.isBoardFull()) {
                    JOptionPane.showMessageDialog(frame, "Board is full!");
                    System.exit(0);
                } else {
                    // switch to the other player
                    backend.changePlayer();
                }
            }
        }
    }
}
