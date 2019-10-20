package org.wu.toolbox.geometry;

/**
 * GIS工具类
 * @author wusq
 * @date 2018/06/21
 */
public class GeometryUtils {

    private static double EARTH_RADIUS = 6378.137;
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过两点经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    /**
     * 通过两点经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(String lat1, String lng1, String lat2, String lng2) {
        return getDistance(Double.parseDouble(lat1), Double.parseDouble(lng1),
                Double.parseDouble(lat2), Double.parseDouble(lng2));
    }


    /**
     * 获取两点之间的曼哈顿距离
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double getManhattanDistance(double lon1, double lat1, double lon2, double lat2){
        return getDistance(lat1, lon1, lat1, lon2) + getDistance(lat1, lon1, lat2, lon1);
    }

    /**
     * 获取两点之间的曼哈顿距离
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double getManhattanDistance(String lon1, String lat1, String lon2, String lat2){
        return getDistance(lat1, lon1, lat1, lon2) + getDistance(lat1, lon1, lat2, lon1);
    }

    /**
     * 求垂足
     * @param x0 经度
     * @param y0 纬度
     * @param x1 线段起点经度
     * @param y1 线段起点纬度
     * @param x2 线段终点经度
     * @param y2 线段终点纬度
     * @return
     */
    public static double[] getFootPoint(double x0, double y0, double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            return new double[]{x1, y0};
        } else if (y1 == y2) {
            return new double[]{x0, y1};
        } else {
            double k = (y2 - y1) / (x2 - x1);
            double nx = (k * k * x1 + k * (y0 - y1) + x0) / (k * k + 1.0D);
            double ny = k * (nx - x1) + y1;
            return new double[]{nx, ny};
        }
    }

    public static void main(String[] args) {
        //System.out.println(getDistance(34.75714, 113.60069,34.7569,113.60191));

        double[] array = getFootPoint(116.307809,39.883985, 116.305389,39.884429, 116.308371,39.885813);
        System.out.println(array[0] + "," + array[1]);
    }
}
