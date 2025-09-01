class Solution {
    class Pair{
        int index; double increase;
        public Pair(int i, double d){
            this.index= i;
            this.increase= d;
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(b.increase, a.increase));
        for(int i=0; i<classes.length; i++){
            double d= ((double)(classes[i][0]+1)/(classes[i][1]+1))-((double)classes[i][0]/classes[i][1]);
            //System.out.println("d="+d);
            pq.offer(new Pair(i,d));
        }

        while (extraStudents != 0){
            Pair p= pq.poll();
            int ind= p.index;
            classes[ind][0]++;
            classes[ind][1]++;
            //System.out.println(ind+" "+classes[ind][0]+" "+classes[ind][1]+" "+p.increase);
            double d=  ((double)(classes[ind][0]+1)/(classes[ind][1]+1))-((double)classes[ind][0]/classes[ind][1]);
            pq.offer(new Pair(ind,d));
            extraStudents--;
        }
        double ans=0;
        for (int [] i: classes){
            ans+=((double)i[0]/i[1]);
        }
        ans/=classes.length;

        return ans;
    }
}
