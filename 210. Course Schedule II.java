public class Solution {
    public class Course{
        public int index;
        public LinkedList<Course> prevList;
        public LinkedList<Course> deeperList;
        public Course(int i) {
            index = i;
            prevList = new LinkedList<Course>();
            deeperList = new LinkedList<Course>();
        }
        
        public void addPrev(Course prev) {
            prevList.add(prev);
            prev.addDeeper(this);
        }
        
        public void addDeeper(Course deeper) {
            deeperList.add(deeper);
        }
        
        public boolean isPrevEmpty() {
            return prevList.isEmpty();
        }
        
        public void removePrev(Course prev) {
            prevList.remove(prev);
        }
        
        public ArrayList<Course> finish() {
            ArrayList<Course> newFreeCourses = new ArrayList<Course>();
            for(Course c:deeperList) {
                c.removePrev(this);
                if(c.isPrevEmpty()){
                    newFreeCourses.add(c);
                }
            }
            return newFreeCourses;
        }
        
        public int getIndex() {
            return this.index;
        }
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses > 0)  {
            // throw
        }
        
        ArrayList<Course> courses = new ArrayList<Course>(numCourses); 
        for(int i = 0; i < numCourses; i++) {
            courses.add(new Course(i));
        }
        
        for(int[] pre:prerequisites) {
            courses.get(pre[0]).addPrev(courses.get(pre[1]));
        }
        
        LinkedList<Course> freeCourses = new LinkedList<Course>();
        for(Course course:courses) {
            if(course.isPrevEmpty()){
                freeCourses.add(course);
            }
        }
        
        int[] res = new int[numCourses];
        int count = 0; // count the courses that have been finished
        
        // BFS
        while(!freeCourses.isEmpty()) {
            Course course = freeCourses.poll();
            ArrayList newFreeCourses = course.finish();
            res[count] = course.getIndex();
            count++;
            freeCourses.addAll(newFreeCourses);
        }
        
        if(count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
        
        
    }
}
