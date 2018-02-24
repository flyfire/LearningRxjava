package com.solarexsoft.learningrxjava;

import java.io.Serializable;
import java.util.List;

/**
 * Created by houruhou on 05/11/2017.
 */

public class IcxstrapSettings {


    /**
     * screenContent : {"plateIndex":0,"sport":true,"heartRate":true}
     * gestureControl : {"raiseToWake":true}
     * autoMeasureHeartRate : {"on":true,"frequency":15}
     * standReminder : {"on":true,"startTime":540,"endTime":600,"days":[1,2,3]}
     * sleepAssistant : {"sleepReminder":true}
     * alarms : [{"on":true,"index":0,"name":"起床","time":420,"lsrOn":true,"lsrSize":5,"days":[1,
     * 2,3,4,5],"lazyMode":true},{"on":true,"index":1,"name":"吃早餐","time":480,"lsrOn":true,
     * "lsrSize":5,"days":[1,2,3,4,5],"lazyMode":true}]
     * messageNotification : {"wechat":true,"qq":true,"sms":true}
     * phoneCall : {"on":true}
     * dndMode : {"on":true}
     */

    private ScreenContentBean screenContent;
    private GestureControlBean gestureControl;
    private AutoMeasureHeartRateBean autoMeasureHeartRate;
    private StandReminderBean standReminder;
    private SleepAssistantBean sleepAssistant;
    private MessageNotificationBean messageNotification;
    private PhoneCallBean phoneCall;
    private DndModeBean dndMode;
    private List<AlarmsBean> alarms;

    public ScreenContentBean getScreenContent() {
        return screenContent;
    }

    public void setScreenContent(ScreenContentBean screenContent) {
        this.screenContent = screenContent;
    }

    public GestureControlBean getGestureControl() {
        return gestureControl;
    }

    public void setGestureControl(GestureControlBean gestureControl) {
        this.gestureControl = gestureControl;
    }

    public AutoMeasureHeartRateBean getAutoMeasureHeartRate() {
        return autoMeasureHeartRate;
    }

    public void setAutoMeasureHeartRate(AutoMeasureHeartRateBean autoMeasureHeartRate) {
        this.autoMeasureHeartRate = autoMeasureHeartRate;
    }

    public StandReminderBean getStandReminder() {
        return standReminder;
    }

    public void setStandReminder(StandReminderBean standReminder) {
        this.standReminder = standReminder;
    }

    public SleepAssistantBean getSleepAssistant() {
        return sleepAssistant;
    }

    public void setSleepAssistant(SleepAssistantBean sleepAssistant) {
        this.sleepAssistant = sleepAssistant;
    }

    public MessageNotificationBean getMessageNotification() {
        return messageNotification;
    }

    public void setMessageNotification(MessageNotificationBean messageNotification) {
        this.messageNotification = messageNotification;
    }

    public PhoneCallBean getPhoneCall() {
        return phoneCall;
    }

    public void setPhoneCall(PhoneCallBean phoneCall) {
        this.phoneCall = phoneCall;
    }

    public DndModeBean getDndMode() {
        return dndMode;
    }

    public void setDndMode(DndModeBean dndMode) {
        this.dndMode = dndMode;
    }

