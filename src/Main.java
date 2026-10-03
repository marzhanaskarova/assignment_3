public class Main {

    public static void main(String[] args) {

        if (args.length == 0 || !args[0].equals("--demo")) {
            System.out.println("Use: java -cp out Main --demo");
            return;
        }

        // T1: Circle + VectorRenderer
        Circle circle1 = new Circle(
                "C1",
                2,
                new VectorRenderer()
        );

        String result1 = circle1.execute();
        String expected1 = "VECTOR circle radius=2";

        printResult(
                "T1",
                "Circle + VectorRenderer",
                result1,
                expected1
        );


        // T2: Circle + RasterRenderer
        Circle circle2 = new Circle(
                "C2",
                2,
                new RasterRenderer()
        );

        String result2 = circle2.execute();
        String expected2 = "RASTER circle radius=2";

        printResult(
                "T2",
                "Circle + RasterRenderer",
                result2,
                expected2
        );


        // T3: Square + VectorRenderer
        Square square1 = new Square(
                "S1",
                3,
                new VectorRenderer()
        );

        String result3 = square1.execute();
        String expected3 = "VECTOR square side=3";

        printResult(
                "T3",
                "Square + VectorRenderer",
                result3,
                expected3
        );


        // T4: Square + RasterRenderer
        Square square2 = new Square(
                "S2",
                3,
                new RasterRenderer()
        );

        String result4 = square2.execute();
        String expected4 = "RASTER square side=3";

        printResult(
                "T4",
                "Square + RasterRenderer",
                result4,
                expected4
        );


        // T5: Runtime implementation switch
        Circle circle5 = new Circle(
                "C5",
                2,
                new VectorRenderer()
        );

        Circle originalReference = circle5;

        String before = circle5.execute();

        circle5.setImplementation(new RasterRenderer());

        String after = circle5.execute();

        boolean sameObject = originalReference == circle5;

        boolean stateUnchanged =
                circle5.getId().equals("C5");

        boolean pass =
                sameObject
                        && stateUnchanged
                        && before.equals("VECTOR circle radius=2")
                        && after.equals("RASTER circle radius=2");

        if (pass) {
            System.out.println(
                    "T5 PASS | sameObject=" + sameObject
                            + " | stateUnchanged=" + stateUnchanged
                            + " | before=" + before
                            + " | after=" + after
            );
        } else {
            System.out.println(
                    "T5 FAIL | expected same object and implementation switch"
            );
        }

        System.out.println("SUMMARY: T1-T5 completed");
    }


    private static void printResult(
            String testId,
            String classes,
            String actual,
            String expected
    ) {

        if (actual.equals(expected)) {
            System.out.println(
                    testId + " PASS | "
                            + classes
                            + " | result=" + actual
            );
        } else {
            System.out.println(
                    testId + " FAIL | "
                            + classes
                            + " | actual=" + actual
                            + " | expected=" + expected
            );
        }
    }
}