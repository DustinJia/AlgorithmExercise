package LintCode;

// https://www.lintcode.com/en/problem/course-schedule/

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */

/**
 * Example
 * Given n = 2, prerequisites = [[1,0]]
 * Return true
 * Given n = 2, prerequisites = [[1,0],[0,1]]
 * Return false
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_615 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;

        int[] degrees = new int[numCourses];
        List[] edges = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue queue = new LinkedList();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            count++;

            int course = (int) queue.poll();
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int successor = (int) edges[course].get(i);
                degrees[successor]--;

                if (degrees[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }

        return count == numCourses;
    }
}
