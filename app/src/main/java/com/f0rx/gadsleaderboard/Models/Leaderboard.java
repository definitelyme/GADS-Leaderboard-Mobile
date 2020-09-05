package com.f0rx.gadsleaderboard.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leaderboard {
    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("hours")
    @Expose
    public int hours;

    @SerializedName("score")
    @Expose
    public int score;

    @SerializedName("country")
    @Expose
    public String country;

    @SerializedName("badgeUrl")
    @Expose
    public String badgeURL;

    public Leaderboard() {
    }

    /**
     * @param country Learner's country name
     * @param hours No of hours
     * @param score Learner's score
     * @param badgeURL Badge URL
     * @param name Learner's name
     */
    public Leaderboard(String name, int hours, int score, String country, String badgeURL) {
        this.setName(name);
        this.setHours(hours);
        this.setScore(score);
        this.setCountry(country);
        this.setBadgeURL(badgeURL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeURL() {
        return badgeURL;
    }

    public void setBadgeURL(String badgeURL) {
        this.badgeURL = badgeURL;
    }
}
