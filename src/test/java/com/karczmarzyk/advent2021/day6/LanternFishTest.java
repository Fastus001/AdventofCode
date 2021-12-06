package com.karczmarzyk.advent2021.day6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanternFishTest {

    @Test
    void oneDay() {
        LanternFish fish = new LanternFish("3,4,3,1,2");

        for (int i = 0; i < 80; i++) {
            fish.oneDay();
        }

        int muchIsTheFish = fish.howMuchIsTheFish();

        Assertions.assertThat(muchIsTheFish).isEqualTo(5934);
    }

    @Test
    void partOne() {
        LanternFish fish = new LanternFish("2,5,5,3,2,2,5,1,4,5,2,1,5,5,1,2,3,3,4,1,4,1,4,4,2,1,5,5,3,5,4,3,4,1,5,4,1,5,5,5,4,3,1,2,1,5,1,4,4,1,4,1,3,1,1,1,3,1,1,2,1,3,1,1,1,2,3,5,5,3,2,3,3,2,2,1,3,1,3,1,5,5,1,2,3,2,1,1,2,1,2,1,2,2,1,3,5,4,3,3,2,2,3,1,4,2,2,1,3,4,5,4,2,5,4,1,2,1,3,5,3,3,5,4,1,1,5,2,4,4,1,2,2,5,5,3,1,2,4,3,3,1,4,2,5,1,5,1,2,1,1,1,1,3,5,5,1,5,5,1,2,2,1,2,1,2,1,2,1,4,5,1,2,4,3,3,3,1,5,3,2,2,1,4,2,4,2,3,2,5,1,5,1,1,1,3,1,1,3,5,4,2,5,3,2,2,1,4,5,1,3,2,5,1,2,1,4,1,5,5,1,2,2,1,2,4,5,3,3,1,4,4,3,1,4,2,4,4,3,4,1,4,5,3,1,4,2,2,3,4,4,4,1,4,3,1,3,4,5,1,5,4,4,4,5,5,5,2,1,3,4,3,2,5,3,1,3,2,2,3,1,4,5,3,5,5,3,2,3,1,2,5,2,1,3,1,1,1,5,1");

        for (int i = 0; i < 80; i++) {
            fish.oneDay();
        }

        int muchIsTheFish = fish.howMuchIsTheFish();

        Assertions.assertThat(muchIsTheFish).isEqualTo(352151);
    }
}