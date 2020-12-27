def solution(answers):
    dict = {
        0: 'a',
        1: 'b',
        2: 'c'
    }
    student_a_pattern = [1,2,3,4,5]
    student_b_pattern = [2,1,2,3,2,4,2,5]
    student_c_pattern = [3,3,1,1,2,2,4,4,5,5]

    student_answers = []
    student_answers.append(student_a_pattern * int(10000 / len(student_a_pattern)))
    student_answers.append(student_b_pattern * int(10000 / len(student_b_pattern)))
    student_answers.append(student_c_pattern * int(10000 / len(student_c_pattern)))

    # 제출한 답안 출력
    for student_idx in range(len(student_answers)):
        print(student_answers[student_idx])

    count = [0, 0, 0]

    # 정답지 'answers'에 대해 각 학생의 답이 맞는지 체크하는데, 각 학생의 정답 갯수를 카운트
    for student_idx in range(len(student_answers)):
        for answer_idx in range(len(answers)):
            # if student_answers[student_idx][answer_idx] == answers[answer_idx]:
            if student_answers[student_idx][answer_idx] == answers[answer_idx]:
                count[student_idx] = count[student_idx] + 1

    result = []
    max_score = max(count)
    for i in range(len(count)):
        if count[i] == max_score:
            result.append(dict[i])

    return result


def main():
    print("student_a :: 10000/5 = {}".format(10000/5))
    print("student_b :: 10000/8 = {}".format(10000/8))
    print("student_c :: 10000/10 = {}".format(10000/10))

    answer = [1,2,3,4,5]*2000
    print("anwser :: {}".format(answer))
    print("고득점자 :: {}".format(solution(answer)))


if __name__ == "__main__":
    main()
