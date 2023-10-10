package com.review.thymeleaf;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

@Service
public class LottoService {

    // void는 main 불러오기가 안됨. 반환형이 필요해...!
    public String[] winningNum() {
        int[] allNums = new int[45];
        String[] winningNums = new String[6];
        Random random = new Random();

        // 전체 로또 수를 담는 배열 생성
        for (int i = 1; i < 46; i++) {
            allNums[i - 1] = i;
        }
        //todo : null 발생 및 중복된 값 출력 -> GPT풀이
        // 원인 1. String으로 받아서 null이 나옴. int로 random함수를 쓰되, +1 을 통해 0 값 제거
        // 원인 2. 중복된 값을 제거하는 로직이 잘못됨. Boolean함수를 쓰는게 익숙하지 않음.
        // 여전히 왜 일반 조건문에서는 적용이 안되는지는 이해가 안됨.

        // 6개의 수를 뽑는 배열 생성

            for (int i = 0; i < 6; i++) {
                //String oneNum = Integer.toString((int) (Math.random() * 46));
                // Generate a random number between 1 and 45 (inclusive)
                int oneNum = random.nextInt(45) + 1;


                // Check if the generated number is already in the array
                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (winningNums[j] != null && winningNums[j].equals(String.valueOf(oneNum))) {
                        isDuplicate = true;
                        break;
                    }
                }

                // If it's a duplicate, generate a new number
                if (isDuplicate) {
                    i--;
                } else {
                    winningNums[i] = String.valueOf(oneNum);
                }
            }
        return winningNums;
    }

/*
                // random 난수 생성
                // 조건 1. 난수가 0이 아닐 때 && 0 번째인 경우 (생략 시 0번째 인덱스가 null)
                if (!oneNum.equals("0") && !oneNum.equals(null) && !oneNum.equals("null")) {
                    if (i == 0 && !oneNum.equals("null")) {
                        winningNums[i] = oneNum;
                    } else {
                    // 조건 2. 지금까지 i개 생성 된 난수 중 같은 값이 존재하지 않을 때
                    for (int j = 0; j < i; j++) {
                        if (!oneNum.equals(winningNums[j])) {
                            winningNums[i] = oneNum;
                        }
                    }
                }
            }
        }
        return winningNums;
    }

 */

    public String result() {
        LottoService lottoService = new LottoService();
        String[] nums = lottoService.winningNum();
        //String[] nums = {"1", "2", "3", "4", "5", "6"};
        String results = "";

        for (int i = 0; i < nums.length ; i++) {
            results += String.format("%s", nums[i]);
            if (i != nums.length - 1) {
                results += " - ";
            }
        }
        return results;
    }


    public static void main(String[] args) {
       // System.out.println(new LottoService().winningNum());
        LottoService lottoService = new LottoService();
        //System.out.println(lottoService.winningNum());
        //System.out.println(Arrays.toString(lottoService.winningNum()));
        System.out.println(lottoService.result());

        for (String num : lottoService.winningNum()) {
            System.out.print(num + " - ");
        }
    }
}
