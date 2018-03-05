import java.io.File;
import java.util.Scanner;

public class StandardIODemo {

    public static void main(String args[]) {
    	int num;
    	int arr[], arr2[] ;
    	String str ;
    	
		Scanner sc = new Scanner(System.in);    // 표준 입력 클래스 생성
		
    	System.out.println ("Input number of Integers: ");
       	num = sc.nextInt(); 
       	arr = new int[num] ;
       	
    	System.out.print ("Input " + num + " Integers: ");
    	for (int i=0; i < arr.length; i++)
    		arr[i] = sc.nextInt();

    	System.out.print ("Inputed Integers: ");
    	for (int i=0; i < arr.length; i++)
    		System.out.print(arr[i] + " "); 

    	System.out.println ("Input a Sring : ");
   	    str = sc.next();      // 하나의 문자열 읽기
   	    System.out.println("The inputed string is "+ str);  
   	    
    	try {       // FileNotFoundException  처리를 위해 반드시 사용
    		
    	  File fl = new File("c:/test.txt") ;	
   	      sc = new Scanner(fl);                  // 파일 입출력
          arr2 = new int[6] ;
          for (int i=0; i < arr2.length; i++)
        	  arr2[i] = sc.nextInt();

          System.out.print ("Inputed Integers from a file: ");
      	  for (int i=0; i < arr2.length; i++)
      		  System.out.print(arr2[i] + " ") ;  
    	}
      	catch (Exception e) {
      		System.out.println("Exception: " + e);
        }
   } // end of main ()
}
