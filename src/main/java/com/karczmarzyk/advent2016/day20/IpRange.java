package com.karczmarzyk.advent2016.day20;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@EqualsAndHashCode
public class IpRange implements Comparable<IpRange>{
    private long min;
    private long max;

    public IpRange(long min, long max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int compareTo(@NotNull IpRange o) {
        return Long.compare( this.min, o.min );
    }

    public long getDifference(){
        return (max-min);
    }

    public boolean isNumberInRange(long number){
        return number >= this.min && number <= this.max;
    }

    public boolean isInRange(IpRange range){
        if(range.min >= this.min && range.min <=this.max){
            return true;
        }
        if(range.max >= this.min && range.max <= this.max){
            return true;
        }
        if(range.min < this.min && range.max > this.max){
            return true;
        }
        if(this.max==(range.min-1)){
            return true;
        }
        if((this.min)-1==range.max){
            return true;
        }
        //when new Range include inside whole this range!
        return false;
    }

    public IpRange joinRanges(IpRange range){
        //new covers whole old
        if(range.min <= this.min && range.max >= this.max){
            return range;
        }
        //old covers whole new
        if(range.min >= this.min && range.max <= this.max){
            return this;
        }
        //new min is in range, but max is higher
        if(range.min >= this.min && range.min <=this.max){
            return new IpRange( this.min, range.max );
        }
        //oposit situation
        if(range.max >= this.min && range.max <= this.max){
            return new IpRange( range.min, this.max );
        }
        //when both ranges are different only by one
        if(this.max==(range.min)-1){
            return new IpRange( this.min, range.max );
        }
        if((this.min)-1==range.max){
            return new IpRange( range.min, this.max );
        }
        return null;
    }

    @Override
    public String toString() {
        return min +"-"+ max;
    }
}
