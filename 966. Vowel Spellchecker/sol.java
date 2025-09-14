import java.util.*;

class Solution {
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Preprocess wordlist
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelErrorMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower, word);

            String masked = maskVowels(lower);
            vowelErrorMap.putIfAbsent(masked, word);
        }

        // 2. Process queries
        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // Rule 1: Exact match
            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }

            // Rule 2: Case-insensitive match
            String lowerQuery = query.toLowerCase();
            if (caseInsensitiveMap.containsKey(lowerQuery)) {
                result[i] = caseInsensitiveMap.get(lowerQuery);
                continue;
            }

            // Rule 3: Vowel-error match
            String maskedQuery = maskVowels(lowerQuery);
            if (vowelErrorMap.containsKey(maskedQuery)) {
                result[i] = vowelErrorMap.get(maskedQuery);
                continue;
            }

            // Rule 4: No match
            result[i] = "";
        }
        return result;
    }
}

