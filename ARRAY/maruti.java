interface car{
 void startEngine();
 void speed();
}

class toyata implements car{

    public void startEngine(){
        System.out.println("This is startEngine working toyata");
    }

    public void speed(){
        System.out.println("Speed increases toyata");
    }

   
}
class honda extends toyata{

    public void speed(){
        System.out.println("This is honda speed");
    }

    public void speed(int data){
        System.out.println("this is speed honda is: "+ data);
    }

    private int rpm=0;

    public void setRpm(int data){
        this.rpm=data;
    }

    public int getRpm(){
        return rpm;
    }
}


class suzuki extends honda{
    public void speed(){
        System.out.println("This is suzuki speed");
    }

    public void speed(int data){
        System.out.println("this is suzuki speed: "+ data);
    }


    public void speed(int data, int speed){
        System.out.println("speed"+ speed+" and data"+ data);
    }
    private int rpm=0;

    public void setRpm(int data){
        this.rpm=data;
    }

    public int getRpm(){
        return rpm;
    }

}

     class maruti extends suzuki{

        public final void speed(){
            System.out.println("this is final speed of maruti");
        }
    } 

    class bmw extends maruti{
        
            public  void speed(){
                System.out.println("this is speed exception from bmw");
           }
    }

class main{


    public static void main(String[] args){
         car newCar=new toyata();

         newCar.startEngine(); 
         newCar.speed();


         toyata newcar1=new honda();
         newcar1.speed(); 

        //  honda newcar2=new honda();


        // newcar2.speed(20);
        // System.out.println(newcar2.getRpm());

        // newcar2.setRpm(50);

        // System.out.println(newcar2.getRpm());

        honda newcar5=new suzuki();
        newcar5.speed(); 
        //newcar5.speed(10);
        // System.out.println(newcar5.getRpm());
        // newcar5.setRpm(90);
        // System.out.println(newcar5.getRpm());

        suzuki newcar9=new maruti();
        newcar9.speed();


        bmw newbmw=new bmw();
        try{
            newbmw.speed();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("exception resolve");
        }

    }
}



