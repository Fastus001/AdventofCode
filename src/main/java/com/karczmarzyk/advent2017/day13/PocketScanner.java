package com.karczmarzyk.advent2017.day13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class PocketScanner {
    private final int maxLayer;
    private final Map<Integer, Layer> firewall;

    public PocketScanner(List<String> firewall) {
        this.firewall = firewall.stream()
                .map(s -> s.split(": "))
                .collect(Collectors.toMap(strings -> parseInt(strings[0]), strings -> new Layer(parseInt(strings[1]))));
        this.maxLayer = this.firewall.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(-1);
    }

    public int computeSeverity() {
        int severity = 0;
        for (int i = 0; i <= maxLayer; i++) {
            if (firewall.containsKey(i)) {
                Layer layer = firewall.get(i);
                int position = layer.getPosition();
                if (position == 1) {
                    severity += layer.getSeverity(i);
                }
            }
            firewall.values().forEach(Layer::move);
        }
        return severity;
    }
}
