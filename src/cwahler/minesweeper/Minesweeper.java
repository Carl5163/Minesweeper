package cwahler.minesweeper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Minesweeper extends JFrame implements ActionListener{

    private int xSize = 31;
    private int ySize = 16;
    private int numMines = 40;
    private int[][] grid;

    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> new Minesweeper() );
    }

    public Minesweeper() {
        createGUI();
    }

    private void createGUI() {

        setSize(changeGameSize(xSize, ySize));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper: A Deep Learning Project");
        //setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("File");
        m.setMnemonic(KeyEvent.VK_F);

        JMenuItem mi;
        mi = new JMenuItem("New Game");
        mi.setActionCommand("NEW");
        mi.setMnemonic(KeyEvent.VK_N);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        mi.addActionListener(this);
        m.add(mi);
        m.addSeparator();
        mi = new JMenuItem("Options");
        mi.setActionCommand("OPTION");
        mi.setMnemonic(KeyEvent.VK_O);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        mi.addActionListener(this);
        m.add(mi);
        mi = new JMenuItem("Restart");
        mi.setActionCommand("RESTART");
        mi.setMnemonic(KeyEvent.VK_R);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        mi.addActionListener(this);
        mi.getAccelerator();
        m.add(mi);
        m.addSeparator();
        mi = new JMenuItem("Quit");
        mi.setActionCommand("QUIT");
        mi.setMnemonic(KeyEvent.VK_Q);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        mi.addActionListener(this);
        m.add(mi);

        mb.add(m);
        setJMenuBar(mb);

        JPanel panelc = new JPanel();
        panelc.setLayout(new GridLayout(xSize, ySize));
        JButton b;

        for(int r = 0; r < ySize; r++)
        {
            for(int c = 0; c < xSize; c++)
            {
                System.out.printf("i:%d, j:%d\n", r,c);
                b = new MineButton(r, c);
                b.addActionListener(this);
                panelc.add(b);
            }
        }
        repaint();
        add(panelc);

        setVisible(true);
    }

    public Dimension changeGameSize(int gameX, int gameY) {
        return new Dimension(17*gameX,19*gameY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if(ac.equals("QUIT")) {
            dispose();
        } else if(ac.contains(",")) {
            MineButton b = ((MineButton)e.getSource());
            if(b.getState() == MineButton.PREGAME) {
                startGame();
            }
        }
    }

    private void startGame() {
        for(int y = 0; y < ySize; y++) {
            for(int x = 0; x < xSize; x++) {

            }
        }
    }
}
