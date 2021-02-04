package com.karczmarzyk.advent2016.day20;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class IpRange {
    private long min;
    private long max;

    public IpRange(long min, long max) {
        this.min = min;
        this.max = max;
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
        //when new Range include inside whole this range!
        return range.min < this.min && range.max > this.max;
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
        return null;
    }



}
