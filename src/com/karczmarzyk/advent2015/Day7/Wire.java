package com.karczmarzyk.advent2015.Day7;

import java.util.ArrayList;

public class Wire {
    private final String identifier;
    private int signal;
    private boolean hasSignal;
    private final ArrayList<String> data;

    Wire(ArrayList<String> data)
    {
        this.identifier = data.get(data.size()-1);
        data.remove(data.size()-1);
        data.remove(data.size()-1);
        this.data = data;
        this.hasSignal = false;
    }

    public void setSignal(int signal)
    {
        this.signal = signal;
        this.hasSignal = true;
    }

    public int giveSignal()
    {
        return signal;
    }

    public boolean hasSignal() {
        return hasSignal;
    }

    public int getDataSize(){return this.data.size();}

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "Wire{" +
                "identifier='" + identifier + '\'' +
                ", signal=" + signal +
                ", hasSignal=" + hasSignal +
                ", data=" + data +
                '}';
    }

    public int dataSize() {
        return data.size();
    }

    public String dataGet(int i) {
        return data.get( i );
    }
}
