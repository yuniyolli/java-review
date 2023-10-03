package com.review.thymeleaf;

import org.springframework.stereotype.Service;

@Service
public class hitService {
    private int hit = 0;
/*
// private X -> private: only for this class
// String X -> this method will be used to cound "int" hit in controller
    private String countHit() {
        hit++;
        return countHit();

    }

 */
    // 여기서 private으로 메소드 생성하니까 컨트롤러에서 못찾음. 왜지??
    public int countHit() {
        hit++;
        return hit;
    }
}
