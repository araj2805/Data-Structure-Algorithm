package interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervalsList, Interval newInterval) {

        LinkedList<Interval> ans = new LinkedList<>();

        for (Interval interval : intervalsList) {

            if (interval.end < newInterval.start)
                ans.add(interval);

            if (newInterval.end < interval.start)
                ans.add(interval);


            if (ans.getLast().end >= newInterval.start) {
                Interval insertInterval = new Interval();

                insertInterval.start = Math.min(newInterval.start, interval.start);
                insertInterval.end = Math.max(newInterval.end, interval.end);

                ans.add(insertInterval);
            }

        }

        if (ans.getLast().end < newInterval.start)
            ans.add(newInterval);

        ans.sort((a, b) -> {
            return a.start - b.start;
        });


        return new ArrayList<>(ans);
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}




