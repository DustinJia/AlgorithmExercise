package LintCode;

// https://www.lintcode.com/en/problem/course-schedule-ii/

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 */

/**
 * Example
 * Given n = 2, prerequisites = [[1,0]]
 * Return [0,1]
 *
 * Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * Return [0,1,2,3] or [0,2,1,3]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2_616 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        ArrayList[] edges = new ArrayList[numCourses];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            result[count++] = course;

            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int successor = (int) edges[course].get(i);
                degrees[successor]--;

                if (degrees[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }

        if (count < numCourses) {
            return new int[0];
        } else {
            return result;
        }
    }
}
