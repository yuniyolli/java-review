package com.review.thymeleaf;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestService {
    public int RandomNum() {
        Random random = new Random();

        // historyExam 전체 문항수에 대한 배열 선언
        int[] historyExam = new int[50];
        for (int i = 1; i <= 50 ; i++) {
            historyExam[i - 1] = i;
        }

        // 풀이를 할 특정 문제 고르기
        int chooseNum = random.nextInt(51);

        // 풀이를 끝낸 문제를 담을 배열 생성
        List<Integer> solved = new ArrayList<>();

        // 풀이를 끝낸 문제를 배열에 추가하기
        // chooseNum이 배열에 존재하지 않을 때까지 난수 검색
        // -> 한번만 검색하
        while (!solved.contains(chooseNum)) {
            int count = 0;
            //System.out.println(chooseNum);
            solved.add(chooseNum);
            count++;
            if (count == 1)
            //    System.out.println("Already passed a question");
                break;
            }


        return chooseNum;
    }
}
