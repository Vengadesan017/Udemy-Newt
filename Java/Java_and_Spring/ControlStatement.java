public class ControlStatement {
    public static void main(String[] args) {
        if (false){
            System.out.println("dfvkfd");
        }
        else if (false){
            System.out.println("dkjfvn");
        }
        else{
            System.out.println("else");
        }

        System.out.println(2==1?true:false);

        switch ("Hai") {
            case "hi":
                System.out.println("hi");
                break;
        
            case "hii":
            System.out.println("hii");
                break;
        
            case "Hai":
            System.out.println("hai");
                break;
        
            default:
            System.out.println("break");
                break;
        }

        // add break point and debug the code
        int i=0;
        while(i<10){
            i++;
            System.out.println(i);
        }

        do{
            i--;
            System.out.println(i);
        }while(i!=0);
         

        for (int j=0;j<10;j++){
            System.out.println(i);
        }

        int arr[] = new int[3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int ii : arr) {
            System.out.println(ii);
        }
    }
}
