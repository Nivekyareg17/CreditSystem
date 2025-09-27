package com.sena.introductionMaven.CrediSystem;

public class Deudor {
    private String idNumber;
    private String firstName;
    private String lastName;
    private String idDate;
    private String saldo;

    public Deudor(String idNumber, String firstName, String lastName, String idDate, String saldo) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idDate = idDate;
        this.saldo = saldo;
    }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getIdDate() { return idDate; }
    public void setIdDate(String idDate) { this.idDate = idDate; }

    public String getSaldo() { return saldo; }
    public void setSaldo(String saldo) { this.saldo = saldo; }

    public int getSaldoint(){
        try {
            return Integer.parseInt(saldo);
        }catch (NumberFormatException e){
            return 0;
        }

    }
}
