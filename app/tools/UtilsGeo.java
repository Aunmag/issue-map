package tools;

import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.jetbrains.annotations.Nullable;

public class UtilsGeo {

    @Nullable
    public static Polygon parsePolygon(String polygon) {
        try {
            return (Polygon) new WKTReader().read(polygon);
        } catch (ParseException e) {
            return null;
        }
    }

}
