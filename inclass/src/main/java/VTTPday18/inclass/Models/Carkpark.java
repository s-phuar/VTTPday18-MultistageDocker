package VTTPday18.inclass.Models;



public class Carkpark {

    private int id;
    private String carpark;
    private String category;
    private String weekdayRate1;
    private String weekdayRate2;
    private String saturdayRate;
    private String sundayHolidayRate;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getCarpark() {return carpark;}
    public void setCarpark(String carpark) {this.carpark = carpark;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getWeekdayRate1() {return weekdayRate1;}
    public void setWeekdayRate1(String weekdayRate1) {this.weekdayRate1 = weekdayRate1;}
    public String getWeekdayRate2() {return weekdayRate2;}
    public void setWeekdayRate2(String weekdayRate2) {this.weekdayRate2 = weekdayRate2;}
    public String getSaturdayRate() {return saturdayRate;}
    public void setSaturdayRate(String saturdayRate) {this.saturdayRate = saturdayRate;}
    public String getSundayHolidayRate() {return sundayHolidayRate;}
    public void setSundayHolidayRate(String sundayHolidayRate) {this.sundayHolidayRate = sundayHolidayRate;}



    public Carkpark(int id, String carpark, String category, String weekdayRate1, String weekdayRate2,
            String saturdayRate, String sundayHolidayRate) {
        this.id = id;
        this.carpark = carpark;
        this.category = category;
        this.weekdayRate1 = weekdayRate1;
        this.weekdayRate2 = weekdayRate2;
        this.saturdayRate = saturdayRate;
        this.sundayHolidayRate = sundayHolidayRate;
    }

    @Override
    public String toString() {
        return "Carkpark [id=" + id + ", carpark=" + carpark + ", category=" + category + ", weekdayRate1="
                + weekdayRate1 + ", weekdayRate2=" + weekdayRate2 + ", saturdayRate=" + saturdayRate
                + ", sundayHolidayRate=" + sundayHolidayRate + "]";
    }

    //JSON to Carpark
    





}
