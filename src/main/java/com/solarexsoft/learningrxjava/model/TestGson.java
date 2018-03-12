package com.solarexsoft.learningrxjava.model;

import com.google.gson.Gson;

/**
 * Created by houruhou on 24/02/2018.
 */
public class TestGson {
    public static void main(String[] args) {
        IcxstrapSettings settings = new IcxstrapSettings();
        IcxstrapSettings.ScreenContentBean screenContentBean = new IcxstrapSettings.ScreenContentBean();
        screenContentBean.setPlateIndex(1);
        screenContentBean.setHeartRate(false);
        screenContentBean.setSport(false);
        settings.setScreenContent(screenContentBean);
        Gson gson = new Gson();
        String str = gson.toJson(settings);
        System.out.println(str);
        IcxstrapSettings a = gson.fromJson("{}", IcxstrapSettings.class);
        System.out.println(a);
        System.out.println(a.getScreenContent());
        IcxstrapSettings b = gson.fromJson((String) null, IcxstrapSettings.class);
        System.out.println(b);
    }
}
