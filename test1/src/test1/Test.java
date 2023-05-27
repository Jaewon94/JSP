package test1;

import java.util.Random;
import java.util.Arrays;

// 컬렉션을 사용하지 않고 다음 문제를 풀어보세요


public class Test {
	public static void main(String[] args) {
		int size = 10;
		int range = 100;
		int[] arr = new int[size];
		Random ran = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(range);
		}
		System.out.println(Arrays.toString(arr));

		// 1) 배열의 각 요소를 역순으로 출력해보세요
		// 정렬이 아닙니다. 먼저 출력된 값의 역순으로 출력되어야 합니다

		int[] arr1 = new int[arr.length];
		int j = 0;
		for (int i = arr1.length - 1; i >= 0; i--) {
			arr1[j] = arr[i];
			j++;
		}

		System.out.println("1번 문제");
		System.out.println(Arrays.toString(arr1));
		System.out.println();

		// 2) 홀수와 짝수가 몇개인지 각각 파악하여 출력하세요
		int odd = 0;
		int even = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("2번 문제");
		System.out.println("odd : " + odd);
		System.out.println("even : " + even);
		System.out.println();

		// 3) oddArray와 evenArray를 생성하여 각각 홀수와 짝수를 담아서 출력하세요
		int[] oddArray = new int[odd];
		int[] evenArray = new int[even];

		int plus = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] % 2 != 0) {
				oddArray[plus] = arr[k];
				plus++;
			}
		}

		plus = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] % 2 == 0) {
				evenArray[plus] = arr[k];
				plus++;
			}
		}
		System.out.println("3번 문제");
		System.out.println("oddArray : " + Arrays.toString(oddArray));
		System.out.println("evenArray : " + Arrays.toString(evenArray));
		System.out.println();
		
		
		// 4) 배열의 합을 구하여 출력하세요
		
		int oddSum =0;
		int evenSum =0;
		
		for(int i=0; i<oddArray.length;i++) {
			oddSum += oddArray[i];
		}

		for(int i=0; i<evenArray.length;i++) {
			evenSum += evenArray[i];
		}
		
		System.out.println("4번 문제");
		System.out.println(oddSum);
		System.out.println(evenSum);
		System.out.println();
		
		// 5) 배열의 값을 오름차순으로 변환하여 출력하세요
		int[] oddAsc = new int[oddArray.length];
		
		int tmp = oddArray[0];
		for(int i=0; i<oddArray.length-1;i++) {
			for(int k= i+1; k < oddArray.length;k++) {
				if(oddArray[i] > oddArray[k]) {
					tmp = oddArray[i];
					oddArray[i] = oddArray[k];
					oddArray[k] = tmp;
					
				}
				
			}
		}
		tmp = evenArray[0];
		for(int i=0; i<evenArray.length-1;i++) {
			for(int k= i+1; k < evenArray.length;k++) {
				if(evenArray[i] > evenArray[k]) {
					tmp = evenArray[i];
					evenArray[i] = evenArray[k];
					evenArray[k] = tmp;
					
				}
				
			}
		}
		
		System.out.println("6번 문제");
		System.out.println(Arrays.toString(oddArray));
		System.out.println(Arrays.toString(evenArray));
		// 6) 위 내용들을 각각 서로 다른 함수로 작성하여 새로운 배열을 반환하게 작성하세요
		// 만들어진 함수를 각각 호출하여 결과를 확인하세요

	}
}