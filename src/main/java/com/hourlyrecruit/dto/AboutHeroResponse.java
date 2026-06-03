package com.hourlyrecruit.dto;

import com.hourlyrecruit.model.AboutHeroSection;
import com.hourlyrecruit.model.HeroDashboardCard;

public class AboutHeroResponse {

    private AboutHeroSection heroSection;

    private HeroDashboardCard dashboardCard;

    private long totalDevelopers;

    public AboutHeroSection getHeroSection() {
        return heroSection;
    }

    public void setHeroSection(AboutHeroSection heroSection) {
        this.heroSection = heroSection;
    }

    public HeroDashboardCard getDashboardCard() {
        return dashboardCard;
    }

    public void setDashboardCard(HeroDashboardCard dashboardCard) {
        this.dashboardCard = dashboardCard;
    }

    public long getTotalDevelopers() {
        return totalDevelopers;
    }

    public void setTotalDevelopers(long totalDevelopers) {
        this.totalDevelopers = totalDevelopers;
    }
}