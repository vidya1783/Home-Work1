package com.techelevator;

public class Airplane {
    //Instance variables -->private members
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats ;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    //Accessors
    public String getPlaneNumber(){return planeNumber;}
    public int getTotalFirstClassSeats (){return totalFirstClassSeats;}
    public int getBookedFirstClassSeats(){return bookedFirstClassSeats;}
    public int getTotalCoachSeats(){return totalCoachSeats;}
    public int getBookedCoachSeats(){return bookedCoachSeats;}
    public int getAvailableFirstClassSeats(){
       int  availableFirstClassSeats = totalFirstClassSeats-bookedFirstClassSeats;
       return availableFirstClassSeats;
    }
    public int getAvailableCoachSeats(){
        int availableCoachSeats= totalCoachSeats-bookedCoachSeats;
               return availableCoachSeats ;
    }
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber=planeNumber;
        this.totalFirstClassSeats=totalFirstClassSeats;
        this.totalCoachSeats=totalCoachSeats;
    }
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if(forFirstClass && totalNumberOfSeats < totalFirstClassSeats) {
            bookedFirstClassSeats += totalNumberOfSeats;
            return totalFirstClassSeats >= bookedFirstClassSeats;
        } else if(!forFirstClass && totalNumberOfSeats < totalCoachSeats) {
            bookedCoachSeats += totalNumberOfSeats;
            return totalCoachSeats >= bookedCoachSeats;
        }
        return false;
    }




    }


