# 키에 따른 대기열 재구성
# 언어별로 난이도 및 시간이 조금 걸리는 점이 있다.
- python 의 경우 insert 메서드를 사용하면 해당 index 에 데이터가 있더라도 일반 리스트 연산처럼 그 곳에 데이터를 넣고 뒤에 링크를 붙이는 반면
- java 의 경우 add 메서드를 사용하면 해당 index 에 데이터가 있으면 replace 해버린다. 이런 이유로 2차원 배열 기반으로 문제를 풀긴 햇는데 아직도 불완전
    - 차라리 DataList 라는 이름의 리스트를 만들어서 해보는 것도 생각중이기는 하다. 
# 난이도 : Medium
# 출처
[406. Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/)

# 문제
> 문제 내용을 자세히 읽어서 알수 없다면 input/output example 을 자세히 보는 것이 맞다. 수식으로 표현되었어야 하는 내용들을 말로 설명하는 것이고, 더군다나 영어로 표현되어 있는 것이기 때문에  
> input, output 예시를 봐야 오히려 이해가 더 빠를 수 있기 때문이다. 일단 아래의 내요을 보면 h는 키이고, 
```plain
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
```

# e.g. 1)
```plain
Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
```

- `[5,0]`은 맨 앞에 있어야 한다. 키가 5이면서 어떠한 사람도 키가 그 이상인 사람이 앞에 없다.    
- `[7,0]`은 키가 크거나 같은 사람을 두어야 하는 앞에 있어야 하는 사람이 없다.  
- `[5,2]`은 자신보다 키가 크거나 같은 사람을 두명(5,7) 가지고 있다.  
- `[6,1]`은 자신보다 키가 크거나 같은 사람을 한명(7) 가지고 있다.
- `[4,4]`는 자신보다 키가 크거나 같은 사람을 네명 (5,7,5,6)을 가지고 있다. 
- `[7,1]`는 자신보다 키가 크거나 같은 사람을 한명 (7)을 가지고 있다. 


# e.g. 2)
```plain
Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
```


