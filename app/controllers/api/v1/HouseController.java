package controllers.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import controllers.Controller;
import models.House;
import play.mvc.Result;
import tools.UtilsGeo;

public class HouseController extends Controller {

    /**
     * About 50 meters in Kurgan
     */
    public static final double HOUSE_SEARCH_RANGE = 0.0004;

    public Result detail(Double lat, Double lon) {
        var point = new GeometryFactory().createPoint(new Coordinate(lon, lat));
        var houses = House.FIND.query()
                .setMaxRows(100)
                .where()
                .gt("lat", lat - HOUSE_SEARCH_RANGE)
                .lt("lat", lat + HOUSE_SEARCH_RANGE)
                .gt("lon", lon - HOUSE_SEARCH_RANGE)
                .lt("lon", lon + HOUSE_SEARCH_RANGE)
                .findList();

        for (var house : houses) {
            var polygon = UtilsGeo.parsePolygon(house.polygon);

            if (polygon != null && polygon.contains(point)) {
                return ok(house.toJson(getMessages()));
            }
        }

        return notFound();
    }

    public Result list(Double latMin, Double lonMin, Double latMax, Double lonMax) {
        var data = new ObjectMapper().createArrayNode();

        House.FIND.query()
                .setMaxRows(500)
                .where()
                .gt("lat", latMin)
                .lt("lat", latMax)
                .gt("lon", lonMin)
                .lt("lon", lonMax)
                .findEach(h -> data.add(h.toJson(getMessages())));

        return ok(data);
    }

}
