package functions;

import java.util.Scanner;

public class DataCaptionV2 {
    String data;
    private static final Scanner SCANNER = new Scanner(System.in);
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String CaptionString(String message){
        System.out.print(message);
        this.setData(SCANNER.nextLine());
        return this.getData();
    }
    }

