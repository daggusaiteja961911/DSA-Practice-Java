package org.example.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {
    //Leetcode 811
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String entry : cpdomains) {
            String[] parts = entry.split(" ");
            int times = Integer.parseInt(parts[0]);
            String domain = parts[1];

            map.put(domain, map.getOrDefault(domain, 0) + times);

            int pos = domain.indexOf('.');
            while (pos != -1) {
                String sub = domain.substring(pos + 1);
                map.put(sub, map.getOrDefault(sub, 0) + times);
                pos = domain.indexOf('.', pos + 1);
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            res.add(e.getValue() + " " + e.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        SubDomainVisitCount solution = new SubDomainVisitCount();
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> result = solution.subdomainVisits(cpdomains);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
