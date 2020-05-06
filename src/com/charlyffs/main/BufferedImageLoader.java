package com.charlyffs.main;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class BufferedImageLoader {
    
    /**
     * Looks for image in res folder.
     * @param path Path to image.
     * @return Image as BufferedImage to be drawn or processed.
     */
    BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
