package com.ck2020.mvpbasic;

import java.util.List;

/**
 * @author chenke
 * @create 2020/7/8
 * @Describe
 */
public class WeatherBean {
    /**
     * yesterday : {"date":"7日星期二","high":"高温 32℃","fx":"东南风","low":"低温 23℃","fl":"<![CDATA[1级]]>","type":"小雨"}
     * city : 成都
     * forecast : [{"date":"8日星期三","high":"高温 32℃","fengli":"<![CDATA[1级]]>","low":"低温 25℃","fengxiang":"东南风","type":"阵雨"},{"date":"9日星期四","high":"高温 32℃","fengli":"<![CDATA[1级]]>","low":"低温 23℃","fengxiang":"西南风","type":"阵雨"},{"date":"10日星期五","high":"高温 29℃","fengli":"<![CDATA[2级]]>","low":"低温 21℃","fengxiang":"西南风","type":"阵雨"},{"date":"11日星期六","high":"高温 27℃","fengli":"<![CDATA[2级]]>","low":"低温 22℃","fengxiang":"东北风","type":"中雨"},{"date":"12日星期天","high":"高温 29℃","fengli":"<![CDATA[2级]]>","low":"低温 23℃","fengxiang":"西南风","type":"阵雨"}]
     * ganmao : 感冒低发期，天气舒适，请注意多吃蔬菜水果，多喝水哦。
     * wendu : 32
     */

    private YesterdayBean yesterday;
    private String city;
    private String ganmao;
    private String wendu;
    private List<ForecastBean> forecast;

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * date : 7日星期二
         * high : 高温 32℃
         * fx : 东南风
         * low : 低温 23℃
         * fl : <![CDATA[1级]]>
         * type : 小雨
         */

        private String date;
        private String high;
        private String fx;
        private String low;
        private String fl;
        private String type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ForecastBean {
        /**
         * date : 8日星期三
         * high : 高温 32℃
         * fengli : <![CDATA[1级]]>
         * low : 低温 25℃
         * fengxiang : 东南风
         * type : 阵雨
         */

        private String date;
        private String high;
        private String fengli;
        private String low;
        private String fengxiang;
        private String type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getFengli() {
            return fengli;
        }

        public void setFengli(String fengli) {
            this.fengli = fengli;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getFengxiang() {
            return fengxiang;
        }

        public void setFengxiang(String fengxiang) {
            this.fengxiang = fengxiang;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
