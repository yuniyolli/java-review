package com.review.thymeleaf;

import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    public void randomNum() {
        LottoService lottoService = new LottoService();
        System.out.println(lottoService.winningNum());

    }
    private class LottoService{
        public Object winningNum() {
            for (int i = 0; i < 6; i++) {
                for (int j = i; j < i + 1; j++) {
                    // the type of Random function : double!
                    j = (int) Math.random();
                    System.out.printf("%d ", j);
                }
                System.out.print("- ");
            }
            return winningNum();
        }

    }
}
