package eci.arep.lucas_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LucasSequenceService {

    @GetMapping("/lucasseq")
    public String computeLucasSequence(@RequestParam(value = "value", defaultValue = "0") int value) {
        StringBuilder sequence = new StringBuilder();
        int n1 = 2, n2 = 1;

        sequence.append(n1);
        if (value >= 1) {
            sequence.append(", ").append(n2);
        }

        for (int i = 2; i <= value; i++) {
            int next = n1 + n2;
            sequence.append(", ").append(next);
            n1 = n2;
            n2 = next;
        }

        return "{\"operation\":\"Secuencia de Lucas\",\"input\":" + value + ",\"output\":\"" + sequence.toString() + "\"}";
    }
}
