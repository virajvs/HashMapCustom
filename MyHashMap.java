import java.util.*;

class data<k, v> {
    k key;
    v val;

    data(k k, v v) {
        this.key = k;
        this.val = v;
    }
}

class MyHashMap<k, v> {

    int pos = 0;
    int size = 20;
    int cur = 0;
    data<k, v> element[];

    MyHashMap() {

        element = new data[size];
    }

    void put(k key, v value) {

        if (!isFound(key)) {
            if (pos > size) {
                size = size + 1;
            }
            element[pos] = new data(key, value);
            pos = pos + 1;
            cur = cur + 1;
        }else{
            System.out.println("Already Present");
        }
    }
    boolean isFound(k k1)
    {
        
        for (int i=0;i<cur;i++){
            if(element[i].key.equals(k1)){
                return true;
            }
        }
        return false;
    }

    void get(k k1) {
        for (int i = 0; i < cur; i++) {
            if (element[i].key.equals(k1)) {
                System.out.println("value :" + element[i].val);
            }
        }
    }

    void getAll() {
        try {
            for (data d : element) {
                System.out.println("Key :" + d.key + ",Val :" + d.val);

            }
        } catch (Exception e) {
            // System.out.println("No Data Found");
        }
    }

    void replace(k k1, v v1) {

        for (int i = 0; i < cur; i++) {
            if (element[i].key.equals(k1)) {
                element[i].val = v1;
                break;
            }
        }
    }

    void remove(k k1) {
        k x = k1;

        for (int i = 0; i < cur; i++) {
            if (element[i].key.equals(k1)) {
                element[i] = null;
                element[cur + 1] = element[i];
                break;
            }
        }
        System.out.println(k1 + " is deleted");
    }

    void showKeys() {
        for (int i = 0; i < cur; i++) {
            System.out.println(element[i].key);
        }
    }

    void showVals() {
        for (int i = 0; i < cur; i++) {
            System.out.println(element[i].val);
        }
    }

    void hasKey(k k1) {
        for (int i = 0; i < cur; i++) {
            if (element[i].key.equals(k1)) {
                System.out.println("Key Exitst");
                break;
            }
        }
    }

    void clear() {
        element=null;
    }

    void isEmpty() {
        int f = 0;
        for (data d : element) {
            if (d != null) {
                f = 1;
                break;
            } else {
                f = 0;
            }

        }
        if (f == 1)
            System.out.println("Not Empty");
        else
            System.out.println("Empty");
    }

    public static void main(String args[]) {
        Scanner sc;
        sc = new Scanner(System.in);
        String k;
        int v;
        int opt;
        MyHashMap<String, Integer> hm = new MyHashMap<>();

        do {
            System.out.println(
                    "\n1:PUT\n2:GET\n3:REPLCAE\n4:REMOVE\n5:SHOW ALL\n6:SHOW KEYS\n7:SHOW VALS\n8:Has Key\n9:Remove All\n10:isEmpty\n0:EXIT");
            System.out.print("Choose an option :");
            opt = sc.nextInt();

            switch (opt) {
            case 1:
                System.out.print("Key :");
                k = sc.next();
                System.out.print("Value :");
                v = sc.nextInt();

                hm.put(k, v);
                break;

            case 2:
                System.out.print("Key :");
                k = sc.next();
                hm.get(k);
                break;

            case 3:
                System.out.print("Key :");
                k = sc.next();
                System.out.print("Value to replace :");
                v = sc.nextInt();
                hm.replace(k, v);
                break;

            case 4:
                System.out.print("Key :");
                k = sc.next();
                hm.remove(k);
                break;

            case 5:
                hm.getAll();
                break;

            case 6:
                hm.showKeys();
                break;

            case 7:
                hm.showVals();
                break;

            case 8:
                System.out.print("Key :");
                k = sc.next();
                hm.hasKey(k);
                break;

            case 9:
                hm.clear();
                break;

            case 10:
                hm.isEmpty();
                break;

            case 0:
                System.exit(0);

            default:
                System.out.print("Enter valid option");

            }

        } while (opt != 0);
    }
    

}
