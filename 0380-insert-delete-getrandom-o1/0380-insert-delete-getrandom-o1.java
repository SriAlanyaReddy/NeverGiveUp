class RandomizedSet {
    HashMap<Integer,Integer>mp;
    ArrayList<Integer>l;
    Random r=new Random();

    public RandomizedSet() {
        mp=new HashMap<>();
        l=new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val)){
           
            return false;
        }
        mp.put(val,l.size());
        l.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
       if(!mp.containsKey(val)){
        return false;
       }
       int pos=mp.get(val);
       if(pos!=l.size()-1){
        int last=l.get(l.size()-1);
        l.set(pos,last);
        mp.put(last,pos);
       }
       return true;
    }
    
    public int getRandom() {
        int rand=r.nextInt(l.size());
        return l.get(rand);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */