/*

given {x,h,y} , x to y with height h

1) create array sorted with x, 
{x,h},{y,h},...

2) create priority queue with height,
3) traverse thoourgh start, end list,
    if point is start point? -> add it to PQ, does the max value change? -> yes -> update max
    if point is end point? -> remove it from PQ, does the max value change? -> yes -> update max


*/
// https://www.youtube.com/watch?v=GSBLe8cKu0s

import java.util.*;

/**
 *         Given skyline of a city merge the buildings
 *
 *         Time complexity is O(nlogn)
 *         Space complexity is O(n)
 *
 *         References
 *         https://leetcode.com/problems/the-skyline-problem/
 *         https://leetcode.com/discuss/67091/once-for-all-explanation-with-clean-java-code-nlog-time-space
 */
class skylineDrawing {

  /**
   * Represents either start or end of building
   */
  static class BuildingPoint implements Comparable<BuildingPoint> {

    int x;
    boolean isStart; // true for start, false for endpoint
    int height;

    @Override
    public int compareTo(BuildingPoint o) {
      // first compare by x.
      // If they are same then use this logic
      // if two starts are compared then higher height building should be picked first
      // if two ends are compared then lower height building should be picked first
      // if one start and end is compared then start should appear before end
      if (this.x != o.x) {
        return this.x - o.x;
      } else { // if start is same then compare by height
        return (
          (this.isStart ? -this.height : this.height) -
          (o.isStart ? -o.height : o.height)
        );
      }
    }
  }

  public List<int[]> getSkyline(int[][] buildings) {
    // for all start and end of building put them into List of BuildingPoint
    BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
    int index = 0;
    for (int building[] : buildings) {
      // for start point
      buildingPoints[index] = new BuildingPoint();
      buildingPoints[index].x = building[0];
      buildingPoints[index].isStart = true;
      buildingPoints[index].height = building[2];

      index++; //next is end
      // for end point
      buildingPoints[index] = new BuildingPoint();
      buildingPoints[index].x = building[1];
      buildingPoints[index].isStart = false;
      buildingPoints[index].height = building[2];
      index++; // prepare for the next start
    }
    Arrays.sort(buildingPoints); // sort with starting points, ie

    // using TreeMap because it gives log time performance.
    // PriorityQueue in java does not support remove(object) operation in log time.
    TreeMap<Integer, Integer> queue = new TreeMap<>();
    // PriorityQueue<Integer> queue1 = new
    // PriorityQueue<>(Collections.reverseOrder());
    queue.put(0, 1);
    // queue1.add(0);
    int prevMaxHeight = 0;
    List<int[]> result = new ArrayList<>();
    for (BuildingPoint buildingPoint : buildingPoints) {
      // if it is start of building then add the height to map. If height already
      // exists then increment
      // the value
      if (buildingPoint.isStart) {
        queue.compute(
          buildingPoint.height,
          (key, value) -> {
            if (value != null) {
              return value + 1;
            }
            return 1;
          }
        );
        // queue1.add(cp.height);
      } else { // if it is end of building then decrement or remove the height from map.
        queue.compute(
          buildingPoint.height,
          (key, value) -> {
            if (value == 1) {
              return null;
            }
            return value - 1;
          }
        );
        // queue1.remove(cp.height);
      }
      // peek the current height after addition or removal of building x.
      int currentMaxHeight = queue.lastKey();
      // int currentMaxHeight = queue1.peek();
      // if height changes from previous height then this building x becomes critcal
      // x.
      // So add it to the result.
      if (prevMaxHeight != currentMaxHeight) {
        result.add(new int[] { buildingPoint.x, currentMaxHeight });
        prevMaxHeight = currentMaxHeight;
      }
    }
    return result;
  }
}

class SkyLineProblem {

  public static void main(String args[]) {
    int[][] buildings = {
      { 1, 3, 4 },
      { 3, 4, 4 },
      { 2, 6, 2 },
      { 8, 11, 4 },
      { 7, 9, 3 },
      { 10, 11, 2 },
    };
    skylineDrawing sd = new skylineDrawing();
    List<int[]> criticalPoints = getSkyline(buildings);
    criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));
  }
}

//pepCoding https://www.youtube.com/watch?v=POUMNJou4vc

class pepCodingSolutionToSkylineProblem {

  public static void main(String[] args) {}

  public List<List<Integer>> getskyline(int[][] buildings) {
    List<Pair> list = new ArrayList<>();
    for (int i = 0; i < buildings.length; i++) {
      list.add(new Pair(buildings[i][0], -buildings[i][2])); // start neg
      list.add(new Pair(buildings[i][1], buildings[i][2])); // end pos
    }

    // sort the list by x

    Collections.sort(list);

    List<List<Integer>> ans = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.add(0);

    int cht = 0; //current height
    for (int i = 0; i < list.size(); i++) {
      int x = list.get(i).x;
      int ht = list.get(i).height;

      if (ht < 0) { // start
        pq.add(-ht);
      } else { // end point
        pq.remove(ht);
      }

      // if current height is not equal to max height then add it to the ans
      if (cht != pq.peek()) {
        ans.add(new ArrayList<Integer>());
        ans.get(ans.size() - 1).add(x);
        ans.get(ans.size() - 1).add(pq.peek());
        cht = pq.peek();
      }
    }
    return ans;
  }

  // compare two pairs and return the one with higher height
  public class Pair implements Comparable<Pair> {

    int x;
    int height;

    public Pair(int x, int height) {
      this.x = x;
      this.height = height;
    }

    @Override
    public int compare(Pair o2) {
      if (this.x != o2.x) {
        return this.x - o2.x;
      } else {
        return this.height - o2.height;
      }
    }
  }
}
