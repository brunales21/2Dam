import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculadora {
    public static void main(String[] args) {
        //System.out.println(resolve("7/-7x-2/2"));
        Arrays.stream("6x-6+-4/-2".split("-?\\d+")).forEach(a -> System.out.print(a+", "));
        System.out.println();
        Arrays.stream("6x-6+-4/-2".split("[+x/]")).forEach(a -> System.out.print(a+", "));



    }

    public static String resolve(String operacion) {
        if (operacion.startsWith("")) {
            operacion = new StringBuilder(operacion).insert(0, "0").toString();
        }
        String [] dm = operacion.split("[+-]");
        List<String> dimu = new ArrayList<>(Arrays.asList(dm));
        System.out.println(dimu);
        dimu = dimu.stream().map(o -> String.valueOf(resolveMultDiv(o))).collect(Collectors.toList());

        String [] sr = operacion.split("[^\\+\\-]");
        List<String> sure = new ArrayList<>(Arrays.asList(sr));
        sure.removeIf(String::isEmpty);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimu.size(); i++) {
            sb.append(dimu.get(i));
            if (i != dimu.size()-1) {
                sb.append(sure.get(i));
            }
        }

        return String.valueOf(resolveMultDiv(sb.toString()));
    }

    public static double resolveMultDiv(String operation) {
        String[] auxNums = operation.split("[x/+-]");
        String [] auxSimbs = operation.split("[0-9.]+");

        List<Double> nums = Arrays.stream(auxNums).map(Double::parseDouble).collect(Collectors.toList());
        List<String> simbs = new ArrayList<>(List.of(auxSimbs));
        simbs.removeIf(String::isEmpty);

        double result = nums.get(0);
        boolean end = false;
        do {
            if (simbs.size() == 0) {
                break;
            }
            for (int i = 0; i < simbs.size(); i++) {
                double currentNum = nums.get(0);
                double nxtNum = nums.get(1);
                if (simbs.get(i).equals("x")) {
                    result = currentNum*nxtNum;
                } else if (simbs.get(i).equals("/")) {
                    result = currentNum/nxtNum;
                } else if (simbs.get(i).equals("+")) {
                    result = currentNum+nxtNum;
                } else if (simbs.get(i).equals("-")) {
                    result = currentNum-nxtNum;
                }
                nums.remove(currentNum);
                nums.remove(nxtNum);
                nums.add(0, result);
                if (nums.size() == 1) {
                    end = true;
                    break;
                }
            }
        } while (!end);
        return result;
    }

    public static boolean isFloatNum(String s) {
        return "1234567890.".contains(s);
    }

    public static boolean isSimbolo(char c) {
        return "x+-/".indexOf(c) != -1;
    }

    public static void resolver(String operacion) {
        String [] ns = operacion.split("[/\\+\\-x]");
        String [] ss = operacion.split("\\d+");

        List<String> nums = new ArrayList<>();
        List<String> signos = new ArrayList<>();

        nums.addAll(Arrays.asList(ns));
        signos.addAll(Arrays.asList(ss));

        signos.remove(0);



        do {
            int i = signos.indexOf("x");
            int i2 = signos.indexOf("/");
            if (i != -1 && i2 != -1) {
                int index = 0;
                int r = 0;
                if (i<i2) {
                    index = i;
                    r = Integer.parseInt(nums.get(index))*Integer.parseInt(nums.get(index+1));
                } else if (i2<i) {
                    index = i2;
                    r = Integer.parseInt(nums.get(index))/Integer.parseInt(nums.get(index+1));

                }
                signos.remove(index+1);
                nums.set(index, String.valueOf(r));
                nums.remove(index+1);
            } else {
                for (int index = 0; index < nums.size()-1; index++) {
                    String s = signos.get(index);
                    int a = Integer.parseInt(nums.get(index));
                    int b = Integer.parseInt(nums.get(index+1));
                    int r;
                    if (s.equals("+")) {
                        r = a+b;
                    } else {
                        r = a-b;
                    }
                    signos.remove(index+1);
                    nums.set(index, String.valueOf(r));
                    nums.remove(index+1);
                }
                break;
            }

        } while (true);
        System.out.println(nums);
    }

    public static int simbsCount(String operation) {
        int contador = 0;
        for (int i = 0; i < operation.length(); i++) {
            if (isSimbolo(operation.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    public static String getDecPart(String num) {
        boolean isDecPart = false;
        StringBuilder decPart = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '.') {
                isDecPart = true;
                continue;
            }
            if (isDecPart) {
                decPart.append(num.charAt(i));
            }
        }
        return decPart.toString();
    }


}
