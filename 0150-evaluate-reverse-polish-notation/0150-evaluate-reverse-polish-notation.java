class Solution {
    
    public int evalRPN(String[] tokens) {
        Set<String> oper = Set.of("+", "-", "*", "/");
        Stack<Integer> st = new Stack<>();
        
        for (String t: tokens) {
            if (!oper.contains(t)) {
                st.push(Integer.parseInt(t));
                continue;
            }

            int b = st.pop();
            int a = st.pop();
            
            int cur = cal(a, b, t);
            System.out.println(t);
            System.out.println(cur);
            st.push(cur);
        }

        return st.pop();
    }

    public int cal(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        return a / b;
    }
}