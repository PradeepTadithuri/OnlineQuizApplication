package onlineQuiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


    //class 
 public final class MyQuiz 
{
   private static final Scanner sc=new Scanner(System.in);
   private static final Map<Integer,Question> quizQuestion= new HashMap<>();
   private static final Map<String,Integer> scores= new HashMap<>();
   //class
    static class Question
    {
    	//private variables
    	private String question;
    	private String[] options;
    	private int correctOption;
    	
    	//parameterized constructor
     	public Question(String question,String[] options,int correctOption)
    	{
     		//assigning values for instance variables
    		this.question=question;
    		this.options=options;
    		this.correctOption=correctOption;
    	}
    }
     //class
    static class User
    {
    	 String userName;
    	int score=0;
    	//parameterized constructor
    	public User(String userName)
    	{
    		//assigning value for instance variables
    		this.userName=userName;
    	}
    }
    //static block
    static 
    {
    	//putting values in HashMap
    	quizQuestion.put(1,new Question("Where is Mumbai?",new String[]{"Ameerpet","vizag","chennai","Maharastra"},4));
    	quizQuestion.put(2,new Question("What is the tallest animal?",new String[]{"lion","rabbit","Girafee","tiger"},3));
    	quizQuestion.put(3,new Question("Who is the main character in one-piece?",new String[]{"Monkey D Luffy","Zoro","Usopp","Nami"},1));
    }
    //main method
    public static void main(String[] args) 
    {
      //do while 
      boolean True=true;
	  do
	  {
		System.out.println("Welcome to MyQuiz");
		System.out.println("Enter your name");
		//user input
		String username=sc.next();
		//User class object
		User user=new User(username);
		//starting quiz
		System.out.println("Quiz is Started");
		
		//outer for loop
		for(int i=1;i<=quizQuestion.size();i++)
		{
			//Question class object
			Question questionNumber=quizQuestion.get(i);
			//printing question
			System.out.println("Q"+i+": "+questionNumber.question);
			//inner loop
			for(int j=0;j<questionNumber.options.length;j++)
			{
				//printing options
				System.out.println((j+1)+". "+questionNumber.options[j]);
			}
			System.out.println("Enter your choice in numbers ");
			//user input
			int choice=sc.nextInt();
			//if else-if
			if(questionNumber.correctOption==choice)
			{
				System.out.println("correct answer,you earned a point");
				 System.out.println();
				 user.score++;
			}
			else if(questionNumber.correctOption!=choice&&choice<=questionNumber.options.length)
			{
				System.out.println("Incorrect answer, correct answer was "+questionNumber.correctOption);
				 System.out.println();
			}
			else
			{
				System.out.println("Invalid Choice");
				 System.out.println();
			}
		}
		System.out.println("MyQuiz completed, Your final score: "+user.score);
		 System.out.println();
		 scores.put(user.userName, user.score);
		 System.out.println("Scores: ");
		 //advanced for loop 
		 for(Map.Entry<String, Integer> entry: scores.entrySet())
		 {
			 //printing user name and score
			 System.out.println("UserName: "+entry.getKey()+"  UserScore: "+entry.getValue());
		 }
		 System.out.println("Do you want to participate again then choose 1 or 2");
		 System.out.println("Enter 1 to participate again or 2 to end");
		 //user input
		 int choose=sc.nextInt();
		 if(choose==1)
		 {
			System.out.println("Start");
		 }
		 else if(choose==2)
		 {
			 System.out.println("Quiz Ended");
			 True=false;
		 }
		 else
		 {
			 System.out.println("Invalid choice");
			 System.out.println("Quiz Ended");
			 True=false;
		 }
		}while(True);
	}
}
