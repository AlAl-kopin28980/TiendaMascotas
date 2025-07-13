package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Clase que permite cargar imagenes de resources una sola vez y luego buscarlas
 */
public final class Sprites {
    private static final ArrayList<String> names = new ArrayList<>();
    private static final ArrayList<BufferedImage> img = new ArrayList<>();

    /**
     * Devuelve una Imagen png
     * @param name Nombre de la imagen
     * @return Imagen
     */
    public static BufferedImage GetSprite(String name){
        return GetSprite(name,"png");
    }

    /**
     * Devuelve una Imagen de cualquier formato
     * @param name Nombre de la imagen
     * @param extension Extension del archivo
     * @return Imagen
     */
    public static BufferedImage GetSprite(String name, String extension){
        int index = names.indexOf(name);

        if (index==-1){
            try {
                BufferedImage image = ImageIO.read(new File("src/main/resources/"+name+"."+extension));

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
