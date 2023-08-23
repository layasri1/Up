package com.example.up;

public class UserDetails {
    private String userId;
    private String days;
    private String startDate;
    private String cropName;
    private String workType;
    private String requirement;
    private String area;
    private String wage;

    public UserDetails() {
        // Default constructor required for Firebase
    }

    public UserDetails(String userId, String days, String startDate, String cropName, String workType, String requirement, String area, String wage) {
        this.userId = userId;
        this.days = days;
        this.startDate = startDate;
        this.cropName = cropName;
        this.workType = workType;
        this.requirement = requirement;
        this.area = area;
        this.wage = wage;
    }

    public String getUserId() {
        return userId;
    }

    public String getDays() {
        return days;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getCropName() {
        return cropName;
    }

    public String getWorkType() {
        return workType;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getArea() {
        return area;
    }

    public String getWage() {
        return wage;
    }
}
