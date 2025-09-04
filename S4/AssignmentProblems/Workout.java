class Workout {
    String activityName; int durationInMinutes,caloriesBurned;
    Workout(){this("Walking",30,150);}
    Workout(String a){this(a,30,150);}
    Workout(String a,int d){this(a,d,d*5);}
    Workout(String a,int d,int c){activityName=a;durationInMinutes=d;caloriesBurned=c;}
    void displayWorkout(){System.out.println(activityName+" | "+durationInMinutes+" mins | "+caloriesBurned+" cal");}
    public static void main(String[] args){
        Workout w1=new Workout();
        Workout w2=new Workout("Running");
        Workout w3=new Workout("Cycling",60);
        w1.displayWorkout();w2.displayWorkout();w3.displayWorkout();
    }
}
