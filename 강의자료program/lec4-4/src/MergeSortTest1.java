public class MergeSortTest1 {

	public static void main(String[] args) {
		int arrSize = 16 ;    // 배열의 크기
		int arr[] = new int[arrSize+1];
		
		for(int i=1; i<= arrSize; i++) 
			arr[i] = (int)(java.lang.Math.random()*99);  //테스트 데이터 생성

		System.out.println("정렬 전:");
		for(int i=1; i<= arrSize; i++)
			System.out.print("  " + arr[i]);
		System.out.println();
		
		MergeSortClass m = new MergeSortClass(arr, arrSize) ;
		arr = m.MergeSortCall();

		System.out.println("정렬 후:");
		for(int i=1; i<= arrSize; i++)
			System.out.print("  " + arr[i]);			
		

	}

}