    public List<AlarmsBean> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<AlarmsBean> alarms) {
        this.alarms = alarms;
    }

    public static class ScreenContentBean {
        /**
         * plateIndex : 0
         * sport : true
         * heartRate : true
         */

        private int plateIndex;
        private boolean sport;
        private boolean heartRate;

        public int getPlateIndex() {
            return plateIndex;
        }

        public void setPlateIndex(int plateIndex) {
            this.plateIndex = plateIndex;
        }

        public boolean isSport() {
            return sport;
        }

        public void setSport(boolean sport) {
            this.sport = sport;
        }

        public boolean isHeartRate() {
            return heartRate;
        }

        public void setHeartRate(boolean heartRate) {
            this.heartRate = heartRate;
        }

        public void persist() {
//            ScreenDisplayModel.writePlate(plateIndex);
//            ScreenDisplayModel.writeHeart(heartRate);
//            ScreenDisplayModel.writeSports(sport);
//            ScreenDisplayModel.writeWeather(false);
        }
    }

    public static class GestureControlBean {
        /**
         * raiseToWake : true
         */

        private boolean raiseToWake;

        public boolean isRaiseToWake() {
            return raiseToWake;
        }

        public void setRaiseToWake(boolean raiseToWake) {
            this.raiseToWake = raiseToWake;
        }


    }

    public static class AutoMeasureHeartRateBean {
        /**
         * on : true
         * frequency : 15
         */

        private boolean on;
        private int frequency;

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public void persist() {
//            HeartrateModel.writeAutoMeasureHeart(on);
//            HeartrateModel.writeHeartrateInterval(frequency);
        }
    }

    public static class StandReminderBean {
        /**
         * on : true
         * startTime : 540
         * endTime : 600
         * days : [1,2,3]
         */

        private boolean on;
        private int startTime;
        private int endTime;
        private List<Integer> days;

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public List<Integer> getDays() {
            return days;
        }

        public void setDays(List<Integer> days) {
            this.days = days;
        }

        public void persist() {
//            ExerciseReminderModel.writeExerciseReminder(this);
        }
    }

    public static class SleepAssistantBean {
        /**
         * sleepReminder : true
         */

        private boolean sleepReminder;

        public boolean isSleepReminder() {
            return sleepReminder;
        }

        public void setSleepReminder(boolean sleepReminder) {
            this.sleepReminder = sleepReminder;
        }

        public void persist() {
//            SleepReminderModel.writeSleepReminderOn(sleepReminder);
        }
    }

    public static class MessageNotificationBean {
        /**
         * wechat : true
         * qq : true
         * sms : true
         */

        private boolean wechat;
        private boolean qq;
        private boolean sms;

        public boolean isWechat() {
            return wechat;
        }

        public void setWechat(boolean wechat) {
            this.wechat = wechat;
        }

        public boolean isQq() {
            return qq;
        }

        public void setQq(boolean qq) {
            this.qq = qq;
        }

        public boolean isSms() {
            return sms;
        }

        public void setSms(boolean sms) {
            this.sms = sms;
        }

        public void persist() {
//            MessageReminderModel.writeWechatOn(wechat);
//            MessageReminderModel.writeQQOn(qq);
//            MessageReminderModel.writeSMSOn(sms);
        }
    }

    public static class PhoneCallBean {
        /**
         * on : true
         */

        private boolean on;

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public void persist() {
//            MessageReminderModel.writeCallOn(on);
        }
    }

    public static class DndModeBean {
        /**
         * on : true
         */

        private boolean on;

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public void persist() {
//            NoDistrubModel.writeNoDistrubChecked(on);
        }
    }

    public static class AlarmsBean implements Serializable {
        /**
         * on : true
         * index : 0
         * name : 起床
         * time : 420
         * lsrOn : true
         * lsrSize : 5
         * days : [1,2,3,4,5]
         * lazyMode : true
         */

        private boolean on;
        private int index;
        private String name;
        private int time;
        private boolean lsrOn;
        private int lsrSize;
        private boolean lazyMode;
        private List<Integer> days;

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public boolean isLsrOn() {
            return lsrOn;
        }

        public void setLsrOn(boolean lsrOn) {
            this.lsrOn = lsrOn;
        }

        public int getLsrSize() {
            return lsrSize;
        }

        public void setLsrSize(int lsrSize) {
            this.lsrSize = lsrSize;
        }

        public boolean isLazyMode() {
            return lazyMode;
        }

        public void setLazyMode(boolean lazyMode) {
            this.lazyMode = lazyMode;
        }

        public List<Integer> getDays() {
            return days;
        }

        public void setDays(List<Integer> days) {
            this.days = days;
        }
    }

    public void persist() {
//        this.screenContent.persist();
//        this.gestureControl.persist();
//        this.autoMeasureHeartRate.persist();
//        this.standReminder.persist();
//        this.sleepAssistant.persist();
//        this.messageNotification.persist();
//        this.phoneCall.persist();
//        this.dndMode.persist();
//        AlarmClockModel.writeAlarms(alarms);
    }
}
