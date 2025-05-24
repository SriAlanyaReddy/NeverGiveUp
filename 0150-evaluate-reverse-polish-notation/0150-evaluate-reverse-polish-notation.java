class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        String operators="+-/*";
        Stack<String>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(!operators.contains(tokens[i])){
                st.push(tokens[i]);

            }
            else{
                int first=Integer.parseInt(st.pop());
                int second=Integer.parseInt(st.pop());
                int op=operators.indexOf(tokens[i]);
                switch(op){
                    case 0:
                    st.push(String.valueOf(first+second));
                    break;
                    case 1:
                    st.push(String.valueOf(second-first));
                    break;
                    case 2:
                    st.push(String.valueOf(second/first));
                    break;
                    case 3:
                    st.push(String.valueOf(first*second));
                    break;
                }
                
            }

        }
        return Integer.parseInt(st.pop());
    }
}