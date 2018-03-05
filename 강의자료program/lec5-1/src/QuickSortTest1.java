
public class QuickSortTest1 {

	public static void main(String[] args) {
		int arrSize = 16 ;    // 배열의 크기
		int arr[] = new int[arrSize+2];
		
		for(int i=1; i<= arrSize; i++) 
			arr[i] = (int)(java.lang.Math.random()*99);  //테스트 데이터 생성

		System.out.println("정렬 전:");
		for(int i=1; i<= arrSize; i++)
			System.out.print("  " + arr[i]);   // 정렬 전의 데이터 값들
		System.out.println(); 
		
		QuickSortClass1 m = new QuickSortClass1(arr, arrSize) ; // 합병정렬 클래스를 생성
		arr = m.QuickSortCall();    // 합병정렬을 호출

		System.out.println("정렬 후:");
		for(int i=1; i<= arrSize; i++)
			System.out.print("  " + arr[i]);	// 정렬 후의 데이터 값들	 	
	}
}
