class piggybank
{
    private double savings;
    private final String id;
    
    piggybank(String id)
    {
        this.id = id;
        this.savings = 0;
    }
    public void deposit(double amount)
    {
        savings += amount;
    }
    public void withdraw(double amount)
    {
        if(amount <= savings){
            savings -= amount;
        }
        else{
            System.out.println("withdrawal rejected");
        }
    }
    public double getsavings(){
        return savings;
    }
    public String getid(){
        return id;
    }
}
public class bankpiggy
{
    public static void main(String[] args)
    {
        piggybank pb = new piggybank("PB - 1");
        pb.deposit(100);
        System.out.println("Savings = " + pb.getsavings());

        pb.withdraw(30);
        System.out.println("Savings = " + pb.getsavings());

        pb.withdraw(500);
        System.out.println("Savings = " + pb.getsavings());
    }
}
    