package com.vengat.Spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    @Autowired
    private Gaming1 g1;
    private Gaming2 g2;
    public GameRunner() {
        System.out.println("Obj is crated by the spring");
    }

    public void startGame() {
        g1.go();
        g2.go();
    }


}
