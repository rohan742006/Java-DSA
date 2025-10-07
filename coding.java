import java.util.*;
public class coding {

    public static void bottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        bottom(stack, data);
        stack.push(top);
    }

    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        //push each element in stack
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void Stock_span(int array[], int span[]) {
        Stack<Integer> s = new Stack<>();
        //span at starting is 1
        span[0] = 1;
        s.push(0);
        //iterate through all
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            //check if curr > prev then pop all prev
            while (!s.isEmpty() && curr >= array[s.peek()]) {
                s.pop();
            }
            //if stack empty push one value there
            if (s.isEmpty()) {
                span[i] = i + 1;
            }
            //else calculate span=i-prevhigh
            else {
                int prevhigh = s.peek();
                span[i] = i - prevhigh;
            }
            s.push(i);
        }
    }

    public static void nextgreater(int nums[]) {
        Stack<Integer> s = new Stack<>();
        int ng[] = new int[nums.length];
        //if top ele is smaller then all other pop top
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            //if s is empty then -1
            if (s.isEmpty()) {
                ng[i] = -1;
            }
            //if s not empty then top is greater
            else {
                ng[i] = nums[s.peek()];
            }
            //push in stack
            s.push(i);
        }

        System.out.println("Next greater elements:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(ng[i] + " ");
        }
        System.out.println();
    }

    public static void greater(int nums[]) {
        Stack<Integer> s = new Stack<>();
        int ng[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            //check if top is less then curr ele
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ng[i] = -1;
            } else {
                ng[i] = nums[s.peek()];
            }
            s.push(i);
        }

        System.out.println("Greater array:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(ng[i] + " ");
        }
        System.out.println();
    }

    public static boolean valid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            //closing
            else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((ch == ')' && s.peek() == '(') ||
                    (ch == '}' && s.peek() == '{') ||
                    (ch == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean duplicate(String str) {
        Stack<Character> s = new Stack<>();
        //if opening,or operator or operand then push
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ')') {
                s.push(ch);
            } else {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate found
                } else {
                    s.pop();
                }
            }
        }
        return false;
    }

    public static void max_area(int array[]) {
        int nsr[] = new int[array.length];
        int nsl[] = new int[array.length];
        //next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && array[s.peek()] >= array[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = array.length;   //i=n
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //next smaller left
        s = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!s.isEmpty() && array[s.peek()] >= array[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;   //i=n
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //curr Area  width=j-i-1=nsr[i]-nsl[i]-1
        int max_area = 0;
        for (int i = 0; i < array.length; i++) {
            int h = array[i];
            int w = nsr[i] - nsl[i] - 1;
            int curr_area = h * w;
            max_area = Math.max(curr_area, max_area);
        }
        System.out.print("Max area in histogram is: " + max_area);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        bottom(s, 3);
        System.out.println("Stack after inserting at bottom: " + s);

        String str = "rohan";
        System.out.println("Reversed string: " + reverse(str));

        int prices[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[prices.length];
        Stock_span(prices, span);
        System.out.println("Stock span: " + Arrays.toString(span));

        int nums[] = {6, 8, 0, 1, 3};
        nextgreater(nums);

        System.out.println("Valid parentheses ( { [ ] } ): " + valid("({[]})"));
        System.out.println("Duplicate parentheses ((a+b)): " + duplicate("((a+b))"));

        int array[] = {2, 1, 5, 6, 2, 3};
        max_area(array);
    }
}
