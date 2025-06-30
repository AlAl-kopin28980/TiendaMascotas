package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public final class Sprites {
    private static final ArrayList<String> names = new ArrayList<>();
    private static final ArrayList<BufferedImage> img = new ArrayList<>();

    public static BufferedImage GetSprite(String name){
        int index = names.indexOf(name);

        if (index==-1){
            try {
                BufferedImage image = ImageIO.read(new File("src/main/resources/"+name+".png"));

                names.add(name);
                img.add(image);

                return image;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return img.get(index);
        }

        return null;
    }
}
