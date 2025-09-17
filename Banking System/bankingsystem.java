import java.util.*;
public class bankingsystem 
{
    static class User 
    {
        String username;
        int password;
        int balance;
        User(String username, int password) 
        {
            this.username=username;
            this.password=password;
            this.balance=0;
        }
    }
    static ArrayList<User> users=new ArrayList<>();
    public static void main(String[] args) 
    {
        users.add(new User("Tharnesh", 2003));
        Scanner sc=new Scanner(System.in);
        while(true) 
        {
            System.out.println("\n--- Welcome to Banking System ---");
            System.out.println("1. Login");
            System.out.println("2. Add New User");
            System.out.println("3. Reset Password");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1)
            {
                System.out.print("Enter username: ");
                String uname=sc.nextLine();
                System.out.print("Enter password: ");
                int pwd=sc.nextInt();
                int index=findUser(uname);
                if (index!=-1&&users.get(index).password==pwd) 
                {
                    System.out.println("Login successful");
                    userMenu(index, sc);
                } 
                else if(index==-1)
                {
                    System.out.println("User Not Found");
                }
                else 
                {
                    System.out.println("Invalid username or password");
                }
            } 
            else if(choice==2) 
            {
                System.out.print("Enter new username: ");
                String newUser=sc.nextLine();
                if(findUser(newUser)!=-1) 
                {
                    System.out.println("Username already exists");
                } 
                else 
                {
                    System.out.print("Enter password: ");
                    int newPwd=sc.nextInt();
                    users.add(new User(newUser, newPwd));
                    System.out.println("User added successfully");
                }
            } 
            else if(choice==3) 
            {
                System.out.print("Enter username: ");
                String uname=sc.nextLine();
                int index=findUser(uname);
                if(index!=-1) 
                {
                    System.out.print("Enter old password: ");
                    int oldPwd=sc.nextInt();
                    if(users.get(index).password == oldPwd) 
                    {
                        System.out.print("Enter new password: ");
                        int newPwd = sc.nextInt();
                        users.get(index).password = newPwd;
                        System.out.println("Password reset successfully");
                    } 
                    else 
                    {
                        System.out.println("Incorrect old password");
                    }
                } 
                else 
                {
                    System.out.println("Username not found");
                }
            } 
            else if(choice==4) 
            {
                System.out.println("Thank you for using the banking system");
                break;
            } 
            else 
            {
                System.out.println("Invalid option");
            }
        }
        sc.close();
    }
    static int findUser(String uname) 
    {
        for(int i=0;i<users.size();i++) 
        {
            if(users.get(i).username.equals(uname)) 
            {
                return i;
            }
        }
        return -1;
    }
    static void userMenu(int index, Scanner sc) 
    {
        while(true) 
        {
            User user=users.get(index);
            System.out.println("\n--- Welcome, " + user.username + " ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            int opt=sc.nextInt();
            if(opt==1) 
            {
                System.out.println("Your balance is: " + user.balance);
            } 
            else if(opt==2) 
            {
                System.out.print("Enter amount to deposit: ");
                int amount=sc.nextInt();
                user.balance+=amount;
                System.out.println("Deposited successfully. Balance: " + user.balance);
            } 
            else if(opt==3) 
            {
                System.out.print("Enter amount to withdraw: ");
                int amount=sc.nextInt();
                if (amount>user.balance) 
                {
                    System.out.println("Insufficient funds");
                } 
                else 
                {
                    user.balance-=amount;
                    System.out.println("Withdrawn successfully. Balance: " + user.balance);
                }
            } 
            else if(opt==4) 
            {
                System.out.println("Logged out");
                break;
            } 
            else 
            {
                System.out.println("Invalid option");
            }
        }
    }
}
