/*
Problem: Job Sequencing with Deadlines

Approach:
- Sort jobs by profit in descending order
- Find the maximum deadline to determine the number of available time slots
- Store the sorted jobs in a queue
- Process jobs in profit order using the queue
- For each job, find the latest available slot before its deadline
- Schedule the job if a valid slot is available
- Print the scheduled jobs in chronological order

Complexity:
Time: O(n log n + n * d)
Space: O(n + d)
Here, n = number of jobs and d = maximum deadline.

Key Idea:
- Greedily prioritize jobs with higher profits
- Schedule each job in the latest available slot before its deadline
- This leaves earlier slots available for jobs with tighter deadlines
*/
package Queues;

import java.util.*;

public class JobSequencing {

    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobSequence(Job[] jobs) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        char[] slots = new char[maxDeadline + 1];

        // Queue processes the jobs in profit order
        Queue<Job> queue = new LinkedList<>();

        for (Job job : jobs) {
            queue.add(job);
        }

        while (!queue.isEmpty()) {
            Job job = queue.poll();

            // Find the latest available slot before deadline
            for (int i = job.deadline; i >= 1; i--) {
                if (slots[i] == '\0') {
                    slots[i] = job.id;
                    break;
                }
            }
        }

        // Print scheduled jobs in time order
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != '\0') {
                System.out.print(slots[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 4, 20),
                new Job('b', 1, 10),
                new Job('c', 1, 40),
                new Job('d', 1, 30)
        };

        jobSequence(jobs);
    }
}
