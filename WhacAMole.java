import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class WhacAMole {
    private static final int GRID_SIZE = 2;
    private static final int TILE_COUNT = GRID_SIZE * GRID_SIZE;
    private static final int ICON_SIZE = 100;
    private static final int INITIAL_MOLE_DELAY = 1000;
    private static final int INITIAL_PLANT_DELAY = 1500;
    private static final int SCORE_INCREMENT = 10;

    private JFrame frame;
    private JLabel scoreLabel;
    private JPanel boardPanel;
    private JButton[] tiles;
    private JButton resetButton;

    private ImageIcon moleIcon, plantIcon;
    private JButton activeMole, activePlant;

    private int score = 0;
    private Timer moleTimer, plantTimer;
    private Random random = new Random();

    public WhacAMole() {
        setupFrame();
        loadIcons();
        setupBoard();
        setupTimers();
        frame.setVisible(true);
    }

    private void setupFrame() {
        frame = new JFrame("Whac-A-Mole");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(scoreLabel, BorderLayout.NORTH);

        boardPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        frame.add(boardPanel, BorderLayout.CENTER);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 18));
        resetButton.setVisible(false);
        resetButton.addActionListener(e -> resetGame());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resetButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadIcons() {
        try {
            moleIcon = loadScaledIcon("/monty.png");
            plantIcon = loadScaledIcon("/piranha.png");
        } catch (Exception e) {
            System.err.println("Error loading icons: " + e.getMessage());
        }
    }

    private ImageIcon loadScaledIcon(String path) {
        Image image = new ImageIcon(getClass().getResource(path)).getImage();
        return new ImageIcon(image.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH));
    }

    private void setupBoard() {
        tiles = new JButton[TILE_COUNT];
        for (int i = 0; i < TILE_COUNT; i++) {
            JButton tile = new JButton();
            tile.setFocusable(false);
            tile.addActionListener(e -> handleTileClick(tile));
            tiles[i] = tile;
            boardPanel.add(tile);
        }
    }

    private void handleTileClick(JButton tile) {
        if (tile == activeMole) {
            score += SCORE_INCREMENT;
            scoreLabel.setText("Score: " + score);
            activeMole.setIcon(null);
            activeMole = null;
        } else if (tile == activePlant) {
            scoreLabel.setText("Game Over! Final Score: " + score);
            endGame();
        }
    }

    private void setupTimers() {
        moleTimer = new Timer(INITIAL_MOLE_DELAY, e -> spawnMole());
        plantTimer = new Timer(INITIAL_PLANT_DELAY, e -> spawnPlant());
        moleTimer.start();
        plantTimer.start();
    }

    private void spawnMole() {
        if (activeMole != null) activeMole.setIcon(null);
        do {
            activeMole = tiles[random.nextInt(TILE_COUNT)];
        } while (activeMole == activePlant);
        activeMole.setIcon(moleIcon);
    }

    private void spawnPlant() {
        if (activePlant != null) activePlant.setIcon(null);
        do {
            activePlant = tiles[random.nextInt(TILE_COUNT)];
        } while (activePlant == activeMole);
        activePlant.setIcon(plantIcon);
    }

    private void endGame() {
        moleTimer.stop();
        plantTimer.stop();
        for (JButton tile : tiles) {
            tile.setEnabled(false);
        }
        resetButton.setVisible(true);
    }

    private void resetGame() {
        score = 0;
        scoreLabel.setText("Score: 0");
        for (JButton tile : tiles) {
            tile.setEnabled(true);
            tile.setIcon(null);
        }
        activeMole = null;
        activePlant = null;
        moleTimer.restart();
        plantTimer.restart();
        resetButton.setVisible(false);
    }

    public static void main(String[] args) {
        new WhacAMole();
    }
}
