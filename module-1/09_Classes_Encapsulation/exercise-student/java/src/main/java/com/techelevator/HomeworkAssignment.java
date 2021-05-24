package com.techelevator;

public class HomeworkAssignment {
    //Instance variables -->private members
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    //Accessors
    public int getEarnedMarks(){
        return earnedMarks;
    }
    public int getPossibleMarks(){
        return possibleMarks;
    }
    public String getSubmitterName(){
        return submitterName;
    }
    public String getLetterGrade(){
        String result= "F";
        double score = ((double)earnedMarks/possibleMarks) * 100;
        int wholeScore= (int) score;
        if(wholeScore>=90){result = "A";}
        if(wholeScore>=80&&wholeScore<90){result = "B";}
        if(wholeScore>=70&&wholeScore<80){result = "C";}
        if(wholeScore>=60&&wholeScore<70){result = "D";}
        return result;
    }
    public void setEarnedMarks(int markEarned){
        this.earnedMarks=markEarned;
    }
    //Constructor
    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName=submitterName;

    }

}
