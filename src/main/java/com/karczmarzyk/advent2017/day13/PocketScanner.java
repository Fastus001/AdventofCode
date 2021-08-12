package com.karczmarzyk.advent2017.day13;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toMap;

public class PocketScanner {
    private final int maxLayer;
    private final Map<Integer, Layer> firewall;

    public PocketScanner(List<String> firewall) {
        this.firewall = firewall.stream()
                .map(s -> s.split(": "))
                .collect(toMap(strings -> parseInt(strings[0]), strings -> new Layer(parseInt(strings[1]))));
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

    public boolean computeSafePass() {
        var temp = copyFirewall();
        for (int i = 0; i <= maxLayer; i++) {
            if (temp.containsKey(i)) {
                Layer layer = temp.get(i);
                int position = layer.getPosition();
                if (position == 1) {
                    return false;
                }
            }
            temp.values().forEach(Layer::move);
        }
        return true;
    }

    public void delay() {
            firewall.values().forEach(Layer::move);
    }

    public void resetLayers() {
        firewall.values()
                .forEach(Layer::reset);
    }

    private Map<Integer, Layer> copyFirewall() {
        return firewall
                .entrySet()
                .stream()
                .collect(toMap(
                        Map.Entry::getKey,
                        entry->{
                            Layer value = entry.getValue();
                            return new Layer(value.getSize(), value.getDirection(), value.getPosition());
                        })
                );
    }
}
