# 병합정렬
퀵정렬에서는 파티션, partion 함수를 이해하는 것이 중요한 개념이기도 하고 큰 러닝커브이다.  
병합정렬에서는 마지막 요소들을 합칠때 정렬해서 병합해야 하는데 이 병합할때의 로직이 러닝커브가 된다.  
분할 정복을 배우면서 다른 문제들을 이해하지 못하게 되는 경우가 꽤 있는데, 병합정렬을 먼저 이해하고 넘어가면 조금이나마 빠르게 이해하게 되는 것 같다.  
  
# 참고자료
- [C언어로 쉽게 풀어쓴 자료구조](http://www.yes24.com/Product/Goods/69750539)

# 병합정렬 알고리즘
psuedo-code 는 아래와 같다.
```plain
merge_sort(list, left, right){
    if left <right
        mid = (left+right)/2;
        merge_sort(list, left, mid);
        merge_sort(list, mid+1, right);
        merge(list, left, mid, right);
}
```
1. 만약 나누어진 구간의 크기가 1 이상이면 
2. 중간 위치를 계산한다.
3. 앞쪽 부분 배열을 정렬하기 위하여 merge_sort 함수를 순환호출한다.
4. 뒤쪽 부분 배열을 정렬하기 위하여 merge_sort 함수를 순환호출한다.
5. 정렬된 2개의 부분 배열을 통합하여 하나의 정렬된 배열로 만든다.

# merge 함수 알고리즘
병합정렬에서 merge_sort 를 모두 호출 한 후에 merge를 호출하게 되는데 이것을 보통 합병 알고리즘이라고 부른다.
다른 재귀문은 알맹이가 없지만, 결국 merge 함수에서 실질적인 정렬작업을 수행한다.  
```plain
merge(list, left, mid, last){
    b1 = left;
    e1 = mid;
    b2 = mid + 1;
    e2 = right;

    int [] sorted = ...;
    int index = 0;
    
    while (b1<=e1 && b2 <=e2) do {
        if(list[b1] < list[b2])
            then
                sorted[index] = list[b1];
                b1++;
                index++;
            else
                sorted[index] = list[b2];
                b2++;
                index++;
    }

    요소가 남아있는 부분 배열을 sorted로 복사

    sorted를 list로 복사
}
```
  
# merge 함수 :: 병합정렬의 병합시의 정렬로직
> 병합정렬은 배열의 모든 요소를 분할했다가, 요소들을 병합한다. 이때 중요한 것이 merge 함수, 즉, 병합함수 이다. 
> - 이 merge 함수는 정렬을 수행하면서 병합을 수행한다.      

병합정렬에서 가장 중요한 로직이자 처음 배울때 어려움을 느끼는 병합(merge)로직을 살펴보자.  
병합(merge)로직은 병합을 수행하면서 정렬을 수행하면서 병합을 수행하게 된다.  
![이미지](./img/2021-02-23-MERGESORT.png)
  
# 병합정렬 
```java
void mergeSort(int list [], int left, int right){
    int mid;
    if (left < right) {
        mid = (left+right)/2;
        mergeSort(list, left, mid);
        mergeSort(list, mid+1, right);
        merge(list, left, mid, right);
    }
}
```
