package cwahler.minesweeper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MineButton extends JButton {

    public static int PREGAME = -1;
    public static int HIDDEN = 0;

    private BufferedImage spriteSheet;
    private BufferedImage[] sprites;
    private int state = PREGAME;
    private int x;
    private int y;

    public MineButton(int x, int y) {
        super("");
        this.x = x;
        this.y = y;

        try {
            spriteSheet = ImageIO.read(new File("res\\sprites.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        sprites = new BufferedImage[16];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 8; i++) {
                sprites[j * 8 + i] = spriteSheet.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
        setIcon(new ImageIcon(sprites[0]));
        setPressedIcon(new ImageIcon(sprites[1]));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setActionCommand(x + "," + y);
    }

    public int getState() {
        return state;
    }

    public int[] getPosition() {
        int[] ret = {x,y};
        return ret;
    }
}
