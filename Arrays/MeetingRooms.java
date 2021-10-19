import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Meeting{
    int start;
    int end;

    public Meeting(int start,int end){
        this.start = start;
        this.end = end;
    }
};

public class MeetingRooms {

    public static int minimumMeetingRooms(List<Meeting> meetings){

        if(meetings == null || meetings.size() == 0) return 0;
        Collections.sort(meetings, (a,b) -> Integer.compare(a.start,b.start));

        //Making the minHeap using priority queue.

        int minRooms =0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size(),(a,b) -> Integer.compare(a.end,b.end));
        
        for(Meeting meeting : meetings){

            // deleting the meetings that has been completed before the start of ith meeting.
            while(!minHeap.isEmpty() && minHeap.peek().end <= meeting.start){
                minHeap.poll();
            }
            //add the current meeting to the queue and
            minHeap.offer(meeting);

            //Take the max of minRooms and queue size at every meeting.
            minRooms = Math.max(minRooms, minHeap.size()); 
        }
        return minRooms;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        List<Meeting> meetings = new ArrayList<Meeting>();
        int n  = sc.nextInt();

        for(int i=0;i<n;i++){
            meetings.add(new Meeting(sc.nextInt(),sc.nextInt()));
        }

        System.out.println(minimumMeetingRooms(meetings));

    }
}
