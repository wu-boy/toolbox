package org.wu.toolbox.gis.jts;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.WKTReader;

/**
 * JTS工具类
 * @author wusq
 * @date 2018/06/21
 */
public class JtsUtils {

    private static GeometryFactory geometryFactory = new GeometryFactory();

    /**
     * 创建Point
     * @param lon
     * @param lat
     * @return Point
     */
    public static Point createPoint(double lon, double lat){
        Coordinate c = new Coordinate(lon, lat);
        return geometryFactory.createPoint(c);
    }

    /**
     * 创建Point
     * @param lon
     * @param lat
     * @return Point
     */
    public static Point createPoint(String lon, String lat){
        return createPoint(Double.parseDouble(lon), Double.parseDouble(lat));
    }

    /**
     * 创建LineString
     * @param coordinates 坐标点数组
     * @return LineString
     */
    public static LineString createLineString(Coordinate[] coordinates){
        return geometryFactory.createLineString(coordinates);
    }

    /**
     * 根据wkt创建MultiLineString
     * @param wkt
     * @return MultiLineString
     */
    public static MultiLineString createMultiLineStringByWKT(String wkt){
        WKTReader reader = new WKTReader(geometryFactory);
        MultiLineString result = null;
        try {
            // wkt = "MULTILINESTRING((113.665955 34.866966,113.663994 34.866966))")
            result = (MultiLineString) reader.read(wkt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据multiLineString创建Polygon
     * @param multiLineString
     * @return Polygon
     */
    public static Polygon createPolygon(MultiLineString multiLineString){
        Polygon result = null;
        if(multiLineString != null){
            result = geometryFactory.createPolygon(multiLineString.getCoordinates());
        }
        return result;
    }

    /**
     * 根据wkt创建Polygon
     * @param wkt
     * @return Polygon
     */
    public static Polygon createPolygonByWKT(String wkt){
        WKTReader reader = new WKTReader(geometryFactory);
        Polygon polygon = null;
        try {
            // wkt = "POLYGON((20 10, 30 0, 40 10, 30 20, 20 10))")
            polygon = (Polygon) reader.read(wkt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return polygon;
    }
}
