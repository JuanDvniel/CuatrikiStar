package config;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontConfig {

    private Font fuentePersonalizada;

    public FontConfig() {
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/Kettler-Bold Regular.otf");
            if (is == null) {
                throw new IOException("No se encontró la fuente en la ruta especificada.");
            }
            this.fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 25);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            this.fuentePersonalizada = new Font("Arial", Font.PLAIN, 25);
        }
    }

    public Font getFuentePersonalizada() {
        return fuentePersonalizada;
    }
}
