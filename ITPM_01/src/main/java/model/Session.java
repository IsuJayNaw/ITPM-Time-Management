/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Prabhashwara
 */
public class Session {
    private String lecture;
    private String ssid;
    private String Group;
    private String time;
    private String subGroup;

    public Session(String lecture, String ssid, String Group, String time, String subGroup) {
        this.lecture = lecture;
        this.ssid = ssid;
        this.Group = Group;
        this.time = time;
        this.subGroup = subGroup;
    }

    public Session() {
    }
    

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }
    
}
