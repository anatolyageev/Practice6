package ua.nure.ageev.practice6.part6;

public class Part6 {
  //  private String filePath;

    public  Part6() {
    }

    public static void main(String[] args) {
        new Part6().consoleParam(args[0], args[1], args[2], args[3]);

        //     Part61 p61 = new Part61(filePath);
        //      Part61 p62 = new Part62(filePath);
        //     Part61 p63 = new Part63(filePath);
        //       p61.fillMap(filePath);
//p62.fillMap(filePath);
//p63.fillMap(filePath);

//        System.out.println("~~~~~~~~~~~~Part6");
//        Part6.main(new String[]{
//                "--input", "part6.txt", "--task", "frequency"
//        });
//        Part6.main(new String[]{
//                "--input", "part6.txt", "--task", "length"
//        });
//        Part6.main(new String[]{
//                "--input", "part6.txt", "--task", "duplicates"
//        });
    }

    private void consoleParam(String input, String filePath, String task, String option) {
        if (!(input.equals("-i") || input.equals("--input"))) {
            throw new IllegalArgumentException("Parameters not valid!");
        }
        if (!(task.equals("-t") || task.equals("--task"))) {
            throw new IllegalArgumentException("Parameters not valid!");
        }
        switch (option) {
            case "frequency":
                new Part61(filePath).fillMap();
                break;
            case "length":
                new Part62(filePath).fillMap();
                break;
            case "duplicates":
                new Part63(filePath).fillMap();
                break;
        }

    }
}
