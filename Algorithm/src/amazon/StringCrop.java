package amazon;

import java.util.Arrays;

public class StringCrop {
    public String solution(String message, int K) {
        // write your code in Java SE 8
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (String word: message.trim().split("\\s+")){
            count = count + word.length();
            if (count <= K) {
                stringBuilder.append(word).append(" ");
            } else {
                break;
            }
        }

        return stringBuilder.toString().trim();

    }
}

