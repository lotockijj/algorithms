package army;

public class Car {
    private String name;
    private String year;
    private String passport;
    private String vehicleNumber;
    private String registrationNumber;

    public Car(String name, String year, String passport, String vehicleNumber, String registrationNumber) {
        this.name = name;
        this.year = year;
        this.passport = passport;
        this.vehicleNumber = vehicleNumber;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return name + ", " + year + ", " + passport + ", шасі: " + vehicleNumber + ", номер: " + registrationNumber + " .";
    }
}
