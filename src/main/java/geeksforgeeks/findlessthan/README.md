# 리스트에서 특정 숫자보다 작은 숫자의 갯수를 구하기
# 문제
오름차순으로 정렬되어 있는 숫자로만 구성된 리스트가 있다. 이 리스트에서 숫자 i 보다 작은 요소들의 갯수를 구해보자.  

# 참고자료
 - [Geeks For Geeks](https://www.geeksforgeeks.org/count-smaller-equal-elements-sorted-array/)
    - 완벽한 해결법은 아니다. 효율적인 계산은 아니여서 입맛대로 어느정도는 손을 봤다.
 - [이진탐색이란?](https://cjh5414.github.io/binary-search/)
    - 대소 구분을 하면서 원하는 요소가 어디에 있는지 또는 어디까지가 더 작은 소그룹인지 구하려 할 때 사용
 - **나누기 2 비트 연산**  
    - 나누기 수행시 `숫자A >> 2` 를 수행하면 나누기 연산을 수행한다.
    - 효율성측면에서는 모르겠고... 나중에 쓸모가 있을 것 같기는 하다. 

# 포인트
## 이진탐색
### 이진탐색 개념
정렬된 배열을 대상으로 원하는 대상을 찾을 때 원하는 수 `a[i]`보다 작은 그룹, 큰 그룹으로 나누어 해당되는 그룹을 구하고 또 그 그룹을 줄여나가는 과정을 여러번 거치게 된다.  
특정 수를 2로 여러번 나누는 연산과 같다고 생각하면 될 것 같다. 학부에서 배우던 공식을 사용한 개념 정리가 필요할지는 잘 모르겠다. 아직은 필요를 못 느껴서 정리를 하지 않았다.  
  
### 이진탐색 탈출 조건
이진탐색에서의 키 포인트는 여러가지가 있겠지만 그중 하나는`left < right` 이다. 아래와 같이 `left < right` 일 동안만 이진탐색을 수행한다. 원하는 수를 찾지 못했더라도 right 또는 left 는 아래의 연산을 계속해서 수행하므로 그 다음 연산에서 `left < right`에서 걸리게 된다.
- `left = mid +1;` 
- `right = mid -1;`
 
```java
public class SomeClass {
    public int something(int [] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        int result = 0;

        while (left < right){
            mid = (left + right)/2;
            int value = arr[mid];

            if (value < target){
            	left = mid + 1;
            }
            else if (value > target){
                right = mid - 1;            	
            }
            else {
            	result = mid;
                break;
            }
        }
    
        return result;
    }
}
```

# 문제를 더 어렵게 만들어보면 (지저분한 케이스들 만들어보기)
## 정렬되지 않은 숫자의 리스트에서 숫자 i 보다 작은 요소들의 갯수를 구할 경우
 - 퀵소트를 사용하여 정렬 후 
 - 이진탐색을 수행

# 테스트 케이스들
## 가능한 배열들 (계속 추가. 그림 그려가면서... ㅂㄷㅂㄷ)
```java
int [] sample1 = new int [] {1,2,5,6,7,8,9,13,100,200};
int [] sample2 = new int [] {1,2,4,5,6,7,8,9,13,100,200};
int [] sample3 = new int [] {1,2,5,6,7,9,13,100,200};
int [] sample = new int [] {1,2,5,6,9,13,100,200};
```

