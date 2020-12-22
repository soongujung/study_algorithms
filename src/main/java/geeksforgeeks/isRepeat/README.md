
# 참고자료
[Geeks For Geeks - check if a linked list is circular](https://www.geeksforgeeks.org/check-if-a-linked-list-is-circular-linked-list/)  
  
아래는 내 멋대로 만들어 본 문제
# 줄세우기
이름이 A, B, C, ... 인 사람들이 있다. 급식을 받아서 점심을 먹어야 한다. 
줄을 서는 순서를 미리 정해놓으려 한다. 줄을 설때 A, B, C, ... 인 이름을 가진 사람들이 
중복해서 배식받지 않도록 연결리스트를 작성해보자.

```java
Person a = new Person();
Person b = new Person();

a.setNextPerson(b);
b.setNextPerson(a);

System.out.println("is 'a' repeat ? " + a.isRepeat());
```
